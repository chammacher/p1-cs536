import java.util.*;

/**
 * p1
 *  FIX THIS TO BE ACCURATE
 * This is a class whose sole purpose is to test the List<E> class, which
 * provides the following operations:
 *       no-arg constructor            -- create an empty SymTable
 *       void addDec1(String name, Sym sym)     -- add item to the first hashmap in list
 *       void addScope()               -- add a new hashmap to front of list
 *       Sym lookupLocal(String name)  -- checks the first hashmap for an element
 *       Sym lookupGlobal(String name) -- checks all hashmaps for element
 *       void removeScope()            -- removes first hashmap
 *       void print()                  -- print out the symtable
 *
 * This code tests every symTable operation, including both correct and
 * bad calls to the operation (remove) that can throw an exception.
 * It produces output ONLY if a test fails.
 */

public class p1 {
    public static void main(String [] args){

        SymTable t1 = new SymTable();
        Sym s1 = new Sym("int");

        //test Sym class
        System.out.println("Print out type: " + s1.toString());

        //test SymTable addDec1 for exceptions
        try{
            t1.addDec1("a", s1);
        } catch (EmptySymTableException e){
            System.out.println("SymTable list is empty. May now have called the constructor.");
        } catch (DuplicateSymException e){
            System.out.println("tried to add dup.");
        } catch (WrongArgumentException e){
            System.out.println(e);
        }

        //test all values of WrongArgumentException
        try{
            t1.addDec1(null, s1);
        } catch (WrongArgumentException e){
            System.out.println(e);
        } catch (DuplicateSymException e){
            System.out.println("tried to add dup");
        } catch (EmptySymTableException e) {
            System.out.println("empty table");
        }
        try{
            t1.addDec1("b", null);
        } catch (WrongArgumentException e){
            System.out.println(e);
        } catch (DuplicateSymException e){
            System.out.println("tried to add dup");
        } catch (EmptySymTableException e) {
            System.out.println("empty table");
        }
        try{
            t1.addDec1(null, null);
        } catch (WrongArgumentException e){
            System.out.println(e);
        } catch (DuplicateSymException e){
            System.out.println("tried to add dup");
        } catch (EmptySymTableException e) {
            System.out.println("empty table");
        }

        //test dup exception
        try{
            t1.addDec1("a", s1);
        } catch (DuplicateSymException e){
            System.out.println("tried to add a duplicate name");
        } catch (EmptySymTableException e){
            System.out.println("caught empty table exc");
        } catch (WrongArgumentException e){
            System.out.println(e);
        }

        //test addScope()
        t1.addScope();
        //assume addDec1 works at this point if nothing as failed so far
        try {
            t1.addDec1("c", s1);
        } catch (DuplicateSymException e){
            System.out.println("tried to add a duplicate name");
        } catch (EmptySymTableException e){
            System.out.println("caught empty table exc");
        } catch (WrongArgumentException e){
            System.out.println(e);
        }

        //test look up local
        Sym ll = null;
        try{
            ll = t1.lookupLocal("c");
        } catch (EmptySymTableException e){
            System.out.println("list is empty. cannot perform a lookup");
        } finally {
            if(ll == null){
                System.out.println("element requested not in current scope.");
            }
        }
        //check not in this scope
        try{
            ll = t1.lookupLocal("a");
        } catch (EmptySymTableException e){
            System.out.println("list is empty. cannot perform a lookup");
        } finally {
            if(ll != null){
                System.out.println("element requested in current scope.");
            }
        }

        //test global lookup
        Sym gl = null;
        try{
            gl = t1.lookupLocal("a");
        } catch (EmptySymTableException e){
            System.out.println("list is empty. cannot perform a lookup");
        } finally {
            if(gl == null){
                System.out.println("element requested not in any scope.");
            }
        }
        try{
            gl = t1.lookupLocal("c");
        } catch (EmptySymTableException e){
            System.out.println("list is empty. cannot perform a lookup");
        } finally {
            if(gl == null){
                System.out.println("element requested not in any scope.");
            }
        }
        //check for element not in any scope
        try{
            gl = t1.lookupLocal("d");
        } catch (EmptySymTableException e){
            System.out.println("list is empty. cannot perform a lookup");
        } finally {
            if(gl != null){
                System.out.println("element requested in some scope.");
            }
        }

        //test if print works
        System.out.println("Print out the SymTable to see the elements before " +
                "removing scopes..");
        t1.print();

        //test removeScope
        try{
            t1.removeScope();
        } catch (EmptySymTableException e){
            System.out.println("list is empty");
        }
        try{
            t1.removeScope();
        } catch (EmptySymTableException e){
            System.out.println("list is empty");
        }
        try{
            t1.removeScope();
        } catch (EmptySymTableException e){
            System.out.println("This should print. List should have been empty.");
        }

    }
}
