import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class AkkaApp {
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("AkkaApplication");
        ActorRef route = sys.actorOf(Props.create(Router.class, sys));

        final Http http = Http.get(sys);
        final ActorMaterializer actorMat = ActorMaterializer.create(sys);
        final AkkaApplication instance = new AkkaApplication();
        final Flow<HttpRequest, HttpResponse, NotUsed> flow = instance.createRoute()
    }
}