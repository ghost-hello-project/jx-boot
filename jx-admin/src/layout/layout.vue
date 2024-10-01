<template>
    <el-container>
        <HeaderView />
        <el-container>
            <SideView />
            <el-main>
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
