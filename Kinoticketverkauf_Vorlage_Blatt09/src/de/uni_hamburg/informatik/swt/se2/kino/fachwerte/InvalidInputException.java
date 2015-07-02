package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public class InvalidInputException extends Exception
{
	public InvalidInputException()
	{
		super("Falsch formatierter Geldbetrag.");
	}
}
