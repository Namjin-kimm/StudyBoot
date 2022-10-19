package com.iu.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long perPage;
	private Long perBlock;
	
	private boolean pre;
	private boolean next;
	
	public long getPage(){
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return this.page;
	}
	
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage();
	}

}
