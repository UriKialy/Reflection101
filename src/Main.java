import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Class C1 = int.class; // reflection can work on a primitive type
        System.out.println(C1.getName());


        Dog dog1 = new Dog("Dubi", 7, "Dor");
        Class dog1Class =dog1.getClass();
        System.out.println(dog1.getName());

        Constructor[] Constructors = dog1Class.getConstructors();    //an array of the constructor
        Constructor[] allConstructors = dog1Class.getDeclaredConstructors();//same but include the private
        Method[] allMethods = dog1.getClass().getDeclaredMethods(); //an array of the methods that  include the private
        ArrayList<Parameter> Parameters = new ArrayList<Parameter>(); //an array of the Parameters
        ArrayList<Parameter> PrivateParameters = new ArrayList<Parameter>(); //same but include the private
        Field[] fields = dog1.getClass().getFields(); //an array of the fields

        System.out.println("the constructors are:");
        for (Constructor constructor : Constructors) {    //print the ctor and the param's
            System.out.println(constructor.getName());
            Parameters.addAll(Arrays.asList(constructor.getParameters()));
        }

        System.out.println("the  private constructors are:");
        for (Constructor PrivateConstructor : allConstructors) {
            if (!Arrays.asList(Constructors).contains(PrivateConstructor)) { // if this ctor is not in the regular array
                System.out.println(PrivateConstructor.getName());  //print the ctor
                PrivateParameters.addAll(Arrays.asList(PrivateConstructor.getParameters()));
            }
        }
        System.out.println("the Parameters are:");
        for (Parameter Parameter : Parameters) {
            System.out.println(Parameter.getName() + " " + Parameter.getType().getName()); //print the param's and their type
        }
        System.out.println("the private Parameters are:");
        for (Parameter PrivateParameter : PrivateParameters) {
            if ((!Arrays.asList(Parameters).contains(PrivateParameter))) //if the param is private, print it
                System.out.println(PrivateParameter.getName() + " " + PrivateParameter.getType().getName());
        }
        System.out.println("the methods are:");
        for (int i = 0; i < allMethods.length; i++) {
            System.out.println(allMethods[i].getName());
            if (allMethods[i].getName().equals("sit")) {
                allMethods[i].setAccessible(true);
                allMethods[i].invoke(dog1);
            }

        }
        System.out.println("the fields are:");
        for (Field field : fields) {
            System.out.println(field.getName());
            if (field.getName().equals("owner")) {
                field.setAccessible(true);
                field.set(dog1, "mike");
                System.out.println(dog1.owner);
            }
        }

    }
}
