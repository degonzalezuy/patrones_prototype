package prototype;

import prototype.impl.PriceListImpl;
import prototype.impl.ProductItem;
import prototype.impl.PrototypeFactory;

public class Main {
    public static void main(String[] args) {
    /***
     *Creamos la lista de precios inicial, ésta tiene los productos con
     *         el precio de lista
     */

        PriceListImpl standarPriceList =
                new PriceListImpl("Standar Price List");
        for(int c = 1; c<=5; c++){
            ProductItem item = new ProductItem("Product " + c, c*2);
            standarPriceList.addProductItem(item);
        }
        PrototypeFactory.addPrototype(
                standarPriceList.getListName(), standarPriceList);
    /***
     *  Segunda lista para clientes de maryoreo a partir de la lista
     *  estandar con un 10% de descuento sobre la lista de precio estándar.
     */
        PriceListImpl wholesalePriceList = (PriceListImpl)
                PrototypeFactory.getPrototype("Standar Price List");
        wholesalePriceList.setListName("Wholesale Price List");
        for(ProductItem item : wholesalePriceList.getProducts()){
            item.setPrice(item.getPrice()*0.90);
        }
        PrototypeFactory.addPrototype(
                wholesalePriceList.getListName(), wholesalePriceList
        );

    /**
     * Tercera lista de precios para clientes VIP a partir de la lista
     * de mayoreo con 10% de decuento sobre la lista de precios de mayoreo
     */
        PriceListImpl vipPriceList = (PriceListImpl)
                PrototypeFactory.getPrototype("Wholesale Price List");
        vipPriceList.setListName("VIP Price List");
        for (ProductItem item: vipPriceList.getProducts()){
            item.setPrice(item.getPrice() * 0.90);
        }

        //IMPRIMIENDO LAS LISTAS DE PRECIOS
        System.out.println(standarPriceList);
        System.out.println(wholesalePriceList);
        System.out.println(vipPriceList);
    }
}