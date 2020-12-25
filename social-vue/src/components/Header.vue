<template>
	<div id="header">
		<div class="container">
			<div class="title">
				TITLE
			</div>
			
			<div class="menu">
				<div 
					class="item" 
					v-for="(link, index) of links" 
					:title="link.title"
					:key="'l' + index">
					<router-link :to="link.url">
						<i :data-eva="link.iconData" 
							data-fill="#424242">
						</i>
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
	methods: {
		onLink: function(e) {
			e.target.setAttribute("data-fill", "#2979FF");
		},
		outLink: function(e) {
			e.target.setAttribute("data-fill", "#424242");
		}
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
