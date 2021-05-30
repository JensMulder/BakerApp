import React from "react";
import { useHistory} from "react-router-dom";

import {createOrderData, createPieData, createTestUsers} from "../constants/testData";
import  profilePicture  from '../images/profile picture.png'
import '../Styles/Pages_styles/AccountPage.css'
import {Button} from "../Components/button/Button";

function Account() {

  const users = createTestUsers(1);
  const orders = createOrderData(1);
  const pie = createPieData(1);
  const history = useHistory();




  return (
      <div className='Account'>
      <div className='container'>
          <div className='main'>
              <div className='account-top-bar'>


              </div>
              <div className='row'>
                  <div className='col-md-4 mt-1'>
                      <div className='card text-center sidebar'>
                          <div className='card-body'>
                              <img src={profilePicture} className='rounded-circle' width="150"/>
                              <div className='mt-3'>
                                  {
                                      users.map(users =>

                                              <p> {users.firstName} {users.lastName}</p>




                                      )
                                  }
                              </div>


                              </div>





                      </div>

                  </div>
                  <div className='col-md-8 mt-1'>
                      <div className='card mb-3-content'>
                          <h1 className='m-3 pt-3'>Mijn gegevens</h1>
                          <div className='card-body'>
                              <div className='row'>
                                  <div className='col-md-9 text secondary'>
                                      {
                                          users.map(users =>

                                              <p>Naam: {users.firstName} {users.lastName}</p>




                                          )
                                      }
                                  </div>

                              </div>
                              <div className='row'>

                                  <div className='col-md-9 text secondary'>
                                      {
                                          users.map(users =>

                                              <p>Email: {users.email} </p>




                                          )
                                      }
                                  </div>

                              </div>
                              <div className='row'>

                                  <div className='col-md-9 text secondary'>
                                      {
                                          users.map(users =>

                                              <p>GebruikersNaam: {users.username}</p>




                                          )
                                      }
                                  </div>

                              </div>
                              <div className='row'>

                                  <div className='col-md-9 text secondary'>
                                      {
                                          users.map(user =>

                                              <p>Adres:{user.streetName} {user.houseNumber} {user.houseNumberAdd} </p>




                                          )
                                      }
                                  </div>

                              </div>
                              <div className='row'>
                              <div className='col-md-9 text secondary'>
                                  {
                                      users.map(user =>

                                          <p>Postcode: {user.postalCode}</p>




                                      )
                                  }
                              </div>
                                  <Button
                                         type="button"
                                         color='primary'
                                          onClick={() => {
                                           history.push("/edit/user");
                                          }}

                                  >
                                      Update gegevens
                                  </Button>

                          </div>

                          </div>

                      </div>
                      <div className='card mb-3-content'>
                          <h1 className='m-3 pt-3'>Mijn order</h1>
                          <div className='card-body-account'>
                              <div className='account-row'>
                                  <div className='col-md-9 text secondary'>
                                      {
                                          orders.map(order =>

                                              <p>Besteldatum: {new Date(order.orderDate).toLocaleDateString()}</p>




                                          )
                                      }
                                  </div>
                                  <div className='col-md-9 text secondary'>
                                      {
                                          orders.map(order =>

                                              <p>Bezorgdatum: {new Date(order.deliverDate).toLocaleDateString()}</p>




                                          )
                                      }
                                  </div>
                                  <div className='col-md-9 text secondary'>
                                      {
                                          orders.map(order =>

                                              <p>Opmerkingen: {order.notes}</p>




                                          )
                                      }
                                  </div>


                                  <Button
                                      color='primary'

                                      type="button"
                                      onClick={() => history.push('/edit/order')}>
                                      Wijzig of annuleer order</Button>

                              </div>

                          </div>
                      </div>
                  </div>

              </div>
          </div>

      </div>
      </div>


  );
}

export default Account;
