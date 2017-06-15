package cn.appsys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;

public interface AppInfoMapper {
	public List<AppInfo> getAppInfosByPage(Map<String, Object> map);

	public int getAppInfoTotalCount(AppInfo appInfo);

	public List<AppCategory> getFirstLevelList();

	public List<AppCategory> getSecondLevelList(
			@Param("firstLevelId") int firstLevelId);

	public List<AppCategory> getThridLevelList(
			@Param("secondLevelId") int secondLevelId);

	public List<DataDictionary> getAppStatusList();

	public List<DataDictionary> getAppFlatFormList();

	public List<DataDictionary> getAppFlatFormList(
			@Param("typeCode") String typeCode);

	public int checkApkNameUnique(@Param("APKName") String APKName);
	
	public int addAppInfo(AppInfo appInfo);
}
