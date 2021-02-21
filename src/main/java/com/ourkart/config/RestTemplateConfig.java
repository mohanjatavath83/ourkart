package com.ourkart.config;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.apache.http.client.HttpClient;


@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {


        //socketTimeout() (or SO_TIMEOUT) refers to the timeout for waiting for data,
        // connectTimeout() refers to the timeout until a connection is established
        //connectionRequestTimeout() refers to the timeout when requesting a connection from the connection manager.
        //GET, HEAD, POST, PUT, DELETE, TRACE and OPTIONS


        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(getHttpClient());
        clientHttpRequestFactory.setConnectTimeout(5000);
        clientHttpRequestFactory.setReadTimeout(5000);
        clientHttpRequestFactory.setConnectionRequestTimeout(5000);

        return clientHttpRequestFactory;
    }

    public HttpClient getHttpClient()
    {
        return getHttpClientBuilder().build();
    }

    public HttpClientBuilder getHttpClientBuilder()
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //httpClientBuilder.setConnectionManager();
        httpClientBuilder.setMaxConnTotal(20);
        httpClientBuilder.setMaxConnPerRoute(0);

        return httpClientBuilder;
    }
}
