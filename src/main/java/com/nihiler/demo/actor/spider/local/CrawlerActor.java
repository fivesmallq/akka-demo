package com.nihiler.demo.actor.spider.local;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class CrawlerActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    public CrawlerActor() {
        receive(ReceiveBuilder.
                        match(Message.class, s -> {
                            log.info("Received String message: {}", s);
                        }).
                        matchAny(o -> log.info("received unknown message")).build()
        );
    }
}
