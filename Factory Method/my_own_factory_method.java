/* Factory Method design pattern

Creator (abstract)    = declares the Factory Method + cool useful operations - it is what Client will work with
Product (interface)   = just an abstraction, but could declare or implement behavior

ConcreteCreator  = overrides the FactoryMethod, inherits the cool useful operations from Creator
ConcreteProduct  = a concretion - it could implement or inherit behavior from the Product interface

*/
/*

FM-CPCC
FM-CaPiCC-i

 */

/////////////////////////////
//// BEGIN abstractions ////
//_______________________//

public abstract class Creator { // the Factory // an abstraction // contains a bunch of cool useful operations
  // knows about Product interface only, not ConcreteProduct's
  public void anOperation(){ // one cool useful operation // not usually overriden by a subclass
    Product product = factoryMethod();
    // ... some cool useful operation with a ConcreteProduct of Product here
  }

  protected abstract Product factoryMethod(); // <the> factoryMethod in Factory that subclasses must override
}

public interface Product {  }

//_______________________//
//// END of abstractions //
//////////////////////////



/////////////////////////////
//// BEGIN concretions /////
//_______________________//

public class ConcreteProduct implements Product {}

public class ConcreteCreator extends Creator {
  // overrides the factoryMethod - to return a concrete product
  // inherits cool useful operations from Creator
  // will be casted to its parent class Creator

  // ConcreteCreator knows about ConcreteProduct, but returns it as a Product
  protected Product factoryMethod(){
    return new ConcreteProduct();
  }
}

//_______________________//
//// END of concretions //
/////////////////////////


public class Client {
  public static void main(String args[]) {

    Creator creator = new ConcreteCreator(); // magic trick // extends Creator, where the cool useful operations exist
    creator.anOperation(); // the cool useful operation exists in Creator (aka. Factory)

  }
}
