package utilidades;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class HandlerSAX extends DefaultHandler {
    private int indicadorFila =0;
    private int indicadorColum =0;
    private final StringBuilder BUILDER = new StringBuilder();
    private final String[] FILA_TABLA = new String[4];
    private final List<String> ELEMENTOS = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String nombreEtiqueta, Attributes attributes){
        if(attributes.getLength()>0){
            ELEMENTOS.add(attributes.getValue(0));
        }
        if(indicadorFila >=1 && indicadorColum <4) {
            if(indicadorColum==0 && attributes.getLength()>0){
                FILA_TABLA[indicadorColum]=attributes.getLocalName(0);
            }
            else{
                FILA_TABLA[indicadorColum]=nombreEtiqueta;
            }
            indicadorColum++;
        }
        indicadorFila++;
    }

    @Override
    public void endDocument(){
        System.out.println(getTabla());
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        indicadorFila--;
    }

    @Override
    public void characters(char[] ch, int start, int length){
        String cadena=new String(ch, start, length);
        if (!(cadena.trim().length() == 0))
            ELEMENTOS.add(cadena);
    }

    public String getTabla() {
        for (String string : FILA_TABLA) {
            BUILDER.append(String.format("%-20s", string.toUpperCase().charAt(0)+string.substring(1)));
        }
        BUILDER.append(System.lineSeparator());
        BUILDER.append("-".repeat(80));
        BUILDER.append(System.lineSeparator());
        for (int i = 1; i <= ELEMENTOS.size(); i++) {
            BUILDER.append(String.format("%-20s", ELEMENTOS.get(i-1)));
            if (i%4==0)
                BUILDER.append(System.lineSeparator());
        }
        return BUILDER.toString();
    }
}
