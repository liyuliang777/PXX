package org.hut.dao;

import java.util.List;

import org.hut.pojo.FenYe;
import org.hut.pojo.ProDetail;
import org.hut.pojo.Query;

public interface ProductMapper {
	/*
	 * 前台产品分页展示
	 */
	List<ProDetail> selectProductByFenYe(FenYe fenYe);
	
	/*
	 * 查看产品详情
	 */
	ProDetail selectProductById(Integer id);
	
	
	int queryTotalTiaoShu(Query query);
	

}
