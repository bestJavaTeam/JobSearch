<template>
    <div class="footer">
      <a class="backtop" title="回到顶部" style="bottom: 156px; display: inline;" @click="backTop" v-if="currentHeight"></a>
      <div class="wrapper">
        <div class="inner_wrapper">
          <div class="footer_module_column"></div>
          <div class="footer_module_right">
            <div class="footer_module_business">
              <p class="footer_module_title">企业服务</p>
              <a href="#">招聘抢人宝典</a>
              <a href="#">公司搜索</a>
              <a href="#">职位搜索</a>
            </div>
            <div class="footer_module_business">
              <p class="footer_module_title">用户帮助</p>
              <a href="#">帮助中心</a>
              <a href="#">用户服务协议</a>
              <a href="#">隐私政策</a>
              <a href="#">在线提问</a>
            </div>
            <div class="footer_module_business">
              <p class="footer_module_title">联系方式</p>
              <span class="tel">服务热线：<em>4006 2828 35 (9:00 -18:00)</em></span>
              <a href="#" class="tel">企业服务邮箱：<em>cc@lagou.com</em></a>
              <a href="#">联系我们</a>
            </div>
          </div>
        </div>
        <div class="copyright">
          <div class="copyright_main">
            <div class="copyright_main_left">
              <span class="copyright_title">
                <em>©</em>2018 拉勾网
              </span>
              <a href="#">京ICP备14023790号-2</a>
              <a href="#" class="footer_gongan"><i class="footer__gongan"></i>京公网安备 11010802024043号</a>
              <div class="footer_jubao">
                <i class="jubao"></i>
                <p>
                  <span>违法和不良信息举报</span>
                  <span>电话: 4006 2828 35</span>
                  <span>邮箱: cc@lagou.com</span>
                </p>
              </div>
            </div>
            <i class="footer_icon"></i>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: 'HomeFooter',
  data () {
    return {
      currentHeight: 0
    }
  },
  created () {
    window.addEventListener('scroll', this.handleScroll)
  },
  methods: {
    backTop () {
      this.currentHeight = 0
      document.body.scrollTop = this.currentHeight
      document.documentElement.scrollTop = this.currentHeight
    },
    handleScroll (e) {
      this.currentHeight = e.target.body.scrollTop || e.target.documentElement.scrollTop
    }
  }
}
</script>

<style scoped lang="stylus">
.footer
  background-color: #fff
  clear: both
  border-top: 1px solid #ebebeb
  position: relative
  z-index: 1001
  .backtop
    display: none;
    margin-left: 631px
    background: url("~static/img/backtop.png") left top no-repeat
    width: 28px
    height: 46px
    position: fixed
    left: 50%
    bottom: 88px
    cursor: pointer
    z-index: 1002
    &:hover
      background-position: right top!important
  .wrapper
    margin: 0 auto
    position: relative
    .inner_wrapper
      width: 1200px
      max-width: 1200px
      margin: 49px auto 66px
      white-space: nowrap
      display: flex
      .footer_module_right
        margin-left: 130px
        display: flex
        flex: 1
        justify-content: space-between
        .footer_module_business
          .footer_module_title
            font-size: 18px
            font-weight: 600
            color: #555
            margin-bottom: 30px
          a,span.tel
            color: #555
            font-size: 14px
            text-decoration: none
          a,span
            display: block
            margin-bottom: 10px
            span em
              font-size: 14px
              font-style: normal
          a:last-of-type
            margin-bottom: 0
    .copyright
      clear: both
      margin: 0 auto
      color: #999
      font-size: 14px
      line-height: 12px
      text-align: center
      background: #FAFAFA
      height: 100px
      overflow: hidden
      .copyright_main
        width: 1200px
        max-width: 1200px
        margin: 28px auto
        display: flex
        align-items: center
        justify-content: space-between
        .copyright_main_left
          display: flex
          align-items: center
          .copyright_title
            margin-right: 5px
            em
              font-size: 14px
              font-style: normal
              font-family: Arial
          a
            padding-right: 0
            font-size: 14px
            color: #999
          .footer_gongan
            margin: 0 0 0 20px
            display: flex
            align-items: center
            .footer__gongan
              display: inline-block
              width: 16px
              height: 16px
              background: url("~static/img/sprite.png") -150px -184px no-repeat
              margin: 0 5px 0 0
          .footer_jubao
            margin: 0 0 0 20px
            border: 1px solid #D5DADF
            display: flex
            align-items: center
            padding: 8px 20px
            .jubao
              display: inline-block
              width: 20px
              height: 24px
              background: url("~static/img/sprite.png") -132px -20px no-repeat
              margin: 0 10px 0 0
            p
              text-align: left
              span
                display: block
                line-height: 14px
                font-size: 12px
                color: #999
        .footer_icon
          display: inline-block
          width: 198px
          height: 19px
          background: url("~static/img/footer_icon.png") 0 0 no-repeat
</style>
