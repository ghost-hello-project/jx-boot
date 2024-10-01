import { defineStore } from 'pinia'

import type { AppConfig } from '@/interfaces/app'

const collapseWidth = 64
const expandWidth = 200

const defaultAppConfigStore: AppConfig = {
    side: {
        collapse: false,
        width: expandWidth
    }
}

export const useAppStore = defineStore('appStore', {
    state: () => {
        return defaultAppConfigStore
    },
    getters: {
        getSideCollapse(): boolean {
            return this.side.collapse
        },
        getSideWidth(): string {
            return this.side.width + 'px'
        }
    },
    actions: {
        toggleSideCollapse() {
            console.log('toggleSideCollapse')
            this.side.collapse = !this.side.collapse
            this.side.width = this.side.collapse ? collapseWidth : expandWidth
        }
    }
})
