import Vue from 'vue'
import Router from 'vue-router'
import router from '../router'
import Login from "../components/Before_login/Login";
import HelloWorld from "../components/HelloWorld";
import video from "../components/Test/video"
import RegistUser from "../components/Before_login/RegistUser"
import mainView from "../components/Main/mainView";
import indexView from "../components/Main/indexView";
import testView1 from "../components/Main/DetailView/testView1";
import testView2 from "../components/Main/DetailView/testView2";
import test1 from "../components/Main/test1";
Vue.use(Router)

export default new Router({

  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/Login',
      name:'Login',
      component:Login
    },
    {
      path:'/video',
      name:video,
      component:video
    },
    {
      path:'/RegistUser',
      name:RegistUser,
      component:RegistUser
    },
    {
      path:'/mainView',
      name:mainView,
      component:mainView
    },
    {
      path:'/indexView',
      name:indexView,
      component:indexView,
      children:[
        {
          path:'/testView1',
          name:testView1,
          component:testView1,
        },
        {
          path:'/testView2',
          name:testView2,
          component:testView2,
        },
        ]
    },
    {
      path:'/test1',
      name:test1,
      component:test1,
    },

  ],
})

router.beforeEach((to, from, next) => {
//to到哪儿  from从哪儿离开  next跳转 为空就是放行
  if (to.path === '/Login') {
    //如果跳转为登录，就放行
    next();
  } else {
    //取出localStorage判断
    let token = localStorage.getItem('token');
    console.log("token"+token)
    if (token == null || token === '') {
      console.log('请先登录')
      // next({name: '/'});
      next("/Login")
    } else {
      next();
    }
  }});

