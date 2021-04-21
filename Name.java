package angel.ast;
import angel.base.AngelException;
import angel.base.Token;
import angel.env.Enviroment;

public class Name extends ASTLeaf{
	public Name(Token t){super(t);}
	public String name(){return token().getText();}
	public Object eval(Enviroment env) {
		Object obj = env.get(name());
		if(obj != null){
			return obj;
		}else {
			throw new AngelException("undefined name: " + name(), this);
		}
	}
}