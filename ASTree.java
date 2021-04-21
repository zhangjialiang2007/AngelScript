package angel.ast;
import java.util.Iterator;
import angel.env.Enviroment;

public abstract class ASTree implements Iterable<ASTree>{
	public abstract ASTree child(int i);
	public abstract int numChildren();
	public abstract Iterator<ASTree> children();
	public abstract String location();
	public Iterator<ASTree> iterator(){return children();}
	
	public abstract Object eval(Enviroment env);
}