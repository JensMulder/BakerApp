import axios from 'axios';


export class ClientBase {
    constructor() {


        this.client = axios.create({
            baseURL: process.env.REACT_APP_API_BASE_URL,
            headers: {
                "Access-Control-Allow-Origin": '*',
                "Content-Type": 'application/json'
            }
        })
        
        this.client.interceptors.request.use(config => {
            const token = localStorage.getItem('token');

            config.headers.Authorization =  token ? `Bearer ${token}` : '';

            return config;
        })
        
        this.client.interceptors.response.use(undefined, err => {
            switch (err.response.status) {
                case 401:
                    break;
            }
        });
    }
}