<script>
import api from '../api.js';
import { useVuelidate } from '@vuelidate/core';
import { required, email } from '@vuelidate/validators';


export default {
  

  setup () {
    return { v$: useVuelidate() }
  },
  data() {
    return {
      users: [],
      userName: '',
      errorMessage: '',
      responseData: null,
      userPassword: '',
      jwt: null,
    };
  },
  validations () {
    return {
      userName: { required }, // Matches this.firstName
      userPassword: { required }, // Matches this.lastName
      
      
    } 
  },
  methods: {

    setPage(){
      window.location.href="/reg";
    },



    async signupUser() {
      const User = {
        name: this.userName,
        password: this.userPassword,
      };
      const isFormCorrect = await this.v$.$validate()
      if (isFormCorrect){
        try {
          const response = await api
            .post('/auth/signin', User)
            .then((response) => {
              this.responseData = response.data;
              this.errorMessage = response.data.message;
              this.jwt = response.data;
              this.$cookies.remove('jwt');
              this.$cookies.set('jwt', this.jwt, '1d');
              console.log(this.jwt);
              console.log('авторизован:', User);
              window.location.href = '/auth/main';
            })
            .catch((error) => {
              console.error(error);
              this.errorMessage = error.response.status;
            });
          
        } catch (error) {}
      }
    },
  },
  // created() {
  //   api.get('unauthorized/get/users/')
  //     .then(response => {
  //       this.users = response.data;
  //     })
  //     .catch(error => {
  //       console.error(error);
  //     });

  // },
  // created(){
  //   const newUser = {
  //     userName: '',
  //     userAge: '',
  //     userPass: ''
  //     }
  //   api.post('/auth/signup', newUser)
  //     .then(response => {
  //       this.users = response.data;
  //     })
  //     .catch(error => {
  //       console.error(error);
  //     });
  // }
};
</script>

<template>
  <div class="All">
    <header></header>
    <main>
      <div class="reg_window">
        <div class="reg_input">
          <h2 class="error">{{ errorMessage }}</h2>
          <input type="text" v-model.trim="userName" placeholder="name" />

          <input
            type="password"
            v-model.trim="userPassword"
            placeholder="password"
          />
        </div>
        <div class="reg_Button">
          <button class="regBT" @click="signupUser()">отправить</button>

        </div>
        <div class="regist"><a class="regi" @click="setPage()">зарегистрироваться</a></div>
      </div>
    </main>
    <footer></footer>
  </div>
</template>

<style scoped>
.regi{
  color: black;
}
.regist{
  margin-top: 50px;
  
}
.error {
  font-size: 28px;
  color: red;
}
input {
  margin-bottom: 1vh;
  background: rgb(255, 255, 255);
  background: linear-gradient(
    241deg,
    rgb(239, 161, 255) 0%,
    rgb(255, 255, 255) 100%
  );
  animation: gradient 2s infinite linear;
  background-size: 400%;
  height: 5vh;
  width: 30vh;
  border-color: rgba(252, 0, 255, 1);
  border-radius: 10px;
  align-items: center;
  font-size: 32px;
}
.All {
  display: column;
  align-items: center;
  justify-content: space-around;
  width: 100%;
  max-height: 100vh;
}

.regBT {
  background: rgb(255, 255, 255);
  background: linear-gradient(
    241deg,
    rgba(0, 254, 255, 1) 0%,
    rgba(252, 0, 255, 1) 100%
  );
  animation: gradient 5s infinite linear;
  background-size: 400%;
  width: auto;
  height: auto;
  color: aliceblue;
  background-color: rgb(203, 148, 255);
  border-color: azure;
  border-radius: 35px;
  font-size: 35px;
}

.reg_window {
  width: 100%;
  height: 100%;
  margin-top: 15%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.reg_input {
  width: 100%;
  height: 100%;
  margin-top: 10vh;
  margin-bottom: 5%;
  flex-direction: column;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 35px;
  color: blueviolet;
  font-weight: bold;
}
.log {
  height: auto;
  width: auto;
  align-items: center;
  justify-content: space-around;
  margin-bottom: 3vh;
}
.reg {
  height: auto;
  width: auto;
}

@keyframes gradient {
  0% {
    background-position: 80% 0%;
  }
  50% {
    background-position: 20% 100%;
  }
  100% {
    background-position: 80% 0%;
  }
}
</style>
