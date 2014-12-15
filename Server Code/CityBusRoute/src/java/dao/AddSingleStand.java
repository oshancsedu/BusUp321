package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class AddSingleStand extends JdbcDaoSupport implements DbOperator {

    @Override
    public Boolean operation(String[] detail) {
    try {
        String sql="INSERT INTO `bus_route`.`"+detail[0]+"_stand` (`StandName`) VALUES ('"+detail[1]+"')";
        this.getJdbcTemplate().update(sql);
        return true;
        }catch(Exception ex) {
            return false;
        }    
    }
}
