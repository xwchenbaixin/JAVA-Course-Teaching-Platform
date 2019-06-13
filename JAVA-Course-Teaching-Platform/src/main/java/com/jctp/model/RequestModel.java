package com.jctp.model;

public class RequestModel<T> {
	private T param;
	private PageModel pageModel;
	public T getParam() {
		return param;
	}
	public void setParam(T param) {
		this.param = param;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	
}
