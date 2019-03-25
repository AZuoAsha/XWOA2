var stage=new createjs.Stage("gameView");
createjs.Ticker.setFPS(30);
createjs.Ticker.addEventListener("tick",stage);

var mc=new createjs.MovieClip(null,0,true,{start:50,stop:0});
stage.addChild(mc);

var stage1=new createjs.Shape(new createjs.Graphics().beginFill("#0CF").drawCircle(0,100,30));
var stage2=new createjs.Shape(new createjs.Graphics().beginFill("#66C").drawCircle(0,100,30));

mc.timeline.addTween(createjs.Tween.get(stage1).to({x:30}).to({x:400},100).to({x:30},100));
mc.timeline.addTween(createjs.Tween.get(stage2).to({x:400}).to({x:30},100).to({x:400},100));

mc.gotoAndPlay("stop");