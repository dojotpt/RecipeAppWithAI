<template>
  <div id="entire-page-container">
    <header>
      
          <div id="title">Cookin' with Java</div>
          <div id="search">
        <input v-model="headerQuery" placeholder="Enter a recipe" />
          <button @click.prevent="handleSearch">Find a Recipe</button>
      </div>
      
          <div class="logo">
            <img id="logo-img" src="@/images/RecipeAppLogo.png" alt="cartoon chef with binary hat">

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
  display: flex;
  flex-direction: column;
}
header {
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1vh 2vw 1vh 0;
  width: 100vw;
  background-color: #FFFFFF;
  border-bottom: 2px solid #3C3C3C;
  height: 22vh;
}
.logo-title-container {
  display: flex;
  align-items: center;
  flex: 0 0 auto; /* stops shrinking */
}
.logo, #title, #search, #user-actions {
  display: flex;
  align-items: center;
}
.logo {
  margin-right: 2%;
}
#logo-img {
  flex-shrink: 0;
  height: 14rem;
  width: auto;
  border-radius: 5%;
  border: 2px solid #F7C845;
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}
#search {
flex: 1;
max-width: 600px;
justify-content: flex-start;
}
#search input {
  width: 60%;
  margin-top: 10%;
  margin-left: 4%;
  flex-shrink: 1;
  padding: 0.75rem 1rem;
  border: 2px solid #9AD0E5;
  border-radius: 25px 0 0 25px;
  font-size: 1.1rem;
  outline: none;
  transition: all .3s ease;
}
#search input:focus {
  border-color: #F7931A;
  box-shadow: 0 0 8px rgba(247, 147, 26, 0.4);
}
#search button {
  width: 30%;
  padding: 0.75rem 1rem;
  margin-top: 10%;
  background-color: #9AD0E5;
  color: #3C3C3C;
  border: 2px solid #9AD0E5;
  border-radius: 0 25px 25px 0;
  font-size: 1.1rem;
  cursor: pointer;
  transition: background-color .3s ease;
  flex: 0 0 auto;
}
#search button:hover {
  background-color: #1C4075;
  border-color: #1C4075;
}
#title {
  font-size: 9rem;
  text-align: center;
  margin-left: 2%;
  margin-right: 0;
  font-weight: bold;
  color: #F05A28;
  flex-shrink: 0; 
  text-shadow: 2px 2px 4px rgba(60,60,60,0.3);
  background: linear-gradient(to right, #F05A28, #F7C845);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  letter-spacing: 5px;
  transition: all 0.3s ease;
  z-index: 1;
}#F7C845, #F05A28
#user-actions {
  margin-left: 2%;
  flex: 0 0 auto;
}
#user-actions button, #user-actions .router-link {
  background-color: #F7C845;
  color: #1C4075;
  border: none;
  border-radius: 20px;
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
@media (max-width: 768px) {
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
    margin-bottom: -20px;
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
