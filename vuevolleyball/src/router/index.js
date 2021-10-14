import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Players from '../views/Players.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: Home,
    },
    {
        path: '/players',
        name: 'Players',
        component: Players
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
