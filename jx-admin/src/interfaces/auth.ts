export interface LoginReq {
    username: string
    password: string
    loginType: string
}

export interface LoginRsp {
    token: string
}

export interface UserInfoRsp {
    userInfo: {
        phone: string
        username: string
        nickname: string
        avatar: string
        email: string
    }
    perms: Array<string>
    roles: Array<string>
}

export interface AuthStore {
    markDynamicRoutes: boolean
    userInfo: UserInfoRsp
}
