package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UpdateRoute extends JdbcDaoSupport implements DbOperator {

    @Override
    public Boolean operation(String[] detail) {
      return true;
    }
    
}
