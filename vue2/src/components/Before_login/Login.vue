<template>
  <div id="box" style="margin-top: 140px">
    <div style="justify-content: center;display: flex;">
      <el-card>
        <el-form id="form" style="width: 400px;" :ref="user1" :model="user1":rules="rules"  >
          <h2>用户登录</h2>
          <div class="verticalBar"></div>
          <el-form-item label="用户名" prop="userName" style="margin-top: 20px">
            <el-input type="account"  v-model="user1.account" placeholder="请输入用户名" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="passWord">
            <el-input type="password"  v-model="user1.password" placeholder="请输入密码" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button id="commit" type="primary" v-on:click="commit">登录</el-button>
            <el-button id="regist" type="primary" v-on:click="regist">注册</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </div>
</template>

<script>
  import jwt from 'jwt-decode';
  import {isInteger, isDecimal, isPort, validatePhone} from "../../js/validator";

  export default {
        data(){
          return{
            user1:{
              account:'',
              password:'',
            },
            userToken:'',
            rules:{
              account:[{required:true,message:'账户不能为空',trigger:'blur'},
                {validator:validatePhone, trigger:'blur'}
              ],
              passWord:[{
                required:true,message:'密码不能为空',trigger:'blur'
              },
                {min: 6, max: 20, message: '密码长度6-20字符', trigger: 'blur'}
              ]
            }
          }
        },
      methods:{
        commit(){
          var loginMessage = this.user1;
          if(loginMessage.account === ''|| loginMessage.password === ''){
            alert('账号或密码不能为空')
          }else{
            alert(JSON.stringify(this.user1))
            this.$axios.post(('http://localhost:8025/user/login'),loginMessage,{
                   }).then(res=>{
              console.log("请求发送了"+res.data)
              console.log("登陆前:"+localStorage.getItem('token'))
              this.$router.push("/").catch(()=>{})
            })
          }
        },
        regist(){
            alert("准备跳转至注册页面")
        }
      }
    }
</script>

<style scoped>
  .verticalBar{
    width: 410px;
    height: 2px;
    background: lightblue;
    display: block;
    margin-top: 10px;
    vertical-align: top;
    margin-right: 0px;
    margin-left: 0px;
  }

</style>
