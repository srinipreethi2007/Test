//Cloning teststep

import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction

def slaveTestStepSecretqns = testRunner.testCase.testSuite.project.getTestSuiteByName("Utilities").getTestCaseByName("RunSteps").getTestStepByName("CreateSecretQnsInt")
def slaveTestClearAllInterrupts = testRunner.testCase.testSuite.project.getTestSuiteByName("Utilities").getTestCaseByName("RunSteps").getTestStepByName("ClearAllInterrupts")
def slaveTestStepDeleteMFA = testRunner.testCase.testSuite.project.getTestSuiteByName("Utilities").getTestCaseByName("RunSteps").getTestStepByName("DisableMFA")
def slaveTestStepEnableMFA = testRunner.testCase.testSuite.project.getTestSuiteByName("Utilities").getTestCaseByName("RunSteps").getTestStepByName("EnableMFA")
def slaveTestStepCreateTncInterrupt = testRunner.testCase.testSuite.project.getTestSuiteByName("Utilities").getTestCaseByName("RunSteps").getTestStepByName("CreateTnCInterrupt")
//testRunner.testCase.testSuite.project.getTestSuiteByName("Test Suite").cloneTestCase(slaveTestCase,"NewName")
def findtxt = context.expand('${Properties#Find}')
def findtxt2 = context.expand('${Properties#Find2}')
def replace = context.expand('${Properties#Replace}')

//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"
def Sootcount = testRunner.testCase.testSuite.project.getTestSuiteCount()
log.info Sootcount
for (int j = 3; j < 4; j++) { //scan suites
  def count = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseCount()
  log.info testRunner.testCase.testSuite.project.getTestSuiteAt(j).getName()
  for (int i = 0; i < count; i++) { //scan cases
    def stepcount = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepCount()
    String tcname = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getName()
	if(tcname.contains("ecret")){
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStepSecretqns, "CreateInterrupt")
		testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestClearAllInterrupts, "ClearAllInterrupts")
        log.info "Cloned"
        def steprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("CreateInterrupt")
        def inx = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(steprq)
        def Csteprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("RunOauthTokenGenerator")
        def Cstep = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(Csteprq)
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).moveTestStep(inx,-((inx-Cstep)))
        log.info "Changed" ;
      // }
    }
	else if(tcname.contains("Mfa")){
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStepEnableMFA, "EnableMFA")
		testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStepDeleteMFA, "DisableMFA")
        log.info "Cloned"
        def steprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("EnableMFA")
        def inx = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(steprq)
        def Csteprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode")
        def Cstep = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(Csteprq)
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).moveTestStep(inx,-((inx-Cstep)))
        log.info "Changed" ;
      // }
    }
	else if(tcname.contains("nterrupt")){
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStepCreateTncInterrupt, "CreateInterrupt")
		testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestClearAllInterrupts, "ClearAllInterrupts")
        log.info "Cloned"
        def steprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("CreateInterrupt")
        def inx = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(steprq)
        def Csteprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode")
        def Cstep = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(Csteprq)
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).moveTestStep(inx,-((inx-Cstep)))
        log.info "Changed" ;
      // }
    }
	else if(tcname.contains("ropoff")){
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestStepCreateTncInterrupt, "CreateInterrupt")
		testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).cloneStep(slaveTestClearAllInterrupts, "ClearAllInterrupts")
        log.info "Cloned"
        def steprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("CreateInterrupt")
        def inx = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(steprq)
        def Csteprq = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode")
        def Cstep = testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getIndexOfTestStep(Csteprq)
        testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).moveTestStep(inx,-((inx-Cstep)))
        log.info "Changed" ;
      // }
    }
	else if(tcname.contains("ignon")){
        log.info "no Change" ;
      // }
    }
    else {
        log.info "no Change" ;
      // }
    }//k

    //if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode")){
    //	if(testRunner.testCase.testSuite.project.getTestSuiteAt(j).getTestCaseAt(i).getTestStepByName("Base64Encode").disabled==false){

  }
}