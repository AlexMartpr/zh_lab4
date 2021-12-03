import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMessage implements Serializable {
    private String packageId;
    private String nameFunction;
    private String tests;
    private String typeScript;

    private final String PACKAGE_ID = "packageId";
    private final String NAME_FUNCTION = "functionName";
    private final String TYPE_SCRIPT = "jsScript";
    private final String TESTS = "tests";


    public TestMessage(
            @JsonProperty(PACKAGE_ID) String pId
    )

}
