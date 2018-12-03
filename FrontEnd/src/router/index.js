import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/home/Home'
import Container from '@/pages/home/components/container/Container'
import Login from '@/pages/login/Login'
import MyResume from '@/pages/resume/MyResume'
import Register from '@/pages/register/Register'
import Reg1 from '@/pages/register/Reg1'
import Reg2 from '@/pages/register/Reg2'
import Jobs from '@/pages/home/components/job/Jobs'
import Company from '@/pages/home/components/company/Company'

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
          path: '/company',
          component: Company
        },
        {
          path: 'school'
        },
        {
          path: 'career'
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
