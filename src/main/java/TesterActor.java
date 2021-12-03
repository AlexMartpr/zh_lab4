import java.io.Serializable;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.http.scaladsl.model.headers.CacheDirectives.private;

public class TesterActor extends AbstractActor{
    private ActorRef storeActor;
    
    private static final String JS_VER = "nashorn";



    @Override
    public Receive createReceive() {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
