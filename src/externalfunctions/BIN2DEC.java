/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalfunctions;
import org.sqlite.Function;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLException;
/**
 *
 * @author Miguel Hasbun
 */
public class BIN2DEC extends Function{
    
     protected void xFunc() throws SQLException {
        if (args() != 1) {
            throw new SQLException("Requiere un parámetro" + args());
        }
      try{
           result(Integer.parseInt( value_text(0),2));
       }catch(Exception e){
           result(0);
       }
     }
}
