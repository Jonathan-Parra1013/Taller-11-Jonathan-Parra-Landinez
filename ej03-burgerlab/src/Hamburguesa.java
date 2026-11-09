public class Hamburguesa {

    private String proteina;
    private int porciones;
    private String pan;
    private boolean queso;
    private boolean tocineta;
    private boolean cebollaCaramelizada;
    private boolean pepinillos;
    private String salsa;
    private boolean papasAgrandadas;


    private Hamburguesa(Builder builder) {
        this.proteina = builder.proteina;
        this.porciones = builder.porciones;
        this.pan = builder.pan;
        this.queso = builder.queso;
        this.tocineta = builder.tocineta;
        this.cebollaCaramelizada = builder.cebollaCaramelizada;
        this.pepinillos = builder.pepinillos;
        this.salsa = builder.salsa;
        this.papasAgrandadas = builder.papasAgrandadas;
    }

    public static class Builder {
        // Atributos obligatorios
        private String proteina;
        private int porciones;

        // Atributos opcionales con valores por defecto
        private String pan = "brioche";
        private String salsa = "ninguna";
        private boolean queso = false;
        private boolean tocineta = false;
        private boolean cebollaCaramelizada = false;
        private boolean pepinillos = false;
        private boolean papasAgrandadas = false;

        // El constructor del Builder exige los obligatorios
        public Builder(String proteina, int porciones) {
            if (porciones < 1 || porciones > 3) {
                throw new IllegalArgumentException("El numero de porciones debe estar entre 1 y 3. Rechazado: " + porciones);
            }
            this.proteina = proteina;
            this.porciones = porciones;
        }

       
        public Builder conPan(String pan) {
            this.pan = pan;
            return this;
        }

        public Builder conQueso() {
            this.queso = true;
            return this;
        }

        public Builder conTocineta() {
            this.tocineta = true;
            return this;
        }

        public Builder conCebollaCaramelizada() {
            this.cebollaCaramelizada = true;
            return this;
        }

        public Builder conPepinillos() {
            this.pepinillos = true;
            return this;
        }

        public Builder conSalsa(String salsa) {
            this.salsa = salsa;
            return this;
        }

        public Builder conPapasAgrandadas() {
            this.papasAgrandadas = true;
            return this;
        }

        // build comnstruye la hamburguesa jeje :D
        public Hamburguesa build() {
            return new Hamburguesa(this);
        }
    }

    @Override
    public String toString() {
        return "Hamburguesa de " + proteina + " x" + porciones
             + " | pan: " + pan
             + (queso ? " | queso" : "")
             + (tocineta ? " | tocineta" : "")
             + (cebollaCaramelizada ? " | cebolla caramelizada" : "")
             + (pepinillos ? " | pepinillos" : "")
             + " | salsa: " + salsa
             + (papasAgrandadas ? " | papas agrandadas" : "");
    }
}