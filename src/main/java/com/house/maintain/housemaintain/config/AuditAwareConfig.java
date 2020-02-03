package com.house.maintain.housemaintain.config;

import com.house.maintain.housemaintain.service.security.AuditAwareService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableJpaAuditing
public class AuditAwareConfig {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditAwareService();
    }


    @Bean
    public Mapper dozerBean() {
        List<String> mappingFiles = Arrays.asList(
                "mapper.xml"
        );

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

}
