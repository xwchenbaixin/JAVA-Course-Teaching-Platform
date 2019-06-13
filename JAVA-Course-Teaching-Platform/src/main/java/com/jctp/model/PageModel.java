package com.jctp.model;

import com.jctp.tools.StringTools;

import net.bytebuddy.asm.Advice.This;

public class PageModel {
	private int page;
	private int limit;
	private int offset;
	private String sort;
	private String order;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getSort() {
		return sort;
	}
	//防止SQL注入攻击，去除
	public void setSort(String sort) {
		System.out.println(sort);
		sort=StringTools.upperCharToUnderLine(sort);
		System.out.println(sort);
		if(!sort.matches("^[A-Za-z_]*$")) {
			System.out.println("防御SQL注入攻击，设置排序列为id");
			sort="id";
		}
		this.sort=sort;
		System.out.println(sort);
		
	}
	public String getOrder() {
		return order;
	}
	//防止SQL注入攻击
	public void setOrder(String order) {
		if(!order.equals("desc"))
			order="asc";
		this.order = order;
	}
	
}
