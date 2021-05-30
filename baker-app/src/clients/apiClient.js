import { ClientBase } from "./clientBase";

class ApiClient extends ClientBase {
    constructor() {
        super()
    }

    async getPaged(url, pageSize, pageNum) {
        const response = await this.client.get(`${url}?page=${pageNum}&size=${pageSize}`);

        console.log(response);

        return response.data;
    }

    async getById(url, id) {
        const response = await this.client.get(`${url}/${id}`);

        console.log(response);
        
        return response.data;
    }

    async create(url, data) {
        const response = await this.client.post(url, data);

        console.log(response);

        return response.data;
    }

    async update(url, id, data) {
        const response = await this.client.put(`${url}/${id}`, data);

        console.log(response);

        return response.data;
    }

    async delete(url, id) {
        const response = await this.client.delete(`${url}/${id}`);

        console.log(response);

        return response;
    }
}

export default new ApiClient();