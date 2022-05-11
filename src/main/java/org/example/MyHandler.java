package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

public class MyHandler implements HttpHandler {

    public void handle(HttpExchange t) throws IOException {
        InputStream is = t.getRequestBody();

        URI uri = t.getRequestURI();
        String query = uri.getQuery();
        String res="";
        String splitted[] = new String[0];
        int ecc=0;
        if(!query.contains("&") || !query.contains("=")) res="Parametri passati errati";
        else {
            splitted = query.split("&");
            ecc=1;
        }

        int somma=0;
        if (ecc==1) {
            for (int i = 0; i < splitted.length; i++) {
                String[] resplitted = splitted[i].split("=");
                if (resplitted[0].contains("num")){
                    try{
                        Integer.parseInt(resplitted[1]);
                    }catch(NumberFormatException n){
                        res="parametro dopo = not an integer";
                        break;
                    }
                    somma = somma + Integer.parseInt(resplitted[1]);
                }
                else {
                    res = "Parametro errato";
                    break;
                }
                res = Integer.toString(somma);
            }
        }
        System.out.println(somma);
        String s = read(is); // .. read the request body

        String response = "<!doctype html>\n" +
                "<html lang=en>\n" +
                "<head>\n" +
                "<meta charset=utf-8>\n" +
                "<title>MyJava Sample</title>\n" +
                "</head>\n" +
                "<body>\n" +

                "</br>I'm the content" +
                "</br>\n" +
                s +

                "</br>query:" +
                "</br>\n" +
                query + "<h3>Risultato operazione</h3><br>"+number(res)+
                "</body>\n" +
                "</html>\n";

        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String number(String res){
        String link[] = new String[11];
        link[0]="https://www.kindpng.com/picc/m/407-4079776_number-zero-png-0-png-transparent-png.png";
        link[1]="https://esquilo.io/png/thumb/vj9m09OLDtkDOHB-Vector-Number-1-PNG-HD.png";
        link[2]="https://www.pngplay.com/wp-content/uploads/5/Number-2-No-Background.png";
        link[3]="https://www.kindpng.com/picc/m/273-2736019_number-3-png-black-number-3-png-transparent.png";
        link[4]="https://www.pngplay.com/wp-content/uploads/5/Number-4-Download-Free-PNG.png";
        link[5]="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ZI83DRtYl66F2Xawtxaw2WupUV4xurMqeQ&usqp=CAU";
        link[6]="https://icon2.cleanpng.com/20171220/grq/number-6-png-5a3a8735542046.5204665215137851413446.jpg";
        link[7]="https://www.kindpng.com/picc/m/117-1175117_number-7-on-a-transparent-background-hd-png.png";
        link[8]="https://icon2.cleanpng.com/20171220/ove/number-8-png-5a3a86fd760b34.7946325115137850854835.jpg";
        link[9]="https://png.pngitem.com/pimgs/s/462-4627994_9-png-image-without-background-number-9-transparent.png";
        link[10]="https://upload.wikimedia.org/wikipedia/commons/e/ec/Minus_symbol.svg";
        String result="";
        String passed=res;
        String []splitted=passed.split("");
        for(int i=0; i<splitted.length; i++){
            switch (splitted[i]){
                case "0":
                    result=result+"<img src=\""+link[0]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "1":
                    result=result+"<img src=\""+link[1]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "2":
                    result=result+"<img src=\""+link[2]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "3":
                    result=result+"<img src=\""+link[3]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "4":
                    result=result+"<img src=\""+link[4]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "5":
                    result=result+"<img src=\""+link[5]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "6":
                    result=result+"<img src=\""+link[6]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "7":
                    result=result+"<img src=\""+link[7]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "8":
                    result=result+"<img src=\""+link[8]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "9":
                    result=result+"<img src=\""+link[9]+"\"  width=\"50\" height=\"60\">";
                    break;

                case "-":
                    result=result+"<img src=\""+link[10]+"\"  width=\"50\" height=\"60\">";
                    break;
                default:
                    result="errore";
            }
        }

        return result;
    }
    private String read(InputStream is) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is));

        System.out.println("\n");
        String received = null;
        while (true) {
            String s = null;
            try {
                if ((s = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s);
            received += s;
        }
        return received;
    }


}