import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TempHeatingUnitTest {

	//Test 1 for TsatLookUp method
		@Test
		public void TsatTest1() {
			  TempHeating tSatTest = new TempHeating();
		      
		      double output = tSatTest.tSatLookUp(20);//pass 20 as measured temperature
		      assertEquals(2.65,output,0.00);//compare expected result with output from TsatLookUp Method to 2 decimal places
		}
		
		//Test 2 for TsatLookUp method
		@Test
		public void TsatTest2() {
			TempHeating tSatTest = new TempHeating();
		      
		      double output = tSatTest.tSatLookUp(30);//test with 30
		      assertEquals(2.54,output,0.00);
		}
		
		//Test 1 for Tmeas method
		@Test
		public void measuredTempTest1() {
			TempHeating tMeasTest = new TempHeating();
			 double output = tMeasTest.getTmeas(32.7); //test with 32.7 as temperature parameter
			 assertEquals(30.00,output,0.00);
		}
		
		//Test 2 for Tmeas method
		@Test
		public void measuredTempTest2() {
			TempHeating tMeasTest = new TempHeating();
			 double output = tMeasTest.getTmeas(12.5);//test with 12.5 as temperature parameter
			 assertEquals(10.00,output,0.00);
		}
		
		//test 1 for Theat method
		@Test
		public void tHeatTest1() {
			TempHeating tHeatTest = new TempHeating();
			 double output = tHeatTest.getTheat(3500,22.5,20); //3500 seconds, 22.5 degs and 20 Tmeas as parameter
			 assertEquals(2.637845499236963,output,0.00);
		}
		
		//test 2 for Theat method
		@Test
		public void tHeatTest2() {
			TempHeating tHeatTest = new TempHeating();
			 double output = tHeatTest.getTheat(5000,18.7,20);//5000 seconds, 18.7 degs and 20 Tmeas as parameter
			 assertEquals(2.64879074166346,output,0.00);
		}
		
		//test 1 for actual temperature method
		@Test
		public void tActualTest1() {
			TempHeating tActualTest = new TempHeating();
			 double output = tActualTest.getTactual(22.5,3500); //22.5 degs and 3500 seconds as parameter
			 assertEquals(17.362154500763037,output,0.00);
		}
		
		//test 2 for actual temperature method
		@Test
		public void tActualTest2() {
			TempHeating tActualTest = new TempHeating();
			 double output = tActualTest.getTactual(18.7,5000); //18.7 degs and 5000 seconds as parameter
			 assertEquals(17.35120925833654,output,0.00);
		}
		

}
