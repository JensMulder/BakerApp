import {useForm} from "react-hook-form";
import {Order} from "../models/Order";
import {size} from "../constants/Constants";
import React, {useEffect, useState} from "react";
import {Pie} from "../models/Pie";
import {useAuthState} from "../Components/context/AuthContext";
import "../Styles/Component_styles/Forms.css"
import {Button} from "../Components/button/Button";
import { useHistory } from "react-router-dom";

export const OrderForm = () => {
    const history = useHistory();
    const [fileUrl, setFileUrl] = useState();
    const [pies, setPies] = useState([]);

    // Made some general forms with styling, so they are easily reusable.

    const { register: orderRegister, handleSubmit: handleOrderSubmit } = useForm({

        defaultValues: {

        }
    });

    useEffect(() => {

        let dataFromApi = [
            new Pie(1, "Ronde slagroomtaart", "lekker rond", 3.00),
            new Pie(2, "vierkante slagroomtaart", "lekker vierkant", 2.00)
        ]

        setPies(dataFromApi);
    }, []);

    const onOrderSubmit = (data) => {
        const order = new Order(
            undefined,
            undefined,
            data.deliverDate,
            data.img,
            data.size,
            data.notes,
            data.pie.id
        );

        console.log(order);
    }

    return (
        <div className="register-page">
            <div className="register-form-container">
                <h1>Bestel nu!<span>Bestel hier je taart op maat!</span></h1>


            <form onSubmit={handleOrderSubmit(onOrderSubmit)}>
                <div className="section"><span>1</span>Bezorgdatum & Grootte</div>
                <div className='inner-wrap'>
                <label><input required={true} {...orderRegister("deliverDate")} type="date" /></label>
                <label><select required={true} {...orderRegister("size")}>
                    {
                        Object.keys(size)
                            .map(s =>
                                <option value={s}>
                                    {s} (Voor {size[s].people} mensen) ({size[s].price} euro)
                                </option>
                            )
                    }
                </select></label>
                </div>
                <div className="section"><span>2</span>Kies een foto</div>
                <div className='inner-wrap'>
                {fileUrl && <img src={fileUrl} alt="image" />}
                <label><input required={true} {...orderRegister("img")} onChange={(e) => {
                    window.URL.revokeObjectURL(fileUrl);
                    setFileUrl(window.URL.createObjectURL(e.target.files[0]));
                }} type="file" multiple={false} /></label>
                </div>
                <div className="section"><span>3</span>Opmerkingen & soort taart</div>
                <div className='inner-wrap'>
                <label><textarea required={true} {...orderRegister("notes")} rows={3} /></label>
                <label><select required={true} {...orderRegister("pie")}>
                    {
                        pies.map(pie =>
                            <option value={pie.id}>
                                {pie.name} ({pie.price})
                            </option>
                        )
                    }

                </select></label>
                </div>
                <div style={{ margin: '5px', alignItems: 'center', justifyContent: 'space-around' }}>
                    <Button color='primary' type="submit">Submit</Button>
                    <Button color='secondary' onClick={() => {history.push('/')}}>Cancel</Button>
                </div>
            </form>
        </div>
        </div>
    );
}