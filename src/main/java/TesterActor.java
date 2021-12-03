import java.io.Serializable;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;
import akka.http.scaladsl.model.headers.CacheDirectives.private;

public class TesterActor extends AbstractActor{
    private ActorRef storeActor;
    
    private static final String JS_VER = "nashorn";

    public TesterActor(ActorRef ac) {
        this.storeActor = ac;
    }

    private String runTest(Test test) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(JS_VER);
        TestMessage parent = test.getParentTest();
        engine.eval(parent.getTypeScript());
        Invocable invoc = (Invocable) engine;
        return invoc.invokeFunction(parent.getNameFunction(), test.getParams()).toString();
    }

    private Test checkResult(Test test) {
        try {
            String getRes = runTest(test);
            test.setActualResult(getRes);
        } catch (Exception excep) {
            test.setActualResult(excep.toString());
        }
        return test;
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder
                .create()
                .match(Test.class, msg -> storeActor.tell(checkResult(msg), ActorRef.noSender()))
                .build();
    }

    
    
}