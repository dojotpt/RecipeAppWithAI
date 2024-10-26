<template>
  <div>
    <recipe-search></recipe-search>
  </div>
</template>

<script>
import SearchRecipe from "../components/SearchRecipe.vue";

export default {
  components: {
    SearchRecipe,
  },
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
