import static com.coti.tools.DiaUtil.showFinalTime;
import static com.coti.tools.Esdia.readInt;
import java.time.LocalDate;


public class sol_06 {
    public static void main(String[] args) {
        
        int actualYear = LocalDate.now().getYear();

        int birthYear = readInt("Escriba el año en que nació :  ");

        int age = actualYear - birthYear;

        System.out.printf("Su edad es de %d años%n", age);

        showFinalTime();
    }
}
