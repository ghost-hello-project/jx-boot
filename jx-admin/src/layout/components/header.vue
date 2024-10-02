<template>
    <div :class="['header-container', appStore.getSideCollapse ? 'collapse' : 'expand']">
        <div class="nav" @click="toggleSideCollapse">
            <el-icon>
                <fold v-if="appStore.getSideCollapse" />
                <Expand v-else />
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
import { useAuthStore } from '@/stores/authStore'
import { useAppStore } from '@/stores/appStore'
import { messageBox, message } from '@/utils/common'
export default {
    setup() {
        const authStore = useAuthStore()
        const appStore = useAppStore()

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

        const toggleSideCollapse = () => {
            appStore.toggleSideCollapse()
        }

        return {
            avatarImg,
            navigateToUserCenter,
            logout,
            toggleSideCollapse,
            appStore
        }
    }
}
</script>

<style scoped lang="scss">
.header-container {
    height: 50px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    box-shadow: 0 1px 4px rgba(0, 21, 41, .08);
    padding-right: 15px;
    transition: all 0.2s;

    &.collapse {
        width: calc(100vw - 64px);
    }

    &.expand {
        width: calc(100vw - 200px);
    }

    .nav {
        height: 100%;
        width: 50px;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;

        &:hover {
            background-color: rgba(0, 0, 0, .025);
        }
    }
}
</style>