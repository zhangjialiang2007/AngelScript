package angel.ast;
import java.util.List;

import angel.env.Enviroment;

public class NullStmnt extends ASTList{
	public NullStmnt(List<ASTree> tree){super(tree);}
	/*
	public Object eval(Enviroment env) {
		Object result = 0;
		return result;	
	}
	*/
}