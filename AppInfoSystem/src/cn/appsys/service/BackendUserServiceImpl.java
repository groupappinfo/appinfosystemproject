package cn.appsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.BackendUserMapper;
import cn.appsys.pojo.BackendUser;
@Service("BackendUserServiceImpl")
public class BackendUserServiceImpl implements BackendUserService {
	@Autowired
	private BackendUserMapper backendUserMapper;
	
	@Override
	public BackendUser getBackendUserByCode(BackendUser backendUser) {
		
		return backendUserMapper.getBackendUserByCode(backendUser);
	}

	@Override
	public BackendUser getBackendUserByCodeAndPassword(BackendUser backendUser) {
		// TODO Auto-generated method stub
		return backendUserMapper.getBackendUserByCodeAndPassword(backendUser);
	}
}	
