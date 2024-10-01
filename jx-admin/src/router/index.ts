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
            path: '/',
            component: LayoutView,
            children: [
                {
                    path: 'product',
                    children: [
                        {
                            path: 'product',
                            name: 'product_product',
                            component: () => import('@/views/product/product.vue'),
                            meta: {
                                title: '商品管理'
                            }
                        },
                        {
                            path: 'category',
                            name: 'product_category',
                            component: () => import('@/views/product/category.vue'),
                            meta: {
                                title: '商品分类'
                            }
                        },
                        {
                            path: 'brand',
                            children: [
                                {
                                    path: 'category',
                                    name: 'product_brand_brand',
                                    component: () => import('@/views/product/brand/category.vue'),
                                    meta: {
                                        title: '品牌分类'
                                    }
                                },
                                {
                                    path: 'list',
                                    name: 'product_brand_list',
                                    component: () => import('@/views/product/brand/brand_list.vue'),
                                    meta: {
                                        title: '品牌列表'
                                    }
                                }
                            ]
                        }
                    ]
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
