import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { createPinia } from 'pinia'

import 'nprogress/nprogress.css'

import App from './App.vue'
import router from './router'
import './permission'

const app = createApp(App)

app.use(ElementPlus)
app.use(router)
app.use(createPinia()).mount('#app')
// app.mount('#app')
