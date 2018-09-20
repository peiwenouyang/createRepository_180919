import com.dpp.DivisibleMethodCollection;
import com.dpp.com.help.PrintTool;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DivisiblePrintProject {
    public static void main(String[] args) {
       List<String> list1 = DivisibleMethodCollection.getDivisibleListByAddList(1,100);
        PrintTool.seperateAndPrintList(list1,20);
        System.out.println("------------------------");
        try {
            List<String> list2 = DivisibleMethodCollection.getDivisibleListByMultiThread(1,100,3);
            PrintTool.seperateAndPrintList(list2,20);
        }catch (InterruptedException e){
              e.printStackTrace();
        }catch (ExecutionException e){
              e.printStackTrace();
        }
        System.out.println("------------------------");
        List<String> list3 =  DivisibleMethodCollection.getDivisibleListWithDataSavedByRedis(1,100);
        PrintTool.seperateAndPrintList(list3,20);


    }

}
