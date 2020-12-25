<template>
	<div id="not-found" class="container">
		<div class="content">
			<img src="../assets/svg/page_not_found.svg" alt="404 Not Found">
			<h3>Thank you for visiting, although we still have nothing.</h3>
			<p><router-link to="/">Back to home.</router-link></p>
		</div>
	</div>
</template>

<script>
</script>

<style lang="scss">
#not-found {
	display: grid;
	place-items: center;
	height: 100%;
	line-height: 3rem;
	text-align: center;

	img {
		max-width: 70%;
	}

	a {
		font-weight: bolder;
		text-decoration: none;
		color: #2979FF;
	}
}
</style>
