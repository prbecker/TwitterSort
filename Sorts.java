package twittersort;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.JOptionPane;
import java.lang.Object;
import java.util.Collections;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Sorts {

    public static List sorts()  {
        
        Twitter twitter = new TwitterFactory().getInstance();
        ArrayList<Post> postagens = new ArrayList<Post>();
        List<Post> ordena = new ArrayList<Post>();
        meuComparadorData comparatorData = new meuComparadorData();
        meuComparadorUser comparatorUser = new meuComparadorUser();
        meuComparadorRT comparatorRT = new meuComparadorRT();
        meuComparadorDataDec comparatorDataDec = new meuComparadorDataDec();
        meuComparadorUserDec comparatorUserDec = new meuComparadorUserDec();
        meuComparadorRTDec comparatorRTDec = new meuComparadorRTDec();
        int[] postagensRT = new int[25];
        String lista;
        int indice = 0;
        
        twitter.setOAuthConsumer("NONXhE30M33aMu2ZpMwXXIFOT", "1VsYq25Cu26fqSrvoJWUqIaOCxScb56WAxJPMbZy4OTNTs8hwy");
        twitter.setOAuthAccessToken(new AccessToken("203107631-oY2p0Zh9HzGn9NfvJdyMWCjUTtCH0yRukGmNZTPe", "pK3nkYxIMQYbRVDDp8xBbLABstjZjFIY488dlBkepVaRV"));

        try {

            ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1, 26));
            String userName = twitter.getScreenName();

            for (Status b : a) {
                Post estrutura = new Post();

                //System.out.println(b.getText());
                //System.out.println(b.getCreatedAt());
                //System.out.println(b.getRetweetCount());
                //System.out.println(b.getUser());
                //System.out.println(userName);
                //System.out.println();                                
                estrutura.setUser(b.getUser().getScreenName());
                estrutura.setData(b.getCreatedAt());
                estrutura.setPost(b.getText());
                estrutura.setRetweet(b.getRetweetCount());
                estrutura.setId(b.hashCode());

                postagens.add(estrutura);
                

                ordena.add(estrutura);
                postagensRT[indice] = estrutura.getRetweet();
               
               // System.out.println(postagensRT[indice]);
               // indice++;
            }
            
            //Comparador de Data crescente
            //Collections.sort(ordena, comparatorData);
            //Comparador de User crescente
            //Collections.sort(ordena, comparatorUser);
            //Comparador de RT crescente
            //Collections.sort(ordena, comparatorRT);
            
            //Comparador de Data decrescente
            //Collections.sort(ordena, comparatorDataDec);
            //Comparador de User decrescente
            //Collections.sort(ordena, comparatorUserDec);
            //Comparador de RT decrescente
            //Collections.sort(ordena, comparatorRTDec);
            
            System.out.println(ordena);
            
        } catch (Exception e) {

        }

        return ordena;
    }

}
