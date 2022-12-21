package Lab_8;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class File_ByteRead_SumBuff {
    public static void readAllByArray(InputStream in) throws IOException{
        byte [] buff = new byte[5];
        while (true){
            int count = in.read(buff);
            if (count !=-1){
                System.out.println("количество= "+ count +", buff="+ Arrays.toString(buff)+", str="
                        + new String(buff,0,count,"cp1251"));
            }else{
                break;
            }
        }
    }
}
