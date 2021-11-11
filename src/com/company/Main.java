package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Ebben a projektben lesz egy automata, amiben lesz egy jelszó és egy felhasználónév is, ez egy banki fiók lesz, érjük el,
        //hogy a felhasználó képes legyen kivenni pénzt, és befizetni pénzt, és megnézni hogy mennyi pénze van.
        Scanner scanner = new Scanner(System.in);
        Random veletlen = new Random();
        int probalkozasok = 1;
        int hatraLevoProba = 3;
        int accountMoney = veletlen.nextInt(20000, 20000000);  //A pénz randoman lesz kitalálva 20 ezer és 20 millió között.
        int moneyCash = veletlen.nextInt(5000, 20000); //A nálunk lévő készpénz is randoman lesz kitalálva, de az 5 és 20 ezer között.
        System.out.println("Jelenleg ennyi készpénzed van: " + moneyCash);
        String userName = "Lakatos Lajos"; //Ez pedig a felhasználónév.
        try {
            System.out.println("Kérem a jelszót: ");
            int userInPassword = scanner.nextInt();
            while (userInPassword != 557798) {  //Ahhoz hogy belépjünk a programba, ezt meg kell adni.
                System.out.println("Kérem a jelszót: ");
                hatraLevoProba -= 1;
                System.out.println("Hátralévő próbálkozások: " + hatraLevoProba);
                userInPassword = scanner.nextInt();
                probalkozasok += 1;
                if (probalkozasok == 3) {
                    System.out.println("Bankkártyája zárolásra került, kérjük forduljon a bankjához.");
                    System.exit(0);
                }
            }
            System.out.println("Bejelentkezés...");
            System.out.println("Üdvözöljük " + userName + " Elérhető egyenleg: " + accountMoney);
            boolean machineON = true;
            System.out.println("Parancsok: ");
            while (machineON) {
                System.out.println("1. Egyenleglekérdezés: 1");
                System.out.println("2. Befizetés: 2");
                System.out.println("3. Pénzfelvétel: 3");
                System.out.println("4. Kilépés: 4");
                System.out.printf(">: ");
                int parancs = scanner.nextInt();
                if (parancs == 1) {
                    System.out.println("Jelenlegi egyenleg: " + accountMoney);
                }
                if (parancs == 2) {
                    System.out.println("Mennyi pénzt szeretne befizetni? ");
                    System.out.printf(">: ");
                    int payMoney = scanner.nextInt();
                    if (payMoney > moneyCash) {
                        System.out.println("Nincsen ennnyi készpénze! ");
                        System.out.println("Hiba...");
                        break;
                    } else {
                        System.out.println("Befizetés sikeres..");
                        accountMoney += payMoney;
                        System.out.println("Új egyenleg: " + accountMoney);
                    }
                }
                if (parancs == 3) {
                    System.out.println("Mennyi pénzt szeretne felvenni? ");
                    System.out.printf(">: ");
                    int pickUpMoney = scanner.nextInt();
                    if (pickUpMoney > accountMoney) {
                        System.out.println("Nincsen ennyi pénz a bankszámláján! ");
                        System.out.println("Hiba...");
                        break;
                    } else {
                        System.out.println("Pénzfelvétel sikeres.");
                        accountMoney -= pickUpMoney;
                        System.out.println("Új egyenleg: " + accountMoney);
                    }
                }
                if (parancs == 4) {
                    System.out.println("Kilépés...");
                    machineON = false;
                }
            }
        }
        catch(Exception exception){
            System.out.println("Nem megfelelő bevitel...");
            //Használati útmutató..
            //A program befog kérni egy jelszót, ami: 557798
            //Ezután számokkal tudunk navigálni a parancsok között
            //Kilépéshez a 4-est kell beírni, minden a parancsok mellé van írva, mihez milyen szám kell.
        }
    }
}