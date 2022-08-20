package com.sevenine.conecta.config;

import java.time.format.DateTimeFormatter;

public class Constants {
    private static final String DATE_FORMAT_BRAZILIAN = "dd/MM/yyyy";

    public static final DateTimeFormatter OF_PATTERN_DATE = DateTimeFormatter.ofPattern(DATE_FORMAT_BRAZILIAN);
    public static final String PROFISSIONAL_NAO_LOCALIZADO = "Profissional não cadastrado";
}
