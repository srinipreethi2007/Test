//Segregate test cases
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for(int j=0; j< Sootcount; j++){
def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
def newName = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
for(int i=0; i<count;i++){
def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
String cname =  testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
if(cname.contains("erver")){
	def slaveTestCase = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i)
newName = newName - "API_TestSuite"
newName = newName + cname
	testRunner.testCase.testSuite.project.getTestSuiteByName("OutageTestSuite").cloneTestCase(slaveTestCase, newName)
}
}
}