package angel.ast;
import java.util.List;

import angel.env.Enviroment;
public class BlockStmnt extends ASTList{
	public BlockStmnt(List<ASTree> tree){super(tree);}
	public Object eval(Enviroment env) {
		Object result = 0;
		for(ASTree tree : this) {
			if(!(tree instanceof NullStmnt)) {
				result = tree.eval(env);
			}
		}
		return result;	
	}
}