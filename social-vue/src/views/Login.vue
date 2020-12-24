<template>
	<div id="login" class="container">
		<form action="#">
			<div class="avatar">
				<label for="img-up-load">
					<div class="message">点击上传头像</div>
				</label>
				<input id="img-up-load" type="file" v-show="false"/>
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
	
	form {
		padding: 2rem;
		background-color: #FFFFFF;
		border-radius: 1rem;
		
		.avatar label{
			display: block;
			width: 8rem;
			height: 8rem;
			margin: auto;
			border-radius: 50%;
			display: grid;
			place-items: center;
			background-image: url(../assets/svg/undraw_male_avatar_323b.svg);
			background-size: cover;
			overflow: hidden;
			
			.message {
				width: 100%;
				height: 100%;
				line-height: 8rem;
				color: #FFFFFF;
				text-align: center;
				background-color: #41414161;
				opacity: 0;
				transition: 0.2s;
			}
			
			&:hover .message {
				opacity: 1;
			}
		}
	}
}
</style>
