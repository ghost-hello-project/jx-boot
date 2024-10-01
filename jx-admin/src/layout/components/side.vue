<template>
    <div class="sider-container">
        <div class="sysinfo-wrapper">
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
                <el-menu default-active="2">
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
export default {
    setup() {
        return {
            logoImg,
        }
    }
}
</script>

<style scoped lang="scss">
.sider-container {
    width: 200px;

    .sysinfo-wrapper {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 60px;
        border-right: 1px solid #dcefe6;

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
    }

    .menu-wrapper {
        position: absolute;
        top: 60px;
        height: calc(100vh - 60px);
        overflow-y: auto;


    }

    :deep(.el-menu) {
        height: 100%;
        width: 200px;
    }
}
</style>