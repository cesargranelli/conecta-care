package com.sevenine.conecta.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.BodyFilter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.zalando.logbook.BodyFilter.merge;
import static org.zalando.logbook.BodyFilters.defaultValue;
import static org.zalando.logbook.json.JsonBodyFilters.replaceJsonStringProperty;

//@Getter
//@Configuration
public class ConfigLogBook {

//    @Value("${logbook.obfuscate.properties}")
//    private List<String> obfuscateProperties;
//
//    @Bean
//    public BodyFilter bodyFilter() {
//        Set<String> properties = new HashSet<>(getObfuscateProperties());
//
//        return merge(
//                defaultValue(),
//                replaceJsonStringProperty(properties, "data:image"));
//    }

}
