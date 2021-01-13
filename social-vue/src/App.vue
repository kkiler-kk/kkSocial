<template>
  <div id="app">
		<Header :links="this.$store.state.isLogin ? links : touristLinks"/>
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
			touristLinks: [
				{
					text: 'sign-up',
					iconData: 'person-add',
					url: '/sign-up',
					title: 'sign-up'
				}
			],
			links: [
				{
					text: 'github',
					iconData: 'github',
					url: '/',
					title: 'github'
				},
				{
					text: 'globe',
					iconData: 'globe',
					url: '/',
					title: 'globe'
				},
				{
					text: 'grid',
					iconData: 'grid',
					url: '/',
					title: 'grid'
				},
				{
					text: 'external',
					iconData: 'external-link-outline',
					url: '/',
					title: 'external'
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
	/* display: flex; */
	/* flex-direction: column; */
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #414141;
	font-size: 1.2rem;
	min-height: 100%;
	background-color: #EEEEEE;
}

#page {
	position: absolute;
	top: 4rem;
	bottom: 0;
	left: 0;
	right: 0;
	overflow: auto;
	z-index: 0;
	/* flex: 1 0 auto; */
}

@media screen and (max-width: 1280px) {
	.container {
		width: 100%;
	}
}

.load {
	animation: loading 2s linear infinite;
}

@keyframes loading {
	from { transform: rotate(0deg); }
	to { transform: rotate(360deg); }
}

/* a.router-link-exact-active */
</style>

<style lang="scss" src="@/assets/css/form-box.scss">
</style>
