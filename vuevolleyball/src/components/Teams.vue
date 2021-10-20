<template>
  <table>
    <thead>
    <tr>
      <td>Clubnaam</td>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(team) in teams" :key="team.id">
      <td>{{team.teamName}}</td>
    </tr>
    </tbody>
  </table>
</template>

<script lang="js">

import { defineComponent } from 'vue'

export default defineComponent({
  name: 'Team',
  data () {
    return {
      teams: [],
    }
  },
  methods: {
    getTeams () {
      fetch('http://localhost:8080/api/team')
          .then(res => res.json())
          .then(json => {
            for (const x of json) {
              this.teams.push(x)
            }
          })
    }
  },
  mounted () {
    this.getTeams()
  }
})
</script>

<style scoped>

</style>
