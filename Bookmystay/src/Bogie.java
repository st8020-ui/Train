public class Bogie {
    private String type;
    private String cargo;

    public Bogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // Cargo assignment with safety handling
    public void assignCargo(String cargo) {

        try {
            // Rule: Rectangular bogie cannot carry Petroleum
            if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned successfully");

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment attempted for bogie: " + type);
        }
    }
}
