package com.auditDemo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"com.auditDemo.*"})
@EntityScan(basePackages = "com.auditDemo.entities")
@EnableJpaRepositories(basePackages = "com.auditDemo.repo")
@Configuration
public class AuditConfiguration {


}
