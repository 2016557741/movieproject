package www.csdn.project.service;

import www.csdn.project.domain.Users;

public interface UsersService {

	public Users login(final String email, final String passWord);
	
	public boolean checkPass(final Class clazz, final String property,
			final String value, final Integer id) ;
	
	public Users updateUserPassword(String oldPass,String newPass) throws Exception  ;
}
