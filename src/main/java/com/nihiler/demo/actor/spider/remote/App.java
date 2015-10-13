package com.nihiler.demo.actor.spider.remote;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * 先运行 App 然后运行 app2
 * @author <a href="mailto:fivesmallq@gmail.com">wuzq</a>
 * @version Revision: 1.0
 * @date 15/10/12 下午6:33
 */
public class App {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("CrawlerSystem",
                ConfigFactory.load(("remotecrawler")));
        system.actorOf(Props.create(CrawlerActor.class), "crawler");
        System.out.println("Started crawler");
        system.awaitTermination();
    }
}
