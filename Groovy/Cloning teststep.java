//Cloning teststep

import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction

def slaveTestStep = testRunner.testCase.testSuite.project.getTestSuiteByName("Smoke_Suite").getTestCaseByName("CreateUserWithRequiredAttributes").getTestStepByName("RunOauthTokenGenerator_SignOn")
//testRunner.testCase.testSuite.project.getTestSuiteByName("Test Suite").cloneTestCase(slaveTestCase,"NewName")

//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for(int j=0; j< Sootcount; j++){
def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
for(int i=0; i<count;i++){
def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStep, "RunOauthTokenGeneratorSignOn")
log.info "Cloned"
}
}

//Cloning teststep

import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction

def slaveTestStep = testRunner.testCase.testSuite.project.getTestSuiteByName("GetUserIdentifiers_API_TestSuite").getTestCaseByName("GetApplicationSpecificUserIdentifiersUsingGuid").getTestStepByName("GenerateUserID")
//testRunner.testCase.testSuite.project.getTestSuiteByName("Test Suite").cloneTestCase(slaveTestCase,"NewName")

//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for(int j=15; j< 16; j++){
def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
for(int i=0; i<count;i++){
def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStep, "GeneratedUserID")
log.info "Cloned"
}
}

//Cloning teststep

import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction

def slaveTestStep = testRunner.testCase.testSuite.project.getTestSuiteByName("GetUserIdentifiers_API_TestSuite").getTestCaseByName("GetApplicationSpecificUserIdentifiersUsingGuid").getTestStepByName("GenerateUserID")
//testRunner.testCase.testSuite.project.getTestSuiteByName("Test Suite").cloneTestCase(slaveTestCase,"NewName")
def findtxt = context.expand( '${Properties#Find}' )
def replace = context.expand( '${Properties#Replace}' )

//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for(int j=0; j< Sootcount; j++){//scan suites
def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
for(int i=0; i<count;i++){//scan cases
def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("base64encode")){
String Req = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("base64encode").getPropertyValue("script")
Req = Req.replace(findtxt,replace)
log.info Req
testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("base64encode").setPropertyValue("Request",Req)
//testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStep, "GeneratedUserID")
//log.info "Cloned"
String Reqch = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("base64encode").getPropertyValue("script")
def steprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("base64encode")
//log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).moveTestStep(arg0, arg1)
assert Req == Reqch
log.info "Changed"+ Reqch
}
else{
}
}
}