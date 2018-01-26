import java.util.*;

public class SymTable {
    //globals
    private List<HashMap<String, Sym>> L;

    public SymTable(){

    }
    public void addDec1(String name, Sym sym) throws WrongArgumentException, DuplicateSymException, EmptySymTableException {

    }
    public void addScope(){

    }
    public Sym lookupLocal(String name) throws EmptySymTableException{
        return null;
    }
    public Sym lookupGlobal(String name) throws EmptySymTableException{
        return null;
    }
    public void removeScope() throws EmptySymTableException{

    }
    public void print(){
        System.out.println("\n=== Sym Table ===\n");
        for (int i = 0; i < L.size();i++){
            //print m which should be each hashmap REPLACE L with arrayList
            List<HashMap<String, Sym>> m;
        }
        System.out.println("\n");
    }
}
