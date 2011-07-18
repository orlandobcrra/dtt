/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unet.compiladores.diagramas.modelo.util;

import unet.compiladores.diagramas.modelo.componentes.Compilador;
import unet.compiladores.diagramas.modelo.componentes.Interprete;
import unet.compiladores.diagramas.modelo.componentes.Maquina;
import unet.compiladores.diagramas.modelo.componentes.Programa;
import java.awt.Point;


/**
 *
 * @author james
 */
public class UnirFiguras {
    
    public static void unirCompiladorMaquina(Compilador c, Maquina m){
        if ( c.getUnidos()[1] == null
                && m.getUnidos()[0] == null
                && c.getUnidos()[3]!=null
                && c.getUnidos()[2]!=null
                &&  c.getImplementacion().equals(m.getNombre())) {
            c.getUnidos()[1] = m;
            m.getUnidos()[0] = c;
        }
    }
    
    public static void unirInterpreteMaquina(Interprete i, Maquina m){
        if ( i.getUnidos()[1] == null
                && m.getUnidos()[0] == null
                &&  i.getM().equals(m.getNombre())) {
            i.getUnidos()[1] = m;
            m.getUnidos()[0] = i;
        }
    }
    public static void unirProgramaMaquina(Programa p, Maquina m){
        if ( p.getUnidos()[1] == null
                && m.getUnidos()[0] == null
                && p.getUnidos()[1] == null
                && p.getUnidos()[2] == null
                && p.getUnidos()[3] == null
                && p.getLenguaje().equals(m.getNombre())) {
                    p.getUnidos()[1] = m;
                    m.getUnidos()[0] = p;
        }
    }
    
     public static void unirInterpreteCompilador(Interprete i, Compilador c){
        if ( i.getUnidos()[0] == null
                && c.getUnidos()[1] == null
                &&  i.getL().equals(c.getImplementacion())) {
            i.getUnidos()[0] = c;
            c.getUnidos()[1] = i;
        }
    }
     public static void unirCompiladorCompilador(Compilador ca, Compilador c){
        if ( c.isYoEncimaYaMiDerecha()
                && ca.getUnidos()[3] == null
                && c.getUnidos()[2] == null
                && ca.getFuente().equals(c.getImplementacion())){
            ca.getUnidos()[3]=c;
            c.getUnidos()[2]=ca;
        }
        if ( !c.isYoEncimaYaMiDerecha()
                && ca.getUnidos()[2] == null
                && c.getUnidos()[3] == null
                && ca.getObjeto().equals(c.getImplementacion())){
            ca.getUnidos()[2]=c;
            c.getUnidos()[3]=ca;
        }
    }
 
     public static void unirProgramaCompilador(Programa p, Compilador c,boolean aLaDerechaDelPrograma){
        if (aLaDerechaDelPrograma
                && p.getUnidos()[2] == null
                && c.getUnidos()[3] == null
                && p.getLenguaje().equals(c.getFuente())){
            p.getUnidos()[2] = c;
            c.getUnidos()[3] = p;
        }
        if (!aLaDerechaDelPrograma
                && p.getUnidos()[3] == null
                && c.getUnidos()[2] == null
                && p.getLenguaje().equals(c.getObjeto())){
            p.getUnidos()[3] = c;
            c.getUnidos()[2] = p;
        }
    }
     
       public static void unirProgramaInterprete(Programa p, Interprete i){
        if (p.getUnidos()[1]==null
                && i.getUnidos()[0] == null
                && p.getUnidos()[2]== null
                && p.getUnidos()[3]== null
                && p.getLenguaje().equals(i.getL())){
            p.getUnidos()[1] = i;
            i.getUnidos()[0] = p;
        }
    }
       public static void pegarCompiladorInterprete(Compilador c, Interprete i){
           if(c.getUnidos()[1] == null
                   && i.getUnidos()[0] == null
                   && c.getImplementacion().equals(i.getL())){
            Point px = new Point(c.getPosicion().x, c.getPosicion().y);
            px.x += i.getTAM();
            px.y += i.getTAM() * 2;
            i.posicionar(px, true);
           }
       }
         public static void pegarProgramaInterprete(Programa p, Interprete i){
           if(p.getUnidos()[1] == null
                   && i.getUnidos()[0] == null
                   && p.getUnidos()[2] == null
                   && p.getUnidos()[3] == null
                   && p.getLenguaje().equals(i.getL())){
            Point px = new Point(p.getPosicion().x, p.getPosicion().y);
            px.x += 0;
            px.y += i.getTAM();
            i.posicionar(px, true);
           }
       }     
         
          public static void pegarMaquinaInterprete(Maquina m, Interprete i){
           if(m.getUnidos()[0] == null
                   && i.getUnidos()[1] == null
                   && m.getNombre().equals(i.getM())){
            Point px = new Point(m.getPosicion().x, m.getPosicion().y);
            px.y -= i.getTAM()*2;
            i.posicionar(px, true);
           }
       }
          public static void pegarMaquinaInterprete(Interprete i, Maquina m){
           if(i.getUnidos()[1] == null
                   && m.getUnidos()[0] == null
                   && m.getNombre().equals(i.getM())){
            Point px = new Point(i.getPosicion().x, i.getPosicion().y);
            px.y += i.getTAM()*2;
            m.posicionar(px, true);
           }
       }
          
