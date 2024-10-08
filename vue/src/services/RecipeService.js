import axios from "axios";

export default {
    searchRecipes(query) {
        console.log(query)
        return axios.get(`/recipes`, {
            params: {
                query: query
            }
        });
    },
}
