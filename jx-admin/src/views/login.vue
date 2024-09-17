<template>
    <el-row class="container">
        <el-col :span="16" class="left">
            <div class="box">
                <div class="title">jx-ui-admin</div>
                <div class="intro">
                    此项目为
                    <a href="javascript:void(0);" class="text-cyan-200">《内卷正经》</a>
                    的前置项目，用于统一学习环境
                </div>
            </div>
        </el-col>
        <el-col :span="8" class="right">
            <h2 class="title">欢迎登录</h2>
            <div>
                <el-tabs type="border-card">
                    <el-tab-pane label="账号密码登录">
                        <el-form ref="loginFormRef" :model="loginFormModel" :rules="loginFormRules" style="width: 300px"
                            status-icon>
                            <el-form-item prop="username">
                                <el-input auto-completeo="off" placeholder="请输入账号" v-model="loginFormModel.username" />
                            </el-form-item>
                            <el-form-item>
                                <el-input auto-completeo="off" placeholder="请输入密码" v-model="loginFormModel.password" />
                            </el-form-item>
                            <el-form-item class="flex flex-col items-center">
                                <el-button type="primary" @click="onSubmit(loginFormRef)">登录</el-button>
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                    <el-tab-pane label="扫码登录">开发中</el-tab-pane>
                </el-tabs>
            </div>
        </el-col>
    </el-row>
</template>

<script lang="ts">
import type { LoginReq } from '@/interfaces/auth'
import { reactive, ref, toRaw } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import authApi from '@/api/auth'
import authUtil from '@/utils/authUtil'
export default {
    setup() {
        const loginDataInit = { username: 'superAdmin', password: '123456', loginType: '01' }
        const loginFormModel = reactive<LoginReq>(loginDataInit)
        const loginFormRef = ref<FormInstance>()
        const loginFormRules = reactive<FormRules<LoginReq>>({
            username: [{ required: true, message: '请输入账号', trigger: 'blur' }]
        })

        const onSubmit = async (formEl: FormInstance | undefined) => {
            if (!formEl) {
                return
            }

            await formEl.validate(async (valid, fields) => {
                if (valid) {
                    const loginRsp = await authApi.login(toRaw(loginFormModel))
                    const loginBody = loginRsp.data
                    console.log(loginBody)
                    authUtil.setToken(loginBody.body.token)
                } else {
                    console.error('error submit:', fields)
                }
            })
        }

        return {
            loginFormModel,
            loginFormRef,
            loginFormRules,
            onSubmit
        }
    }
}
</script>

<style scoped lang="scss">
.container {
    height: 100vh;

    .left {
        background-color: #606ff6;
        color: #ffffff;
        display: flex;
        align-items: center;
        align-content: center;

        .box {
            width: 100%;
            display: flex;
            align-content: center;
            flex-direction: column;
            padding-left: 180px;

            .title {
                font-size: 25px;
            }

            .intro {
                color: bisque;
                margin-top: 10px;

                a {
                    text-decoration: none;
                    color: #fc5531;
                }
            }
        }
    }

    .right {
        display: flex;
        justify-content: center;
        flex-direction: column;
        padding: 0 40px 120px 40px;

        .title {
            text-align: center;
        }
    }
}
</style>
