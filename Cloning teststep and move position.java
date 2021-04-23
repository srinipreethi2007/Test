//Cloning teststep

import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction

def slaveTestStep = testRunner.testCase.testSuite.project.getTestSuiteByName("UpdateTNCVersion_API_TestSuite").getTestCaseByName("UpdateTandCUsingGuid-UserWithoutTandC").getTestStepByName("CheckConflict")
//testRunner.testCase.testSuite.project.getTestSuiteByName("Test Suite").cloneTestCase(slaveTestCase,"NewName")
def findtxt = context.expand('${Properties#Find}')
def findtxt2 = context.expand('${Properties#Find2}')
def replace = context.expand('${Properties#Replace}')

//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for (int j = 11; j < 12; j++) { //scan suites
  def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
  log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
  for (int i = 0; i < count; i++) { //scan cases
    def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
    log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
    for (int k = 0; k < stepcount; k++) { //scan steps
      String stpname = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getName()
      if (stpname.contains("CreateUser")) {
//        String Req = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getPropertyValue("script")
//        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).setPropertyValue("script", Req)
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStep, "GotoForDuplicate")
        //log.info "Cloned"
//        String Reqch = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getPropertyValue("script")
        def steprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("GotoForDuplicate")
        def inx = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(steprq)
         def Csteprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("CreateUser - Request 1")
        def Cstep = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(Csteprq)
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).moveTestStep(inx,-((inx-Cstep)-1))
        log.info "Changed" ;
      }
    }//k

    //if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode")){
    //	if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode").disabled==false){

  }
}