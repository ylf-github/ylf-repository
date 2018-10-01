package service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
@Service
public class GetRandomStringUtils{
   public static String getRandomStringUtils(){
	   return RandomStringUtils.randomAlphanumeric(32);
   }
}
