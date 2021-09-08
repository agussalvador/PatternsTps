package org.formacion.prototype;

import static org.junit.Assert.*;

import org.formacion.prototype.Hamburguesa.Carne;
import org.formacion.prototype.Hamburguesa.Extra;
import org.formacion.prototype.Hamburguesa.Pan;
import org.formacion.prototype.Hamburguesa.Size;
import org.junit.Test;

public class TestHamburguesaFactory {

	@Test
	public void test_carta() {
		Hamburguesa royal = HamburguesaFactory.royal();

		assertEquals(Carne.VACUNO, royal.getCarne());
		assertEquals(Size.GRANDE, royal.getSize());
		assertEquals(Pan.NORMAL, royal.getPan());
		assertTrue(royal.getExtras().contains(Extra.CEBOLLA));
		assertTrue(royal.getExtras().contains(Extra.QUESO));
		assertFalse(royal.getExtras().contains(Extra.PEPINO));
		assertFalse(royal.getExtras().contains(Extra.MAYONESA));
	}

	@Test
	public void test_royal_si_cebolla() {
		// queremos simplificar pedir esta hamburguesa !!
		
		/*Hamburguesa royaSinCebolla = new HamburguesaFactory()
				                              .setCarne(Carne.VACUNO)
				                              .setSize(Size.GRANDE)
				                              .setPan(Pan.NORMAL)
				                              .addExtra(Extra.QUESO)
				                              .crea();*/
		Hamburguesa royalSinCebolla = new HamburguesaFactory().copy(HamburguesaFactory.royal()).removeExtra(Extra.CEBOLLA).crea();

		assertEquals(Carne.VACUNO, royalSinCebolla.getCarne());
		assertEquals(Size.GRANDE, royalSinCebolla.getSize());
		assertEquals(Pan.NORMAL, royalSinCebolla.getPan());
		assertFalse(royalSinCebolla.getExtras().contains(Extra.CEBOLLA));
		assertTrue(royalSinCebolla.getExtras().contains(Extra.QUESO));
		assertFalse(royalSinCebolla.getExtras().contains(Extra.PEPINO));
		assertFalse(royalSinCebolla.getExtras().contains(Extra.MAYONESA));
		
	}
}
