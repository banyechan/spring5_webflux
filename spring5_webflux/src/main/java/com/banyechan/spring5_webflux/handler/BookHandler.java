package com.banyechan.spring5_webflux.handler;

import com.banyechan.spring5_webflux.entity.Book;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BookHandler {

    public Mono<ServerResponse> bookList(ServerRequest serverRequest) {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1, "《十万个为什么》", "章三", 10.00, new Date()));
        bookList.add(new Book(2, "《中国文化》", "章三", 60.80, new Date()));
        bookList.add(new Book(3, "《唐诗三百首》", "章三", 100.00, new Date()));

        //Flux<Book> result = Flux.fromIterable(bookList);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.fromIterable(bookList), Object.class);
    }


    public Mono<ServerResponse> getBook(ServerRequest serverRequest) {
        Book tem = new Book();
        tem.setId(1);
        tem.setName("《葵花宝典》");
        tem.setAuthor("东方不败");
        tem.setPrice(66.66);
        tem.setCreateTime(new Date());
        // Mono<Book> result = Mono.just(tem);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(tem), Object.class);
    }

    public Mono<ServerResponse> sendMessage(ServerRequest serverRequest) {
        int i = 0;
        String message = "这是第" + i + "次发送信息";
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(5)).map(s -> message), Object.class);
    }


}
