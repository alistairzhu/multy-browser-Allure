package dbHelpers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class JdbcHelper
{
    private static Connection connection;

    static
    {
        try
        {
            Class.forName( JdbcConstants.DRIVER_NAME );
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println( "Driver class not found" );
        }
    }

    public static Connection getConnection() throws SQLException
    {
        connection = DriverManager.getConnection( JdbcConstants.URL, JdbcConstants.USERNAME, JdbcConstants.PASSWORD );
        return connection;
    }

    public static void closeConnection( Connection con ) throws SQLException
    {
        if ( con != null )
        {
            con.close();
        }
    }

    public static void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
    {
        if ( stmt != null )
        {
            stmt.close();
        }
    }

    public static void closeResultSet( ResultSet rs ) throws SQLException
    {
        if ( rs != null )
        {
            rs.close();
        }
    }

}
