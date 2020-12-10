import {msg} from "./Msg" 
import {protobufjs} from "./protobuf" 
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
    },

	start () {

        websocket.connect("ws://127.0.0.1:12345/ws");
       // websocket.connect("ws://127.0.0.1:8080/ws/asset");
	   //websocket.send_data("data is String");
    },
    // called every frame
    update: function (dt) {

    },
});
