# Creational Patterns

## Singleton

**Pattern Name and Intent:** Ensures a class has only one instance and provides a global point of access to it.

**Real-world Analogy:** Like the CEO of a company - there's only one, and everyone knows how to contact them.

**When to USE this pattern:**
- When there must be exactly one instance of a class accessible from a well-known access point.
- When the sole instance should be extensible by subclassing without changing client code.
- When the instance should be created only when needed (lazy initialization).

**When NOT to use it:**
- When you need multiple instances of the class.
- When the singleton might need to be replaced with a different implementation at runtime.

**Code Walkthrough:**
- `ThreadSafeSingleton`: Class with private constructor, static volatile instance, and getInstance() method using double-checked locking for thread safety.
- `Demo`: Creates two instances and checks if they are the same (prints true).

**How to Run:** `java -cp creational/src/main/java com.example.creational.singleton.Demo`

**Interview Talking Points:**
- Singleton ensures single instance, useful for resources like database connections or logging.
- Thread-safe implementation uses double-checked locking to avoid performance issues.
- Can be broken by reflection or serialization, so need to handle those cases.

**Staff/PE Interview Questions:**
- How would you implement a thread-safe singleton in a distributed system with multiple JVMs?
- What are the pitfalls of using Singleton with dependency injection frameworks like Spring?
- How can you break a singleton and how do you prevent it?
- When would you prefer enum-based singleton over class-based?

**Common Mistakes:**
- Forgetting thread-safety in multi-threaded environments
- Not handling serialization/deserialization properly
- Using singleton for global state management instead of proper dependency injection
- Making the singleton constructor public by mistake

