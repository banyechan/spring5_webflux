package com.banyechan.spring5_webflux_demo.Configuration;


import com.banyechan.spring5_webflux_demo.handler.BookHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private BookHandler bookHandler;


    @Bean
    public RouterFunction<ServerResponse> bookRouter() {
        return RouterFunction.route(RequestPredicates.GET("/list"), req -> bookHandler::bookList)
                .andRoute(GET("/book"), bookHandler::getBook);
    }




}
