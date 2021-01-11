<template>
	<div id="news">
		<components :is="getState" v-bind="getStateProps"></components>
	</div>
</template>

<script>
import Retry from '@/components/Retry.vue';
import NewsList from '@/components/NewsList.vue';
import Loading from '@/components/Loading.vue';

/*
 * state 字段
 * 获取动态的结果状态
 * 可能有如下值
 * 0 'executing' 执行中
 * 1 'success' 成功
 * -1 'failure' 失败
 */
export default {
	name: 'News',
	data: function () {
		return {
			state: 0,
			news: [],
			pageNum: 0,
			pageSize: 10
		};
	},
	methods: {
		setState: function (state) {
			this.state = state;
		},
		getNews: function () {
			this.setState(0);
			this.axios.post('/api/news/get-top', {
				pageNum: this.pageNum,
				pageSize: this.pageSize
			})
			.then(request => {
				let data = request.data;
				if (!data || !data.status) {
					this.setState(-1);
					return;
				}
				this.news = data.data.content;
				this.setState(1);
				// console.log(data);
			})
			.catch(() => this.setState(-1));
		}
	},
	computed: {
		getState: function () {
			const state = this.state;
			if (state > 0) {
				if (this.news.length > 0) return 'NewsList';
				return 'Retry';
			}
			if (state < 0) return 'Retry';
			return 'Loading';
		},
		getStateProps: function () {
			const state = this.state;
			if (state > 0) {
				if (this.news.length > 0) return { list: this.news };
				return {
					message: '暂无动态',
					buttonText: '刷新',
					clickHandle: this.getNews
				};
			}
			if (state < 0) return {
				message: '获取动态出错',
				buttonText: '重试',
				clickHandle: this.getNews
			};
			return {};
		}
	},
	mounted: function () {
		this.getNews();
	},
	components: {
		Retry,
		NewsList,
		Loading
	}
}
</script>

<style>
</style>
