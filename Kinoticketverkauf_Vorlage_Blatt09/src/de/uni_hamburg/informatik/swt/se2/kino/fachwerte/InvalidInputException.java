package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public class InvalidInputException extends Exception
{
	/**
	 * Falsch formatierter Geldbetrag.
	 */
	private static final long serialVersionUID = 2906501122468773680L;

	public InvalidInputException()
	{
		super("Falsch formatierter Geldbetrag.");
	}
}
