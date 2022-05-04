public class Inmueble {
    private String tipo;
    private String ubicacion;
    private float tamanioArea;
    private float precio;
    private int numCuartos;
    private int numBanios;
    private String descripcion;
    private String foto;
    private float precioLista;
    private boolean status;

    public Inmueble(String tipo, String ubicacion, float tamanioArea, float precio, int numCuartos, int numBanios, String descripcion, String foto, float precioLista, boolean status) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.tamanioArea = tamanioArea;
        this.precio = precio;
        this.numCuartos = numCuartos;
        this.numBanios = numBanios;
        this.descripcion = descripcion;
        this.foto = foto;
        this.precioLista = precioLista;
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getTamanioArea() {
        return tamanioArea;
    }

    public void setTamanioArea(float tamanioArea) {
        this.tamanioArea = tamanioArea;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumCuartos() {
        return numCuartos;
    }

    public void setNumCuartos(int numCuartos) {
        this.numCuartos = numCuartos;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(float precioLista) {
        this.precioLista = precioLista;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
