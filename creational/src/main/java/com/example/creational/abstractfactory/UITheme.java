package com.example.creational.abstractfactory;

/**
 * Abstract Factory for creating families of related UI components.
 * Ensures consistent theming across different platforms.
 *
 * <p>This pattern is used in GUI frameworks like Swing, SWT, and cross-platform
 * UI libraries to maintain visual consistency.
 *
 * <p>Benefits:
 * - Ensures product families are compatible
 * - Easy to switch entire themes/platforms
 * - Encapsulates platform-specific creation logic
 *
 * <p>Trade-offs:
 * - Adding new products requires changing all factories
 * - Can become complex with many product types
 *
 * <p>Time Complexity: O(1) - simple instantiation
 * <p>Space Complexity: O(1) per component
 */
public interface UITheme {
    Button createButton();
    Window createWindow();
    Checkbox createCheckbox();
    TextField createTextField();
}
