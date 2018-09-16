/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalfunctions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.Function;
import sun.security.pkcs11.wrapper.Functions;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Miguel Hasbun
 */
public class ExternalFunctions {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException {
    
        String fileDb = "C:/Users/Miguel Hasbun/Documents/NetBeansProjects/ExternalFunctions/test.db";
        Connection connection = Connection(fileDb);
        Function.create(connection,Trim.class.getSimpleName(), new Trim());
        Function.create(connection, Ping.class.getSimpleName(), new Ping());
        Function.create(connection, Factorial.class.getSimpleName(), new Factorial());
        Function.create(connection, C2F.class .getSimpleName(), new C2F());
        Function.create(connection, F2C.class .getSimpleName(), new F2C());
        Function.create(connection, BIN2DEC.class.getSimpleName(), new BIN2DEC());
        Function.create(connection, DEC2BIN.class.getSimpleName(), new DEC2BIN());
        Function.create(connection, DEC2HEX.class.getSimpleName(), new DEC2HEX());
        Function.create(connection, HEX2DEC.class.getSimpleName(), new HEX2DEC());
        Function.create(connection, REPEAT.class.getSimpleName(), new REPEAT());
        Function.create(connection, PMT.class.getSimpleName(), new PMT());
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  
        
        try {
            //PARA EL TRIM
           // ResultSet rs = statement.executeQuery("select Trim('/Miguel/','/') as b");
           //while(rs.next())
            //{
              //  System.out.println("b = " + rs.getString("b"));
            //}
           
            //PARA EL PING
            /*ResultSet rst = statement.executeQuery("select Ping('marca.com') as b");
            
            System.out.println(rst.getString("b"));*/
            
            //PARA EL FACTORIAL
           /* ResultSet rsat = statement.executeQuery("select Factorial(5) as b");
              while (rsat.next()){
                System.out.println("Factorial = "+ rsat.getInt(1));
           }*/
           
           //PARA C2F
           /*ResultSet rs= statement.executeQuery("select C2F(25) as b");
           System.out.println("Temperatura en Farenheit= "+ rs.getDouble(1)+ " °F");*/
           
           //PARA F2C
           /*ResultSet rs= statement.executeQuery("select F2C (45) as b");
           System.out.println("Temperatura en Celsius="+ rs.getDouble(1)+ " °C");*/
           
           //PARA BIN2DEC
           /*ResultSet rs= statement.executeQuery("select BIN2DEC (101010) as b");
           System.out.println("Valor en decimal="+ rs.getInt(1));*/
           
           //PARA DEC2BIN
          /* ResultSet rs= statement.executeQuery("select DEC2BIN (25) as b");
           System.out.println("Valor en binario="+ rs.getString("b"));*/
          
          //PARA DEC2HEX
          /*ResultSet rs= statement.executeQuery("select DEC2HEX (21) as b");
          System.out.println("Número en hexadecimal="+ rs.getInt(1));*/
          
          //PARA HEX2DEC
          /*ResultSet rs= statement.executeQuery("select HEX2DEC ('A') as b");
          System.out.println("Número en decimal "+ rs.getInt(1));*/
          
          //PARA EL REPEAT
          /*ResultSet rs = statement.executeQuery("select REPEAT('/Miguel/',5) as b");
           while(rs.next())
           {
               System.out.println("Cadena repetida = " + rs.getString("b"));
           }*/
          
          //PARA EL PMT
          ResultSet rs= statement.executeQuery("select PMT(10 ,12 ,100000) as b");
          System.out.println("Valor= "+ rs.getDouble(1));
            
            
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                
                System.err.println(e);
            }
        }
    }

    public static Connection Connection(String fileDb)
    {
        File file = new File(fileDb);
        if (file.exists())
        {
            Connection conn = null;
            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:" + fileDb;
                conn = DriverManager.getConnection(url);
                System.out.println("Conexión establecida con éxito");
                return conn;
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else
        {
            System.out.println("No se encontro la base de datos");
            return null;
        }
    }

    }


