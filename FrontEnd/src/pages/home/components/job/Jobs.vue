<template>
  <div class="content-container">
    <div class="search-wrapper">
      <div class="search-bar">
        <div class="tab-wrapper">
          <a href="javascript:;" class="active">职位 ( <span>500+</span> ) </a>
        </div>
        <div class="input-wrapper">
          <div class="search-box">
            <el-input prefix-icon="el-icon-search" v-model="input" placeholder="搜索职位、公司或地点" class="search_input"></el-input>
            <el-input type="submit" class="search_btn" value="搜索" />
          </div>
        </div>
      </div>
    </div>
    <div class="main_container">
      <div class="job-list-container">
        <div class="position-head">
          <filter-box></filter-box>
          <ul class="sub-filter">
            <li class="wrapper clearfix">
              <div class="item order">
                <span class="title">排序方式</span>
                <a v-for="(o, index) in orders" :key="index">{{o}}</a>
              </div>
              <div class="item order">
                <span class="title">月薪</span>
                <select v-model="selectedOption1">
                  <option v-for="(s, index) in salaries" :value="s" :key="index">{{s}}</option>
                </select>
              </div>
              <div class="item order">
                <span class="title">工作性质</span>
                <select v-model="selectedOption2">
                  <option v-for="(w, index) in works" :value="w" :key="index">{{w}}</option>
                </select>
              </div>
            </li>
          </ul>
        </div>
        <div class="s_position_list ">
          <ul class="item_con_list">
            <li class="con_list_item first_row default_list" v-for="job of jobList" :key="job.jobId">
              <div class="list_item_top">
                <div class="position">
                  <div class="p_top">
                    <a href="#" class="position_link">
                      <h3 style="max-width: 180px;">{{job.jobName}}</h3>
                      <span class="add">[<em>{{job.site}}</em>]</span>
                    </a>
                    <span class="format-time">{{job.release}}发布</span>
                    <div class="chat_me"></div>
                  </div>
                  <div class="p_bot">
                    <div class="li_b_l">
                      <span class="money">2k-3k</span>经验{{job.experience}}
                    </div>
                  </div>
                </div>
                <div class="company">
                  <div class="company_name">
                    <a href="#">{{job.companyName}}</a>
                    <i class="company_mark"></i>
                  </div>
                  <div class="industry">
                    {{job.industry}} / {{job.financeStage}} / {{job.companySize}}人
                  </div>
                </div>
                <div class="com_logo">
                  <a href="#">
                    <img src="//www.lgstatic.com/thumbnail_120x120/i/image/M00/7B/5B/CgqKkVhCakCAbmTuAACSBtj-neg91.jpeg" alt="金贝塔" width="60" height="60">
                  </a>
                </div>
              </div>
              <div class="list_item_bot">
                <div class="li_b_l">
                  <span v-for="(tag, index) of job.tags" :key="index">{{tag}}</span>
                </div>
                <div class="li_b_r">“{{job.desc}}”</div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import FilterBox from './FilterBox'
export default {
  name: 'Jobs',
  components: {FilterBox},
  data () {
    return {
      selectedOption1: '不限',
      selectedOption2: '不限',
      input: '',
      salary: '',
      orders: ['默认', '最新'],
      salaries: ['不限', '2k以下', '2k-5k', '10k-15k', '15k-20k', '20k-50k', '50k以上'],
      works: ['不限', '全职', '兼职', '实习'],
      jobList: [
        {
          jobId: '001', // 工作编号
          jobName: '产品实习生', // 工作名
          companyName: '金贝塔', // 公司名字
          companyId: '001', // 公司编号
          site: '深圳·科技园', // 公司地点
          salary: '2k-3k', // 薪资
          release: '14:54', // 工作发布日期
          experience: '应届毕业生 / 本科', // 工作经验要求
          financeStage: 'A轮', // 融资阶段
          companySize: '50-150', // 公司人数规模
          industry: '移动互联网,金融', // 行业领域
          tags: [
            '交互设计',
            '金融',
            '产品设计',
            '产品策划'
          ], // 工作标签
          desc: '学到东西,玩得开心,交到朋友' // 公司。。。
        }
      ]
    }
  },
  watch: {
    selectedOption1 (val) {
      this.selectedOption1 = val
      console.log(this.selectedOption1)
    },
    selectedOption2 (val) {
      this.selectedOption2 = val
      console.log(this.selectedOption2)
    }
  },
  mounted () {
    console.log(this.selectedOption1)
    console.log(this.selectedOption2)
  },
  methods: {
  }
}
</script>

