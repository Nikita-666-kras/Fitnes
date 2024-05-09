// import './assets/main.css'
import "bootstrap/dist/css/bootstrap.css"
import { createApp } from 'vue'
import App from './App.vue'
import router from './router';


const app = createApp(App);
app.mount('#app');
app.use(router);
import "bootstrap/dist/js/bootstrap.js"