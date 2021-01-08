/** 
websocket.js 导出的自己封装的websocket模块
   这个模块不要在里面写具体的功能
**/
var websocket = {
    sock: null,  // 连接的socket 对象 WebSocket, h5标准对象;
 
    // 网络连接成功了以后调用
    on_open: function(event) {
        // test
        this.send_data("HelloWorld");
        // end
    },
 
    // 客户端收到数据的时候
    on_message: function(event) {
		 console.log("#####1.这是客户端接收返回来的数据", event.data);
		let msg = new Uint8Array(event.data);
        console.log("#####2.这是客户端接收返回来的数据", msg);
		let message = $root.Message.decode(msg);
		/**
		这里的message拿到后应该做一个分发的处理，
		取到里面具体的消息（根据消息id）然后转到对应的处理方法里面去
		具体详细的功能在单个的里面去处理
		*/
		console.log("########3.这是msgType",message.msgType);
		console.log("########3.这是msg",message);
    },
 
    // 客户端收到socket 关闭的时间的时候调用;
    on_close: function (event) {
        this.close();
    },
 
    on_error: function (event) {
        this.close();
    }, 
 
    close: function() {
        if (this.sock != null) {
            this.sock.close(); // 关闭socket
            this.sock = null;
        }
    },
 
    // 连接函数, 
    connect: function(url) {
        this.sock = new WebSocket(url); // h5标准的websocket对象
        this.sock.binaryType = "arraybuffer"; // 配置接受二进制的数据类型,与服务器保持一次, "Blob"
 
        // 为这个websocket对象制定对应的回掉函数;
        this.sock.onopen = this.on_open.bind(this);
        this.sock.onmessage = this.on_message.bind(this);
        this.sock.onclose = this.on_close.bind(this);
        this.sock.onerror = this.on_error.bind(this);
    },
 
    // 发送数据, sock.send;
    send_data: function(data) {
        this.sock.send(data);
    },
};
 
 
module.exports = websocket;