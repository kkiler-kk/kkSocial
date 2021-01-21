<template>
  <div id="home" class="container">
		<UserInfo :isSlef="true"/>
		<News/>
  </div>
</template>

<script>
import News from '@/components/News.vue';
import UserInfo from '@/components/UserInfo.vue';

export default {
	name: 'Home',
	components: {
		News,
		UserInfo
	}
}
</script>

<style lang="scss">
#home {
	display: flex;
	align-items: flex-start;
	padding: 2rem;
	
	> div:nth-child(1) {
		width: 20rem;
		margin-right: 1rem;
	}
	
	> div:nth-child(2) {
		flex: 1;
	}
}
</style>
