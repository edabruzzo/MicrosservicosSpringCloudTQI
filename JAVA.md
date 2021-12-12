# Java Programming

## Collections
### HashTable 

    public class Hashtable<K,​V>
        extends Dictionary<K,​V>
            implements Map<K,​V>, Cloneable, Serializable
    
    An instance of Hashtable has two parameters that affect its performance: 

    * initial capacity
        The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created.
        Note that the hash table is open: in the case of a "hash collision", a single bucket stores multiple entries, which must be searched sequentially. 

    * load factor.  
        The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. The initial capacity and load factor parameters are merely hints to the implementation. The exact details as to when and whether the rehash method is invoked are implementation-dependent.

    Generally, the default load factor (.75) offers a good tradeoff between time and space costs. Higher values decrease the space overhead but increase the time cost to look up an entry (which is reflected in most Hashtable operations, including get and put).
    The initial capacity controls a tradeoff between wasted space and the need for rehash operations, which are time-consuming. No rehash operations will ever occur if the initial capacity is greater than the maximum number of entries the Hashtable will contain divided by its load factor. However, setting the initial capacity too high can waste space.
    If many entries are to be made into a Hashtable, creating it with a sufficiently large capacity may allow the entries to be inserted more efficiently than letting it perform automatic rehashing as needed to grow the table.

This example creates a hashtable of numbers. It uses the names of the numbers as keys:    

```   
         Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
         numbers.put("one", 1);
         numbers.put("two", 2);
         numbers.put("three", 3);
         
```
         
To retrieve a number, use the following code:

```
Integer n = numbers.get("two");
if (n != null) {
System.out.println("two = " + n);
}
```        
+ https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Hashtable.html



## Streams

### Stream (interface)
    A sequence of elements supporting sequential and parallel aggregate operations. The following example illustrates an aggregate operation using Stream and IntStream:

```
     int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();
```
    
    To perform a computation, stream operations are composed into a stream pipeline. A stream pipeline consists of a source (which might be an array, a collection, a generator function, an I/O channel, etc), zero or more intermediate operations (which transform a stream into another stream, such as filter(Predicate)), and a terminal operation (which produces a result or side-effect, such as count() or forEach(Consumer)). Streams are lazy; computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed. 

+ https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html

### Side-effects on Streams Discussion

+ https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/package-summary.html#SideEffects



## Java Reflection

+ https://www.oracle.com/technical-resources/articles/java/javareflection.html