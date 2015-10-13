package com.nihiler.demo.actor.spider.remote;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

import java.util.Random;
public class App2 {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("JobMasterSystem",
                ConfigFactory.load("remotejobmaster"));
        final String path = "akka.tcp://CrawlerSystem@127.0.0.1:3000/user/crawler";
        final ActorRef actor = system.actorOf(
                Props.create(JobMasterActor.class, path), "jobmaster");

        System.out.println("Started jobmaster");
        final Random r = new Random();
        actor.tell(new Message("data"), null);
        system.awaitTermination();
    }
}
