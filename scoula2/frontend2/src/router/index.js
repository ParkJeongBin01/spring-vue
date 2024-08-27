import { createRouter, createWebHistory } from 'vue-router';
import authRotes from './auth';
import boardRotes from './board';
import travelRotes from './travel';
import galleryRotes from './gallery';
import HomePage from '../pages/HomePage.vue';
//import danger from './danger';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [{ path: '/', name: 'home', component: HomePage }, ...authRotes, ...boardRotes, ...travelRotes, ...galleryRotes], //...danger],
  //spread연산자. 코드가 길어지고 유지 보수가 쉽도록 썼다.
});

export default router;
