<template>
    <div class="sider-container">
        <div :class="['sysinfo-wrapper', appStore.getSideCollapse ? 'collapse' : 'expand']">
            <div class="title">
                <img :src="logoImg" />
                <span>京西</span>
            </div>
            <div class="intro">
                <span>小东子，给我狠狠地淦留学生</span>
            </div>
        </div>
        <div class="menu-wrapper">
            <el-scrollbar>
                <el-menu default-active="2" :collapse-transition="false" :collapse="appStore.getSideCollapse"
                    :style="{ width: appStore.getSideWidth }">
                    <el-menu-item index="2">
                        <el-icon>
                            <HomeFilled />
                        </el-icon>
                        <span>首页</span>
                    </el-menu-item>
                    <el-sub-menu index="1">
                        <template #title>
                            <el-icon>
                                <location />
                            </el-icon>
                            <span>Navigator One</span>
                        </template>
                        <el-menu-item-group title="Group One">
                            <el-menu-item index="1-1">item one</el-menu-item>
                            <el-menu-item index="1-2">item two</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="Group Two">
                            <el-menu-item index="1-3">item three</el-menu-item>
                        </el-menu-item-group>
                        <el-sub-menu index="1-4">
                            <template #title>item four</template>
                            <el-menu-item index="1-4-1">item one</el-menu-item>
                        </el-sub-menu>
                    </el-sub-menu>
                    <el-menu-item index="3" disabled>
                        <el-icon>
                            <document />
                        </el-icon>
                        <span>Navigator Three</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <el-icon>
                            <setting />
                        </el-icon>
                        <span>Navigator Four</span>
                    </el-menu-item>
                </el-menu>
            </el-scrollbar>

        </div>

    </div>
</template>

<script lang="ts">
import logoImg from '@/assets/image/logo.png'
import { useAppStore } from '@/stores/appStore'
export default {
    setup() {
        const appStore = useAppStore()
        return {
            logoImg,
            appStore
        }
    }
}
</script>

<style scoped lang="scss">
.sider-container {
    transition: all 0.2s;
    box-sizing: border-box;

    .sysinfo-wrapper {
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 70px;
        padding-top: 10px;
        width: 200px;
        border-right: 1px solid #dcefe6;
        transition: all 0.2s;

        .title {
            display: flex;
            justify-content: center;
            height: 32px;

            img {
                width: 32px;
                height: 32px;
            }

            span {
                font-size: 18px;
                line-height: 32px;
                padding-left: 10px;
            }
        }

        .intro {
            height: 28px;
            display: flex;
            justify-content: center;

            span {
                font-size: 12px;
            }
        }

        &.collapse {

            width: 64px;

            .intro {
                display: none;
            }

            .title {
                span {
                    display: none;
                }
            }
        }

        &.expand {
            width: 200px;

            .intro {
                display: flex;
                justify-content: center;
            }

            .title {
                span {
                    display: inline-block;
                }
            }
        }
    }

    .menu-wrapper {
        position: absolute;
        top: 70px;
        height: calc(100vh - 70px);
        overflow-y: auto;
        transition: all 0.2s;
    }

    :deep(.el-menu) {
        height: 100%;
        transition: all 0.2s;
    }

    :deep(.el-scrollbar) {
        transition: all 0.2s;
    }

    :deep(.el-scrollbar__view) {
        height: 100%;
    }
}
</style>