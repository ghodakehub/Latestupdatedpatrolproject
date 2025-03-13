package Patrol.Utility;

public class TestResults {
	
	 private String testCaseName;
	    private String status;
	    private String errorMessage; // Ensure this field exists

	    // Constructor
	    public TestResults(String testCaseName, String status, String errorMessage) {
	        this.testCaseName = testCaseName;
	        this.status = status;
	        this.errorMessage = errorMessage;
	    }

	    // Getters
	    public String getTestCaseName() {
	        return testCaseName;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public String getErrorMessage() {
	        return errorMessage; // Ensure this method exists
	    }
	}

