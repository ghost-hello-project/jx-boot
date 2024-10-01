import { createRouter, createWebHistory } from 'vue-router'

import LayoutView from '@/layout/layout.vue'
import IndexView from '@/views/index.vue'
import LoginView from '@/views/login.vue'
import NotFoundView from '@/views/404.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            component: LayoutView,
            children: [
                {
                    path: '/',
                    name: 'index',
                    component: IndexView,
                    meta: {
                        title: '管理台'
                    }
                }
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: LoginView,
            meta: {
                title: '登录'
            }
        },
        {
            path: '/:pathMatch(.*)*',
            name: 'notfound',
            component: NotFoundView
        }
    ]
})

export default router