          public static void pegarMaquinaCompilador(Maquina m, Compilador c){
           if(m.getUnidos()[0] == null
                   && c.getUnidos()[1] == null
                   && c.getUnidos()[3]!=null
                   && c.getUnidos()[2]!=null
                   && m.getNombre().equals(c.getImplementacion())){
            Point px = new Point(m.getPosicion().x, m.getPosicion().y);
            px.x -= c.getTAM();
            px.y -= c.getTAM()*2;
            c.posicionar(px, true);
            
           }
       }
         public static void pegarMaquinaCompilador(Compilador c, Maquina m){
           if(c.getUnidos()[1] == null
                   && c.getUnidos()[3]!=null
                   && c.getUnidos()[2]!=null
                   && m.getUnidos()[0] == null
                   && m.getNombre().equals(c.getImplementacion())){
            Point px = new Point(c.getPosicion().x, c.getPosicion().y);
            px.x += m.getTAM();
            px.y += m.getTAM()*2;
            m.posicionar(px, true);
            
           }
       }
          
          public static void pegarCompiladorInterprete(Interprete i, Compilador c){
           if(i.getUnidos()[0] == null
                   && c.getUnidos()[1] == null
                   && c.getImplementacion().equals(i.getL())){
            Point px = new Point(i.getPosicion().x, i.getPosicion().y);
            px.x -= c.getTAM();
            px.y -= c.getTAM() * 2;
            c.posicionar(px, true);
           }
       }
          public static void pegarProgramaCompilador(Programa p, Compilador c){
              if (c.getPosicion().x <= p.getPosicion().x + (c.getTAM() / 2)) { // por la izq
                if ((p.getUnidos()[3] == null && c.getUnidos()[2] == null) 
                    && (p.getLenguaje().equals(c.getObjeto()))){
                    Point px = new Point(p.getPosicion().x, p.getPosicion().y);
                    px.x -= 3 * c.getTAM();
                    c.posicionar(px, true);
                    c.setYoEncimaYaMiDerecha(false);
                    }
            }
           if (c.getPosicion().x > p.getPosicion().x + (c.getTAM() / 2)) { // por la derecha
                if ((p.getUnidos()[2] == null && c.getUnidos()[3] == null)
                        && p.getLenguaje().equals(c.getFuente())) {
                    Point px = new Point(p.getPosicion().x, p.getPosicion().y);
                    px.x += c.getTAM();
                    c.posicionar(px, true);
                    c.setYoEncimaYaMiDerecha(true);
                }
            }  
       }
          public static void pegarCompiladorCompilador(Compilador ca, Compilador c){
              if (c.getPosicion().x <= ca.getPosicion().x + (3 * c.getTAM() / 2)) { // yo encima y por mi derecha
                if ((ca.getUnidos()[3] == null && c.getUnidos()[2] == null) 
                    && ca.getFuente().equals(c.getImplementacion())){
                    Point px = new Point(ca.getPosicion().x, ca.getPosicion().y);
                    px.y -= c.getTAM();
                    px.x -= 2 * c.getTAM();
                    c.posicionar(px, true);
                    c.setYoEncimaYaMiDerecha(true);
                }
            }
               if (c.getPosicion().x > ca.getPosicion().x + (3 * c.getTAM() / 2)) {
                if ((ca.getUnidos()[2] == null && c.getUnidos()[3] == null) 
                    && (ca.getObjeto().equals(c.getImplementacion()))) {
                    Point px = new Point(ca.getPosicion().x, ca.getPosicion().y);
                    px.y -= c.getTAM();
                    px.x += 2 * c.getTAM();
                    c.posicionar(px, true);
                    c.setYoEncimaYaMiDerecha(false);
                }
            }
          }
          
          public static void pegarProgramaMaquina(Programa p, Maquina m){
              if(p.getUnidos()[1] == null
                && m.getUnidos()[0] == null
                && p.getUnidos()[2] == null
                && p.getUnidos()[3] == null
                && p.getLenguaje().equals(m.getNombre())){
            Point px = new Point(p.getPosicion().x, p.getPosicion().y);
            px.y += m.getTAM();
            m.posicionar(px, true);
            }
          
          }
           public static void pegarProgramaCompilador(Compilador c, Programa p){
            if (p.getPosicion().x <= c.getPosicion().x + (3 * p.getTAM() / 2)) {
                if ((c.getUnidos()[3] == null && p.getUnidos()[2] == null)
                    && (c.getFuente().equals(p.getLenguaje()))){
                    Point px = new Point(c.getPosicion().x, c.getPosicion().y);
                    px.x -= p.getTAM();
                    p.posicionar(px, true);
                    p.setaLaDerechaDelPrograma(true);
                    }
            }
            
              if (p.getPosicion().x > c.getPosicion().x + (3 * p.getTAM() / 2)) {
                if ((c.getUnidos()[2] == null && p.getUnidos()[3] == null )
                   && c.getObjeto().equals(p.getLenguaje())){
                    Point px = new Point(c.getPosicion().x, c.getPosicion().y);
                    px.x += 3 * p.getTAM();
                    p.posicionar(px, true);
                    p.setaLaDerechaDelPrograma(false);
                }
            }
         }
           
         public static void pegarProgramaInterprete(Interprete i, Programa p){
           if(i.getUnidos()[0] == null
                   && p.getUnidos()[1] == null
                   && p.getLenguaje().equals(i.getL())){
            Point px = new Point(i.getPosicion().x, i.getPosicion().y);
            px.x += 0;
            px.y -= p.getTAM();
            p.posicionar(px, true);
           }
       }  
           public static void pegarProgramaMaquina(Maquina m, Programa p){
              if(m.getUnidos()[0] == null
                && p.getUnidos()[1] == null
                && p.getLenguaje().equals(m.getNombre())){
            Point px = new Point(m.getPosicion().x, m.getPosicion().y);
            px.y -= p.getTAM();
            p.posicionar(px, true);
            }
          
          }
          
          
    
}
