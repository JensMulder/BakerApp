import React, { Component, useState, useContext, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../images/unnamed.png";
import { AuthContext, useAuthState } from "../context/AuthContext";
import "../../Styles/Component_styles/navbar.css";

function NavBar() {
  const [click, setClick] = useState(false);
  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);
  const { logout } = useContext(AuthContext);
  const { isAuthenticated } = useAuthState();
  const history = useHistory();



  return (
      <>
        <nav className='navbar'>
          <div className='navbar-container'>
            <Link to='/' className='navbar-logo' onClick={closeMobileMenu}>
             <img src={Logo}/>
            </Link>
            <div className='menu-icon' onClick={handleClick}>
              <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
            </div>
            <ul className={click ? 'nav-menu active' : 'nav-menu'}>
              <li className='nav-item'>
                <Link to='/' className='nav-links' onClick={closeMobileMenu}>
                  Home
                </Link>
              </li>
              <li className='nav-item'>
                <Link
                    to='/contact'
                    className='nav-links'
                    onClick={closeMobileMenu}
                >
                  Contact
                </Link>
              </li>
              <li className='nav-item'>
                <Link
                    to='/about'
                    className='nav-links'
                    onClick={closeMobileMenu}
                >
                  Over ons
                </Link>
              </li>
              <li className='nav-item'>
                <Link
                    to='/CreateOrder'
                    className='nav-links'
                    onClick={closeMobileMenu}
                >
                  Bestellen
                </Link>
              </li>
              <li>

                {isAuthenticated ? (
                    <Link
                        to='/'
                        className='nav-links'
                        onClick={() => logout()}
                    >
                      Logout
                    </Link>

                ) : (
                    <Link
                        to='/login'
                        className='nav-links'
                        onClick={() => {history.push('/login')}}
                    >
                      Login
                    </Link>
                )}
              </li>

            <li>

                  <Link
                      to='/account'
                      className='nav-links'
                      onClick={closeMobileMenu}
                  >
                    Mijn Account
                  </Link>


            </li>
            </ul>

          </div>
        </nav>
      </>
  );
}

export default NavBar;
