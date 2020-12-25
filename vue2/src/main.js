// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store/index.js'
import Vuex from 'vuex'
Vue.use(Vuex)
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$axios = axios
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})

axios.interceptors.request.use(config=>{
  if (config.push === '/'){
  } else {
    if (localStorage.getItem('token')) {
      console.log("向后端请求前，将token放入headers;"+localStorage.getItem('token'));
      //在请求头加入token，名字要和后端接收请求头的token名字一样
      config.headers.token = localStorage.getItem('token');
      // config.headers.token=localStorage.getItem('token');
    }else {
      console.log("失败： 向后端请求前，将token放入headers");
    }
  }
    return config;
  },error =>{
    return Promise.reject(error);
});
//响应回来token是否过期
axios.interceptors.response.use(response => {
    console.log('响应回来：'+response.data.code)
    console.log('响应回来：'+response.data.token)
    //和后端token失效返回码约定403
    if (response.data.code != 1) {
      // 引用elementui message提示框
      ElementUI.Message({
        message: '身份已失效',
        type: 'err'
      });
      //清除token
      localStorage.removeItem('token ');
      console.log("清楚token________________________")
      //跳转
      this.$router.push("/Login").catch(()=>{})
      // router.push({name: 'Login'});
    } else {
      localStorage.setItem('token',response.data.token)
      return response
    }
  },
  error => {
    return Promise.reject(error);
  })
