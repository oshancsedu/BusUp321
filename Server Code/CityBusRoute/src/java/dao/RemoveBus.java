package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class RemoveBus extends JdbcDaoSupport implements DbOperator {

    @Override
    public Boolean operation(String[] detail) {
       
        try {
        String sql="DELETE FROM `busname` WHERE bus like '"+detail[0]+"'";
        System.out.println("Into Provider: "+detail[0]);
        this.getJdbcTemplate().update(sql);
        
        sql="drop table "+detail[0];
        this.getJdbcTemplate().update(sql);
        
        sql="drop table "+detail[0]+"_stand";
        this.getJdbcTemplate().update(sql);
        
        return true;
        }catch(Exception ex) {
           return false;
        }
    }
}