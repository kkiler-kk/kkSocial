<template>
	<div class="container form-box">
		<form id="sign-up">
			<div class="link-box">
				<router-link to="/sign-up">注册</router-link>
				<router-link to="/login">登录</router-link>
			</div>
			<div class="avatar">
				<label for="img-up-load" :class="[(user.gender ? 'male' : 'female')]" id="avatar">
					<div class="message">点击上传头像</div>
				</label>
				<input 
					id="img-up-load" 
					type="file" 
					name="file"
					accept="image/*"
					@change="showAvatar"
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
				<input type="text" name="code" placeholder="验证码" v-model="user.code"/>
				<button type="button" @click="getVerifyCode($event)">点击发送</button>
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
			form: null,
			user: {
				name: '',
				gender: true,
				code: '',
				email: '',
				password: ''
			},
			verify: {
				password: ''
			},
			errorList: []
		}
	},
	methods: {
		setError: function (errorList) {
			this.errorList = errorList;
		},
		showAvatar: function () {
			let file = new FormData(this.form).get("file");
			let img = new Image();
			img.onload = () => {
				document.getElementById('avatar').innerHTML = "";
				document.getElementById('avatar').appendChild(img);
			}
			let reader = new FileReader();
			reader.onload = e => img.src = e.target.result;
			reader.readAsDataURL(file);
		},
		getVerifyCode: function (e) {
			let button = e.target;
			
			let errorList = [];
			let email = this.user.email;
			let emailVerify = /^\w+@(\w+.)+\w+$/;
			if (email === '') errorList.push("请填写邮箱");
			else if (!emailVerify.test(email)) errorList.push("请填写正确的邮箱格式");
			else {
				// /existEmail.do
				this.axios.get('/api/user/existEmail.do', {
					params: {
						email
					}
				})
				.then(response => {
					if (!response.data.status) {
						errorList.push("邮箱已经存在");
						this.setError(errorList);
						return;
					}
					
					this.axios.get('/api/user/sendEmail.do', {
						params: {
							email
						}
					})
					.then(response => {
					button.innerText = '已发送';
					console.log(response);
					})
					.catch(error => {
					button.innerText = '发送失败';
					console.log(error);
					});
					
					button.innerText = '发送中';
				})
				.catch(error => {
					console.log(error);
					errorList.push("邮箱验证失败");
					this.setError(errorList);
				});
			}
			if (errorList.length > 0) this.setError(errorList);
			
			this.axios.get('/api/user/sendEmail.do', {
				params: {
					email
				}
			})
			.then(response => {
				button.innerText = '已发送';
				console.log(response);
			})
			.catch(error => {
				button.innerText = '发送失败';
				console.log(error);
			});
			
			button.innerText = '发送中';
		},
		verifyForm: function () {
			let errorList = [];
			let user = this.user;
			let verify = this.verify;
			let emailVerify = /^\w+@(\w+.)+\w+$/;
			let codeVerify = /^\d+$/;
			if (user.name === '') errorList.push("请填写用户名");
			if (user.email === '') errorList.push("请填写邮箱");
			else if (!emailVerify.test(user.email)) errorList.push("请填写正确的邮箱格式");
			if (user.code === '') errorList.push("请填写验证码");
			else if (!codeVerify.test(user.code)) errorList.push("验证码格式错误");
			if (user.password === '') errorList.push("请填写密码");
			if (user.password !== verify.password) errorList.push("前后密码不一致");
			this.setError(errorList);
			return errorList.length === 0;
		},
		send: function () {
			if (!this.verifyForm()) return;
			console.count('send');
			
			let formData = new FormData(this.form);
			// let setError = this.setError;
			console.log(...formData);
			this.axios.post('/api/user/register.do', formData, {
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
				},
			})
			.then(response => {
				let data = response.data;
				console.log(data);
			})
			.catch(error => {
				console.log(error);
			});
		}
	},
	mounted: function () {
		this.form = document.getElementById('sign-up');
	}
}
</script>

<style lang="scss" src="@/assets/css/form-box.scss">
</style>
