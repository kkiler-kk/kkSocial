<template>
	<div class="container form-box">
		<form action="/#/sign-up">
			<div class="link-box">
				<router-link to="/sign-up">注册</router-link>
				<router-link to="/login">登录</router-link>
			</div>
			<div class="avatar">
				<label class="male"></label>
			</div>
			
			<label class="label">
				<div class="icon">
					<i data-eva="email-outline" data-eva-fill="#2979FF"></i>
				</div>
				<input type="email" name="email" placeholder="邮箱" v-model="user.email"/>
			</label>
			
			<label class="label">
				<div class="icon">
					<i data-eva="lock-outline" data-eva-fill="#2979FF"></i>
				</div>
				<input type="password" name="password" placeholder="密码" v-model="user.password"/>
			</label>
			
			<div class="label">
				<button type="button" class="submit">登录</button>
			</div>
		</form>
	</div>
</template>

<script>

export default {
	name: "Login",
	data: function () {
		return {
			user: {
				email: '',
				password: ''
			}
		}
	}
}
</script>

<style>
</style>
