import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/home/Home'
import Container from '@/pages/home/components/container/Container'
import Login from '@/pages/home/Login'
import MyResume from '@/pages/home/MyResume'
import Register from '@/pages/home/Register'
import Reg1 from '@/pages/home/Reg1'
import Reg2 from '@/pages/home/Reg2'
import Jobs from '@/pages/home/Jobs'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: Home,
      children: [
        {
          path: '',
          component: Container
        },
        {
          path: '/jobs/list',
          component: Jobs
        },
        {
          path: 'school',
          component: Jobs
        },
        {
          path: 'career',
          component: Jobs
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/register/form1',
      component: Reg1
    },
    {
      path: '/register/form2',
      component: Reg2
    },
    {
      path: '/myResume',
      component: MyResume
    }
  ]
})
