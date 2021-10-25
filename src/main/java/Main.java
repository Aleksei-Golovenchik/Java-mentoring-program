import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {




        final ArrayList<String> strings = new ArrayList<>();
        strings.add("zxc");
        strings.add("mnb");

        System.out.println(intSupplier(6));
      //  System.out.println(listStringConsumer(strings));
        System.out.println(listStringConsumer(Arrays.asList("1",Integer.valueOf(7),"3")));
        List<Integer> list=Arrays.asList(1,2,3);
    }

    public static <T extends Integer> int intSupplier(T t) {
        return t.intValue();
    }

    public static <E> int intSupplier(E t) {
        return 0;
    }

    public static int listStringConsumer(List<Object> list) {
        System.out.println(list);
        return list.size();
    }
//some info

}
