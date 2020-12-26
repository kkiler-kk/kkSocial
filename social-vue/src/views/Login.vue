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
			
			<ul class="error-list" v-show="errorList.length > 0">
				<li v-for="(item, index) of errorList" :key="'e' + index">{{item}}</li>
			</ul>
			
			<div class="label">
				<button type="button" class="submit" @click="send">登录</button>
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
			},
			errorList: []
		}
	},
	methods: {
		setError: function (errorList) {
			this.errorList = errorList;
		},
		verifyForm: function () {
			let errorList = [];
			let user = this.user;
			let emailVerify = /^\w+@(\w+\.)+\w+$/;
			if (user.email === '') errorList.push("请填写邮箱");
			else if (!emailVerify.test(user.email)) errorList.push("请填写正确的邮箱格式");
			if (user.password === '') errorList.push("请填写密码");
			this.setError(errorList);
			return errorList.length === 0;
		},
		send: function () {
			if (!this.verifyForm()) return;
			console.count('send');
			let formData = new FormData();
			for (let key in this.user) {
				formData.append(key, this.user[key]);
			}
			this.axios.post('/api/user/login.do', formData, {
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
				},
			})
			.then(response => {
				console.log(response.data);
			})
			.catch(error => {
				console.log(error);
			});
		}
	}
}
</script>

<style lang="scss" src="@/assets/css/form-box.scss">
</style>
