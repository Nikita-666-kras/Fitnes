
<script setup>
import api from '@/api';
import Header from '@/components/Header.vue';
// import jwt_decode from 'jwt-decode';
import jwt_decode from 'vue-jwt-decode'
// import * as jwt_decode from 'jwt-decode';

// Далее ваш код для декодирования JWT токена и получения id пользователя


</script>


<script>


export default {
  
  data() {
    return {
      visible: false,
      User: {},
      // src : 'https://share-assets.mfcimg.com/packs-compiled/static/avatar-grey-4d1d556a3f7c835d738d.png',
      user: {
        name: '',
        email: '',
        img: '',
        resp: {},
        userId: null,
      }

    };
  },
  methods:{
    logOut(){
      this.$cookies.remove('jwt');
      window.location.href="/log"
    },


    
    async setimg() {
       this.User = {
        name :this.user.name,
        img: this.user.img,
      };
      try{
        const response = await api.post('/authorized/set/user/img',this.User,
        {
          headers: {
            'Authorization': 'Bearer ' + this.$cookies.get('jwt') 
          }
        }
        )
        .then(response =>{
          console.log(response.data)
          console.log(User)
        });
      }
      catch(error){}
      
    }
  },
  mounted() {


    const token = this.$cookies.get('jwt'); 
    const decodedToken = jwt_decode.decode(token);

    if (decodedToken) {
         this.userId = decodedToken.id;
        console.log(decodedToken.id ); // Вывод id пользователя
    } else {
        console.log('Неверный токен');
    }
    


    api.get('/authorized/get/user/'+this.userId, {
      headers: {
        'Authorization': 'Bearer ' + this.$cookies.get('jwt') // Получаем JWT токен из cookie
      }
})
      .then(response => {
        this.user.name = response.data.name;
        this.user.email = response.data.email;
        if (response.data.img != null){
          this.user.img = response.data.img
        }
        else {
          this.user.img = "https://share-assets.mfcimg.com/packs-compiled/static/avatar-grey-4d1d556a3f7c835d738d.png";

        }

        
        console.log(response.data)
      })
      .catch(error => {
        console.error('Ошибка при получении данных:', error);
      });
      console.log(document.cookie);
  }
  
};


</script>
<template>
  <Header />
  <div>
    <div class="container">
    <img class="Ava" v-bind:src="user.img">
    <button class="set_img" @click="visible = true">поменять картинку</button>
    
      <div v-show="visible">
          <div  class="hre">
            <p>вставьте ссылку на картинку</p>
            <input type="text" v-model="user.img" placeholder="вставьте ссылку на картинку"/>
            <button class="set_img" @click="setimg()">Готово</button>
          </div>
        </div>  
    <h1>Name: {{ user.name }}</h1>
    <p>Email: {{ user.email }}</p>
    <div class="logout">
      <button class="b_logout" @click="logOut()">Выйти из аккаунта</button>
    </div>


    </div>
    
  </div>
</template>

<style scoped>
.b_logout{
  max-width: 450px;
  border-radius: 30px;
  border: none;
  margin-top: 1%;
  background-color: #45184c;
  color: white;
  margin-bottom: 5%;}
.logout{
  margin-top: 40px;
  max-width: 25%;
  display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    align-content: center;
    align-items: center;
    justify-content: space-evenly;

}
.hre{
  display: flex;
  align-items: center;
  flex-direction: column;
}
.set_img{
  border-radius: 30px;
  border: none;
  margin-top: 1%;
  background-color: #45184c;
  color: white;
  margin-bottom: 5%;
}
.container{
  display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    align-content: center;
    align-items: center;
    justify-content: space-evenly;

}
.Ava{
  max-width: 200px;
  height: auto;
  border-radius: 30px;
}
h1 {
  color: #333;
  margin-bottom: 1%;
}

p {
  font-size: 16px;
}
</style>