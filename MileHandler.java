package cor;

class MileHandler implements Handler {
    private Handler nextHandler;

    @Override
    public double handleRequest(double amount, String unit) {
        if ("MILE".equalsIgnoreCase(unit)) {
            return amount; 
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