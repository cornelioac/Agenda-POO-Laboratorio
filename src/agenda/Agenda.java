package agenda;

import agenda.Contacto;


public class Agenda {	
	//Atributos
	Contacto[] lista;	

	//Metodos Constructores
	public Agenda(int tamanio_agenda){
		this.lista= new Contacto[tamanio_agenda]; 
	}

	public Agenda(){
		this.lista= new Contacto[10]; 
	}	

	//Metodos

	//Metodo insertar contactos
	public void setContacto(Contacto c){		
		int indice=buscar_indice_vacio();

		if(indice<0){
			System.out.println("");
			System.out.println("Importante: Agenda llena!");
		}else{
			this.lista[indice]=c;	
		}								
	}

	private int buscar_indice_vacio() {		
		int indice=0;		
		while(this.lista[indice]!=null){			
			indice++;
			if(indice > (this.lista).length-1){
				return -1;
			}				
		}		
		return indice;				
	}

	public void listarContactos(){
		System.out.println("");
		System.out.println("Lista de contactos");
		for(int i=0;i<(this.lista).length;i++){
			if(this.lista[i]==null){

			}else{
				System.out.println("");
				System.out.println("Contacto: "+(i+1));
				(this.lista[i]).DatosContacto();
			}
		}			
	}
	
	public void buscarPorNombre(String nombre){
		boolean find=false;
		for(int i=0;i<(this.lista).length;i++){
			if(this.lista[i] != null && this.lista[i].getNombre().equalsIgnoreCase(nombre) ){
				System.out.println("Su telefono es "+ this.lista[i].getTelefono());
				System.out.println("Su correo es "+ this.lista[i].getEmail());
				find=true;
			}
		}
		
		if(!find){
			System.out.println("No se encontro el contacto :(");
		}
	}
	
	public  void eliminarContacto(String nombre){
		boolean find=false;
		for(int i=0;i<(this.lista).length;i++){
			if(this.lista[i] != null && this.lista[i].getNombre ().equalsIgnoreCase(nombre) ){
				this.lista[i]=null;
				find=true;
				System.out.println ("Se ha eliminado el contacto");
				}
		}
		if(!find){
			System.out.println("No se pudo eliminar el contacto :(");
		}
		
	}
	
	public boolean existeContacto(String nombre){
		for(int i=0;i<(this.lista).length;i++){
			if(this.lista[i] != null && this.lista[i].getNombre ().equalsIgnoreCase(nombre) ){
				return true;
				}
			}
		return false;
	}

	public void editarContacto(Contacto c){
		for(int i=0;i<(this.lista).length;i++){
			if(this.lista[i] != null && this.lista[i].getNombre().equals(c.getNombre()) ){
				this.lista[i]= c;
				}
		}
	}

}
