package com.example.configservice;

import io.pivotal.spring.cloud.vault.service.common.VaultServiceInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceApplication {

    @Bean
    @Profile("cloud")
    public void something() {
        System.out.println(System.getenv("VCAP_APPLICATION"));
        System.out.println(System.getenv("VCAP_SERVICES"));
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        VaultServiceInfo myService = (VaultServiceInfo) cloud.getServiceInfo("my-vault");
        myService.getUri();
        myService.getToken();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }
}
