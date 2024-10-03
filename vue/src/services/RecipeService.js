import axios from "axios";

const API_BASE_URL = 'http://localhost:9000';

export default {
    searchRecipes(query) {
        console.log(query)
        return axios.get(`${API_BASE_URL}/recipes`, {
            params: {
                query: query
            }
        });
    },

}
