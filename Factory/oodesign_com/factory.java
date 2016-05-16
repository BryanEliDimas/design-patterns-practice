/*
Factory design pattern

Product         = an abstraction
OneProduct      = a concretion

ProductFactory  = responsible for creating a Product and the client doesn't know the Concrete Product class
*/

abstract class Product { // an abstraction // standardizes behavior, class name, method names
  public abstract createProduct();
}



class OneProduct extends Product { // a concrete implementation of the Product abstraction
  static  { // registers itself with the Factory
    ProductFactory.instance().registerProduct("ID1", new OneProduct);
  }

  public OneProduct createProduct(){
    return new OneProduct();
  }
}



class ProductFactory { // the actual Factory, creates Products
  public void registerProduct(String productID, Product p) {
    m_RegisteredProducts.put(productID, p);
  }

   // the important stuff
  public Product createProduct(String productID) {
    ((Product)m_RegisteredProducts.get(productID)).createProduct();
  }
}
