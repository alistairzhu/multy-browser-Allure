package dbHelpers;

public class SqlQueries {


    /**
     * Table name : PERSON
     *
     * SQL for creating the table:
     * create table PERSON (ID bigint not null, EMAIL varchar(255), FIRST_NAME varchar(255), JOINED_DATE date, LAST_NAME varchar(255), primary key (id))
     *
     */
    public static final String INSERT_SQL_QUERY     = "INSERT INTO PERSON(ID,FIRST_NAME,LAST_NAME,EMAIL,JOINED_DATE) VALUES(?,?,?,?,?)";
    //public static final String INSERT_SQL_QUERY     = "INSERT INTO public.acccounts(accoutName, addressSet) VALUES (?, ?)";
    public static final String UPDATE_SQL_QUERY     = "UPDATE PERSON SET FIRST_NAME=? WHERE ID=?";
    public static final String SELECT_SQL_QUERY     = "SELECT ID,FIRST_NAME,LAST_NAME,EMAIL,JOINED_DATE FROM PERSON WHERE ID=?";
    public static final String SELECT_ALL_SQL_QUERY = "SELECT ID,FIRST_NAME,LAST_NAME,EMAIL,JOINED_DATE FROM PERSON";
    public static final String DELETE_SQL_QUERY     = "DELETE FROM PERSON WHERE ID=?";
    public static final String DELETE_ALL_SQL_QUERY = "DELETE FROM PERSON";
    public static final String SELECT_PERSON_QUERY  = "SELECT * FROM PERSON";

}
