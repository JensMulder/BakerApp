import React, { createContext, useContext, useState, useEffect } from 'react';
import axios from 'axios';
import authClient from "../../clients/authClient";

const AuthContext = createContext({});

function AuthContextProvider({ children }) {
    //the authenticator provides us with tools to be able to login, logout or define roles

    const [authState, setAuthState] = useState({
        status: 'pending',
        error: null,
        user: null,
    });

    useEffect(() => {
        const token = localStorage.getItem('token');

        async function getUserInfo() {
            try {
                const response = await authClient.getUserInfo();

                setAuthState({
                    ...authState,
                    user: {
                        id: response.data.id,
                        username: response.data.username,
                        email: response.data.email,
                        roles: response.data.roles,


                    },
                    status: 'done',
                });
            } catch (e) {
                setAuthState({
                    ...authState,
                    user: null,
                    error: e,
                    status: 'done'
                });
            }
        }

        if (!authState.user && token) {
            getUserInfo();
        } else {
            setAuthState({
                ...authState,
                error: null,
                user: null,
                status: 'done'
            });
        }

    }, []);

    function login(data) {
        localStorage.setItem('token', data.accessToken);
        setAuthState({
            ...authState,
            user: {
                username: data.username,
                email: data.email,
                roles: data.roles,
                isAdmin: data.roles.includes("ADMIN"),
            }
        })
    }

    function logout() {
        localStorage.clear();
        setAuthState({
            ...authState,
            user: null,
        });
    }

    const providerData = {
        ...authState,
        login,
        logout,
    };

    return(
        <AuthContext.Provider value={providerData}>
            { authState.status === 'done' && children }
            { authState.status === 'pending' && <p>Loading...</p>}
        </AuthContext.Provider>
    );
}

function useAuthState() {
    const authState = useContext(AuthContext);
    const isDone = authState.status === 'done';
    const isAuthenticated = authState.user !== null && isDone;

    return{
        ...authState,
        isAuthenticated: isAuthenticated,
    }
}

export {
    AuthContext,
    AuthContextProvider,
    useAuthState,
}