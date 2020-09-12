import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

public class Program {
    public static void main(final String[] args) {
        for (final String arg : args) {
            System.out.println(arg);
        }

        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Path.of(Program.class.getResource("resources/arquivo").toURI()));
        } catch (IOException | URISyntaxException ioex)
        {
            ioex.printStackTrace();
        }
        

        for (final byte b : bytes) {
            System.out.println(b);
        }

        writeHeader(EncondingType.Delta);
    }
    
    private static void writeHeader(final EncondingType encType) {
        try {
            var outFile = Files.createFile(new File("./resources/saida").toPath());

            Files.write(outFile, new byte [] { encType.getCode() });
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public enum EncondingType {
        Golomb(0),
        EliasGama(1), 
        Fibonacci(2),
        Unary(3),
        Delta(4);
    
        private final byte code;
    
        private EncondingType(final int code) {
            this.code = (byte)code;
        }

        public byte getCode() {
            return code;
        }
    }
}
