/*
  Singleton design pattern
*/

public class SingleObject {

  // create an object of SingleObject
  private static SingleObject instance = new SingleObject();

  // make the constructor private
  private SingleObject(){}

  public static SingleObject getInstance(){
    return instance;
  }

  public void showMessage(){
    System.out.println("Hello World of Design Patterns");
  }
}


public class SingletonPatternDemo {
  public static void main(String args[]){

    SingleObject object = SingleObject.getInstance();

    object.showMessage();
  }
}
