package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AddBus extends JdbcDaoSupport implements DbOperator {

    @Override
    public Boolean operation(String[] detail) {
        try {
        String sql="INSERT INTO `bus_route`.`busname` (`Bus`, `Color`) VALUES ('"+detail[0]+"','"+detail[1]+"')";
        System.out.println("Into Provider: "+detail[0]);
        this.getJdbcTemplate().update(sql);
        
        sql="CREATE TABLE "+detail[0]+" (Lat float (10,6), Lng float (10,6))";
        this.getJdbcTemplate().update(sql);
        
        sql="CREATE TABLE "+detail[0]+"_stand (StandName varchar(100))";
        this.getJdbcTemplate().update(sql);
        
        return true;
        }catch(Exception ex) {
            return false;
        }
    }
}