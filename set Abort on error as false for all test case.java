//set Abort on error as false for all test case
testRunner.testCase.testSuite.project.getTestSuiteList().each
{
   it.getTestCaseList().each
   {
      //Switch the parameter value to 'true' if you need to enable 'Abort on Error' option
      it.setFailOnError(false)
   }
}