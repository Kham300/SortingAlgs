public class SortCompare {
    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Вставки")) Insertion.sort(a);
        if (alg.equals("Выбор")) Selection.sort(a);
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
        int N = 1000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("Для %d случайных Doubles\n   %s в", N, alg1);
        StdOut.printf(" %.1f раз быстрее, чем %s\n", t2/t1, alg2);
    }
}
