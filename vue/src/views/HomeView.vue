

<template>
  <div class="home">
    <h1>Home</h1>
    <p>You are logged in as {{ this.user }}</p>
  </div>
</template>

<script>
import AuthService from "../services/AuthService.js";

// export default {
//   data() {
//     return {
//       user: "",
//     };
//   },
//   created() {
//     this.fetchUser();
//   },
// };
</script>
