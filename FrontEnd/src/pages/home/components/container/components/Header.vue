<template>
  <div class="header">
    <div class="search-wrapper">
      <div class="search-box">
        <el-input prefix-icon="el-icon-search" v-model="input" placeholder="搜索职位、公司或地点" class="search_input"></el-input>
        <router-link to="/jobs/list"><el-input type="submit" class="search_btn" value="搜索" /></router-link>
      </div>
      <div class="guess-wrapper"></div>
      <dl class="hot-search">
        <dt>热门搜索：</dt>
        <dd><a href="#" class="highlight" target="_self">java</a></dd>
        <dd><a href="#" class="highlight" target="_self">js</a></dd>
        <dd><a href="#" class="highlight" target="_self">html</a></dd>
        <dd><a href="#" class="highlight" target="_self">c++</a></dd>
        <dd><a href="#" class="highlight" target="_self">php</a></dd>
        <dd><a href="#" class="highlight" target="_self">产品经理</a></dd>
        <dd><a href="#" class="highlight" target="_self">后端开发</a></dd>
      </dl>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ContainerHeader',
  data () {
    return {
      input: ''
    }
  },
  methods: {
    handleSearch () {
      console.log(123)
      this.$router.push('/jobs/list')
    }
  }
}
</script>

<style scoped lang="stylus">
  .header
    position: relative
    .search-wrapper
      background-color: #f2f5f4
      padding: 30px 0 28px
      min-width: 1200px
      .search-box
        border: 0 solid #00b38a
        width: 938px
        height: 46px
        margin: 0 auto
        position: relative
        .search_input
          width: 762px
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
      .hot-search
        width: 938px
        height: 22px
        overflow: hidden
        margin: 6px auto 0
        dt
          float: left
          margin-right: 10px
          font-size: 14px
          color: #777
        dd
          float: left
          margin-right: 20px
          color: #999
          a.highlight
            color: #00b38a
</style>
