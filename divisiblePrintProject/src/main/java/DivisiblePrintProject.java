import com.dpp.DivisibleMethodCollection;
import com.dpp.PrintTool;
import java.util.List;

public class DivisiblePrintProject {
    public static void main(String[] args) {
        List<String> list = DivisibleMethodCollection.getDivisibleListByAddList(1,100);
       // PrintTool.seperateAndPrintList(list,20);
        try {
            List<String> mlist = DivisibleMethodCollection.getDivisibleListByMultiThread(1,100,3);
            PrintTool.seperateAndPrintList(mlist,20);
        }catch (Exception e){

        }


    }

}
