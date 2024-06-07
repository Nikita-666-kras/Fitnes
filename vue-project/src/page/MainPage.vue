
<template>
    <Header />
    <carousel />
    <div>
    <h1>Список тренеров</h1>
    <div class="card-container">
      <div class="card" v-for="trainer in training" :key="trainer.id">
        <img :src="trainer.user.img" alt="trainer-avatar" class="card-img-top" />
        <div class="card-body">
          <h5 class="card-title">{{ trainer.user.name }}</h5>
          <h5 class="card-title">{{ trainer.user.name }}</h5>
          <p class="card-text">{{ trainer.specialization }}</p>
          <!-- <a :href="`/trainer/${trainer.id}`" class="btn btn-primary">Подробнее</a> -->
        </div>
      </div>
    </div>
  </div>
    
</template>
<script setup>

import carousel from '../components/carusel.vue';

import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import Header from '@/components/Header.vue';
import api from '@/api.js';

const training = ref(null);
const route = useRoute();

const fetchTrainingDetail = async () => {
  const id = route.params.id;
  try {
    const response = await api.get('/unauthorized/get/coach/', {
      headers: {
        'Authorization': 'Bearer ' + $cookies.get('jwt')
      }
    });
    console.log(response.data);
    training.value = response.data;
    
  } catch (error) {
    console.error(error);
  }
};

onMounted(fetchTrainingDetail);

</script>







<style scoped>

.card-container {
    
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.card-body{
    border: 3px;
    border-color: blue;
}

.card {
    border: 32px;
    border-color: blue;  
  width: 18rem;
  margin: 1rem;
}

.card-img-top {
  width: 100%;
  height: 15rem;
  object-fit: cover;
}



.First {
  margin-top: 7%;
}
.c1 {
  background: rgb(255, 255, 255);
  background: linear-gradient(
    241deg,
    rgb(159, 134, 192) 0%,
    rgba(159, 134, 192) 100%
  );
  animation: gradient 5s infinite linear;
  background-size: 400%;
}
.btn{
    color: aliceblue;
    background-color: rgb(35, 25, 66);
}
@media (max-width: 768px) {
  .search-bar input {
    width: 150px;
  }
}

@media (max-width: 480px) {
  .First {
    flex-direction: column;
    padding: 10px;
  }

  .c1 {
    width: 100%;
    margin-bottom: 7%;
  }

  .buttons {
    margin-top: 10px;
  }

  .buttons button {
    margin-left: 0;
    display: block;
    width: 100%;
    margin-top: 7px;
  }
}
</style>
