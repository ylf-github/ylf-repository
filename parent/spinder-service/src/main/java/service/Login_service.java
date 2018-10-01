package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bean.Login;
import idao.Login_idao;
import iservice.Login_iservice;
@Service
public class Login_service implements Login_iservice{
@Autowired
private Login_idao dao;
	public int addTo(Login login) {
		// TODO Auto-generated method stub
		login.setId(GetRandomStringUtils.getRandomStringUtils());
		return dao.add(login);
	}

}
