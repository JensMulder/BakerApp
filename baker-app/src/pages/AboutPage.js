import React from 'react'
import OverOns from '../images/Over ons afbeelding.jpg'
import '../Styles/Pages_styles/AboutPage.css'
import Footer from "../Components/footer/Footer";


function AboutPage () {



    return (
        <>
        <div className="about-page">
            <div className="content-section">
                <div className="content-text">
                    <div className="content-title">
                        <h1>Over ons</h1>
                    </div>
                    <div className="content-info">
                        <h3>Een lekkere taart is heel veel tijd waard</h3>
                        <p>
                            Elke nacht opnieuw bakken onze bakkers de lekkerste producten.
                            Brood en banket om van te genieten. Je proeft de allerbeste grondstoffen die in de producten verwerkt zijn.
                            Maar dat niet alleen, je proeft de aandacht en het gevoel waarmee de producten gemaakt zijn.
                            Kortom, je proeft het vakmanschap en de passie van onze bakkers.

                        </p>
                    </div>
                </div>
                <div className="image-section">
                    <img src={OverOns} />




                </div>
            </div>
        </div>
            <Footer/>


</>
            );
        }
        export default AboutPage








