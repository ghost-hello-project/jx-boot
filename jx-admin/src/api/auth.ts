import request from '@/utils/request'
import type { AxiosResponse } from 'axios'
import type { R } from '@/utils/common'
import type { LoginReq, LoginRsp } from '@/interfaces/auth'

export default {
    login(data: LoginReq): Promise<AxiosResponse<R<any>>> {
        return request.request({
            url: '/api/auth/login',
            method: 'POST',
            data
        }) as Promise<AxiosResponse<R<LoginRsp>>>
    }
}
