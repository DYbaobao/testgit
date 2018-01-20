package cn.it.ssm.model;

import java.util.List;

public class Page {
	     //��ҳ��
		private Integer totalPageCount=1;
		//ÿҳ��ʾ��¼��
		private Integer pageSize=0;
		//��¼����
		private Integer totalCount=0;
		//��ǰ��ҳ����ҳ�룩
		private Integer currPageNo=1;
		//��ʾ�û�����Ϣ����
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
				//������ҳ��
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
