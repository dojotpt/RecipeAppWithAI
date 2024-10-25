<template>
    <div class="recipe-container">
      <div class="recipe-card">
        <img class="recipe-image" :src="recipe.image" alt="picture of recipe"/>
      </div>
    </div>
  </template>
  
  <script>
import RecipeService from '../services/RecipeService';

export default {
  data(){
    return {
      recipe: {}
    }
  },
  created(){
    const recipeUri = this.$route.params.uri;
    RecipeService.getRecipe(recipeUri).then((response) => {
      console.log(response.data);
      if (response.data.hits && response.data.hits.length > 0) {
        this.recipe = response.data.hits[0].recipe;
      }  else if (response.data.recipe) {
        this.recipe = response.data.recipe;
      }
      console.log('Recipe data:', this.recipe);
    })
  },
}

  </script>

