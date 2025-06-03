package Entidades;

public class Domicilio {

    //Tendria que ser private pero para probar mejor en public total solo es cambiar la llamada por el getter
     public String calle;
     public Integer numero;
     public Integer id;
     public String localidad;

    public Domicilio(String calle, Integer numero, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }
}