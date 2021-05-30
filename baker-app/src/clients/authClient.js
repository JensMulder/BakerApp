import { ClientBase } from "./clientBase";

class AuthClient extends ClientBase {
    constructor() {
        super()
    }

    async login(username, password) {
        const response = this.client.post('/auth/login', { username: username, password: password });

        console.log(response);
        return response;
    }

    async register(user) {
        const response = this.client.post('/auth/register', user);

        console.log(response);
        return response;
    }

    async getUserInfo() {
        const response = this.client.get('/auth/login');

        console.log(response);
        return response;
    }
}

export default new AuthClient();