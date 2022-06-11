package gui;
import java.io.IOException;
import java.io.PipedInputStream;
import javafx.scene.control.TextArea;
//ThreadReader class begins
public class ThreadReader implements Runnable {
    private final PipedInputStream pipe1;
    private final PipedInputStream pipe2;
    Thread throwError;
    private Thread read1;
    private Thread read2;
    private boolean exit;
    private TextArea prgOutput;
//ThreadReader Constructor
    ThreadReader(PipedInputStream input1, PipedInputStream input2, Thread throwError1, Thread read11, Thread read22, boolean newExit, TextArea prgOutput1) {
        pipe1 = input1;
        pipe2 = input2;
        throwError = throwError1;
        read1 = read11;
        read2 = read22;
        exit = newExit;
        prgOutput = prgOutput1;

        this.exit = false;
        this.read1= new Thread(this);
        this.read1.setDaemon(true);
        this.read1.start();

        this.read2 = new Thread(this);
        this.read2.setDaemon(true);
        this.read2.start();

        this.throwError = new Thread(this);
        this.throwError.setDaemon(true);
        this.throwError.start();
    }
    //run method
    public synchronized void run() {
        try {
            while (Thread.currentThread() == this.read1) {
                try {
                    wait(100L);
                } catch (InterruptedException ie) {
                    System.out.println("Located in first thread");
                }
                if (this.pipe1.available() != 0) {
                    String input = lineRead(this.pipe1);
                    this.prgOutput.appendText(input);
                }
                if (this.exit) return;
            }

        while (Thread.currentThread() == this.read2) {
            try {
                wait(100L);
            } catch (InterruptedException ie) {
                System.out.println("Located in first thread");
            }
            if (this.pipe2.available() != 0) {
                String input = lineRead(this.pipe1);
                this.prgOutput.appendText(input);
            }
            if (this.exit) return;
        }
                } catch (Exception exc)
    {}
    if (Thread.currentThread() == this.throwError) {
        try {
            wait(800L);
            } catch (InterruptedException ie) {}
        System.out.println("Console Started Successfully");
        }
    }
    //lineRead method begins here
    public synchronized String lineRead(PipedInputStream in)
            throws IOException
    {
        String input = "";
        do
        {
            int available = in.available();
            if (available == 0) break;
            byte[] bit = new byte[available];
            in.read(bit);
            input = input + new String(bit, 0, bit.length);
        }while ((!input.endsWith("\n")) && (!input.endsWith("\r\n")) && (!this.exit));
        return input;
    }
}
