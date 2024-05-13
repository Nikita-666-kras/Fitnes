import { createRouter, createWebHistory } from 'vue-router';

import RegPage from "./page/RegPage.vue";
import LogPage from "./page/LogPage.vue";
import HomePage from "./page/HomePage.vue";
import MainPage from "./page/MainPage.vue";




export default createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/home", component: HomePage, alias: '/' },
        { path: "/reg", component: RegPage },
        { path: "/log", component: LogPage },
        { path: "/main", component: MainPage },
        // {path:"/auth/main",component:AuthMain},


    ]
})