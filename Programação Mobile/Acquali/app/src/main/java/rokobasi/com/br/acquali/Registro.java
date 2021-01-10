package rokobasi.com.br.acquali;

public class Registro {

    // identificação agente
    private String uid;
    private String emailAgente;
    // bacias
    private String bacia;
    private String subBacia;
    private String acude;
    // atributos acude
    private String precipitacao;
    private String vazao;
    private String dbo;
    private String ft;
    private String nt;
    private String cl;
    private String cla;
    private String od;
    private String ph;
    private String turbidez;
    private String tipoDeCultura;
    private String tipoDeIrrigacao;
    private String metroQuadrado;
    // atributo controle
    private String data;

    public Registro() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmailAgente() {
        return emailAgente;
    }

    public void setEmailAgente(String emailAgente) {
        this.emailAgente = emailAgente;
    }

    public String getBacia() {
        return bacia;
    }

    public void setBacia(String bacia) {
        this.bacia = bacia;
    }

    public String getSubBacia() {
        return subBacia;
    }

    public void setSubBacia(String subBacia) {
        this.subBacia = subBacia;
    }

    public String getAcude() {
        return acude;
    }

    public void setAcude(String acude) {
        this.acude = acude;
    }

    public String getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(String precipitacao) {
        this.precipitacao = precipitacao;
    }

    public String getVazao() {
        return vazao;
    }

    public void setVazao(String vazao) {
        this.vazao = vazao;
    }

    public String getDbo() {
        return dbo;
    }

    public void setDbo(String dbo) {
        this.dbo = dbo;
    }

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getTurbidez() {
        return turbidez;
    }

    public void setTurbidez(String turbidez) {
        this.turbidez = turbidez;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoDeCultura() {
        return tipoDeCultura;
    }

    public void setTipoDeCultura(String tipoDeCultura) {
        this.tipoDeCultura = tipoDeCultura;
    }

    public String getTipoDeIrrigacao() {
        return tipoDeIrrigacao;
    }

    public void setTipoDeIrrigacao(String tipoDeIrrigacao) {
        this.tipoDeIrrigacao = tipoDeIrrigacao;
    }

    public String getMetroQuadrado() {
        return metroQuadrado;
    }

    public void setMetroQuadrado(String metroQuadrado) {
        this.metroQuadrado = metroQuadrado;
    }
}
