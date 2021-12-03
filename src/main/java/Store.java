import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import akka.actor.AbstractActor;

public class Store extends AbstractActor {
    private Map<String, ArrayList<Test>> store = new HashMap<>();

    private static final String FAIL = "FAIL";
    private static final String SUCCESS = "SUCCESS";

    @Override
    public Receive createReceive() {
        
    }

    
    
}
