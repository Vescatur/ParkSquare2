import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;


public class Main {
    boolean BerekenLijst = true;

    public Main(){
        if(BerekenLijst) {
            PrintWriter writer = null;

            int maxnumbers = 100;
            int[] SquaredNumbers = new int[maxnumbers + 1];
            int[] AnswerNumbers = new int[maxnumbers * maxnumbers * 3 + 1];

            for (int i = 0; i < maxnumbers + 1; i++) {
                SquaredNumbers[i] = i * i;
            }
            for (int first = 1; first < maxnumbers + 1; first++) {
                for (int second = 1; second < maxnumbers + 1; second++) {
                    for (int third = 1; third < maxnumbers + 1; third++) {
                        if (first != second && first != third && third != second) {
                            AnswerNumbers[SquaredNumbers[first] + SquaredNumbers[second] + SquaredNumbers[third]]++;
                        }
                    }
                }
            }
            int[] NieuweLijst = new int[maxnumbers + 1];
            for(int i=1; i<maxnumbers+1; i++){
                NieuweLijst[i] = AnswerNumbers[i];
                //writer.println(AnswerNumbers[i]+", ");
            }
            try {
                writer = new PrintWriter("ParkerSquare.csv", "UTF-8");
                writer.println(Arrays.toString(NieuweLijst));
                writer.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
