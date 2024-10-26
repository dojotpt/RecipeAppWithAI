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
    const recipeId = this.$route.params.id;
    RecipeService.getRecipeById(recipeId).then((response) => {
      console.log(response.data);
        this.recipe = response.data.recipe;
    })
  },
}
  </script>

