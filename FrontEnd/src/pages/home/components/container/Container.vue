<template>
  <div class="container clearfix  has-login-toolbar">
    <container-header></container-header>
    <div class="container-body">
      <div class="clearfix">
        <carousel :carousels="carousels"></carousel>
        <tab-bar :tabList="jobTabs"></tab-bar>
        <job-card :jobList="jobList"></job-card>
        <tab-bar :tabList="companyTabs"></tab-bar>
        <company-card :companyList="companyList" type="more"></company-card>
      </div>
    </div>
  </div>
</template>

<script>
import ContainerHeader from './components/Header'
import Carousel from './components/Carousel'
import JobCard from './components/JobCard'
import CompanyCard from './components/CompanyCard'
import TabBar from './components/TabBar'
import axios from 'axios'
export default {
  name: 'Container',
  components: {JobCard, Carousel, ContainerHeader, TabBar, CompanyCard},
  data () {
    return {
      carousels: [],
      jobTabs: ['推荐职位', '热门职位', '最新职位'],
      jobList: [],
      companyTabs: ['热门公司'],
      companyList: []
    }
  },
  mounted () {
    this.getHomeInfo()
  },
  methods: {
    getHomeInfo () {
      axios.get('/api/index.json')
        .then(this.getHomeInfoSucc)
    },
    getHomeInfoSucc (res) {
      res = res.data
      if (res.status === 'success' && res.data) {
        const data = res.data
        this.carousels = data.carousels
        this.jobList = data.jobList
        this.companyList = data.companyList
      }
    }
  }
}
</script>

<style scoped lang="stylus">
.container.has-login-toolbar
  padding-bottom: 91px
  .container-body
    margin: 26px auto 0
    width: 1200px
</style>
