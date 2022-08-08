package com.sevenine.conecta.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;

@Component
public class RequestInformationUtils {

    public RequestData getRequestData(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line;
        ServletInputStream is;
        try {
            is = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return RequestData.builder()
                .path(getFullUrlPath(request))
                .bearer(request.getHeader("Authorization"))
                .headers(getHeaders(request))
                .body(jb.toString())
                .build();
    }

    private static String getFullUrlPath(HttpServletRequest request) {
        StringBuilder requestUrl = new StringBuilder(request.getServletPath());
        String queryString = request.getQueryString();
        if (queryString == null) {
            return requestUrl.toString();
        } else {
            return requestUrl.append('?').append(queryString).toString();
        }
    }

    private HttpHeaders getHeaders(HttpServletRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", request.getHeader("Authorization"));

        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String element = headerNames.nextElement();
                httpHeaders.set(element, request.getHeader(element));
            }
        }

        return httpHeaders;
    }

}
