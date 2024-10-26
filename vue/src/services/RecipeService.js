import axios from "axios";
const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API
});


export default {
    searchRecipes(query) {
        console.log(query)

        const ingredients = query.split(/,\s*|\s+/);
        const formattedQuery = ingredients.join(',');
        console.log(formattedQuery);

        return axios.get(`/recipes`, {
            params: {
                query: formattedQuery
            }
        });
    },
    getRecipeById(recipeId){
        return http.get(`/recipes/${recipeId}`);
    }
}
