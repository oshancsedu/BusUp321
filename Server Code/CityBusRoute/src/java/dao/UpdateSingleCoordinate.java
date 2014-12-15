package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UpdateSingleCoordinate extends JdbcDaoSupport implements DbOperator{

    @Override
    public Boolean operation(String[] detail) {
        try {
        System.out.println(detail[0]+" "+detail[1]+" "+detail[2]);
        String sql="UPDATE `"+detail[0]+"` SET `Lat`="+detail[3]+",`Lng`="+detail[4]+" WHERE lat="+detail[1]+" and lng="+detail[2]+"";
        this.getJdbcTemplate().update(sql);
        return true;
        }catch(Exception ex) {
            return false;
        }    
    }
}