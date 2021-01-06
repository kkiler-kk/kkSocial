<template>
  <div id="home" class="container">
		<News/>
  </div>
</template>

<script>
import News from '@/components/News.vue';

export default {
	name: 'Home',
	components: {
		News
	}
}
</script>

<style>
#home {
	padding: 2rem;
}
</style>
