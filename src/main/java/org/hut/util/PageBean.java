/**
 * 
 */
package org.hut.util;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * @author Administrator
 *
 */
@Component
@Scope("prototype")
public class PageBean <T, V>{
    private Integer currentPage; //当前页数
    private Integer pageSize=4;  //每页记录条数
    private Integer totalPage;   //总页数   
    private Integer countPageSize; //总记录条数
    private Integer startPageSize;  //查询的页数开始记录数
	private Integer endPageSize;    //查询的页数结束记录数
	private T query;    //查询条件
	private  List<V> list;  //查询结果
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
//		if(getCountPageSize()%getPageSize()==0) {
//			totalPage=getCountPageSize()/getPageSize();
//		}else {
//			totalPage=getCountPageSize()/getPageSize()+1;
//		}
		 return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCountPageSize() {
		return countPageSize;
	}
	public void setCountPageSize(Integer countPageSize) {
		if(countPageSize%getPageSize()==0) {
			totalPage=countPageSize/getPageSize();
		}else {
			totalPage=countPageSize/getPageSize()+1;
		}
		this.countPageSize = countPageSize;
	}
	public Integer getStartPageSize() {
		startPageSize=(getCurrentPage()-1)*getPageSize();
		return startPageSize;
	}
	public void setStartPageSize(Integer startPageSize) {
		this.startPageSize = startPageSize;
	}
	public Integer getEndPageSize() {
		endPageSize=getCurrentPage()*getPageSize();
		return endPageSize;
	}
	public void setEndPageSize(Integer endPageSize) {
		this.endPageSize = endPageSize;
	}
	public T getQuery() {
		return query;
	}
	public void setQuery(T query) {
		this.query = query;
	}
	public List<V> getList() {
		return list;
	}
	public void setList(List<V> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", countPageSize=" + countPageSize + ", startPageSize=" + startPageSize + ", endPageSize="
				+ endPageSize + ", query=" + query + ", list=" + list + "]";
	}
}
