import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'index',
            component: () => import('@/views/index.vue'),
            meta: {
                title: '管理台'
            }
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/login.vue'),
            meta: {
                title: '登录'
            }
        },
        {
            path: '/:pathMatch(.*)*',
            name: 'notfound',
            component: () => import('@/views/404.vue')
        }
    ]
})

export default router
