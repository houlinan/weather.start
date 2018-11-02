package cn.hgxsp.springCloud.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * DESC：请求配置类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/11/1
 * Time : 17:22
 */
@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder ;

    @Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build();
    }

}
