import axios from 'axios'
import type { AxiosInstance, AxiosRequestConfig, AxiosResponse } from 'axios'
import { ElMessage } from 'element-plus'
import type { R } from '@/utils/common'
import authUtil from '@/utils/authUtil'

// 导出 Request 类, 用来自定义传递配置
export class Request {
    // axiox 实例
    instance: AxiosInstance
    // 基础配置
    baseConfig: AxiosRequestConfig = { baseURL: '', timeout: 60000 }

    constructor(config: AxiosRequestConfig) {
        this.instance = axios.create(Object.assign(this.baseConfig, config))

        // 请求拦截
        this.instance.interceptors.request.use(
            (config) => {
                // 添加 token
                const token = authUtil.getToken()
                if (token) {
                    config.headers!.Authorization = token
                }

                // 添加 channel type
                const channelType = authUtil.getChannelType()
                if (channelType) {
                    config.headers!.channel = channelType
                }
                return config
            },
            (err: any) => {
                // 请求错误 element 提示框
                return Promise.reject(err)
            }
        )

        this.instance.interceptors.response.use(
            (res: AxiosResponse<R<any>>) => {
                const data = res.data
                if ('200' !== data.code) {
                    ElMessage({
                        message: data.msg,
                        type: 'warning'
                    })
                }
                return res
            },
            (err: any) => {
                // 处理错误
                ElMessage({
                    message: err.response.data.msg,
                    type: 'error'
                })
                return Promise.reject(err.response)
            }
        )
    }

    public request<T = any>(config: AxiosRequestConfig): Promise<AxiosResponse<R<T>>> {
        return this.instance.request(config)
    }
}

export default new Request({})
