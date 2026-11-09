public class Boleta {

    private final String pelicula;   
    private final String silla;      
    private final boolean es3D;
    private final boolean sillaVip;
    private final String combo;      
    private final boolean estudiante;

    private Boleta(Builder builder) {
        this.pelicula = builder.pelicula;
        this.silla = builder.silla;
        this.es3D = builder.es3D;
        this.sillaVip = builder.sillaVip;
        this.combo = builder.combo;
        this.estudiante = builder.estudiante;
    }

    public String getSilla() { return silla; }

    public static class Builder {
        private String pelicula;
        private String silla;
        
        private boolean es3D = false;
        private boolean sillaVip = false;
        private String combo = null;
        private boolean estudiante = false;

        public Builder(String pelicula, String silla) {
            if (pelicula == null || pelicula.trim().isEmpty()) {
                throw new IllegalArgumentException("La pelicula es obligatoria");
            }
            if (silla == null || silla.trim().isEmpty()) {
                throw new IllegalArgumentException("La silla es obligatoria");
            }
            this.pelicula = pelicula;
            this.silla = silla;
        }

        public Builder con3D() { this.es3D = true; return this; }
        public Builder conSillaVip() { this.sillaVip = true; return this; }
        public Builder conCombo(String combo) { this.combo = combo; return this; }
        public Builder conTarifaEstudiante() { this.estudiante = true; return this; }

        public Boleta build() { return new Boleta(this); }
    }

    @Override
    public String toString() {
        return pelicula + " | silla " + silla
             + (es3D ? " | 3D" : "")
             + (sillaVip ? " | VIP" : "")
             + (combo != null ? " | combo " + combo : "")
             + (estudiante ? " | tarifa estudiante" : "");
    }
}