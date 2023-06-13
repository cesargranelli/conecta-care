package com.sevenine.usuario.services;

import java.util.List;

public interface GeneratedTokenService {
    String retrieveToken(String username, List<String> roles, String module);
}
