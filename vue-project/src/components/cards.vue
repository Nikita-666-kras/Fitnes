<template>
  <div>
    <h1>Список тренеров</h1>
    <div class="card-container">
      <div class="card" v-for="trainer in trainers" :key="trainer.id">
        <img :src="trainer.avatar" alt="trainer-avatar" class="card-img-top" />
        <div class="card-body">
          <h5 class="card-title">{{ trainer.name }}</h5>
          <p class="card-text">{{ trainer.bio }}</p>
          <a :href="`/trainer/${trainer.id}`" class="btn btn-primary">Подробнее</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import api from '@/api.js';</script>
<script>


export default {
  data() {
    return {
      trainers: [],
    };
  },
  async created() {
    try {
      const response = await api.get('unauthorized/get/coach/'); // Предполагается, что эндпоинт /trainers возвращает список тренеров
      this.trainers = response.data; // Предполагается, что список тренеров возвращается в формате массива объектов
    } catch (error) {
      console.error('Ошибка при получении списка тренеров:', error);
    }
  },
};
</script>

<style scoped>
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
