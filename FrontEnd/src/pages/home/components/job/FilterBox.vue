<template>
  <ul id="filter-box">
    <div class="details">
      <div class="has-more workcity">
        <li class="clearfix">
          <span class="title">公司地点：</span>
          <div class="city-wrapper">
            <a v-for="(site, index) in sites" :class="{active:site===selSite}" @click="choseSite(site)" :key="index">{{site}}</a>
          </div>
          <a class="btn-more" @mouseover="_inSiteHandler">更多&nbsp;<i></i></a>
        </li>
        <div v-show="showMoreSite" class="more more-position" @mouseleave="_outSiteHandler">
          <li class="hot">
            <span class="title">公司地点：</span>
            <div class="city-wrapper">
              <a v-for="(site, index) in sites" :class="{active:site===selSite}" @click="choseSite(site)" :key="index">{{site}}</a>
            </div>
          </li>
          <li class="other">
            <a v-for="(otherSite, index) in otherSites" :key="index">{{otherSite}}</a>
            <a class="all-city">全部城市 > </a>
          </li>
        </div>
      </div>
      <li class="multi-chosen financeStage clearfix">
        <span class="title">工作经验：</span>
        <a :class="{active:selWN.length===0}">不限</a>
        <a :class="mulSelWN(wn)" v-for="(wn, index) in workNature" @click="choseWN(wn)" :key="index">{{wn}}<i
          class="delete" @click.stop="removeWn(wn)"></i></a>
      </li>
      <li class="multi-chosen financeStage clearfix">
        <span class="title">学历要求：</span>
        <a :class="{active:selER.length===0}">不限</a>
        <a :class="mulSelER(er)" v-for="(er, index) in educationRequire" @click="choseER(er)" :key="index">{{er}}<i
          class="delete" @click.stop="removeEr(er)"></i></a>
      </li>
      <li class="multi-chosen financeStage clearfix">
        <span class="title">融资阶段：</span>
        <a :class="{active:selFS.length===0}">不限</a>
        <a :class="mulSelFS(fs)" v-for="(fs, index) in financeStages" @click="choseFS(fs)" :key="index">{{fs}}<i
          class="delete" @click.stop="removeFs(fs)"></i></a>
      </li>
      <li class="multi-chosen financeStage clearfix">
        <span class="title">公司规模：</span>
        <a :class="{active:selCS.length===0}">不限</a>
        <a :class="mulSelCS(cs)" v-for="(cs, index) in companySize" @click="choseCS(cs)" :key="index">{{cs}}<i
          class="delete" @click.stop="removeCs(cs)"></i></a>
      </li>
      <div class="has-more industry clearfix">
        <li class="multi-chosen">
          <span class="title">行业领域：</span>
          <a :class="{active:selIndustry.length===0}">不限</a>
          <a :class="mulSelIndustry(i)" v-for="(i, index) in industries" @click="choseIndustry(i)" :key="index">{{i}}<i
            class="delete" @click.stop="removeIndustry(i)"></i></a>
          <span class="btn-more-hy" @mouseover="_inIndustryHandler">更多&nbsp;<i></i></span>
        </li>
        <div v-show="showMoreIndustry" class="more-by" @mouseleave="_outIndustryHandler">
          <li class="hot multi-chosen clearfix">
            <span class="title">行业领域：</span>
            <a :class="{active:selIndustry.length===0}">不限</a>
            <a :class="{active:i===selIndustry}" v-for="(i, index) in industries" @click="choseIndustry(i)" :key="index">{{i}}<i
              class="delete"></i></a>
          </li>
          <li class="other multi-chosen clearfix">
            <a v-for="(otherIndustry, index) in otherIndustries" :key="index">{{otherIndustry}}</a>
          </li>
        </div>
      </div>
    </div>
  </ul>
</template>

