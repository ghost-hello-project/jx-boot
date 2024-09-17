import router from '@/router'
import authUtil from '@/utils/authUtil'
import { toast, progressStart, progressClose } from '@/utils/common'

const login_path = '/login'

router.beforeEach((to, from, next) => {
    // nprogress
    progressStart()

    const token = authUtil.getToken()

    // 未登录, 跳转到登录页
    if (!token && login_path !== to.path) {
        toast('请先登录', 'error')
        return next({ path: login_path })
    }

    // 防止重复登录
    if (token && login_path === to.path) {
        toast('请不要重复登录', 'warning')
        return next({ path: from.path ? from.path : '/' })
    }
    next()
})

router.afterEach(() => {
    progressClose()
})
