<script setup>
import { ref, onMounted } from 'vue';
import Header from '@/components/Header.vue';
import api from '@/api.js';
import jwt_decode from 'vue-jwt-decode';

const trainings = ref([]);

const fetchTrainingData = async () => {
  try {
    const response = await api.get('/authorized/get/workouts/', {
      headers: {
        'Authorization': 'Bearer ' + $cookies.get('jwt')
      }
    });
    trainings.value = response.data;
  } catch (error) {
    console.error(error);
  }
};

const viewDetails = (id) => {
  this.$router.push({ name: 'Train', params: { id: id } });
};

const addTrains = async (productId) => {
  const token = $cookies.get('jwt');
  const decodedToken = jwt_decode.decode(token);
  const trainData = {
    user: {
      id: decodedToken.id
    },
    coach: {
      id: 1
    },
    exercises: {
      id: 1
    },
    workouts: {
      id: productId
    }
  };

  try {
    const response = await api.post('/authorized/create/train/', trainData, {
      headers: {
        'Authorization': 'Bearer ' + $cookies.get('jwt')
      }
    });
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
};

onMounted(fetchTrainingData);
</script>

<template>
  <div>
    <Header />
    <div class="main">
      <div class="container">
        <h1>Все тренировки</h1>
        <div class="workout" v-for="training in trainings" :key="training.id">
          <h2>{{ training.name }}</h2>
          <p>{{ training.description }}</p>
          <div class="btnyyy"></div>
          <button type="button" class="BTN" @click="viewDetails(training.id)">Подробнее</button>
          <button type="button" class="BTN" @click="addTrains(training.id)">Добавить в мои тренировки</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.btnyyy {
  margin-left: 19px;
}

body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}

.BTN {
  max-width: 450px;
  border: none;
  margin-top: 1%;
  background-color: #007bff;
  color: white;
  margin-bottom: 5%;
}

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

.workout {
  margin-bottom: 20px;
  padding: 10px;
  background-color: #f9f9f9;
  border-left: 6px solid #007bff;
}

.workout h2 {
  color: #333;
}

.workout p {
  color: #666;
}
</style>
