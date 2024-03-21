import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.swing.text.TabStop;

public class games {

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			Random random = new Random();
		
			int satirSayisi,sutunSayisi,zorlukDerecesi;
			
			System.out.println("Mayın Tarlası Oyunummuza Hoşgeldiniz ...");
			System.out.print("Mayın Tarlasının Satır Sayısını Giriniz : ");
			satirSayisi = scanner.nextInt();
			System.out.print("Mayın Tarlasının Sutün Sayısını Giriniz : ");
			 sutunSayisi=scanner.nextInt();
			System.out.print("Zorlu derecesini belirleyin (20 ile 80 de  arasında olmalı ) :  ");
			 zorlukDerecesi = scanner.nextInt();
			 
			 int mayinSayisi=0;
			 float b = zorlukDerecesi/100F;
			 
			 if(zorlukDerecesi>19 && zorlukDerecesi<81) {
				mayinSayisi= (int) ((satirSayisi*sutunSayisi)*b);
			 }
			 else {
				 System.out.println("20 ile 80  arasında  zorluk tekrardan  değeri giriniz : ");
				 System.out.print("Zorluk derecesi : ");
				 zorlukDerecesi=scanner.nextInt();
				 
				 // Yeniden zorluk derecesi aldığımızda atanan değer 
				 float c = zorlukDerecesi/100F;
				 mayinSayisi= (int) ((satirSayisi*sutunSayisi)*c);
				 
			 }
	
			 int MayinTarlasi[][]= new int[satirSayisi][sutunSayisi];
			 
			 for(int i =1;i<=mayinSayisi;i++) {
				 int x= random.nextInt(0,satirSayisi);  
				 int y = random.nextInt(0,sutunSayisi);
				 MayinTarlasi[x][y] = 1;
			 }
			 
			 //	Mayınların nerde olduğunu gösterir; Mayınlar yerleşti geriye kalan elemanlara 0 değeri atandı
			 
			 for(int i =0;i<satirSayisi;i++) { 
				 for(int j =0;j<sutunSayisi;j++) {
					 if(MayinTarlasi[i][j]==1) {
						 System.out.print(1);
				 }
					 else {
						System.out.print(0);
					}
					System.out.print(" ");
			 }
				 System.out.println("");
			}
		 
		// Mayın Tarlasını verir
			for(int i=0;i<satirSayisi;i++) {
				for (int j =0;j<sutunSayisi;j++) {
					System.out.print("*");
					System.out.print(" ");
				}
				System.out.println("");
			}
			
			System.out.print ("Arama yapmak istediğiniz satırı numarasını giriniz.. :");
			int kulSatirNum=scanner.nextInt();
			System.out.print("Arama yapmak istediğiniz sutunu numarasını giriniz.. : ");
			int kulSutunNum = scanner.nextInt();
			
			int mayinKontrol[][] = new  int[satirSayisi][sutunSayisi];
			// mayinKontrol dizisinin tüm elemanlarına -1 değerini atadım
			for(int i=0;i<satirSayisi;i++) {
				for (int j = 0;j<sutunSayisi;j++) {
					mayinKontrol[i][j]=-1;
				}
				System.out.println("");
			}
			 
			boolean dongu = true;
			int toplamPuan=0;
			
			while(dongu) {
				
				mayinKontrol[kulSatirNum][kulSutunNum] = MayinTarlasi[kulSatirNum][kulSutunNum];
				
				for(int i=0;i<satirSayisi;i++) {
				for (int j =0;j<sutunSayisi;j++) {
					if(mayinKontrol[i][j] == 0 || mayinKontrol[i][j]== 1  ) {
						System.out.print(mayinKontrol[i][j]);
					}
					else {
						System.out.print("*");
					}
					System.out.print(" ");
				}
				System.out.println("");
				}
				
				if(MayinTarlasi[kulSatirNum][kulSutunNum]==1) {
					System.out.println("Oyun bitti ... Mayına Bastınız");
					System.out.println("Toplam puanınız = "+toplamPuan);
					 
					for(int i =0;i<satirSayisi;i++) { 
						 for(int j =0;j<sutunSayisi;j++) {
							 if(MayinTarlasi[i][j]==1) {
								 System.out.print(1);
						 }
							 else {
								System.out.print(0);
							}
							System.out.print(" ");
					 }
						 System.out.println("");
					}
					dongu=false;	
				}
				else {
					toplamPuan+=5;
					System.out.print ("Arama yapmak istediğiniz satır numarasını giriniz.. :");
					 kulSatirNum=scanner.nextInt();
					System.out.print("Arama yapmak istediğiniz sutun numarasını giriniz.. : ");
					 kulSutunNum = scanner.nextInt();
				}	
			}
		}
	}

