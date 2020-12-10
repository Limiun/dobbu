import {msg} from "./Msg" //这里引入文件,msg为package的包名
var websocket = {
    sock: null,
 
    on_open: function () {
        this.send_data(JSON.stringify({
            stype: "auth",
            ctype: "login",
            data: {
                name: "jianan",
                pwd: 123456
            }
        }));
    },
    
    on_message: function (event) {
		cc.log("First client rcv data=" + event.data);
		let udata = new Unit8Array(event.data)
		cc.log(udata);
		let messagefor = msg.Login.decode(udata);
        console.log("client rcv data=" + messagefor);
    },
 
    on_close: function () {
        this.close();
    },
 
    on_error: function () {
        this.close();
    },
    
    close: function () {
        if(this.sock){
            this.sock.close();
            this.sock = null;
        }
    },
 
    connect: function (url) {
        this.sock = new WebSocket(url);
        this.sock.binaryType = "arraybuffer";
        this.sock.onopen = this.on_open.bind(this);
        this.sock.onmessage = this.on_message.bind(this);
        this.sock.onclose = this.on_close.bind(this);
        this.sock.onerror = this.on_error.bind(this);
    },
 
    send_data: function (data) {
		let messagetest = msg.Login.create({name: "hello", pwd: "pwd"});//构造对象
		let messageBuftest = msg.Login.encode(messagetest).finish(); //获取二进制数据，一定要注意使用finish函数
		cc.log("%%%%%%%%%%%%%%%%%%%%%");
		let sendData = new msg.Login();
		sendData.name = "yxy";
		sendData.pwd ="125125";
		cc.log(sendData);
		let sendByte = msg.Login.encode(sendData).finish();
		cc.log("sendByte"+sendByte);
		let user_login = msg.Login.decode(sendByte);
		cc.log(user_login);
		cc.log("%%%%%%%%%%%%%%%%%%%%%");
		this.sock.send(messageBuftest);
		cc.log(messageBuftest);
		cc.log(messagetest);
		let messagefor = msg.Login.decode(messageBuftest);
		cc.log(messagefor);
		cc.log("%%%%%%%%%%%%%%%%%%%%%");
        
		//this.sock.send(data);
    }
 
}
 
module.exports = websocket;