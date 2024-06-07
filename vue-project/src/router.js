import { createRouter, createWebHistory } from 'vue-router';

import RegPage from './page/RegPage.vue';
import LogPage from './page/LogPage.vue';
import HomePage from './page/HomePage.vue';
import MainPage from './page/MainPage.vue';
import Account from '@/page/Account.vue';
import Workout from '@/page/Workout.vue';
import Exercises from '@/page/Exercises.vue';
import Train from '@/page/Train.vue';
import MyWorkout from './page/MyWorkout.vue';
import SearchResults from '@/page/SearchResults.vue';

export default createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/home', component: HomePage, alias: '/' },
    { path: '/reg', component: RegPage },
    { path: '/log', component: LogPage },
    { path: '/auth/main', component: MainPage },
    { path: '/auth/account', component: Account },
    { path: '/auth/workout',component:Workout},
    { path: '/auth/exercises',component:Exercises},
    { path: '/auth/train/:id', name: 'Train', component: Train },
    { path: '/auth/MyWorcout', component: MyWorkout },
    { path: '/search', component: SearchResults,},
  

    // {path:"/auth/main",component:AuthMain},
  ],
});
