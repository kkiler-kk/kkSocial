<template>
	<div class="retry">
		<p>
			{{message}}
		</p>
		<p>
			<button @click="clickHandle">{{buttonText}}</button>
		</p>
	</div>
</template>

<script>
export default {
	name: 'Retry',
	props: {
		message: String,
		buttonText: String,
		clickHandle: Function
	}
}
</script>

<style>
</style>
