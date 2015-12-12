import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GestorFiguras {
	Hashtable<String,Figura> Figuras;
	
	
	/**
	 * Crea un gestor de figuras vacia
	 */
	public GestorFiguras(){
		Figuras = new Hashtable <String,Figura>();
		
	}
	
	/**
	 * Anade una nueva figura
	 * @param figura
	 */
	public void guardar(Figura figura){
		Figuras.put(figura.getNombre(), figura);
	}
	
	/**
	 * Devuelve la figura que tiene el nombre 'nombre' y si no null
	 * @param nombre, el nombre de una figura
	 * @return la figura
	 */
	public Figura recuperar(String nombre){
		return Figuras.get(nombre); 
	}
	
	/**
	 * Cambia la figura que tiene el mismo nombre que la figura dada
	 * @param figura, una figura 
	 */
	public void cambiar(Figura figura){
		Figuras.put(figura.getNombre(), figura);		
	}
	
	/**
	 * Verifica si existe o no una figura con el mismo nombre que el parametro 'nombre'
	 * @param nombre, el nombre de una figura
	 * @return devuelve True si existe y False, en caso contrario
	 */
	public boolean existe(String nombre){
		if(Figuras.containsKey(nombre)==true){;
		return true;
		}
		else{
		return false;
		}
	}
	
	/**
	 * Devuelve una lista de figuras que tengan los mismos nombres que contiene el array 'nombres'
	 * @param nombres, una lista de nombres
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarLista(String [] nombres){
		List <Figura> coincidencias = new LinkedList<Figura>();
		for(int i=0;i<nombres.length;i++){
				if(Figuras.get(nombres)!=null){
					coincidencias.add(Figuras.get(nombres));
				}
		}
		return coincidencias;
	}

	/**
	 * Devuelve una lista de figuras que son iguales a la figura dada 
	 * @param figura, una figura
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarIguales (Figura figura){
		List <Figura> coincidencias = new LinkedList<Figura>();
		Iterator<Figura>iterador=Figuras.values().iterator();
		while(iterador.hasNext()){
			Figura f = iterador.next();
			if(f.equals(figura)){
				coincidencias.add(f);
			}

		}			
		
		return coincidencias;
	}

	/**
	 * Devuelve una lista de figuras que son semejantes a la figura dada 
	 * @param figura, una figura
	 * @return una lista de figuras
	 */
	public List<Figura> recuperarSemejantes(Figura figura){
		List <Figura> coincidencias = new LinkedList<Figura>();
		Iterator<Figura>iterador=Figuras.values().iterator();
		while(iterador.hasNext()){
			Figura f = iterador.next();
			if(f.esSemejante(figura)){
				coincidencias.add(f);
			}
		}
	return coincidencias;
	
	}
		
		
}
