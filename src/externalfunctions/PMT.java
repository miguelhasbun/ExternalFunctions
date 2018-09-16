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
public class PMT extends Function {
    @Override
    protected void xFunc() throws SQLException {
        if (args() != 3) {
            throw new SQLException("Necesita 3 parámetros" + args());
        }
        try {
            double tasa_interes = value_double(0);
            int numero_periodos = value_int(1);
            double valor_prestamo = value_double(2);
            double v = (1+(tasa_interes/12));
            double t = (-(numero_periodos/12)*12);
            double resultante=(valor_prestamo*(tasa_interes/12))/(1-Math.pow(v, t));
            result(resultante);
        }catch (Exception e)
        {
            result(-1);
        }
    }
}
