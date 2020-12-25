<template>
    <div id="box" style="margin-top: 140px">
      <div style="justify-content: center;display:flex">
        <el-card>
          <el-form id="form" style="width: 400px" :ref="user" :model="user" :rules="rules">
            <h2>注册</h2>
            <div class="verticalBar"></div>
            <el-from-item  prop="userName" style="margin-top: 20px">
<!--              <span>登录账号 :</span>-->
              <el-input type="account"  v-model="user.account" placeholder="请输入用户名" autocomplete="off"></el-input>
            </el-from-item>
            <p></p>
            <el-form-item  prop="passWord">
              <p></p>
              <el-input type="password"  v-model="user.password" placeholder="请输入密码" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item  prop="username">
              <el-input type="username"  v-model="user.username" placeholder="请输入昵称" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
              <span>:</span>
<!--              <el-input type="sex"  v-model="user.sex" placeholder="请输入性别" autocomplete="off"></el-input>-->
              <div class="app" >
                <div class="boy">
                  <input type="radio" name="radios" value="1" v-model="param"><label>男</label>
                </div>
                <div class="girl">
                  <input type="radio" name="radios" value="2" v-model="param"><label>女</label>
                </div>
              </div>
            </el-form-item>
            <el-form-item prop="age">
              <el-input type="age"  v-model="user.age" placeholder="请输入年龄" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item prop="phone">
              <el-input type="phone"  v-model="user.phone" placeholder="请输入电话" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button id="commit" type="primary" v-on:click="regist">注册</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>

    </div>
</template>

<script>
  import {isInteger, isDecimal, isPort, validatePhone} from "../../js/validator";
  export default {
      data(){
          return{
            param:'1',//设置默认值为1，即设置第一个单选框为选中状态
            user:{
              account:'',
              password:'',
              username:'',
              sex:'',
              age:'',
              phone:'',
            },
            userToken:'',
            rules:{
              account:[{required:true,message:'账户不能为空',trigger:'blur'},
                {validator:validatePhone, trigger:'blur'}
              ],
              password:[{
                required:true,message:'密码不能为空',trigger:'blur'
              },
                {min: 6, max: 20, message: '密码长度6-20字符', trigger: 'blur'}
              ]
            }
          }
      },
      methods:{
          regist(){
            var registMessage = this.user;
            if (registMessage.account ===''|| registMessage.password === ''){
              alert('账号或密码不能为空')
            }else{
              console.log(JSON.stringify(this.user))
              this.$axios.post(("http://localhost:8025/user/user1"),registMessage,{
              }).then(res=>{
                console.log("注册请求发送了data："+res.data)
                console.log("注册的:localStorage.getItem："+localStorage.getItem('token'))
                this.$router.push("/Login").catch(()=>{})
              }).catch(()=>{
                console.log("为跳转："+res.data)
              })
            }
          }
      }
    }
</script>

<style scoped>
  .app{
    height:60px;
    background: #fff;
    border: 1px solid  #f1ebeb;
  }
  .boy{
    height:30px;
    background: fff;
    border-bottom: 1px solid  #f1ebeb;
  }
  .boy input{
    text-align: center;
  }
  .boy label{
    text-align: center;
  }


  .girl{
    height:30px;
    background: fff;
  }
</style>
