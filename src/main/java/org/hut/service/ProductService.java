package org.hut.service;

import java.util.List;

import org.hut.pojo.FenYe;
import org.hut.pojo.ProDetail;
import org.hut.pojo.Query;

public interface ProductService {
	/*
	 * 前台产品分页展示
	 */
	List<ProDetail>findProductByFenYe(FenYe fy);
	
	/*
	 * 查看产品详情
	 */
	ProDetail findProductById(Integer id);
	
	/*int findTotalTiaoShu(Query query);*/
}
