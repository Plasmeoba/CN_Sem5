import java.util.Scanner;

class Assgn3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("------ SUBNETTING ------\n");

        System.out.println("Definition of Subnetting:");
        System.out.println("Subnetting is the process of dividing a large network into smaller subnetworks (subnets).\n");

        System.out.println("Definition of Subnet Mask:");
        System.out.println("A subnet mask is a 32-bit number used to identify the network portion and host portion of an IP address.\n");

        System.out.print("Enter an IPv4 Address: ");
        String ip = sc.nextLine();

        String[] parts = ip.split("\\.");

        if (parts.length != 4) {
            System.out.println("Invalid IP Address!");
            return;
        }

        int firstOctet = 0;

        try {
            for (int i = 0; i < 4; i++) {
                int num = Integer.parseInt(parts[i]);

                if (num < 0 || num > 255) {
                    System.out.println("Invalid IP Address!");
                    return;
                }

                if (i == 0)
                    firstOctet = num;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid IP Address!");
            return;
        }

        if (firstOctet >= 0 && firstOctet <= 127) {

            System.out.println("\nClass : A");
            System.out.println("Subnet Mask           : 255.0.0.0");
            System.out.println("IP Range              : 0.0.0.0 - 127.255.255.255");
            System.out.println("Hosts per Network ID  : 2^24 - 2 = 16,777,214");
            System.out.println("Number of Networks    : 2^7 = 128");

        } else if (firstOctet >= 128 && firstOctet <= 191) {

            System.out.println("\nClass : B");
            System.out.println("Subnet Mask           : 255.255.0.0");
            System.out.println("IP Range              : 128.0.0.0 - 191.255.255.255");
            System.out.println("Hosts per Network ID  : 2^16 - 2 = 65,534");
            System.out.println("Number of Networks    : 2^14 = 16,384");

        } else if (firstOctet >= 192 && firstOctet <= 223) {

            System.out.println("\nClass : C");
            System.out.println("Subnet Mask           : 255.255.255.0");
            System.out.println("IP Range              : 192.0.0.0 - 223.255.255.255");
            System.out.println("Hosts per Network ID  : 2^8 - 2 = 254");
            System.out.println("Number of Networks    : 2^21 = 2,097,152");

        } else if (firstOctet >= 224 && firstOctet <= 239) {

            System.out.println("\nClass : D (Multicast)");
            System.out.println("Subnet Mask           : Not Applicable");
            System.out.println("IP Range              : 224.0.0.0 - 239.255.255.255");
            System.out.println("Hosts per Network ID  : Not Applicable");
            System.out.println("Number of Networks    : Not Applicable");

        } else {

            System.out.println("\nClass : E (Experimental)");
            System.out.println("Subnet Mask           : Not Applicable");
            System.out.println("IP Range              : 240.0.0.0 - 255.255.255.255");
            System.out.println("Hosts per Network ID  : Not Applicable");
            System.out.println("Number of Networks    : Not Applicable");

        }

        sc.close();
    }
}