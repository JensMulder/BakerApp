import {useForm} from "react-hook-form";
import {Order} from "../models/Order";
import {size} from "../constants/Constants";
import React, {useEffect, useState} from "react";
import {Pie} from "../models/Pie";
import "../Styles/Component_styles/Forms.css"
import {Button} from "../Components/button/Button";

export const EditOrderForm = () => {
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

                <button onClick={() => console.log()} />
                <form onSubmit={handleOrderSubmit(onOrderSubmit)}>
                    <div className="section"><span>1</span>Bezorgdatum & Groottte</div>
                    <div className='inner-wrap'>
                        <label><input {...orderRegister("deliverDate")} type="date" /></label>
                        <label><select {...orderRegister("size")}>
                            {
                                Object.keys(size)
                                    .map(s =>
                                        <option value={s}>
                                            {s} (for {size[s].people} people) ({size[s].price})
                                        </option>
                                    )
                            }
                        </select></label>
                    </div>
                    <div className="section"><span>2</span>Kies een foto</div>
                    <div className='inner-wrap'>
                        {fileUrl && <img src={fileUrl} alt="image" />}
                        <label><input {...orderRegister("img")} onChange={(e) => {
                            window.URL.revokeObjectURL(fileUrl);
                            setFileUrl(window.URL.createObjectURL(e.target.files[0]));
                        }} type="file" multiple={false} /></label>
                    </div>
                    <div className="section"><span>3</span>Opmerkingen & soort taart</div>
                    <div className='inner-wrap'>
                        <label><textarea {...orderRegister("notes")} rows={3} /></label>
                        <label><select {...orderRegister("pie")}>
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
                        <Button color='primary' type="submit">Update Order</Button>
                        <Button color='secondary'>Verwijder Order</Button>
                    </div>
                </form>
            </div>
        </div>
    );
}