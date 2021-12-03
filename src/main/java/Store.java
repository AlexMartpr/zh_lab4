import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class Store extends AbstractActor {
    private Map<String, ArrayList<Test>> store = new HashMap<>();

    private static final String FAIL = "FAIL";
    private static final String SUCCESS = "SUCCESS";

    private void putTest(Test test) {
        String pId = test.getParentTest().getPackageId();
        if (this.store.containsKey(pId)) {
            this.store.get(pId).add(test);
        } else {
            ArrayList<Test> arrayTests = new ArrayList<>();
            arrayTests.add(test);
            this.store.put(pId, arrayTests);
        }
    }

    private Map<String, String> prepareRes(String pId) {
        Map<String, String> mapTestsResult = new HashMap<>();
        if (this.store.containsKey(pId)) {
            for (Test test : this.store.get(pId)) {
                if (test.getActualResult().equals(test.getExpectedResult())) {
                    mapTestsResult.put(test.getTestName(), SUCCESS);
                } else {
                    mapTestsResult.put(test.getTestName(), FAIL);
                }
            }
        }
        return mapTestsResult;
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder
                .create()
                .match(Test.class, t -> putTest(t))
                .match(String.class, id -> sender().tell(prepareRes(id), self()))
                .build();
    }

    
    
}
