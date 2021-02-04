<template>
	<div class="user-info">
		<components v-show="state < 1" :is="getState" v-bind="getStateProps"></components>
		<div v-show="state > 0" class="content" v-if="user">
			<div class="background"></div>
			<div class="title">
				<div class="avatar male">
					<img v-if="user.url !== ''" :src="basicPath + user.url" :alt="user.name">
				</div>
				<div class="name">
					{{user.name}}
				</div>
			</div>
			<div class="menu">
				<router-link class="item" to="/">
					<div class="num">{{user.userInfo.count_user}}</div>
					<div class="message">关注</div>
				</router-link>
				<router-link class="item" to="/">
					<div class="num">{{user.userInfo.count_fans}}</div>
					<div class="message">粉丝</div>
				</router-link>
				<router-link class="item" to="/">
					<div class="num">{{user.userInfo.count_news}}</div>
					<div class="message">动态</div>
				</router-link>
			</div>
		</div>
	</div>
</template>

<script>
import Retry from '@/components/Retry.vue';
import Loading from '@/components/Loading.vue';

/*
 * state 字段
 * 可能有如下值
 * 0 'executing' 执行中
 * 1 'success' 成功
 * -1 'failure' 失败
 * -2 'unauthorized' 未授权
 */
export default {
	name: 'UserInfo',
	props: {
		isSlef: Boolean
	},
	data: function () {
		return {
			state: 0,
			basicPath: this.$store.state.basicPath
		};
	},
	methods: {
		setState: function (state) {
			this.state = state;
		},
		getInfo: function () {
			if (this.user) return;
			this.setState(0);
			if (!this.isLogin) {
				this.setState(-2);
				return;
			}
			this.axios.post('/api/private/get-user', null, {
				headers: {'Authorization': this.$store.state.token}
			}).then(response => {
				if (!response.data) {
					this.setState(-1);
					return;
				}
				if (!response.data.status) {
					this.setState(-2);
					return;
				}
				let user = response.data.data;
				this.setState(1);
				this.$store.commit('setUser', user);
			}).catch(() => {
				this.setState(-1);
			});
		},
		toLogin: function () {
			this.$router.push('/login');
		}
	},
	computed: {
		isLogin: function () {
			return this.$store.state.isLogin;
		},
		getState: function () {
			const state = this.state;
			if (state < 0) return 'Retry';
			return 'Loading';
		},
		getStateProps: function () {
			const state = this.state;
			if (state === -1) return {
				message: '获取出错',
				buttonText: '重试',
				clickHandle: this.getInfo
			};
			if (state === -2) return {
				message: '未登录',
				buttonText: '登录',
				clickHandle: this.toLogin
			}
			return {};
		},
		user: function () {
			return this.$store.state.user;
		}
	},
	mounted: function () {
		this.getInfo();
	},
	components: {
		Retry,
		Loading
	}
}
</script>

<style lang="scss">
.user-info {
	position: relative;
	background-color: #FFFFFF;
	
	.content {
		height: 100%;
		
		> .background {
			height: 5rem;
			background-image: url('../assets/svg/default_background.svg');
			background-size: cover;
		}
		
		.avatar {
			width: 4.2rem;
			height: 4.2rem;
			overflow: hidden;
			border: solid 0.2rem #FFFFFF;
			border-radius: 50%;
			margin-right: 1rem;
			background-size: cover;
			
			&.male {
				background-image: url('../assets/svg/male_avatar.svg');
			}
			
			&.female {
				background-image: url('../assets/svg/female_avatar.svg');
			}
			
			img {
				width: 100%;
			}
		}
		
		> .title {
			display: flex;
			align-items: center;
			padding: 0 1rem;
			margin-top: -1.5rem;
		}
		
		> .menu {
			display: flex;
			cursor: pointer;
			padding: 1rem;
			
			> .item {
				flex: 2;
				display: block;
				text-decoration: none;
				color: #414141;
				text-align: center;
				
				> .num {
					font-weight: bolder;
				}
				
				> .message {
					color: #828282;
					font-size: 1rem;
				}
				
				&:hover > .num {
					color: #2979FF;
				}
			}
		}
	}
}
</style>
