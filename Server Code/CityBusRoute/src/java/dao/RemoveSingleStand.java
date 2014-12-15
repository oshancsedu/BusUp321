package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class RemoveSingleStand  extends JdbcDaoSupport implements DbOperator{

    @Override
    public Boolean operation(String[] detail) {
      
        try {
        String sql="DELETE FROM `"+detail[0]+"_stand` WHERE standname='"+detail[1]+"'";
        this.getJdbcTemplate().update(sql);
        return true;
        }catch(Exception ex) {
            return false;
        }    
    }
}
