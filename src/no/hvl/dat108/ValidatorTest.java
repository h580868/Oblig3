
package no.hvl.dat108;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author niklasjohansson
 *
 */
public class ValidatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void isValidNameTest() {
		String test1 = "12345678";
		String test2 = "loa";
		String test3 = "eeeeeeeeeeeeooooooooooooooooossssssssssssssssss";
		
		assertEquals(false, Validator.isValidName(test1));
		assertEquals(true, Validator.isValidName(test2));
		assertEquals(false, Validator.isValidName(test3));
	}
	
	@Test
	public void isValidMobileTest() {
		String test1 = "12345678";
		String test2 = "loa";
		String test3 = "12345_876";
		
		assertEquals(true, Validator.isValidMobile(test1));
		assertEquals(false, Validator.isValidMobile(test2));
		assertEquals(false, Validator.isValidMobile(test3));
	}

}
