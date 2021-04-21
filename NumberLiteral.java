package angel.ast;
import angel.base.Token;
import angel.env.Enviroment;

public class NumberLiteral extends ASTLeaf{
	public NumberLiteral(Token t){super(t);}
	public int value(){return token.getNumber();}
	public Object eval(Enviroment env) {
		return value();
	}
}