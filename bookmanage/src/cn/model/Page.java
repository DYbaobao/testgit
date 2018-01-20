package cn.model;

import java.util.List;

public class Page {
	     //��ҳ��
		private int totalPageCount=1;
		//ÿҳ��ʾ��¼��
		private int pageSize=0;
		//��¼����
		private int totalCount=0;
		//��ǰ��ҳ����ҳ�룩
		private int currPageNo=1;
		//��ʾ�û�����Ϣ����
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
				//������ҳ��
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
