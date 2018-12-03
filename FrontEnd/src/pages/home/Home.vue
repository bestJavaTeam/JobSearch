<template>
  <div>
    <div class="nav">
      <div class="inner">
        <div class="nav_l">
          <a href="/" class="logo">
            <h1>拉钩网</h1>
          </a>
          <div class="suggestCity">
            <strong>{{currentCity}}</strong>
            <em @click="openDialog">[切换城市]</em>
          </div>
        </div>
        <el-menu :default-active="activeIndex" class="nav_wrap" mode="horizontal" router>
          <el-menu-item index="/"><a>首页</a></el-menu-item>
          <el-menu-item index="/company"><a>公司</a></el-menu-item>
          <el-menu-item index="/school"><a>校园</a></el-menu-item>
          <el-menu-item index="/career"><a>言职</a></el-menu-item>
        </el-menu>
        <div class="nav_r">
          <ul>
            <router-link to="/login" tag="li"><a>登陆</a></router-link>
            <router-link to="/register" tag="li"><a>注册</a></router-link>
          </ul>
        </div>
      </div>
    </div>
    <v-dialog v-show="visible">
      <div class="content">
        <div class="loaded-content">
          <div class="change-city-box">
            <div class="change-city-header">
              <strong>亲爱的用户您好：</strong>
              <p class="tips">切换城市分站，让我们为您提供更准确的职位信息。</p>
            </div>
            <p class="check-tips">
              点击进入
              <a class="tab focus">{{selCity}}</a>
              or 切换到以下城市
            </p>
            <ul class="clearfix">
              <li v-for="(city, index) in cityList" @click="changeCity(city)" :key="index">
                <a class="tab">{{city}}</a>
              </li>
            </ul>
            <p class="change-city-footer">其他城市正在开通中，敬请期待~</p>
          </div>
        </div>
        <div class="title">切换城市</div>
        <button class="close" @click="visible=false">close</button>
      </div>
    </v-dialog>
    <router-view />
    <home-footer></home-footer>
  </div>
</template>

<script>
import HomeFooter from './components/Footer'
import VDialog from './components/Dialog'
export default {
  name: 'Home',
  components: {VDialog, HomeFooter},
  data () {
    return {
      activeIndex: '/',
      currentCity: '全国站',
      selCity: '全国站',
      cityList: ['北京站', '上海站', '杭州站', '广州站', '深圳站', '成都站'],
      visible: false
    }
  },
  watch: {
    selCity: function (val) {
      this.cityList = ['全国站', '北京站', '上海站', '杭州站', '广州站', '深圳站', '成都站']
      for (let i = 0; i < this.cityList.length; i++) {
        if (this.cityList[i] === val) {
          this.cityList.splice(i, 1)
        }
      }
    }
  },
  methods: {
    changeCity (city) {
      this.selCity = city
      this.currentCity = city
      this.visible = false
    },
    openDialog () {
      this.visible = true
    }
  }
}
</script>

<style scoped lang="stylus">
  .nav
    height: 54px
    min-width: 1200px
    border-top: 1px solid #d2d2d2
    border-bottom: 1px solid #e5e5e5
    background-color: #fafafa
    .inner
      width: 1200px
      margin: 0 auto
      .nav_l
        float: left
        width: 260px
        .logo
          color: #555555
          background-color: transparent
          text-decoration: none
          h1
            float: left
            width: 97px
            height: 34px
            margin: 10px 0 0
            padding: 0
            font-weight: 400
            font-size: 2em
            background-image: url("~static/img/logo1.png")
            background-size: 97px 34px
            overflow: hidden
            text-indent: -99em
        .suggestCity
          float: left
          height: 44px
          padding: 10px 0 0 12px
          font-size: 18px
          line-height: 44px
          strong
            margin-right: 8px;
            color: #333
            font-size: 18px
            font-weight: 400
          em
            color: #999
            font-size: 12px
            cursor: pointer
      .nav_wrap
        float: left
        height: 53px
        border-bottom: none
        background-color: #fafafa
        li
          display: inline-block
          margin: 0 16px
          a
            display: block
            font-size: 18px
            color: #999
            line-height: 53px
            padding: 0 5px
      .nav_wrap >>> .el-menu-item
        height: 55px
        &:focus
          background-color: #fafafa
        &:hover
          height: 54px
          background-color: #fafafa
          border-bottom: 2px solid #00b38a!important
          a
            color: #333
      .nav_wrap >>> .is-active
        border-bottom: 2px solid #00b38a
      .nav_wrap >>> .is-active>a
        color: #333
      .nav_r
        ul
          float: right
          li
            position: relative
            float: left
            height: 30px
            a
              color: #c4c3c3
              float: left
              line-height: 53px
              padding: 0 12px
              font-size: 18px

  #dialog
    .content
      position relative
      float left
      width 502px
      height 484px
      .loaded-content
        margin-top 44px
        width 502px
        height 440px
        overflow hidden
        .change-city-box
          width 422px
          padding 30px 40px
          .change-city-header
            border-bottom 1px dotted #e5e5e5
            strong
              font-size 20px
              margin-bottom 10px
              color #333
              font-weight 400
            .tips
              font-size 16px
              color #555
              line-height 42px
              margin 0 0 25px
          .check-tips
            margin 26px 0 14px
          .tab
            display inline-block
            margin 0 12px
            font-size 16px
            width 100px
            height 50px
            color #999
            text-align center
            line-height 50px
            border 1px solid #dce4e6
            border-radius 1px
            cursor pointer
            &.focus
            &:hover
              border 2px solid #00b38a
              color #555
              width 98px
              height 48px
              line-height 48px
          ul
            list-style none
            padding-left 24px
            margin 0
            li
              float left
              width 102px
              margin 11px 12px
          .change-city-footer
            color #777
            font-size 14px
            margin 14px 0 0
      .title
        display block
        float left
        font-size 18px
        color #fff
        background #00b38a
        height 44px
        width 100%
        text-indent 1em
        position absolute
        top 0
        left 0
        line-height 44px
        margin 0
      .close
        position absolute
        top 6px
        right 6px
        background url(//static.lagou.com/www/static/common/components/jquery-colorbox-custom/img/controls_74ddda3.png) no-repeat
        background-position 6px 6px
        width 31px
        height 31px
        text-indent -9999px
        border 0
        padding 0
        margin 0
        overflow visible
        cursor pointer
        &:hover
          background-color: rgba(255,0,0,.8)
</style>
