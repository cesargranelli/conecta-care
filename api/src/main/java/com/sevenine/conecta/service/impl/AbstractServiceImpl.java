package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.http_.response.HyperMediaResponse;
import com.sevenine.conecta.service.AbstractService;
import com.google.gson.Gson;
import com.sevenine.conecta.utils.RequestData;
import com.sevenine.conecta.utils.RequestInformationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AbstractServiceImpl implements AbstractService {

    private final RestTemplate restTemplate;
    private final RequestInformationUtils requestInformationUtils;
    private final Gson gson;

    public ResponseEntity<Object> abstractRequest(HttpServletRequest request, String url, HttpMethod method) {
        RequestData requestData = requestInformationUtils.getRequestData(request);

        HttpEntity<?> httpEntity = new HttpEntity<>(requestData.getBody(), requestData.getHeaders());
        try {
            ResponseEntity<Object> response =
                    restTemplate.exchange(url + requestData.getPath(), method, httpEntity, Object.class);
            HyperMediaResponse hyperMediaResponse =
                    new HyperMediaResponse(response.getStatusCode().is2xxSuccessful(), response.getStatusCode().value(), response.getBody());
            return ResponseEntity.status(response.getStatusCode()).body(hyperMediaResponse);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            HyperMediaResponse hyperMediaResponse =
                    new HyperMediaResponse(false, e.getStatusCode().value(), gson.fromJson(e.getResponseBodyAsString(), Object.class));
            return ResponseEntity.status(e.getStatusCode()).body(hyperMediaResponse);
        }
    }

    public ResponseEntity<Resource> abstractRequestOctetStream(HttpServletRequest request, String url, HttpMethod method) {
        RequestData requestData = requestInformationUtils.getRequestData(request);

        HttpEntity<?> httpEntity = new HttpEntity<>(requestData.getBody(), requestData.getHeaders());
        try {
            ResponseEntity<byte[]> response =
                    restTemplate.exchange(url + requestData.getPath(), method, httpEntity, byte[].class);

            File f = new File(System.currentTimeMillis() + ".pdf");
            try (FileOutputStream stream = new FileOutputStream(f)) {
                stream.write(response.getBody());
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(f));
            return ResponseEntity.ok()
                    .headers(response.getHeaders())
                    .contentLength(f.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);

        } catch (IOException | HttpServerErrorException | HttpClientErrorException e) {
            e.printStackTrace();
            return null;
        }
    }

}
