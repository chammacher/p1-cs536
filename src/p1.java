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
        //neww test addDec1 test for emptySymTableException
        // test wrongarg exception
        // test dupSymexc
        //else add name and Sym to first hashmap

        //add scope

        //lookup local
        //test empsymtabexc
        // find somehing in first hashmap
        //else return null
        //

        //lookup global
        //test empexc
        // find something in any hashmap
        //return null

        //removeScope
        //test empyt sym table exc
        //remove first hashmap'

        //print

        Sym s1 = new Sym("int");
        //return type
    }
}
