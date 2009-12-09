package AdaSemantic;
/**
Clase para representar los cuádruplos del código intermedio
*/
public class Cuadruplo{
	public String operador;
	public String arg1;
	public String arg2;
	public String res;
	
	public Cuadruplo(){
		operador=null;
		arg1=null;
		arg2=null;
		res=null;
	}
	public Cuadruplo( String operador,  String arg1,  String arg2,  String res){
		this.operador=operador;
		this.arg1=arg1;
		this.arg2=arg2;
		this.res=res;
	}	
	/*Para operadores unarios*/
	public Cuadruplo(String operador, String arg1,  String res){
		this.operador=operador;
		this.arg1=arg1;
		this.arg2=null;
		this.res=res;
	}	
	/*Para sentencias como goto*/
	public Cuadruplo( String operador,  String res){
		this.operador=operador;
		this.arg1=null;
		this.arg2=null;
		this.res=res;
	}	
	public String  toString(){
		String r=(!res.isEmpty()) ? res+":=" : "";
		String a1=(!arg1.isEmpty()) ? arg1+" " : "";
		String o= (!operador.isEmpty()) ? operador+ " " : "";
		/*Para que el if se mire pinta: */
		if(operador.contains("if"))
			return operador.split("_")[0]+" "+arg1+" "+operador.split("_")[1]+" "+ arg2+" goto "+res;
		else if(operador.contains(":="))
			return res+" := "+ arg1;
		else if(operador.equals("goto"))
			return "goto "+res;
		else if(operador.matches("put|get|call|param|glbl|function|return|initFunction"))
			return operador+" "+ arg1+" "+arg2;
		return r+a1+o+arg2;
	}
		
}
