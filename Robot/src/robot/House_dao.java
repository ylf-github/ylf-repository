package robot;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class House_dao {
        public int add(House house) throws IOException{
        	InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
        	SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        	SqlSession session=sqlSessionFactory.openSession();
        	int n=session.insert("addhouse", house);
        	session.commit();
        	session.close();
        	return n;
        }
}
