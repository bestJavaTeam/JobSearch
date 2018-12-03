<template>
  <div class="box" :style="{height: height}">
    <div class="header">
      <a href="/" class="logo"></a>
    </div>
    <div class="content_box clearfix">
      <div class="register_type worker fl">
        <h3>找工作</h3>
        <h4>专注互联网职业机会</h4>
        <div class="worker_image"></div>
        <div class="btn_group">
          <router-link to="/register/form1">去找工作</router-link>
        </div>
      </div>
      <div class="divider fl"></div>
      <div class="register_type hr fl">
        <h3>招人</h3>
        <h4>互联网都在拉钩</h4>
        <div class="hr_image"></div>
        <div class="btn_group">
          <router-link to="/register/form2">去发布职位</router-link>
        </div>
      </div>
    </div>
    <div class="footer">
      <p>已有帐号，请<router-link to="/login"><a>登陆</a></router-link></p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      height: document.documentElement.clientHeight + 'px'
    }
  },
  mounted () {
    window.addEventListener('resize', this.handleResize)
  },
  methods: {
    handleResize () {
      this.height = document.documentElement.clientHeight + 'px'
    }
  }
}
</script>

<style scoped lang="stylus">
  .box
    min-width: 1024px
    min-height: 100%
    background-color: #f8f9fc
    .header
      position: relative
      width: 100%
      height: 360px
      background-color: #00b38a
      .logo
        position: absolute
        z-index: 9999
        top: 76px
        left: 50%
        margin-left: -350px
        width: 112px
        height: 42px
        background: url(//www.lgstatic.com/passport/static/pc/modules/common/img/logo_e420e46.png) no-repeat
        background-size: contain
    .content_box
      position: relative
      z-index: 1
      margin: -205px auto 0 auto
      padding: 52px 72px 42px
      background-color: #fff
      border: 1px solid #dce1e6
      text-align: center
      -webkit-border-radius: 2px
      -moz-border-radius: 2px
      border-radius: 2px
      display: table
      .register_type
        width: 258px
        h3
          font-size: 24px
          color: #333
          margin: 10px 0
          font-weight: 400
        h4
          font-size: 14px
          color: #999
          margin: 10px 0
          font-weight: 400
        .worker_image
          width: 232px
          height: 172px
          background: url("~static/img/worker.png") no-repeat
          background-size: contain
          margin: 44px 0 0 28px
        .hr_image
          width: 212px
          height: 179px
          background: url("~static/img/hr.png") no-repeat
          background-size: contain
          margin: 37px 0 0 15px
        .btn_group
          margin-top: 36px
          text-align: center
          a
            display: inline-block
            width: 178px
            height: 38px
            border: 1px solid #00b38a
            text-decoration: none
            line-height: 40px
            color: #00b38a
            font-size: 16px
            border-radius: 3px
            &:hover
              color: #fff
              background: #00b38a
      .divider
        position: relative
        border-left: 1px dashed #ededed
        height: 402px
        color: #d8d8d8
        margin: 0 70px
      .fl
        float: left
    .footer
      text-align: center
      margin: 27px 0 60px
      font-size: 16px
      color: #777
      p
        margin: 0
        a
          color: #00b38a
          text-decoration: none
</style>
