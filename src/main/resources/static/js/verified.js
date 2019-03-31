        //第一步    第一个页面路由
        var firstComp = {
            template:"#first",
            data() {
                return {
                    realName:'',
                    idCard:'', 

                    realNameInfo:'',
                    realNameClass:' ',

                    idCardInfo:'',
                    idCardClass:'' , 
                    
                    checkAllInfo:'',
                    checkAllClass:'',
                }
            },
            created() {
//                verifiedVue.schedule = 'first';
//                verifiedVue.info = '实名认证';
            },
            methods: {
                checkRealName:function(){
                    var reg = /^[\u4e00-\u9fa5]{0,}$/;
                    if(reg.test(this.realName) && this.realName != ''){
                        this.realNameInfo = '符合规则';
                        this.realNameClass = 'success';
                        return true;
                    }else{
                        this.realNameInfo = '不符合规则';
                        this.realNameClass = 'error';
                        return false;
                    }
                },
                checkIdCard:function(){
                    var reg =/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
                    if(reg.test(this.idCard) && this.idCard != ''){
                        this.idCardInfo = '符合规则';
                        this.idCardClass = 'success';
                        return true;
                    }else{
                        this.idCardInfo = '不符合规则';
                        this.idCardClass = 'error';
                        return false;
                    }
                },
                toSecond:function(){
                    if(this.checkRealName() && this.checkIdCard()){
                    	this.checkAllInfo = '正在实名认证，请稍候！！！';
                    	this.checkAllClass = 'success';
                        //ajax实名校验
                        var flag = getDataByAjax('/verifiedCustomer',{cusName:this.realName,cusCardId:this.idCard});
                        if(true){
                            router.push({path:'/second'});
                            return true;
                        }
                    }
                    this.checkAllInfo = '实名认证失败！！！';
                	this.checkAllClass = 'error';
                },
            },
        }
        //第二步    第二个页面路由
        var secondComp = {
            template:"#second",
            data() {
                return { 
                    cusPhone:'',
                    cusAddr:'',
                    cusWorkspace:'',
                    cusEducation:'',
                    cusYearInput:'',
                    cusEmail:'' ,

                    cusPhoneInfo:'',
                    cusPhoneClass:'',
                    
                    cusAddrInfo:'',
                    cusAddrClass:'',
                    
                    cusWorkspaceInfo:'',
                    cusWorkspaceClass:'',
                    
                    cusEducationInfo:'',
                    cusEducationClass:'',

                    cusYearInputInfo:'',
                    cusYearInputClass:'',

                    cusEmailInfo:'',
                    cusEmailClass:'',
                    
                    checkAllInfo:'',
                    checkAllClass:'',
                }
            },
            created() {
//                verifiedVue.schedule = 'second';
//                verifiedVue.info = '完善信息';
            },
            methods: {
            	checkCusPhone:function(){
            		var reg = /^\d{3,4}-\d{7,8}$/;
            		if(reg.test(this.cusPhone)){
            			this.cusPhoneInfo = '固话符合规则';
            			this.cusPhoneClass = 'success';
            			return true;
            		}else{
            			this.cusPhoneInfo = '固话不符合规则';
            			this.cusPhoneClass = 'error';
            			return false;
            		}
            	},
            	checkCusAddr:function(){
            		if(this.cusAddr == null || this.cusAddr == ''){
            			this.cusAddrInfo = '住址不能为空';
            			this.cusAddrClass = 'error';
            			return false;
            		}
            		this.cusAddrInfo = '住址符合';
        			this.cusAddrClass = 'success';
        			return true;
            	},
            	checkCusWorkspace:function(){
            		if(this.cusWorkspace == null || this.cusWorkspace == ''){
            			this.cusWorkspaceInfo = '工作不能为空';
            			this.cusWorkspaceClass = 'error';
            			return false;
            		}
            		this.cusWorkspaceInfo = '工作符合';
        			this.cusWorkspaceClass = 'success';
        			return true;
            	},
            	checkCusEducation:function(){
            		if(this.cusEducation == null || this.cusEducation == ''){
            			this.cusEducationInfo = '学历不能为空';
            			this.cusEducationClass = 'error';
            			return false;
            		}
            		this.cusEducationInfo = '学历符合';
        			this.cusEducationClass = 'success';
        			return true;
            	},
                checkCusYearInput:function(){
                    var reg = /^\d{1,}$/;
                    if(reg.test(this.cusYearInput)){
                        this.cusYearInputInfo = '符合规则';
                        this.cusYearInputClass = 'success';
                        return true;
                    }else{
                        this.cusYearInputInfo = '不是纯数字';
                        this.cusYearInputClass = 'error';
                        return false;
                    }
                },
                checkEmail:function(){
                    var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                    if(reg.test(this.cusEmail)){
                        this.cusEmailInfo = '邮箱符合规则';
                        this.cusEmailClass = 'success';
                        return true;
                    }else{
                        this.cusEmailInfo = '邮箱不符合规则';
                        this.cusEmailClass = 'error';
                        return false;
                    }
                },
                toOver:function(){
                    if(this.checkCusPhone() &&this.checkCusAddr() &&this.checkCusWorkspace() && this.checkCusEducation() && this.checkCusYearInput() && this.checkEmail()){
                    	var data = {
                    			'cusPhone':this.cusPhone,
                    			'cusAddr':this.cusAddr,
                    			'cusWorkspace':this.cusWorkspace,
                    			'cusEducation':this.cusEducation,
                    			'cusYearInput':this.cusYearInput,
                    			'cusEmail':this.cusEmail
                    	};
                        var flag = getDataByAjax('/modifyCustomer',data);
                        if(flag){
                            router.push({path:'/over'});
                            return true;
                        }
                    }
                    this.checkAllInfo = '完善信息失败，请联系管理员';
                    this.checkAllClass = 'error';
                }
            },
        }
        //第三步    第三个页面路由
        var overComp = {
            template:"#over",
            data() {
                return {
                    
                }
            },
            methods: {
                success:function(){
                	location.href='/removeCustomer';
                }
            },
        }

        
        
        //路由对象
        var router = new VueRouter({
            routes: [
            	{path:'/',redirect:'/first'},
                {path:"/first",component:firstComp},
                {path:"/second",component:secondComp},
                {path:"/over",component:overComp},
            ],
            
        })
        //vue 路由全局前置钩子
        router.beforeEach((to, from, next) => {
		 	var customer = getDataByAjax('/sessionCustomer');
		 	
		 	if(customer.cusCardId != null && customer.cusCardId != '' &&customer.cusPhone == '' && to.path != '/second' && to.path != '/over'){
		 		//已经实名认证，则直接进入完善页面
		 		next({path: '/second'});
		 	}else{
		 		next();
		 	}
		 });
        
        //vue实例
        var verifiedVue = new Vue({
            el:'#verifiedDiv',
            data:{
                schedule:'first',
                info:'实名认证',
            },
            methods: {},
            watch: {
            	'$route.path':function(newVal,oldVal){
            		if(newVal == '/first'){
        				this.schedule = 'first';
        				this.info = '实名认证';
        			}else if(newVal == '/second'){
        				this.schedule = 'second';
        				this.info = '完善信息';
        			}else{
        				this.schedule = 'over';
        				this.info = '恭喜完成';
        			}
            	}
            },
            router,//注册路由
        })

        //vue路由全局后置钩子
        router.afterEach((to,from) => {
        	console.log(to.path)
        	if(to.path == '/first'){
				verifiedVue.schedule = 'first';
				verifiedVue.info = '实名认证';
			}else if(to.path == '/second'){
				verifiedVue.schedule = 'second';
				verifiedVue.info = '完善信息';
			}else{
				verifiedVue.schedule = 'over';
				verifiedVue.info = '恭喜完成';
			}
        })