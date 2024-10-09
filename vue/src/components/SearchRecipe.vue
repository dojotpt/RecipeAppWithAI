<!-- <template>
  <div class="search-recipe-container">

  <div class="results-container"> 
    <ul v-if="recipes.length">
      <li v-for="recipe in recipes" :key="recipe.uri">
        {{ recipe.label }}
      </li>
    </ul>
  </div>

  <div class="search-recipe">
    <input v-model="query" placeholder="Enter a recipe" />
    <button @click="searchRecipes">Search</button>
  </div>
  </div>

</template> -->

<template>
  <div class="recipe-search-container">
   
    
    <div class="results-area" v-if="recipes.length">
      <h2>Search Results</h2>
      <ul class="recipe-list">
        <li v-for="recipe in recipes" :key="recipe.uri" class="recipe-item">
          {{ recipe.label }}
        </li>
      </ul>
    </div>


    <div class="search-area">
      <input v-model="query" placeholder="Enter a recipe" />
      <button @click="searchRecipes">Search</button>
    </div>
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
.recipe-search-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  max-width: 1200px;
  margin: 0 auto;
  background: lightblue;
}

.search-area {
  width: 100%;
  display: flex;
  justify-content: center;
  margin-bottom: 30px;
}

.search-area input {
  width: 60%;
  padding: 10px;
  font-size: 16px;
}

.search-area button {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}

.results-area {
  width: 100%;
}

.recipe-list {
  list-style-type: none;
  padding: 0;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 20px;
}

.recipe-item {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  background-color: #f9f9f9;
}
</style>

<!-- <style scoped>
.search-recipe-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 85%;
  min-height: 80vh;
  background: lightblue;
  margin: 75px auto;
  padding-bottom: 10px;
  font-family: "Montserrat", sans-serif;
  border-radius: 5px;
}


</style> -->