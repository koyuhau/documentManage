/**
 * Created by Administrator on 2017/9/22.
 */
$(function () {
    vm = avalon.define({
        $id: "article",
        rows:[],
        init: function () {

            $.ajax({
                url:"/article/getArticles",
                type:"GET",
                data:{
                    page:1,
                    pageSize:10
                },
                dataType:"json",
                beforeSend:function(){
                },
                complete:function(){
                },
                success:function(result){
                    vm.rows = result ;
                }
            });

        },
        jump : function(id){
            window.location.href= "/article.html?id="+id;
        }
    });
    avalon.scan($("#article")[0], vm);
    vm.init();
});