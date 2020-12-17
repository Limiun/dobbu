<template>
  <el-button id="commit" type="primary" v-on:click="commit">登录</el-button>
</template>

<script>
    export default {
      passport: "Regist",
      methods:{
        commit(){
          var passport = this.password
          this.$axios.get(('http://localhost:8087/backend/access/loginNoPassWord'),passport,{
          // this.$axios.get(('http://localhost:8087/backend/findPayItemStr'),passport,{
            }).then(res=>{
              console.log("请求发送了")
            })
          }
        },
    }
</script>

<style scoped>

</style>
