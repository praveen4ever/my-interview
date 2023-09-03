package com.interview.solving;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test suite for finding the second largest element in an array")
public class SecondLargestInListTest {

    private SecondLargestInList secondLargestInList;  // Declare instance variable

    @BeforeEach  // This method will run before each test case
    public void setUp() {
        secondLargestInList = new SecondLargestInList();  // Initialize instance variable before each test
    }

    @Test
    @Order(1)
    @DisplayName("Test with duplicate values")
    @Tag("Positive")
    public void duplicateValueTest() throws Exception {
        Assertions.assertEquals(3, secondLargestInList.processv2(new int[]{3, 2, 2, 8, 8}));
    }

    @Test
    @Order(2)
    @DisplayName("Test with single value")
    @Tag("Negative")
    public void singleValueTest() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> secondLargestInList.processv2(new int[]{3}));
        Assertions.assertEquals("not found", exception.getMessage());
    }

    @Test
    @Order(3)
    @DisplayName("Test with all unique values")
    @Tag("Positive")
    public void allUniqueValuesTest() throws Exception {
        Assertions.assertEquals(4, secondLargestInList.processv2(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @Order(4)
    @DisplayName("Test with all same values")
    @Tag("Negative")
    public void allSameValuesTest() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> secondLargestInList.processv2(new int[]{2, 2, 2, 2}));
        Assertions.assertEquals("not found", exception.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName("Test with negative numbers")
    @Tag("Positive")
    public void negativeNumbersTest() throws Exception {
        Assertions.assertEquals(-2, secondLargestInList.processv2(new int[]{-1, -2, -3}));
    }

    @Test
    @Order(6)
    @DisplayName("Test with mixed positive and negative numbers")
    @Tag("Positive")
    public void mixedNumbersTest() throws Exception {
        Assertions.assertEquals(0, secondLargestInList.processv2(new int[]{1, 0, -1}));
    }

    @Test
    @Order(7)
    @DisplayName("Test with empty array")
    @Tag("Negative")
    public void emptyArrayTest() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> secondLargestInList.processv2(new int[]{}));
        Assertions.assertEquals("Invalid input", exception.getMessage());
    }
}
