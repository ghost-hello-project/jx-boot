import { fileURLToPath, URL } from 'node:url'

import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import { viteMockServe } from 'vite-plugin-mock'

// https://vitejs.dev/config/
export default defineConfig(({ mode }) => {
    const env = loadEnv(mode, process.cwd())
    console.log(mode)
    console.log(env)
    const plugins = [vue()]
    if ('mock' === mode) {
        plugins.push(
            viteMockServe({
                logger: true,
                mockPath: './src/mock/'
            })
        )
    }
    return {
        plugins: plugins,
        resolve: {
            alias: {
                '@': fileURLToPath(new URL('./src', import.meta.url))
            }
        },

        server: {
            port: 7001,
            proxy: {
                '/api': {
                    target: env.VITE_API_BASE_URL,
                    changeOrigin: true,
                    rewrite: (path) => path.replace(/^\/api/, '')
                }
            }
        },

        css: {
            preprocessorOptions: {
                scss: {
                    additionalData: '@import "@/assets/style/global.scss";'
                }
            }
        }
    }
})
