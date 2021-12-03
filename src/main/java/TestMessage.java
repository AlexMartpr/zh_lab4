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
            @JsonProperty(PACKAGE_ID) String pId,
            @JsonProperty(TYPE_SCRIPT) String ts,
            @JsonProperty(NAME_FUNCTION) String nf,
            @JsonProperty(TESTS) String t
    ) {
        this.packageId = pId;
        this.nameFunction = nf;
        this.tests = t;
        this.typeScript = ts;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getTypeScript() {
        return this.typeScript;
    }

    public String getNameFunction() {
        return this.nameFunction;
    }

    public List<Te> getTests() {
        return this.te;
    }

}
