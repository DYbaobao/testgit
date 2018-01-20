package cn.model;

import java.util.List;

public class Page {
	     //总页数
		private int totalPageCount=1;
		//每页显示记录数
		private int pageSize=0;
		//记录总数
		private int totalCount=0;
		//当前的页数（页码）
		private int currPageNo=1;
		//显示用户的信息集合
		List<BookStock> list;
		public int getTotalPageCount() {
			return totalPageCount;
		}
		public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			if(pageSize>0){
				this.pageSize = pageSize;
			}
			
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			if(totalCount>0){
				this.totalCount = totalCount;
				//计算总页数
				totalPageCount=totalCount%this.pageSize==0
					?totalCount/this.pageSize
						:totalCount/this.pageSize+1;
			}
			
		}
		public int getCurrPageNo() {
			return currPageNo;
		}
		public void setCurrPageNo(int currPageNo) {
			this.currPageNo = currPageNo;
		}
		public List<BookStock> getList() {
			return list;
		}
		public void setList(List<BookStock> list) {
			this.list = list;
		}
}
