import java.util.*;
import java.sql.*; // for JDBC

// ===================== DAY 1: BASICS & OOPS PRINCIPLES =====================

/*
================= Classes =================
- Classes are blueprints for objects.
- They encapsulate data (fields) and behaviors (methods).
- Objects are instances of classes.
- Fields hold the object's state.
- Methods define actions or behavior.

Example:
A 'Car' class might have fields like color, model and methods like drive(), stop().
*/

class Car {
    String color;
    String model;

    void drive() {
        System.out.println(model + " run.");
    }
}

// public class Main {
//     public static void main(String[] args) {
//         Car myCar = new Car();

//         myCar.color = "red";
//         myCar.model = "toyoto";

//         myCar.drive();
//     }
// }

/*
================= Inheritance =================
- Inheritance allows a class (child/subclass) to acquire properties and methods of another class (parent/superclass).
- Enables code reuse and method overriding.
- Types of inheritance in Java:
  a) Single inheritance (one parent)
  b) Multilevel inheritance (grandparent-parent-child)
  c) Hierarchical inheritance (multiple children from one parent)

Example:
Class Dog inherits Animal, Dog can use Animal's methods and have its own.
*/

class Animal {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking.");
    }
}

/*
================= Abstract Classes =================
- Cannot create instances directly.
- Can have abstract methods (methods without body) that subclasses must implement.
- Can also have concrete methods with implementation.
- Used when you want a base class that provides partial implementation.

Example:
Abstract class Shape with abstract method draw().
*/
// abstract class Shape {
//     // Abstract method: must be implemented by subclasses
//     abstract void draw();

//     // Normal method: can be called directly
//     void info() {
//         System.out.println("This is a shape.");
//     }
// }

// class Rectangle extends Shape {
//     // Implementing abstract method
//     void draw() {
//         System.out.println("Drawing a rectangle.");
//     }
// }

// public class Learn {
//     public static void main(String[] args) {
//         // You cannot create an object of Shape directly,
//         // but you can create an object of Rectangle (which extends Shape)
//         Shape myshape = new Rectangle();

//         myshape.info();  // Calls the concrete method from Shape
//         myshape.draw();  // Calls the overridden method in Rectangle
//     }
// }

/*
================= Interfaces =================
- Define methods that a class must implement.
- All methods are implicitly abstract (until Java 8 default methods).
- Supports multiple inheritance (a class can implement multiple interfaces).
- Used for abstraction and to define contracts.

Example:
Interface Drawable with method draw().
*/

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}


// ===================== DAY 2: BASICS OF COLLECTIONS =====================

/*
================= Arrays =================
- Fixed size data structure holding elements of same type.
- Accessed by index starting at 0.
- Fast access but size is fixed.

Example:
An integer array holding 3 numbers.
*/

class ArraysExample {
    void demo() {
        int[] nums = {10, 20, 30};
        System.out.println("First element: " + nums[0]);
    }
}

/*
================= List =================
- Ordered collection allowing duplicates.
- Implemented by ArrayList, LinkedList etc.
- Supports dynamic resizing.

Example:
List of strings storing fruits with duplicates allowed.
*/

class ListExample {
    void demo() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Apple");  // duplicate allowed
        fruits.add("Banana");
        System.out.println("List: " + fruits);
    }
}

/*
================= Set =================
- Collection that stores unique elements (no duplicates).
- Implementations: HashSet (unordered), TreeSet (sorted).

Example:
Set of names where duplicates are ignored.
*/

class SetExample {
    void demo() {
        Set<String> names = new HashSet<>();
        names.add("Alice");
        names.add("Alice");  // ignored duplicate
        names.add("Bob");
        System.out.println("Set: " + names);
    }
}

/*
================= Map =================
- Stores key-value pairs.
- Keys are unique; values can be duplicated.
- Common implementations: HashMap, TreeMap.

Example:
Map of Integer keys to String values.
*/

class MapExample {
    void demo() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println("Value for key 1: " + map.get(1));
    }
}


// ===================== DAY 3: EXCEPTIONS, DESIGN PATTERNS, THREADS =====================

/*
================= Exception Handling =================
- Exceptions handle runtime errors.
- try-catch blocks catch exceptions.
- finally block runs always.
- Checked exceptions must be declared or caught.

Example:
Catch divide by zero error.
*/

class ExceptionExample {
    void demo() {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}

/*
================= Singleton Pattern =================
- Ensures only one instance of a class.
- Provides global access to that instance.
- Used for configurations, logging, etc.
*/

class Singleton {
    private static Singleton instance;

