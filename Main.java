import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        String strin = "({[]}){})";
        System.out.println(check(strin));
    }

    public static boolean check(String str) {
        List<Character> map1 = new ArrayList<>(asList('(', '[', '{'));
        List<Character> map2 = new ArrayList<>(asList(')', ']', '}'));
        List<Character> list = new ArrayList<>();
        char[] strChar = str.toCharArray();
        int count = 0;

        for(int i = 0; i < strChar.length; i++) {
            if(map2.contains(strChar[i]) && count == 0) {
                return false;
            }
            if(map1.contains(strChar[i])) {
                count++;
                list.add(strChar[i]);
            } else if(map2.contains(strChar[i])) { // ошибка тут
                        if(map2.indexOf(strChar[i]) == map1.indexOf(list.get(list.size() - 1))) {
                            list.remove(list.size() - 1);
                            count--;
                        } else return false;
                    }
        }
        if(list.size() != 0) return false;
        return true;
    }
}
