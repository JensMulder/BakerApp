import {useForm} from "react-hook-form";
import React, {useEffect,} from "react";
import {User} from "../models/User";
import {Button} from "../Components/button/Button";
import "../Styles/Component_styles/Forms.css"
import axios from "axios";
import {useAuthState} from "../Components/context/AuthContext"
import authClient from "../clients/authClient";


export const RegisterForm = () => {
    const {register: userRegister, handleSubmit: handleUserRegisterSubmit} = useForm();

    // Made some general forms with styling, so they are easily reusable.

    const onRegisterSubmit = async (data) => {
        const user = new User(
            undefined,
            data.firstName,
            data.lastName,
            data.email,
            data.username,
            data.phoneNumber,
            data.password,
            data.streetName,
            data.houseNumber,
            data.houseNumberAdd,
            data.postalCode,
            data.province,
        );

        console.log(user);

        const response = await authClient.register(data.firstName, data.lastName, data.email,data.username, data.password, data.streetName, data.houseNumber, data.houseNumberAdd, data.postalCode, data.province);







    }

    return (
        <div className="register-page">
        <div className="register-form-container">
            <h1>Schrijf je nu in!<span>Schrijf je in en bestel snel je taart!</span></h1>
            <form onSubmit={handleUserRegisterSubmit(onRegisterSubmit)}>
                <div className="section"><span>1</span>Voor & Achternaam</div>
                <div className='inner-wrap'>
                   <label>Voornaam<input required={true} type='text' {...userRegister("firstName")}/></label>
                    <label> Achternaam<input required={true} type='text' {...userRegister("lastName")} /></label>
                </div>
                <div className="section"><span>2</span>Email, Username & Password</div>
                <div className="inner-wrap">
                <label>Email<input required={true} type='email' {...userRegister("email")} type="email"/></label>
                <label>Gebruikersnaam<input required={true} type='text' {...userRegister("username")}/></label>
                    <label>TelefoonNummer<input required={true} type='text' {...userRegister("phoneNumber")}/></label>
                <label>Wachtwoord<input {...userRegister("password")} required={true} type="password"/></label>
                </div>
                <div className="section"><span>3</span>Adresgegevens</div>
                <div className='inner-wrap'>
                    <label>Straatnaam<input required={true} type='text' {...userRegister("address.streetName")}/></label>
                    <label>HuisNummer<input {...userRegister("address.houseNumber")} required={true} type="int"/></label>
                    <label>Toevoeging<input required={false} type='text' {...userRegister("address.houseNumberAdd")}/></label>
                    <label>Postcode<input required={true} {...userRegister("address.postalCode")} type="zipcode"/></label>
                    <label>Provincie<input required={true} type='text' {...userRegister("address.province")}/></label>
                </div>
                <Button color="primary" type="submit">Submit</Button>
                <Button color="secondary">Cancel</Button>
            </form>
        </div>
        </div>
    );
}

