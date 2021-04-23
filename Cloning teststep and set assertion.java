//Cloning teststep

import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction
import com.eviware.soapui.security.assertion.ValidHttpStatusCodesAssertion
def slaveTestStep = testRunner.testCase.testSuite.project.getTestSuiteByName("AddMFAtotheUser_API_TestSuite").getTestCaseByName("EnableMFAtotheuserusingGUID").getTestStepByName("GotoForDuplicate")
//testRunner.testCase.testSuite.project.getTestSuiteByName("Test Suite").cloneTestCase(slaveTestCase,"NewName")
def findtxt = context.expand('${Properties#Find}')
def findtxt2 = context.expand('${Properties#Find2}')
def replace = context.expand('${Properties#Replace}')

//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for (int j = 5; j < Sootcount; j++) { //scan suites
  def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
  log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
  for (int i = 0; i < count; i++) { //scan cases
    def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
    String cname = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
    if(cname.contains("orrelation")){
    for (int k = 0; k < stepcount; k++) { //scan steps
      String stpname = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getName()
      def testStep = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k)
      if (!stpname.contains("Create")) {
//        String Req = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getPropertyValue("script")
//def assertiontype = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getAssertionAt(k)
if(testStep.config.type == "restrequest")
{
   log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getAssertionAt(0).setCodes("400,412")	
}
      }
     
        
//        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStep, "GotoForDuplicate")
        //log.info "Cloned"
//        String Reqch = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getPropertyValue("script")
//        def steprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k)
//        def inx = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(steprq)
//         def Csteprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("CreateUser - Request 1")
//        def Cstep = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(Csteprq)
//        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).moveTestStep(inx,((Cstep-inx)-2))
//        log.info "Changed" ;
// 		ValidHttpStatusCodesAssertion.setCodes("200,201,409")       
      }
    }//k

    //if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode")){
    //	if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode").disabled==false){

  }
}