# Structural Patterns

## Adapter

**Pattern Name and Intent:** Converts the interface of a class into another interface clients expect.

**Real-world Analogy:** Like a travel adapter - plugs into different socket types.

**When to USE this pattern:**
- When you want to use an existing class, but its interface doesn't match what you need.
- To create a reusable class that cooperates with unrelated or unforeseen classes.
- To adapt a class's interface without modifying it.

**When NOT to use it:**
- When you can modify the existing class.
- When the interfaces are already compatible.

**Code Walkthrough:**
- `LegacyAPI`: Class with oldMethod().
- `ModernAPI`: Interface with newMethod().
- `APIAdapter`: Implements ModernAPI, wraps LegacyAPI, calls oldMethod() in newMethod().
- `Demo`: Creates adapter and calls newMethod().

**How to Run:** `java -cp structural/src/main/java com.example.structural.adapter.Demo`

**Interview Talking Points:**
- Adapter allows incompatible interfaces to work together.
- Object adapter uses composition, class adapter uses inheritance.
- Useful for legacy code integration.

## Decorator

**Pattern Name and Intent:** Attaches additional responsibilities to an object dynamically.

**Real-world Analogy:** Like adding toppings to a pizza - each topping decorates the base.

**When to USE this pattern:**
- To add responsibilities to individual objects dynamically and transparently.
- When extension by subclassing is impractical.
- To avoid class explosion from many combinations.

**When NOT to use it:**
- When the added responsibilities are fixed and not dynamic.
- When performance is critical.

**Code Walkthrough:**
- `Coffee`: Interface with cost(), description().
- `SimpleCoffee`: Implements Coffee.
- `MilkDecorator`, `SugarDecorator`: Implement Coffee, wrap another Coffee, add to cost/description.
- `Demo`: Creates SimpleCoffee, decorates with Milk, prints.

**How to Run:** `java -cp structural/src/main/java com.example.structural.decorator.Demo`

**Interview Talking Points:**
- Decorator adds behavior dynamically without subclassing.
- Useful for I/O streams or UI components.
- Can be stacked for multiple decorations.

## Facade

**Pattern Name and Intent:** Provides a unified interface to a set of interfaces in a subsystem.

**Real-world Analogy:** Like a universal remote - controls multiple devices with one interface.

**When to USE this pattern:**
- To provide a simple interface to a complex subsystem.
- To decouple clients from subsystem components.
- To layer subsystems.

**When NOT to use it:**
- When the subsystem is simple and doesn't need simplification.
- When clients need direct access to subsystem parts.

**Code Walkthrough:**
- `Projector`, `SoundSystem`: Classes with on/off().
- `HomeTheaterFacade`: Wraps them, startMovie() calls on(), endMovie() calls off().
- `Demo`: Creates facade, starts movie.

**How to Run:** `java -cp structural/src/main/java com.example.structural.facade.Demo`

**Interview Talking Points:**
- Facade simplifies complex subsystems.
- Useful for libraries or APIs with many classes.
- Can hide implementation details.

## Proxy

**Pattern Name and Intent:** Provides a surrogate or placeholder for another object to control access to it.

**Real-world Analogy:** Like a credit card - represents access to your bank account.

**When to USE this pattern:**
- To control access to an object.
- When you need lazy initialization or caching.
- For remote proxies or virtual proxies.

**When NOT to use it:**
- When direct access is fine.
- When the proxy adds unnecessary complexity.

**Code Walkthrough:**
- `DatabaseConnection`: Interface with connect().
- `DatabaseProxy`: Implements DatabaseConnection, lazy initializes RealDatabaseConnection.
- `RealDatabaseConnection`: Inner class implementing connect().
- `Demo`: Creates proxy, connects.

**How to Run:** `java -cp structural/src/main/java com.example.structural.proxy.Demo`

**Interview Talking Points:**
- Proxy controls access, useful for security or performance.
- Types: virtual, protection, remote.
- Can add logging or caching transparently.

## Composite

**Pattern Name and Intent:** Composes objects into tree structures to represent part-whole hierarchies.

**Real-world Analogy:** Like a file system - directories contain files or other directories.

**When to USE this pattern:**
- To represent part-whole hierarchies of objects.
- When clients should treat individual and composite objects uniformly.
- To ignore the difference between compositions of objects and individual objects.

**When NOT to use it:**
- When the hierarchy is fixed and simple.
- When performance is critical for leaf operations.

**Code Walkthrough:**
- `FileSystem`: Interface with showDetails().
- `File`: Implements FileSystem, shows name.
- `Directory`: Implements FileSystem, has list of children, shows recursively.
- `Demo`: Creates root directory, adds file and subdir, shows details.

**How to Run:** `java -cp structural/src/main/java com.example.structural.composite.Demo`

**Interview Talking Points:**
- Composite treats individual and groups uniformly.
- Useful for tree structures like menus or graphics.
- Requires careful handling of operations on composites.
