<template>
	<div class="container form-box">
		<form id="login">
			<div class="link-box">
				<router-link to="/sign-up">注册</router-link>
				<router-link to="/login">登录</router-link>
			</div>
			<div class="avatar">
				<label class="male" id="avatar"></label>
			</div>

			<label class="label">
				<div class="icon">
					<eva-icon name="email-outline" fill="#2979FF"></eva-icon>
				</div>
				<input type="email" name="email" placeholder="邮箱" v-model="user.email" @blur="getAvatar()"/>
			</label>

			<label class="label">
				<div class="icon">
					<eva-icon name="lock-outline" fill="#2979FF"></eva-icon>
				</div>
				<input type="password" name="password" placeholder="密码" v-model="user.password" @blur="verifyPassword()"/>
			</label>

			<ul class="error-list" v-show="errorList.length > 0">
				<li v-for="(item, index) of errorList" :key="'e' + index">{{item}}</li>
			</ul>

			<div class="label">
				<button type="button" class="submit" @click="send">
					登录
				</button>
			</div>
		</form>
	</div>
</template>

<script>
import Verifys from '@/utils/form-verify';

export default {
	name: 'Login',
	data: function () {
		return {
			form: null,
			user: {
				email: '',
				password: ''
			},
			errorState: {
				email: 'true',
				password: 'true'
			}
		};
	},
	methods: {
		setErrorState: function (key, value) {
			this.errorState[key] = value;
		},
		getAvatar: async function () {
			await this.verifyEmail();
			if (this.errorState.email !== 'true') return;

			let img = new Image;
			img.onload = () => {
				document.getElementById('avatar').innerHTML = '';
				document.getElementById('avatar').appendChild(img);
			}
			img.onerror = () => document.getElementById('avatar').innerHTML = '';
			img.src = `http://localhost:8800/upload/${this.user.email}.jpg`;
		},
		verifyEmail: async function () {
			let email = this.user.email;
			let setErrorState = this.setErrorState;
			setErrorState('email', 'true');
			if (Verifys.isEmpty(email)) setErrorState('email', 'null');
			else if (!Verifys.verifyEmail(email)) setErrorState('email', 'false');
			else {
				await this.axios.get('/api/user/exist-email', {
					params: {
						email
					}
				})
				.then(response => {
					if (!response.data) {
						setErrorState('email', 'error');
						return;
					}
					if (response.data.status) {
						setErrorState('email', 'exist');
						return;
					}
				})
				.catch(error => {
					setErrorState('email', 'error');
					console.log(error);
				});
			}
		},
		verifyPassword: function () {
			let password = this.user.password;
			let setErrorState = this.setErrorState;
			setErrorState('password', 'true');
			if (Verifys.isEmpty(password)) setErrorState('password', 'null');
			// else if (!Verifys.lengthIn(password, 6, 18)) setErrorState('password', 'length');
		},
		verifyForm: async function () {
			await this.verifyEmail();
			this.verifyPassword();
			for (let key in this.errorState) {
				if (this.errorState[key] !== 'true') return false;
			}
			return true;
		},
		send: async function () {
			if (! await this.verifyForm()) return;
			let setErrorState = this.setErrorState;
			setErrorState('password', 'true');
			console.count('send');
			let formData = new FormData(this.form);
			await this.axios.post('/api/user/login', formData, {
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
				},
			})
			.then(response => {
				if (!response.data) {
					setErrorState('password', 'error');
				}
				if (!response.data.status) {
					setErrorState('password', 'exist');
					return;
				}
				this.$store.commit('setLogin', true);
				this.$store.commit('setToken', response.data.data);
				this.$store.commit('setUser', {
					email: formData.get('email'),
					password: formData.get('password')
				});
				this.$router.push('/');
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
			switch (errorState.email) {
				case 'null' :
					errorList.push('请填写邮箱');
					break;
				case 'false' :
					errorList.push('邮箱格式错误');
					break;
				case 'exist' :
					errorList.push('邮箱不存在');
					break;
				case 'error' :
					errorList.push('邮箱验证失败');
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
					errorList.push('密码错误');
					break;
				case 'error' :
					errorList.push('登录失败');
					break;
			}
			return errorList;
		}
	},
	mounted: function () {
		if (this.$store.state.isLogin) this.$router.push('/');
		this.form = document.getElementById('login');
		if (this.$store.state.user) {
			this.user = this.$store.state.user;
			this.$store.commit('setUser', null);
		}
	}
}
</script>

<style lang="scss" src="@/assets/css/form-box.scss">
</style>
