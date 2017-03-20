package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author lognaume
 */
public class ERemoverStreamProcessor implements IStreamProcessor {

    @Override
    public void process(Reader in, Writer out) throws IOException {
        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(out);
        int c = br.read();
        while (c != -1) {
            if (c != 'e' && c != 'E') {
                bw.write(c);
            }
            c = br.read();
        }
        bw.flush();
    }
}
