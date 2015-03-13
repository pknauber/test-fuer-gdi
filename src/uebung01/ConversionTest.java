package uebung01;

import static org.junit.Assert.*;
import gdi.MakeItSimple.GDIException;

import org.junit.Test;

public class ConversionTest {

	@Test
	public void gültige() throws Exception {
		assertEquals(0, Conversion.parseInteger("0"));
		assertEquals(1, Conversion.parseInteger("1"));
		assertEquals(1234567890, Conversion.parseInteger("1234567890"));
		assertEquals(Integer.MAX_VALUE - 1, Conversion.parseInteger(Integer.MAX_VALUE - 1 + ""));
		assertEquals(Integer.MAX_VALUE, Conversion.parseInteger(Integer.MAX_VALUE + ""));
	}

	@Test(expected=GDIException.class)
	public void zuGroßeZahlVerursachtÜberlauf() throws Exception {
		System.err.println("Exception 'Zahl zu groß' erwartet; geliefert: " + Conversion.parseInteger((long) Integer.MAX_VALUE + 1 + ""));
	}

	@Test(expected=GDIException.class)
	public void negativ() throws Exception {
		Conversion.parseInteger("-1");
	}

	@Test(expected=GDIException.class)
	public void minValueIstNegativ() throws Exception {
		Conversion.parseInteger(Integer.MIN_VALUE + "");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen1() throws Exception {
		Conversion.parseInteger("x");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen2() throws Exception {
		Conversion.parseInteger("-12");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen3() throws Exception {
		Conversion.parseInteger("1-2");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen4() throws Exception {
		Conversion.parseInteger("12-");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen5() throws Exception {
		Conversion.parseInteger("+12");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen6() throws Exception {
		Conversion.parseInteger("1+2");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen7() throws Exception {
		Conversion.parseInteger("12+");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen8() throws Exception {
		Conversion.parseInteger(" 12");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen9() throws Exception {
		Conversion.parseInteger("1 2");
	}

	@Test(expected=GDIException.class)
	public void ungültigeZeichen10() throws Exception {
		Conversion.parseInteger("12 ");
	}

}
