import {useForm} from "react-hook-form";
import React, {useState} from "react";
import {User} from "../models/User";
import {Button} from "../Components/button/Button";
import "../Styles/Component_styles/Forms.css"



export const EditRegisterForm = () => {
    const [checkedTerms, toggleCheckedTerms] = useState(false);
    const {register: userRegister, handleSubmit: handleUserRegisterSubmit} = useForm();

    // Made some general forms with styling, so they are easily reusable.

    const onRegisterSubmit = async (data) => {
        const user = new User(
            undefined,
            data.firstName,
            data.lastName,
            data.email,
            data.phoneNumber,
            data.username,
            data.password,
            data.streetName,
            data.houseNumber,
            data.houseNumberAdd,
            data.postalCode,
            data.province,

        );

        console.log(user);





    }

    return (
        <div className="register-page">
            <div className="register-form-container">
                <h1>Schrijf je nu in!<span>Schrijf je in en bestel snel je taart!</span></h1>
                <form onSubmit={handleUserRegisterSubmit(onRegisterSubmit)}>
                    <div className="section"><span>1</span>Voor & Achternaam</div>
                    <div className='inner-wrap'>
                        <label>Voornaam<input {...userRegister("firstName")}/></label>
                        <label> Achternaam<input {...userRegister("lastName")} /></label>
                    </div>
                    <div className="section"><span>2</span>Email, Username & Password</div>
                    <div className="inner-wrap">
                        <label>Email<input {...userRegister("email")} type="email"/></label>
                        <label>Gebruikersnaam<input {...userRegister("username")}/></label>
                        <label>TelefoonNummer<input required={true} type='text' {...userRegister("phoneNumber")}/></label>
                        <label>Wachtwoord<input {...userRegister("password")} type="password"/></label>
                    </div>
                    <div className="section"><span>3</span>Adresgegevens</div>
                    <div className='inner-wrap'>
                        <label>Straatnaam<input {...userRegister("address.streetName")}/></label>
                        <label>HuisNummer<input {...userRegister("address.houseNumber")} type="int"/></label>
                        <label>Toevoeging<input {...userRegister("address.houseNumberAdd")}/></label>
                        <label>Postcode<input {...userRegister("address.postalCode")} type="zipcode"/></label>
                        <label>Provincie<input {...userRegister("address.province")}/></label>
                    </div>
                    <Button color='primary'  type="submit">Update Gegevens</Button>
                    <div className='delete-checkbox'>
                    <input
                        type="checkbox" name="delete-check" id="delete-check" checked={checkedTerms} onChange={() => toggleCheckedTerms(!checkedTerms)}/>
                        Weet je zeker dat je jouw account wilt verwijderen?
                </div>
                    <Button color='secondary'>Verwijder account</Button>
                </form>
            </div>
        </div>
    );
}