package com.jueee.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jueee.item34.Item34Example06.Operation;


public class Item34Example07 {

    // Implementing a fromString method on an enum type
    private static final Map<String, Operation> stringToEnum =
            Stream.of(Operation.values()).collect(Collectors.toMap(Object::toString, e -> e));

    // Returns Operation for string, if any
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        System.out.println(fromString("+"));    // Optional[+]
        System.out.println(fromString("+").get());  // +
        System.out.println(fromString("a"));    // Optional.empty
        System.out.println(fromString("a").get());  // Exception in thread "main" java.util.NoSuchElementException: No value present
    }
}
