
package com.farmacia;
import com.farmacia.controller.FarmaciaController;
import com.farmacia.view.FarmaciaView;
/**
 *
 * @author PERSONAL
 */
public class PryFarmaciaEstructuras {

    public static void main(String[] args) {


    
    FarmaciaController controller = new FarmaciaController();
    FarmaciaView view = new FarmaciaView(controller);
    view.mostrarMenuPrincipal();
    
    
    }
    
}
