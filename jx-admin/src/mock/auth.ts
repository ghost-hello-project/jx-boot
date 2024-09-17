import type { MockMethod } from 'vite-plugin-mock'

export default [
    {
        url: '/api/auth/login',
        method: 'post',
        response: () => {
            return {
                code: '200',
                success: true,
                msg: '操作成功',
                body: {
                    token: 'token_mock'
                },
                extra: null,
                tid: '15323885216012608',
                time: '2024-08-28 07:05:33'
            }
        }
    },
    {
        url: '/api/auth/logout',
        method: 'get',
        response: () => {
            return {
                code: '200',
                msg: '操作成功',
                success: true,
                body: null,
                extra: 'mock'
            }
        }
    },
    {
        url: '/api/auth/userInfo',
        method: 'get',
        response: () => {
            return {
                code: '200',
                msg: '操作成功',
                success: true,
                body: {
                    userInfo: {
                        phone: '13500001001',
                        username: 'superAdmin',
                        nickname: '超级管理员',
                        avatar: 'http://image.jx.com/user/1/2023/12/24/avatar.jpg',
                        email: 'superAdmin@jx.com'
                    },
                    perms: ['*:*:*'],
                    roles: ['superAdmin']
                },
                extra: 'mock'
            }
        }
    }
] as MockMethod[]
