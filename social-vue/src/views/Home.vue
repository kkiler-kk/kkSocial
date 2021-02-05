<template>
  <div id="home" class="container">
		<UserInfo :isSlef="true"/>
		<News/>
		<UserInfo :isSlef="true"/>
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
	padding: 0.5rem 2rem;
	
	> div:nth-child(1) {
		width: 16rem;
		margin-right: 1rem;
	}
	
	> div:nth-child(2) {
		flex: 1;
		margin-right: 1rem;
	}
	
	> div:nth-child(3) {
		width: 16rem;
	}
}
</style>
