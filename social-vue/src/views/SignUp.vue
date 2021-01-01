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
import Verifys from '@/utils/form-verify';

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
			errorList: [],
			timer: null
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
			if (this.timer) return;
			
			let button = e.target;
			
			let errorList = [];
			let email = this.user.email;
			if (Verifys.isEmpty(email)) errorList.push("请填写邮箱");
			else if (!Verifys.emailVerify(email)) errorList.push("请填写正确的邮箱格式");
			else {
				this.axios.get('/api/user/existEmail', {
					params: {
						email
					}
				})
				.then(response => {
					// console.log(response);
					if (!response.data.status) {
						errorList.push("邮箱已经存在");
						this.setError(errorList);
						return;
					}
					
					this.axios.get('/api/user/sendEmail', {
						params: {
							email
						}
					})
					.then(response => {
						console.log(response);
						let i = 1;
						this.timer = window.setInterval(() => {
							button.innerText = `已发送 (${60 - i}s)`;
							if (++i == 60) {
								window.clearInterval(this.timer);
							}
						}, 1000);
						window.setTimeout(() => {
							window.clearInterval(this.timer);
							this.timer = null;
							button.innerText = '再次发送';
						}, 60 * 1000);
						this.setError(errorList);
					})
					.catch(error => {
						button.innerText = '再次发送';
						errorList.push('验证码发送失败');
						console.log(error);
					});
					
					button.innerText = '发送中';
				})
				.catch(error => {
					console.log(error);
					errorList.push("发送失败, 请重试");
					this.setError(errorList);
				});
			}
			if (errorList.length > 0) this.setError(errorList);
		},
		verifyForm: function () {
			let errorList = [];
			let user = this.user;
			let verify = this.verify;
			if (Verifys.isEmpty(user.name)) errorList.push("请填写用户名");
			if (Verifys.isEmpty(user.email)) errorList.push("请填写邮箱");
			else if (!Verifys.emailVerify(user.email)) errorList.push("请填写正确的邮箱格式");
			if (Verifys.isEmpty(user.code)) errorList.push("请填写验证码");
			else if (!Verifys.test(/^\d+/, user.code)) errorList.push("验证码格式错误");
			if (Verifys.isEmpty(user.password)) errorList.push("请填写密码");
			if (!Verifys.equals(user.password, verify.password)) errorList.push("前后密码不一致");
			this.setError(errorList);
			return errorList.length === 0;
		},
		send: function () {
			if (!this.verifyForm()) return;
			console.count('send');
			
			let formData = new FormData(this.form);
			// let setError = this.setError;
			console.log(...formData);
			this.axios.post('/api/user/register', formData, {
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
				},
			})
			.then(response => {
				if (response.data.status) {
					this.$router.push('/login');
				}
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
