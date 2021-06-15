package com.tansun.service;


import com.tansun.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class OrderServiceFallback implements FallbackProvider {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceFallback.class);

    @Override
    public String getRoute() {
        //当执行order-service失败，
        //应用当前这个降级类
        return "order-server";
        // 星号和null都表示所有微服务失败 都应用当前降级类
        //"*"; //null;
    }

    //该方法返回封装降级响应的对象
    //ClientHttpResponse中封装降级响应
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return response();
    }

    private ClientHttpResponse response() {

        return new ClientHttpResponse() {
            //下面三个方法都是协议号
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                logger.info("fallback body");
                String s = JsonResult.err().msg("后台服务错误").toString();
                return new ByteArrayInputStream(s.getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
