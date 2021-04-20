package dev.maow.owo;

import dev.maow.owo.api.OwO;
import dev.maow.owo.util.OwOFactory;

public class Test {
    public static void main(String[] args) {
        final OwO owo = OwOFactory.INSTANCE.create();

        System.out.println(owo.translate("This is a test of the OwO library."));
        System.out.println(owo.translate("My family would be proud of me."));
    }
}