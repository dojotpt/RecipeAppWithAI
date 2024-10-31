<template>
  <div id="entire-page-container">
    <header>
          <div id="title">Cookin' with Java</div>
          <div id="search">
        <input v-model="headerQuery" @keyup.enter="handleSearch" placeholder="Enter a recipe" />
          <button @click.prevent="handleSearch">Find a Recipe</button>
      </div>
      <div class="logo-title-container">
          <div class="logo">
            <img id="logo-img" src="@/images/RecipeAppLogo.png" alt="cartoon chef with binary hat">
          </div>
          </div>
    </header>
    <router-view />
  </div>

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
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
header {
  position: fixed;
  display: flex;
  align-items: center;
  background-image: 
  linear-gradient(rgba(245, 245, 220, 0.3), rgba(245, 245, 220, 0.6)),
  url('/src/images/HeaderBackgrounds/whiteboard.jpg');
  justify-content: space-between;
  padding: 1vh 2vw 1vh 0;
  width: 100%;
  border-bottom: .145rem solid #3C3C3C;
  min-height: 22vh;
  height: auto;
  flex-wrap: wrap;
  gap: 1rem;
}
.logo-title-container {
  display: flex;
  align-items: center;
  /* flex: 1 1 auto; */
  min-width: none; 
}
.logo, #title, #search, #user-actions {
  display: flex;
  align-items: center;
  margin-right: 2%;
}
.logo {

}
#logo-img {
  flex-shrink: 1;
  max-height: 11rem;
  width: auto;
  border-radius: 5%;
  border: .145rem solid #F7C845;
  box-shadow: 0 .25rem .5rem rgba(0,0,0,0.1);
}
#search {
flex: 1 1 auto;
min-width: 12.5rem;
max-width: 37.5rem;
justify-content: flex-start;
}
#search input {
  width: 70%;
  min-width: 0;
  margin-top: 10%;
  margin-left: 4%;
  flex-shrink: 0;
  padding: 0.75rem 1rem;
  border: .145rem solid #F7931A;
  border-radius: 1.56rem 0 0 1.56rem;
  box-shadow: 0 .25rem .5rem rgba(0,0,0,0.3);
  font-size: 1.1rem;
  outline: none;
  transition: all .3s ease;
  flex: 0 0 auto;
}
#search input:focus {
  border-color: #F7931A;
  box-shadow: 0 0 .5rem rgba(247, 147, 26, 0.3);
}
#search button {
  padding: 0.75rem 1rem;
  margin-top: 10%;
  background-color: #F7C845;
  color: #F05A28;
  border: .145 solid #F7931A;
  border-radius: 0 1.6rem 1.6rem 0;
  box-shadow: 0 .25rem .5rem rgba(0,0,0,0.4);
  font-size: 1.1rem;
  cursor: pointer;
  transition: background-color .3s ease;
  flex: 0 0 auto;
}
#search button:hover {
  background-color: #F05A28;
  border-color: #F05A28;
  color:#F7931A;
}
#title {
  font-family: 'Playfair Display', sans-serif;
  text-align: center;
  margin-left: 1%;
  margin-right: 0;
  min-width: none;
  font-weight: bold;
  color: #1C4075;
  flex-shrink: 0; 
  text-shadow: -.07rem -.07rem 0 rgba(255, 255, 255, 0.2);
  background: linear-gradient(to right, #0A2850, #5B9BD5);
  background-clip: text;
  color: transparent;
  letter-spacing: .5px;
  transition: all 0.3s ease;
  z-index: 1;
  flex: 0 1 auto;
  font-size: clamp(1.5rem, 9vw, 9rem);
}
#user-actions {
  margin-left: 2%;
  flex: 0 0 auto;
}
#user-actions button, #user-actions .router-link {
  background-color: #F7C845;
  color: #1C4075;
  border: none;
  border-radius: 1.25rem;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.1s ease;
  text-decoration: none;
  display: inline-block;
}
#user-actions button:hover, #user-actions .router-link:hover {
  background-color: #FFD700;
  transform: scale(1.05);
}
#user-actions button:active,
#user-actions .router-link:active {
  transform: scale(.95);
}
#social-media {
  justify-self: center;
}
@media (max-width: 48rem) {
  header {
    flex-direction: column;
    height: auto;
    padding: 1rem;
  }
  .logo-title-container {
    flex-direction: column;
    margin-bottom: 1rem;
    align-items: center;
  }
  .logo {
    margin-right: 0;
    margin-bottom: -1rem;
  }
  #logo-img {
    height: 6rem;
    margin-bottom: 0.5rem;
  }
  #search {
    width: 100%;
    max-width: none;
    margin: 1rem 0;
  }
  #title {
    font-size: clamp(1.5rem, 4vw, 2rem); 
    margin-left: 0; 
    padding-left: 0;
  }
#user-actions {
  margin-top: 1rem;
}
}
</style>
