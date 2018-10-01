package dao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bean.Login;
import idao.Login_idao;
@Repository
public class Login_dao implements Login_idao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int add(Login login) {
		return sqlSessionTemplate.insert("addLogin", login);
	}
       
}
