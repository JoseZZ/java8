# java8

## Expresiones lambda
1. Una expresion lambda es una forma mas sencilla de expresar una instancia de una clase anonima.
    
    ```java
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    };
    ```
    Puede expresarse como:
    
    ```
    Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
    ```
2. ¿Cual es el tipo de una expresion lambda?
    
    El tipo es una interfaz funcional.
    
3. ¿Puede guardarse una expresion lambda en una variable?
    
    Si, por lo que se pueden usar como parámetros o valor de retorno.

4. ¿Una expresion lambda es un objeto?

    Una expresion lambda se crea sin usar el comando *new*. Cuando se usa el comando new, se solicita memoria para el nuevo objeto, se limpia dicha memoria, se ejecuta el inicializadores estaticos, los bloques estáticos, los inicializadores no estáticos, los bloques no estaticos, y finalmente el constructor del objeto, incluyendo toda su jerarquia de superclases.
    Cuando se usa una expresion lambda no se hace todo eso, por lo que en terminos de rendimiento es mucho mejor, pero aun asi se esta guardando un objeto en la JVM. LA respuesta es que se trata de un nuevo tipo de objeto, un objeto sin una identidad. Una expresion lambda no es un objeto del que se puedan llamar a sus metodos, sino que es un bloque de codigo que se utiliza junto.
    
## Interfaz funcional

+ Es una interfaz con un solo método abstracto.

    ```java
    public interface Runnable{
        run();
    }
    ```
+ Los métodos de la clase Object no cuentan (equals, toString, etc).
+ Una interfaz funcional puede anotarse con *@FunctionalInterface*. Esta anotación sirve para que el compilador nos diga si es una interfaz funcional o no.
+ Java 8 ofrece hasta 43 interfaces funcionales en el paquete java.util.function. Las más usadas son:

## Interface de *java.util.function* mas usadas
### Suplier

No acepta ningun objeto y devuelve un objeto.
  
```java
  @FunctionalInterface
  public interface Supplier<T> {
      T get();  
  }
```
###Consumer
Acepta un objeto y no devuelve nada.
        
  ```java
  @FunctionalInterface
  public interface Consumer<T> {
      void accept(T t);
  }
```
 
BiConsumer: acepta dos objetos, que pueden ser de tipos distintos, y no devuelve nada.
          
   ```java
    @FunctionalInterface
    public interface BiConsumer<T, U> {
        void accept(T t, U u);
    }
  ```
      
###Predicate
Acepta un objeto como parametro y devuelve un boolean.
            
 ```java
  @FunctionalInterface
  public interface Predicate<T> {
      boolean test(T t);
  }
```
    
BiPredicate: acepta dos objetos como parametros, que pueden ser de distinto tipo, y devuelve un boolean.
              
   ```java
    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }
  ```
### Function
Toma un objeto como parámetro y devuelve otro objecto.

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```
BiFunctional: toma dos objetos como parámetro y devuelve uno.

```java
@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
```

UnaryOperator: toma un objeto y devuelve un objeto del mismo tipo

```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
}
```

BinaryOperator: toma dos objetos del mismo tipo y devuelve un objeto del mismo tipo

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
}
```
