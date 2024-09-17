import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  // sass 全局变量引入
  css:{
    preprocessorOptions:{
      scss:{
        additionalData: '@import "@/style/global.scss";'
      }
    }
  }
})
