package com.javatech.utils;

public class StringUtil{
    public static String makeBeautiful(String str){
    	if(str == null) return "";
        return str.trim().replaceAll("\\s+", " ");
    }
    
    /**
     * 
     * @param str
     * @return true if str is null or empty
     */
    public static Boolean isNullOrEmpty(String str) {
    	if(str == null || str.equals("")) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 
     * @param strs
     * @return true, if all field is not null or empty.
     */
    public static Boolean checkNullOrEmptyForValidation(String... strs) {
    	for (String str : strs) {
			if(isNullOrEmpty(str)) {
				return false;
			}
		}
    	return true;
    }
}