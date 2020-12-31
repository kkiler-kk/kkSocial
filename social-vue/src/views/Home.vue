<template>
  <div id="home" class="container">
		<p>{{this.$store.state.token ? this.$store.state.token : 'THE HOME'}}</p>
  </div>
</template>

<script>
</script>

<style>
#home {
	display: grid;
	place-items: center;
	height: 100%;
}
</style>
