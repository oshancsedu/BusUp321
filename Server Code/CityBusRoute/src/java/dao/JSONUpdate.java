package dao;

import jsonaction.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JSONUpdate extends JdbcDaoSupport{
 
    public List<BusName> getAllBusName() {
        String Sql = "SELECT * FROM `busname` order by bus";
        return this.getJdbcTemplate().query(Sql, new BusNameRowMapper());
    }

    public List<StandDetail> getAllStand() {
        String sql="SELECT * FROM `busstand` order by stand";
        return this.getJdbcTemplate().query(sql, new StandDetailRowMapper());
    }
    
    public List<Name> getAllBusStand(String busname) {
        String Sql = "SELECT * FROM `"+busname+"_stand`";
        return this.getJdbcTemplate().query(Sql, new NameRowMapper());
    }
    
    public List<Route> getAllBusRoute(String busname) {
        String Sql = "SELECT * FROM `"+busname+"`";
        return this.getJdbcTemplate().query(Sql, new RouteRowMapper());
    }
    
    private static class BusNameRowMapper implements RowMapper<BusName> {

        @Override
        public BusName mapRow(ResultSet rs, int i) throws SQLException {
            BusName busName = new BusName();
            busName.setName(rs.getString(1));
            busName.setColor(rs.getString(2));
            return busName;  
        }
    }

    private static class NameRowMapper implements RowMapper<Name> {

        @Override
        public Name mapRow(ResultSet rs, int i) throws SQLException {
            Name busName = new Name();
            busName.setName(rs.getString(1));
            return busName;  
        }
    }
    
    
    private static class RouteRowMapper implements RowMapper<Route> {

        @Override
        public Route mapRow(ResultSet rs, int i) throws SQLException {
            Route route = new Route();
            route.setLat(rs.getDouble(1));
            route.setLng(rs.getDouble(2));
            return route;  
        }
    }

    private static class StandDetailRowMapper implements RowMapper<StandDetail>{

        @Override
        public StandDetail mapRow(ResultSet rs, int i) throws SQLException {
            StandDetail standDetail= new StandDetail();
            standDetail.setStandName(rs.getString(1));
            standDetail.setLatUp(rs.getDouble(2));
            standDetail.setLongUp(rs.getDouble(3));
            standDetail.setLatDown(rs.getDouble(4));
            standDetail.setLongDown(rs.getDouble(5));
            return standDetail;
        }
    }
}
