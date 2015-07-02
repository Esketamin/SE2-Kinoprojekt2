package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public final class Geldbetrag
{
	private final int _eurocent;
	
	private Geldbetrag(int betrag)
	{
		_eurocent=betrag;
	}
	
	/**
	 * Erzeugt neues Geldbetrag Objekt
	 * 
	 * @param betrag
	 * @return geldbetrag
	 */
	public static Geldbetrag get(int betrag)
	{
		return new Geldbetrag(betrag);
	}
		

	
	public static Geldbetrag get(String betrag)
	{
		//TODO fix this :/
		if(betrag.matches("[-]?\\d+,\\d\\d"))
		{
			
		}
//		else
//		{
//			
//		}
//		Regular Expressions?! DAFUQ
		return null;
	}

	//rechnungen
	public Geldbetrag addiere(Geldbetrag betrag)
	{
		return get(_eurocent+betrag.getEurocent());
	}
	
	public Geldbetrag subtrahiere(Geldbetrag betrag)
	{
		return get(_eurocent-betrag.getEurocent());
	}

	public Geldbetrag multipliziere(int i)
	{
		return get(_eurocent*i);
	}
	
	//umwandlungen
	private int getEurocent()
	{
		return _eurocent;
	}
	
	private int getEuro()
	{
		
		return _eurocent/100;
	}
	
	private int getCent()
	{
		return _eurocent%100;
	}
	
	//fachwerte override
	@Override
	public boolean equals(Object O)
	{
		//TODO do this :P
		return true;
	}
	
	@Override
	public int hashCode()
	{
		//TODO do this :P
		return 1;
	}
	
	@Override
	public String toString()
	{
		return (new StringBuilder(getEuro()+','+getCent())).toString();
	}
}
