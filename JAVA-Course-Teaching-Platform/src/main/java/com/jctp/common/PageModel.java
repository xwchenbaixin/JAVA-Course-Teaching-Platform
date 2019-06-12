package com.jctp.common;

public class PageModel {
	private int pageIndex;
	private int pageSize;
	private int offset;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getOffset() {
		if(pageIndex!=0&&pageSize!=0)
			this.offset=(pageIndex-1)*pageSize;
		else {
			this.offset=0;
		}
		return offset;
	}
	
	
}
