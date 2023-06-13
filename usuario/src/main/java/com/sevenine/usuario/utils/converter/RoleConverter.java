package com.sevenine.usuario.utils.converter;

import com.sevenine.usuario.entity.Role;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoleConverter {

    public static List<Role> rolesStringToRolesList(String roles) {
        String rolesSemColchetesSemAspas = roles.replaceAll("[\\[\\]\"]", "");
        List<String> rolesList = Arrays.asList(StringUtils.commaDelimitedListToStringArray(rolesSemColchetesSemAspas));
        return rolesList.stream().map(Role::new).collect(Collectors.toList());
    }

}
