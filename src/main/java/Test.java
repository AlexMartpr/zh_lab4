import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Test implements Serializable {
    private String testName;
    private String expectedResult;
    private String actualResult;
    private TestMessage parentTest;
    private Object[] params;

    private static final String TEST_NAME = "testName";
    private static final String EXPECTED_RESULT = "expectedResult";
    private static final String PARAMS = "params";
    
    @JsonCreator
    public Test(
            @JsonProperty(TEST_NAME) String tn,
            @JsonProperty(EXPECTED_RESULT) String er,
            @JsonProperty(PARAMS) Object[] p
    ) {
        this.testName = tn;
        this.expectedResult = er;
        this.params = p;
        this.actualResult = "";
    }

    public String getTestName() {
        return this.testName;
    }

    public String getExpectedResult() {
        return this.expectedResult;
    }

    public Object[] getParams() {
        return this.params;
    }

    public TestMessage getParentTest() {
        return this.parentTest;
    }

    public String getActualResult() {
        return this.actualResult;
    }

    public void setParentTest(TestMessage p) {
        this.parentTest = p;
    }

    public void setActualResult(String r) {
        this.actualResult = r;
    }

}
