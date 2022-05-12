public class ContraseniaIncorrectaException extends Exception {
    ContraseniaIncorrectaException(String mensaje){
        super(mensaje);
    }

    ContraseniaIncorrectaException(){
        this("La contraseña es incorrecta.");
    }

}
