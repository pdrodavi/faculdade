public class AdapterTomada extends TomadaDoisPinos {
    
    private TomadaDeTresPinos tomadaDeTresPinos;
    
    public AdapterTomada(TomadaDeTresPinos tomadaDeTresPinos){
        this.tomadaDeTresPinos = tomadaDeTresPinos;
    }
    
    public void ligarNaTomadaDeDoisPinos(){
        tomadaDeTresPinos.ligarNaTomadaDeTresPinos();
    }
    
}
