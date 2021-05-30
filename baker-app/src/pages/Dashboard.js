import React from "react";
import '../Styles/Pages_styles/Dashboard.css'
import {createOrderData, createPieData, createTestUsers } from "../constants/testData";
import {useParams} from "react-router";


const Dashboard = () => {


    const { id } = useParams()

        const users = createTestUsers(20);
        const orders = createOrderData(20);
        const pie = createPieData(1);





  return(
      <>
          <div className='dashboard'>
          <h6>Alle Gebruikers:</h6>
      <table className="table">
        <thead>
        <th>Voornaam</th>
        <th>Achternaam</th>
        <th>Email</th>
        <th>Adres</th>
        <th>Postcode</th>
        <th>provincie</th>
        </thead>
        <tbody>
            {
                users.map(user =>
                    <tr key={user.id}>
                        <td>{user.firstName}</td>
                        <td>{user.lastName}</td>
                        <td>{user.email}</td>
                        <td>{user.streetName} {user.houseNumber} {user.houseNumberAdd}</td>
                        <td>{user.postalCode}</td>
                        <td>{user.province}</td>
                    </tr>


                )
            }
        </tbody>
      </table>
          <h6>Alle Orders:</h6>
    <table className="table">
        <thead>
        <th>Besteldatum</th>
        <th>bezorgdatum</th>
        <th>Soort taart</th>

        </thead>
        <tbody>
        {
            orders.map(order =>
                <tr key={order.id}>

                    <td>{new Date(order.orderDate).toLocaleDateString()}</td>
                    <td>{new Date(order.deliverDate).toLocaleDateString()}</td>
                    <td>{order.notes}</td>



                </tr>


            )
        }
        </tbody>
    </table>
      </div>
</>







);


}
export default Dashboard;
