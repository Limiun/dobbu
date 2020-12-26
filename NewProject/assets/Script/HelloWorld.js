var websocket = require("websocket");
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
		console.log("test@@@@@@@@@@");
		websocket.connect("ws://127.0.0.1:12345/ws");
		//var role = this;
		//let test = $root.test1Msg.create({id:1,name:"yxy",age:22,state:1});
		//console.log("finish@@@@@@@@@@"+test);
		//let messageBuf = role.test1Msg.encode(test).finish();////获取二进制数据，一定要注意使用finish函数
		//websocket.send_data(messageBuf);
		//console.log("finish@@@@@@@@@@");
        this.label.string = this.text;
    },

    // called every frame
    update: function (dt) {

    },
});
