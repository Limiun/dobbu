import {msg} from "./Msg" //这里引入文件,msg为package的包名
var websocket = require("./websocket.js");
cc.Class({
    extends: cc.Component,

    properties: {
        label: {
            default: null,
            type: cc.Label
        },
        // defaults, set visually when attaching this script to the Canvas
        text: 'Hello, World!'
    },

    // use this for initialization
    onLoad: function () {
        this.label.string = this.text;
		this.label.string = "你好1"//this.text
		this.testProtobuf();
		return;
    },

    // called every frame
    update: function (dt) {

    },
	onMessage:function(obj){
        console.log("It's HelloWorld onMessage----->"+obj);
    },
	onDestroy:function(){
        onfire.un(this.msssageFire);

    },
	testProtobuf: function () {
        if (cc.sys.isNative) {//在native上加载失败，是因为没有找到目录，我们在testProtobuf函数里面添加一个搜索目录:
            cc.log("jsb.fileUtils=" + jsb.fileUtils);

            //下面这段代码在PC window平台运行没问题，但是在android下面就出问题了
            //jsb.fileUtils.addSearchPath("res\\raw-assets\\resources", true);
            //需要改成这样：
            jsb.fileUtils.addSearchPath("res/raw-assets/resources", true);//坑太多了。。没办法
        }

        var filename1 = "test1.proto";
        // cc.loader.loadRes(filename1, cc.TextAsset, function (error, result) {//指定加载文本资源
        //     cc.log("loadRes error=" + error + ",result = " + result + ",type=" + typeof result);
        //     // callback(null, result);
        // });

        var protobufHere = protobuf;//require("protobuf");//导入为插件，直接使用
        protobufHere.load(filename1, function (err, root) {//Data/PbLobby.proto
            if (err)
                throw err;

            cc.log("root=" + root);
            for (var i in root) {
                cc.log("root." + i + "=" + root[i]);
            }
            //return;

            cc.log("加载protobuf完毕，开始测试protobuf...")

            var cmd = root.lookupEnum("PbLobby.Cmd");
            cc.log(`cmd = ${JSON.stringify(cmd)}`);
            cc.log("CMD_KEEPALIVED_C2S = "+cmd.values.CMD_KEEPALIVED_C2S);

            //lookup 等价于 lookupTypeOrEnum 
            //不同的是 lookup找不到返回null,lookupTypeOrEnum找不到则是抛出异常
            var type1 = root.lookup("PbLobby.Cmd1");
            cc.log("type1 = "+type1);
            var type2 = root.lookup("PbLobby.Test1");
            cc.log("type2 = "+type2);

            // Obtain a message type
            var Test1Message = root.lookupType("PbLobby.Test1");
            cc.log("Test1Message = "+Test1Message);

            // Exemplary payload
            var payload = { id: 1,name:"hello protobuf" };
            //var payload = { ids: 1,name:"hello protobuf" };
            cc.log(`payload = ${JSON.stringify(payload)}`);

            //检查数据格式，测试了下发现没什么卵用
            // Verify the payload if necessary (i.e. when possibly incomplete or invalid)
            // var errMsg = Test1Message.verify(payload);
            // if (errMsg){
            //     cc.log("errMsg = "+errMsg);
            //     throw Error(errMsg);
            // }
                
            //过滤掉一些message中的不存在的字段
            // Create a new message
            var message = Test1Message.create(payload); // or use .fromObject if conversion is necessary
            cc.log(`message = ${JSON.stringify(message)}`);

            // Encode a message to an Uint8Array (browser) or Buffer (node)
            var buffer = Test1Message.encode(message).finish();
            cc.log("buffer1 = "+buffer);
            cc.log(`buffer2 = ${Array.prototype.toString.call(buffer)}`);
            // ... do something with buffer

            // Decode an Uint8Array (browser) or Buffer (node) to a message
            var decoded = Test1Message.decode(buffer);
            cc.log("decoded1 = "+decoded);
            cc.log(`decoded2 = ${JSON.stringify(decoded)}`);
            // ... do something with message

            // If the application uses length-delimited buffers, there is also encodeDelimited and decodeDelimited.

            //一般情况下，也不需要下面的转换
            // Maybe convert the message back to a plain object
            var object = Test1Message.toObject(decoded, {
                longs: String,
                enums: String,
                bytes: String,
                // see ConversionOptions
            });
            cc.log("object = "+JSON.stringify(object));
			cc.log("######################################################################");
			let messagetest = msg.Login.create({name: "hello", pwd: "pwd"});//构造对象
			let messageBuftest = msg.Login.encode(messagetest).finish(); //获取二进制数据，一定要注意使用finish函数
			cc.log(messagetest);
			cc.log(messageBuftest);
			websocket.connect("ws://127.0.0.1:12345/ws?uid=666^&amp=777");
			//websocket.connect("ws://127.0.0.1:12345/ws");
			
        });
	
    },
	start () {
        websocket.connect("ws://127.0.0.1:12345/ws?uid=666^&amp=777");
    },
});
