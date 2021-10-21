<template>
  <v-row justify="center">
    <div>
      <p>Players</p>
      <table>
        <thead>
        <tr>
          <td>Voornaam</td>
          <td>Achternaam</td>
          <td>Positie</td>
          <td>Lengte</td>
          <td>Club</td>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(player) in players" :key="player.id">
          <td>{{ player.firstName }}</td>
          <td>{{ player.lastName }}</td>
          <td>{{ player.position }}</td>
          <td>{{ player.length }}</td>
          <td>{{ player.teamName }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </v-row>
</template>

<script lang="js">

import { defineComponent } from 'vue'

export default defineComponent({
  name: 'Player',
  data () {
    return {
      players: [],
    }
  },
  methods: {
    getPlayers () {
      fetch('http://localhost:8080/api/player')
          .then(res => res.json())
          .then(json => {
            for (const x of json) {
              this.players.push(x)
            }
          })
    }
  },
  mounted () {
    this.getPlayers()
  }
})
</script>

<style scoped>

</style>
