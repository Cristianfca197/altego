package edu.fiuba.algo3.modelo.objetivo;

public class ObjetivoDestruir implements Objetivo {

    private String titulo;
    private String equipoADestruir;

    public ObjetivoDestruir(String titulo, String equipoADestruir){
        this.titulo = titulo;
        this.equipoADestruir = equipoADestruir;

    }

    @Override
    public Boolean estaCumplido() {
        return true;
    }

    @Override
    public String obtenerTipo() {
        return "Destruir";
    }

    @Override
    public Integer paisesAConquistar(String string) {
        // No debe conquistar paises
        return 0;
    }


}
