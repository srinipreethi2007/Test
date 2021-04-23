//add header

import com.eviware.soapui.support.types.StringToStringMap
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep
//Cloning teststep

import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction

def slaveTestStep = testRunner.testCase.testSuite.project.getTestSuiteByName("UpdateTNCVersion_API_TestSuite").getTestCaseByName("UpdateTandCUsingGuid-UserWithoutTandC").getTestStepByName("CheckConflict")
//testRunner.testCase.testSuite.project.getTestSuiteByName("Test Suite").cloneTestCase(slaveTestCase,"NewName")
def findtxt = context.expand('${Properties#Find}')
def findtxt2 = context.expand('${Properties#Find2}')
def replace = context.expand('${Properties#Replace}')
def headers = new StringToStringMap()
//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for (int j = 1; j < Sootcount; j++) { //scan suites
  def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
  log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
  for (int i = 0; i < count; i++) { //scan cases
    def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
    log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
    for (int k = 0; k < stepcount; k++) { //scan steps
      String stpname = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k).getName()
      def step = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepAt(k)
      if (stpname.contains("Sign") 
      	&& step instanceof RestTestRequestStep) {
      	
 		
          //Append the new header to the existing list
          headers.put("x-requestdropoff", "true");
          //Set the updated header list 
          headers = step.testRequest.getRequestHeaders()
          def list = []
          list = headers
          list.add("x-requestdropoff","true")
//          headers[] = list
          log.info list
          headers = list
          log.info headers
          step.testRequest.setRequestHeaders(headers)
        log.info "Changed "+ stpname ;
      }
    }//k

    //if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode")){
    //	if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode").disabled==false){

  }
}