<script type="text/ecmascript-6">
export default {
  name: 'FilterBox',
  data () {
    return {
      sites: ['全国', '北京', '上海', '深圳', '广州', '杭州', '成都', '南京', '武汉', '西安', '厦门', '长沙', '苏州', '天津'],
      otherSites: ['重庆', '郑州', '青岛', '合肥', '福州', '济南', '大连', '珠海', '无锡', '佛山', '东莞', '宁波', '常州', '沈阳', '石家庄', '昆明', '南昌', '南宁', '哈尔滨', '海口', '中山', '惠州', '贵阳', '长春', '太原', '嘉兴', '泰安', '昆山', '烟台', '兰州', '泉州'],
      financeStages: ['未融资', '天使轮', 'A轮', 'B轮', 'C轮', 'D轮及以上', '上市公司', '不需要融资'],
      workNature: ['应届毕业生', '3年及以下', '3-5年', '5-10年', '10年以上', '不要求'],
      companySize: ['少于15人', '15-50人', '50-150人', '150-500人', '500-2000人', '2000人以上'],
      educationRequire: ['大专', '本科', '硕士', '博士', '不要求'],
      industries: ['移动互联网', '电子商务', '金融', '企业服务', '教育', '文化娱乐', '游戏', 'O2O', '硬件'],
      otherIndustries: ['医疗健康', '生活服务', '广告营销', '旅游', '数据服务', '社交网络', '分类信息', '信息安全', '招聘', '其他'],
      selSite: '全国',
      selFS: [],
      selCS: [],
      selER: [],
      selWN: [],
      selIndustry: [],
      showMoreSite: false,
      showMoreIndustry: false
    }
  },
  methods: {
    choseSite (site) {
      this.selSite = site
    },
    choseFS (fs) {
      this.selFS.push(fs)
    },
    choseCS (cs) {
      this.selCS.push(cs)
    },
    choseER (er) {
      this.selER.push(er)
    },
    choseWN (wn) {
      this.selWN.push(wn)
    },
    mulSelFS (fs) {
      let index = this.selFS.indexOf(fs)
      if (index !== -1) {
        return 'chosen'
      } else {
        return ''
      }
    },
    mulSelCS (cs) {
      let index = this.selCS.indexOf(cs)
      if (index !== -1) {
        return 'chosen'
      } else {
        return ''
      }
    },
    mulSelER (er) {
      let index = this.selER.indexOf(er)
      if (index !== -1) {
        return 'chosen'
      } else {
        return ''
      }
    },
    mulSelWN (wn) {
      let index = this.selWN.indexOf(wn)
      if (index !== -1) {
        return 'chosen'
      } else {
        return ''
      }
    },
    mulSelIndustry (industry) {
      let index = this.selIndustry.indexOf(industry)
      if (index !== -1) {
        return 'chosen'
      } else {
        return ''
      }
    },
    choseIndustry (industry) {
      this.selIndustry.push(industry)
    },
    removeFs (fs) {
      let index = this.selFS.indexOf(fs)
      this.selFS.splice(index, 1)
    },
    removeCs (cs) {
      let index = this.selCS.indexOf(cs)
      this.selCS.splice(index, 1)
    },
    removeEr (er) {
      let index = this.selER.indexOf(er)
      this.selER.splice(index, 1)
    },
    removeWn (wn) {
      let index = this.selWN.indexOf(wn)
      this.selWN.splice(index, 1)
    },
    removeIndustry (industry) {
      let index = this.selIndustry.indexOf(industry)
      this.selIndustry.splice(index, 1)
    },
    _inSiteHandler () {
      this.showMoreSite = true
    },
    _outSiteHandler () {
      this.showMoreSite = false
    },
    _inIndustryHandler () {
      this.showMoreIndustry = true
    },
    _outIndustryHandler () {
      this.showMoreIndustry = false
    }
  }
}
</script>

<style lang="stylus" scoped>
  #filter-box
    position relative
    margin-top 35px
    padding 8px 0
    background-color #fafafa
    border 1px solid #ededed
    min-height 36px
    .details
      position relative
      overflow visible
      background #fafafa
      .workcity
        z-index 10
        .more-position
          z-index 11 !important
          .hot
            overflow hidden
            width 958px
            height 22px
          .other
            height auto
            padding 0 10px
            border-bottom 0
            padding-left 15px
            a
              margin 3px 0
            .all-city
              color #00b38a
              &:hover
                background-color #fff
                color #00b38a
      .financeStage.multi-chosen
        .chosen
          position relative
          padding-right 22px
          background-color #00b38a
          color #fff
        .delete
          position absolute
          right 5px
          top 5px
          width 11px
          height 11px
          background url(//static.lagou.com/www/static/company-list/modules/filter/img/delete_filter_icon_41c99f2.png) no-repeat
      .industry
        z-index 8
        .multi-chosen
          .chosen
            position relative
            padding-right 22px
            background-color #00b38a
            color #fff
          .delete
            position absolute
            right 5px
            top 5px
            width 11px
            height 11px
            background url(//static.lagou.com/www/static/company-list/modules/filter/img/delete_filter_icon_41c99f2.png) no-repeat
        .more-by
          display block
          position absolute
          z-index 11
          top 0
          left -1px
          right -1px
          background-color #fff
          margin-top -1px
          border 1px solid #ededed
          .other
            height auto
            padding 0 10px
            border-bottom 0
            padding-left 15px
            a
              margin 3px 0
      .has-more
        position relative
        .more
          position absolute
          z-index 10
          top 0
          left -1px
          right -1px
          background-color #fff
          margin-top -1px
          border 1px solid #ededed
      li
        position relative
        padding 4px 0
        zoom 1
        color #555
        border-bottom 1px dashed transparent
        span
          cursor: default!important
        span
        a
        .btn-more
          display block
          float left
          margin-right 5px
          padding 4px 8px
          height 14px
          line-height 14px
          cursor pointer
          &:hover
            background-color #fafafa
            color #333
        a:hover
          background #00b38a
          color #fff
        .title
          font-weight 600
          margin-right -5px
          margin-left 15px
        .city-wrapper
          width 1038px
          height 22px
          overflow hidden
          position absolute
          display inline-block
          a
            padding 4px 8px
            cursor pointer
        .btn-more
          color #555
          font-weight 400
          position relative
          z-index 11
          float right
          margin 0 16px
          background-color transparent
          i
            position absolute
            top 9px
            right -3px
            font-size 0
            height 0
            width 0
            border-width 6px 6px 0
            border-style solid dashed
            border-color #00b38a transparent transparent
            overflow hidden
            transition all .4s ease 0s
        .btn-more-hy
          color #555
          font-weight 400
          position relative
          z-index 11
          float right
          margin 0 16px
          background-color transparent
          i
            position absolute
            top 9px
            right -3px
            font-size 0
            height 0
            width 0
            border-width 6px 6px 0
            border-style solid dashed
            border-color #00b38a transparent transparent
            overflow hidden
            transition all .4s ease 0s
    .active
      background #00b38a
      color #fff
</style>
