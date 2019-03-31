package org.hut.service.impl;

import java.util.List;

import org.hut.dao.ProductMapper;
import org.hut.pojo.FenYe;
import org.hut.pojo.ProDetail;
import org.hut.pojo.Query;
import org.hut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper pm;

	@Override
	public List<ProDetail> findProductByFenYe(FenYe fy) {
		if(fy.getPage()==null || fy.getPage()==0) {
			fy.setPage(1);
		}
		pm.selectProductByFenYe(fy);
		return fy.getPros();
	}


	public ProDetail findProductById(Integer id) {
		return pm.selectProductById(id);
	}

/*	@Override
	public int findTotalTiaoShu(Query query) {
		return pm.queryTotalTiaoShu(query);
	}*/

}
