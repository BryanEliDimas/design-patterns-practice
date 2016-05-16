/*
Factory Method design pattern

Creator          =  Factory           = cool useful operations + declares the Factory Method, is what client will work with
ConcreteCreator  =  Concrete Factory  = overrides the FactoryMethod, inherits the cool useful operations from Creator

Product          =  Product           = just an abstraction
ConcreteProduct  =  Concrete Product  = a concretion
*/

public interface Product {  } // an abstraction

public class ConcreteProduct implements Product {} // a concretion




public abstract class Creator { // the Factory // an abstraction // contains a bunch of cool useful operations
  // knows about Product interface only, not ConcreteProduct's
  public void anOperation(){ // one cool useful operation // not usually overriden by a subclass
    Product product = factoryMethod();
    // ... some cool useful operation with a ConcreteProduct of Product here
  }

  protected abstract Product factoryMethod(); // obviously <the> factoryMethod in Factory that subclasses must override
}



public class ConcreteCreator extends Creator {
  // extends the Factory
  // overrides the factoryMethod
  // inherits cool useful operations
  // will be casted to its parent class Creator

  // knows about ConcreteProduct, but returns it as a Product
  protected Product factoryMethod(){
    return new ConcreteProduct();
  }
}




public class Client {
  public static void main(String args[]) {

    Creator creator = new ConcreteCreator(); // magic trick // extends Creator, where the cool useful operations exist
    creator.anOperation(); // the cool useful operation exists in Creator (aka. Factory)

  }
}
