<template>
  <div class="box" :style="{height: height}">
    <div class="container clearfix">
      <div class="complete-info">
        <div class="forms">
          <div class="forms__inner" style="width: 5120px; transform: translateX(0px);overflow: hidden;height: 100%;">
            <div class="forms__wrapper" v-show="personPage">
              <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <h2>请填写基本信息</h2>
                <el-upload
                  class="avatar-uploader"
                  :action="uploadUrl()"
                  :show-file-list="false"
                  :on-success="handleAvatarSuccess"
                  :on-error="uploadError"
                  :before-upload="beforeAvatarUpload">
                  <img v-if="imageUrl" :src="imageUrl" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
                <el-form-item label="" prop="name" style="margin-top: 30px;">
                  <el-input v-model="ruleForm.name" placeholder="请输入你的姓名"></el-input>
                </el-form-item>
                <el-form-item prop="birthday" style="margin-top: 30px;">
                  <el-date-picker
                    v-model="ruleForm.birthday"
                    type="date"
                    suffix-icon="el-icon-date"
                    placeholder="请选择出生年月">
                  </el-date-picker>
                </el-form-item>
                <el-form-item prop="sex" style="margin-top: 30px;">
                  <el-radio-group v-model="ruleForm.sex">
                    <el-radio label="男"></el-radio>
                    <el-radio label="女"></el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item prop="city" style="margin-top: 30px;">
                  <el-select v-model="ruleForm.city" placeholder="请选择所在城市">
                    <el-option label="大专" value="大专"></el-option>
                    <el-option label="本科" value="本科"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item prop="career" style="margin-top: 30px;">
                  <el-radio-group v-model="ruleForm.career">
                    <el-radio label="学生"></el-radio>
                    <el-radio label="非学生"></el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-bottom: 30px;">
                  <el-button type="primary" @click="submitForm('ruleForm')">下一步</el-button>
                </el-form-item>
              </el-form>
            </div>
            <div class="forms__wrapper form2" v-show="educationPage">
              <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                <h2>请填写教育经历</h2>
                <el-form-item label="" prop="schoolName" style="margin-top: 30px;">
                  <el-input v-model="ruleForm2.schoolName" placeholder="请输入学校名称"></el-input>
                </el-form-item>
                <el-form-item prop="admissionTime" style="margin-top: 30px;">
                  <el-date-picker
                    v-model="ruleForm2.admissionTime"
                    type="date"
                    placeholder="请选择入学时间">
                  </el-date-picker>
                </el-form-item>
                <el-form-item prop="graduationTime" style="margin-top: 30px;">
                  <el-date-picker
                    v-model="ruleForm2.graduationTime"
                    type="date"
                    placeholder="请选择毕业时间">
                  </el-date-picker>
                </el-form-item>
                <el-form-item label="" prop="major" style="margin-top: 30px;">
                  <el-input v-model="ruleForm2.major" placeholder="请输入所学专业"></el-input>
                </el-form-item>
                <el-form-item prop="education" style="margin-top: 30px;">
                  <el-select v-model="ruleForm2.education" placeholder="请选择学历">
                    <el-option label="大专" value="大专"></el-option>
                    <el-option label="本科" value="本科"></el-option>
                    <el-option label="硕士" value="硕士"></el-option>
                    <el-option label="博士" value="博士"></el-option>
                    <el-option label="其他" value="其他"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item style="margin-bottom: 30px;">
                  <el-button type="primary" @click="showPrev" class="prev">上一步</el-button>
                  <el-button type="primary" @click="submitForm('ruleForm2')" class="next">下一步</el-button>
                </el-form-item>
              </el-form>
            </div>
            <div class="forms__wrapper form3" v-show="cardPage">
              <el-form :model="ruleForm3" :rules="rules3" ref="ruleForm3" label-width="100px" class="demo-ruleForm">
                <h2>完善你的个人名片</h2>
                <div class="basic-info">
                  <img src="//www.lgstatic.com/common/image/pc/default_boy_headpic2.png" class="avator-img">
                  <div class="basic-info__block">
                    <p class="basic-info__name">cxzcz</p>
                    <div class="basic-info__detail">
                      <span>16岁</span>
                      <span> / 男</span>
                      <span> / 北京</span>
                      <span> / 学生</span>
                    </div>
                  </div>
                </div>
                <div class="clearfix"></div>
                <el-form-item  style="margin-top: 30px;">
                  <el-tag
                  :key="tag"
                  v-for="tag in dynamicTags"
                  closable
                  :disable-transitions="false"
                  @close="handleClose(tag)">
                  {{tag}}
                  </el-tag>
                  <el-input
                  class="input-new-tag"
                  v-if="inputVisible"
                  v-model="personTag"
                  ref="saveTagInput"
                  size="small"
                  @keyup.enter.native="handleInputConfirm"
                  @blur="handleInputConfirm"
                  >
                  </el-input>
                  <el-button v-else class="button-new-tag" size="small" @click="showInput">+ 添加你的综合能力标签</el-button>
                </el-form-item>
                <el-form-item style="margin-top: 30px;" prop="desc">
                  <p class="desc">自我描述</p>
                  <el-input type="textarea" v-model="ruleForm3.desc" placeholder="自我描述主要是关于你的能力，特长和成就。你可以通过描述你的岗位来突出你真正擅长的东西。也可以简单的说说你的求职目标。"></el-input>
                </el-form-item>
                <el-form-item style="margin-top: 30px;">
                  <p class="examples_title">示例</p>
                  <div class="examples_box">
                    <div class="examples_example" v-show="showExample1">
                      <div class="examples__title">
                        <img src="https://www.lgstatic.com/common/image/pc/default_girl_headpic3.png">
                        <span>java</span>
                      </div>
                      <p>本人有6年工作经验，意向电商或高并发，责任心非常强，耐力持久，热爱技术，皮实。本人符合程序员特征内敛、灵活、执着。热衷于技术，崇尚科技改变世界。</p>
                    </div>
                    <div class="examples_example" v-show="showExample2">
                      <div class="examples__title">
                        <img src="https://www.lgstatic.com/common/image/pc/default_girl_headpic3.png">
                        <span>web前端</span>
                      </div>
                      <p>有3年以上经验，有带领工作团队经验，积极向上，有良好的人际沟通能力，良好的工作协调能力，踏实肯干的工作精神，不断学习新技术，对知识有强烈的求知欲，良好的前端编程能力和编程习惯，致力于代码的整体结构规范及优化。</p>
                    </div>
                    <div class="examples_example" v-show="showExample3">
                      <div class="examples__title">
                        <img src="https://www.lgstatic.com/common/image/pc/default_girl_headpic3.png">
                        <span>产品经理</span>
                      </div>
                      <p>我是一个拥有3年工作经验的产品经理，我有很强的沟通能力和协调能力，具有一定产品规划能力和user story描绘能力，擅长数据分析和竞品分析。</p>
                    </div>
                    <p class="examples__change" @click="changeExample">换一个</p>
                  </div>
                </el-form-item>
                <el-form-item style="margin-bottom: 30px;">
                  <el-button type="primary" @click="showCardPrev" class="prev">上一步</el-button>
                  <el-button type="primary" @click="submitForm('ruleForm3')" class="next">完成</el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      index: 1,
      height: document.documentElement.clientHeight + 1000 + 'px',
      name: '', // 用户姓名
      imageUrl: '', // 上传图片地址
      birthday: '', // 生日
      sex: '', // 性别
      career: '', // 职业
      email: '', // 邮箱
      city: '', // 用户居住城市
      education: '', // 学历
      major: '', // 专业
      admissionTime: '', // 入学时间
      graduationTime: '', // 毕业时间
      schoolName: '', // 学习名称
      educationPage: false,
      personPage: true,
      cardPage: false,
      dynamicTags: [],
      inputVisible: false,
      personTag: '',
      desc: '',
      showExample1: true,
      showExample2: false,
      showExample3: false,
      ruleForm: {
        name: '',
        birthday: '',
        sex: '',
        city: '',
        email: '',
        career: ''
      },
      ruleForm2: {
        education: '', // 学历
        major: '', // 专业
        admissionTime: '', // 入学时间
        graduationTime: '', // 毕业时间
        schoolName: '' // 学习名称
      },
      ruleForm3: {
        personTag: '', // 能力标签
        desc: '' // 自我描述
      },
      rules: {
        name: [
          { required: true, message: '请填写用户名', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'change' }
        ],
        birthday: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        sex: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        city: [
          { required: true, message: '请选择城市', trigger: 'change' }
        ],
        email: [
          { required: true, message: '请填写邮箱', trigger: 'change' }
        ],
        career: [
          { required: true, message: '请选择你的职业', trigger: 'change' }
        ]
      },
      rules2: {
        schoolName: [
          { required: true, message: '请填写学校名称', trigger: 'change' },
          { min: 4, max: 12, message: '长度在 4 到 12 个字符', trigger: 'blur' }
        ],
        admissionTime: [
          { type: 'date', required: true, message: '请选择入学时间', trigger: 'change' }
        ],
        graduationTime: [
          { type: 'date', required: true, message: '请选择毕业时间', trigger: 'change' }
        ],
        major: [
          { required: true, message: '请输入所学专业', trigger: 'change' }
        ],
        education: [
          { required: true, message: '请选择学历', trigger: 'change' }
        ]
      },
      rules3: {
        personTag: [
          { required: true, message: '请添加你的技能标签', trigger: 'change' }
        ],
        desc: [
          { required: true, message: '请填写一段自我描述', trigger: 'change' }
        ]
      }
    }
  },
  mounted () {
    // window.addEventListener('resize', this.handleResize)
  },
  methods: {
    handleResize () {
      this.height = document.documentElement.clientHeight + 'px'
    },
    uploadUrl () {
      var url = 'http://localhost:8081/#/' // 生产环境和开发环境的判断
      return url
    },
    uploadError () {
      this.$message.error('上传失败，请重新上传')
      // this.showNoticeUploading = false
    },
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid && formName === 'ruleForm') {
          this.personPage = false
          this.educationPage = true
        } else if (valid && formName === 'ruleForm2') {
          this.educationPage = false
          this.cardPage = true
        } else if (valid && formName === 'ruleForm3') {
          this.cardPage = false
          alert('提交成功')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    showPrev () {
      this.educationPage = false
      this.personPage = true
    },
    showCardPrev () {
      this.cardPage = false
      this.educationPage = true
    },
    handleClose (tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1)
    },
    showInput () {
      this.inputVisible = true
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus()
      })
    },
    handleInputConfirm () {
      let personTag = this.personTag
      if (personTag) {
        this.dynamicTags.push(personTag)
        console.log(this.dynamicTags)
      }
      this.inputVisible = false
      this.personTag = ''
    },
    changeExample () {
      switch (this.index) {
        case 1:
          this.showExample1 = false
          this.showExample2 = true
          this.index++
          break
        case 2:
          this.showExample2 = false
          this.showExample3 = true
          this.index++
          break
        default:
          this.showExample1 = true
          this.showExample3 = false
          this.index = 1
          break
      }
    }
  }
}
</script>

