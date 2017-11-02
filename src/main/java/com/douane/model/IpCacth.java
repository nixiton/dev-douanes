package com.douane.model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class IpCacth {
	
	
	public static String getClientIpLocal(HttpServletRequest request) {
		String ipAddress = request.getRemoteAddr();
		return ipAddress;
	}
	
	public static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
	
	public static Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

	    Map<String, String> result = new HashMap<String, String>();

	    Enumeration headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = request.getHeader(key);
	        result.put(key, value);
	    }

	    return result;
	}
	
	/*
	 * "referer" :"https://www.google.com/",
"cf-ipcountry" :"US",
"cf-ray" :"348c7acba8a02210-EWR",
"x-forwarded-proto" :"https",
"accept-language" :"en-US,en;q=0.8",
"cookie" :"__cfduid=d3c6e5d73aa55b6b42fad9600c94849851490726068; _ga=GA1.2.450731937.1490726069",

"x-forwarded-for" :"100.8.204.40",             // <------ This is client real IP

"accept" :"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*\/*;q=0.8",

"x-real-ip" :"108.162.219.236",             // <------ This is cloudflare IP

"x-forwarded-server" :"hostingcompass.com",
"x-forwarded-host" :"hostingcompass.com",
 "cf-visitor" :"{\"scheme\":\"https\"}",
"host" :"127.0.0.1:8080",
"upgrade-insecure-requests" :"1",
"connection" :"close",
"cf-connecting-ip" :"100.8.204.40",
"accept-encoding" :"gzip",
"user-agent" : "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"
	 */
}
