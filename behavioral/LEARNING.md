# Behavioral Patterns

## Observer

**Pattern Name and Intent:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

**Real-world Analogy:** Like subscribing to a newsletter - when there's new content, all subscribers get notified.

**When to USE this pattern:**
- When an abstraction has two aspects, one dependent on the other, and you want to encapsulate them.
- To avoid tight coupling between subject and observers.
- When changes to one object require changing others, and you don't know how many.

**When NOT to use it:**
- When there are few observers and tight coupling is acceptable.
- When notifications are frequent and performance is a concern.

**Code Walkthrough:**
- `Observer`: Interface with update() method.
- `Subject`: Class with list of observers, add/remove, notifyObservers().
- `Stock`: Extends Subject, setPrice() calls notifyObservers().
- `Investor`: Implements Observer, prints message on update.
- `Demo`: Creates stock, adds investor, changes price.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.observer.Demo`

**Interview Talking Points:**
- Observer pattern enables loose coupling between subject and observers.
- Useful for event-driven systems like GUI or pub-sub.
- Can lead to memory leaks if observers aren't removed properly.

## Strategy

**Pattern Name and Intent:** Defines a family of algorithms, encapsulates each one, and makes them interchangeable.

**Real-world Analogy:** Like choosing payment methods - credit card, PayPal, etc., at checkout.

**When to USE this pattern:**
- When many related classes differ only in their behavior.
- To configure a class with one of many behaviors.
- To avoid using multiple conditional statements.

**When NOT to use it:**
- When there are only a few behaviors and they don't change.
- When the algorithms are tightly coupled to the context.

**Code Walkthrough:**
- `PaymentStrategy`: Interface with pay() method.
- `CreditCard`, `PayPal`, `Crypto`: Implement PaymentStrategy.
- `Demo`: Creates CreditCard strategy and pays.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.strategy.Demo`

**Interview Talking Points:**
- Strategy allows selecting algorithms at runtime, promoting OCP.
- Useful for sorting algorithms or payment processing.
- Composition over inheritance for behavior variation.

## Command

**Pattern Name and Intent:** Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

**Real-world Analogy:** Like a remote control - each button is a command that controls a device.

**When to USE this pattern:**
- To parameterize objects with operations.
- To specify, queue, and execute requests at different times.
- To support undo operations.

**When NOT to use it:**
- When operations are simple and don't need queuing or undo.
- When there are no varying requests.

**Code Walkthrough:**
- `Command`: Interface with execute().
- `LightOnCommand`, `ThermostatCommand`: Implement Command.
- `RemoteControl`: Has command, setCommand(), pressButton().
- `Demo`: Sets LightOnCommand and presses button.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.command.Demo`

**Interview Talking Points:**
- Command pattern decouples invoker from receiver, enabling features like undo.
- Useful for menus, toolbars, or transaction systems.
- Can be extended with macro commands.

## Iterator

**Pattern Name and Intent:** Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

**Real-world Analogy:** Like a TV remote - you can go to next/previous channel without knowing how channels are stored.

**When to USE this pattern:**
- To access an aggregate object's contents without exposing its internal structure.
- To support multiple traversal algorithms.
- To provide a uniform interface for traversing different aggregate structures.

**When NOT to use it:**
- When the aggregate is simple and traversal is straightforward.
- When performance is critical and iterator adds overhead.

**Code Walkthrough:**
- `Playlist`: Has list of songs, iterator() returns PlaylistIterator.
- `PlaylistIterator`: Has hasNext(), next().
- `Demo`: Adds songs, iterates and prints.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.iterator.Demo`

**Interview Talking Points:**
- Iterator provides uniform access to collections, hiding implementation.
- Built into Java as Iterable/Iterator.
- Useful for custom collections or external iteration.

## Template Method

**Pattern Name and Intent:** Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.

**Real-world Analogy:** Like a recipe - the steps are defined, but ingredients can vary.

**When to USE this pattern:**
- To implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary.
- To avoid code duplication by factoring out common behavior.
- When subclasses need to extend the base algorithm.

**When NOT to use it:**
- When the algorithm is fixed and doesn't vary.
- When inheritance is not suitable.

**Code Walkthrough:**
- `DataExporter`: Abstract class with final export() calling openFile(), writeData(), closeFile().
- `CSVExporter`, `JSONExporter`: Implement the abstract methods.
- `Demo`: Creates CSVExporter and exports.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.templatemethod.Demo`

**Interview Talking Points:**
- Template Method uses inheritance to define algorithm structure.
- Useful for frameworks where steps are fixed but implementations vary.
- Promotes code reuse and consistency.

## Chain of Responsibility

**Pattern Name and Intent:** Allows passing requests along a chain of handlers, where each handler decides either to process the request or to pass it to the next handler in the chain.

**Real-world Analogy:** Like customer support levels - if level 1 can't handle, it escalates to level 2.

**When to USE this pattern:**
- When more than one object may handle a request, and the handler isn't known a priori.
- When you want to issue a request to one of several objects without specifying the receiver explicitly.
- To decouple senders and receivers.

**When NOT to use it:**
- When the chain is too long and performance is critical.
- When handlers are not clearly ordered.

**Code Walkthrough:**
- `Handler`: Abstract class with next, handleRequest().
- `SupportTicket`: Class with level.
- `LevelOneSupport`, `LevelTwoSupport`, `LevelThreeSupport`: Handle based on level, pass to next if needed.
- `Demo`: Creates chain, handles tickets of different levels.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.chainofresponsibility.Demo`

