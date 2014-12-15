package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class RemoveStand extends JdbcDaoSupport implements DbOperator{

    @Override
    public Boolean operation(String[] detail) {
        try {
        String sql="Delete from busstand where stand like '"+detail[0]+"'";
        this.getJdbcTemplate().update(sql);
        return true;
        }catch(Exception ex) {
           return false;
        }
    }
}
