package com.javatech.utils;
import javax.servlet.http.HttpServletRequest;

import com.javatech.model.UserModel;

public class SessionUtil {

	public static final String USERMODEL = "USERMODEL";
	
    private static SessionUtil sessionUtil = null;
    
    private static Integer userId = null;

    public static SessionUtil getInstance() {
        if (sessionUtil == null) {
            sessionUtil = new SessionUtil();
        }
        return sessionUtil;
    }

    public void putValue(HttpServletRequest request, String key, Object value) {
    	if(value != null) {
    		request.getSession().setAttribute(key, value);
    		if(key.equals(USERMODEL)) {
    			userId = ((UserModel)value).getId();
    		}
    	}
    }

    public Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public void removeValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
        if(key.equals(USERMODEL)) {
			userId = null;
		}
    }

	public static Integer getUserId() {
		return userId;
	}
}
