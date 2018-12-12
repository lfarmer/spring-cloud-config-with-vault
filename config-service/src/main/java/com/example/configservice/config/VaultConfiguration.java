package com.example.configservice.config;

import io.pivotal.spring.cloud.vault.service.common.VaultServiceInfo;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.server.environment.VaultEnvironmentProperties;
import org.springframework.cloud.config.server.environment.VaultEnvironmentRepository;
import org.springframework.cloud.config.server.environment.VaultEnvironmentRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class VaultConfiguration {

    @Bean
    @Profile("cloud")
    public VaultServiceInfo vaultServiceInfo() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        return (VaultServiceInfo) cloud.getServiceInfo("my-vault");
    }

    @Bean
    @Profile("cloud")
    public VaultEnvironmentRepository cloudVaultEnvironmentRepository(VaultEnvironmentRepositoryFactory vaultEnvironmentRepositoryFactory,
                                                                      VaultEnvironmentProperties vaultEnvironmentProperties,
                                                                      VaultServiceInfo vaultServiceInfo) throws Exception {
        vaultEnvironmentProperties.setScheme(vaultServiceInfo.getScheme());
        vaultEnvironmentProperties.setHost(vaultServiceInfo.getHost());
        vaultEnvironmentProperties.setPort(443);
        return vaultEnvironmentRepositoryFactory.build(vaultEnvironmentProperties);
    }

}

