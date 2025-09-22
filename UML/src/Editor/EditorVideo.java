package Editor;

public class EditorVideo {
    public void exportar(String formato, Proyecto proyecto) {
        Render render = new Render(formato, proyecto);
        System.out.println("Exportando proyecto '" + proyecto.getNombre() + "' al formato '" + render.getFormato() + "'");
    }
}
