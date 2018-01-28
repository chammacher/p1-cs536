import java.util.*;

public class SymTable {
    //globals
    // The arraylist keeps track of the scope and the front of the the scope is the end of the array list
    // so when removing a scope it removes from the back
    private List<HashMap<String, Sym>> symList;
    //current hashmap is the one at the front of the list....
    private HashMap<String, Sym> current;

    public SymTable(){
        //create a new hashmap as the first scope and an arraylist
        current = new HashMap<String, Sym>();
        symList = new ArrayList<>();
        symList.add(current);

    }
    public void addDec1(String name, Sym sym) throws WrongArgumentException, DuplicateSymException, EmptySymTableException {
        //if symList is empty throw exception
        if (symList.isEmpty()){
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
        symList.get(symList.size()-1).put(name, sym);
    }
    public void addScope(){
        //add a new empty hashmap and add it to the end of the arraylist
        current = new HashMap<String, Sym>();
        symList.add(current);
    }
    public Sym lookupLocal(String name) throws EmptySymTableException{
        //if list is empty throw exception
        if (symList.isEmpty()){
            throw new EmptySymTableException();
        }
        //check current hashmap for string
        if(symList.get(symList.size()-1).containsKey(name)){
            return symList.get(symList.size()-1).get(name);
        }
        return null;
    }
    public Sym lookupGlobal(String name) throws EmptySymTableException{
        // throw exception if table is empty
        if (symList.isEmpty()){
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
        if (symList.isEmpty()){
            throw new EmptySymTableException();
        }
        //otherwise remove current hashmap since it should be the most recent
        symList.remove(current);

    }
    public void print(){
        System.out.println("\n=== Sym Table ===\n");
        for (int i = 0; i < symList.size();i++){
            //print m which should be each hashmap REPLACE L with arrayList
            System.out.println(symList.get(i).toString() + '\n');
        }
        System.out.println("\n");
    }
}
