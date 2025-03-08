class Customer {
    private String name;
    private String phone;
    private int tableNumber;

    public Customer(String name, String phone, int tableNumber) {
        this.name = name;
        this.phone = phone;
        this.tableNumber = tableNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.matches("\\d{10}")) { 
            this.phone = phone;
        } else {
            System.out.println("Invalid phone number.");
        }
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        if (tableNumber > 0) {
            this.tableNumber = tableNumber;
        } else {
            System.out.println("Table number must be positive.");
        }
    }
}
