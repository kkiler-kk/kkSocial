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
					<eva-icon name="person-outline" fill="#2979FF"></eva-icon>
				</div>
				<input type="text" name="name" placeholder="用户名" v-model="user.name" @blur="verifyName()"/>
			</label>

			<label class="label">
				<div class="icon">
					<eva-icon name="email-outline" fill="#2979FF"></eva-icon>
				</div>
				<input type="email" name="email" placeholder="邮箱" v-model="user.email" @blur="verifyEmail()"/>
			</label>

			<label class="label">
				<div class="icon">
					<eva-icon name="code-outline" fill="#2979FF"></eva-icon>
				</div>
				<input type="text" name="code" placeholder="验证码" v-model="user.code" @blur="verifyCode()"/>
				<button type="button" @click="verifyEmail(getVerifyCode)">
					<eva-icon v-show="verify.isLoad" class="load" name="loader-outline" fill="#2979FF"></eva-icon>
					{{verify.buttonText}}
				</button>
			</label>

			<label class="label">
				<div class="icon">
					<eva-icon name="lock-outline" fill="#2979FF"></eva-icon>
				</div>
				<input type="password" name="password" placeholder="密码" v-model="user.password" @blur="verifyPassword()"/>
			</label>

			<label class="label">
				<div class="icon">
					<eva-icon name="lock-outline" fill="#2979FF"></eva-icon>
				</div>
				<input type="password" placeholder="确认密码" v-model="verify.password" @blur="verifyPassword()"/>
			</label>

			<ul class="error-list" v-show="errorList.length > 0">
				<li v-for="(item, index) of errorList" :key="'e' + index">{{item}}</li>
			</ul>

			<div class="label">
				<button type="button" class="submit" @click="send">
					注册
				</button>
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
				buttonText: '点击发送',
				isLoad: false,
				password: ''
			},
			errorState: {
				name: 'true',
				email: 'true',
				code: 'true',
				password: 'true'
			},
			timer: null,
			submitIsLoad: false
		}
	},
	methods: {
		setErrorState: function (key, value) {
			this.errorState[key] = value;
		},
		setTimer: function () {
			let verify = this.verify;
			let i = 1;
			this.timer = window.setInterval(() => {
				verify.isLoad = false;
				verify.buttonText = `已发送 (${60 - i}s)`;
				if (++i >= 60) {
					window.clearInterval(this.timer);
					this.timer = null;
					verify.buttonText = '再次发送';
				}
			}, 1000);
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
		verifyName: async function () {
			let name = this.user.name;
			let setErrorState = this.setErrorState;
			setErrorState('name', 'true');
			if (Verifys.isEmpty(name)) setErrorState('name', 'null');
			else {
				await this.axios.get('/api/public/exist-name/' + name)
				.then(response => {
					if (!response.data) {
						setErrorState('name', 'error');
						return;
					}
					if (!response.data.status) {
						setErrorState('name', 'exist');
						return;
					}
				})
				.catch(error => {
					setErrorState('name', 'error');
					console.log(error);
				});
			}
		},
		verifyEmail: async function (callback) {
			let email = this.user.email;
			let setErrorState = this.setErrorState;
			setErrorState('email', 'true');
			if (Verifys.isEmpty(email)) setErrorState('email', 'null');
			else if (!Verifys.verifyEmail(email)) setErrorState('email', 'false');
			else {
				await this.axios.get('/api/public/exist-email', {
					params: {
						email
					}
				})
				.then(response => {
					if (!response.data) {
						setErrorState('email', 'error');
						return;
					}
					if (!response.data.status) {
						setErrorState('email', 'exist');
						return;
					}

					if (callback) callback();
				})
				.catch(error => {
					setErrorState('email', 'error');
					console.log(error);
				});
			}
		},
		getVerifyCode: async function () {
			if (this.timer || this.errorState.email !== 'true') return;

			let email = this.user.email;
			let setErrorState = this.setErrorState;
			let setTimer = this.setTimer;
			let verify = this.verify;

			verify.buttonText = '';
			verify.isLoad = true;

			await this.axios.get('/api/public/send-email', {
				params: {
					email
				}
			})
			.then(response => {
				if (!response.data || !response.data.status) {
					setErrorState('code', 'error');
					return;
				}
				setTimer();
			})
			.catch(error => {
				console.log(error);
				setErrorState('code', 'error');
				verify.buttonText = '再次发送';
				verify.isLoad = false;
			});
		},
		verifyCode: function () {
			let code = this.user.code;
			let setErrorState = this.setErrorState;
			setErrorState('code', 'true');
			if (Verifys.isEmpty(code)) setErrorState('code', 'null');
			else if (!Verifys.test(/^\d+/, code)) setErrorState('code', 'false');
			else if (!Verifys.lengthIn(code, 6, 7)) setErrorState('code', 'length');
		},
		verifyPassword: function () {
			let password = this.user.password;
			let setErrorState = this.setErrorState;
			setErrorState('password', 'true');
			if (Verifys.isEmpty(password)) setErrorState('password', 'null');
			else if (!Verifys.equals(password, this.verify.password)) setErrorState('password', 'exist');
			// else if (!Verifys.lengthIn(password, 6, 18)) setErrorState('password', 'length');
		},
		verifyForm: async function () {
			await this.verifyName();
			await this.verifyEmail();
			this.verifyCode();
			this.verifyPassword();
			for (let key in this.errorState) {
				if (this.errorState[key] !== 'true') return false;
			}
			return true;
		},
		send: async function () {
			if (! await this.verifyForm()) return;
			console.count('send');
			let setErrorState = this.setErrorState;
			setErrorState('password', 'true');
			setErrorState('code', 'true');

			let formData = new FormData(this.form);
			// console.log(...formData);
			await this.axios.post('/api/public/register', formData, {
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
				},
			})
			.then(response => {
				if (!response.data) {
					setErrorState('password', 'error');
				}
				if (!response.data.status) {
					setErrorState('code', 'exist');
					return;
				}

				this.$store.commit('setUser', {
					email: formData.get('email'),
					password: formData.get('password')
				});
				this.$router.push('/login');
			})
			.catch(error => {
				console.log(error);
				setErrorState('password', 'error');
			});
		}
	},
	computed: {
		errorList: function () {
			let errorState = this.errorState;
			let errorList = [];
			switch (errorState.name) {
				case 'null' :
					errorList.push('请填写用户名');
					break;
				case 'length' :
					errorList.push('用户名长度不合法');
					break;
				case 'exist' :
					errorList.push('用户名已存在');
					break;
				case 'error' :
					errorList.push('用户名验证失败');
					break;
			}
			switch (errorState.email) {
				case 'null' :
					errorList.push('请填写邮箱');
					break;
				case 'false' :
					errorList.push('邮箱格式错误');
					break;
				case 'exist' :
					errorList.push('邮箱已存在');
					break;
				case 'error' :
					errorList.push('邮箱验证失败');
					break;
			}
			switch (errorState.code) {
				case 'null' :
					errorList.push('请填写验证码');
					break;
				case 'false' :
					errorList.push('验证码格式错误');
					break;
				case 'length' :
					errorList.push('请填写 6 位数验证码');
					break;
				case 'exist' :
					errorList.push('验证码错误');
					break;
				case 'error' :
					errorList.push('验证码发送失败');
					break;
			}
			switch (errorState.password) {
				case 'null' :
					errorList.push('请填写密码');
					break;
				case 'false' :
					errorList.push('密码格式错误');
					break;
				case 'length' :
					errorList.push('请填写 6 - 18 位密码');
					break;
				case 'exist' :
					errorList.push('前后密码不一致');
					break;
				case 'error' :
					errorList.push('注册失败');
					break;
			}
			return errorList;
		}
	},
	mounted: function () {
		if (this.$store.state.isLogin) this.$router.push('/');
		this.form = document.getElementById('sign-up');
	}
}
</script>
