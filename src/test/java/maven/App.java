package maven;

public class App {

	public int userLogin(String in_user,String in_pwd)
	{
		
		String userName="abc";
		String password="abc@123";
		
		if(in_user.equals(userName) && in_pwd.equals(password))
			return 1;
		else
			return 0;
	}

}
