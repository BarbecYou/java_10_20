package hu.petrik.versenyeredmenyek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static Map<String, List<Eredmeny>> sportagEredmenyek = new HashMap<>();

    public static void main(String[] args) {
        String fileName = "eredmenyek.txt";
        try {
            beolvas(fileName);
            kiiras();
            System.out.println("Sportágak száma: " + getSportagakSzama());
            System.out.printf("Az olimpián %d versenyző vett részt\n", getVersenyzokSzama());
        } catch (FileNotFoundException e){
            System.out.printf("Nem található a file");
        }
    }

    private static int getVersenyzokSzama() {
        List<String> versenyzok = new ArrayList<>();
        for (Map.Entry<String, List<Eredmeny>> entry : sportagEredmenyek.entrySet()){
            List<Eredmeny> eredmenyek = entry.getValue();
            for (Eredmeny e : eredmenyek){
                if (!versenyzok.contains(e.getNev())){
                    versenyzok.add(e.getNev());
                }
            }
        }
        return versenyzok.size();
    }

    private static int getSportagakSzama(){
        return sportagEredmenyek.keySet().size();
    }

    private static void kiiras() {
        for (Map.Entry<String, List<Eredmeny>> entry : sportagEredmenyek.entrySet()){
            String sportag = entry.getKey();
            List<Eredmeny> eredmenyek = entry.getValue();

            System.out.println(sportag);

            for (Eredmeny e : eredmenyek){
                System.out.println("\t" + e);
            }
        }
    }

    private static void beolvas(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNext()) {
            String[] sor = file.nextLine().split(" ");
            String sportag = sor[0];
            String reszIdo = sor[1];
            String nev = sor[2] + " " + sor[3];
            sportagEredmenyek.putIfAbsent(sportag, new ArrayList<>());
            Eredmeny eredmeny = new Eredmeny(reszIdo, nev);
            sportagEredmenyek.get(sportag).add(eredmeny);
        }
        file.close();
    }
}
