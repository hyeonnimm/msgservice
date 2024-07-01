
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReservationMsgListManager from "./components/listers/ReservationMsgListCards"
import ReservationMsgListDetail from "./components/listers/ReservationMsgListDetail"

import SendMsgManager from "./components/listers/SendMsgCards"
import SendMsgDetail from "./components/listers/SendMsgDetail"

import RaterRateManager from "./components/listers/RaterRateCards"
import RaterRateDetail from "./components/listers/RaterRateDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reservations/msgLists',
                name: 'ReservationMsgListManager',
                component: ReservationMsgListManager
            },
            {
                path: '/reservations/msgLists/:id',
                name: 'ReservationMsgListDetail',
                component: ReservationMsgListDetail
            },

            {
                path: '/sends/msgs',
                name: 'SendMsgManager',
                component: SendMsgManager
            },
            {
                path: '/sends/msgs/:id',
                name: 'SendMsgDetail',
                component: SendMsgDetail
            },

            {
                path: '/raters/rates',
                name: 'RaterRateManager',
                component: RaterRateManager
            },
            {
                path: '/raters/rates/:id',
                name: 'RaterRateDetail',
                component: RaterRateDetail
            },




    ]
})
