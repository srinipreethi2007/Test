//Remove Copy of
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for(int j=0; j< Sootcount; j++){
def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
for(int i=0; i<count;i++){
def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
for (int k=0;k<stepcount; k++){
def name = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getName()
log.info name
name = name - "Copy of "
testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).setName(name)
log.info "changed to "+ name
}
}
}