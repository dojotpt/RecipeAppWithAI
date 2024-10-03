<template>
  <div>
    <h1>Recipe Search</h1>
    <input v-model="query" placeholder="Enter a recipe" />
    <ul v-if="recipes.length">
      <li v-for="recipe in recipes" :key="recipe.uri">
        {{ recipe.label }}
      </li>
    </ul>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";

export default {
  data() {
    return {
      query: "",
      recipes: [],
    };
  },
  methods: {
    searchRecipes() {
      RecipeService.searchRecipes(this.query)
        .then((response) => {
          this.recipes = response.data.hits.map((hit) => hit.recipe);
        })
        .catch((error) => {
          console.log("There was an error fetching recipes:", error);
        });
    },
  },
};
</script>

<style scoped>
</style>