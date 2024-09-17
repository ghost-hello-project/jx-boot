import { useCookies } from '@vueuse/integrations/useCookies'
const cookie = useCookies()
const system_token_name = 'platform_token'
const channel_type_name = 'platform_channel_type'

export default {
    getToken() {
        return cookie.get(system_token_name)
    },
    setToken(token: string) {
        cookie.set(system_token_name, token)
    },
    removeToken() {
        cookie.remove(system_token_name)
    },
    getChannelType() {
        return cookie.get(channel_type_name)
    },
    setChannelType(type: string) {
        cookie.set(channel_type_name, type)
    }
}
