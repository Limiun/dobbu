<template>
 <div>
   <el-card>
     <el-form>
       <el-form-item label="用户名" prop="userName" style="margin-top: 20px">
         <el-input type="userName"  v-model="test.userName" placeholder="请输入用户名" autocomplete="off"></el-input>
       </el-form-item>
       <el-button v-on:click="dotest" id="dotest" type="primary"></el-button>
     </el-form>
   </el-card>
 </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      test:{
        userName: ''
      }
    }
  },
  methods:{
    dotest(){
      var item = this.test
      this.$axios.post(('http://192.168.13.131:8034/es/a/list'),item,{
      }).then(res=>{
        this.tt = res.data.test
        console.log(res)
        console.log(res.data.userName)
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
