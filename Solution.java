
public class Solution {
	 public static int measuredTemp(double temperature){
	        int value=0;
	        
	        if(temperature<5){
	            value = 0;
	        }else if(temperature>=5 && temperature<15){
	            value = 10;
	        }else if(temperature >= 15 && temperature < 25){
	            value = 20;
	        }else if(temperature >=25 && temperature <= 35){
	            value = 30;
	        }else if(temperature >35){
	            value = 40;
	        }
	        
	        return value;
	    }
	    
	    public static double tSatLookUp(int tMeas){
	        double value = 0;
	         switch (tMeas){
	                    case 0:
	                        value = 2.89;
	                        break;
	                    case 10:
	                        value = 2.78;
	                        break;
	                    case 20:
	                        value = 2.65;
	                        break;
	                    case 30:
	                        value = 2.54;
	                        break;
	                    case 40:
	                        value = 2.43;
	                        break;
	                }
	         
	         return value;
	    }
	    
	    public static double tHeat(int time, double temperature, int tMeas){
	  
	       double tSat = tSatLookUp(tMeas);
	       double tau = 650.0;
	       double euleur = Math.exp(((-time)/(tau)));
	       
	       double value = (tSat-0)*(1-euleur);
	       
	       return value;  
	    }
	    
	    public static double tActual(double temperature,int time){
	       
	        int tMeas =  measuredTemp(temperature);
	        double tHeat = tHeat(time,temperature,tMeas);
	        
	        double value = tMeas - tHeat;
	        return value;  
	    }
	    
	    public static void main(String[] args){
	        
	        double temperature = 22.5;
	        int time = 3500;
	        
	        double aTemp = tActual(temperature,time);
	        System.out.println("The actual temperature is "+ aTemp);
	         
	        
	    }

}
