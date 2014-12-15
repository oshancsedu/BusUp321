package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class RemoveSingleCoordinate extends JdbcDaoSupport implements DbOperator{

    @Override
    public Boolean operation(String[] detail) {
    System.out.println(detail[0]+" "+detail[1]+" "+detail[2]);
        double lat= Double.parseDouble(detail[1]);
        double lng= Double.parseDouble(detail[2]);
        try {
        String sql="DELETE FROM `"+detail[0]+"` WHERE lng="+lng+" and lat="+lat+"";
        this.getJdbcTemplate().update(sql);
        return true;
        }catch(Exception ex){
            return false;
        }    
    }
}
