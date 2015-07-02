package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;


/**
 * Klasse, die Geldbeträge beschreibt. Geldbeträge können nicht einfach erzeugt werden sondern müssen die Fabrikmethoden
 * geholt werden.
 * Sie tragen einen Betrag in Eurocent und bieten Methoden zum Rechnen und lassen eine Repräsentation des Betrages als
 * String ausgeben.
 * 
 * @author stefan
 * @version 1.0
 * @date 02.07.2015
 */
public final class Geldbetrag
{
	private final int _eurocent;
	
	private Geldbetrag(int betrag)
	{
		_eurocent = betrag;
	}
	
	/**
	 * Erzeugt neues Geldbetrag Objekt
	 * 
	 * @param betrag Der Betrag in Eurocent. Negative Zahlen sind gültig und entsprechen Auszahlungen aus der Kasse
	 * 
	 * @ensure result != null
	 * 
	 * @return Das fertige Geldbetrag-Objekt
	 */
	public static Geldbetrag get(int betrag)
	{
		return new Geldbetrag(betrag);
	}
		

	/**
	 * Fabrikmethode liefert einen Geldbetrag mit gewünschtem Betrag
	 * 
	 * @param betrag Betrag als kommaseparierter String, für den ein Geldbetrag-Objekt erzeugt werden soll
	 * in der Form "EE,CC"
	 * 
	 * @require betrag != null
	 * @require betrag.matches("-? *\\d+ *, *\\d\\d")
	 * 
	 * @ensure result != null
	 * 
	 * @return Das fertige Geldbetrag-Objekt
	 */
	public static Geldbetrag get(String betrag) throws InvalidInputException
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		assert betrag.matches(" *-? *\\d+ *, *\\d *\\d *") : "Vorbedingung verletzt: betrag.matches(\" *-? *\\d+ *, *\\d *\\d *\")";
		
		if(betrag.matches(" *-? *\\d+ *, *\\d *\\d *"))
		{
			return new Geldbetrag(Integer.parseInt(betrag.replaceAll("[, ]", "")));
		}
		else
		{
			throw new InvalidInputException();
		}
	}

	
	//Rechnungen
	
	/**
	 * Addiert einen Geldbetrag zum aufrufenden Geldbetrag. Lässt Addition negativer Wertbeträge zu.
	 * @param betrag Der zu addierende Geldbetrag. Kann ein negativer Betrag sein
	 * 
	 * @require betrag != null
	 * @ensure result != null
	 * 
	 * @return Geldbetrag, der das Ergebnis der Addition trägt.
	 */
	public Geldbetrag addiere(Geldbetrag betrag)
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		
		return get(_eurocent + betrag.getEurocent());
	}
	
	/**
	 * Subtrahiert einen Geldbetrag vom aufrufenden Geldbetrag. Lässt Subtraktion negativer Wertbeträge zu.
	 * 
	 * @param betrag Der zu subtrahierende Geldbetrag. Kann ein negativer Betrag sein.
	 * 
	 * @require betrag != null
	 * 
	 * @ensure result != null
	 * 
	 * @return Geldbetrag, der das Ergebnis der Subtraktion trägt.
	 */
	public Geldbetrag subtrahiere(Geldbetrag betrag)
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		
		return get(_eurocent - betrag.getEurocent());
	}

	/**
	 * Multipliziert den Geldbetrag mit einer Ganzzahl und liefert einen neuen Geldbetrag, der das Ergebnis der
	 * Rechnung trägt.
	 * 
	 * @param n Der Multiplikator, mit dem der Geldbetrag multipliziert werden soll.
	 * 
	 * @ensure result != null
	 * 
	 * @return Geldbetrag, der das Ergebnis der Rechnung trägt.
	 */
	public Geldbetrag multipliziere(int n)
	{
		return get(n * _eurocent);
	}
		
	//Hilfsmethoden
	
	// Liefert den im Objekt gehaltenen Wert in Eurocent
	// @return Gehaltener Wert in Eurocent
	private int getEurocent()
	{
		return _eurocent;
	}
	
	// Liefert die VOLLEN Euro, die im Wert enthalten sind OHNE Cent. Bsp: 8,31€ liefert 8.
	// @return Ganze Euro, die im Objekt gehalten werden
	private int getEuro()
	{
		return _eurocent / 100;
	}
	
	// Liefert die Cent ohne Euro, die im Wert enthalten sind. Bsp: 8,31€ liefert 31
	//  @return Cent zum nächsten vollen Euro
	private int getCent()
	{
		return _eurocent % 100;
	}
	
	//fachwerte override
	
	/**
	 * Liefert einen String, der den Wert des Geldbetrages in formatierter Form enthält. Der String hat die Form
	 * "E(EE...),CC".
	 * 
	 * @ensure result.matches("-? *\\d+ *, *\\d\\d")
	 * @ensure result != null
	 * 
	 * @return String, der den Wert des Geldbetrages repräsentiert
	 */
	@Override
	public String toString()
	{
		if(Math.abs(getCent())<10)
		{
			return (new StringBuilder(getEuro()+(",0"+getCent()).replaceAll("-", ""))).toString();
		}
		else
		{
			return (new StringBuilder(getEuro()+(","+getCent()).replaceAll("-", ""))).toString();
		}
	}
	
	/**
	 * Prüft, ob ein Objekt dem aufrufenden Geldbetrag gleicht.
	 * 
	 * @return Ergebnis der Prüfung auf Gleichheit. Gleichheit wird durch true repräsentiert.
	 */
	@Override
	public boolean equals(Object O)
	{
		if((O instanceof Geldbetrag) && (hashCode()==O.hashCode()))
		{
			return true;
		}	
		return false;
	}
	
	/**
	 * Erstellt einen hashCode der gleich ist für gleich Geldbetragobjekte.
	 * 
	 * @return int hashcode ist hier _eurocent.
	 */
	@Override
	public int hashCode()
	{
		return _eurocent;
	}
}
