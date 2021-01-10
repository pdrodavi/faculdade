public class AdapterPs2ToUsb extends Usb {
    
    private Pse entradaPs2;
    
    public AdapterPs2ToUsb(Pse ps2){
        this.entradaPs2 = ps2;
    }
    
    public void ligarNoUsb(){
        entradaPs2.ligarNoUsb();
    }
    
}

  
