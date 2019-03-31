package org.hut.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TurnController {
	//跳转到客户首页
	@RequestMapping("/tomy")
	public String toMyHtml() {
		return "my";
	}
	
	//跳转到客户信息显示
	@RequestMapping("/tomyprofile")
	public String myprofile() {
		return "myProfile";
	}
	
	//跳转到个人中心
//	@RequestMapping("/")
//	public String userIndex() {
//		return "userIndex";
//	}
	
	
	//跳转到密码更改页面
	@RequestMapping("/pwd")
	public String pwd() {
		return "passwordManage";
	}
	//测试  跳转个人信息显示页面
//	@RequestMapping("/test")
//	public String test(Customer cus,HttpSession session) throws ParseException {
//		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
//		cus.setCusId(1);
//		cus.setCusName("张三");
//		cus.setCusMobilePhone("17328766756");
//		cus.setCusCardId("360731199212224536");
//		cus.setCusSex("女");
//		cus.setCusBirth(sm.parse("1992-12-22"));
//		cus.setCusHAddr("江西赣州");
//		cus.setCusWorkspace("北大青鸟");
//		cus.setCusEducation("大专");
//		cus.setCusAddr("深圳龙华");
//		cus.setCusEmail("810109970@qq.com");
//		cus.setCusPhone("6360223");
//		session.setAttribute("customer", cus);
//		
//		return "myProfile";
//	}
	
	//跳转个人信息修改页面
	@RequestMapping("/toupdatefile")
	public String updatefile() {
		
		return "updateProfile";
	}
	
	//跳转到银行卡增加页面
	@RequestMapping("/toaddcard")
	public String toAddCard() {
		return "addCard";
	}
	
	//跳转风险页面
	@RequestMapping("/fengxian")
	public String fengxian() {
		return "cusRiskToleranceLevel";
	}
	
	@RequestMapping("/assete")
	public String assete() {
		return "myAssete";
	}
}
