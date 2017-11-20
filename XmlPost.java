package twittersort;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.*;
import java.util.List;

class XmlPost {

    public static void gravaXMLListaPost(List<Post> posts) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("ListaDePostagens", List.class);
 // xStream.alias("endereco", Endereco.class);

        File arquivo = new File("ListaDePostagens.xml");
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(posts).getBytes());
            gravar.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}