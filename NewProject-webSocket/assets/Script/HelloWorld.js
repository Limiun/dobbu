
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
	
       // websocket.connect("ws://127.0.0.1:8080/ws?uid=666^&amp=777");
        websocket.connect("ws://127.0.0.1:8080/ws/asset");
    },
    // called every frame
    update: function (dt) {

    },
});
