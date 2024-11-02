<template>
    <div class="recipe-container">
      <div class="recipe-card">
        <h1>{{ recipe.label }}</h1>
        <div class="recipe-details">
          <img :src="recipe.image" alt="Recipe Image">
          <p>Instructions: {{ recipe.url }}</p>
          <p>Calories: {{ recipe.calories }}</p>
        </div>

        <h2> Ingredients: </h2>
        <ul>
          <li v-for="ingredient in recipe.ingredients" :key="ingredient">
            {{ ingredient }}
          </li>
        </ul>

        <!-- <h2>Diet Labels:</h2>
        <ul>
          <li v-for="label in recipe.dietLabels" :key="diet">
            {{ diet }}
          </li>
        </ul>

        <h2>Health Labels:</h2>
        <ul>
          <li v-for="label in recipe.healthLabels" :key="health">
            {{ health }}
          </li>
        </ul> -->

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

<style scoped>
.recipe-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;
  max-width: 100rem;
  margin: 0 auto;
  background: rgba(154, 208, 229, .5);
  margin-top: calc(22vh + 2rem);
  padding: 2rem;

.recipe-card {
  margin-top: 4.68rem;
  width: 100%;
}

.ingredient-list {
  list-style-type: none;
  padding: 0;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 1.25rem;
}

.recipe-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border: .07rem solid #ddd;
  border-radius: .5rem;
  padding: 1rem;
  background-color: #f9f9f9;
  height: 100%;
  width: 100%;
  box-sizing: border-box;
}
.ingredient-thumbnail {
  border-radius: 1rem;
  height: 5rem;
  width: 5rem;
}
@media (max-width: 26em) {

}
@media (max-width: 48em) {
  .recipe-container {
    margin-top: calc(25vh + 2rem);
    padding: clamp(.5rem, 2vh, 1.5rem);
  }

  .recipe-card {
    margin-top: 1rem;
  }
}
}

@media (max-width: 64em) {
  .recipe-container {
    padding: 1.5rem;
  }
}

@media (max-width: 90em) {
.recipe-container {
  display: flex;
  flex-direction: column;
  align-items: center;margin-top: calc(18vh + 2rem);
  max-width: 85rem;
  padding: 1.5rem;
}

  .recipe-card {
    margin-top: calc(16.5vh + 1.5rem);
  }
}
</style>


