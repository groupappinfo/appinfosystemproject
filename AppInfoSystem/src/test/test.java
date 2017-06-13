package test;



import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.appsys.dao.AppInfoMapper;
import cn.appsys.pojo.AppInfo;



public class test {
	@Test
	public void testOne(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");	
		AppInfoMapper appInfoMapper =  (AppInfoMapper)context.getBean("appInfoMapper");
	    List<AppInfo> listAppInfo = appInfoMapper.getAppInfosByPage();
	    System.out.println(listAppInfo.size());
	    for (Iterator iterator = listAppInfo.iterator(); iterator.hasNext();) {
			AppInfo appInfo = (AppInfo) iterator.next();
			System.out.println(appInfo.getFlatformName()+"---------"+appInfo.getCategoryLevel1Name()+"---------"+appInfo.getCategoryLevel2Name()+"-----" +
					"----"+appInfo.getCategoryLevel3Name()+"---------"+appInfo.getStatusName()+"---------"+appInfo.getVersionNo());
		}
	}


}
