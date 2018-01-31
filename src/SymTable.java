import java.util.*;

public class SymTable {
    //globals
    // The arraylist keeps track of the scope and the front of the the scope is the end of the array list
    // so when removing a scope it removes from the back
    private LinkedList<HashMap<String, Sym>> symList;
    //current hashmap is the one at the front of the list....
    private HashMap<String, Sym> current;

    public SymTable(){
        //create a new hashmap as the first scope and an arraylist
        current = new HashMap<String, Sym>();
        symList = new LinkedList<>();
        symList.addFirst(current);

    }
    public void addDecl(String name, Sym sym) throws WrongArgumentException, DuplicateSymException, EmptySymTableException {
        //if symList is empty throw exception
        if (symList.size() == 0){
            throw new EmptySymTableException();
        }
        // if name or sym or both is null throw WrongArgumentException
        if (name == null){
            throw new WrongArgumentException("Argument name is null.");
        } else if (sym == null){
            throw new WrongArgumentException("Argument sym is null.");
        } else if (name == null && sym == null){
            throw new WrongArgumentException("Arguments name and sym are null.");
        }
        //if the first hashmp in the list already contains a given name as a kay throw dup exception
        if (lookupLocal(name) != null){
            throw new DuplicateSymException();
        }
        // at this point should  be able to just add element
        symList.get(0).put(name, sym);
    }
    public void addScope(){
        //add a new empty hashmap and add it to the end of the arraylist
        current = new HashMap<String, Sym>();
        symList.addFirst(current);
    }
    public Sym lookupLocal(String name) throws EmptySymTableException{
        //if list is empty throw exception
        if (symList.size() == 0){
            throw new EmptySymTableException();
        }
        //check current hashmap for string
        if(symList.get(0).containsKey(name)){
            return symList.get(0).get(name);
        }
        return null;
    }
    public Sym lookupGlobal(String name) throws EmptySymTableException{
        // throw exception if table is empty
        if (symList.size() == 0){
            throw new EmptySymTableException();
        }
        //check all hashmaps for string
        for (int i = 0; i < symList.size(); i++){
            if(symList.get(i).containsKey(name)){
                return symList.get(i).get(name);
            }
        }
        return null;
    }
    public void removeScope() throws EmptySymTableException{
        //throw exception if table is empty
        if (symList.size() == 0){
            throw new EmptySymTableException();
        }
        //otherwise remove current hashmap since it should be the most recent
        symList.remove();
        //update current
        if (symList.size() != 0) {
            current = symList.get(0);
        }

    }
    public void print(){
        System.out.print("\n=== Sym Table ===\n");
        for (int i = 0; i < symList.size();i++){
            //print m which should be each hashmap REPLACE L with arrayList
            System.out.print(symList.get(i).toString() + '\n');
        }
        System.out.print("\n");
    }
}
