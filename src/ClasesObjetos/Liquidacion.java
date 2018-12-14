/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesObjetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asoriano
 */
public class Liquidacion {
    SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
    String fechaInicio;
    String fechaFin;
    public float salario;   
    
    public void Liquidacion(float salario,String fechaInicio, String fechaFin){
        this.salario=salario;
        this.fechaFin=fechaFin;
        this.fechaInicio=fechaInicio;
    }
    
    
    public float getSalario(){
        return this.salario;
    }
    public void setSalario(float salario){
        this.salario=salario;
    }
    
    public String getFechaInicio(){
        return this.fechaInicio;
    }
    public void setFechaInicio(String fechaInicio){
        this.fechaInicio=fechaInicio;
    }
    
    public String getFechaFin(){
        return this.fechaFin;
    }
    public void setFechaFin(String fechaFin){
        this.fechaFin=fechaFin;
    }
    
    public int getAntiguedadDias(int antiguedadDias){        
        try {
            Date fechaI = df.parse(fechaInicio);
            Date fechaF = df.parse(fechaFin);            
            antiguedadDias=(int) ((fechaF.getTime()-fechaI.getTime())/86400000);                        
            if(antiguedadDias>0){
                antiguedadDias=antiguedadDias+1;
            }else{
                antiguedadDias=0+1;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Liquidacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return antiguedadDias;
    }
    
    //Salario normal ordinario = salario mensual dividido entre 30, es igual al pago diario
    public float getSalarioNormalOrdinario(float salarioNormalOrdinario){
        salarioNormalOrdinario=salario/30;
        return salarioNormalOrdinario;
    }
    
    //Salario Promedio contabilizando decimotercer y decimocuarto (aguinaldo y catorceavo) mensual
    public float getSalarioPromedio(float SalarioPromedio){
        SalarioPromedio=(salario*14)/12;
        return SalarioPromedio;
    }
    
    //Salario promedio entre 30, salario promedio ordinario diario
    public float getSalarioPromedioOrdinario(float SalarioPromedioOrdinario){
        SalarioPromedioOrdinario=((salario*14)/12)/30;
        return SalarioPromedioOrdinario;
    }
    
    public float getPreaviso(float preaviso){
        preaviso = ((salario*14)/12)*2;
        return preaviso;
    }
    
    //devuelve el valor de la sesantia calculada segun los meses laborados
    public float getCesantia(float cesantia){
        try {
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio));
            fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            int difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            //System.out.println(difM);   
            
            //Si la duracion laboral es mayor a tres meses y menor a 6
            if(difM>3 && difM<6){
                cesantia = ((salario/30))*10;
                //si la duracion laboral es de 6 meses a un año
            }else if(difM>=6 && difM < 12){                
                cesantia = (((salario)/30))*20;
            }else if(difM>=12 && difM < 25){
                cesantia = ((salario)*2);
            }else if (difM>=25){
                cesantia = (salario)*4;
            }else{
                cesantia = 0;
            }
            
        } catch(ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }        
        return cesantia;
    }
    
    public float getVacaciones(float vacaciones){
        vacaciones = 10*(((salario*14)/12)/30);
        return vacaciones;
    }
    
    public float getDecimotercer(float decimotercer){
        decimotercer = (((salario*14)/12)/30)*15;        
        return decimotercer;
    }
    
    public float getDecimocuarto(float decimocuarto){
        decimocuarto = (((salario*14)/12)/30)*15;        
        return decimocuarto;
    }
    
    
 
    //devuelve la cantidad de meses en base a la fecha de inicio y fin
    public int getMeses(int meses){        
         try {
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio));
            fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            int difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            //System.out.println(difM);
            meses = difM;
        } catch(ParseException ex) {

        }        
        
        return meses;
    }
    
    public int getAños(int años){        
         try {
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio));
            fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            int difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            //System.out.println(difM);
            años = difA;
        } catch(ParseException ex) {

        }        
        
        return años;
    }
}
