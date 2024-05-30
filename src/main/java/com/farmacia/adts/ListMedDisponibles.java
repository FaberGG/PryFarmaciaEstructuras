/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia.adts;
import com.farmacia.model.Medicamento;
/**
 *
 * @author PERSONAL
 */
    public class ListMedDisponibles {
        private NodeMedDis inicio;
        private NodeMedDis fin;

    public ListMedDisponibles() {
        this.inicio = null;
        this.fin = null;
    }
    
    public void AgregarMedicamento (Medicamento medicamento){
      NodeMedDis nuevoNodo = new NodeMedDis();
      nuevoNodo.setMedicamento(medicamento);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
        } else {
            nuevoNodo.setSiguiente(inicio);
            fin.siguiente=nuevoNodo;
            nuevoNodo.anterior=fin;
            fin=nuevoNodo;
        }
    }
    
    public String EliminarMedicamento(int dato){
        
        NodeMedDis actual = BuscarMedicamento(dato);
        if(actual==null){
         if(MedicamentoVencido(dato)==true){
             
             return "EL MEDICAMENTO SE ENCUENTRA VENCIDO";
         }else{
         return"EL MEDICAMENTO SE ENCUENTRA AGOTADO ";
         }
  
       }
         if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            inicio = actual.siguiente;  // Eliminar cabeza
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            fin = actual.anterior;  // Eliminar cola
        }
     return "ELEMENTO AGREGADO AL CARRRITO";
    }
    
    
    
    
    public NodeMedDis  BuscarMedicamento(int codigobuscar){
        
    NodeMedDis actual=inicio;
    while (actual!=null){
        if(codigobuscar==actual.getMedicamento().getCodigo()){
        return actual;
    }
}
 
    return null;

}
   
    
    //CODIGO DE CADUCIDAD-------------- 1111 
 
    public boolean MedicamentoVencido(int codigo){
        NodeMedDis actual=inicio;
         while (actual!=null){
        if(actual.getMedicamento().getCodigo()==codigo && codigo==1111){
        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            inicio = actual.siguiente; // Eliminar cabeza
        }
        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            fin = actual.anterior;  // Eliminar cola
        }
        return true; 
        //EL MEDICAMENTO ESTÁ VENCIDO Y SE ELIMINA POR ESO
          }       
    }    
        return false;// EL MEDICAMENTO NO ESTÁ VENCIDO 
 }

    
}
