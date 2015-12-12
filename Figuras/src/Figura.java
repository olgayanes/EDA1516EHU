import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Figura {
	// Representa una figura mediante trazos hechos a mano
	//cambios
	private String nombre;
	private LinkedList<Trazo>  lisTrazos; 
	Iterator<Trazo> iter;
	
	/**
	 * Crea una figura con los trazos indicados
	 * @param trazos, una secuencia de trazos
	 */
	public Figura(String trazos){

		this.lisTrazos=new LinkedList<Trazo>();	
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
		this.lisTrazos=new LinkedList<Trazo>();
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
	 * divide la lista en dos y vuelve a juntarla con la lista de "f" en medio
	 * si se os ocurre algo mas elegante implementadlo
	 * 
	 */
	public void insertar(int pos, Figura f){
		 LinkedList<Trazo> Apoyo = new LinkedList<Trazo>();
		 Apoyo.add(lisTrazos.get(pos));
			lisTrazos.remove(pos);
		 //este copia a una lista de apoyo a partir de pos y va borrando los ya copiados
		for(; pos< this.lisTrazos.size();pos++){
			Apoyo.add(lisTrazos.get(pos));
			lisTrazos.remove(pos);
		}
		//este coloca lo nuevo en lisTrazos
		for(int i=0;i<f.getTrazos().size();i++){
			lisTrazos.add(f.getTrazos().get(i));
		}
		//este copiara lo de apoyo a lisTrazos 
		for(int j=0;j<Apoyo.size();j++){
			lisTrazos.add(Apoyo.get(j));
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
		int pos= lisTrazos.lastIndexOf(new Trazo(c));
		
		if(pos>=0){
		for(;pos<lisTrazos.size();pos++){
			lisTrazos.remove(pos);
		}
		}
	}
	
	/**
	 * Sustituye el primer trazo de tipo 'c' con los trazos dados en 'trazos'
	 * Pre: Loz trazos dados deben de formar una secuencia casi-cerrada-1, es decir, le falta un
	 *  trazo para que sea cerrada y deber’a de seguir correctamente la secuencia con el 
	 *  siguinte trazo a 'c'. Porque si no repercute en la anchura y altura.
	 * @param c, un tipo de trazo
	 * @param trazos
	 * 
	 * Sustituye los trazos pero NO SE ME OCURRE COMO HACER PARA QUE CUMPLA LA PRECONDICION
	 * 
	 */
	public void sustituir(char c, String trazos){
		  System.out.println(lisTrazos);
		LinkedList<Trazo>  Apoyo = new LinkedList<Trazo>();
		int pos = lisTrazos.indexOf(new Trazo(c)); //este busca la posicion de c
		lisTrazos.remove(pos);
		  System.out.println(lisTrazos);
		pos++; //Avanza uno porque si no no hay nada que borrar?
		//este copia a una lista de apoyo a partir de pos y va borrando los ya copiados
		for(;pos<this.lisTrazos.size();pos++)
		{				
			Apoyo.add(lisTrazos.get(pos));
			lisTrazos.remove(pos);
			  System.out.println(lisTrazos);
		}
				
		//este coloca lo nuevo en lisTrazos
		for(int i=0;i<trazos.length();i++){
			lisTrazos.add(new Trazo( trazos.charAt(i)));
			System.out.println(lisTrazos);
		}
		//FUNCIONA GENIAL!!
		
		
		
	}
	
	/**
	 * Gira la figura 90¼ a la derecha
	 * 
	 * recorre los trazos cambiandolos por su equivalente girado 90º usando el metodo que 
	 * hay en la clase Trazos
	 * 
	 */
	public void girarDerecha(){
		for( Trazo t : this.lisTrazos ){
			t.girarDerecha();
		}
	}
	
	/**
	 * Aplica una homotecia de factor 2 a la figura
	 * Nota: Mirar si se sobrescribe la figura a la que se aplica la homotecia 
	 * o se guarda con un nuevo nombre y pasa a formar parte de Figuras
	 * 
	 * En este metodo se SOBRESCRIBE lisTrazos
	 */
	public void homotecia2(){
		LinkedList<Trazo>  lisTrazos2 = new LinkedList<Trazo>(); 
	
		for( Trazo t : this.lisTrazos ){
			lisTrazos2.add(t);
			lisTrazos2.add(t);
		}
		lisTrazos=lisTrazos2;
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
		int anchura = 0;
		int trazosDcha = 0;
		int trazosIzda = 0;
		
		for (Trazo todos : this.lisTrazos)
		{
			if (todos.getOrientacion() == 'D') 
			{
				trazosDcha++;
			}
			else if (todos.getOrientacion() == 'I')
			{
				trazosIzda++;
			}
		}
		
	if(trazosIzda < trazosDcha) { anchura = trazosDcha; }
	if(trazosDcha < trazosIzda) { anchura = trazosIzda; }
	if(trazosDcha == trazosIzda){ anchura = trazosIzda; }
	
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
	 * Compara las listas de trazos
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Figura){
			Figura f = (Figura) obj;
			if(this.longitud()!=f.longitud()) {return false;}
			else {
				for(int i=0;i<this.getTrazos().size();i++){
					if(this.lisTrazos.get(i).equals(f.lisTrazos.get(i))==false){
						return false;
					}
				}
				return true;	
			}	
		}
		return false;
	}

	/**
	 * Verifica si la figura actual y la figura 'f' son homoteticas. Es homotetica si las dos 
	 * figuras tienen la misma orientaci—n 
	 * y aplicando una secuencia de homotecias del factor 2 a una de las figuras se obtiene la 
	 * otra.
	 * @param f, una figura
	 * @return True si es homotetica y False, en caso contrario
	 * 
	 * Usa homotecia2 en la figura mas pequeña y luego las compara con equals
	 * 
	 */
	public boolean esHomotetica(Figura f){
		
		if(f.longitud() != this.longitud()&& f.longitud() < this.longitud() ){
			while(f.longitud() < this.longitud())f.homotecia2();
		}
		if(f.longitud() != this.longitud()&& f.longitud() > this.longitud() ){
			while(f.longitud() > this.longitud())this.homotecia2();
		}
		
		return this.equals(f); 
	}
	
	/**
	 * Verifica si la figura actual y la figura 'f' son semejantes. Es semejante si aplicando
	 *  una secuencia de homotecias del 
	 * factor 2 y giros a la derecha a una de las figuras se obtiene la otra.
	 * @param f, una figura
	 * @return True si es semejante y False, en caso contrario
	 * NOta: Si son iguales que devuelve????
	 * 
	 * Aplica la homotencia2 a la mas pequeña y las compara 4 veces, una por giro
	 * 
	 */
	public boolean esSemejante(Figura f){
		if(this.getTrazos().size()>f.getTrazos().size()){
			f.homotecia2();
			for(int i=3;i>0;i=i-1){
				if(this.equals(f)){
					return true;
				}
				f.girarDerecha();
			}
			}
		if(this.getTrazos().size()<f.getTrazos().size()){
			this.homotecia2();
			for(int i=3;i>0;i=i-1){
				if(this.equals(f)){
					return true;
				}
				this.girarDerecha();
			}
		if(this.getTrazos().size()==f.getTrazos().size()){
			return true;	
			}
			}
		return false;
	}

	
	/**
	 * Devuelve una copia exacta a la figura actual
	 * 
	 * Copia todo
	 * 
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Figura clon = new Figura("",this.getNombre());
		for(int i=0; i<this.getTrazos().size();i++){
			clon.getTrazos().add(this.getTrazos().get(i));
		}
		return super.clone();
	}

	/** 
	 * Devuelve la representacion de una figura de trazos como una cadena de caracteres
	 * 
	 * No me fio mucho de este pero tiene sentido
	 * 
	 */
	@Override
	public String toString() {
		String cadenaTrazos="";
		for(int i=0; i<this.getTrazos().size();i++){
			cadenaTrazos = cadenaTrazos + this.getTrazos().get(i);
		}
		return cadenaTrazos;
	}
}
