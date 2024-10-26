<template>
  <div class="recipe-search-container">
    <div class="results-area" v-if="recipes.length">
      <h2>Search Results</h2>
      <ul class="recipe-list"> 
        <li v-for="recipe in recipes" :key="recipe.uri" class="recipe-item">
          <router-link :to="{ name: 'recipes', params: { id: recipe.uri.split('#recipe_')[1] }}">
          {{ recipe.label }}
          <img class="recipe-thumbnail" :src="recipe.image" alt="recipe icon" />
        </router-link>
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
      user: "",
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
    searchFromHeaderQuery() {
      const queryParam = this.$route.query.q;
      if (queryParam) {
        this.query = queryParam;
        this.searchRecipes();
      }
    }
  },
  mounted() {
    this.searchFromHeaderQuery();
  },
  watch: {
    "$route.query.q": {
      handler(query) {
        this.searchFromHeaderQuery();
      },
      immediate: true
    }
  }
};
</script>
  
  <style scoped>
  .recipe-search-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;
  max-width: 100rem;
  margin: 0 auto;
  background: rgba(154, 208, 229, .5);
  margin-top: 10.5rem;
}

.search-area {
  width: 100%;
  display: flex;
  justify-content: center;
  margin-bottom: 1.8rem;
}

.search-area input {
  width: 60%;
  padding: .6rem;
  font-size: 1rem;
}

.search-area button {
  padding: .6rem 1.3rem;
  font-size: 1rem;
  background-color: #4caf50;
  color: white;
  border: none;
  cursor: pointer;
}

.results-area {
  margin-top: 4.68rem;
  width: 100%;
}

.recipe-list {
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
.recipe-thumbnail {
  border-radius: 1rem;
  height: 5rem;
  width: 5rem;
}
  </style>