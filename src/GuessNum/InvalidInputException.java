package GuessNum;
public class InvalidInputException extends Exception
{
	private static final long serialVersionUID = -220913467852042704L;
	
	public InvalidInputException(String errorMessage)
	{
		super(errorMessage);
	}
}