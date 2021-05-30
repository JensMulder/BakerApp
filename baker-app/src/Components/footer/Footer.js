import React from 'react';
import '../../Styles/Component_styles/Footer.css';
import { Button } from '../button/Button';
import { Link } from 'react-router-dom';

function Footer() {
    // The footer provides us with some links and a subscribe button. there are also links to the social media.
    return (
        <div className='footer-container'>
            <section className='footer-subscription'>
                <p className='footer-subscription-heading'>
                    Krijg nu de Boender Nieuwsbrief
                </p>
                <p className='footer-subscription-text'>
                    Van alles op de hoogte
                </p>
                <div className='input-areas'>
                    <form>
                        <input
                            className='footer-input'
                            name='email'
                            type='email'
                            placeholder='Your Email'
                        />
                        <Button color='primary'>Subscribe</Button>
                    </form>
                </div>
            </section>
            <div className='footer-links'>
                <div className='footer-link-wrapper'>
                    <div className='footer-link-items'>
                        <h2>Meld je aan</h2>
                        <Link to='/Register'>Registreer</Link>
                        <Link to='/Login'>Login</Link>

                    </div>
                    <div className='footer-link-items'>
                        <h2>Over ons</h2>
                        <Link to='/Contact'>Contact</Link>
                        <Link to='/About'>Over Ons</Link>
                    </div>
                </div>
                <div className='footer-link-wrapper'>
                    <div className='footer-link-items'>
                        <h2>De bakkerij</h2>
                        <Link to='/'>Bestellen</Link>
                        <Link to='/'>Boender</Link>
                    </div>
                </div>


            </div>
            <section className='social-media'>
                <div className='social-media-wrap'>

                    <small className='website-rights'>Bakkerij Boender © 2021</small>
                    <div className='social-icons'>
                        <Link
                            class='social-icon-link facebook'
                            to="https://www.facebook.com/bakkerijboender/"
                            target='_blank'
                            aria-label='Facebook'
                        >
                            <i className='fab fa-facebook-f' />
                        </Link>
                        <Link
                            class='social-icon-link instagram'
                            to="https://www.instagram.com/bakkerijboender"
                            target='_blank'
                            aria-label='Instagram'
                        >
                            <i className='fab fa-instagram' />
                        </Link>
                        <Link
                            class='social-icon-link youtube'
                            to="https://www.youtube.com/channel/UCpJw2H9KKqwCCGQKRh1Bf2w"
                            target='_blank'
                            aria-label='Youtube'
                        >
                            <i className='fab fa-youtube' />
                        </Link>
                        <Link
                            class='social-icon-link twitter'
                            to="https://www.twitter.com/bakkerijboender"
                            target='_blank'
                            aria-label='Twitter'
                        >
                            <i className='fab fa-twitter' />
                        </Link>
                    </div>
                </div>




            </section>
        </div>

    );
}

export default Footer;