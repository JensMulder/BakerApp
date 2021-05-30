import React from "react";
import { useAuthState } from "../Components/context/AuthContext";
import { Redirect, Route } from "react-router-dom";

function PrivateRoute({ children, ...rest }) {
    const { isAuthenticated } = useAuthState();

    return (
        <Route {...rest} render={() => {
            return isAuthenticated ? children : <Redirect to="/login" />
        }}/>
    );
}

export default PrivateRoute;