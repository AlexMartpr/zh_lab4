import akka.actor.ActorRef;
import akka.http.javadsl.server.AllDirectives;

public class RouterDefine extends AllDirectives {
    private final ActorRef router;
    
    public RouterDefine(ActorRef r) {
        this.router = r;
    }

    public Route createRoute
}
