
/**
 * 通过ajax获取数据
 * @param url
 * @param data
 * @returns
 */
function getDataByAjax(urlVal,dataVal){
	var rData = null;
	$.ajax({
		url:urlVal,
		method:'POST',
		data:dataVal,
		dataType:'json',
		async : false,//同步加载数据获取返回值
		success(data){
			rData = data;
		},
		error(msg){
			console.log(msg);
		}
	});
	return rData;
}