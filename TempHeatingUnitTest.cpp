#include "pch.h"
#include "CppUnitTest.h"
#include<iostream>
#include <cmath>
#include <C:/Users/peter/source/repos/TempHeating/TempHeating.h>

using namespace std;


using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace TempHeatingUnitTest
{
	TEST_CLASS(TempHeatingUnitTest)
	{
	public:

		//Test 1 for TsatLookUp method
		TEST_METHOD(TsatTest1)
		{
			TempHeating tSatTest;
			double output = tSatTest.tSatLookUp(20);//pass 20 as measured temperature
			Assert::AreEqual(2.65, output);//compare expected result with output from TsatLookUp Method to 2 decimal places
		}

		//Test 2 for TsatLookUp method
		TEST_METHOD(TsatTest2)
	    {
			TempHeating tSatTest;
			double output = tSatTest.tSatLookUp(30);//test with 30
			Assert::AreEqual(2.54, output);
		}

		//Test 1 for Tmeas method
		TEST_METHOD(measuredTempTest1)
		{
			TempHeating tMeasTest;
			double output = tMeasTest.getTmeas(32.7); //test with 32.7 as temperature parameter
			Assert::AreEqual(30.00, output);
		}

		//Test 2 for Tmeas method
		TEST_METHOD(measuredTempTest2)
	    {
			TempHeating tMeasTest;
			double output = tMeasTest.getTmeas(12.5);//test with 12.5 as temperature parameter
			Assert::AreEqual(10.00, output);
		}
		
		TEST_METHOD(tHeatTest1)
		{
			TempHeating tHeatTest;
			double output = tHeatTest.getTheat(3500, 22.5, 20); //3500 seconds, 22.5 degs and 20 Tmeas as parameter
			Assert::AreEqual(2.637845499236963, output);
		}

		TEST_METHOD(tHeatTest2)
		{
			TempHeating tHeatTest;
			double output = tHeatTest.getTheat(5000, 18.7, 20); //5000 seconds, 18.7 degs and 20 Tmeas as parameter
			Assert::AreEqual(2.64879074166346, output);
		}
		//test 1 for actual temperature method
		TEST_METHOD(tActualTest1)
		{
			TempHeating tActualTest;
			double output = tActualTest.getTactual(22.5, 3500); //22.5 degs and 3500 seconds as parameter
			Assert::AreEqual(17.362154500763037, output);
		}

		//test 2 for actual temperature method
		TEST_METHOD(tActualTest2)
		{
			TempHeating tActualTest;
			double output = tActualTest.getTactual(18.7, 5000); //18.7 degs and 5000 seconds as parameter
			Assert::AreEqual(17.35120925833654, output);
		}
	};
}
