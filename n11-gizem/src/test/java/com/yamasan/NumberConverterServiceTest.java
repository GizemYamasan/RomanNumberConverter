package com.yamasan;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yamasan.service.NumberConverterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberConverterServiceTest {
	
	private HashMap<Integer,String> sampleNumbers;
	@Autowired
	private NumberConverterService service;
	
	@Before
	public void setup(){
		/*Sample Roman numbers from Wiki
		    XIV = 14
			XXIV = 24
			XXXII = 32
			XLVIII = 48
			LX = 60
			LXVIII = 68
			XCVI = 96
			CLIX = 159
			CCXVII = 217
			DCCXCIII = 793
			MMMMCDXXXII = 4432 
		 */
		sampleNumbers = new HashMap<>();
		
		sampleNumbers.put(14, "XIV");
		sampleNumbers.put(24, "XXIV");
		sampleNumbers.put(48, "XLVIII");
		sampleNumbers.put(60, "LX");
		sampleNumbers.put(68, "LXVIII");
		sampleNumbers.put(96, "XCVI");
		sampleNumbers.put(159, "CLIX");
		sampleNumbers.put(217, "CCXVII");
		sampleNumbers.put(793, "DCCXCIII");
		sampleNumbers.put(4432, "MMMMCDXXXII");
		
	}
	
	@Test
	public void contextLoads() {

		sampleNumbers.forEach((wholeNumber,romanNumber) -> {
            Assert.assertEquals("Failed converting to roman number. WholeNumber: " + wholeNumber,romanNumber, service.convertToRoman(wholeNumber).getRomanNumber());
		});
		
	}

}
