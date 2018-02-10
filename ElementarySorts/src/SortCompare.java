public class SortCompare {
    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Вставки")) Insertion.sort(a);
        if (alg.equals("Выбор")) Selection.sort(a);
        if (alg.equals("Шелл")) Shell.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Вставки";
        String alg2 = "Выбор";
        String alg3 = "Шелл";
        int N = 10000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg3, N, T);
        StdOut.printf("Для %d случайных Doubles\n   %s в", N*T, alg3);
        StdOut.printf(" %.5f раз быстрее, чем %s\n", t1/t2, alg1);
    }
}
