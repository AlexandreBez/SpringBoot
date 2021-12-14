package home.MVCandThymeleaf.api.model.components;

public enum UFEnum {
    
    AM("AM", "Manaus"),
    AL("AL", "Maceió"),
    AC("AC", "Rio Branco"),
    AP("AP", "Macapá"),
    BA("BA", "Salvador"),
    PA("PA", "Belém"),
    MT("MT", "Cuiabá"),
    MG("MG", "Belo Horizonte"),
    MS("MS", "Campo Grande"),
    GO("GO", "Goiânia"),
    MA("MA", "São Luís"),
    RS("RS", "Porto Alegre"),
    TO("TO", "Palmas"),
    PI("PI", "Teresina"),
    SP("SP", "São Paulo"),
    RO("RO", "Porto Velho"),
    RR("RR", "Boa Vista"),
    PR("PR", "Curitiba"),
    CE("CE", "Fortaleza"),
    PE("PE", "Recife"),
    SC("SC", "Florianópolis"),
    PB("PB", "João Pessoa"),
    RN("RN", "Natal"),
    ES("ES", "Vitória"),
    RJ("RJ", "Rio de Janeiro"),
    SE("SE", "Aracaju"),
    DF("DF", "Brasília");

    private String sigla;
    private String descricao;

    UFEnum(String sigla, String descricao){
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

}