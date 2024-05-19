
<script setup>
import api from '@/api';
import Header from '@/components/Header.vue';
</script>


<script>


export default {
  
  data() {
    return {
      visible: false,
      // src : 'https://share-assets.mfcimg.com/packs-compiled/static/avatar-grey-4d1d556a3f7c835d738d.png',
      user: {
        name: '',
        email: '',
        img: 'https://share-assets.mfcimg.com/packs-compiled/static/avatar-grey-4d1d556a3f7c835d738d.png',
        resp: {},
      }

    };
  },
  methods:{
    
    async setimg() {
      const User = {
        img: this.img
       
      };
      try{
        const response = await apiapi.post('/authorized/set/user/img',User)
        .then(response =>{console.log(response.data)});
      }
      catch(error){}
      
    }
  },
  mounted() {
    


    api.get('/authorized/get/user/3', {
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
  }
  
};


</script>
<template>
  <Header />
  <div>
    <div class="container">
    <img class="Ava" v-bind:src="user.img">
    <button class="set_img" @click="visible = true">поменять картинку</button>
    
      <modal :show="visible">
          <div>
            <input type="text" v-model.trim="user.img" placeholder="вставьте ссылку на картинку"/>
            <button class="set_img" @click="setimg()">Готово</button>
          </div>
      </modal>  
    <h1>Name: {{ user.name }}</h1>
    <p>Email: {{ user.email }}</p>
    


    </div>
    
  </div>
</template>

<style scoped>
.set_img{
  border-radius: 30px;
  border: none;
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