//Clone same test case in many suites
import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for(int j=0; j< Sootcount-2; j++){
def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
for(int i=0; i<count;i++){
def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
def name = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
if (name.contains("relation")){
def newName = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
newName = newName - "API_TestSuite"
newName = newName + name
def slaveTestCase = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i)
testRunner.testCase.testSuite.project.getTestSuiteByName("Correlation-IdWithoutHeader").cloneTestCase(slaveTestCase, newName)
}
}
}