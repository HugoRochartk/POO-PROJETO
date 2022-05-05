    import java.util.Objects;

public class Fornecedor {

        private int id;

        public Fornecedor(){
            this.id = 0;
        }

        public Fornecedor(int id){
            this.id = id;
        }

        public Fornecedor (Fornecedor forn){
            this.id = forn.getId();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fornecedor)) return false;
            Fornecedor that = (Fornecedor) o;
            return id == that.getId();
        }

        public String toString() {
            return "Fornecedor{" +
                    "id=" + id +
                    '}';
        }

        public Fornecedor clone(){
            return new Fornecedor(this);
        }

}

