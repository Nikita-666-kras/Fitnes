<script setup>
import Header from '@/components/Header.vue';
import api from '@/api.js'


</script>

<script>
export default {
  data() {
    return {
      trainings: [],
      WorkIDlist:null
    };
  },
  methods: {
    async fetchTrainingData() {





      try {
        const response = await api.get('/authorized/get/workouts/' , {
          headers: {
            'Authorization': 'Bearer ' + this.$cookies.get('jwt')
          }
        }).then(response=>{
           this.trainings = response.data
        });
         
      } catch (error) {
        console.error(error);
      }
    },
    exercises(){
      window.location.href="/auth/exercises";
    }


    
  },
  mounted() {
    this.fetchTrainingData();

    
  }}
</script>









<template>
  <div>
    <Header/>

    <div class="main">
      <div class="container">
        <h1>Все тренировки</h1>


        <div class="workout" v-for="training in trainings" :key="training.id">
          <h2>{{ training.name }}</h2>
          <p>{{ training.description }}</p>
          <!-- <ul>
            <li v-for="exercise in training.exercises" :key="exercise.id">{{ exercise.name }}</li>
          </ul> -->
          <button type="button" class="BTN"@click="exercises()">Подробнее</button>
        </div>
      </div>
    </div>
    
  </div>
</template>











<style scoped>

 body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .BTN{
  max-width: 450px;

  border: none;
  margin-top: 1%;
  background-color: #007bff;
  color: white;
  margin-bottom: 5%;}


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





