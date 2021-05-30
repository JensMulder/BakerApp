import {User} from "../models/User";
import {Order} from "../models/Order";
import moment from "moment";
import {Pie} from "../models/Pie";
import {size} from "./Constants";

export const createTestUsers = (userAmount) => {
    let users = [];

    for (let i = 0; i < userAmount; i++) {
        users.push(new User(
            1,
            `TestUser${i}`,
            `Test${i}`,
            `user${i}@user.nl`,
            `test${i}`,
            undefined,
            `baltezarschans`,
            `${i}`,
            `A`,
            `6969KK`,
            `Zuid-Holland`

            )
        )
    }

    return users;
}

export const createPieData = (pieAmount) => {
    let pie = [];
    for (let i = 0; i < pieAmount; i++) {
        pie.push(new Pie(
            0,
            "vierkante slagroomtaart",
            "lekker vierkant",
            2.00
            )
        )
    }
    return pie;

}



export const createOrderData = (orderAmount) => {
    let orders = []

    for (let i = 0; i < orderAmount; i++) {
        orders.push(
            new Order(
                i,
                moment(new Date()).add(i, 'd'),
                moment(new Date()).add(i + 5, 'd'),
                undefined,
                size.M,
                "bliebloenbla",
                new Pie(1),
            new User(i)
        ))
    }

    return orders;
}

export const testData = {
    users: createTestUsers(20),
    orders: createOrderData(20),
    pie: createPieData(1)

}