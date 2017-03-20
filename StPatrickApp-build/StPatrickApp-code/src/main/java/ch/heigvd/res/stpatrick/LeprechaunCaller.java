package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lognaume
 */
public class LeprechaunCaller {

    public static void main(String[] args) {
        // Client (again, exception handling has been removed)
        Socket socket = null;
        try {
            socket = new Socket("10.192.114.100", 1703);

            BufferedReader in
                    = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

            OutputStream out = socket.getOutputStream();

            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            in.reset();
            
            String response = "guillaume.milani@heig-vd.ch\n";

            out.write(response.getBytes());
            out.flush();

            line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }

            System.out.println("Closing");

            socket.close();
            in.close();
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
