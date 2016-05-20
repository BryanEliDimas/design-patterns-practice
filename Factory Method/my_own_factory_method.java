/* Factory Method design pattern

Creator (abstract)    = declares the Factory Method
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

public abstract class Creator { // the Factory // an abstraction
  // <the> factoryMethod in Factory that subclasses must override to implement
  protected abstract Product factoryMethod();
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
  // will be cast to its parent class Creator

  // ConcreteCreator knows about ConcreteProduct, but returns it as a Product
  protected Product factoryMethod(){
    return new ConcreteProduct();
  }
}

//_______________________//
//// END of concretions //
/////////////////////////

// This is the code we care about, but it is implicit in the documentation for this pattern
// The client of Creator because it uses Creator
// - the extensible part of the system
// ---- EXTENSIBLE = POLYMORPHISM, not adding new methods
// - easy to test
public class BusinessLogic {
  public BusinessLogic(Creator creator) { // this is the strategy pattern at play
    // store creator
  }

  public void setCreator(Creator creator) { ... }

  public void doWork() {
    // some business logic
    _creator.anOperation();
    // some more business logic
  }
}


public class Client {
  public static void main(String args[]) {

    // magic trick // extends Creator
    Creator creator = new ConcreteCreator();
    BusinessLogic app = new BusinessLogic(creator);
    app.doWork(); // the cool useful operation exists in BusinessLogic

  }
}
