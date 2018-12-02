<template>
  <div class="container clearfix  has-login-toolbar">
    <container-header></container-header>
    <container-body></container-body>
    <container-recommend></container-recommend>
  </div>
</template>

<script>
import ContainerHeader from './components/Header'
import ContainerBody from './components/Body'
import ContainerRecommend from './components/Recommend'
export default {
  name: 'Container',
  components: {ContainerRecommend, ContainerBody, ContainerHeader}
}
</script>

<style scoped lang="stylus">
.container.has-login-toolbar
  padding-bottom: 91px
</style>
