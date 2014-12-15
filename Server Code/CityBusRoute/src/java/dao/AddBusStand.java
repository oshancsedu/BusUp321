package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AddBusStand extends JdbcDaoSupport implements DbOperator {

    @Override
    public Boolean operation(String[] detail) {
      
        try {
        String sql="INSERT INTO `bus_route`.`busstand` (`Stand`, `Latup`, `LongUp`, `LatDown`, `LongDown`) "
                    + "VALUES ('"+detail[0]+"', "+detail[1]+", "+detail[2]+", "+detail[3]+", "+detail[4]+");";
        System.out.println("Into Provider: "+detail[0]);
        this.getJdbcTemplate().update(sql);
        return true;
        }catch(Exception ex) {
           return false;
        }
    }
 }