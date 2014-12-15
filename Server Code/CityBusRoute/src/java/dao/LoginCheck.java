package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.spi.LoginModule;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

public class LoginCheck extends JdbcDaoSupport implements DbOperator{
  
    @Override
    public Boolean operation(String[] detail) {
        try {
        String sql="Select password from admin where userName like '"+detail[0]+"' and password like '"+detail[1]+"'";
        String test= this.getJdbcTemplate().queryForObject(sql, String.class);
        return true;
        }catch(EmptyResultDataAccessException ex) {
           return false;
        }
    }
}