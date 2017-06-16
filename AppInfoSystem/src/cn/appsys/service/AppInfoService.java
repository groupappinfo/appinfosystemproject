package cn.appsys.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;

public interface AppInfoService {
	
	public List<AppInfo> getAppInfosByPage(Map<String, Object> map);

	public int getAppInfoTotalCount(AppInfo appInfo);

	public List<AppCategory> getFirstLevelList();

	public List<AppCategory> getSecondLevelList(@Param("firstLevelId") int firstLevelId);

	public List<AppCategory> getThridLevelList(@Param("secondLevelId") int secondLevelId);
	
	public List<DataDictionary> getAppStatusList();
	
	public List<DataDictionary> getAppFlatFormList();
	
	public List<DataDictionary> getAppFlatFormList(String typeCode);
	
	public int checkApkNameUnique(@Param("APKName") String APKName);
	
	public int addAppInfo(AppInfo appInfo);
	
	public AppInfo getAppInfoById(int id);
<<<<<<< HEAD
	
	public AppInfo getAppByAidVid(AppInfo appInfo);
	//审核App
	public boolean checkApp(AppInfo appInfo);
=======
>>>>>>> 6388e0b5485a06188812413227fcbe612c1e5370
}
