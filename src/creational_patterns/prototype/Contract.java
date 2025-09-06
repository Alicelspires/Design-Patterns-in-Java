package creational_patterns.prototype;

public class Contract extends Document{
    private String company;
    private String clauses;

    public Contract(String name, String company, String clauses){
        super(name);
        this.company = company;
        this.clauses = clauses;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setClauses(String clauses) {
        this.clauses = clauses;
    }

    @Override
    public Contract clone(){
        Contract copy = new Contract(this.name, this.company, this.clauses);
        copy.version = this.version;
        return copy;
    }

    @Override
    public void show(){
        System.out.println("\nContract ================================");
        generalInfo();
        System.out.println("Company: " + company);
        System.out.println("Clauses: " + clauses);
    }
}
