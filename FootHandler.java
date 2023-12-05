package cor;

class FootHandler implements Handler {
    @Override
    public double handleRequest(double amount, String unit) {
        if ("FEET".equalsIgnoreCase(unit)) {
            return amount * 3281; 
        } else {
            System.out.println("Invalid unit");
            return -1;
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
    }
}