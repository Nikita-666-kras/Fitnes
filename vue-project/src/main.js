// import './assets/main.css'
import "bootstrap/dist/css/bootstrap.css";
import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import Cookies from 'js-cookie';


const app = createApp(App);
app.use(router);
app.mount('#app');

import "bootstrap/dist/js/bootstrap.js"