import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'index',
            component: () => import('@/views/index.vue')
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/login.vue')
        },
        {
            path: '/:pathMatch(.*)*',
            name: 'notfound',
            component: () => import('@/views/404.vue')
        }
    ]
})

export default router
