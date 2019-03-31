//  获取当前用户是否登录
 function getUser(urlVal,dataVal){
     var rDate = null;
    //  $.ajax({
    //      url:urlVal,
    //      data:dataVal,
    //      dataType:'json',
    //      success:function(data){
    //         rDate = data;
    //      }
    //  })
    //  return rDate;
    return {userName:'张与超'};
 }
 
 
 //通过ajax获取
    //urlVal : url地址
    //dataVal : 需要提交的数据
    //vueObj : 翻页vue对象
    function getDataByAjax(urlVal,dataVal,vueObj){
        var pageBean = null;
         $.ajax({
             url:urlVal,
             data:dataVal,
             method:'post',
             dataType:'json',
             async:false,
             success:function(data){
                 pageBean = data;
             }
         })
         if(pageBean != null){
	        vueObj.currentPage = pageBean.currentPage;//设置当前页
	        vueObj.totlePage = pageBean.totalPage;//设置总页数
	        vueObj.pages = [];//清空页数
	        var begin = 1;
	        var end = 1;
	        if(vueObj.currentPage%5==0){
	            begin = (vueObj.currentPage/5-1)*5+1;
	            end = parseInt(vueObj.currentPage/5-1)*5+5
	        }else{
	        	if(vueObj.totlePage-5 < vueObj.currentPage){
	        		begin = parseInt(vueObj.currentPage/5)*5+1;
	        		end = begin + (vueObj.totlePage % 5) - 1;
	        	}else{
		            begin = parseInt(vueObj.currentPage/5)*5+1;
		            end = parseInt(vueObj.currentPage/5)*5+5;
	        	}
	        }
	
	        for(var i = begin;i<=end;i++){//设置新页数
	            vueObj.pages.push(i);
	        }
	        //如果为第一页，首页上一页禁用
	        if(vueObj.currentPage <= 1){
	            vueObj.upPage = true;
	        }else{
	            vueObj.upPage = false;
	        }
	        //如果为最后一页，末页和下一页禁用
	        if(vueObj.currentPage >= vueObj.totlePage){
	            vueObj.downPage = true;
	        }else{
	            vueObj.downPage = false;
	        }
	        return pageBean.list;
         }
         return null;
    }

    //上传文件
    //id:文件上传框的id
    //uploadUrl:文件上传url
    //uploadExtraData:文件上传参数，如：{"id": 1, "fileName":'123.mp3'}
    //allowedFileExtensions:文件上传支持的格式，如：['jpg', 'gif', 'png']
    function fileInput(id,uploadUrl,uploadExtraData,allowedFileExtensions){
        var Id = '#'+id;
        $(Id).fileinput({                
                language: 'zh', //设置语言                
                uploadUrl:uploadUrl, //上传的地址              
                allowedFileExtensions:allowedFileExtensions,//接收的文件后缀               
                uploadExtraData:uploadExtraData,                
                dropZoneEnabled: true,//是否显示拖拽区域               
                uploadAsync: true, //默认异步上传                
                showUpload:true, //是否显示上传按钮                
                showRemove :true, //显示移除按钮                
                showPreview :true, //是否显示预览                
                showCaption:true,//是否显示标题                
                browseClass:"btn btn-primary", //按钮样式                   
                // minImageWidth: 50, //图片的最小宽度               
                // minImageHeight: 50,//图片的最小高度               
                // maxImageWidth: 1000,//图片的最大宽度               
                // maxImageHeight: 1000,//图片的最大高度                
                // maxFileSize:0,//单位为kb，如果为0表示不限制文件大小               
                // minFileCount: 0,                
                maxFileCount:10, //表示允许同时上传的最大文件个数                
                enctype:'multipart/form-data',               
                validateInitialCount:true,                
                previewFileIcon: "",               
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",           
            }).on("fileuploaded", function (event, data, previewId, index){});
    }

    //暂停
    function sleep(d){
        for(var t = Date.now();Date.now() - t <= d;);
    }