package listener;

import dao.DbOperator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    
    private volatile static Provider provider=null;
    public ApplicationContext context=null;
   
    private Provider() {
        context = new ClassPathXmlApplicationContext("Spring.xml");
    }
    
    public static Provider get_Provider() {
        if(provider==null)
        {
            synchronized(Provider.class){
                if(provider==null)
                    provider =new Provider();
            }
        }
        return provider;
    }
    
    public Boolean Provide (DbOperator dbOperator,String[] detail) {
        System.out.println("Into Provider: "+detail[0]);
        if(dbOperator.operation(detail))
        return true;
        else
        return false;
    }
}