import { createRouter, createWebHistory } from 'vue-router';

import RegPage from './page/RegPage.vue';
import LogPage from './page/LogPage.vue';
import HomePage from './page/HomePage.vue';
import MainPage from './page/MainPage.vue';
import Account from '@/page/Account.vue';
import Workout from '@/page/Workout.vue';

export default createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/home', component: HomePage, alias: '/' },
    { path: '/reg', component: RegPage },
    { path: '/log', component: LogPage },
    { path: '/auth/main', component: MainPage },
    { path: '/auth/account', component: Account },
    {path: '/auth/workout',component:Workout}
  

    // {path:"/auth/main",component:AuthMain},
  ],
});
