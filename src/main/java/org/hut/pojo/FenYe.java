package org.hut.pojo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FenYe {
	private Integer page;//当前页
	private Integer pageSize=2;//每页条数
	private Integer zongJiLuShu;//总记录数
	private Integer zongYeShu;//总页数
	private Integer startTiaoShu;//开始条数
	private Integer endTiaoShu;//结束条数
	private Query query;
	private List<ProDetail> pros;
	public FenYe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FenYe(Integer page, Integer pageSize, Integer zongJiLuShu, Integer zongYeShu, Integer startTiaoShu,
			Integer endTiaoShu, Query query) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.zongJiLuShu = zongJiLuShu;
		this.zongYeShu = zongYeShu;
		this.startTiaoShu = startTiaoShu;
		this.endTiaoShu = endTiaoShu;
		this.query = query;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getZongJiLuShu() {
		return zongJiLuShu;
	}
	public void setZongJiLuShu(Integer zongJiLuShu) {
		this.zongJiLuShu = zongJiLuShu;
	}
	public Integer getZongYeShu() {
		zongYeShu=this.getZongJiLuShu()%this.getPageSize()==0?this.getZongJiLuShu()/this.getPageSize():this.getZongJiLuShu()/this.getPageSize()+1;
		return zongYeShu;
	}
	public void setZongYeShu(Integer zongYeShu) {
		this.zongYeShu = zongYeShu;
	}
	public Integer getStartTiaoShu() {
		startTiaoShu=(this.getPage()-1)*this.getPageSize();
		return startTiaoShu;
	}
	public void setStartTiaoShu(Integer startTiaoShu) {
		this.startTiaoShu = startTiaoShu;
	}
	public Integer getEndTiaoShu() {
		endTiaoShu=this.getPage()*this.getPageSize();
		return endTiaoShu;
	}
	public void setEndTiaoShu(Integer endTiaoShu) {
		this.endTiaoShu = endTiaoShu;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}



	@Override
	public String toString() {
		return "FenYe [page=" + page + ", pageSize=" + pageSize + ", zongJiLuShu=" + zongJiLuShu + ", zongYeShu="
				+ zongYeShu + ", startTiaoShu=" + startTiaoShu + ", endTiaoShu=" + endTiaoShu + ", query=" + query
				+ ", pros=" + pros + "]";
	}

	public List<ProDetail> getPros() {
		return pros;
	}

	public void setPros(List<ProDetail> pros) {
		this.pros = pros;
	}

	


	

}
