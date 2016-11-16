/**
 * Created by suvin on 2016/11/10.
 */

function doRefresh() {
    var ifr = window.frames["page-content"];
    ifr.location.reload();
}
function getHistory(type) {
    if (type != 0) {
        var ifr =window.frames["page-content"];
        ifr.history.go(type);
        setTimeout("doRefresh()", 75);
    } else if (type == 0) {
        doRefresh();
    }

}
/**
 * This is an example of how to use eventable.
 * As you can see,each instance can hold event driven's base function through merge the instance of Eventable's properties.
 */
var PageContainerStore = Object.assign({},new Eventable(),{
    onBack:function(callback){
        this.on("back",callback);
    },
    emitBack:function(){
        getHistory(-1);
        this.emit("back");
    },
    onLoad:function(callback){
        this.on("load",callback)
    },
    emitLoad:function(e){
        this.emit("load",e);
    },
    emitRefresh:function(){
        doRefresh();
        this.emit("refresh");
    }

});

