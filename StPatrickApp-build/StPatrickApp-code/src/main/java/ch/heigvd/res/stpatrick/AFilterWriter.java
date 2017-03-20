package ch.heigvd.res.stpatrick;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author lognaume
 */
public class AFilterWriter extends FilterWriter {

    public AFilterWriter(Writer wrapperWriter) {
        super(wrapperWriter);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        char[] array = str.toCharArray();
        write(array, off, len);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            write(cbuf[i]);
        }
    }

    @Override
    public void write(int c) throws IOException {
        if (c != 'a' && c != 'A')
        super.write(c);
    }
}
