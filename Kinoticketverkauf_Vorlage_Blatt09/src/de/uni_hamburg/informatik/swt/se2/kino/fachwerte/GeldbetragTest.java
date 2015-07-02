package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeldbetragTest
{
    @Test
    public void testConstructionFromInteger()
    {
        assertEquals("1,00",Geldbetrag.get(100).toString());
    }
    
    @Test
    public void testConstructionFromString()
    {
        assertEquals("1,00",Geldbetrag.get("1,00").toString());
    }  
    
    @Test
    public void testGibString()
    {
        Geldbetrag geldbetrag = Geldbetrag.get(1000);
        assertEquals("10,00",geldbetrag.toString());
    }
    
    @Test
    public void testAddieren()
    {
        Geldbetrag betrag1 = Geldbetrag.get(1337);
        Geldbetrag betrag2 = Geldbetrag.get("13,37");
        
        assertEquals("26,74",betrag1.addiere(betrag2).toString());
    }
    
    @Test
    public void testSubtrahieren()
    {
        Geldbetrag betrag1 = Geldbetrag.get(1337);
        Geldbetrag betrag2 = Geldbetrag.get("13,37");
        
        assertEquals(Geldbetrag.get(0),betrag1.subtrahiere(betrag2));
    }
    
    @Test
    public void testMultiplizierenMitZahl()
    {
        Geldbetrag betrag = Geldbetrag.get(1000);
        
        assertEquals(Geldbetrag.get(2000),betrag.multipliziere(2));
    }
    
    @Test
    public void testNegativeZahlen()
    {
    	Geldbetrag betrag = Geldbetrag.get(-1337);
    	assertEquals("-13,37",betrag.toString());
    }
}
