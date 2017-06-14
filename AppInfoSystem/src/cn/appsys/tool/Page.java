package cn.appsys.tool;

import java.util.List;

import cn.appsys.pojo.AppInfo;

public class Page {
	private int PageSize;
	private int totalCount;
	private int TotalPageCount;
	private int currentPageNo;
	private List<AppInfo> listAppInfo;

	public List<AppInfo> getListAppInfo() {
		return listAppInfo;
	}

	public void setListAppInfo(List<AppInfo> listAppInfo) {
		this.listAppInfo = listAppInfo;
	}
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount == 0) {
			totalCount = 1;
			this.totalCount = 0;
		} else {
			this.totalCount = totalCount;
		}
		this.TotalPageCount = totalCount % this.PageSize == 0 ? totalCount
				/ this.PageSize
				: totalCount / this.PageSize + 1;
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return TotalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		TotalPageCount = totalPageCount;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		if (currentPageNo <= 0) {
			currentPageNo = 1;
		} else if (currentPageNo >= this.TotalPageCount) {
			currentPageNo = this.TotalPageCount;
		}
		this.currentPageNo = currentPageNo;
	}

	public int getCurrentPageIndex() {
		return currentPageNo;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int objectPageSize) {
		this.PageSize = objectPageSize;
	}
}

