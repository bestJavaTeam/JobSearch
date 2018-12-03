<template>
  <div id="job-cards">
    <ul class="clearfix">
      <li v-for="(job, index) in jobList" :key="index">
        <div class="top">
          <div class="pli-top-l clearfix">
            <div class="position-name">
              <h2>
                <a class="wordCut" :title="job.jobName">{{job.jobName}}</a>
              </h2>
              <span class="create-time">&nbsp;[{{job.release}}发布]&nbsp;</span>
            </div>
            <span class="salary">{{job.salary}}</span>
          </div>
          <div class="position-main-info wordCut">
            <span>经验{{job.experience}}</span>
            <span>{{job.education}}</span>
          </div>
          <div class="labels">
            <div class="pli-btm-l">
              <span class="wordCut" v-for="(tag, index) in job.tags" :key="index">{{tag}}</span>
            </div>
          </div>
        </div>
        <div class="bottom">
          <a>
            <img :src="job.coverImg" width="40" height="40">
          </a>
          <div class="bottom-right">
            <div class="company-name">
              <a>{{job.companyName}}</a>
            </div>
            <div class="industry wordCut">
              <span>{{job.industry | industryConcat}}</span>
              <span>{{job.financeStage}}</span>
              <span>{{job.site}}</span>
            </div>
          </div>
        </div>
      </li>
    </ul>
    <a class="list-more">查看更多</a>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  name: 'JobCard',
  props: {
    jobList: Array,
    type: String
  },
  filters: {
    industryConcat: function (val) {
      return val.join(',')
    }
  }
}
</script>

<style lang="stylus" scoped>
  #job-cards
    ul
      width 1216px
      margin 0
      padding 0
      list-style none
      li
        float left
        box-sizing border-box
        position relative
        width 389px
        height 200px
        margin 16px 16px 0 0
        padding 20px 18px 0
        border 1px solid #eaeeed
        background-color #fff
        &:hover
          box-shadow 0 0 10px 0 rgba(56, 81, 76, .12)
        .top
          .pli-top-l
            .position-name
              height 22px
              font-size 0
              max-width 290px
              float left
              h2
                display inline-block
                vertical-align middle
                font-size 16px
                padding 0
                margin 0
                color #333
                a
                  max-width 145px
                  float left
                  color #555
                  background-color transparent
                  text-decoration none
                  cursor pointer
                  &:hover
                    color #00b38a
              .create-time
                color #999
                font-size 14px
                display inline-block
                vertical-align middle
            .salary
              font-size 16px
              color #fa6041
              float right
          .position-main-info
            height 30px
            line-height 30px
            color #777
            span:nth-child(2):before
              content ' / '

          .labels
            margin-top 5px
            .pli-btm-l
              margin-right 20px
              height 30px
              line-height 30px
              overflow hidden
              span
                display inline-block
                width 61px
                height 26px
                padding 0 5px
                font-size 12px
                line-height 24px
                color #999
                border 1px solid #f0f0f0
                border-radius 3px
                text-align center
                text-overflow ellipsis
                overflow hidden
                white-space nowrap
                word-wrap normal
                & + span
                  margin-left 6px
        .bottom
          margin-top 18px
          padding-top 18px
          border-top 1px dashed #e0e0e0
          a
            float left
            color #555
            background-color transparent
            text-decoration none
            img
              border 0
              vertical-align top
              display inline-block
              cursor pointer
          .bottom-right
            margin-left 54px
            .company-name
              height 20px
              line-height 20px
              font-size 14px
              color #333
              a
                color #555
                background-color transparent
                text-decoration none
                cursor pointer
                &:hover
                  color #00b38a
            .industry
              height 20px
              line-height 20px
              color #999
              span:nth-child(n+2):before
                content ' / '

    .list-more
      display block
      width 387px
      height 42px
      line-height 42px
      margin 16px auto 0
      background #fff
      border 1px solid #00b38a
      font-size 16px
      color #00b38a
      text-align center
      transition background .3s, color .1s
      text-decoration none
      cursor pointer
      &:hover
        color #fff
        background-color #00b38a

  .wordCut
    text-overflow ellipsis
    overflow hidden
    white-space nowrap
    word-wrap normal
</style>
