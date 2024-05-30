/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.farmacia;
import com.farmacia.adts.NodeMedDis;
import com.farmacia.adts.ListInventario;
import com.farmacia.model.Medicamento;

/**
 *
 * @author PERSONAL
 */
public class PryFarmaciaEstructuras {

    public static void main(String[] args) {
    
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Esta sección trae la implementación de la lista inventario
    Medicamento medicamento1=new Medicamento("Setralina",20,3434);
    Medicamento medicamento2=new Medicamento("Acetaminofen",100,5050);
    Medicamento medicamento3=new Medicamento("Ibuprofeno",50,7878);
    Medicamento medicamento4=new Medicamento("Minoplazol",80,1111);
    
   ListInventario listaCircular = new ListInventario();
   
   listaCircular.AgregarAlInventario(medicamento4);
   listaCircular.AgregarAlInventario(medicamento4);
   listaCircular.AgregarAlInventario(medicamento4);
   listaCircular.AgregarAlInventario(medicamento1);

    listaCircular.ImprimirLista();   
    listaCircular.ImprimirLista();

    
/////////////////////////////////////////////////////////////////////////////////////////////////////777         
    }
    
}
