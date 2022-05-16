import java.util.Objects;

public class Fornecedor {

        private String string;

        public Fornecedor(){
            this.string = "";
        }

        public Fornecedor(String string){
            this.string = string;
        }

        public Fornecedor (Fornecedor forn){
            this.string = forn.getString();
        }

        public String getString() {
            return this.string;
        }

        public void setString(String string) {
            this.string = string;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fornecedor)) return false;
            Fornecedor that = (Fornecedor) o;
            return this.string.equalsIgnoreCase(that.getString());
        }

        public String toString() {
            return "Fornecedor{" +
                    "fornecedor=" + string +
                    '}';
        }

        
        public Fornecedor clone(){
            return new Fornecedor(this);
        }

}

