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

// This is the code we care about, but it is implicit in the documentation for this pattern
// The client because it uses Creator
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

    // magic trick // extends Creator, where the cool useful operations exist
    Creator creator = new ConcreteCreator();
    BusinessLogic app = new BusinessLogic(creator);
    app.anOperation(); // the cool useful operation exists in Creator (aka. Factory)

  }
}
