<template>
  <div id="app">
    <p>The beauty of volleyball</p>
    <img :src=logo height="480" width="400" crop="fill" />
  </div>
</template>

<script>
export default {
  data: function (){
    return {
      logo: require('../assets/volleyball.jpg')
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
