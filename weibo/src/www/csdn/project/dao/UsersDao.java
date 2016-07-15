package www.csdn.project.dao;

import www.csdn.project.domain.Users;

public interface UsersDao {

	public Users login(final String email, final String passWord);
	
	public boolean checkPass(final Class clazz, final String property,
			final String value, final Integer id) ;

	public Users updateUsers(Users users) ;

	public Users getUsersById(int id) ;
}
