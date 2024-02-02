
public class tester 
{
	public static void main (String[]args) 
	{
		String line = "Apr 12 21:10:58 fembot sshd[24195]: Invalid user ubnt from 222.186.3.84";
		if (line.contains("Invalid")) 
		{
			int startIndex = line.indexOf("from ");
			String ipAddress=line.substring(startIndex+5);
			System.out.println(ipAddress);
		}
	}
}
