package com.nihiler.demo.actor.spider.remote;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class JobMasterActor extends UntypedActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);
    private String path;

    public JobMasterActor(String path) {
        this.path = path;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        tellProcess((Message) message);
    }



    private void tellProcess(Message message) {
        try {
            log.info("job master send message:" + message);
            getContext().actorSelection(path).tell(new Message("crawler http://www.baidu.com"), self());
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
