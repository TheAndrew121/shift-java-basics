package homework21;

// задача №1
public class LogicalOperationTable {
    static void main(String[] args) {
        // заголовок таблицы
        System.out.println("P\tQ\tP AND Q\tP OR Q\tP XOR Q\tNOT P");

        boolean[] values = {false, true};

        // тело таблицы
        for (boolean p : values) {
            for (boolean q : values) {
              System.out.println(
                 p + "\t" + q + "\t" + (p && q) +
                         "\t" + (p || q) + "\t"
                         + (p ^ q) + "\t" + (!p)
              );

            }

        }
    }
}


