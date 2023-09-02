package test;

public class StringTest {
    public static void main(String[] args) {
        String a = "Hello World";
        // String a = new String("Hello World");
        String b = "Hello World";

        System.out.println(a == b);

        String c = "Hello";
        c = c + " World";
        System.out.print(c == b);
        System.out.print(c.equals(b));
    }
}
