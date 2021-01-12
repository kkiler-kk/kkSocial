import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
		token: '',
		user: null,
		isLogin: false
  },
  mutations: {
		setToken (state, token) {
			state.token = token;
		},
		setUser (state, user) {
			state.user = user;
		},
		setLogin (state, isLogin) {
			state.isLogin = isLogin;
		}
  },
  actions: {
  },
  modules: {
  }
})
