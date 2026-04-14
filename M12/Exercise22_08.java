import java.io.*;

public class Exercise22_08 {
    private static final int BATCH_SIZE = 10000;

    public static void main(String[] args) throws Exception {
        long limit = 10000000000L;
        long[] primeBuffer = new long[BATCH_SIZE];
        long number;

        RandomAccessFile raf = new RandomAccessFile("PrimeNumbers.dat", "rw");

        if (raf.length() == 0) {
            number = 1;
        } else {
            raf.seek(raf.length() - 8);
            number = raf.readLong();
        }

        long squareRoot = 1;

        search:
        while (number < limit) {
            number++;
            raf.seek(0);

            if ((squareRoot + 1) * (squareRoot + 1) <= number) {
                squareRoot++;
            }

            while (raf.getFilePointer() < raf.length()) {
                int count = fetchNextBatch(primeBuffer, raf);

                for (int i = 0; i < count; i++) {
                    if (primeBuffer[i] > squareRoot) {
                        break;
                    }
                    if (number % primeBuffer[i] == 0) {
                        continue search;
                    }
                }
            }

            raf.seek(raf.length());
            raf.writeLong(number);
        }

        raf.close();
    }

    public static int fetchNextBatch(long[] buffer, RandomAccessFile raf) {
        int count = 0;
        try {
            while (count < BATCH_SIZE && raf.getFilePointer() < raf.length()) {
                buffer[count++] = raf.readLong();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return count;
    }
}