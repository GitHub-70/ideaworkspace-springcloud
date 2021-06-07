package com.tansun;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableZuulProxy // 集成了Hstrix actuator
@EnableDiscoveryClient
//@Configuration
public class ZuulApplication {

    /**
     * todo 不知为何需要通过以下方式 才能暴露 hystrix.stream
     * http://localhost:3003/actuator/ 暴露的端点中 没有显示 hystrix.stream信息
     * 但却 能通过 http://localhost:3003/actuator/hystrix.stream 访问
     *
     * 据网上资料说，低版本可根据配置，可直接查看 hystrix.stream 信息
     * 高版本需要通过下面方法 才能查看hystrix.stream 信息
     *
     */
//    @Bean
//    public ServletRegistrationBean getServlet() {
//
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        registrationBean.setName("ZuulMetricsStreamServlet");
//        return registrationBean;
//    }


    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}
