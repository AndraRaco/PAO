package exceptions.ex1;

// java lang -> Throwable
//                        Error
//                              OutOfMemoryException
//                              StackOverflowException
//                        Exception
//                              RuntimeException -> unchecked exceptions
//                                  java.lang, NPE, ArithmeticException,
//                                  IllegalArgumentException (NumberFormatException), classCastException
//                              other exceptions -> checked exceptions
//                                  IOException (java.io), SqlException(java.sql)
//                                      FileNotFoundException (java.io)

public class Ex1 {
    public static void main(String[] args) throws Exception { // Nu e recomadat throws Exception la main
        try {
            m1();
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("in finally");
        }
    }

    static void m1() throws Exception {
        System.out.println("in m1");
        m2();
        throw new Exception();

    }

    static void m2() {
        System.out.println("in m2");
        m3();
    }

    static void m3() {
        System.out.println("in m3");
        // throws NPE
        Object o = null;
        o.toString();
    }
}
