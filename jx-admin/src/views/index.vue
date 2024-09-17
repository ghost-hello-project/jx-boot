<template>
    <div class="red">hello world</div>
    <el-button type="primary" @click="sayHello">hello</el-button>
</template>

<script lang="ts">
import { useAuthStore } from '@/stores/authStore';
import { ElMessage } from 'element-plus';
import { onMounted } from 'vue';
import authApi from '@/api/auth'
export default {
    setup() {
        const authStore = useAuthStore()

        const sayHello = async () => {
            ElMessage({
                message: 'hello world',
                type: 'success'
            })
            console.log('hello world')
            const res = await authApi.userInfo()
            console.log(res.data.body)
        }

        onMounted(async () => {
            await authStore.getUserInfo()
        })
        return {
            sayHello
        }
    }
}
</script>

<style lang="scss">
.red {
    color: $baseColor;
}
</style>
