<template>
  <Players/>
</template>

<script>
import Players from "@/components/Players";
import {defineComponent} from "vue";

export default defineComponent({
  name: 'Home',
  components:{
    Players
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
