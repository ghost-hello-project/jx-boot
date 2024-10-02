<template>
    <el-container>
        <SideView />
        <el-container :class="['content-wrapper', appStore.getSideCollapse ? 'collapse' : 'expand']">
            <HeaderView />
            <el-main class="main-wrapper">
                <TagListView />
                <div class="main-container">
                    <RouterView v-slot="{ Component }">
                        <KeepAlive>
                            <component :is="Component"></component>
                        </KeepAlive>
                    </RouterView>
                </div>
            </el-main>
        </el-container>
    </el-container>
</template>

<script lang="ts">
import HeaderView from '@/layout/components/header.vue'
import SideView from '@/layout/components/side.vue'
import TagListView from '@/layout/components/tag-list.vue'
import { useAppStore } from '@/stores/appStore'
export default {
    components: {
        HeaderView,
        SideView,
        TagListView
    },
    setup() {
        const appStore = useAppStore()
        return {
            appStore
        }
    }
}
</script>


<style scoped lang="scss">
.content-wrapper {
    display: flex;
    flex-direction: column;

    &.collapse {
        width: calc(100vw - 64px);
    }

    &.expand {
        width: calc(100vw - 200px);
    }
}

.main-wrapper {
    height: calc(100vh - 50px);
    overflow: hidden;


    .main-container {
        padding: 15px;
    }
}

:deep(.el-main) {
    padding: 0;
}
</style>