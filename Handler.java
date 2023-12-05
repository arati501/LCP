package cor;

interface Handler {
    double handleRequest(double amount, String unit);
    void setNextHandler(Handler nextHandler);
}