package cn.appsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.AppVersionMapper;
import cn.appsys.pojo.AppVersion;

@Service("AppVersionServiceImpl")
public class AppVersionServiceImpl implements AppVersionService {
	@Autowired
	private AppVersionMapper appVersionMapper;
	@Override
	public AppVersion getAppVersion(AppVersion appVersion) {
		return appVersionMapper.getAppVersion(appVersion);
	}

}
