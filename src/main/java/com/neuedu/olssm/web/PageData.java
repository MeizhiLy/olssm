package com.neuedu.olssm.web;

import java.util.List;

public class PageData<T> {
	// 当前页码
	private int curPage;
	// 总页�?
	private int totalPage;
	// 数据总数
	private int totalRecourd;

	// 返回的数�?
	private List<T> data;
	private int pageSize;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public PageData(int pageSize, int curPage) {
		this.pageSize = pageSize;
		this.curPage = curPage;
	}

	public int getTotalPage() {
		totalPage = totalRecourd % pageSize == 0 ? totalRecourd / pageSize : (totalRecourd / pageSize) + 1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecourd() {
		return totalRecourd;
	}

	public void setTotalRecourd(int totalRecourd) {
		this.totalRecourd = totalRecourd;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageData [curPage=" + curPage + ", totalPage=" + totalPage + ", totalRecourd=" + totalRecourd
				+ ", data=" + data + ", pageSize=" + pageSize + "]";
	}

}
