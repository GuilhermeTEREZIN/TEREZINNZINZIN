//BRA , ARG , COL , PAR , URU, CHI, EQU, VEN, RUS, POR, ITA   
public enum Pais {
    BRA("BRASIL"),
    ARG("ARGENTINA"),
    COL("COLOMBIA"),
    PAR("PARAGUAI"),
    URU("URUGUAI"),
    CHI("CHILE"),
    EQU("EQUADOR"),
    VEN("VENEZUELA"),
    RUS("RUSSIA"),
    POR("PORTUGAL"),
    ITA("ITALIA");
    
    private String nacionalidade;
    Pais(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }
    public String getNacionalidade(){return nacionalidade;} 
}