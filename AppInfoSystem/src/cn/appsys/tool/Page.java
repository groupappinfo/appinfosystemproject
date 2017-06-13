package cn.appsys.tool;

import java.util.List;

import cn.appsys.pojo.AppInfo;

public class Page {
	private int PageSize;
	private int objectTotalCount;
	private int TotalPageCount;
	private int currentPageIndex;
	private List<AppInfo> listAppInfo;

	public List<AppInfo> getListAppInfo() {
		return listAppInfo;
	}

	public void setListAppInfo(List<AppInfo> listAppInfo) {
		this.listAppInfo = listAppInfo;
	}

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		if (currentPageIndex <= 0) {
			currentPageIndex = 1;
		} else if (currentPageIndex >= this.TotalPageCount) {
			currentPageIndex = this.TotalPageCount;
		}
		this.currentPageIndex = currentPageIndex;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int objectPageSize) {
		this.PageSize = objectPageSize;
	}

	public int getObjectTotalCount() {
		return objectTotalCount;
	}

	public void setObjectTotalCount(int objectTotalCount) {
		if (objectTotalCount == 0) {
			objectTotalCount = 1;
			this.objectTotalCount = 0;
		} else {
			this.objectTotalCount = objectTotalCount;
		}
		this.TotalPageCount = objectTotalCount % this.PageSize == 0 ? objectTotalCount
				/ this.PageSize
				: objectTotalCount / this.PageSize + 1;

	}

	public int getObjectTotalPageCount() {
		return TotalPageCount;
	}

}
