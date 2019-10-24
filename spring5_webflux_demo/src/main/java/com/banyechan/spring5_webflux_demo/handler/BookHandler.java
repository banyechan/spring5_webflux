package com.banyechan.spring5_webflux_demo.handler;

import org.springframework.stereotype.Component;

@Component
public class BookHandler {

    public Flux<Book> bookList(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"《十万个为什么》","章三",10.00,new Date()));
        bookList.add(new Book(2,"《中国文化》","章三",60.80,new Date()));
        bookList.add(new Book(3,"《唐诗三百首》","章三",100.00,new Date()));

        Flux<Book> result = Flux.fromIterable(bookList);

        return result;
    }


    public Mono<Book> getBook(){
        Book tem = new Book();
        tem.setId(1);
        tem.setName("《葵花宝典》");
        tem.setAuthor("东方不败");
        tem.setPrice(66.66);
        tem.setCreateTime(new Date());
        Mono<Book> result = Mono.just(tem);

        return result;
    }



}
