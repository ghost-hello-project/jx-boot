import request from '@/utils/request'
import type { AxiosResponse } from 'axios'
import type { R } from '@/utils/common'

export default {
    dictTypeList(data: any): Promise<AxiosResponse<R<any>>> {
        return request.request({
            url: '/api/admin/system/dict/type/list',
            method: 'POST',
            data
        }) as Promise<AxiosResponse<R<any>>>
    }
}
