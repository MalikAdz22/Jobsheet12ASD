import java.util.Scanner;

public class vaksinMain {
    public static void menu() {
        System.out.println("===================================");
        System.out.println("PENGANTRI VAKSIN RS WIJAYA 17 ");
        System.out.println("=================================== ");
        System.out.println();
        System.out.println("1. Tammbah Data Penerima Vaksin");
        System.out.println("2. Hapus Data Pengantri Vaksin");
        System.out.println("3. Daftar Penerima Vaksin");
        System.out.println("4. Keluar");
        System.out.println("=================================== ");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        vaksinasi17 dll = new vaksinasi17();

        int pilih;
    
        do {
            menu(); 
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Masukkan Data Penerima Vaksin");
                    System.out.println("-----------------------------");
                    System.out.print("Nomor Antrian: ");
                    int noAntrian = sc.nextInt();
                    System.out.print("Nama Penerima: ");
                    String nama = sc.next();
                    vaksin17 nb = new vaksin17(noAntrian, nama);
                    dll.addlast(nb);
                    System.out.println();
                    break;
                case 2:
                    vaksin17 penerima = dll.getFirst();
                    System.out.println(penerima.nama + " telah selesain divaksinasi.");
                    dll.removeFirst();
                    break;
                case 3:
                    System.out.println("-----------------------------");
                    System.out.println("Daftar Pengantri Vaksin");
                    System.out.println("-----------------------------");
                    dll.print();
                    System.out.println("Sisa Antrian: " + dll.size());
                    System.out.println();
                    break;
                case 4:
                    return;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4);
    }
}