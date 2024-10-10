<template>
  <div class="recipe-search-container">
    <div class="results-area" v-if="recipes.length">
      <h2>Search Results</h2>
      <ul class="recipe-list">
        <li v-for="recipe in recipes" :key="recipe.uri" class="recipe-item">
          {{ recipe.label }}
          <img class="recipe-thumbnail" :src="recipe.image" alt="recipe icon" />
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
          console.log(response.data);
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
  max-width: 1600px;
  margin: 0 auto;
  background: lightblue;
  margin-top: 100px;
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
  background-color: #4caf50;
  color: white;
  border: none;
  cursor: pointer;
}

.results-area {
  margin-top: 75px;
  width: 100%;
}

.recipe-list {
  list-style-type: none;
  padding: 0;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  /* grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); */
  gap: 20px;
}

.recipe-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  background-color: #f9f9f9;
  height: 100%;
  width: 100%;
  box-sizing: border-box;
}
.recipe-thumbnail {
  border-radius: 15px;
  height: 80px;
  width: 80px;
}
</style>
