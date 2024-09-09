package com.mfouad.userService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor { 
	
	@Override 
	public void contribute(Info.Builder builder) {
		Map<String, Object> details= new HashMap<String, Object>();
		details.put("app.version", System.getProperty("application.version"));
		details.put("java.version", System.getProperty("java.version"));
		builder.withDetails(details).build();
		}
	

}
