//GO ZAG LE LD MLG MEI CA PTE PTD VOL
public enum Posicao {
    GO("GOLEIRO"),
    ZAG("ZAGUEIRO"),
    LE("LATERAL ESQUERDO"),
    LD("LATERAL DIREITO"),
    MLG("MEIA DE LIGACAO"),
    MEI("MEIO CAMPO"),
    CA("CENTRO AVANTE"),
    PTE("PONTA ESQUERDA"),
    PTD("PONTA DIREITA"),
    VOL("VOLANTE"),
    
    
    private String posi;
    Posicao(String posi){
        this.posi = posi;
    }
    public String getPosi(){return posi;} 
}