/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.maven.sample;

import cse.maven.sample.exception.InvalidNICInputException;
import org.joda.time.*;

/**
 *
 * @author Eranda
 */
public class NIC_decryp {
    public NIC_obj createNIC(String nic) throws InvalidNICInputException{
        try {
			return new NIC_obj(nic);
		} catch(Exception ex) {
			throw new InvalidNICInputException();
		}
    }
    public String[] calculate(NIC_obj nic) throws InvalidNICInputException{
       if(!validate(nic)) {
			throw new InvalidNICInputException();
	}   
       
        String[] out=new String[4];
        out[3]="0";
        int year,days;
        boolean isMale;
        
        DateTime today = LocalTime.now().toDateTimeToday();
        year=1900+Integer.parseInt(nic.getNic().substring(0, 2));
        days=Integer.parseInt(nic.getNic().substring(2, 5));
        
        DateTime date= new DateTime(year,1,1,0,0,0);
        
        if(days<500){
            isMale=true;
            out[1]="Male";
        }
        else{
            isMale=false;
            out[1]="Female";
            days-=500;
        }
        
        date=date.plusDays(days-2);
        
        out[0]=date.toString().substring(0, 10);
        
        if(date.plusYears(18).compareTo(today)<0){
            out[2]="Yes";
        }
        else{
            out[2]="No";
        }
        
        return out;
	}
	
	public boolean validate(NIC_obj nic) {
            if(nic.getNic().length()<10)    return false;
                for(int i=0;i<9;i++){
                  if(nic.getNic().charAt(i)>58||nic.getNic().charAt(i)<48){
                      return false;
                  }  
                }
                if(nic.getNic().charAt(0)=='0') return false;
                if(nic.getNic().charAt(9)!='v'&&nic.getNic().charAt(9)!='V')    return false;
            return true;		
	}
}
