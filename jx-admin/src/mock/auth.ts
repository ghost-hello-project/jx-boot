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
    }
] as MockMethod[]
