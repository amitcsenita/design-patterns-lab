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

## Bridge

**Pattern Name and Intent:** Decouples an abstraction from its implementation so that the two can vary independently.

**Real-world Analogy:** Like a TV remote and TV - the remote (abstraction) can control different TV brands (implementations).

**When to USE this pattern:**
- When you want to avoid a permanent binding between an abstraction and its implementation.
- When both the abstractions and their implementations should be extensible by subclassing.
- To share an implementation among multiple objects.

**When NOT to use it:**
- When there is only one implementation.
- When changes in abstraction don't affect implementation.

**Code Walkthrough:**
- `DrawingAPI`: Interface for drawing operations.
- `RasterDrawing`, `VectorDrawing`: Implement DrawingAPI.
- `Shape`: Abstract class with DrawingAPI.
- `Circle`, `Square`: Extend Shape, delegate drawing to API.
- `Demo`: Creates shapes with different drawing APIs.

**How to Run:** `java -cp structural/src/main/java com.example.structural.bridge.Demo`

**Interview Talking Points:**
- Bridge separates abstraction from implementation.
- Allows both to evolve independently.
- Useful for cross-platform development.

**Staff/PE Interview Questions:**
- How does Bridge pattern differ from Adapter pattern?
- How would you implement Bridge for cross-platform GUI development?
- What are the benefits of separating abstraction from implementation?
- How does Bridge pattern support the Open/Closed Principle?

**Common Mistakes:**
- Confusing Bridge with Adapter
- Not clearly separating abstraction from implementation
- Making implementations depend on abstractions
- Overusing Bridge for simple cases

**Real-world Usage:**
- Java's JDBC drivers (DriverManager abstraction, vendor implementations)
- GUI toolkits (Swing/AWT abstractions, platform implementations)
- Device drivers (hardware abstraction layer)
- Plugin architectures

**Pattern Combinations:**
- Bridge + Abstract Factory: Factory creates bridged components
- Bridge + Builder: Builder constructs bridged objects
- Bridge + Strategy: Implementation varies by strategy

## Flyweight

**Pattern Name and Intent:** Uses sharing to support large numbers of fine-grained objects efficiently.

**Real-world Analogy:** Like a word processor sharing font objects - many characters use the same font instance.

**When to USE this pattern:**
- When an application uses a large number of objects.
- When storage costs are high because of the sheer quantity of objects.
- When most object state can be made extrinsic.

**When NOT to use it:**
- When objects don't have intrinsic state to share.
- When the number of objects is small.

**Code Walkthrough:**
- `TreeType`: Shared state (name, color, texture).
- `TreeFactory`: Map to reuse TreeType instances.
- `Tree`: Extrinsic state (x, y), references TreeType.
- `Forest`: Plants trees, reuses types.
- `Demo`: Plants multiple trees, some sharing types.

**How to Run:** `java -cp structural/src/main/java com.example.structural.flyweight.Demo`

**Interview Talking Points:**
- Flyweight reduces memory usage by sharing common state.
- Distinguishes intrinsic (shared) and extrinsic (unique) state.
- Useful for games or text editors with many similar objects.

**Staff/PE Interview Questions:**
- How do you identify intrinsic vs extrinsic state?
- How would you scale Flyweight for distributed systems?
- What are the memory trade-offs of Flyweight pattern?
- How does Flyweight relate to object pooling?

**Common Mistakes:**
- Not separating intrinsic from extrinsic state properly
- Making flyweights mutable
- Forgetting thread-safety in shared state
- Over-optimizing when objects aren't numerous enough

**Real-world Usage:**
- Java's String interning
- Game engines (Unity's object pooling)
- Text editors (character formatting)
- GUI components (shared icons/images)

**Pattern Combinations:**
- Flyweight + Factory: Factory manages flyweight instances
- Flyweight + Composite: Composite shares flyweight leaves
- Flyweight + Strategy: Different strategies for different flyweights
