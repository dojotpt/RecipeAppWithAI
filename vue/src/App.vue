<template>
  <div id="entire-page-container">
    <div id="header-container"></div>
    <header>
      <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
      </div>
      <div id="search">
        <input v-model="query" placeholder="Enter a recipe" />

        <router-link :to="`/search`">
          <button @click="searchRecipes">Find a Recipe</button>
        </router-link>

        <ul v-if="recipes.length">
          <li v-for="recipe in recipes" :key="recipe.uri">
            {{ recipe.label }}
          </li>
        </ul>
      </div>
      <div id="title">Cookin' with Java</div>
      <div id="user-actions">
        <button>logout</button>
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </div>
    </header>
  </div>
  <router-view />
</template>


<script>
import RecipeService from "./services/RecipeService";

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

<style>
#entire-page-container {
  /* min-height: 100vh; */
  display: flex;
  flex-direction: column;
}
header {
  position: fixed;
  display: grid;
  grid-template-columns: auto 1fr auto 1fr auto;
  grid-template-areas: "nav search title social-media user-actions";
  width: 100vw;
  padding-right: 100px;
  padding-left: 100px;
  align-items: center;
  background-color: #f5f5dc;
  border-bottom: 2px solid black;
  height: 13vh;
}
#nav {
  grid-area: nav;
  justify-self: center;
}
#search {
  grid-area: search;
  justify-self: center;
}
#title {
  grid-area: title;
  font-size: 58px;
  text-align: center;
  justify-self: center;
}
#user-actions {
  grid-area: user-actions;
  justify-self: flex-end;
}
#social-media {
  grid-area: social-media;
  justify-self: center;
}
</style>
