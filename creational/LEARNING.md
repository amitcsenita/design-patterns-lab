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
