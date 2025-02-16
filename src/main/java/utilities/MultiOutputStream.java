package utilities;

import java.io.IOException;
import java.io.OutputStream;

public class MultiOutputStream extends OutputStream {
	private final OutputStream outputStream1;
    private final OutputStream outputStream2;

    public MultiOutputStream(OutputStream stream1, OutputStream stream2) {
        this.outputStream1 = stream1;
        this.outputStream2 = stream2;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream1.write(b);
        outputStream2.write(b);
    }

    @Override
    public void flush() throws IOException {
        outputStream1.flush();
        outputStream2.flush();
    }

    @Override
    public void close() throws IOException {
        outputStream1.close();
        outputStream2.close();
    }
}