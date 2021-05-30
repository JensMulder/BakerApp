import React from 'react';
import '../../Styles/Component_styles/Cards.css';
import CardItem from './CardItem';
import OverOns from '../../images/Over ons afbeelding.jpg'
import Contact from '../../images/contact afbeelding.jpg'
import Foto1 from '../../images/img.png'
import Foto2 from '../../images/img_2.png'
import Foto3 from '../../images/img_1.png'

function Cards() {
    // Using the card item in order to create a landing page design
    return (
        <div className='cards'>
            <h1>Het geheim achter onze heerlijke producten</h1>
            <div className='cards__container'>
                <div className='cards__wrapper'>
                    <ul className='cards__items'>
                        <CardItem
                            src={OverOns}
                            text='Kijk wie wij zijn en wat we doen'
                            label='Over ons'
                            path='/AboutPage'
                        />
                        <CardItem
                            src={Contact}
                            text='Neem contact met ons op en stel al je vragen'
                            label='Neem contact op'
                            path='/Contact'
                        />
                    </ul>
                    <ul className='cards__items'>
                        <CardItem
                            src={Foto1}
                            text='Kies een foto met betekenis'
                            label='Gefelicitaart'
                            path='/CreateOrder'
                        />
                        <CardItem
                            src={Foto2}
                            text='Kies zelf hoe jouw taart eruit ziet'
                            label='Alles op maat'
                            path='/CreateOrder'
                        />
                        <CardItem
                            src={Foto3}
                            text='Laat hem de volgende dag nog bezorgen'
                            label='De snelste levering'
                            path='/CreateOrder'
                        />
                    </ul>
                </div>
            </div>
        </div>
    );
}

export default Cards;