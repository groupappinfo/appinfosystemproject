package cn.appsys.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfoMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
@Service("AppInfoServiceImpl")
public class AppInfoServiceImpl implements AppInfoService {
	@Autowired
	AppInfoMapper appInfoMapper;

	@Override
	public List<AppInfo> getAppInfosByPage(Map<String, Object> map) {

		return appInfoMapper.getAppInfosByPage(map);
	}

	@Override
	public int getAppInfoTotalCount(AppInfo appInfo) {

		return appInfoMapper.getAppInfoTotalCount(appInfo);
	}

	@Override
	public List<AppCategory> getFirstLevelList() {
		
		return appInfoMapper.getFirstLevelList();
	}

	@Override
	public List<AppCategory> getSecondLevelList(
			 int firstLevelId) {
		
		return appInfoMapper.getSecondLevelList(firstLevelId);
	}

	@Override
	public List<AppCategory> getThridLevelList(
			 int secondLevelId) {
		
		return appInfoMapper.getThridLevelList(secondLevelId);
	}

	@Override
	public List<DataDictionary> getAppStatusList() {
		
		return appInfoMapper.getAppStatusList();
	}

	@Override
	public List<DataDictionary> getAppFlatFormList() {
	
		return appInfoMapper.getAppFlatFormList();
	}

	@Override
	public List<DataDictionary> getAppFlatFormList(String typeCode) {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppFlatFormList(typeCode);
	}

	@Override
	public int checkApkNameUnique(@Param("APKName") String APKName) {
		// TODO Auto-generated method stub
		return appInfoMapper.checkApkNameUnique(APKName);
	}

	@Override
	public int addAppInfo(AppInfo appInfo) {
		// TODO Auto-generated method stub
		return appInfoMapper.addAppInfo(appInfo);
	}

	@Override
	public AppInfo getAppInfoById(int id) {
	return appInfoMapper.getAppInfoById(id);
	}

<<<<<<< HEAD
	@Override
	public AppInfo getAppByAidVid(AppInfo appInfo) {
		return appInfoMapper.getAppByAidVid(appInfo);
	}

	@Override
	public boolean checkApp(AppInfo appInfo) {
		int row = appInfoMapper.checkApp(appInfo);
		if (row != 0) {
			return true;
		}else{
			return false;
		}
	}

=======
>>>>>>> 6388e0b5485a06188812413227fcbe612c1e5370
}
