<template>
	<div id="login" class="container">
		<form action="#">
			<div class="avatar">
			</div>
			
			<label>
				<!-- <input type="text"/> -->
			</label>
		</form>
	</div>
</template>

<script>
</script>

<style lang="scss">
#login {
	display: grid;
	place-items: center;
	flex: 1 0 auto;
	height: 100%;
	
	form {
		padding: 2rem;
		background-color: #FFFFFF;
		border-radius: 1rem;
		
		.avatar{
			display: block;
			width: 8rem;
			height: 8rem;
			margin: auto;
			border-radius: 50%;
			background-image: url("../assets/svg/male_avatar.svg");
			background-size: cover;
			overflow: hidden;
		}
	}
}
</style>
