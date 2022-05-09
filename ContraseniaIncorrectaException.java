public class ContraseniaIncorrectaException extends Exception {
    ContraseniaIncorrectaException(String mensaje){
        super(mensaje);
    }

    ContraseniaIncorrectaException(){
        this("El usuario o la contraseña son incorrectos.");
    }

}
