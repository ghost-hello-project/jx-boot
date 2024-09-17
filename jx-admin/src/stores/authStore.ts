import { defineStore } from 'pinia'
import authApi from '@/api/auth'
import authUtil from '@/utils/authUtil'
import { toast, type R } from '@/utils/common'
import router from '@/router/index'
import type { AuthStore, LoginReq, UserInfoRsp } from '@/interfaces/auth'

const defaultAuthStore: AuthStore = {
    markDynamicRoutes: false,
    userInfo: {
        userInfo: {
            phone: '',
            username: '',
            nickname: '',
            avatar: '',
            email: ''
        },
        perms: [],
        roles: []
    }
}

export const useAuthStore = defineStore('authStore', {
    state: () => {
        return defaultAuthStore
    },
    getters: {
        getUsername(): string {
            return this.userInfo.userInfo.username
        },
        getNickname(): string {
            return this.userInfo.userInfo.nickname
        },
        getAavtar(): string {
            return this.userInfo.userInfo.avatar
        },
        getRouters(): Array<any> {
            // return this.userInfo.routers
            return []
        },
        getMarkDynamicRoutes(): boolean {
            return this.markDynamicRoutes
        }
    },
    actions: {
        async login(data: LoginReq) {
            const res = await authApi.login(data)
            if ('200' === res.data.code) {
                toast('登录成功')
                authUtil.setToken(res.data.body.token)
                router.push('/')
            }
        },
        async logout() {
            const res = await authApi.logout()
            if ('200' === res.data.code) {
                // 清除 cookie
                authUtil.removeToken()

                // 清空 pinia 状态
                this.userInfo = defaultAuthStore.userInfo

                // 返回登录页
                router.push('/login')

                toast('您已退出登录')
            }
        },
        async getUserInfo() {
            const res = await authApi.userInfo()
            const r: R<UserInfoRsp> = res.data
            this.userInfo = r.body
        },
        setMarkDynamicRoutes() {
            this.markDynamicRoutes = true
        }
    }
})
