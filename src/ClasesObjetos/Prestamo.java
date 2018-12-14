/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesObjetos;

/**
 *
 * @author asoriano
 */
public class Prestamo {

    private float montoPrestamo;
    protected float salario;
    protected float interes;
    protected int años;
    
    
    public void Prestamo(float montoPrestamo,float salario,float interes,int años){        
        this.montoPrestamo = montoPrestamo;
        this.salario = salario;
        this.interes = interes;
        this.años = años;        
    }
    
    public float getMontoPrestamo(){
        return this.montoPrestamo;
    }
    
    public void setMontoPrestamo(float montoPrestamo){
        this.montoPrestamo=montoPrestamo;
    }
    
    public float getSalario(){
        return this.salario;
    }
    
    public void setSalario(float salario){
        this.salario=salario;
    }
    
    public float getInteres(){
        return this.interes;
    }
    
    public void setInteres(float interes){
        this.interes=interes;
    }
    public int getAños(){
        return this.años;
    }
    public void setAños(int años){
        this.años=años;
    }
    
    public float getCapacidadPago(float salario){
        float capacidadPago;
        capacidadPago = (float) (salario*0.30);        
        return capacidadPago;
    }
    
    public float getCuota(){
        float cuota=0;
        int cuotas = años*12;
        float interesMensual = (interes/12)/100;
        float base = (1+interesMensual);
        int potencia = -cuotas;        
        cuota = (float) ((interesMensual*montoPrestamo)/(1-Math.pow(base,potencia)));   
        
        return cuota;
    }
    
    
    
}
