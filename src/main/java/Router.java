import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;

public class Router extends AbstractActor {
    private final ActorRef storeActor;
    private final ActorRef pool;

    private final int NUMBER_WORKERS = 5;

    public Router() {
        storeActor = getContext().actorOf(Props.create(Store.class));
        pool = getContext().actorOf(new RoundRobinPool(NUMBER_WORKERS).props(Props.create(TestGet.class, storeActor)));
    }

    private void runTests(TestMessage test) {
        for (Test t : test.getTests()) {
            t.setParentTest(test);
            pool.tell(t, ActorRef.noSender());
        }
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder
                .create()
                .match(TestMessage.class, msg -> runTests(msg))
                .match(String.class, msg -> storeActor.forward(msg, getContext()))
                .build();
    }
}
