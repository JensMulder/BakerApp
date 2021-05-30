import React from 'react';
import {useParams} from "react-router";
import {createOrderData, createPieData, createTestUsers } from "../constants/testData";





const UserDetailsPage = (props) => {
    const { id } = useParams()

    const users = createTestUsers(20);
    const orders = createOrderData(20);
    const pie = createPieData(1);

}