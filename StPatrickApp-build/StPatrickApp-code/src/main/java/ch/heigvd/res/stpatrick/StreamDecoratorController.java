package ch.heigvd.res.stpatrick;

import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author lognaume
 */
public class StreamDecoratorController implements IStreamDecoratorController {

    @Override
    public Reader decorateReader(Reader inputReader) {
        /**
         * I choosed to decorate the writer instead of the reader, so this
         * method doesn't do anything.
         * In other case it would have returned a decorated reader.
         */
        return inputReader;
    }

    @Override
    public Writer decorateWriter(Writer outputWriter) {
        return new AFilterWriter(outputWriter);
    }

}
