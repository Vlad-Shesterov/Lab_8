package Lab_8;

import java.io.*;

public class Task_2 {
    static double GRAC(String S) {
        double col = 0;
        int count = 0;
        int i = S.length() - 1;
        while (S.charAt(i) != '.' && S.charAt(i) != '-' && S.charAt(i) != ',' && i > 0) {
            col = col + CST(S.charAt(i)) * Math.pow(10, count);
            count++;
            i--;
        }
        if (S.charAt(i) == '.' || S.charAt(i) == ',') {
            col /= Math.pow(10, count);
            count = 0;
            i--;
            while (i>-1 && S.charAt(i)!='-'){
                col = col + CST(S.charAt(i)) * Math.pow(10, count);
                count++;
                i--;
            }
        }
        if (i>=0 && S.charAt(i) == '-') {
            col *= -1;
            i--;
        }
        return col;
    }
    static int CST(char CH){
        int res = 0;
        switch (CH){
            case ('0'):
                res = 0;
                break;
            case ('1'):
                res = 1;
                break;
            case ('2'):
                res = 2;
                break;
            case ('3'):
                res = 3;
                break;
            case ('4'):
                res = 4;
                break;
            case ('5'):
                res = 5;
                break;
            case ('6'):
                res = 6;
                break;
            case ('7'):
                res = 7;
                break;
            case ('8'):
                res = 8;
                break;
            case ('9'):
                res = 9;
                break;
        }
        return res;
    }
    static boolean CanBOOL(char A){
        //кода буква - значит правда
        if (A != '1' && A != '2' && A != '3' && A != '4' && A != '5' && A != '6' && A != '7' && A != '8' && A != '9' && A != '-'){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        //создаем новый файл программными средствами Java и кладем в него исходные данные
        BufferedWriter newFile = null;
        BufferedWriter pisec = null;
        BufferedReader chtec = null;
        Thread t = Thread.currentThread();
        try{
            newFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\TMP\\TASK-11.edu")));
            newFile.write("Мой дядя самых честных правил\nКогда не в шутку занемог\n");
            newFile.write("10.265\n-20.287 15.4884\n-70.6464 5.1324\n");
            newFile.write("Он уважать себя заставил\nИ больше выдумать не мог\n");
            newFile.write("-10.265\n20.287 -15.4884\n70.6464 -5.1324");
            newFile.flush();
            newFile.close();

            chtec = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\TMP\\TASK-11.edu")));
            pisec = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\TMP\\TASK-11(WR).edu")));

            String str;
            System.out.println(t);
            int counter = 0;
            while (!chtec.equals(null)){
                str = chtec.readLine();
                if (CanBOOL(str.charAt(0)) && counter == 1){
                    pisec.write(str);
                    pisec.newLine();
                    counter++;
                } else if (CanBOOL(str.charAt(0)) && counter != 1){
                    counter++;
                } else if (!CanBOOL(str.charAt(0))){
                    String[] juk = str.split(" ");
                    for (int i = 0; i< juk.length;i++){
                        if (GRAC(juk[i])>0){
                            pisec.write(juk[i]+" ");
                            pisec.newLine();
                        }
                    }
                }
            }
        }catch(Throwable e){
            System.out.println(t);

        }finally {
            pisec.flush();
            pisec.close();
            chtec.close();
        }
    }
}
