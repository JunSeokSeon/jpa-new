package com.jpa.runtime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class WebConfiguration {
	
	@Bean
	CustomAuditorAware customAuditorAware() {
		return new CustomAuditorAware();
	}
}
