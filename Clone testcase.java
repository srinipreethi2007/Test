//Clone testcase
import com.eviware.soapui.impl.wsdl.actions.testcase.CloneTestCaseAction
def newName = context.expand( '${DataSource#ModName}' )
def slaveTestCase = testRunner.testCase.testSuite.project.getTestSuiteByName("kporg-user_API_TestSuite").getTestCaseByName("UpdateKpdisabledflag")
//def slaveTestCase = testRunner.testCase.testSuite.getTestCaseByName(arg0)
//log.info modName.trim()
//log.info "Delete application specific user identifiers - without x-appIdentifier"
//assert modName.trim() == "Delete application specific user identifiers - without x-appIdentifier"
//testRunner.testCase.testSuite.project.getTestSuiteByName('DeleteUserIdentifiers_API_TestSuite').getTestCaseByName(modName.trim()).setName(newname)
testRunner.testCase.testSuite.project.getTestSuiteByName("kporg-user_API_TestSuite").cloneTestCase(slaveTestCase,newName)
//testRunner.testCase.cloneStep(slaveTestStep, "newstep")
log.info "Success"