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

<style lang="scss">
.retry {
	> p {
		text-align: center;
		line-height: 3rem;
	}
	
	button {
		line-height: 2rem;
		padding: 0 2rem;
		border: solid 1px #414141;
		border-radius: 3px;
		background: transparent;
		
		&:hover {
			background-color: #41414121;
		}
	}
}
</style>
