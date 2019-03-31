
var userVue = new Vue({
	    el:'#header',
	    data:{
	        user:null
	    },
	    created() {
	    	this.user = getDataByAjax('/sessionCustomer');
	    	console.log(this.user)
	    },
	})

/**
 * 登录
 */
 var loginVue = new Vue({
            el:'#loginDiv',
            data:{
                telphone:'18682855584',
                password:'222222',
                code:'',
                checkCode:'',
                codeClass:'',
                codeInfo:'',
                checkALlClass:'',
                checkAllInfo:''
            },
            created(){
            	this.createCode();
            },
            methods: {
            	createCode(){
            		this.checkCode = '';
            		var codeLength = 4;
            		var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
            		for(var i = 0;i < codeLength; i++){
            			var index = Math.floor(Math.random()*36);
            			this.checkCode += random[index];
            		}
            	},
            	checkCodeInput(){
            		var code = this.code.toUpperCase();
            		if(code == this.checkCode){
            			this.codeClass = 'success';
            			this.codeInfo = '验证通过';
            			return true;
            		}else{
            			this.codeClass = 'error';
            			this.codeInfo = '验证失败';
            			return false;
            		}
            	},
                login:function(){
                    if(this.checkCodeInput()){
                    	var url = '/customerLogin'
                        var data = {
                        	'telphone':this.telphone, //手机号
                        	'password':this.password,	//密码
                        };
                        $.ajax({
                            url:'/customerLogin',
                            method:'post',
                            data:{
                            	'telphone':this.telphone, //手机号
                            	'password':this.password,	//密码
                        	},
                        	dataType:'json',
                        	success:function(data){
                        		if(data != null && data != ''){
                        			if(data.cusType == '禁用'){
                        				loginVue.checkALlClass = 'error';
                        				loginVue.checkAllInfo = '该账号已被禁用，请联系管理员';
                             			return;
                        			}
		                         	userVue.user = data;
		                         	//关闭模态框
		                         	$("#loginDiv").modal('hide');
                        		}else{
                        			loginVue.checkALlClass = 'error';
                        			loginVue.checkAllInfo = '用户名或者密码错误';
                        		}
	                         },
	                         error(){
	                        	 loginVue.checkALlClass = 'error';
	                        	 loginVue.checkAllInfo = '用户名或者密码错误';
	                         }
                    	})
                    }
                  	
                }
            }
        });
 
 /**
  * 注册
  */
 var registerVue = new Vue({
		el:'#registerDiv',
		data:{
			cusMobilePhone:'',
			cusPwd:'',
			cusPwd2:'',
			phoneCode:'',
			phoneCode2:'',
			imgCode:'',
			imgCodeUrl:'',
			imgCode2:'',
			
			cusMobilePhoneClass:'',
			cusMobilePhoneInfo:'',
			
			cusPwdClass:'',
			cusPwdInfo:'',
			
			cusPwdClass2:'',
			cusPwdInfo2:'',
			
			phoneCodeClass:'',
			phoneCodeInfo:'',
			
			imgCodeClass:'',
			imgCodeInfo:'',
			
			checkAll:''
		},
		created(){
        	this.createCode();
        },
        methods: {
        	//创建图形验证码
        	createCode(){
        		this.imgCode2 = '';
        		var codeLength = 4;
        		var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
        		for(var i = 0;i < codeLength; i++){
        			var index = Math.floor(Math.random()*36);
        			this.imgCode2 += random[index];
        		}
        	},
			//获取手机验证码
			getPhoneCode(){
				$.ajax({
					url:'phoneCode',
					method:'get',
					data:{
						cusMobilePhone:this.cusMobilePhone
					},
					dataType:'json',
					success(data){
						registerVue.phoneCode2 = data;
						alert(registerVue.phoneCode2)
					}
				})
			},
			//验证手机号码是否可用
			checkCusMobilePhone:function(){
				var reg = /^1(3|4|5|7|8)\d{9}$/;
				var flag = false;
				if(reg.test(this.cusMobilePhone)){
					$.ajax({
						url:'checkCusMobilePhone',
						data:{
							cusMobilePhone:this.cusMobilePhone
						},
						async : false,//同步加载数据获取返回值
						dataType:'json',
						success(msg){
							if(msg){
								registerVue.cusMobilePhoneClass = 'success';
								registerVue.cusMobilePhoneInfo = '手机号可用';
								flag = true;
							}else{
								registerVue.cusMobilePhoneClass = 'error';
								registerVue.cusMobilePhoneInfo = '手机号已注册';
								flag = false;
							}
						}
					})
				}else{
					this.cusMobilePhoneClass = 'error';
					this.cusMobilePhoneInfo = '手机号格式不正确';
					flag = false;
				}
				return flag;
			},
			//验证密码是否符合规则
			checkCusPwd:function(){
				var reg = /^[0-9A-Za-z]{6,10}$/;
				if(reg.test(this.cusPwd)){
					this.cusPwdClass = 'success';
					this.cusPwdInfo = '密码可用';
					return true;
				}else{
					this.cusPwdClass = 'error';
					this.cusPwdInfo = '密码不符规则';
					return false;
				}
			},
			//验证两次密码是否一致
			checkCusPwd2:function(){
				if(this.cusPwd == this.cusPwd2 && this.cusPwd != ''){
					this.cusPwdClass2 = 'success';
					this.cusPwdInfo2 = '密码一致';
					return true;
				}else{
					this.cusPwdClass2 = 'error';
					this.cusPwdInfo2 = '密码不一致';
					return false;
				}
			},
			//验证短信验证码
			checkPhoneCode:function(){
				if(this.phoneCode == this.phoneCode2 && this.phoneCode != ''){
					this.phoneCodeClass = 'success';
					this.phoneCodeInfo = '验证成功';
					return true;
				}else{
					this.phoneCodeClass = 'error';
					this.phoneCodeInfo = '验证失败';
					return false;
				}
			},
			//验证图片验证码
			checkImgCode:function(){
				var imgCode = this.imgCode.toUpperCase();
				if(imgCode == this.imgCode2){
					this.imgCodeClass = 'success';
					this.imgCodeInfo = '验证通过';
					return true;
				}else{
					this.imgCodeClass = 'error';
					this.imgCodeInfo = '验证失败';
					return false;
				}
			},
			//立即注册
			register:function(){
				if(this.checkCusMobilePhone() && this.checkCusPwd() && this.checkCusPwd2() && this.checkPhoneCode() && this.checkImgCode()){
					$.ajax({
						url:'/customerRegister',
						method:'post',
						data:{
							cusMobilePhone:this.cusMobilePhone,
							cusPwd:this.cusPwd,
						},
						success:function(data){
							userVue.user = data;
                     	//关闭模态框
                     	$("#registerDiv").modal('hide');
						},
						error(){
                        	alert("注册失败")
                        }
					})
				}else{
					this.checkAll = '验证出错，请检查！！！';
				}
			},
		}
	});