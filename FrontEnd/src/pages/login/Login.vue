<template>
  <div class="box" :style="{height: height}">
    <div class="header">
      <a href="/" class="logo"></a>
    </div>
    <div class="content_box">
      <div class="left_area fl">
        <div class="form_content">
          <div class="form_head">
            <ul class="form_head clearfix">
              <li class="active">邮箱登陆</li>
            </ul>
            <span class="tab_active"></span>
          </div>
          <div class="form_body">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" style="margin-top: 40px;">
              <el-form-item label="" prop="email">
                <el-input v-model="ruleForm.email" placeholder="请输入邮箱"></el-input>
              </el-form-item>
              <el-form-item label="" prop="password" style="margin-top: 40px;">
                <el-input v-model="ruleForm.password" placeholder="请输入密码" type="password"></el-input>
              </el-form-item>
              <div style="margin-top: 40px;">
                <a href="/" class="forgot_pwd">忘记密码？</a>
              </div>
              <el-form-item style="margin-top: 80px;">
                <el-button type="primary" @click="submitForm('ruleForm')">登陆</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
      <div class="divider fl"></div>
      <div class="right_area fl">
        <h5>还没有账号：</h5>
        <router-link to="/register"><a class="register_now">立即注册</a></router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      height: document.documentElement.clientHeight + 'px',
      ruleForm: {
        email: '',
        password: ''
      },
      rules: {
        email: [
          { required: true, message: '请输入已验证邮箱', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  mounted () {
    window.addEventListener('resize', this.handleResize)
  },
  methods: {
    handleResize () {
      this.height = document.documentElement.clientHeight + 'px'
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
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
      position: relative;
      z-index: 1;
      width: 552px
      margin: -205px auto 60px
      padding: 62px 70px 68px 78px
      background-color: #fff
      display: table
      -webkit-border-radius: 2px
      -moz-border-radius: 2px
      border-radius: 2px
      border: 1px solid #dce1e6
      .left_area
        width: 290px
        .form_head
          position: relative
          z-index: 1
          height: 33px
          margin-bottom: 29px
          border-bottom: 1px solid #ebebeb
          ul
            li
              font-size: 16px
              line-height: 24px
              position: relative
              float: left
              width: 50%
              height: 33px
              cursor: pointer
              text-align: center
              color: #333
            li.active
              color: #00b38a
          .tab_active
            position: absolute
            left: 0
            bottom: -1px
            z-index: 1
            background-color: #00b38a
            width: 150px
            height: 1px
            &:before,&:after
              position: absolute
              z-index: 2
              top: -12px
              left: 50%
              margin-left: -3px
              content: ""
              width: 0
              height: 0
              line-height: 0
              border: 6px solid transparent
              border-bottom-color: #007b5f
            &:after
              z-index: 3
              top: -11px
              width: 0
              height: 0
              line-height: 0
              border: 6px solid transparent
              border-bottom-color: #fff
        .form_body >>> .el-form-item__content
          margin-left: 0!important
        .form_body >>> .el-form-item__error
          left: 5px
        .form_body >>> .el-input__inner
          padding: 0 5px
        .form_body >>> .el-button
          display: block
          width: 100%
          font-size: 18px
          height: 46px
          color: #fff
          border-color: #00b38a
          background-color: #00b38a
        .form_body >>> input
          border-left: 0
          border-top: 0
          border-right: 0
          border-color: #ededed
          background: 0 0
        .form_body .forgot_pwd
          position: relative
          right: 5px
          float: right
          font-size: 14px
          display: block
          text-align: right
          text-decoration: none
          color: #00b38a
          margin-top: -5px
          z-index: 3
      .divider
        position: relative
        border-left: 1px dashed #ededed
        height: 274px
        color: #d8d8d8
        margin: 0 52px
        &:after
          position: absolute
          content: "or"
          left: 50%
          top: 50%
          padding: 2px
          background-color: #fff
          -webkit-transform: translate(-50%,-50%)
          -ms-transform: translate(-50%,-50%)
          -o-transform: translate(-50%,-50%)
          transform: translate(-50%,-50%)
      .right_area
        display: block
        width: 150px
        padding-top: 26px
        color: #777
        h5
          margin: 44px 0 8px
          color: #555
          font-size: 14px
        .register_now
          display: inline-block
          height: 22px
          font-size: 16px
          color: #00b38a
          padding-right: 23px
          background: url(//www.lgstatic.com/passport/static/pc/modules/common/img/icon-arrow-right_ea91505.png) right center no-repeat
      .fl
        float: left
</style>
