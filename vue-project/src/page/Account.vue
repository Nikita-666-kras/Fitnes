<script setup>
import Header from '@/components/Header.vue';
</script>
<script>
export default {
  data() {
    return {
      img: '',
    };
  },
  methods: {
    async signupUser() {
      const User = {
        name: this.userName,
        password: this.userPassword,
      };
      try {
        const response = await api
          .post('/set/user/img', User)
          .then((response) => {
            this.responseData = response.data;
            this.errorMessage = response.data.message;
            // window.location.href = '/auth/main';
          })
          .catch((error) => {
            console.error(error);
            this.errorMessage = error.response.status;
          });
        console.log(' не авторизован:', User);
      } catch (error) {}
    },
  },
};
</script>
<template>
  <Header />
  <div class="Person_I container">
    <div class="hader">
      <img src="" alt="" class="avatar" />
      <div class="Name"></div>
      <div class=""></div>
    </div>
  </div>
</template>

<style></style>
