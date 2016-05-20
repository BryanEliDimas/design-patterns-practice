/*
  Abstract Factory pattern in Java
 */

/* BEGIN abstractions
  - 1 abstract factory but it could create several -different- abstract products */
abstract class AbstractFactory{
  // family of abstract products
  abstract AbstractProduct createProduct(); // One type of Product, but there could be more
  // ... more types of abstract products, if desired
}

abstract class AbstractProduct{
  // BEHAVIOR for products
	public abstract void doSomething();
	public abstract void doSomethingElse();
}
/* END of abstractions */


/* BEGIN Concrete Product-s
  - Could be several concrete products for EACH abstract product */
class Product1 extends AbstractProduct{
	Product1(String arg){
		System.out.println("Hello "+arg);
	}
	public void doSomething() {};
	public void doSomethingElse() {};
}

class Product2 extends AbstractProduct{
	Product2(String arg){
		System.out.println("Hello "+arg);
	}
	public void doSomething() {};
	public void doSomethingElse() {};
}
/* END of Concrete Product-s */


/* BEGIN Concrete Factories
 - Could be several concrete factories for the ONE abstract factory
 - Concrete Factories create Concrete Products but return them as Abstract Products */
class ConcreteFactory1 extends AbstractFactory{
	AbstractProduct createProduct(){
		return new Product1("Product1");
	}
}

class ConcreteFactory2 extends AbstractFactory{
	AbstractProduct createProduct(){
		return new Product2("Product2");
	}
}
/* END of Concrete Factories */

// Factory creator - an indirect way of instantiating the factories
class FactoryMaker{
	private static AbstractFactory;

	static AbstractFactory getFactory1(){
		return new ConcreteFactory1(); // Implements (overrides) createProduct() from the AbstractProduct
	}

	static AbstractFactory getFactory2(){
		return new ConcreteFactory2(); // Implements (overrides) createProduct() from the AbstractProduct
	}
}

// Client
//// interacts only with abstractions
//// thanks to FactoryMaker which deals with concretions and gives us abstractions
public class Client{
	public static void main(String args[]){
		AbstractFactory aff1 = FactoryMaker.getFactory1();
		AbstractFactory aff2 = FactoryMaker.getFactory2();

		AbstractProduct product1 = aff1.createProduct();
		AbstractProduct product2 = aff2.createProduct();

    // do things with Abstract Products
	}
}
