package cn.appsys.service;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
			//根据后台用户编码查询用户信息
			public BackendUser getBackendUserByCode(BackendUser backendUser);
			//根据后台用户编码和密码查询用户信息
			public BackendUser getBackendUserByCodeAndPassword(BackendUser backendUser);
}
