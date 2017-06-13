package cn.appsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.DevUserMapper;
import cn.appsys.pojo.DevUser;
@Service("DevUserServiceImpl")
public class DevUserServiceImpl implements DevUserService {
	@Autowired
	private DevUserMapper devUserMapper;

	@Override
	public DevUser getDevUserByCode(DevUser devUser) {
		
		return devUserMapper.getDevUserByCode(devUser);
	}

	@Override
	public DevUser getDevUserByCodeAndPassword(DevUser devUser) {

		return devUserMapper.getDevUserByCodeAndPassword(devUser);
	}

}
