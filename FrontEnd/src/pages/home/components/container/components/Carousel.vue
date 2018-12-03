<template>
  <div class="body">
    <el-carousel indicator-position="inside" :interval="5000">
      <el-carousel-item v-for="carousel of carousels" :key="carousel.id">
        <div class="demo-carousel">
          <a href="#">
            <img :src="carousel.linkUrl" width="840" height="346">
          </a>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: 'ContainerBody',
  props: {
    carousels: Array
  }
}
</script>

<style scoped lang="stylus">
  .body
    margin: 26px auto 0
    width: 840px
    .demo-carousel
      width: 840px
      height: 346px
</style>
