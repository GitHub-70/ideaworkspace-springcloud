package com.tunsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker // 启动 熔断降级 直接走 降级服务
@EnableEurekaClient
@SpringBootApplication

//@SpringCloudApplication //可以使用 @SpringCloudApplication 注解代替三个注解
public class HystrixApplication {

    /**
     * @SpringBootApplication 包含了@Configuration注解
     * @return
     * RestTemplate 是spring WEB中的对象
     *  是用来调用其他微服务的工具类，封装了远程调用代码，
     *  提供了一组用于远程调用的模板方法，例如：getForObject()、postForObject() 等
     *
     *  @LoadBalanced 负载均衡注解，会对 RestTemplate 实例进行封装，
     *  创建动态代理对象，并切入（AOP）负载均衡代码，把请求分散分发到集群中的服务器
     */
    @LoadBalanced //
    @Primary // 优先使用该bean
    @Bean("hystrix_RestTemplate")
    // RestTemplate对象 在Ribbon项目中创建了，注意创建多bean的情况
    public RestTemplate getRestTemplate(){
        // RestTemplate 中默认的 Factory 实例中，两个超时属性默认是 -1，
        //未启用超时，也不会触发重试
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();//??????
        simpleClientHttpRequestFactory.setConnectTimeout(1000);
        simpleClientHttpRequestFactory.setReadTimeout(1000);
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

}
