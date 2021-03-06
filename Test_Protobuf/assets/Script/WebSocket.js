var websocket = {
	sock:null
	on_open function(){
	}
	on_message: function(event) {
        console.log("client rcv data=" + event.data);
    },

    on_close: function() {
        this.close();
    },

    on_error: function () {
        this.close();
    },

    close: function () {alipay
        if(this.sock){
            this.sock.close();
            this.sock = null;
        }
    },
	connect: function(url) {
        this.sock = new WebSocket(url);
        this.sock.binaryType = "arraybuffer";
        this.sock.onopen = this.on_open.bind(this);
        this.sock.onmessage = this.on_message.bind(this);
        this.sock.onclose = this.on_close.bind(this);
        this.sock.onerror = this.on_error.bind(this);
    },

	send_data: function (data) {
        this.sock.send(data);
    }
}
module.exports = {websocket};
