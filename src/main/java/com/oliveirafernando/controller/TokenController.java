package com.oliveirafernando.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveirafernando.config.property.AppApiProperty;

@RestController
@RequestMapping("/tokens")
public class TokenController {
	
	@Autowired
	private AppApiProperty appApiProperty;

	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(this.appApiProperty.getAppSecurity().isEnableHttps());
		cookie.setPath(req.getContextPath() + "/oauth/token");

		resp.addCookie(cookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
