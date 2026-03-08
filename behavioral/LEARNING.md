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
