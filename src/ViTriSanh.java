public enum ViTriSanh {
    TANG_1,
    TANG_2;
    public String getVitri(){
        switch (this){
            case TANG_1 -> {return "Tang 1";}
            case TANG_2 -> {return "Tang 2";}
            default -> {return null;}
        }
    }
}
