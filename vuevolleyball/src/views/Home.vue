<template>
    <p>I am Home</p>
  <HelloWorld/>
</template>

<script>
import HelloWorld from "@/components/HelloWorld";
import {defineComponent} from "vue";

export default defineComponent({
  name: 'Home',
  components:{
    HelloWorld
  }
})
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
