package cn.appsys.service;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
	public DevUser getDevUserByCode(DevUser devUser);

	public DevUser getDevUserByCodeAndPassword(DevUser devUser);
}
