//import {role} from "./role"
//import (WebSocket) from "./WebSocket";
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
		console.log("websocket 连接开始")
		WebSocket.connect("ws://127.0.0.1:12345/ws?uid=666^&amp=777");
		
		
    },

    // called every frame
    update: function (dt) {
		console.log("test 连接开始")
    },
});
