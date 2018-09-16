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
public class DEC2HEX extends Function {
  @Override
    protected void xFunc() throws SQLException {
        if (args() != 1) {
            throw new SQLException("Necesita un argumento" + args());
        }
        result(Integer.toHexString(value_int(0)));
    }
}
