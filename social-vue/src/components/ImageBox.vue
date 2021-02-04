<template>
	<div class="imgbox">
		<div class="grid" :class="{'four': list.length === 4, 'one': list.length === 1}" v-if="!boxIsOpen">
			<div 
			class="img" 
			v-for="(url, index) of list" 
			@click="setIndex(index)"
			:style="{
				backgroundImage: 'url('+ basicPath + url +')'
			}"
			:key="'img' + index">
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
				<div class="item" @click="rotate(-1)">
					<eva-icon name="corner-left-down" fill="#2979FF"></eva-icon>
					<span>向左旋转</span>
				</div>
				<div class="item" @click="rotate(1)">
					<eva-icon name="corner-right-down" fill="#2979FF"></eva-icon>
					<span>向右旋转</span>
				</div>
			</div>
			<div class="img">
				<div class="left" v-if="now > 0" @click="now -= 1"></div>
				<img :class="'r' + rotateState" :src="basicPath + list[now]" alt="动态图片" @click="closeBox()"/>
				<div class="right" v-if="now < list.length - 1" @click="now += 1"></div>
			</div>
			<div class="index" v-if="list.length > 1">
				<div 
					class="img" 
					v-for="(url, index) of list" 
					:class="{'now': index === now}"
					@click="setIndex(index)"
					:style="{
						backgroundImage: 'url('+ basicPath + url +')'
					}"
					:key="'img' + index">
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
			rotateState: 0,
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
		},
		rotate: function(state) {
			this.rotateState += state;
			if (this.rotateState > 3) this.rotateState = 0;
			if (this.rotateState < 0) this.rotateState = 3;
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
			background-repeat: no-repeat;
			background-size: cover;
			background-position: center center;
		}
		
		&.four {
			grid-template-columns: repeat(2, 7rem);
		}
		
		&.one {
			grid-template-columns: 14rem;
			grid-template-rows: 10rem;
			
			> .img {
				width: 14rem;
				height: 10rem;
			}
		}
	}
	
	.box {
		.menu {
			display: flex;
			background-color: #E3F2FD;
			color: #2979FF;
			font-size: 0.9rem;
			user-select: none;
			
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
			position: relative;
			display: grid;
			place-items: center;
			background-color: #E3F2FD;
			user-select: none;
			
			.left {
				position: absolute;
				top: 0;
				bottom: 0;
				left: 0;
				// background: #00000020;
				width: 30%;
				cursor: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACIAAAA8CAYAAAADm2gpAAAAAXNSR0IArs4c6QAAAsVJREFUaAXtmUur2kAUx5NYUXtFiwtx0UU30iLcRWlx4aa4E8W29wv0G/QLlO5vP0BpN1210G0X9YlQC4ILKYLQhctaaF0IPrjx/Uj/I02ITXI1cSZCyUBwPJnM+eU/J5k5GZ6zsRSLxbs8z7/dbDYPXS5Xb7VaXWYymXc2InBcLpdLAkTsdDrr+XwuDQYDqVqtXhUKhRcEhLeDhkBAgc/xePwsFAopLmezGQeYWTgcDgiKlVHFCIK483q9nNvtXnS73TtMQa6DICCLxYIcHqj18wYxsCj7ICRJ4prN5hjB+zqdTs+ZKHIIRKPRmIxGo68+n+8lEYJ6sB4KMRwOqx6P52kymVxRB7EKQRXkGAhqIMdCUAGhAXE0CC2Io0BoQlgGoQ1hCYQFhGkQVhCmQFhCHAzCGoKA7J30TEB8Uc8dpHMz5dpJzyTEhTyBmQGQ2xqC2AlBYHRB7IbQBTkFhAbkVBA7IKeEUEAOhBj/Xd4d9XQQp3qFL5fL95ACfvs3+ZEbk9U2FrpMIYgvAY7exGIxnzoDsxtiCwI1HkQiEd03LPKOYb/f/443JpPhkG94CyIIQm8ymahtSj0ajd5CAnSO8xnFyKgirNfrV61WS4QyGheBQIBLJBI3AfsRAf1Y04C2AZ8LPtRqNRFQCBltQUYmoc2YOQxc8w6M3vA6yuipQmyOMo4yRgoY2Z2Y+e+UyefzT4xuiordTMw4MFBrp8hLCEeZHVnwx1Fm37LTiRmjmMGe3iMqLzejTuB474K81+uR7OA36UP3Q41R52btBKZUKr33+/0XyI/OkB9puqhUKiSNOdee0TS1bkCWKKVSqWeiKH6q1+tjvSQOe78ubDBeWfdi4kr1MGEzUQmXdru9hGI10hXToVGzEhh8ArnE7/NgMLiYTqfCcrn8gSOdzWZ/2QYiQ+EpuY36fQB1sbvZxPBtk+4/aTj+WpXZtpcAAAAASUVORK5CYII=), url("//s1.hdslb.com/bfs/static/blive/live-assets/canvas/photo-imager/cursor.left.cur?v1"), pointer;
			}
			
			.right {
				position: absolute;
				top: 0;
				bottom: 0;
				right: 0;
				// background: #00000020;
				width: 30%;
				cursor: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACIAAAA8CAYAAAADm2gpAAAAAXNSR0IArs4c6QAAAhNJREFUaAXtmb9OwlAUxttLiYkV0plB4sgLODC5QRTiYqIbcXDyHXwMEyMMbg7GBfmzEBISIDHdGYU3KLQQEwp4LvHE5oJJIfTS4XQ5vdDe+/V3Ttp+PaoCW7PZ1BzHuY1Go2fz+bwfiUSKmUzmi/8na1Or1eoBY8w0DOMkkUjo4/HY7ff737PZrJDL5d5lCVFAyINpms7Csw2Hw0W9Xh+Xy+UrWUIYpOEimUzq3gXj8biSTqcPIVUvssQwVVWt6XTq1bHcj8ViUsUwEPHY6/UcqIm9i1FqtdpTq9VyXNf1VMrf7mg0klMzsKQKxVkiMWJREBmRCI6JDJIQI5ERieA4dGTgDlwMzU2PxGCdeCOvGSLjJYL7RAZJiJHIiERwTGSQhBg3JHPOz1fFSXY15mLghfxZ1/UbMGs6GLmVqS3LUrrdrgWG7pit/LujH8C4LbLZ7B146dd2uz1c55vAbyvcyNm2fRqYEH49XIzf69L8HrjNcfx5BKm5htQc/ZcaoKFAaj63md/XOb8PRduHe1wWq69JNz1oAxHBffYgEZg2IkEkkABGqgkigQQwUk0QCSSAkWqCSCABjGGpCd4m8fOiG9w7ZqVSuWw0GvsVAWlhmqbdp1Kptb6De45OpzOBLlchn8+/YRqDiLynZ0ATcWVumSL44gwM0MdgMJh4lcgWwdcOTQN6+VlCaMl/gU8tyW7J/wCJLeOSU2dAQgAAAABJRU5ErkJggg==), url("//s1.hdslb.com/bfs/static/blive/live-assets/canvas/photo-imager/cursor.right.cur?v1"), pointer;
			}
			
			> img {
				max-width: 100%;
				max-height: 40rem;
				cursor: zoom-out;
				
				&.r1 {
					transform: rotate(90deg);
				}
				
				&.r2 {
					transform: rotate(180deg);
				}
				
				&.r3 {
					transform: rotate(270deg);
				}
			}
		}
		
		.index {
			display: flex;
			padding: 0.5rem 0 0.5rem 1%;
			
			> .img {
				height: 0;
				width: 10%;
				padding-bottom: 10%;
				margin-right: 1%;
				cursor: pointer;
				border-radius: 0.3rem;
				opacity: 0.5;
				box-sizing: content-box;
				background-repeat: no-repeat;
				background-size: cover;
				background-position: center center;
				
				&.now {
					border: solid 1px #2979FF;
					opacity: 1;
				}
			}
		}
	}
}
</style>
