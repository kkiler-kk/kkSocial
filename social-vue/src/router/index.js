import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/Home.vue'),
		meta: {
			title: '首页 - SOCIAL'
		}
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue'),
		meta: {
			title: '登录 - SOCIAL'
		}
  },
  {
    path: '/sign-up',
    name: 'SignUp',
    component: () => import('@/views/SignUp.vue'),
		meta: {
			title: '注册 - SOCIAL'
		}
  },
  {
    path: '/*',
    name: 'NotFound',
    component: () => import('@/views/NotFound.vue'),
		meta: {
			title: 'NotFound - SOCIAL'
		}
  }
]

const router = new VueRouter({
	// mode: 'history',
  routes
});

router.beforeEach((to, from, next) => {
	document.title = to.meta.title,
	next();
});

export default router;
