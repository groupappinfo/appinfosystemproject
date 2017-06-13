package cn.appsys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private DevUserServiceImpl devUserServiceImpl;

	@RequestMapping("/backend")
	public String ShowBackendLoginPage() {
		return "backendlogin";
	}

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
		session.removeAttribute("devUserSession");
		return "devlogin";
	}
	



}
