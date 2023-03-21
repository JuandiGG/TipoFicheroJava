import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Start {

	public static String DeducirTipoFicheroBinario (String ruta)
	{
		String formato="";
		FileInputStream ficheroBinarioLectura=null;
		BufferedInputStream bis=null;
		byte[] capturaDatosFichero=new byte[1000];
		int i=0;
		int numBytesLeidos=0;
		File f= new File (ruta);
		
		try {
			if(f.exists())
			{
			
				ficheroBinarioLectura = new FileInputStream(ruta);
				bis=new BufferedInputStream(ficheroBinarioLectura);
				
				try {
					numBytesLeidos = bis.read(capturaDatosFichero);
					if((capturaDatosFichero[0]==-119) && capturaDatosFichero[1]==80)
					{
						formato="PNG";
					}
					else if((capturaDatosFichero[0]==-1) && capturaDatosFichero[1]==-40)
					{
						formato="JPG";
					}
					else
					{
						formato="-2";
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				}	
			else
			{
				return "-1";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return formato;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion=0;
		String ruta="";
		String tipoFichero="";
		Scanner sc=new Scanner(System.in);
		
		do
		{
			System.out.println("***************TIPO DE FICHERO***************\n");
			
			System.out.println("1) Indicar tipo de fichero\n");
			
			System.out.println("0) Salir del programa\n");
			
			System.out.println("Seleccione una opción: ");
			opcion= sc.nextInt();
			
			if (opcion==1)
			{
				System.out.println("Introduzca la ruta del fichero: ");
				sc.nextLine();
				ruta = sc.nextLine();
				tipoFichero=DeducirTipoFicheroBinario(ruta);
				if (tipoFichero.equals("-1"))
				{
					System.out.println("El fichero no existe o no se ha podido abrir");
				}
				else if (tipoFichero.equals("-2"))
				{
					System.out.println("El formato no se ha encontrado");
				}
				else
				{
					System.out.println("El fichero de la ruta "+ruta+" es del tipo "+tipoFichero);
				}
			}
			
		}while(opcion !=0);
		System.out.println("Fin del programa");
		
	}

}
