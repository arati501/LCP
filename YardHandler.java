package cor;

class YardHandler implements Handler {
    private Handler nextHandler;

    @Override
    public double handleRequest(double amount, String unit) {
        if ("YARD".equalsIgnoreCase(unit)) {
            return amount * 1094; 
        } else if (nextHandler != null) {
            return nextHandler.handleRequest(amount, unit);
        } else {
            System.out.println("Invalid unit");
            return -1;
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
