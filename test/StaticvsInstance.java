package test;

public class StaticvsInstance {
    public static void main(String[] args) {
        Something.count = 2;
        int x = Something.adds(5, 0);
        Something s1;
        s1 = new Something();
        s1.value = 66;

        Something s2 = new Something();
        s2.value = 50;
        int r = s2.add(4, 10);
        r = s1.add(4, 10);
    }
}

class Something {
    static int count; // class variable
    int value; // instance / object variable

    int add(int n1, int n2) {
        return n1 + n2;
    }

    static int adds(int n1, int n2) {
        return n1 + n2;
    }
}
