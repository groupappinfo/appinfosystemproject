package cn.appsys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.SetAllPropertiesRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.BackendUserService;
import cn.appsys.service.DevUserServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private DevUserServiceImpl devUserServiceImpl;
	@Autowired 
	private BackendUserService backendUserService;

	

	@RequestMapping("/dev")
	public String ShowDevLoginPage() {
		return "devlogin";
	}

	@RequestMapping("/devLogin")
	public String devLogin(DevUser devUser, HttpServletRequest request,
			HttpSession session) {
		if (devUser.getDevCode().trim() == null
				|| devUser.getDevCode().trim() == "") {
			request.setAttribute("error", "请输入用户名！");
			return "devlogin";
		} else if (devUser.getDevPassword().trim() == null
				|| devUser.getDevPassword().trim() == "") {
			request.setAttribute("devUserSession", devUser);
			request.setAttribute("error", "请输入密码！");
			return "devlogin";
		} else {
			DevUser devUser1 = null;
			if ((devUser1 = devUserServiceImpl.getDevUserByCode(devUser))!= null) {
				devUser1 = null;
				if ((devUser1 = devUserServiceImpl
						.getDevUserByCodeAndPassword(devUser)) != null) {
					request.removeAttribute("devUserSession");
					session.setAttribute("devUserSession", devUser1);
					return "developer/main";
				} else {
					devUser1 = new DevUser();
					devUser1.setDevCode(devUser.getDevCode());
					request.setAttribute("devUserSession", devUser1);
					request.setAttribute("error", "密码不正确！");
					return "devlogin";
				}
			} else {
				request.setAttribute("devUserSession", devUser1);
				request.setAttribute("error", "用户名不存在！");
				return "devlogin";
			}
		}
	}
	@RequestMapping("/devLogout")
	public String devLogout(HttpSession session){
		session.removeAttribute("userSession");
		return "devlogin";
	}
	
	
	@RequestMapping("/backend")
	public String ShowBackendLoginPage() {
		return "backendlogin";
	}
	@RequestMapping("/backendlogin")
	public String backendLogin(BackendUser backendUser,HttpServletRequest  request,HttpSession session){
		System.out.println("backendLogin");
		if (backendUser.getUserCode().trim() == null || backendUser.getUserCode().trim() == "") {
			System.out.println("1");
			request.setAttribute("error", "请输入用户名！");
			return "backendlogin";
		}else if(backendUser.getUserPassword().trim() == null || backendUser.getUserPassword().trim() == ""){
			System.out.println("2");
			request.setAttribute("userSession", backendUser);
			request.setAttribute("error", "请输入密码！");
			return "backendlogin";
		}else{
			System.out.println("3");
			BackendUser backend = null;
			if ((backend = backendUserService.getBackendUserByCode(backendUser)) != null) {
				backend = null;
				if ((backend = backendUserService.getBackendUserByCodeAndPassword(backendUser)) != null) {
					request.removeAttribute("userSession");
					session.setAttribute("userSession", backend);
					return "backend/main";
				}else{
					backend = new BackendUser();
					backend.setUserCode(backendUser.getUserCode());
					request.setAttribute("userSession", backend);
					request.setAttribute("error", "密码不正确！");
					return "backendlogin";
				}
			}else{
				request.setAttribute("userSession", backend);
				request.setAttribute("error", "用户名不存在");
				return "backendlogin";
			}
		}
	}
	@RequestMapping("/backendLogout")
	public String backendLogin(HttpSession session){
		session.removeAttribute("userSession");
		return "backendlogin";
	}
}
