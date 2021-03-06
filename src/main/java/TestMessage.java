import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMessage implements Serializable {
    private String packageId;
    private String nameFunction;
    private List<Test> tests;
    private String script;

    private final String PACKAGE_ID = "packageId";
    private final String NAME_FUNCTION = "functionName";
    private final String TYPE_SCRIPT = "jsScript";
    private final String TESTS = "tests";

    @JsonCreator
    public TestMessage(
            @JsonProperty(PACKAGE_ID) String pId,
            @JsonProperty(TYPE_SCRIPT) String s,
            @JsonProperty(NAME_FUNCTION) String nf,
            @JsonProperty(TESTS) List<Test> t
    ) {
        this.packageId = pId;
        this.nameFunction = nf;
        this.tests = t;
        this.script = s;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getScript() {
        return this.script;
    }

    public String getNameFunction() {
        return this.nameFunction;
    }

    public List<Test> getTests() {
        return this.tests;
    }

}
