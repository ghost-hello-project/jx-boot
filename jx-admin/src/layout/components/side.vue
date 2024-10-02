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
                <el-menu :default-active="defaultActive" :collapse-transition="false"
                    :collapse="appStore.getSideCollapse" :style="{ width: appStore.getSideWidth }" :router="true">
                    <el-menu-item index="/">
                        <el-icon>
                            <HomeFilled />
                        </el-icon>
                        <span>首页</span>
                    </el-menu-item>
                    <el-sub-menu index="/product">
                        <template #title>
                            <el-icon>
                                <setting />
                            </el-icon>
                            <span>商品管理</span>
                        </template>
                        <el-menu-item index="/product/product">商品管理</el-menu-item>
                        <el-menu-item index="/product/category">商品分类</el-menu-item>
                        <el-sub-menu index="2">
                            <template #title>
                                <span>品牌管理</span>
                            </template>
                            <el-menu-item index="/product/brand/category">品牌分类</el-menu-item>
                            <el-menu-item index="/product/brand/list">品牌列表</el-menu-item>
                        </el-sub-menu>
                    </el-sub-menu>
                    <el-sub-menu index="/setting">
                        <template #title>
                            <el-icon>
                                <setting />
                            </el-icon>
                            <span>设置</span>
                        </template>
                        <el-menu-item index="/setting/menu">菜单管理</el-menu-item>
                    </el-sub-menu>
                </el-menu>
            </el-scrollbar>

        </div>

    </div>
</template>

<script lang="ts">
import logoImg from '@/assets/image/logo.png'
import { useAppStore } from '@/stores/appStore'
import { useRoute } from 'vue-router'
import { ref, onMounted } from 'vue'


export default {
    setup() {
        const route = useRoute()
        const appStore = useAppStore()

        const defaultActive = ref<string>('')

        onMounted(() => {
            defaultActive.value = route.path
        })
        return {
            logoImg,
            appStore,
            defaultActive
        }
    }
}
</script>

<style scoped lang="scss">
.sider-container {
    transition: all 0.2s;


    .sysinfo-wrapper {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 50px;
        width: 200px;
        border-right: 1px solid #dcefe6;
        transition: all 0.2s;
        border-bottom: 1px solid rgba(0, 21, 41, .08);
        ;

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
            height: 18px;
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
        top: 50px;
        height: calc(100vh - 50px);
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