import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Players from '@/components/Players.vue'
import Teams from "@/components/Teams";

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
    },
    {
        path: '/teams',
        name: 'Teams',
        component: Teams
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
