import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class AkkaApp {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("AkkaApp");
        ActorRef route = sys.actorOf(Props.create(Router.class, sys));

        final Http http = Http.get(sys);
        final ActorMaterializer actorMat = ActorMaterializer.create(sys);
        final Flow<HttpRequest, HttpResponse, NotUsed> flow = new RouterDefine(route).createRoute().flow(sys, actorMat);
        http.bindAndHandle(flow, ConnectHttp.toHost(HOST, PORT), actorMat);
    }
}