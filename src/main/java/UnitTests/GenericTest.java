package UnitTests;

import java.util.ArrayList;

/**
 * Created by Rushan on 22.02.2016.
 */
public class GenericTest {

    //fuck you shit
    public class a1<T extends a1> {
        Integer a = 1;

        public Integer getA() {
            return a;
        }

//        public ArrayList<T> getShit() {
//            ArrayList<T> arrayList = new ArrayList<>();
//            arrayList.add();
//        }

    }

    public class a2 extends a1{


    }
}
