<template>
  <ul id="tab-bar">
    <li v-for="(i,index) in tabList" :class="{current:index===currentIndex}" @click="chooseTab(index)" :key="index">{{i}}</li>
  </ul>
</template>

<script>
export default {
  data () {
    return {
      currentIndex: 0
    }
  },
  props: {
    tabList: {
      type: Array,
      default: function () {
        return []
      }
    }
  },
  methods: {
    chooseTab (index) {
      this.currentIndex = index
    }
  }
}
</script>

<style lang="stylus" scoped>
  #tab-bar
    margin 52px auto 14px
    font-size 0
    border-bottom 1px solid #e8e8e8
    li
      cursor pointer
      display inline-block
      padding 14px 0
      margin-right 58px
      font-size 16px
      color #999
      &.current
        border-bottom 2px solid #333
        background #fff
        color #333
</style>
