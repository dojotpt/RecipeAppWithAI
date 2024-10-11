<template>
  <div id="entire-page-container">
    <header>
      <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
      </div>
      <div id="search">
        <input v-model="headerQuery" placeholder="Enter a recipe" />
          <button @click.prevent="handleSearch">Find a Recipe</button>
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

export default {
  data() {
    return {
      headerQuery: "",
    };
  },
  methods: {
    async handleSearch() {
      if (this.headerQuery.trim()) {
        try {
          await this.$router.push({ name: 'search', query: { q: this.headerQuery } });
        this.headerQuery = "";
      } catch (e) {
        console.error("Error searching for recipes:", e);
      }
    }
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
