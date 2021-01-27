<template>
	<div class="imgbox">
		<div class="grid" :class="{'four': list.length === 4, 'one': list.length === 1}" v-if="!boxIsOpen">
			<div 
			class="img" 
			v-for="(url, index) of list" 
			@click="setIndex(index)"
			:key="'img' + index">
				<img :src="basicPath + url" alt="动态图片"/>
			</div>
		</div>
		<div class="box" v-if="boxIsOpen">
			<div class="menu">
				<div class="item" @click="closeBox()">
					<eva-icon name="collapse" fill="#2979FF"></eva-icon>
					<span>收起</span>
				</div>
				<div class="item">
					<eva-icon name="search" fill="#2979FF"></eva-icon>
					<span>查看大图</span>
				</div>
				<div class="item">
					<eva-icon name="corner-left-down" fill="#2979FF"></eva-icon>
					<span>向左旋转</span>
				</div>
				<div class="item">
					<eva-icon name="corner-right-down" fill="#2979FF"></eva-icon>
					<span>向右旋转</span>
				</div>
			</div>
			<div class="img">
				<div class="left"></div>
				<img :src="basicPath + list[now]" alt="动态图片" @click="closeBox()"/>
				<div class="right"></div>
			</div>
			<div class="index">
				<div 
					class="img" 
					v-for="(url, index) of list" 
					:class="{'now': index === now}"
					@click="setIndex(index)"
					:key="'img' + index">
					<img :src="basicPath + url" alt="动态图片"/>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: 'ImageBox',
	props: {
		list: Array
	},
	data: function () {
		return {
			basicPath: this.$store.state.basicPath,
			now: 0,
			boxIsOpen: false,
		}
	},
	methods: {
		setIndex: function (i) {
			this.boxIsOpen = true;
			this.now = i;
		},
		closeBox: function () {
			this.boxIsOpen = false;
		}
	}
}
</script>

<style lang="scss">
.imgbox {
	// background-color: #42B98341;
	
	.grid {
		display: grid;
		grid-template-columns: repeat(3, 7rem);
		grid-gap: 0.5rem;
		
		> .img {
			width: 7rem;
			height: 7rem;
			border-radius: 0.3rem;
			cursor: zoom-in;
			overflow: hidden;
			
			img {
				width: 100%;
			}
		}
		
		&.four {
			grid-template-columns: repeat(2, 7rem);
		}
		
		&.one {
			grid-template-columns: 14rem;
			grid-template-rows: 7rem;
		}
	}
	
	.box {
		.menu {
			display: flex;
			background-color: #E3F2FD;
			color: #2979FF;
			font-size: 0.9rem;
			
			.item {
				display: flex;
				line-height: 2.5rem;
				padding: 0 0.5rem;
				cursor: pointer;
			}
				
			i {
				display: grid;
				place-items: center;
				margin-right: 0.3rem;
			}
		}
		
		> .img {
			display: grid;
			place-items: center;
			background-color: #E3F2FD;
			
			> img {
				cursor: zoom-out;
			}
		}
		
		.index {
			display: grid;
			grid-template-columns: repeat(9, 1fr);
			grid-gap: 0.5rem;
			padding: 0.5rem 0;
			
			> .img {
				cursor: pointer;
				overflow: hidden;
				border-radius: 0.3rem;
				opacity: 0.5;
				
				img {
					width: 100%;
					height: 100%;
				}
				
				&.now {
					border: solid 4px #2979FF;
					opacity: 1;
				}
			}
		}
	}
}
</style>
