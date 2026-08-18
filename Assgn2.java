import java.util.Scanner;

class Assgn2 {

    static Scanner sc = new Scanner(System.in);

    static void send() {
        System.out.print("Enter 4-bit data: ");
        String data = sc.nextLine();

        int d4 = data.charAt(0) - '0';
        int d3 = data.charAt(1) - '0';
        int d2 = data.charAt(2) - '0';
        int d1 = data.charAt(3) - '0';

        int p1 = d1 ^ d2 ^ d4;
        int p2 = d1 ^ d3 ^ d4;
        int p4 = d2 ^ d3 ^ d4;

        String code = "" + d4 + d3 + d2 + p4 + d1 + p2 + p1;

        System.out.println("Generated Hamming Code: " + code);
    }

    static void receive() {
        System.out.print("Enter received 7-bit code: ");
        String code = sc.nextLine();

        int[] bits = new int[7];

        for (int i = 0; i < 7; i++) {
            bits[i] = code.charAt(i) - '0';
        }

        int d4 = bits[0];
        int d3 = bits[1];
        int d2 = bits[2];
        int p4 = bits[3];
        int d1 = bits[4];
        int p2 = bits[5];
        int p1 = bits[6];

        int s1 = p1 ^ d1 ^ d2 ^ d4;
        int s2 = p2 ^ d1 ^ d3 ^ d4;
        int s4 = p4 ^ d2 ^ d3 ^ d4;

        int errorPosition = s4 * 4 + s2 * 2 + s1;

        if (errorPosition == 0) {
            System.out.println("No error detected.");
        } else {
            System.out.println("Error at position: " + errorPosition);

            int index = 7 - errorPosition;

            if (bits[index] == 0) {
                bits[index] = 1;
            } else {
                bits[index] = 0;
            }

            System.out.println("Error corrected.");
        }

        StringBuilder corrected = new StringBuilder();

        for (int bit : bits) {
            corrected.append(bit);
        }

        System.out.println("Corrected Code: " + corrected);
    }

    public static void main(String[] args) {
        send();
        receive();
    }
}