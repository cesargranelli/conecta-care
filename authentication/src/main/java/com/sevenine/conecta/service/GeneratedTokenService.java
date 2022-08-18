package com.sevenine.conecta.service;

import java.util.List;

public interface GeneratedTokenService {
    String retrieveToken(String username, List<String> roles, String module);
}
