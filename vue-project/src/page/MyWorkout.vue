
<script setup>
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import Header from '@/components/Header.vue';
import api from '@/api.js';
import jwt_decode from 'vue-jwt-decode';

const workouts = ref(null);
const route = useRoute();

const fetchTrainingDetail = async () => {
  const token = $cookies.get('jwt'); 
    const decodedToken = jwt_decode.decode(token);
    const user_id=decodedToken.id;
  
  try {
    const response = await api.get(`/authorized/get/train/${user_id}`, {
      headers: {
        'Authorization': 'Bearer ' + $cookies.get('jwt')
      }
    })
    console.log(response.data);
    workouts.value = response.data;
    
  } catch (error) {
    console.error(error);
  }
};

onMounted(fetchTrainingDetail);




</script>

  

<template>
  <div>
    <Header />
    <div class="card" v-for="workout in workouts" :key="workout.id">
      <h1>{{ workout.workouts.name }}</h1>
      <p>{{ workout.workouts.description }}</p>
      <p>{{ workout.workouts.start_date }}</p>
      <p>{{ workout.workouts.end_date }}</p>
      <h3>Упражнения</h3>
      <ul>
        <!-- <li v-for="exercise in training.exercises" :key="exercise.id">{{ exercise.name }}</li> -->
      </ul>
    </div>
  </div>
</template>


  <style scoped>
  .container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  h1 {
    text-align: center;
    color: #333;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    background-color: #f9f9f9;
    margin: 5px 0;
    padding: 10px;
    border-left: 6px solid #007bff;
  }
  </style>