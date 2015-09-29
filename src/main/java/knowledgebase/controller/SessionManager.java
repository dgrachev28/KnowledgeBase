package knowledgebase.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SessionManager {

    @Bean
    UserSession userSession() {
        return new UserSession();
    }
}

