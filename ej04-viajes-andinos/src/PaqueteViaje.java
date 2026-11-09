public class PaqueteViaje {

    // Atributos si o si
    private final String destino;
    private final int noches;
    private final boolean vuelo;
    private final String hotel;
    private final boolean desayuno;
    private final String tour;
    private final boolean seguroViaje;


    private PaqueteViaje(Builder builder) {
        this.destino = builder.destino;
        this.noches = builder.noches;
        this.vuelo = builder.vuelo;
        this.hotel = builder.hotel;
        this.desayuno = builder.desayuno;
        this.tour = builder.tour;
        this.seguroViaje = builder.seguroViaje;
    }


    public static class Builder {

        private String destino;
        private int noches;

        private boolean vuelo = false;
        private String hotel = null;
        private boolean desayuno = false;
        private String tour = null;
        private boolean seguroViaje = false;

        // Constructor obligatorio con los parámetros esenciales
        public Builder(String destino, int noches) {
            if (destino == null || destino.trim().isEmpty()) {
                throw new IllegalArgumentException("El destino es obligatorio.");
            }
            if (noches < 1) {
                throw new IllegalArgumentException("El paquete debe tener al menos 1 noche. Rechazado: " + noches);
            }
            this.destino = destino;
            this.noches = noches;
        }


        public Builder conVuelo() {
            this.vuelo = true;
            return this;
        }

        public Builder conHotel(String hotel) {
            this.hotel = hotel;
            return this;
        }

        public Builder conDesayuno() {
            this.desayuno = true;
            return this;
        }

        public Builder conTour(String tour) {
            this.tour = tour;
            return this;
        }

        public Builder conSeguroViaje() {
            this.seguroViaje = true;
            return this;
        }

        // Build que construye :D
        public PaqueteViaje build() {
            return new PaqueteViaje(this);
        }
    }

    @Override
    public String toString() {
        return destino + " (" + noches + " noches)"
             + (vuelo ? " + vuelo" : "")
             + (hotel != null ? " + hotel " + hotel : "")
             + (desayuno ? " + desayuno" : "")
             + (tour != null ? " + tour " + tour : "")
             + (seguroViaje ? " + seguro" : "");
    }
}