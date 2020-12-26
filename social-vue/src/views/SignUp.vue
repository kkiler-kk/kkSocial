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
				<input type="email" placeholder="验证码" v-model="verify.code"/>
				<button type="button" @click="getVerifyCode">点击发送</button>
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
				<input type="password" placeholder="确认密码" v-model="verify.password"/>
			</label>
			
			<ul class="error-list" v-show="errorList.length > 0">
				<li v-for="(item, index) of errorList" :key="'e' + index">{{item}}</li>
			</ul>
			
			<div class="label">
				<button type="button" class="submit" @click="send">注册</button>
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
				password: ''
			},
			verify: {
				code: '',
				verifyCode: '',
				password: ''
			},
			errorList: []
		}
	},
	methods: {
		setError: function (errorList) {
			this.errorList = errorList;
		},
		getVerifyCode: function () {
			this.verify.verifyCode = '1234';
			alert('验证码: 1234');
		},
		verifyForm: function () {
			let errorList = [];
			let user = this.user;
			let verify = this.verify;
			let emailVerify = /^\w+@(\w+.)+\w+$/;
			if (user.name === '') errorList.push("请填写用户名");
			if (user.email === '') errorList.push("请填写邮箱");
			else if (!emailVerify.test(user.email)) errorList.push("请填写正确的邮箱格式");
			if (verify.code === '') errorList.push("请填写验证码");
			if (verify.code !== verify.verifyCode) errorList.push("验证码错误");
			if (user.password === '') errorList.push("请填写密码");
			if (user.password !== verify.password) errorList.push("前后密码不一致");
			this.setError(errorList);
			return errorList.length === 0;
		},
		send: function () {
			if (!this.verifyForm()) return;
			console.count('send');
		}
	}
}
</script>

<style lang="scss" src="@/assets/css/form-box.scss">
</style>
