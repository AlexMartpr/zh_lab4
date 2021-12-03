import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaApp {
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("AkkaApp");
        ActorRef route = sys.actorOf(Props.create(Router.class, sys), "")
    }
}