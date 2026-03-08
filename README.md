# Design Patterns Lab

This project demonstrates all 23 Gang of Four design patterns in Java 17 with production-ready implementations.

## Creational Patterns

- Singleton: Run `java -cp creational/src/main/java com.example.creational.singleton.Demo`
- Factory Method: Run `java -cp creational/src/main/java com.example.creational.factorymethod.Demo`
- Abstract Factory: Run `java -cp creational/src/main/java com.example.creational.abstractfactory.Demo`
- Builder: Run `java -cp creational/src/main/java com.example.creational.builder.Demo`
- Prototype: Run `java -cp creational/src/main/java com.example.creational.prototype.Demo`

## Structural Patterns

- Adapter: Run `java -cp structural/src/main/java com.example.structural.adapter.Demo`
- Bridge: Run `java -cp structural/src/main/java com.example.structural.bridge.Demo`
- Composite: Run `java -cp structural/src/main/java com.example.structural.composite.Demo`
- Decorator: Run `java -cp structural/src/main/java com.example.structural.decorator.Demo`
- Facade: Run `java -cp structural/src/main/java com.example.structural.facade.Demo`
- Flyweight: Run `java -cp structural/src/main/java com.example.structural.flyweight.Demo`
- Proxy: Run `java -cp structural/src/main/java com.example.structural.proxy.Demo`

## Behavioral Patterns

- Chain of Responsibility: Run `java -cp behavioral/src/main/java com.example.behavioral.chainofresponsibility.Demo`
- Command: Run `java -cp behavioral/src/main/java com.example.behavioral.command.Demo`
- Interpreter: Run `java -cp behavioral/src/main/java com.example.behavioral.interpreter.Demo`
- Iterator: Run `java -cp behavioral/src/main/java com.example.behavioral.iterator.Demo`
- Mediator: Run `java -cp behavioral/src/main/java com.example.behavioral.mediator.Demo`
- Memento: Run `java -cp behavioral/src/main/java com.example.behavioral.memento.Demo`
- Observer: Run `java -cp behavioral/src/main/java com.example.behavioral.observer.Demo`
- State: Run `java -cp behavioral/src/main/java com.example.behavioral.state.Demo`
- Strategy: Run `java -cp behavioral/src/main/java com.example.behavioral.strategy.Demo`
- Template Method: Run `java -cp behavioral/src/main/java com.example.behavioral.templatemethod.Demo`
- Visitor: Run `java -cp behavioral/src/main/java com.example.behavioral.visitor.Demo`

To build: `./gradlew build`

To run a specific demo, use the java command as above (no need to build jars for source execution).

## Study Guide - Recommended Learning Order

### Phase 1: Foundation (Start Here)
1. **Singleton** - Essential for understanding object lifecycle
2. **Factory Method** - Basic object creation patterns
3. **Observer** - Event-driven programming fundamentals
4. **Strategy** - Polymorphism and behavior encapsulation

### Phase 2: Intermediate Patterns
5. **Builder** - Complex object construction
6. **Adapter** - Interface compatibility
7. **Decorator** - Dynamic behavior addition
8. **Iterator** - Collection traversal
9. **Template Method** - Algorithm structure

### Phase 3: Advanced Patterns
10. **Abstract Factory** - Family of related objects
11. **Composite** - Tree structures
12. **Command** - Request encapsulation
13. **State** - Object behavior changes
14. **Proxy** - Access control

### Phase 4: Expert Patterns
15. **Bridge** - Abstraction and implementation decoupling
16. **Prototype** - Object cloning and registries
17. **Flyweight** - Memory optimization
18. **Facade** - Subsystem simplification
19. **Chain of Responsibility** - Request processing chains
20. **Mediator** - Object communication
21. **Memento** - State snapshots
22. **Visitor** - Double dispatch
23. **Interpreter** - Language processing

## PE/Staff Interview Cheat Sheet

### Creational Patterns
- **Singleton**: "One instance, global access, thread-safe lazy initialization"
- **Factory Method**: "Interface for creation, subclasses decide implementation"
- **Abstract Factory**: "Families of related objects, consistent themes"
- **Builder**: "Step-by-step construction, complex objects, immutability"
- **Prototype**: "Clone existing objects, avoid expensive creation"

### Structural Patterns
- **Adapter**: "Interface conversion, incompatible systems integration"
- **Bridge**: "Decouple abstraction from implementation, independent evolution"
- **Composite**: "Tree structures, uniform treatment of individuals/groups"
- **Decorator**: "Dynamic behavior addition, wrapper pattern"
- **Facade**: "Simplified interface to complex subsystems"
- **Flyweight**: "Share common state, reduce memory usage"
- **Proxy**: "Control access, lazy loading, caching"

### Behavioral Patterns
- **Chain of Responsibility**: "Pass requests along handler chain, decoupling sender/receiver"
- **Command**: "Encapsulate requests, undo/redo, parameterization"
- **Interpreter**: "Language grammar representation, expression evaluation"
- **Iterator**: "Sequential access without exposing internals"
- **Mediator**: "Centralized communication, reduce coupling"
- **Memento**: "Capture/restore state without violation, undo mechanism"
- **Observer**: "One-to-many dependency, automatic updates"
- **State**: "Behavior changes with state, eliminate conditionals"
- **Strategy**: "Family of algorithms, interchangeable, OCP"
- **Template Method**: "Algorithm skeleton in superclass, steps in subclasses"
- **Visitor**: "Add operations to classes without modification, double dispatch"

## Anti-patterns - When NOT to Use Design Patterns

### Over-engineering Warning Signs
- **Pattern Fever**: Using patterns just because you know them, not because they're needed
- **Gold Plating**: Adding unnecessary complexity for "future-proofing"
- **Pattern Overkill**: Simple problems solved with complex pattern implementations

### Common Anti-patterns
- **Singleton Abuse**: Using Singleton for global state instead of proper dependency injection
- **God Object**: Classes that know too much or do too much (violates SRP)
- **Anemic Domain Model**: Domain objects with only getters/setters, no behavior
- **Poltergeist**: Classes with no real responsibility, just delegating to others
- **Yo-yo Problem**: Excessive inheritance/navigation through deep hierarchies

### When to Prefer Simplicity
- **Rule of Three**: Don't abstract until you have three use cases
- **YAGNI**: You Aren't Gonna Need It - avoid speculative generality
- **KISS**: Keep It Simple, Stupid - simple solutions are often better
- **Composition over Inheritance**: But sometimes inheritance is simpler

### Modern Alternatives
- **Dependency Injection**: Better than Service Locator pattern
- **Functional Programming**: Lambdas can replace many behavioral patterns
- **Reactive Programming**: RxJava can simplify Observer implementations
- **Aspect-Oriented Programming**: Better for cross-cutting concerns than Decorator

Remember: Design patterns are tools, not goals. Use them when they solve real problems, not just to impress interviewers.
