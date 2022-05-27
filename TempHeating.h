#include<iostream>
#include <cmath>



using namespace std;

class TempHeating{
// function which calculates measured temperature to use in formula based on the temperature
public: 
		int getTmeas(double temperature) {
			int tMeas = 0;

			// if/else block which assigns measured temperature(Tmeas) value
			// based on the range temperature falls in
			if (temperature < 5) {
				tMeas = 0;
			}
			else if (temperature >= 5 && temperature < 15) {
				tMeas = 10;
			}
			else if (temperature >= 15 && temperature < 25) {
				tMeas = 20;
			}
			else if (temperature >= 25 && temperature <= 35) {
				tMeas = 30;
			}
			else if (temperature > 35) {
				tMeas = 40;
			}

			return tMeas;// return Tmeas value
		}

		// function which works as a lookup table to calculate saturation offset
		// temperature(Tsat)
		// using measured temperature(Tmeas) as paramater
		double tSatLookUp(int tMeas) {
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
			default:
				cout << "invalid value for Tmeas please try again" << endl;
				break;
			}

			return tSat; // return Tsat
		}

		// function to calulate Theat
		// uses time, temperature and measured temperature as parameters
   double getTheat(int time, double temperature, int tMeas) {

	double tSat = tSatLookUp(tMeas);// calculate Tsat by using TsatLookUp Method
	double tau = 650.0;// optimal time constant(tau) value
	double euleur = exp(((-time) / (tau)));// euleur number using time and time constant(tau) values


	double tHeat = (tSat - 0) * (1 - euleur);// tHeat value using Tc +(Tsat-Tc)(1-e^(-t/T)
	// where tc is irrelevant given scenario 1

	return tHeat;// Theat
}

	  // function to calculate Actual temperature(Tactual)
	  // takes temperature and time as parameter
	  double getTactual(double temperature, int time) {
		  // calculate Tmeas and Theat
		  int tMeas = getTmeas(temperature);
		  double tHeat = getTheat(time, temperature, tMeas);

		  double tActual = tMeas - tHeat;// Tactual = Tmeas-Theat
		  return tActual;// return Tactual
	  }
	
};


