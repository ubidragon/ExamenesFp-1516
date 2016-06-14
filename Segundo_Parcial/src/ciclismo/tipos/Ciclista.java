package fp.fciclismo.tipos;



public interface Ciclista extends Comparable<Ciclista> {
//Orden natural por nombre del cilista
String getNombre();
LocalDate getFechaNacimiento();
String getPais();

}