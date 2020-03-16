package polymorphism.zoo;

import polymorphism.zoo.carnivor.Leu;
import polymorphism.zoo.carnivor.Pisica;
import polymorphism.zoo.ierbivor.Cal;
import polymorphism.zoo.ierbivor.Elefant;
import polymorphism.zoo.omnivor.Caine;
import polymorphism.zoo.omnivor.Urs;

import java.util.Scanner;

//java.lang - importat default

public class ZooTest
{
    public static void main(String[] args)
    {
        // int nrAnimaleZoo = Integer.parseInt(args[0]);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Precizati nr maxim de animale gazduite la zoo: ");
//        int nrAnimaleZoo = scanner.nextInt();
//        scanner.close();
//
//        Zoo zooBucuresti = new Zoo(nrAnimaleZoo);
//        adaugaAnimaleLaZoo(zooBucuresti);
//
//        for(int i = 0;(i< zooBucuresti.animaleZoo.length) && (zooBucuresti.animaleZoo[i]!=null); i++)
//        {
//            Animal animal = zooBucuresti.animaleZoo[i];
//            animal.afisareDetalii();
//            animal.seHraneste();
//            animal.scoateSunet();
//        }

        //Comparare
        Pisica pisica1 = new Pisica("Tom",7);
        Pisica pisica2 = new Pisica("Tom", 7);
        System.out.println(pisica1 == pisica2); //Compara continutul, hashCodul genrat e diferit la toate
        // E din clasa Object, deci il facem noi
        System.out.println(pisica1.equals(pisica2));//l-am suprascris
    }

    public  static void adaugaAnimaleLaZoo(Zoo zoo)
    {
        Leu leu = new Leu("Simba", 7);
        zoo.adaugAnimal(leu);
        Elefant elefant = new Elefant("Eli", 10);
        zoo.adaugAnimal(elefant);
        Urs urs = new Urs("Fram", 4);
        zoo.adaugAnimal(urs);
        Pisica pisica = new Pisica("Tom", 2);
        zoo.adaugAnimal(pisica);
        Caine caine = new Caine("Toto", 3);
        zoo.adaugAnimal(caine);
        Cal cal = new Cal("Thunder", 3);
        zoo.adaugAnimal(cal);
    }

}
