
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Figura {
	// Representa una figura mediante trazos hechos a mano
	//cambios
	private String nombre;
	private LinkedList<Trazo>  lisTrazos; 
	Iterator<Trazo> iter = lisTrazos.iterator();
	
	/**
	 * Crea una figura con los trazos indicados
	 * @param trazos, una secuencia de trazos
	 */
	public Figura(String trazos){

			
		for(int i= 0; i<trazos.length(); i++)
		{
			lisTrazos.add( new Trazo( trazos.charAt(i)));
		}

	}
	
	/**
	 * Crea una figura con los trazos indicados y lo nombra con el nombre dado
	 * @param trazos, una secuencia de trazos 
	 * @param nombre, un nombre 
	 * 
	 * Como el anterior solo que añade un nombre
	 * 
	 */
	public Figura(String trazos, String nombre){
		
		this.nombre = nombre;
		for(int i= 0; i<trazos.length(); i++)
		{
			lisTrazos.add( new Trazo( trazos.charAt(i)));
		}

	}
	
	
	
	/**
	 * Devuelve el nombre e la figura
	 * @return el nombre
	 * 
	 * no necesita explicacion...
	 * 
	 */
	public String getNombre(){
		return this.nombre;
	}
	
	/**
	 * Devuelve una lista de trazos
	 * @return lista de trazos
	 * 
	 * Evidente no, lo siguiente
	 * 
	 */
	public List<Trazo> getTrazos(){
		return this.lisTrazos;
	}
	
	/**
	 * A–ade un trazo al final de los trazos de la figura
	 * @param c, letra que indica un trazo
	 */
	public void anadirTrazo(char c){
		lisTrazos.add( new Trazo(c));
	}
	
	/**
	 * A–ade un trazo al inicio o al final de los trazos de la figura
	 * @param c, letra que indica un trazo
	 * @param alInicio, si True indica al inicio y False, al final
	 * 
	 * Una condicional y los metodos de linkedLists insertFirst e insertLast
	 * 
	 */
	public void anadirTrazo(char c, boolean alInicio){
		if (alInicio==true)
		{
			this.lisTrazos.addFirst(new Trazo(c));
		}
		else
		{
			this.lisTrazos.addLast(new Trazo(c));
		}
	}
	
	/**
	 * Fusiona la figura 'f' al final de la figura actual
	 * @param f, una figura
	 */
	public void fusionar(Figura f){
		for( Trazo t : f.lisTrazos )
			this.lisTrazos.add( t );
		
	}
	
	/**
	 * Inserta la figura 'f' despues del trazo en la posicion 'pos'.
	 * Pre: La figura 'f' debe ser una secuencia cerrada, es decir, debe terminar en el punto donde empieza. 
	 * Porque si no repercute en la anchura y altura.
	 * @param pos, posicion entre [1..longitud(figura)]
	 * @param f, una figura
	 * 
	 * Buscar un metodo que inserte una lista dentro de otra, si no existe dividir la lista en
	 * dos y volver a juntarlas con la lista de "f" en medio
	 * 
	 */
	public void insertar(int pos, Figura f){
		for(Trazo t: f.lisTrazos){
			this.lisTrazos.add(pos, t);
			pos++;
		}
	}
	
	/**
	 * Elimina la secuencia de trazos desde la œltima ocurrencia del trazo de tipo 'c'
	 * @param c, un tipo de trazo
	 * 
	 * recorre la lista y si encuentra c activara una condicional que borrara todo de ahi 
	 * en adelante
	 * 
	 */
	public void eliminarDesdeUltimoTrazo(char c){
		boolean borrar= false;
		
		for( Trazo t : this.lisTrazos ){
			if(t.equals(c)==true){
				borrar=true;
			}
				if(borrar=true){
					lisTrazos.remove(t);
				}
			
		}
	}
	
	/**
	 * Sustituye el primer trazo de tipo 'c' con los trazos dados en 'trazos'
	 * Pre: Loz trazos dados deben de formar una secuencia casi-cerrada-1, es decir, le falta un trazo para que sea cerrada y
	 * deber’a de seguir correctamente la secuencia con el siguinte trazo a 'c'. Porque si no repercute en la anchura y altura.
	 * @param c, un tipo de trazo
	 * @param trazos
	 * 
	 * Aparentemente es parecido al de insertar...
	 * 
	 */
	public void sustituir(char c, String trazos){
		//TODO
	}
	
	/**
	 * Gira la figura 90¼ a la derecha
	 * 
	 * recorre los trazos cambiandolos por su equivalente girado 90º usando el metodo que 
	 * hay en la clase Trazos
	 * 
	 */
	public void girarDerecha(){
		for( Trazo t : lisTrazos ){
			t.girarDerecha();
		}
	}
	
	/**
	 * Aplica una homotecia de factor 2 a la figura
	 Nota: Mirar si se sobrescribe la figura a la que se aplica la homotecia 
	 o se guarda con un nuevo nombre y pasa a formar parte de Figuras
	 */
	public void homotecia2(){
		//TODO		
	}
	
	/**
	 * Devuelve la longitud de la figura, es decir, el numero de trazos que componen la figura
	 * @return longitud de la figura
	 * 
	 * Simple
	 * 
	 */
	public int longitud(){
		return this.lisTrazos.size();
	}
	
	/**
	 * Devuelve la altura de la figura
	 * @return altura de la figura
	 * 
	 * discutir como se obtiene la altura
	 * contar cuantos trazos hay hacia arriba y hacia abajo, la altura sera el numero mayor de
	 * los dos. Si son iguales cualquiera vale.
	 * 	  
	 */
	public int altura()
	{	int altura = 0;
		int trazosArriba = 0;
		int trazosAbajo = 0;
		
		for (Trazo todos : this.lisTrazos)
		{
			if (todos.getOrientacion() == 'S') 
			{
				trazosArriba++;
			}
			else if (todos.getOrientacion() == 'B')
			{
				trazosAbajo++;
			}
		}
		
	if(trazosAbajo < trazosArriba) { altura = trazosArriba; }
	if(trazosArriba < trazosAbajo){ altura = trazosAbajo; }
	if(trazosArriba == trazosAbajo ){ altura = trazosAbajo; }
	// Esti: Esto es feo y se hace con un switch
		return altura;
	}
	
	/**
	 * Devuelve la anchura de la figura
	 * @return anchura de la figura
	 * 
	 * discutir como se obtiene la anchura
	 * lo mismo que altura pero en horizontal
	 * 
	 */
	public int anchura(){
		//TODO
		int anchura = 0;
		int trazosDcha = 0;
		int trazosIzda = 0;
		
		for (Trazo todos : this.lisTrazos)
		{
			if (todos.getOrientacion() == 'D') 
			{
				trazosDcha++;
			}
			else if (todos.getOrientacion() == 'B')
			{
				trazosIzda++;
			}
		}
		
	if(trazosIzda < trazosDcha) { anchura = trazosDcha; }
	if(trazosDcha < trazosIzda) { anchura = trazosIzda; }
	if(trazosDcha == trazosIzda){ anchura = trazosIzda; }
	// Esti: Esto es feo y se hace con un switch
		return anchura;
	}
	
	/**
	 * Calcula y devuelve la superficie de la figura
	 * @return superficie de la figura
	 * 
	 * Muy simple
	 * 
	 */
	public int superficie(){
		return this.altura()*this.anchura();
	}

	/**
	 * Verifica si la figura actual y la fgura dada por parametro 'obj' son iguales
	 * @paramm obj, una figura
	 * @return True si son iguales y False, en caso contrario
	 * 
	 * Venia hecho
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// NOTA: No se puede utilizar la comparacion entre Strings.
		return super.equals(obj);
	}

	/**
	 * Verifica si la figura actual y la figura 'f' son homoteticas. Es homotetica si las dos figuras tienen la misma orientaci—n 
	 * y aplicando una secuencia de homotecias del factor 2 a una de las figuras se obtiene la otra.
	 * @param f, una figura
	 * @return True si es homotetica y False, en caso contrario
	 */
	public boolean esHomotetica(Figura f){
		// TODO 
		// ver cual es la mas grande
		// f.homotecia2(); ver if(this igual a lo que haya devuelto)
		// NOTA: No se puede utilizar la comparacion entre Strings.
		return false;
	}
	
	/**
	 * Verifica si la figura actual y la figura 'f' son semejantes. Es semejante si aplicando
	 *  una secuencia de homotecias del 
	 * factor 2 y giros a la derecha a una de las figuras se obtiene la otra.
	 * @param f, una figura
	 * @return True si es semejante y False, en caso contrario
	 * NOta: Si son iguales que devuelve????
	 */
	public boolean esSemejante(Figura f){
		// TODO
		// NOTA: No se puede utilizar la comparacion entre Strings.
		return false;
	}
	
	/**
	 * Devuelve una copia exacta a la figura actual
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/** 
	 * Devuelve la representacion de una figura de trazos como una cadena de caracteres
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
