<template>
	<ul id="news-list">
		<li v-for="(item, index) of list" :key="'n' + index">
			<div class="left">
				<div class="avatar" :class="[{'male': item.user.gender}, {'female': !item.user.gender}]">
					<img v-if="item.user.url !== ''" :src="basicPath + item.user.url" :alt="item.user.name" v-show="item.user">
				</div>
			</div>
			<div class="message">
				<div class="title">
					<span>{{item.user ? item.user.name : "name"}}</span>
					<eva-icon class="right-icon" name="more-vertical-outline" fill="#424242" animation="pulse"></eva-icon>
				</div>
				<div class="date">{{formatDate(item.create_date)}}</div>
				<div class="content">
					<p>{{item.content_text}}</p>
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
	},
	data: function () {
		return {
			basicPath: this.$store.state.basicPath
		};
	},
	methods: {
		formatDate: function (dateStr) {
			let date = dateStr.split(' ');
			let time = date[1];
			date = date[0].split('-');
			time = time.split(':');
			let last = new Date(date[0], date[1] - 1, date[2], time[0], time[1]);
			let now = new Date();
			let diff = ~~((now - last) / 1000 / 60);
			if (diff == 0) return '刚刚';
			if (diff < 60) return diff + ' 分钟';
			diff = ~~(diff / 60);
			if (diff < 24) return diff + ' 小时';
			if (diff == 24) return '昨天';
			if (diff < 48) return `昨天 ${time[0]}:${time[1]}`;
			if (now.getFullYear() == date[0]) return `${date[1]}-${date[2]}`;
			return dateStr.split(' ')[0];
		}
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
				background-size: cover;
				
				> img {
					width: 100%;
				}
			
				&.male {
					background-image: url('../assets/svg/male_avatar.svg');
				}
				
				&.female {
					background-image: url('../assets/svg/female_avatar.svg');
				}
			}
		}
		
		> .message {
			flex: 1 1 0;
			
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
				display: flex;
				padding: 1rem 0;
				line-height: 2rem;
				word-break: break-all;
				hyphens: auto;
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
