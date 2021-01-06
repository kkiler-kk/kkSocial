<template>
	<ul>
		<li v-for="(item, index) of list" :key="'n' + index">
			{{item}}
		</li>
	</ul>
</template>

<script>
export default {
	name: 'NewsList',
	props: {
		list: Array
	}
}
</script>

<style>
</style>
