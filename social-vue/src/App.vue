<template>
  <div id="app">
		<Header :links="links"/>
		<div id="page">
			<router-view/>
		</div>
  </div>
</template>

<script>
import Header from '@/components/Header.vue';

export default {
	name: 'App',
	data: function () {
		return {
			links: [
				{
					text: 'sign-up',
					iconData: 'person-add',
					url: '/sign-up',
					title: 'sign-up'
				}
			]
		} 
	},
	components: {
		Header
	}
}
</script>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html, body {
	height: 100%;
}

.container {
	width: 1280px;
	margin: auto;
	padding: 0 2rem;
}

#app {
	display: flex;
	flex-direction: column;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #414141;
	font-size: 1.2rem;
	height: 100%;
	background-color: #EEEEEE;
}

#page {
	position: absolute;
	left: 0;
	right: 0;
	top: 3.5rem;
	bottom: 0;
	overflow: auto;
}

/* a.router-link-exact-active */
</style>
