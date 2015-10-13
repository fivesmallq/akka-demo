package com.nihiler.demo.actor.spider.local;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class JobMasterActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    public JobMasterActor() {
        receive(ReceiveBuilder.match(Message.class, message -> tellProcess(message)).build());
    }

    private ActorRef crawlerActor;

    private void tellProcess(Message message) {
        if (null == crawlerActor) {
            this.crawlerActor = getContext().actorOf(Props.create(CrawlerActor.class), "cralwer");
        }
        try {
           log.info("job master send message:" + message);
            crawlerActor.tell(message, self());
        } catch (Exception e) {
            log.error("NodeActor-tellProcess-error:treeName=", e);
            try {
                this.getContext().stop(self());
                this.getContext().stop(sender());
            } catch (Exception ex) {
                log.error("NodeActor-stopContext-error:", ex);
            }
        }
    }
}
