import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.*;

public class MyClass extends Vehicle {
    int x = 5;

    public void myMethod() {
        System.out.println("dsadas");
    }

    public static boolean isPalindrom(String palindrom) {
        palindrom = palindrom.toLowerCase();
        int l = palindrom.length();
        for (int i = 0; i < l / 2; i++) {
            if (palindrom.charAt(i) != palindrom.charAt(l - i - 1)) {
                return false;

            }
        }
        return true;
    }

    public static int maxNumber(Integer nr1, Integer nr2, Integer nr3) {
        Integer max = nr1;
        if (max > nr2) {
            max = nr2;
        }
        if (nr3 > max) {
            max = nr3;
        }
        return max;

    }

    public static int sumaLista(List<Integer> lista) {
        int suma = 0;
        for (int numar : lista) {
            suma = suma + numar;
        }
        return suma;
    }

    public static boolean isPrim(Integer nr) {
        for (int i = 2; i < nr - 1; i++) {
            if (nr % i == 0) {
                return false;
            }

        }
        return true;
    }

    public static void sortList(List list) {
        System.out.println("lista nesortata: " + list);
        Collections.sort(list);
        System.out.println("lista sortata " + list);

    }

    public static void countVowels(String word) {
        int l = word.length();
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
                count++;
        }
        System.out.println(count);
    }

    public static List<Integer> serieFibo(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        if (n <= 0) {
            return fibonacci;
        }
        fibonacci.add(0);
        if (n > 1) {
            fibonacci.add(1);
        }
        for (int i = 2; i < n; i++) {
            int urmatorul = fibonacci.get(i - 1) + fibonacci.get(i - 2);
            fibonacci.add(urmatorul);
        }
        return fibonacci;

    }

    public static void factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        System.out.println(f);
    }

    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }

    public static void countWords(String phrase) {
        int countWords = phrase.split("\\s").length;
        System.out.println(countWords);
    }

    public static void reverseString(String word) {
        String reversedString = "";
        for (int i = 0; i < word.length(); i++) {
            reversedString = word.charAt(i) + reversedString;
            System.out.println(reversedString);
        }
    }

    public static int smallestElement(int[] ages) {
        int lowestAge = ages[0];
        for (int age : ages) {
            if (lowestAge > age) {
                lowestAge = age;
            }
        }
        return lowestAge;
    }

    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    public static void oddNumber(int no) {
        if (no % 2 == 0) {
            System.out.println(no + "is even ");
        } else {
            System.out.println(no + "is odd");
        }
    }

    public static int sum(int start, int end) {
        if (end > start) {
            return end + sum(start, end - 1);
        } else {
            return end;
        }
    }

    public static void swapNumbers(int nr1, int nr2) {
        int c = 0;
        System.out.println("Numbers before swap: " + nr1 + " " + nr2);
        c = nr1;
        nr1 = nr2;
        nr2 = c;
        System.out.println(nr1 + " " + nr2);
    }

    public static void count(String phrase) {
        int letter = 0;
        int space = 0;
        int number = 0;
        int other = 0;
        char[] c = phrase.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isLetter(c[i])) {
                letter++;
            } else if (Character.isDigit(c[i])) {
                number++;

            } else if (Character.isSpaceChar(c[i])) {
                space++;

            } else {
                other++;
            }
        }
        System.out.println("number of letters is " + letter + " " + "number of digits is " + number + "space is " + " " + space + "and finally other is " + " " + other);
    }

    public static void exampleHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Ion", 25);
        map.put("Maria", 32);
        map.put("George", 35);
        System.out.println("Map initial: " + map);
        System.out.println("Varsta lui Ion este: " + map.get("Ion"));
        map.put("Maria", 32);
        System.out.println("Map dupa actualizarea varstei Mariei: " + map);
        map.remove("George");
        System.out.println(map);
        if (map.containsValue(32)) {
            System.out.println("cineva are varsta 32");
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Cheie: " + entry.getKey() + "valoare: " + entry.getClass());
        }

    }

    public static void checkName() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
        Page page = browser.newPage();
        page.navigate("https://example.com");
        System.out.println(page.title());
        String name = page.title();
        if (name.equals("Example Domain")) {
            System.out.println("hurray");
        } else {
            System.out.println("non hurray");
        }
        browser.close();
    }






    public static void main (String[] args){
        checkName();
//        exampleHashMap();
//        count("Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33");
//        swapNumbers(3,5);
//        MyClass myFastCar = new MyClass();
//        myFastCar.honk();
//        System.out.println(myFastCar.brand + " "+myFastCar.modelName);
//        System.out.println("new");

//        int result = sum(1, 3);
//        System.out.println(result);
//        Scanner obj1 = new Scanner(System.in);
//        String name;
//        System.out.println("enter name: ");
//        name = obj1.nextLine();
//        MyClass myObj = new MyClass();
//        System.out.println(myObj.x);
//        myObj.myMethod();
//        String palindrom = "lupul";
//        boolean rezultat = isPalindrom(palindrom);
//        System.out.println(rezultat);
//        System.out.println(maxNumber(5,6,7));
//        List<Integer> lista = new ArrayList<>();
//        lista.add(25);
//        lista.add(56);
//        lista.add(65);
//        System.out.println(sumaLista(lista));
//        System.out.println(isPrim(12));
//        sortList(lista);
//        countVowels("piropopircanita");
//        System.out.println(serieFibo(13));
//        factorial(7);
//        System.out.println(sum(10));
//        countWords("ana are mere");
//        reverseString("cocos");
//        int[] ages = {25, 26, 54, 98, 57, 1};
//        System.out.println(smallestElement(ages));
//        for (Level val:Level.values()){
//            System.out.println(val);
//        }
//        oddNumber(2);
//        oddNumber(356841);
//        int x = 10;
//        int y=9;
//        System.out.println(x>y);
//        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
//                for(String i:cars){
//                    System.out.println(i);
//
//
//                }
//        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
//        System.out.println(myNumbers[0][0]);
//        for(int i=0; i<myNumbers.length; i++){
//            for(int j =0; j<myNumbers[i].length; j++){
//                System.out.println(myNumbers[i][j]);
//            }
//        }

    }


}
