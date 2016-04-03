package projectEuler;

import java.util.GregorianCalendar;

public class ProjectEuler019 {
	
	public int solve(){
		
		int sundaysFirstOfMonth = 0;
		
		GregorianCalendar gc = new GregorianCalendar(1901, GregorianCalendar.JANUARY, 01);
		
		while(gc.get(GregorianCalendar.YEAR) < 2001){
			for(int i = 0; i < 12; i++){
				if(gc.get(GregorianCalendar.DAY_OF_WEEK) == 1){
					sundaysFirstOfMonth++;
				}
				gc.add(GregorianCalendar.MONTH, 1);
			}
		}
		return sundaysFirstOfMonth;
		
	}
}
