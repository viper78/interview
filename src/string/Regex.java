package string;

/**
 * Created by rajeshsubramanian on 3/14/18.
 */
public class Regex {

    public void replace(String str){
        System.out.println(str.replaceAll( "\\s{2,}", "" ));
    }

    public static void main(String args[]){
        String str = "     This is Tushar   Roy  ";
        Regex mrs = new Regex();
        mrs.replace(str);

        String url = "Mr John Smith    ";
        url = url.replaceAll( "\\s{2,}", "" );
        url = url.replaceAll( "\\s", "%20" );
        System.out.println(url);
    }
}