<style scoped lang="stylus">
  .box
    width: 100%
    background-color: #00b38a
    .container
      width: 1024px
      height: 100%
      margin: 35px auto 0
      margin-top: 0
      .complete-info
        width: 100%
        height: 100%
        background: #00b38a url(//www.lgstatic.com/www/static/mycenter/modules/complete-info/complete-info/img/mr_basicbg_a44f09a.png) center 0 no-repeat
        overflow: hidden
        .forms
          position: relative
          width: 1024px
          margin: 123px auto 0
          overflow: hidden
          .forms__wrapper
            width: 1024px
            float: left
            form
              position: relative
              width: 540px
              margin: auto
              padding: 36px 49px 20px
              background: #fff
              box-sizing: border-box
              h2
                padding-bottom: 15px
                color: #333
                font-size: 20px
                font-weight: 700
              .avatar-uploader
                position: relative
                cursor: pointer
                width: 100%
                height: 72px
                margin-right: 20px
              .basic-info
                margin-top: 34px
                .avator-img
                  display: block
                  position: relative
                  float: left
                  width: 60px
                  height: 60px
                  margin-right: 20px
                  border: 0
                  vertical-align: top
                .basic-info__block
                  width: 300px
                  float: left
                  .basic-info__name
                    font-size: 18px
                    color: #333
                    font-weight: 600
                    overflow: hidden
                    text-overflow: ellipsis
                    white-space: nowrap
                  .basic-info__detail
                    margin-top: 8px
                    font-size: 14px
                    color: #666
              .desc
                margin-bottom: 7px
                font-size: 14px
                color: #333
                font-weight: 600
              .examples_title
                font-size: 14px
                color: #333
                margin-bottom: 16px
                font-weight: 600
              .examples_box
                .examples__change
                  position: absolute
                  top: 36px
                  right: 0
                  text-align: right
                  font-size: 14px
                  color: #00B38A
                  cursor: pointer
                  &:before
                    content: ''
                    display: inline-block
                    width: 14px
                    height: 14px
                    background: url(//www.lgstatic.com/www/static/mycenter/modules/complete-info/complete-info/img/sprite_6c8d6f4.png) no-repeat
                    background-position: -207px -151px
                    vertical-align: middle
                    padding-right: 4px
                .examples_example
                    margin-bottom: 20px
                    .examples__title
                      width: 100%
                      margin-bottom: 10px
                      line-height: 30px
                      vertical-align: middle
                      img
                        display: inline-block
                        width: 30px
                        height: 30px
                        border-radius: 50%
                        overflow: hidden
                        border: 0
                        vertical-align: top
                      span
                        padding-left: 5px
                        font-size: 14px
                        color: #333
                        font-weight: 600
                    p
                      line-height: normal
            form >>> textarea
              width: 442px
              height: 124px
            form >>> .button-new-tag
              width: 100%
              height: 40px
              margin-top: 30px
              margin-left: 0
              line-height: 40px
              text-align: center
              font-size: 14px
              color: #00b38a
              background: #fff
              border: 1px dashed #00b38a
              border-radius: 3px
              cursor: pointer
            form >>> .el-tag
              margin: 10px 10px 0 0
              padding: 2px 10px
              font-size: 14px
              color: #666
              background: #f7f7f7
              border: 1px solid #f7f7f7
              border-radius: 3px
              display: inline-block
              cursor: pointer
            form >>> .el-form-item__content
              margin-left: 0!important
            form >>> .el-icon-date
              display: none
            form >>> .el-date-editor--date
              width: 100%
            form >>> .el-input__inner
              width: 100%
              height: 46px
              margin-top: 0
              line-height: 100%
              font-size: 14px
              color: #333
              background: #f8f8f8
              border: 1px solid #f8f8f8
              padding: 11px 15px
              padding-right: 20%
              box-sizing: border-box
            form >>> .el-radio
              position: relative
              width: 176px
              height: 44px
              padding: 0 13px 0 17px
              line-height: 46px
              color: #757575
              background: #f8f8f8
              cursor: pointer
              border: none
            form >>> .el-radio__inner
              position: relative
              left: 165px
            form >>> .el-radio__label
              position: relative
              left: -25px
            form >>> .el-cascader
              display: block
            form >>> .el-form-item
              margin-bottom: 0
            form >>> .el-button--primary
              display: block
              width: 100%
              padding: 10px 20px
              font-size: 16px
              text-align: center
              background: #00b38a
              color: #fff
              border-radius: 3px
              margin-top: 40px
              box-sizing: border-box
              cursor: pointer
            form >>> .el-form-item__error
              left: 15px
            form >>> .el-select
              display: block
            .prev
              display: inline-block!important
              width: 100px!important
            .next
              display: inline-block!important
              width: 328px!important
            .el-tag + .el-tag {
              margin-left: 10px;
            }
            .button-new-tag {
              margin-left: 10px;
              height: 32px;
              line-height: 30px;
              padding-top: 0;
              padding-bottom: 0;
            }
            .input-new-tag {
              width: 90px;
              margin-left: 10px;
              vertical-align: bottom;
            }
</style>
