package angel.ast;
import java.util.List;

public class PrimaryExpr extends ASTList{
	public PrimaryExpr(List<ASTree> tree){super(tree);}
	public static ASTree create(List<ASTree> tree){
		return tree.size() == 1 ? tree.get(0) : new PrimaryExpr(tree);
	}
}