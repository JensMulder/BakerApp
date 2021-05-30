import React from 'react';
import '../../Styles/App.css';
import { Button } from '../button/Button';
import '../../Styles/Component_styles/HeroSection.css';
import { useHistory } from "react-router-dom";
import myVideo from '../../videos/myVideo.mp4';

function HeroSection() {
    // The herosection is the first thing you will see on the homepage. The Looped video makes it look more dynamic.


    const history = useHistory();
    return (
        <div className='hero-container'>
            <video controls autoPlay loop muted>
                <source src={myVideo} type="video/mp4"></source>
            </video>
            <h1>TAART OP MAAT</h1>
            <p>Maak jouw verjaardag onvergetelijk</p>
            <div className='hero-btn'>
                <Button
                    color='primary'
                    size='large'
                    onClick={() => {history.push('/CreateOrder')}}
                >
                    Bestel nu
                </Button>
                <Button
                    color='tertiary'
                    size='large'
                    onClick={() => {history.push('/Register')}}
                >
                    Registreer Nu
                </Button>
            </div>
        </div>
    );
}

export default HeroSection;