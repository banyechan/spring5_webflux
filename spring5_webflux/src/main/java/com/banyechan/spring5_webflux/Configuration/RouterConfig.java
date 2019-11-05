package com.banyechan.spring5_webflux.Configuration;


import com.banyechan.spring5_webflux.handler.BookHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Autowired
    private BookHandler bookHandler;


    @Bean
    public RouterFunction<ServerResponse> bookRouter() {
        return route(RequestPredicates.GET("/book"), bookHandler::getBook)
                .andRoute(RequestPredicates.GET("/LIST"), bookHandler::bookList);
    }


}
