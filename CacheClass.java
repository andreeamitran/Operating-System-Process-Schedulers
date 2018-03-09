//package tema;

/**
 * @author andreeam
 */
public class CacheClass {
	private String process;
	private int number;
	
	/**
	 * Constructor fara parametri
	 */
	public CacheClass () {}
	
	/**
	 * Constructor cu parametri
	 * Seteaza numele procesului si valoarea numarului
	 * @param process
	 * @param number
	 */
	public CacheClass (String process, int number) {
		this.process = process;
		this.number = number;
	}
	
	/**
	 * Getter pentru tipul procesului
	 * @return process
	 */
	public String getProcType () {
		return process;
	}
	
	/**
	 * Getter pentru valoarea numarului
	 * @return number
	 */
	public int getNumber () {
		return number;
	}
}
