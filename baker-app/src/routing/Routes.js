import React from 'react';
import { Switch, Route, } from 'react-router-dom';
import AdminPrivateRoute from "./AdminPrivateRoute";
import Login from "../pages/Login";
import AboutPage from "../pages/AboutPage";
import HomePage from "../pages/HomePage";
import ContactPage from "../pages/ContactPage";
import Register from "../pages/Register";
import CreateOrder from "../Components/Createorder/CreateOrder";
import Account from "../pages/Account";
import Dashboard from '../pages/Dashboard'
import {RegisterForm} from "../forms/RegisterForm";
import UpdateOrder from "../Components/edit/EditOrder";
import UpdateUser from "../Components/edit/EditUser";

function Routes() {

    return (
        <>
            <Switch>
                <Route exact path="/login" component={Login} />
                <Route exact path="/about" component={AboutPage} />
                <Route exact path="/" component={HomePage} />
                <Route exact path="/contact" component={ContactPage} />
                <Route exact path="/register" component={Register} />
                <Route exact path="/CreateOrder" component={CreateOrder} />
                <Route path={"/registerForm"} component={RegisterForm} />
                <Route path={'/edit/order'} component={UpdateOrder} />
                <Route path={'/edit/user'} component={UpdateUser} />
                <Route
                    path="/Account" component={Account}>
                </Route>
                <AdminPrivateRoute
                path="/Dashboard" component={Dashboard}
                >
                </AdminPrivateRoute>
                <Route exact path={"/registers"} component={RegisterForm} />


            </Switch>
        </>
    );
}
export default Routes;