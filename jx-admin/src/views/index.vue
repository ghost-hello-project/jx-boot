<template>
    <div class="red">hello world</div>
    <el-button type="primary" @click="sayHello">hello</el-button>
</template>

<script lang="ts">
import { ElMessage } from 'element-plus'
export default {
    setup() {
        const sayHello = () => {
            ElMessage({
                message: 'hello world',
                type: 'success'
            })
            console.log('hello world')
        }
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
