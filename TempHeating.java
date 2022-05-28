public class TempHeating {

	// method which calculates measured temperature based on the temperature
	public static int getTmeas(double temperature) {
		int tMeas = 0;

		// if/else block which assigns measured temperature(Tmeas) value
		// based on the range temperature falls in
		if (temperature < 5) {
			tMeas = 0;
		} else if (temperature >= 5 && temperature < 15) {
			tMeas = 10;
		} else if (temperature >= 15 && temperature < 25) {
			tMeas = 20;
		} else if (temperature >= 25 && temperature <= 35) {
			tMeas = 30;
		} else if (temperature > 35) {
			tMeas = 40;
		}

		return tMeas;// return Tmeas value for formula
	}

	// method which works as a lookup table to calculate saturation offset
	// temperature(Tsat)
	// using measured temperature(Tmeas) as paramater
	public static double tSatLookUp(int tMeas) {
		double tSat = 0;

		// switch block which assigns Tsat value based on the Tmeas value
		switch (tMeas) {
		case 0:
			tSat = 2.89;
			break;
		case 10:
			tSat = 2.78;
			break;
		case 20:
			tSat = 2.65;
			break;
		case 30:
			tSat = 2.54;
			break;
		case 40:
			tSat = 2.43;
			break;
		}

		return tSat; // return Tsat
	}

	// method to calulate Theat
	// uses time, temperature and measured temperature as parameters
	public static double getTheat(int time, double temperature, int tMeas) {

		double tSat = tSatLookUp(tMeas);// calculate Tsat by using TsatLookUp Method
		double tau = 650.0;// optimal tau value
		double euleur = Math.exp(((-time) / (tau)));// euleur number using time and time constant(tau) values

		double tHeat = (tSat - 0) * (1 - euleur);// tHeat value using Tc +(Tsat-Tc)(1-e^(-t/T)
		// where tc is irrelevant given scenario 1

		return tHeat;// Theat
	}

	// method to calculate Actual temperature(Tactual)
	// takes temperature and time as parameter
	public static double getTactual(double temperature, int time) {
		// calculate Tmeas and Theat
		int tMeas = getTmeas(temperature);
		double tHeat = getTheat(time, temperature, tMeas);

		double tActual = tMeas - tHeat;// Tactual(t) = Tmeas(t)-Theat
		return tActual;// return Tactual
	}

	public static void main(String[] args) {
		// temperature and time variables
		double temperature = 22.5;// degs celsius
		int time = 3500;// seconds

		double tActual = getTactual(temperature, time);// temperature and time passed as parameter to get actual
														// temperature
		System.out.println("Based on the time since start up: " + time + "(s) and measured temperature: " + temperature
				+ "(deg cels)The actual temperature is " + tActual + "(deg cels)");// print actual temperature

	}



}
