package unet.compiladores.db;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.util.List;
import unet.compiladores.diagramas.modelo.componentes.Compilador;


/**
 *
 * @author orlandobcrra
 */
public class Prueba {

    public static void main(String[] args) {
        // accessDb4o
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba");
        try {
            Compilador c=new Compilador();
            c.setDatos("uno","dos","tres");
            db.store(c);
            List <Compilador> pilots=db.query(Compilador.class);
            for (int i = 0; i < pilots.size(); i++) {
                Compilador compilador = pilots.get(i);
                System.out.println(compilador);
            }
            System.out.println("--");
            Compilador cx=(Compilador) db.queryByExample(c).get(0);
            System.out.println(db.queryByExample(c).size());
            System.out.println(cx);
        } finally {
            db.close();
        }
    }
}
