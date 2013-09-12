/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.maven.sample;

/**
 *
 * @author Eranda
 */

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cse.maven.sample.exception.InvalidNICInputException;
import static org.testng.Assert.assertEquals;

@Test
public class NICAnalyzerTest {

	NIC_decryp nic_decryp;
		
	@BeforeClass
	public void setUp() {
		nic_decryp = new NIC_decryp();
	}
	
	@Test
	public void NIC_Test1() throws InvalidNICInputException {
		NIC_obj nic_obj = new NIC_obj("902160906v");
                String[] expect=new String[4];
                expect[3]="0";
                expect[2]="Yes";
                expect[1]="Male";
                expect[0]="1990-08-03";
	    assertEquals(nic_decryp.calculate(nic_obj), expect);
	}
	
	
	@Test(expectedExceptions = InvalidNICInputException.class)
	public void NIC_Test2() throws InvalidNICInputException {
		NIC_obj nic_obj = new NIC_obj("902160906");
                String[] expect=new String[4];
                expect[3]="0";
                expect[2]="Yes";
                expect[1]="Male";
                expect[0]="1990-08-03";
	    assertEquals(nic_decryp.calculate(nic_obj), expect);		
	}
	
}


    

