package com.banyechan.spring5_webflux.entity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class TestDemo {


    public static void main(String[] args) {

//        Mono.empty().subscribe(System.out::println);
//        Mono.just("welcome to shanghai").subscribe(System.out::println);
//        Mono.create(monoSink -> monoSink.success(1000))
//                .subscribe(System.out::println);
//
//        Mono.delay(Duration.ofSeconds(3)).doOnNext(System.out::println).block();


        Flux.just("aa", "bb", "cc")
                .subscribe(a -> System.out.println(a)
                        , e -> System.err.println(e)
                        , () -> System.out.println("completed"));

        Flux.just("aa", "bb", "cc")
                .subscribe(System.out::println
                        , System.err::println
                        , () -> System.out.println("completed"));

        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);


        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

    }


}
