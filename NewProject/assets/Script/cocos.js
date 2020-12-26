// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html
var websocket = require("websocket");
cc.Class({
    extends: cc.Component,

    properties: {
        // 主角跳跃高度
        jumpHeight: 0,
        // 主角跳跃持续时间
        jumpDuration: 0,
        // 最大移动速度
        maxMoveSpeed: 0,
        // 加速度
        accel: 0,
    },

    // LIFE-CYCLE CALLBACKS:

    // onLoad () {},

    start () {

    },
	onLoad: function () {
		console.log("!!!!!!runjump!!!!!");
        var jumpAction = this.runJumpAction();
        cc.tween(this.node).then(jumpAction).start()
		
		// 加速度方向开关
        this.accLeft = false;
        this.accRight = false;
        // 主角当前水平方向速度
        this.xSpeed = 0;

        // 初始化键盘输入监听
        cc.systemEvent.on(cc.SystemEvent.EventType.KEY_DOWN, this.onKeyDown, this);
        cc.systemEvent.on(cc.SystemEvent.EventType.KEY_UP, this.onKeyUp, this);   
    
    },
	onDestroy () {
        // 取消键盘输入监听
        cc.systemEvent.off(cc.SystemEvent.EventType.KEY_DOWN, this.onKeyDown, this);
        cc.systemEvent.off(cc.SystemEvent.EventType.KEY_UP, this.onKeyUp, this);
    },
	runJumpAction(){
		//跳跃上升   cc.tween().by

		var jumpUp = cc.tween().by(this.jumpDuration, {y: this.jumpHeight}, {easing: 'sineOut'});
		var jumpDown = cc.tween().by(this.jumpDuration,{y:-this.jumpHeight},{easing:'sineIn'});

		// 创建一个缓动，按 jumpUp、jumpDown 的顺序执行动作
        var tween = cc.tween().sequence(jumpUp, jumpDown)
        // 不断重复
        return cc.tween().repeatForever(tween);
	},
	
	onKeyDown (event) {
        // set a flag when key pressed
        switch(event.keyCode) {
            case cc.macro.KEY.a:
                this.accLeft = true;
                break;
            case cc.macro.KEY.d:
                this.accRight = true;
                break;
        }
    },

    onKeyUp (event) {
        // unset a flag when key released
        switch(event.keyCode) {
            case cc.macro.KEY.a:
                this.accLeft = false;
                break;
            case cc.macro.KEY.d:
                this.accRight = false;
                break;
        }
    },

     update (dt) {
		 // 根据当前加速度方向每帧更新速度
        if (this.accLeft) {
			
			let test = $root.test1Msg.create({id:1,name:"yxy",age:22,state:1});
			console.log("1.finish@@@@@@@@@@"+test);
			let messageBuf = $root.test1Msg.encode(test).finish();////获取二进制数据，一定要注意使用finish函数
			console.log("2.finish@@@@@@@@@@"+messageBuf);
			websocket.send_data(messageBuf);
			console.log("3.finish@@@@@@@@@@");
	
            this.xSpeed -= this.accel * dt;
        }
        else if (this.accRight) {
            this.xSpeed += this.accel * dt;
        }

        // 限制主角的速度不能超过最大值
        if (Math.abs(this.xSpeed) > this.maxMoveSpeed) {
            // if speed reach limit, use max speed with current direction
            this.xSpeed = this.maxMoveSpeed * this.xSpeed / Math.abs(this.xSpeed);
        }

        // 根据当前速度更新主角的位置
        this.node.x += this.xSpeed * dt;
	 },
});
