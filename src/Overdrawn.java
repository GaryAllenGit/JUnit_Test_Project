class Overdrawn extends Exception {

    public Overdrawn(){
    }

    public Overdrawn(String message){
        super(message);
    }
}