    private Singleton() {
        
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    void show() {
        System.out.println("Singleton instance hashcode: " + this.hashCode());
    }
}
// class DatabaseManager {
//     private static DatabaseManager db;

//     private DatabaseManager() {
//         System.out.println("Database connected");
//     }

//     public static DatabaseManager getInstance() {
//         if (db == null)
//         { 
//             db = new DatabaseManager();
//         }
//         return db;
//     }

//     void query(String sql) {
//         System.out.println("Running query: " + sql);
//     }
// }

// public class App {
//     public static void main(String[] args) {
//         DatabaseManager db1 = DatabaseManager.getInstance();
//         db1.query("SELECT * FROM users");

//         DatabaseManager db2 = DatabaseManager.getInstance();
//         db2.query("SELECT * FROM orders");

//         System.out.println(db1 == db2); // true — same database object
//     }
// }

/*
================= Factory Pattern =================
- Creates objects without exposing the creation logic.
- Returns objects based on input parameters.
*/

interface ShapeInterface {
    void draw();
}

class CircleShape implements ShapeInterface {
    public void draw() {
        System.out.println("Factory: Drawing Circle");
    }
}

class SquareShape implements ShapeInterface {
    public void draw() {
        System.out.println("Factory: Drawing Square");
    }
}

class ShapeFactory {
    public ShapeInterface getShape(String type) {
        if ("circle".equalsIgnoreCase(type)) {
            return new CircleShape();
        } else if ("square".equalsIgnoreCase(type)) {
            return new SquareShape();
        }
        return null;
    }
}

/*
================= Builder Pattern =================
- Creates complex objects step-by-step.
- Useful for immutable or objects with many parameters.
*/

class User {
    private String name;
    private int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public void show() {
        System.out.println("User: " + name + ", Age: " + age);
    }

    static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

/*
================= Threads =================
- Thread allows concurrent execution.
- Create by extending Thread or implementing Runnable.
- Use start() to run thread.
*/

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running.");
    }
}


// ===================== DAY 4: JDBC & JDBC TEMPLATE =====================

/*
================= JDBC (Java Database Connectivity) =================
- API to connect and execute queries on databases.
- Basic steps:
   1) Load driver (optional for modern drivers)
   2) Establish connection
   3) Create statement
   4) Execute queries
   5) Process results
   6) Close resources

- Requires external database and driver setup.
*/

// JDBC example (in comments, needs database to run)
/*

public class JDBCSample {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load driver (optional)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");

            // Create statement
            stmt = conn.createStatement();

            // Execute query
            rs = stmt.executeQuery("SELECT * FROM users");

            // Process results
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}

*/

/*
================= JDBC Template =================
- Part of Spring Framework.
- Simplifies JDBC by handling connection, exception, and resource management.
- Uses callbacks for executing queries.
- Not available in standard Java SE.
*/


// ===================== MAIN CLASS TO RUN EXAMPLES =====================

public class Learn {
    public static void main(String[] args) {

        System.out.println("=== Day 1: Classes ===");
        Car car = new Car();
        car.model = "Toyota";
        car.color = "Red";
        car.drive();

        System.out.println("\n=== Day 1: Inheritance ===");
        Dog dog = new Dog();
        dog.eat();  // inherited
        dog.bark();

        System.out.println("\n=== Day 1: Abstract Classes ===");
        Shape rect = new Rectangle();
        rect.info();
        rect.draw();

        System.out.println("\n=== Day 1: Interfaces ===");
        Drawable circle = new Circle();
        circle.draw();

        System.out.println("\n\n=== Day 2: Arrays ===");
        ArraysExample arrEx = new ArraysExample();
        arrEx.demo();

        System.out.println("\n=== Day 2: List ===");
        ListExample listEx = new ListExample();
        listEx.demo();

        System.out.println("\n=== Day 2: Set ===");
        SetExample setEx = new SetExample();
        setEx.demo();

        System.out.println("\n=== Day 2: Map ===");
        MapExample mapEx = new MapExample();
        mapEx.demo();

        System.out.println("\n\n=== Day 3: Exception Handling ===");
        ExceptionExample excEx = new ExceptionExample();
        excEx.demo();

        System.out.println("\n=== Day 3: Singleton Pattern ===");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.show();
        s2.show();
        System.out.println("Singletons are same instance: " + (s1 == s2));

        System.out.println("\n=== Day 3: Factory Pattern ===");
        ShapeFactory factory = new ShapeFactory();
        ShapeInterface shape1 = factory.getShape("circle");
        ShapeInterface shape2 = factory.getShape("square");
        shape1.draw();
        shape2.draw();

        System.out.println("\n=== Day 3: Builder Pattern ===");
        User user = new User.Builder().setName("Alice").setAge(30).build();
        user.show();

        System.out.println("\n=== Day 3: Threads ===");
        MyThread thread = new MyThread();
        thread.start();

        // Day 4 JDBC requires database, so omitted running here.
        System.out.println("\n=== Day 4: JDBC ===");
        System.out.println("See JDBC code comments for usage example.");
    }
}
