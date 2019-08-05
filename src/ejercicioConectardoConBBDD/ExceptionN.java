package ejercicioConectardoConBBDD;;

public class ExceptionN {
	
	public boolean exceptionNumero(String cadena) {
		int numero;		 
		try {			
				numero = Integer.parseInt(cadena);
				return true; 				
			}catch(Exception e) {
		
		return false;
			}
	}

}
