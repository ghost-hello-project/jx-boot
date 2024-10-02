<template>
    <div :class="['taglist-container', appStore.getSideCollapse ? 'collapse' : 'expand']">
        <div :class="['tab-wrapper', appStore.getSideCollapse ? 'collapse' : 'expand']">
            <el-tabs v-model="activeTab" type="card" class="demo-tabs" style="min-width: 100px;"
                @tab-click="handleTabClick" @tab-remove="handleTabRemove">
                <el-tab-pane :closable="item.path != '/'" v-for="item in tabList" :key="item.path" :label="item.title"
                    :name="item.path" />
            </el-tabs>
        </div>
        <div class="dropdown-wrapper">
            <el-dropdown @command="handleDropDownClick">
                <span class="el-dropdown-link">
                    <el-icon class="el-icon--right">
                        <arrow-down />
                    </el-icon>
                </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item :command="dropDownCommandCloseOther">关闭其他</el-dropdown-item>
                        <el-dropdown-item :command="dropDownCommandCloseAll">全部关闭</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script lang="ts">
import { useAppStore } from '@/stores/appStore'
import { ref, onMounted, watch } from 'vue'
import { useRoute } from 'vue-router'
import type { AppTab } from '@/interfaces/app'
import { useCookies } from '@vueuse/integrations/useCookies'
import type { TabPaneName, TabsPaneContext } from 'element-plus'
import router from '@/router'
export default {
    setup() {
        const appStore = useAppStore()
        const route = useRoute()
        const cookie = useCookies()


        // 当前激活的 tab
        const activeTab = ref<string>('')

        // 默认的 tab 列表
        const defaultTabList: Array<AppTab> = [
            {
                title: '首页',
                path: '/'
            }
        ]
        // tab 列表
        const tabList = ref<Array<AppTab>>(defaultTabList)

        /**
         * tab 列表 cookie 操作
         */
        const tabCookie = {
            tabListKey: 'tabList',
            updateTabList: (tabList: Array<AppTab>) => {
                cookie.remove(tabCookie.tabListKey)
                cookie.set(tabCookie.tabListKey, tabList)
            },

            getTabList: (): Array<AppTab> => {
                return cookie.get(tabCookie.tabListKey)
            }
        }

        /**
         * tab 点击
         */
        const handleTabClick = (tab: TabsPaneContext) => {
            router.push(tab.props.name as string)
        }

        /**
         * 移除 tab
         */
        const handleTabRemove = (closeTab: TabPaneName) => {
            // 切换 tab
            let tabs = tabList.value
            let actiTab = activeTab.value
            if (closeTab == actiTab) {
                tabs.forEach((tab, index) => {
                    if (tab.path == closeTab) {
                        actiTab = (tabs[index - 1] || tabs[0]).path
                        router.push(actiTab)
                    }
                })
            }
            activeTab.value = actiTab

            // 删除关闭的 tab
            tabList.value = tabList.value.filter((tab) => tab.path != closeTab)
            tabCookie.updateTabList(tabList.value)
        }

        const dropDownCommandCloseAll = 'closeAll'
        const dropDownCommandCloseOther = 'closeOther'
        const dropDownHandleMap: { [key: string]: () => void } = {
            closeAll: () => {
                activeTab.value = '/'
                router.push('/')
                tabList.value = defaultTabList
            },
            closeOther: () => {
                tabList.value = tabList.value.filter((tab) => tab.path == '/' || tab.path == activeTab.value)
            },
        }
        /**
         * 下拉菜单点击
         */
        const handleDropDownClick = (cmd: any) => {
            const handle = dropDownHandleMap[cmd]
            handle()
            tabCookie.updateTabList(tabList.value)
        }

        /**
         * 路由变化时,切换 tab
         */
        const handleWatchAddTab = (tab: AppTab) => {
            const noTab = tabList.value.findIndex(e => e.path == tab.path) == -1
            if (noTab) {
                tabList.value.push(tab)
            }
            activeTab.value = tab.path
            tabCookie.updateTabList(tabList.value)
        }
        watch(() => route.path, (newPath) => {
            handleWatchAddTab({ title: route.meta.title as string, path: newPath })
        })

        onMounted(() => {
            activeTab.value = route.path
            const list = cookie.get('tabList')

            if (!list) {
                tabList.value = defaultTabList
            } else {
                tabList.value = list
            }

        })
        return {
            activeTab,
            tabList,
            appStore,
            handleTabClick,
            handleTabRemove,
            handleDropDownClick,
            dropDownCommandCloseAll,
            dropDownCommandCloseOther
        }
    }
}
</script>

<style scoped lang="scss">
.taglist-container {
    display: flex;
    height: 35px;

    &.collapse {
        width: calc(100vw - 64px);
    }

    &.expand {
        width: calc(100vw - 200px);
    }

    .tab-wrapper {
        &.collapse {
            width: calc(100vw - 64px - 35px);
        }

        &.expand {
            width: calc(100vw - 200px - 35px);
        }
    }

    .dropdown-wrapper {
        width: 35px;
        display: flex;
        align-items: center;
        border-bottom: 1px solid #e4e7ed;
    }
}

:deep(.el-tabs__content) {
    display: none;
}

:deep(.el-tabs__header) {
    height: 35px;
    margin: 0;
}

:deep(.el-tabs__item) {
    height: 35px;
    font-size: 12px;
}

:deep(.is-disabled) {
    cursor: not-allowed;
}

:deep(.el-dropdown) {
    outline: none;
}

:deep(.el-dropdown-link) {
    outline: none;
}
</style>