**Interview Talking Points:**
- Chain of Responsibility creates a processing pipeline.
- Useful for event handling or middleware.
- Allows dynamic addition/removal of handlers.

**Staff/PE Interview Questions:**
- How would you implement Chain of Responsibility for HTTP request processing?
- What are the performance implications of long chains?
- How do you handle cases where no handler processes the request?
- When would you use Chain vs Decorator pattern?

**Common Mistakes:**
- Making chains too long
- Not handling unprocessed requests
- Breaking the chain when handlers have side effects
- Making handlers stateful

**Real-world Usage:**
- Java's Exception handling chain
- Servlet filters in web frameworks
- Event handling in GUI frameworks
- Middleware in Express.js

**Pattern Combinations:**
- Chain of Responsibility + Command: Commands passed along chain
- Chain of Responsibility + Composite: Composite handlers
- Chain of Responsibility + Observer: Handlers notify observers

## Mediator

**Pattern Name and Intent:** Defines an object that encapsulates how a set of objects interact, promoting loose coupling by keeping objects from referring to each other explicitly.

**Real-world Analogy:** Like an air traffic controller - manages communication between planes without them talking directly.

**When to USE this pattern:**
- When objects communicate in complex but well-defined ways.
- When reusing objects is difficult because they refer to and communicate with many other objects.
- To centralize complex communications and control logic.

**When NOT to use it:**
- When objects have simple interactions.
- When the mediator becomes too complex (God object).

**Code Walkthrough:**
- `Mediator`: Interface with sendMessage().
- `ChatRoom`: Implements Mediator, broadcasts messages.
- `User`: Has mediator, send() and receive().
- `Demo`: Creates chatroom, adds users, sends messages.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.mediator.Demo`

**Interview Talking Points:**
- Mediator reduces dependencies between communicating objects.
- Useful for GUI components or chat systems.
- Can simplify maintenance but may centralize too much logic.

**Staff/PE Interview Questions:**
- How does Mediator differ from Observer pattern?
- How would you implement Mediator for a chat application with 1M users?
- What are the drawbacks of centralized communication?
- When should you prefer Mediator over direct communication?

**Common Mistakes:**
- Making mediator too complex (God object)
- Not clearly defining communication protocols
- Forgetting to update mediator when adding new colleagues
- Tight coupling between mediator and colleagues

**Real-world Usage:**
- Air traffic control systems
- Chat applications (mediator manages user communications)
- GUI dialog boxes (widgets communicate through dialog)
- Workflow engines

**Pattern Combinations:**
- Mediator + Observer: Mediator notifies observers of state changes
- Mediator + Command: Commands sent through mediator
- Mediator + State: Mediator changes based on system state

## Memento

**Pattern Name and Intent:** Without violating encapsulation, captures and externalizes an object's internal state so that the object can be restored to this state later.

**Real-world Analogy:** Like undo in a text editor - saves state to allow restoration.

**When to USE this pattern:**
- When a snapshot of an object's state must be saved for later restoration.
- When direct access to the object's fields would violate encapsulation.
- For implementing undo/redo functionality.

**When NOT to use it:**
- When the state is large and expensive to store.
- When the object state changes frequently.

**Code Walkthrough:**
- `Memento`: Class holding state.
- `TextEditor`: Has text, save() returns Memento, restore() sets from Memento.
- `History`: Stack of Mementos, push/pop.
- `Demo`: Writes text, saves, writes more, undoes.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.memento.Demo`

**Interview Talking Points:**
- Memento preserves encapsulation while allowing state snapshots.
- Useful for undo mechanisms or checkpoints.
- Caretaker manages mementos without accessing state.

**Staff/PE Interview Questions:**
- How would you implement undo/redo with Memento in a collaborative editor?
- What are the security implications of Memento pattern?
- How do you handle large state objects in Memento?
- When would you choose Memento over Command for undo?

**Common Mistakes:**
- Storing too much state in mementos
- Not implementing proper encapsulation in memento
- Forgetting to handle memento lifecycle
- Making mementos mutable

**Real-world Usage:**
- Text editors (undo/redo functionality)
- Game save systems
- Database transaction rollbacks
- Version control systems

**Pattern Combinations:**
- Memento + Command: Commands create mementos for undo
- Memento + Iterator: Iterate through memento history
- Memento + Prototype: Clone state for mementos

## State