**Real-world Usage:**
- Database connection pools (HikariCP)
- Logging frameworks (Log4j, SLF4J)
- Configuration managers (Spring's @Configuration)
- Cache managers (Ehcache)

**Pattern Combinations:**
- Factory Method + Singleton: Singleton factory for object creation
- Observer + Singleton: Singleton subject with multiple observers
- Command + Singleton: Singleton command registry

## Factory Method

**Pattern Name and Intent:** Defines an interface for creating an object, but lets subclasses decide which class to instantiate.

**Real-world Analogy:** Like a restaurant menu - you order "pizza", and the kitchen decides which type to make.

**When to USE this pattern:**
- When a class can't anticipate the class of objects it must create.
- When a class wants its subclasses to specify the objects it creates.
- To encapsulate object creation logic.

**When NOT to use it:**
- When the object creation is simple and doesn't need abstraction.
- When there are only a few fixed types and no need for extensibility.

**Code Walkthrough:**
- `Notification`: Interface with send() method.
- `EmailNotification` and `SMSNotification`: Implement Notification.
- `NotificationFactory`: Static method createNotification() that returns the appropriate instance based on type.
- `Demo`: Creates email and SMS notifications and sends messages.

**How to Run:** `java -cp creational/src/main/java com.example.creational.factorymethod.Demo`

**Interview Talking Points:**
- Factory Method allows subclasses to decide object creation, promoting loose coupling.
- Useful for frameworks where client code shouldn't know concrete classes.
- Can be combined with other patterns like Singleton for factories.

**Staff/PE Interview Questions:**
- How does Factory Method differ from Abstract Factory?
- How would you implement a factory that supports dynamic plugin loading?
- What are the benefits of enum-based factories over string-based?
- How do you handle factory method in inheritance hierarchies?

**Common Mistakes:**
- Using string-based factory methods without validation
- Not considering thread-safety in factory registries
- Making factories too complex with too many responsibilities
- Forgetting to handle unknown types gracefully

**Real-world Usage:**
- JDBC DriverManager.getConnection()
- Java's Calendar.getInstance()
- Spring's BeanFactory
- SLF4J LoggerFactory

**Pattern Combinations:**
- Factory Method + Singleton: Singleton factory instance
- Factory Method + Builder: Factory creates builders
- Factory Method + Prototype: Factory clones prototypes

## Builder

**Pattern Name and Intent:** Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

**Real-world Analogy:** Like ordering a custom burger - you specify toppings step by step, and the builder assembles it.

**When to USE this pattern:**
- When the algorithm for creating a complex object should be independent of the parts that make up the object.
- When the construction process must allow different representations of the object.
- To avoid telescoping constructors with many parameters.

**When NOT to use it:**
- When the object is simple and doesn't have many optional parts.
- When performance is critical and the builder adds overhead.

**Code Walkthrough:**
- `Order`: Class with fields item, quantity, price, and getters.
- `OrderBuilder`: Class with methods to set fields fluently, and build() to create Order.
- `Demo`: Uses builder to create an Order and prints the item.

**How to Run:** `java -cp creational/src/main/java com.example.creational.builder.Demo`

**Interview Talking Points:**
- Builder pattern helps construct complex objects step by step, improving readability.
- Useful for immutable objects or when there are many optional parameters.
- Fluent interface makes the code more readable and less error-prone.

**Staff/PE Interview Questions:**
- How does Builder pattern handle validation of complex objects?
- What's the difference between Builder and Factory patterns?
- How would you implement a fluent builder API?
- When should you use inner static builder classes?

**Common Mistakes:**
- Not validating parameters in builder methods
- Making builders mutable after build()
- Forgetting to make the product class immutable
- Overusing builder for simple objects

**Real-world Usage:**
- Java's StringBuilder
- HTTP client libraries (OkHttp Request.Builder)
- JSON builders (Jackson ObjectMapper)
- SQL query builders (JOOQ)

**Pattern Combinations:**
- Builder + Factory: Factory creates builders
- Builder + Singleton: Singleton builder instances
- Builder + Prototype: Builder clones and modifies prototypes

## Prototype

**Pattern Name and Intent:** Specifies the kinds of objects to create using a prototypical instance, and creates new objects by copying this prototype.

**Real-world Analogy:** Like photocopying a document - you make copies of the original.

**When to USE this pattern:**
- When the classes to instantiate are specified at run-time.
- To avoid building a class hierarchy of factories that parallels the class hierarchy of products.
- When instances of a class can have only a few different combinations of state.

**When NOT to use it:**
- When object creation is simple and doesn't involve complex state.
- When deep copying is expensive or not needed.

**Code Walkthrough:**
- `GameCharacter`: Abstract class with clone() method using super.clone().
- `Warrior` and `Mage`: Subclasses with attack() method.
- `Demo`: Creates a warrior, clones it, and calls attack on the clone.

**How to Run:** `java -cp creational/src/main/java com.example.creational.prototype.Demo`

**Interview Talking Points:**
- Prototype allows creating objects by cloning, useful for expensive object creation.
- Requires implementing Cloneable and handling deep vs shallow copy.
- Good for scenarios where object initialization is costly.

**Staff/PE Interview Questions:**
- How do you decide between shallow and deep cloning?
- How would you implement prototype registry for performance?
- What are the issues with cloning and how to solve them?
- How does Prototype pattern work with serialization?

**Common Mistakes:**
- Not implementing Cloneable properly
- Forgetting deep clone for mutable objects
- Not handling circular references in deep cloning
- Using clone() for complex object graphs

**Real-world Usage:**
- Java's Object.clone()
- Prototype-based JavaScript objects
- Game object pooling (Unity's Instantiate)
- Document cloning in office suites

**Pattern Combinations:**
- Prototype + Factory: Factory uses prototypes
- Prototype + Singleton: Singleton prototype registry
- Prototype + Builder: Builder modifies cloned prototypes

## Abstract Factory

**Pattern Name and Intent:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**Real-world Analogy:** Like a furniture store - you choose a style (modern or traditional), and get matching chair, table, etc.

**When to USE this pattern:**
- When a system should be independent of how its products are created, composed, and represented.
- When a system must use only one of a set of families of products.
- To enforce consistency among products.

**When NOT to use it:**
- When there is only one product family.
- When the products don't have dependencies.

**Code Walkthrough:**
- `UITheme`: Interface with createButton() and createWindow().
- `Button` and `Window`: Interfaces.
- `WindowsTheme` and `MacTheme`: Implement UITheme with inner classes for Button and Window.
- `Demo`: Creates WindowsTheme and renders a button.

**How to Run:** `java -cp creational/src/main/java com.example.creational.abstractfactory.Demo`

**Interview Talking Points:**
- Abstract Factory creates families of related objects, ensuring consistency.
- Useful for cross-platform UIs or themes.
- Can be extended with new families without changing client code.

**Staff/PE Interview Questions:**
- How does Abstract Factory scale when you have many product families?
- What's the difference between Abstract Factory and Factory Method?
- How would you implement Abstract Factory for plugin architectures?
- When would you choose Abstract Factory over dependency injection?

**Common Mistakes:**
- Adding new products requires changing all factories
- Not clearly defining product family boundaries
- Making factories too large and complex
- Forgetting to implement all product creation methods

**Real-world Usage:**
- Java's AWT/Swing look and feel
- Cross-platform UI toolkits (Qt, GTK)
- Database abstraction layers (JDBC)
- Game development engines (Unity's factory systems)

**Pattern Combinations:**
- Abstract Factory + Singleton: Singleton factory instances
- Abstract Factory + Builder: Factory creates builders for complex products
- Abstract Factory + Prototype: Factory clones product families