<style scoped lang="stylus">
.content-container
  .search-wrapper
    margin: 0 auto 35px
    height: 156px
    background-color: #f2f5f4
    font-size: 16px
    line-height: 16px
    .search-bar
      margin: 0 auto
      padding-top: 30px
      width: 1200px
      .tab-wrapper
        margin-bottom: 13px
        a.active
          display: inline-block
          margin-right: 7px
          padding: 7px 10px
          -webkit-border-radius: 2px
          -moz-border-radius: 2px
          border-radius: 2px;
          -moz-background-clip: padding
          -webkit-background-clip: padding-box
          background-clip: padding-box
          background-color: #00b38a
          color: #fff
      .input-wrapper
        .search-box
          border: 0 solid #00b38a
          width: 958px
          height: 46px
          position: relative
          .search_input
            width: 816px
            line-height: 20px
            float: left
            margin: 0
          .search_input >>> input
            height: 46px
            font-size: 16px
            border: 1px solid #E8E8E8
            border-right: 0
            &:focus
              border: 1px solid #00b38a
              border-right: 0
          .search_input >>> .el-input__inner
            border-radius: 0
          .search_btn
            float: left
            width: 142px
          .search_btn >>> input
            height: 46px
            background-color: #00b38a
            color: #FFF
            border: 0
            text-align: center
            font-size: 18px
            cursor: pointer
            &:hover
              background-color: #00a57f
          .search_btn >>> .el-input__inner
            border-radius: 0
  .main_container
    width: 958px
    margin-left: 352px
    .job-list-container
      padding-bottom: 100px
      .position-head
        margin-bottom 20px
        .sub-filter
          position relative
          margin-top 13px
          background-color #fafafa
          border 1px solid #ededed
          .wrapper
            zoom 1
            color #555
            font-size 14px
            .order >>> .el-select
              width: 87px
            .order >>> .el-input__inner
              height: 27px
            .order >>> .el-input__suffix
              top: 6px
            .order >>> .is-reverse
              position: relative
              top: -12px!important
            .item
              float left
              padding 10px 0
              height 23px
              line-height 23px
              &.order
                margin-right 35px
                padding-left 16px
                span
                a
                  float left
                  margin-right 5px
                  padding 5px 8px
                  height 14px
                  line-height 14px
                a
                  cursor pointer
                  &:hover
                    background-color #00b38a
                    color #fff
              .title
                margin-right -5px
                font-weight 600
              select
                width: 80px
                border: 1px solid #f3f3f3
                background-color: #fff
                color: #555
              &.page
                float right
                width 114px
                margin-right 18px
                text-align right
                cursor default
                .icon
                  display inline-block
                  vertical-align middle
                  margin -3px 3px 0
                  width 18px
                  height 15px
                  background-image url(//static.lagou.com/www/static/company-list/modules/order/img/check_f5603cd.png?__sprite)
                  background-repeat no-repeat
                  &.checked
                    background-position -18px top
      .s_position_list
        .item_con_list
          .con_list_item
            position: relative
            color: #555
            border: 1px solid #ededed
            margin-top: 18px
            .list_item_top
              width: 928px
              height: 68px
              padding: 14px 15px 0
              .position
                float: left
                width: 528px
                margin-right: 20px
                .p_top
                  height: 34px
                  line-height: 34px
                  h3
                    float: left
                    max-width: 272px
                    margin: 0
                    font-size: 16px
                    color: #00b38a
                    overflow: hidden
                    text-overflow: ellipsis
                    white-space: nowrap
                    word-wrap: normal
                  span
                    float: left
                    margin: 0 3px
                    color: #999
                  span.add
                    font-size: 16px
                    color: #00b38a
                  .chat_me
                    display: inline-block
                    position: relative
                    width: 25px
                    height: 25px
                    background: url(//www.lgstatic.com/www/static/search-result/modules/positions/img/icon-chat_4a70ffc.png) no-repeat 0 0
                    cursor: pointer
                    margin-left: 2px
                .p_bot
                  height: 24px
                  line-height: 24px
                  .li_b_l
                    font-size: 14px
                    color: #555
                    overflow: hidden
                    text-overflow: ellipsis
                    white-space: nowrap
                    word-wrap: normal
                    .money
                      margin-right: 1em
                      font-size: 16px
                      color: #fd5f39
              .company
                float: left
                width: 303px
                margin-right: 15px
                .company_name
                  height: 34px
                  line-height: 34px
                  a
                    display: inline-block
                    max-width: 180px
                    overflow: hidden
                    text-overflow: ellipsis
                    white-space: nowrap
                    word-wrap: normal
                    color: #00b38a
                    font-size: 16px
                    vertical-align: middle
                  .company_mark
                    position: relative
                    display: inline-block
                    width: 16px
                    height: 18px
                    margin-left: .5em
                    background: url(//www.lgstatic.com/www/static/search-result/modules/positions/img/approve_aae725a.png) no-repeat 0 0
                    vertical-align: middle
                    cursor: pointer
                .industry
                  height: 24px
                  line-height: 24px
                  overflow: hidden
                  text-overflow: ellipsis
                  white-space: nowrap
                  word-wrap: normal
              .com_logo
                float: left
                width: 62px
                a
                  display: block
                  img
                    display: block
                    width: 60px
                    height: 60px
                    border: 1px solid #f5f5f5
                    vertical-align: top
            .list_item_bot
              width: 928px
              height: 40px
              padding: 0 15px
              background-color: #fafafa
              .li_b_l
                float: left
                width: 528px
                height: 40px
                margin-right: 20px
                line-height: 40px
                overflow: hidden
                span
                  display: inline-block
                  max-width: 108px
                  height: 20px
                  padding: 0 5px
                  font-size: 12px
                  line-height: 20px
                  color: #555
                  border: 1px solid #dcdcdc
                  border-radius: 3px
                  vertical-align: middle
                  overflow: hidden
                  text-overflow: ellipsis
                  white-space: nowrap
                  word-wrap: normal
              .li_b_r
                float: left
                width: 380px
                height: 40px
                line-height: 40px
                overflow: hidden
                text-overflow: ellipsis
                white-space: nowrap
                word-wrap: normal
</style>
