// 后端接口统一结构
export type R<T> = {
    code: string
    success: boolean
    msg: string
    body: T
    extra: object
    tid: string
    time: string
}

import { ElNotification, ElMessageBox, ElMessage } from 'element-plus'

export const toast = (
    message: string,
    type: any = 'success',
    dangerouslyUseHTMLString: boolean = false
) => {
    ElNotification({
        title: '提示',
        message: message,
        type: type,
        dangerouslyUseHTMLString: dangerouslyUseHTMLString,
        duration: 1500
    })
}

export const messageBox = (message: string, type: any = 'warning', title: string = '提示') => {
    return ElMessageBox.confirm(message, title, {
        confirmButtonText: '确认',
        cancelButtonText: '取消',
        type
    })
}

export const message = (msg: string, type: any = 'success') => {
    return ElMessage({
        message: msg,
        type
    })
}
