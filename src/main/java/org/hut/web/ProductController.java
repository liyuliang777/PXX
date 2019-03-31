package org.hut.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hut.pojo.FenYe;
import org.hut.pojo.ProDetail;
import org.hut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@RequestMapping("/pro")
	@ResponseBody
	public List getAllProDetail(FenYe fy) {
		FenYe cloneFy=new FenYe();
		List pd=ps.findProductByFenYe(fy);
		cloneFy.setEndTiaoShu(fy.getEndTiaoShu());
		cloneFy.setPage(fy.getPage());
		cloneFy.setPageSize(fy.getPageSize());
		cloneFy.setQuery(fy.getQuery());
		cloneFy.setStartTiaoShu(fy.getStartTiaoShu());
		cloneFy.setZongJiLuShu(fy.getZongJiLuShu());
		cloneFy.setZongYeShu(fy.getZongYeShu());
		System.out.println(fy.getPros());
		pd.add(cloneFy);
		return	pd;	
	}
	
	@RequestMapping("/proDetail")
	@ResponseBody
	public ProDetail getProDetail(@RequestParam(value="proId")  Integer id) {  
		return	ps.findProductById(id);	
	}
	
	@RequestMapping("/show")
	public String a(FenYe fy) {
		return	"productShow";	
	}
	@RequestMapping("/setOrder")
	@ResponseBody
	public Map<String,Boolean> setOrder(@RequestParam(value="proId") Integer proId,@RequestParam(value="money") Integer money) {
		Map map=new HashMap();
		if(proId!=null) {
			System.out.println("proId:"+proId+"money:"+money);
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		
		return map;
	}
	

}
