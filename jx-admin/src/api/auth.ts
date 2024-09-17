import request from '@/utils/request'
import type { AxiosResponse } from 'axios'
import type { R } from '@/utils/common'
import type { LoginReq, LoginRsp, UserInfoRsp } from '@/interfaces/auth'

export default {
    login(data: LoginReq): Promise<AxiosResponse<R<any>>> {
        return request.request({
            url: '/api/auth/login',
            method: 'POST',
            data
        }) as Promise<AxiosResponse<R<LoginRsp>>>
    },
    logout(): Promise<AxiosResponse<R<any>>> {
        return request.request({
            url: '/api/auth/logout',
            method: 'GET'
        }) as Promise<AxiosResponse<R<LoginRsp>>>
    },
    userInfo(): Promise<AxiosResponse<R<any>>> {
        return request.request({
            url: '/api/auth/userInfo',
            method: 'GET'
        }) as Promise<AxiosResponse<R<UserInfoRsp>>>
    }
}
