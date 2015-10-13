package com.nihiler.demo.actor.spider.local;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author <a href="mailto:wuzhiqiang@novacloud.com">wuzq</a>
 * @version Revision: 1.0
 * @date 15/10/12 下午6:33
 */
public class App {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("spider-local");
        ActorRef nodeActor = system.actorOf(Props.create(JobMasterActor.class), "job-master");
        nodeActor.tell(new Message("http://www.baidu.com"), ActorRef.noSender());
        system.awaitTermination();
    }
}
