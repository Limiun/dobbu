// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

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
    },
	runJumpAction(){
		//跳跃上升   cc.tween().by
		var jumpUp = cc.tween().by(this.jumpDuration,{y:this.jumpHeight},{easing:'sineOut'});
		var jumpDown = cc.tween.by(this.jumpDuration,{y:-this.jumpHeight},{easing:'sineIn'});
	
		// 创建一个缓动，按 jumpUp、jumpDown 的顺序执行动作
        var tween = cc.tween().sequence(jumpUp, jumpDown)
        // 不断重复
        return cc.tween().repeatForever(tween);
	}

    // update (dt) {},
});
