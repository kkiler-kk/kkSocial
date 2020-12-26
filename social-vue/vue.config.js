module.exports = {
  outputDir: '../social-server/src/main/resources/static',
	devServer: {
		proxy: {
			'/api': {
				target: 'http://localhost:8800/',
				changOrigin: true,
				pathRewrite: {
					'^/api': ''
				}
			}
		}
	}
}