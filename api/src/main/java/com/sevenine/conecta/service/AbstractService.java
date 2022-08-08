package com.sevenine.conecta.service;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface AbstractService {

    ResponseEntity<Object> abstractRequest(HttpServletRequest request, String url, HttpMethod method);
    ResponseEntity<Resource> abstractRequestOctetStream(HttpServletRequest request, String url, HttpMethod method);

}
