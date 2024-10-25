import axios from "axios";

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
}