**Pattern Name and Intent:** Allows an object to alter its behavior when its internal state changes, appearing as if the object changed its class.

**Real-world Analogy:** Like a traffic light - changes behavior (color) based on state.

**When to USE this pattern:**
- When an object's behavior depends on its state, and it must change its behavior at run-time depending on that state.
- When operations have large, multipart conditional statements that depend on the object's state.
- To avoid long switch statements or if-else chains.

**When NOT to use it:**
- When there are few states or simple transitions.
- When state changes are rare.

**Code Walkthrough:**
- `State`: Interface with handle().
- `TrafficLight`: Has state, change() delegates to state.
- `RedState`, `YellowState`, `GreenState`: Implement handle(), set next state.
- `Demo`: Changes traffic light multiple times.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.state.Demo`

**Interview Talking Points:**
- State encapsulates state-specific behavior.
- Useful for state machines or UI states.
- Each state class handles transitions.

**Staff/PE Interview Questions:**
- How would you implement State pattern for TCP connection states?
- What are the benefits of State over large switch statements?
- How do you handle state transitions with complex logic?
- When should you use State vs Strategy pattern?

**Common Mistakes:**
- Making states aware of each other
- Not handling invalid state transitions
- Putting too much logic in state classes
- Forgetting to update context references

**Real-world Usage:**
- TCP state machine
- Vending machines
- Order processing workflows
- Game character states (idle, walking, attacking)

**Pattern Combinations:**
- State + Singleton: Singleton state instances
- State + Flyweight: Shared state objects
- State + Mediator: States communicate through mediator

## Visitor

**Pattern Name and Intent:** Represents an operation to be performed on the elements of an object structure, allowing you to define a new operation without changing the classes of the elements on which it operates.

**Real-world Analogy:** Like a tax inspector visiting businesses - performs operation on each without changing the businesses.

**When to USE this pattern:**
- When you have distinct and unrelated operations to perform on objects in a structure.
- When the object structure rarely changes, but you often add new operations.
- To avoid polluting classes with many operations.

**When NOT to use it:**
- When the element classes change frequently.
- When operations are tightly coupled to element classes.

**Code Walkthrough:**
- `Visitor`: Interface with visit methods.
- `Shape`: Interface with accept().
- `Circle`, `Rectangle`: Implement Shape, accept(visitor) calls visitor.visit(this).
- `AreaCalculator`: Implements Visitor, calculates area for each shape.
- `Demo`: List of shapes, each accepts calculator.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.visitor.Demo`

**Interview Talking Points:**
- Visitor adds operations to classes without modifying them.
- Useful for compilers or object structures with varying operations.
- Double dispatch: visitor and element determine behavior.

**Staff/PE Interview Questions:**
- How does Visitor implement double dispatch?
- How would you add new operations to an existing class hierarchy?
- What are the limitations of Visitor pattern?
- When would you choose Visitor over method overloading?

**Common Mistakes:**
- Modifying element classes to accept visitors
- Making visitors too specific to element types
- Not handling new element types properly
- Creating circular dependencies

**Real-world Usage:**
- Compiler AST traversal
- XML/HTML document processing
- Object serialization frameworks
- Report generation from object structures

**Pattern Combinations:**
- Visitor + Composite: Traverse composite structures
- Visitor + Interpreter: Evaluate expressions
- Visitor + Iterator: Visit elements during iteration

## Interpreter

**Pattern Name and Intent:** Given a language, defines a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

**Real-world Analogy:** Like a calculator parsing expressions - interprets mathematical language.

**When to USE this pattern:**
- When you have a simple language to interpret.
- When efficiency is not a primary concern.
- For parsing and evaluating expressions.

**When NOT to use it:**
- When the grammar is complex or changes frequently.
- When performance is critical (better use parser generators).

**Code Walkthrough:**
- `Expression`: Interface with interpret().
- `NumberExpression`: Returns the number.
- `AddExpression`, `SubtractExpression`: Interpret left and right, add/subtract.
- `Demo`: Builds expression tree, interprets result.

**How to Run:** `java -cp behavioral/src/main/java com.example.behavioral.interpreter.Demo`

**Interview Talking Points:**
- Interpreter parses and evaluates language grammars.
- Useful for DSLs or expression evaluators.
- Can be combined with Composite for expression trees.

**Staff/PE Interview Questions:**
- How would you implement a SQL parser using Interpreter?
- What are the performance issues with Interpreter pattern?
- How do you handle operator precedence in Interpreter?
- When should you use Interpreter vs parser generators?

**Common Mistakes:**
- Creating too many classes for grammar rules
- Not handling parsing errors properly
- Making the grammar too complex
- Forgetting to validate input

**Real-world Usage:**
- Regular expression engines
- Mathematical expression evaluators
- Configuration file parsers
- Simple scripting languages

**Pattern Combinations:**
- Interpreter + Composite: Expression trees
- Interpreter + Visitor: Evaluate expressions
- Interpreter + Flyweight: Share terminal symbols
