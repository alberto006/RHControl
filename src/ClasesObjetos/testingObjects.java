/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesObjetos;

import ClasesObjetos.Prestamo;
import ClasesObjetos.Liquidacion;
import java.text.ParseException;

/**
 *
 * @author asoriano
 */
public class testingObjects {
    public static void main(String[] args) {
        Prestamo pm = new Prestamo();
        pm.setMontoPrestamo(155000);
        pm.setAños(5);
        pm.setSalario(13500);
        pm.setInteres(22);        
        float cuota =pm.getCuota();        
        //System.out.println(cuota);
        
        Liquidacion lq = new Liquidacion();
        lq.setSalario(10790);
        lq.setFechaInicio("06/04/2016");
        lq.setFechaFin("09/05/2018");
        
        float sno = lq.getSalarioNormalOrdinario(0);
        float sp = lq.getSalarioPromedio(0);
        float spo = lq.getSalarioPromedioOrdinario(0);
        float preaviso = lq.getPreaviso(0);        
        int meses = lq.getMeses(0);
        float cesantia = lq.getCesantia(0);
        System.out.println(cesantia);
        System.out.println(lq.getMeses(0));
        
        
    }
}
