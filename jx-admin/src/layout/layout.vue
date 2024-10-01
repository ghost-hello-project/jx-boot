<template>
    <el-container>
        <SideView />
        <el-container class="content-wrapper">
            <HeaderView />
            <el-main class="main-container">
                <TagListView />
                <RouterView />
            </el-main>
        </el-container>
    </el-container>
</template>

<script lang="ts">
import HeaderView from '@/layout/components/header.vue'
import SideView from '@/layout/components/side.vue'
import TagListView from '@/layout/components/tag-list.vue'
export default {
    components: {
        HeaderView,
        SideView,
        TagListView
    },
    setup() {

        return {
        }
    }
}
</script>


<style scoped lang="scss">
.content-wrapper {
    display: flex;
    flex-direction: column;
}

.main-container {
    width: calc(100vw - 200px);
    padding: 0;
}
</style>