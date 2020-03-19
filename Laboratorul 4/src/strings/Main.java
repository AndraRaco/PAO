package strings;

public class Main {
    static String membruClasa;

    public static void main(String[] args) {
        // System.out.println(membruClasa); //null

        String s1 = ""; // Empty string

        String s2 = "abc"; // string pool
        System.out.println(s2); // abc
        s2.toUpperCase(); //Nu modifica val lui s2
        System.out.println(s2); // abc
//        s2 = s2.toUpperCase(); // Modifica valoarea lui s2
//        System.out.println(s2); // ABC

        String s3 = new String("abc");
        String s4 = "abc"; // reutilizeaza memoria de la s2

        // Aici compara si valoarea si referinta
        System.out.println(s2 == s3); //false
        System.out.println(s4 == s3); //false
        System.out.println(s4 == s2); //true
        s3 = s3.intern(); // Muta in zona de memorie refolosibila
        System.out.println(s2.equals(s3)); // true
        String s5 = "a\\bc \n de\tf";
        System.out.println(s5);

        String adresa = s1 + s2 + s3.toUpperCase() + s4.length();
        System.out.println(adresa);

        StringBuilder sb = new StringBuilder(adresa);
        sb.append(1234);
        System.out.println(sb);

        StringBuffer sbf = new StringBuffer(adresa);
        StringBuffer sbf1 = new StringBuffer(sb);
        StringBuffer sb1 = new StringBuffer(sbf);

    }
}
