<template>
  <div id="recipe-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      |
      <router-link v-bind:to="{ name: 'search' }">Search Recipes</router-link>
      <recipe-search />
    </div>
    <router-view />
  </div>
</template>

<script>
</script>

<style>
#recipe-app {
  width: 600px;
  background: lightblue;
  margin: 75px auto;
  padding-bottom: 10px;
  font-family: "Montserrat", sans-serif;
  border-radius: 5px;
}
#nav {
  text-align: center;
}
</style>
