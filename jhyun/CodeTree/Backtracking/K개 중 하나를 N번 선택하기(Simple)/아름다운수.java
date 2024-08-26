import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int ans;
    static List<Integer> seq = new ArrayList<>();

    static boolean isBeautiful(){
        for(int i = 0; i < n; i+= seq.get(i)){
            //연속하여 해당 숫자만큼 나올 수 있는지 확인
            if(i + seq.get(i) - 1 >= n){
                return false;
            }

            //연속하여 해당 숫자만큼 같은 숫자가 있는지 확인
            for(int j = i; j < i + seq.get(i); j++){
                if(seq.get(j) != seq.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    static void countBeautifulSeq(int cnt) {
        if(cnt == n){
            if(isBeautiful()){
                ans++;
            }
            return;
        }

        for(int i = 1; i <= 4; i++){
            seq.add(i);
            countBeautifulSeq(cnt + 1);
            seq.remove(seq.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        countBeautifulSeq(0);
        System.out.print(ans);
    }
}