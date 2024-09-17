export interface LoginReq {
    username: string
    password: string
    loginType: string
}

export interface LoginRsp {
    token: string
}
