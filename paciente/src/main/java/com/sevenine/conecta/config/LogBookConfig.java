package com.sevenine.conecta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.DefaultHttpLogWriter;
import org.zalando.logbook.DefaultSink;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.json.JsonHttpLogFormatter;

import static org.zalando.logbook.Conditions.exclude;
import static org.zalando.logbook.Conditions.requestTo;

@Configuration
public class LogBookConfig {

    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .condition(exclude(requestTo("/actuator/health")))
//                .bodyFilter(jsonPath("$.foto").replace("data:image"))
//                .bodyFilter(jsonPath("$.fotoRg").replace("data:image"))
//                .bodyFilter(jsonPath("$.fotoCpf").replace("data:image"))
//                .bodyFilter(jsonPath("$.comprovante").replace("data:image"))
                .sink(new DefaultSink(new JsonHttpLogFormatter(), new DefaultHttpLogWriter()))
                .build();
    }

}
