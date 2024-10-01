<template>
    <div class="header-container">
        <div class="nav">
            <el-icon>
                <fold />
            </el-icon>
        </div>
        <div class="userinfo">
            <el-dropdown trigger="click">
                <span class="el-dropdown-link">
                    <el-avatar :src="avatarImg" />
                    <el-icon class="el-icon--right">
                        <arrow-down />
                    </el-icon>
                </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item @click="navigateToUserCenter">个人中心</el-dropdown-item>
                        <el-dropdown-item @click="logout" divided>退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script lang="ts">
import avatarImg from '@/assets/image/avatar.jpg'
import { useAuthStore } from '@/stores/authStore';
import { messageBox, message } from '@/utils/common'
export default {
    setup() {
        const authStore = useAuthStore()

        const navigateToUserCenter = () => {
            console.log('个人中心')
        }

        const logout = async () => {
            messageBox('确定要退出吗').then(async () => {
                await authStore.logout()
            }).catch(() => {
                message('您取消了退出')
            })

        }

        return {
            avatarImg,
            navigateToUserCenter,
            logout
        }
    }
}
</script>

<style scoped lang="scss">
.header-container {
    width: calc(100vw - 200px);
    height: 50px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    box-shadow: 0 1px 4px rgba(0, 21, 41, .08);
    padding: 0 15px;
    box-sizing: border-box;
}
</style>