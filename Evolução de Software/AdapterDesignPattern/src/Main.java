public class Main {

    public static void main(String[] args) {
   
        //TomadaDeTresPinos t3 = new TomadaDeTresPinos();
        
        //AdapterTomada adapter = new AdapterTomada(t3);
        //adapter.ligarNaTomadaDeDoisPinos();
        
        Pse ps2 = new Pse();
        AdapterPs2ToUsb adapterUsb = new AdapterPs2ToUsb(ps2);
        adapterUsb.ligarNoUsb();
    }
    
}
