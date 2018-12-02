<template>
  <div class="body">
    <el-carousel indicator-position="inside" :interval="5000">
      <el-carousel-item>
        <div class="demo-carousel">
          <a href="#">
            <img src="https://www.lgstatic.com/i/image2/M01/AF/5D/CgotOVv34T2AanexAAPngDucdlk976.JPG" alt="2018雇主评选" width="840" height="346">
          </a>
        </div>
      </el-carousel-item>
      <el-carousel-item>
        <div class="demo-carousel">
          <a href="#">
            <img src="https://www.lgstatic.com/i/image2/M01/AF/BB/CgoB5lv6t6aABNk7AAq5yi546ok560.PNG" alt="2018雇主评选" width="840" height="346">
          </a>
        </div>
      </el-carousel-item>
      <el-carousel-item>
        <div class="demo-carousel">
          <a href="#">
            <img src="https://www.lgstatic.com/i/image2/M01/B0/D3/CgotOVv86GiADG-tAASjARA1_f8155.JPG" alt="2018雇主评选" width="840" height="346">
          </a>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: 'ContainerBody',
  data () {
    return {
      value2: 0
    }
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
