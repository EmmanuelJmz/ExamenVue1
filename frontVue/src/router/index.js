import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        component:()=> import('../components/Inicio.vue')
    },
    {
        path: '/formulario',
        name: '/formulario',
        component:()=> import('../components/Formulario.vue')
    },
    {
        path: '/paginacion',
        name: 'paginacion',
        component: () => import('../components/Pag.vue')
    },
    {
        path: '/landingpage',
        component:()=> import('../components/LandPage.vue')
    }
]

const router = new VueRouter({ routes, })
export default router;
