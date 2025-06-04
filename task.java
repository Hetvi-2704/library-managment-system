// class Animal {
//     void bark() {
//         System.out.println("bark");
//     }
// }

// class Dog extends Animal {
//     void bark() {
//         System.out.println("barkingg");
//     }
// }

// public class task {
//     public static void main(String[] args) {
//         Animal dog = new Animal(); 
//         Animal dog2 = new Dog();
//         dog.bark();                
//         dog2.bark();
//     }
// }



// abstract class Animal {
//     abstract void bark();
// }

// class Dog extends Animal {
//     void bark() {
//         System.out.println("barkingg");
//     }
// }
// public class task {
//     public static void main(String[] args) {
//         Animal dog = new Dog(); 
//         dog.bark();                
//     }
// }


// interface Animal {
//     void bark();
// }
// class Dog implements Animal {
//     public void bark() {
//         System.out.println("barkingg");
//     }
// }
// public class task {
//     public static void main(String[] args) {
//         Animal dog = new Dog(); 
//         dog.bark();                
//     }
// }

// //multilevel inheritance
// class Animal {
//     void bark() {
//         System.out.println("bark");
//     }
// }
// class Dog extends Animal {
//     void bark() {
//         System.out.println("barkingg");
//     }
// }
// class puppy extends Dog {
//     void bark() {
//         System.out.println("puppy barking");
//     }
// }
// public class task {
//     public static void main(String[] args) {
//         Animal dog = new Dog(); 
//         dog.bark();                
//         Dog puppy = new puppy();
//         puppy.bark();
//     }
// }

//hierarchical inheritance
// class Animal {
//     void bark() {
//         System.out.println("bark");
//     }
// }
// class Dog extends Animal {
//     void bark() {
//         System.out.println("barkingg");
//     }
// }
// class Cat extends Animal {
//     void bark() {
//         System.out.println("meow");
//     }
// }
// public class task {
//     public static void main(String[] args) {
//         Animal dog = new Dog(); 
//         dog.bark();                
//         Animal cat = new Cat();
//         cat.bark();
//     }
// }


//array
// int[] arr = {1, 2, 3, 4, 5};
// for (int i = 0; i < arr.length; i++) {
//     System.out.println(arr[i]);
// }
// for (int num : arr) {
//     System.out.println(num);
// }
//2d array
// int[][] arr2d = {{1, 2, 3}, {4, 5, 6}};
// for (int i = 0; i < arr2d.length; i++) {
//     for (int j = 0; j < arr2d[i].length; j++) {
//         System.out.println(arr2d[i][j]);
//     }
// }


//List

// import java.util.ArrayList;
// import java.util.List;

// public class task {
//     public static void main(String[] args) {
//         List<Integer> numbers = new ArrayList<>();
//         numbers.add(1);

//         System.out.println(numbers);  // Output: [1]
//     }
// }


//map

// import java.util.Map;
// import java.util.HashMap;

// public class task {
//     public static void main(String[] args) {
//         Map<String, Integer> ages = new HashMap<>();
//         ages.put("Alice", 25);
//         ages.put("Bob", 30);
//         ages.put("Charlie", 25);

//         System.out.println(ages.get("Bob"));  // Output: 30
//     }
// }




// Set
// import java.util.Set;
// import java.util.HashSet;
 
// public class task {
//     public static void main(String[] args) {
//         Set<String> names = new HashSet<>();
//         names.add("Alice");
//         names.add("Bob");
//         names.add("Charlie");
//         names.add("Alice"); // Duplicate, will not be added

//         System.out.println(names);  // Output: [Alice, Bob, Charlie]
//     }
// }



// //singleton
// class singleton{
//     private static singleton instance;

//     private singleton() {
//         // private constructor to prevent instantiation
//     }

//     public static singleton getInstance() {
//         if (instance == null) {
//             instance = new singleton();
//         }
//         return instance;
//     }

//     public void displayMessage() {
//         System.out.println("Singleton instance accessed!");
//     }
// }
// public class task {
//     public static void main(String[] args) {
//         singleton obj1 = singleton.getInstance();
//         singleton obj2 = singleton.getInstance();

//         obj1.displayMessage();  // Output: Singleton instance accessed!
//         System.out.println(obj1 == obj2);  // Output: true, both references point to the same instance
//     }
// }


interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
        System.out.println("Dog says: Woof");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Cat says: Meow");
    }
}

// // Factory
// class AnimalFactory {
//     public static Animal getAnimal(String type) {
//         if (type.equalsIgnoreCase("dog")) {
//             return new Dog();
//         } else if (type.equalsIgnoreCase("cat")) {
//             return new Cat();
//         }
//         return null;
//     }
// }

// // Main
// public class task {
//     public static void main(String[] args) {
//         Animal a1 = AnimalFactory.getAnimal("dog");
//         a1.speak();

//         Animal a2 = AnimalFactory.getAnimal("cat");
//         a2.speak();
//     }
// }
class Car {
    private String engine;
    private int wheels;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
    }

    public void showDetails() {
        System.out.println("Engine: " + engine + ", Wheels: " + wheels);
    }

    public static class Builder {
        private String engine;
        private int wheels;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

public class task {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                    .setEngine("V8")
                    .setWheels(4)
                    .build();
        car.showDetails();  // Output: Engine: V8, Wheels: 4
    }
}
