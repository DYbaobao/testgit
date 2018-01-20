package cn.it.ssm.model;

import java.util.List;

public class Page {
	     //总页数
		private Integer totalPageCount=1;
		//每页显示记录数
		private Integer pageSize=0;
		//记录总数
		private Integer totalCount=0;
		//当前的页数（页码）
		private Integer currPageNo=1;
		//显示用户的信息集合
		List<User> list;
		public Integer getTotalPageCount() {
			return totalPageCount;
		}
		public void setTotalPageCount(Integer totalPageCount) {
			this.totalPageCount = totalPageCount;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			if(pageSize>0){
				this.pageSize = pageSize;
			}
			
		}
		public Integer getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(Integer totalCount) {
			if(totalCount>0){
				this.totalCount = totalCount;
				//计算总页数
				totalPageCount=totalCount%this.pageSize==0
					?totalCount/this.pageSize
						:totalCount/this.pageSize+1;
			}
			
		}
		public Integer getCurrPageNo() {
			return currPageNo;
		}
		public void setCurrPageNo(Integer currPageNo) {
			this.currPageNo = currPageNo;
		}
		public List<User> getList() {
			return list;
		}
		public void setList(List<User> list) {
			this.list = list;
		}
}
