This is test
1、创建本地仓库 在任意文件下git init
2、在这个文件夹下创建或存放所需要上传的文件
3、git add . （后面一个 . ，把所有的新东西提交，对于已有的项目理解为提交所有的已修改文件到暂存区）
4、git commit 把项目提交到仓库
5、因为本地的git 仓库和github仓库之间的传输时通过ssh加密的，所以设置一下连接
	（1）创建ssh key 先看一下C:\Users\Administrator\.ssh 有没有id_rsa和id_rsa.pub这两个文件（没有就创建 ssh-keygen -t rsa -C “940811787@qq.com”）
	（2）登录github ,找到setting 中的ssh and GPG KEYS,点击右上角的NEW SSH key,r然后title随便填，把刚刚生成的id_rsa.pub内的内容复制到Title下面的key内容框里面，最后点击Add ssh key ，就完成了ssh key的加密
6、github 上建立仓库 创建好后生成的里面的ssh是等下要使用的
7、git remote add origin  http:.........(这里就是上述的ssh地址)
8、推送，现在关联好后可以把本地库的所有内容推送到远程仓库（github）上，通过：$git push -u origin master




protobuf :
在目录下新建一个proto文件，参考msg.proto,（里面的package为包名msg）
使用如下命令将msg.proto文件转为对应的js版本文件Msg.js
::protobuf.js版本6.x生成js文件
pbjs -t static-module -w commonjs -o Msg.js msg.proto 

修改Msg.js文件对应内容
//var $protobuf = require("protobufjs/minimal"); //将源文件中的这一行屏蔽，然后新增下面一行
var $protobuf = protobuf;

将Msg.js拖放到Creator中

写一个WebSocket的处理脚本挂载到场景中即可。

import {msg} from "./Msg"  //这里引入文件,msg为package的包名
	

目录结构：
	assets
		resources
			msg.proto
			msg.proto.meta
			......
		Scene
		script
			Msg.js
			Msg.js.meta
			......
		Texture
		......
		
		