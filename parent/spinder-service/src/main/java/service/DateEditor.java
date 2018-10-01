package service;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport{
         @Override
         public void setAsText(String text){
        	 SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
        	 try{
        		 Date date=dataFormat.parse(text);
        		 setValue(date);
        	 }catch(Exception e){
        		 e.printStackTrace();
        		 System.out.println("error");
        		 
        	 }
         }
}
