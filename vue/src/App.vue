<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <recipe-search />
    </div>
    <router-view />
  </div>
</template>

<script>
import RecipeSearch from "./components/RecipeSearch.vue";
export default {
  components: {
    RecipeSearch,
  },
};
</script>
