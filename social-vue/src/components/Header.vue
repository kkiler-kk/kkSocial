<template>
	<div id="header">
		<div class="container">
			<router-link class="title" to="/">
				SOCIAL
			</router-link>
			
			<div class="menu">
				<div 
					class="item" 
					v-for="(link, index) of links" 
					:title="link.title"
					:key="'l' + index">
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
	}
}
</script>

<style lang="scss">
#header {
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
	
	.menu {
		display: flex;
		cursor: pointer;
		
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
