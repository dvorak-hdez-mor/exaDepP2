
public class TipoDatoIncorrectoException extends Exception {
    TipoDatoIncorrectoException(String mensaje){
        super(mensaje);
    }
    
    TipoDatoIncorrectoException(){
        this("El dato que ingreso no corresponde a su tipo.");
    }
}
