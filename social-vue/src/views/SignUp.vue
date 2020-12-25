<template>
	<div id="sign-up" class="container">
		<form action="#">
			<div class="nav">
				<router-link to="/sign-up">注册</router-link>
				<router-link to="/login">登录</router-link>
			</div>
			<div class="avatar">
				<label for="img-up-load">
					<div class="message">点击上传头像</div>
				</label>
				<input 
					id="img-up-load" 
					type="file" 
					accept="image/*"
					v-show="false"/>
			</div>
			
			<label>
				<input type="text"/>
			</label>
			
			<div class="link">
			</div>
		</form>
	</div>
</template>

<script>
</script>

<style lang="scss">
#sign-up {
	display: grid;
	place-items: center;
	flex: 1 0 auto;
	height: 100%;
	
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
			background-image: url("../assets/svg/male_avatar.svg");
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
