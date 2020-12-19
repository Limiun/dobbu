<template>
    <div id="box" style="margin-top: 140px">
      <div style="justify-content: center;display:flex">
        <el-card>
          <el-form id="form" style="width: 400px" :ref="user" :model="user" :rules="rules">
            <h2>注册</h2>
            <div class="verticalBar"></div>
            <el-from-item label="登录账号" prop="userName" style="margin-top: 20px">
              <el-input type="account"  v-model="user.account" placeholder="请输入用户名" autocomplete="off"></el-input>
            </el-from-item>
            <el-form-item label="密码" prop="passWord">
              <el-input type="password"  v-model="user.password" placeholder="请输入密码" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="显示名" prop="username">
              <el-input type="username"  v-model="user.username" placeholder="请输入显示名" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
              <el-input type="sex"  v-model="user.sex" placeholder="请输入性别" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="年龄" prop="age">
              <el-input type="age"  v-model="user.age" placeholder="请输入年龄" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phone">
              <el-input type="phone"  v-model="user.phone" placeholder="请输入电话" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button id="commit" type="primary" v-on:click="commit">注册</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>

    </div>
</template>

<script>
    export default {
        name: "RegistUser"
      data(){
          return{
            user:{
              account:'',
              password:'',
              username:'',
              sex:'',
              age:'',
              account:'',

            }
          }
      }
    }
</script>

<style scoped>

</style>
