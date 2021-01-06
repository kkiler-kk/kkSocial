<template>
	<div class="news">
		{{data}}
	</div>
</template>

<script>
export default {
	name: 'News',
	data: function () {
		return {
			data: '',
			pageNum: 0,
			pageSize: 10,
		};
	},
	mounted: function () {
		this.data = '获取中';
		this.axios.get('/api/news/get-top', {
			params: {
				pageNum: this.pageNum,
				pageSize: this.pageSize
			}
		})
		.then(request => {
			if (!request.data) {
				this.data = '加载失败';
				return;
			}
			this.data = request.data;
		})
		.catch(() => this.data = '加载失败');
	}
}
</script>

<style>
</style>
