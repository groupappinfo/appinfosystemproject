package cn.appsys.controller;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.Server;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.service.AppInfoServiceImpl;
import cn.appsys.tool.Page;

@Controller
@RequestMapping("/appInfo")
public class AppInfoContorller {
	@Autowired
	AppInfoServiceImpl appInfoServiceImpl;

	@RequestMapping("/showAppInfoList")
	public String showAppInfoList(AppInfo appInfo, HttpServletRequest request) {
		request.setAttribute("statusList",
				appInfoServiceImpl.getAppStatusList());
		request.setAttribute("flatFormList",
				appInfoServiceImpl.getAppFlatFormList());
		request.setAttribute("categoryLevel1List",
				appInfoServiceImpl.getFirstLevelList());
		request.setAttribute("appInfo", appInfo);
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null) {
			pageIndex = "1";
		}
		page.setPageSize(3);
		page.setTotalCount(appInfoServiceImpl.getAppInfoTotalCount(appInfo));
		page.setCurrentPageNo(Integer.parseInt(pageIndex));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("softwareName", appInfo.getSoftwareName());
		map.put("STATUS", appInfo.getSTATUS());
		map.put("flatformId", appInfo.getFlatformId());
		map.put("categoryLevel1", appInfo.getCategoryLevel1());
		map.put("categoryLevel2", appInfo.getCategoryLevel2());
		map.put("categoryLevel3", appInfo.getCategoryLevel3());
		map.put("fromIndex",
				(page.getCurrentPageIndex() - 1) * page.getPageSize());
		map.put("pageSize", page.getPageSize());
		page.setListAppInfo(appInfoServiceImpl.getAppInfosByPage(map));
		request.setAttribute("appInfoList", page.getListAppInfo());
		request.setAttribute("pages", page);
		return "developer/appinfolist";
	}

	@RequestMapping("/showSecondLevelList")
	@ResponseBody
	public Object showSecondLevelList(@RequestParam("pid") String pid) {
		List<AppCategory> listAppCategory = appInfoServiceImpl
				.getSecondLevelList(Integer.parseInt(pid));
		return JSON.toJSONString(listAppCategory);
	}

	@RequestMapping("/showThirdLevelList")
	@ResponseBody
	public Object showThirdLevelList(@RequestParam("pid") String pid) {
		List<AppCategory> listAppCategory = appInfoServiceImpl
				.getThridLevelList(Integer.parseInt(pid));
		return JSON.toJSONString(listAppCategory);
	}

	@RequestMapping("/showAddAppInfoPage")
	public String showAddAppInfoPage() {
		return "developer/appinfoadd";
	}

	@RequestMapping("/getAppFlatformList")
	@ResponseBody
	public Object getAppFlatformList(@RequestParam("tcode") String tcode) {
		return JSON.toJSONString(appInfoServiceImpl.getAppFlatFormList(tcode));
	}

	@RequestMapping("/getFirstLevelListByAjax")
	@ResponseBody
	public Object getFirstLevelListByAjax(@RequestParam("pid") String pid) {
		return JSON.toJSONString(appInfoServiceImpl.getFirstLevelList());
	}

	@RequestMapping("/checkApkNameUnique")
	@ResponseBody
	public Object checkApkNameUnique(@RequestParam("APKName") String APKName) {
		Map<String, String> map = new HashMap<String, String>();
		if (APKName == null || APKName == "") {
			map.put("APKName", "empty");
		} else if (appInfoServiceImpl.checkApkNameUnique(APKName) == 0) {
			map.put("APKName", "noexist");
		} else {
			map.put("APKName", "exist");
		}
		return JSON.toJSONString(map);
	}

	@RequestMapping("/addAppInfo")
	public String addAppInfo(HttpServletRequest request, AppInfo appInfo,
			@RequestParam("a_logoPicPath") MultipartFile attach) {
		String logoPicPath = null;
		if (!attach.isEmpty()) {// 判断上传文件是否为空
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "uploadfiles");// 创建存放上传文件的文件夹
			String oldFileName = attach.getOriginalFilename();// 获得文件名
			String prefix = FilenameUtils.getExtension(oldFileName);// 获得文件名
			int fileZize = 51200;// 设定上传文件大小
			if (attach.getSize() > fileZize) {// 判断长传文件大小
				request.setAttribute("uploadFileError", "上传文件大小不得超过50kb！");
				request.setAttribute("appInfoBack", appInfo);
				return "forward:/appInfo/showAddAppInfoPage";
			} else if (prefix.equalsIgnoreCase("jpg")// 判断文件格式
					|| prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jpeg")) {
				String fileName = System.currentTimeMillis()// 系统时间及随机数拼接文件名
						+ RandomUtils.nextInt(10000000) + "_personal." + prefix;
				File targetFile = new File(path, fileName);// 创建文件对象
				if (!targetFile.exists()) {// 文件不存在在虚拟机中创建文件
					targetFile.mkdirs();
				}
				try {
					attach.transferTo(targetFile);// 输出内存中文件到本地磁盘
					logoPicPath = path + File.separator + fileName;// 获得文件路径
					appInfo.setLogoLocPath(logoPicPath);
					appInfo.setCreationDate(new Date(System.currentTimeMillis()));
					if (appInfoServiceImpl.addAppInfo(appInfo) == 1) {
						return "redirect:/appInfo/showAppInfoList";

					} else {
						request.setAttribute("uploadFileError", "保存数据失败！");
						request.setAttribute("appInfoBack", appInfo);
						return "forward:/appInfo/showAddAppInfoPage";
					}
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", "上传失败！");
					request.setAttribute("appInfoBack", appInfo);
					return "forward:/appInfo/showAddAppInfoPage";
				}
			} else {	
				request.setAttribute("uploadFileError", "图片格式不正确！");
				request.setAttribute("appInfoBack", appInfo);
				return "forward:/appInfo/showAddAppInfoPage";
			}
		} else {
			request.setAttribute("uploadFileError", "上传文件不得为空！");
			request.setAttribute("appInfoBack", appInfo);
			return "forward:/appInfo/showAddAppInfoPage";
		}
	}
	@RequestMapping(value="/appInfoModify/{id}")
	public String appInfoModify(@PathVariable String id,HttpServletRequest request){
		AppInfo appInfo = null;
		appInfo = appInfoServiceImpl.getAppInfoById(Integer.parseInt(id));
		request.setAttribute("appInfo", appInfo);
		return "developer/appinfomodify";
	}
}
