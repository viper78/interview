package array;

import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();

        List<Integer> list = Arrays.asList(1,2,3,1,5,1,6);

        System.out.println(re.removeElement(list, 1));
    }

    public int removeElement(List<Integer> list, int b) {
        int k = 0;
        for(int i = 0;i < list.size();i++) {
            if(list.get(i) != b) {
                list.set(k, list.get(i));
                k++;
            }
        }
        return k;
    }
}
