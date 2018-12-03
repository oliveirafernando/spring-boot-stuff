package com.oliveirafernando.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("springboot-app")
public class AppApiProperty {
	
	private String allowedOrigin = "http://localhost:8080";
	private final AppSecurity appSecurity = new AppSecurity();

	public AppSecurity getAppSecurity() {
		return appSecurity;
	}

	public String getAllowedOrigin() {
		return allowedOrigin;
	}

	public void setAllowedOrigin(String allowedOrigin) {
		this.allowedOrigin = allowedOrigin;
	}

	public static class AppSecurity{
		private Boolean enableHttps = false;

		public Boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(Boolean enableHttps) {
			this.enableHttps = enableHttps;
		} 
	}
}
