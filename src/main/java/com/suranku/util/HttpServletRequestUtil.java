package com.suranku.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class HttpServletRequestUtil {
    public static String getFullRequestUri(HttpServletRequest request) {
        String uri = null;
        if(request != null) {
            String queryString = request.getQueryString();
            uri = request.getRequestURI() + (StringUtils.isBlank(queryString) ? "" : "?" + queryString);
        }
        return uri;
    }
}
