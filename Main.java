import java.io.*;
import java.util.*;


public class Main {

    public static int minimum(int[] tablica, int rozmiar) {
      int min = tablica[0];
      for ( int i = 1; i < rozmiar; i++ )
         if ( tablica[i] < min )
            min = tablica[i];
      return min;
    }  

    public static int maximum(int[] tablica, int rozmiar) {
      int max = tablica[0];
      for ( int i = 1; i < rozmiar; i++ )
         if ( tablica[i] > max )
            max = tablica[i];
      return max;
    }  

    public static double srednia(int[] tablica, int rozmiar) {
      return suma(tablica, rozmiar) / (double)rozmiar;
    }
    public static int suma(int[] tablica, int rozmiar) {
      int s = 0;
      for ( int i = 0; i < rozmiar; i++ )
         s += tablica[i];
      return s;
    }

   public static void main(String[] args) {
      try {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int x, y;
         Random rand = new Random();
         System.out.println("Podaj liczbe wierszy macierzy: ");
         x = Integer.parseInt(in.readLine());
         System.out.println("Podaj liczbe kolumn macierzy: ");
         y = Integer.parseInt(in.readLine());        
         int[][] m = new int[x][y];
         
         for ( int i = 0; i < x; i++ ) {
            for ( int j = 0; j < y; j++ ) {
              //System.out.println("Podaj element ["+i+"]["+j+"]: ");
              // m[i][j] = Integer.parseInt(in.readLine());
              m[i][j] = rand.nextInt(100);
              System.out.println("Element ["+i+"]["+j+"]: " + m[i][j]);

            }
         }
         
         int min_x = 0, min_y = 0;
         for ( int i = 0; i < x; i++ ) 
            for ( int j = 0; j < y; j++ )
               if ( m[i][j] < m[min_x][min_y] ) {
                  min_x = i;
                  min_y = j;
               }
         
         System.out.println("Najmniejszy element znajduje sie w wierszu nr "+
                            (min_x)+" i kolumnie nr "+(min_y)+
                            " a jego wartosc wynosi "+m[min_x][min_y]);

         int[] minima = new int[x];
         for (int i=0; i<x; i++) {
           minima[i]=minimum(m[i], y);
           System.out.println("Minimum wiersza "+i+ " " + minima[i]);
         }

         System.out.println("Maximum z minimów " + maximum(minima, x));
         System.out.println("Średnia z minimów " + srednia(minima, x));
      } catch(IOException e) {
      }
   }
}

/*
 * Cwiczenia:
 * 1. Znajdz najwieksze z minimow poszczegolnych wierszy.
 * 2. Policz srednia minimow wierszy.
 */
 
