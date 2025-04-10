package org.sopt.common.utils;

public class IdGenerator {
    private static int id = 1;

    public static int generateId() {
        return id++;
    }
}
