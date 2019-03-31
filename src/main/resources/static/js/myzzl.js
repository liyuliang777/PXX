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
    return {userName:''};
 }
 
 
 //通过ajax获取
    //urlVal : url地址
    //dataVal : 需要提交的数据
    //vueObj : 翻页vue对象
    function getProsByAjax(urlVal,dataVal,vueObj){
         $.ajax({
             url:urlVal,
             data:dataVal,
             dataType:'json',
             success:function(data){
            	 pageVue.currentPage = data[data.length-1].page;//设置当前页
                 pageVue.totlePage = data[data.length-1].zongYeShu;//设置总页数
                 pageVue.pages = [];//清空页数
                 var begin = 1;
                 var end = 1;
                 
                 if(pageVue.currentPage%5==0){
                     begin = (pageVue.currentPage/5-1)*5+1;
                     end = parseInt(pageVue.currentPage/5-1)*5+5
                 }else{
                     begin = parseInt(pageVue.currentPage/5)*5+1;
                     end = parseInt(pageVue.totlePage);
                 }

                 for(var i = begin;i<=end;i++){//设置新页数
                	 pageVue.pages.push(i);
                 }
                 //如果为第一页，首页上一页禁用
                 if(pageVue.currentPage <= 1){
                	 pageVue.upPage = true;
                 }else{
                	 pageVue.upPage = false;
                 }
                 //如果为最后一页，末页和下一页禁用
                 if(pageVue.currentPage >= pageVue.totlePage){
                	 pageVue.downPage = true;
                 }else{
                	 pageVue.downPage = false;
                 }
                 //设置产品值
                data.pop();
                if(data[0]!=null){
                	productVue.products=data;
                }else{
                	alert("没有查询结果");
                	productVue.products=null;
                }
                
                 
             }
         })
    } 
        function getProDetailAjax(id){
        	 $.ajax({
	             url:"/proDetail",
	             data:{"proId":id},
	             dataType:'json',
	             success:function(data){
	            	 
	            	 $("#proQueryandShow").html("");
	            	 var proName="<p style='text-align:center;font-size:20px;color:gray'>"+data.apply.proName+"<p>";
	            	 var str="<div style='width:1440px;background-color:#F8F8F8'>";
	            	 var str1="<p>产品类型:"+data.apply.productType.typeName+"</p>";
	            	 var str2="<p>融资规模:"+data.apply.proScale+"</p>";
	            	 var str3="<p>融资期限:"+data.apply.proDateline+"月</p>";
	            	 var str4="<p>资金用途:"+data.apply.proInvest+"</p>";
	            	 var str5="<p>剩余规模:"+data.proRemain+"</p>"
	            	 var str6="<p>预期收益率:"+data.apply.proReceipts+"</p>"
	            	 var str7="<p>项目地区"+data.proRegion+"</p>"
	            	 var str8="<p>风险评级"+data.proRistLevel+"</p>"
	            	 var str9="<p>起投金额:"+data.proStartMoney+"</p>"
	            	 var str10="<p>募集状态:"+data.proRaiseState+"</p>"
	            	 var str11="<div>产品亮点:"+data.proAdvt+"</div>"
	            	 var str12="<button type='button' class='btn btn-info reservation' data-toggle='modal' data-target='#yuYueModal'>产品预约</button>";
	            	 $("#proQueryandShow").html("<div id='productDiv'>"+str+proName+str1+str2+str3+str4+str5+str6+str7+str8+str9+str10+str11+"</div>"+str12+"</div>");
	            	 yuYueVue.proId=data.proId;
	            	 }
	             })
			}
       
        
       
       /* pageBean = {
            currentPage:dataVal.currentPage,
            totlePage:20,
            list:[{
                    title:'某某信托',
                    des:'某某信托，49号集资计划',
                    type:'征信类',
                    pubTime:'2019-1-1',
                    deadline:'24个月',
                    allocation:'半年',
                    fund:'100万',
                    rate:'9.4%',
                },
                {
                    title:'某某信托',
                    des:'某某信托，49号集资计划',
                    type:'征信类',
                    pubTime:'2019-1-1',
                    deadline:'24个月',
                    allocation:'半年',
                    fund:'100万',
                    rate:'9.4%',
                },
                {
                    title:'某某信托',
                    des:'某某信托，49号集资计划',
                    type:'征信类',
                    pubTime:'2019-1-1',
                    deadline:'24个月',
                    allocation:'半年',
                    fund:'100万',
                    rate:'9.4%',
                },
                {
                    title:'某某信托',
                    des:'某某信托，49号集资计划',
                    type:'征信类',
                    pubTime:'2019-1-1',
                    deadline:'24个月',
                    allocation:'半年',
                    fund:'100万',
                    rate:'9.4%',
                },
                {
                    title:'某某信托',
                    des:'某某信托，49号集资计划',
                    type:'征信类',
                    pubTime:'2019-1-1',
                    deadline:'24个月',
                    allocation:'半年',
                    fund:'100万',
                    rate:'9.4%',
                },
            ]};
*/
          
 

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