package angel.ast;
import angel.base.Token;
import angel.env.Enviroment;

public class StringLiteral extends ASTLeaf{
	public StringLiteral(Token token){super(token);}
	public String value(){return token.getText();}
	public Object eval(Enviroment env) {
		return value();
	}
}