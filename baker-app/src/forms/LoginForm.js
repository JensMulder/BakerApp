import {useForm} from "react-hook-form";
import React, {useContext, useEffect,} from "react";
import {User} from "../models/User";
import {Button} from "../Components/button/Button";
import {useHistory} from "react-router-dom";
import authClient from '../clients/authClient'
import {useAuthState} from "../Components/context/AuthContext";

import {Link} from "react-router-dom";


export const LoginForm = () => {

    // Made some general forms with styling, so they are easily reusable.

    const history = useHistory();
    const { isAuthenticated, isAdmin, login } = useAuthState();
    const {register: userLogin, handleSubmit: handleUserLoginSubmit} = useForm();

    useEffect(() => {
        if (isAuthenticated === true) {
            if(isAdmin) {

                history.push('/dashboard');
            } else {

                history.push('/Account');
            }
        }
    }, [isAuthenticated])







    const onRegisterSubmit = async (data) => {
        const user = new User(
            undefined,
            data.username,
            data.password,

        );

        console.log(user);

        const response = await authClient.login(data.username, data.password);

        login(data);
    }



    return (
        <div className="register-page">
            <div className="register-form-container">
                <h1>Login!<span>Meld je hier aan!</span></h1>

            <div className="login-form-container">
                <form onSubmit={handleUserLoginSubmit(onRegisterSubmit)}>
                    <div className="field">
                        <label><input placeholder="Gebruikersnaam" required={true} {...userLogin("firstName")}/></label>

                    </div>
                    <div className="field">
                        <label><input placeholder="Wachtwoord" type='password' required={true} {...userLogin("lastName")} /></label>

                    </div>

                    <div class="field">
                        <Button color="primary" type="submit">Login</Button>
                        </div>
                    <div class="signup-link">
                        Heeft U nog geen account? Klik dan <Link to="/Register" className="link">HIER</Link> om U aan te
                            melden.
                    </div>
                </form>



            </div>
        </div>
            <h4>Happines is Knowing there is a CAKE in the oven, or smacking it into somebodies face...........</h4>
    </div>

);
}
