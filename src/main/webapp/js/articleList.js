/**
 * Created by koyuhau on 2018/5/4.
 */
$(function(){
    init();
})

function deleteById(id){
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/article/deleteById" ,//url
        data:{id:id},
        success: function (result) {
            init();
        },
        error : function() {
            alert("异常！");
        }
    });
}

function init(){

    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/article/get" ,//url
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            $("#container").empty();
            for (var i = 0; i < result.length; i++) {
                var article = result[i];
                $("#container").append("<tr class='box'><td><span class='title'>"+article.title+"</span></td><td><button class='right' onclick='deleteById("+article.id+")'>删除</button></td></tr>");
            }
        },
        error : function() {
            alert("异常！");
        }
    });

}