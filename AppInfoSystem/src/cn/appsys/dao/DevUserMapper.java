package cn.appsys.dao;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	public DevUser getDevUserByCode(DevUser devUser);

	public DevUser getDevUserByCodeAndPassword(DevUser devUser);
}
