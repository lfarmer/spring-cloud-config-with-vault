package com.example.configservice;

import io.pivotal.spring.cloud.vault.service.common.VaultServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.VaultEnvironmentRepository;

import static org.springframework.test.util.ReflectionTestUtils.getField;

@Slf4j
@EnableConfigServer
@SpringBootApplication
public class ConfigServiceApplication implements CommandLineRunner {

    @Autowired
    private VaultServiceInfo vaultServiceInfo;

    @Autowired
    private VaultEnvironmentRepository vaultEnvironmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Project configured with:");
        log.info("Vault Service Info: {}", vaultServiceInfo.toString());
        log.info("Vault Repo Info: {}://{}:{}",
                getField(vaultEnvironmentRepository, "scheme"),
                getField(vaultEnvironmentRepository, "host"),
                getField(vaultEnvironmentRepository, "port"));
    }
}
