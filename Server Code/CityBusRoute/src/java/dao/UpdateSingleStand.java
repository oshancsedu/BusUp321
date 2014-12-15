package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UpdateSingleStand extends JdbcDaoSupport implements DbOperator {

    @Override
    public Boolean operation(String[] detail) {
        try {
        System.out.println(detail[0]+" "+detail[1]+" "+detail[2]);
        String sql="UPDATE `"+detail[0]+"_stand` SET `StandName`='"+detail[2]+"' WHERE standname='"+detail[1]+"'";
        this.getJdbcTemplate().update(sql);
        return true;
        }catch(Exception ex) {
            return false;
        } 
    }
}
