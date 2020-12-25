<template>
	<div class="container form-box">
		<form action="/#/sign-up">
			<div class="link-box">
				<router-link to="/sign-up">注册</router-link>
				<router-link to="/login">登录</router-link>
			</div>
			<div class="avatar">
				<label for="img-up-load" :class="[(user.gender ? 'male' : 'female')]">
					<div class="message">点击上传头像</div>
				</label>
				<input 
					id="img-up-load" 
					type="file" 
					name="file"
					accept="image/*"
					v-show="false"/>
			</div>
			
			<div class="switch-box">
					<span 
						class="switch" 
						:class="[(user.gender ? 'male' : 'remale')]"
						@click="user.gender = !user.gender">
						<span>男</span>
						<span>女</span>
					</span>
					<input type="text" name="gender" :value="user.gender ? 1 : 0" v-show="false">
			</div>
			
			<label class="label">
				<div class="icon">
					<i data-eva="person-outline" data-eva-fill="#2979FF"></i>
				</div>
				<input type="text" name="name" placeholder="用户名" v-model="user.name"/>
			</label>
			
			<label class="label">
				<div class="icon">
					<i data-eva="email-outline" data-eva-fill="#2979FF"></i>
				</div>
				<input type="email" name="email" placeholder="邮箱" v-model="user.email"/>
			</label>
			
			<label class="label">
				<div class="icon">
					<i data-eva="code-outline" data-eva-fill="#2979FF"></i>
				</div>
				<input type="email" placeholder="验证码" v-model="user.code"/>
				<button type="button">点击发送</button>
			</label>
			
			<label class="label">
				<div class="icon">
					<i data-eva="lock-outline" data-eva-fill="#2979FF"></i>
				</div>
				<input type="password" name="password" placeholder="密码" v-model="user.password"/>
			</label>
			
			<label class="label">
				<div class="icon">
					<i data-eva="lock-outline" data-eva-fill="#2979FF"></i>
				</div>
				<input type="password" placeholder="确认密码" v-model="user.repassword"/>
			</label>
			
			<div class="label">
				<button type="button" class="submit">Sign in</button>
			</div>
		</form>
	</div>
</template>

<script>

export default {
	name: "SignUp",
	data: function () {
		return {
			user: {
				name: '',
				gender: true,
				email: '',
				code: '',
				password: '',
				repassword: ''
			}
		}
	}
}
</script>

<style lang="scss" src="@/assets/css/form-box.scss">
</style>
