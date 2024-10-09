<template>
  <div id="entire-page-container">
    <div id="header-container">
    <header>
  <div id="nav">
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
  </div>
  <div id="search">
    <recipe-search />
  </div>
  <div id="title">Cookin' with Java</div>
  <div id="user-actions">
    <button>logout</button>
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout
    </router-link> 
  </div>
</header>
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

<style>
#entire-page-container {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
header {
  display:flex;
}
#header-container {
  display: grid;
  grid-template-columns: auto 1fr auto auto;
  grid-template-areas: "nav search title user-actions";
  align-items: center;
  background-color: #F5F5DC;
  padding: .25% .25% 0 .25%;
  border-bottom: 2px solid black;
  height: 13vh;
}
#nav { 
  grid-area: nav;
  justify-self: start; 
}
#search { 
  grid-area: search; 
}
#title { 
  grid-area: title;
  font-size: 58px;

}
#user-actions { 
  grid-area: user-actions; 
  }
</style>
