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
		console.log("finish@@@@@@@@@@");
        this.label.string = this.text;
    },

    // called every frame
    update: function (dt) {

    },
});
