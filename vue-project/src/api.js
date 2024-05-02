import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:3333', // замените на адрес вашего бэкенда
});

export default api;
