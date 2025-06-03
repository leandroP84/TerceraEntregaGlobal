package Entidades;

public class Persona {

    //Tendria que ser private pero para probar mejor en public total solo es cambiar la llamada por el getter
     public Integer edad;
     public String nombre;
     public Integer id;
     public Domicilio domicilio;

    public Persona(String nombre, Integer edad) {
        this.edad = edad;
        this.nombre = nombre;
    }


}