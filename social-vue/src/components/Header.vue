<template>
	<div id="header">
		<div class="container">
			<router-link class="title" to="/">
				SOCIAL
			</router-link>
			
			<div class="search">
				<input type="text" placeholder="搜索"/>
				<eva-icon class="icon" name="search" fill="#424242">
				</eva-icon>
			</div>
			
			<div class="menu">
				<div class="avatar male" v-if="this.$store.state.isLogin">
					<img v-if="user && user.url" :src="basicPath + user.url" :alt="user.name">
				</div>
				<div 
					class="item" 
					v-for="(link, index) of links" 
					:title="link.title"
					:key="'l' + index"
					@click="exec(link)">
					<router-link :to="link.url">
						<eva-icon :name="link.iconData" fill="#424242" animation="pulse">
						</eva-icon>
					</router-link>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: 'Header',
	props: {
		links: Array
	},
	data: function () {
		return {
			basicPath: this.$store.state.basicPath
		};
	},
	methods: {
		exec: function (link) {
			if (link.handle) link.handle();
		}
	},
	computed: {
		user: function () {
			return this.$store.state.user;
		}
	}
}
</script>

<style lang="scss">
#header {
	position: relative;
	line-height: 3.5rem;
	font-size: 1.5rem;
	font-weight: bolder;
	box-shadow: 0 0 1rem #21212161;
	background-color: #FFFFFF;
	z-index: 1;
	
	> .container {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	a {
		color: #414141;
		text-decoration: none;
		font-weight: bolder;
	}
	
	.search {
		position: relative;
		align-items: center;
		
		> input {
			flex: 2;
			width: 24rem;
			border: none;
			border-bottom: solid 1px #414141;
			outline: none;
			line-height: 1.5rem;
		}
		
		> .icon {
			position: absolute;
			top: 0;
			bottom: 0;
			right: 0;
			display: grid;
			place-items: center;
			transform: scale(0.8);
		}
	}
	
	.avatar {
		overflow: hidden;
		border-radius: 50%;
		// margin-right: 0.5rem;
		width: 2.5rem;
		height: 2.5rem;
		background-size: cover;
		
		img {
			width: 100%;
			height: 100%;
		}
			
		&.male {
			background-image: url('../assets/svg/male_avatar.svg');
		}
		
		&.female {
			background-image: url('../assets/svg/female_avatar.svg');
		}
	}
	
	.menu {
		display: flex;
		cursor: pointer;
		align-items: center;
		
		> .item {
			display: block;
			width: 3rem;
			height: 3rem;
			text-align: center;
			
			a {
				color: #424242;
				text-decoration: none;
				
				&:hover {
					color: #2979FF;
				}
			}
			
			&:hover {
				color: #2979FF;
			}
		}
	}
}
</style>
