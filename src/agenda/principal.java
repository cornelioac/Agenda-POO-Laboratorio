package agenda;

import agenda.Contacto;

import java.util.Scanner;
public class principal {

	public static void main(String[] arg){		

		Scanner reader=new Scanner(System.in);
		int opcion, tamanio;
		Contacto mi_contacto,c;
		String nombre, telefono, email;
		boolean band=true;	

		System.out.print("Tamaño de la agenda: ");
		tamanio=reader.nextInt();
		Agenda mi_agenda=new Agenda(tamanio);		

		while(band==true){	
			menu();			
			System.out.print("> Elegir opcion: ");
			opcion=reader.nextInt();

			switch(opcion){
				case 1: //insertar contacto
					System.out.print("Ingresar nombre contacto: ");
					nombre=reader.next();
					System.out.print("Ingresar telefono contacto: ");
					telefono=reader.next();
					System.out.print("Ingresar email contacto: ");
					email=reader.next();

					mi_contacto=new Contacto(nombre,telefono,email);
					mi_agenda.setContacto(mi_contacto);
					break;
				case 2:
					System.out.println("Ingrese el nombre del contacto a editar: ");
					nombre=reader.next();
					if(!mi_agenda.existeContacto(nombre)){
						System.out.println("No se encontro el contacto");
					}else{
						System.out.println("Ingrese el nuevo numero: ");
						telefono=reader.next();
						System.out.println("Ingrese el nuevo e-mail: ");
						email=reader.next();
						c=new Contacto(nombre,telefono,email);
						mi_agenda.editarContacto(c);
						System.out.println ("Los datos han sido actualizados c: ");
					}
					break;
				case 3:
					System.out.println("Ingrese el nombre del contacto para buscar: ");
					nombre=reader.next();
					mi_agenda.buscarPorNombre(nombre);
					break;
				case 4:
					System.out.println("Ingrese el nombre del contacto para eliminar: ");
					nombre=reader.next();		
					mi_agenda.eliminarContacto(nombre);
					break;
				case 5://Listar Contactos
					mi_agenda.listarContactos();
					break;
				case 0://Finalizar programa
					band=false;
					break;
				default:				
					break;					
			}				
		}		
	}

	//Metodo de menu de opciones del proyecto
	public static void menu(){
		System.out.println("");
		System.out.println("========= Menu Agenda Telefonica =========");
		System.out.println("[1] Añadir Contacto");
		System.out.println("[2] Editar Contacto");
		System.out.println("[3] Buscar Contacto");
		System.out.println("[4] Eliminar Contacto"); // por nombre
		System.out.println("[5] Listar Contacto");
		System.out.println("[0] Finalizar Programa");
	}



}