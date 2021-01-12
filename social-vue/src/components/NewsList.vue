<template>
	<ul id="news-list">
		<li v-for="(item, index) of list" :key="'n' + index">
			<div class="left">
				<div class="avatar">
					<img :src="'http://localhost:8800' + item.user.url" :alt="item.user.name" v-show="item.user">
				</div>
			</div>
			<div class="message">
				<div class="title">
					<span>{{item.user ? item.user.name : "name"}}</span>
					<eva-icon class="right-icon" name="more-vertical-outline" fill="#424242" animation="pulse"></eva-icon>
				</div>
				<div class="date">{{item.create_date}}</div>
				<div class="content">
					{{item.content_text}}
				</div>
				<div class="menu">
					<div class="item">
						<eva-icon name="flip-2-outline" fill="#848484" animation="pulse"></eva-icon>
						{{item.share_num ? item.share_num : ""}}
						<!-- {{item.share_num}} -->
					</div>
					<div class="item">
						<eva-icon name="message-square-outline" fill="#848484" animation="pulse"></eva-icon>
						{{item.comment_num ? item.comment_num : ""}}
						<!-- {{item.comment_num}} -->
					</div>
					<div class="item">
						<eva-icon name="heart-outline" fill="#848484" animation="pulse"></eva-icon>
						{{item.like ? item.like : ""}}
						<!-- {{item.like}} -->
					</div>
				</div>
			</div>
		</li>
	</ul>
</template>

<script>
export default {
	name: 'NewsList',
	props: {
		list: Array
	}
}
</script>

<style lang="scss">
#news-list {
	> li {
		display: flex;
		list-style: none;
		background-color: #FFFFFF;
		padding: 1rem;
		margin-bottom: 1rem;
		
		> .left {
			width: 4rem;
			margin-right: 1rem;
			
			.avatar {
				width: 4rem;
				height: 4rem;
				background-color: #42B98388;
				border-radius: 50%;
				overflow: hidden;
				
				> img {
					width: 100%;
				}
			}
		}
		
		> .message {
			flex: 1;
			
			> .title {
				display: flex;
				justify-content: space-between;
				font-weight: bolder;
				font-size: 1.2rem;
			}
			
			> .date {
				color: #848484;
				font-weight: bolder;
				font-size: 0.9rem;
			}
			
			> .content {
				padding: 1rem 0;
				line-height: 2rem;
			}
			
			> .menu {
				display: flex;
				cursor: pointer;
				color: #848484;
				
				> .item {
					flex: 1;
					line-height: 2rem;
					display: flex;
					
					i {
						margin-right: 1rem;
						display: grid;
						place-items: center;
					}
				}
			}
		}
	}
}
</style>
