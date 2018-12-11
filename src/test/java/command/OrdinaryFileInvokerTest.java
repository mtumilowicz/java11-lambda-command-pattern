package command;

import command.ordinary.CloseFileCommand;
import command.ordinary.OpenFileCommand;
import command.ordinary.WriteFileCommand;
import command.system.FileSystemReceiver;
import command.system.MacFileSystemReceiver;
import command.system.WindowsFileSystemReceiver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mtumilowicz on 2017-11-20.
 */
public class OrdinaryFileInvokerTest {
    
    private final FileSystemReceiver windowsReceiver = new WindowsFileSystemReceiver();
    private final FileSystemReceiver macReceiver = new MacFileSystemReceiver();
    
    @Test
    public void windowsOpenFile() {
        assertEquals("WINDOWS, OPEN",
                new FileInvoker(windowsReceiver::open).execute());
        
        assertEquals("WINDOWS, OPEN", 
                new FileInvoker(new OpenFileCommand(windowsReceiver)).execute());
    }

    @Test
    public void windowsWriteFile() {
        assertEquals("WINDOWS, WRITE",
                new FileInvoker(windowsReceiver::write).execute());
        
        assertEquals("WINDOWS, WRITE", 
                new FileInvoker(new WriteFileCommand(windowsReceiver)).execute());
    }

    @Test
    public void windowsCloseFile() {
        assertEquals("WINDOWS, CLOSE",
                new FileInvoker(windowsReceiver::close).execute());
        
        assertEquals("WINDOWS, CLOSE", 
                new FileInvoker(new CloseFileCommand(windowsReceiver)).execute());
    }

    @Test
    public void macOpenFile() {
        assertEquals("MAC, OPEN",
                new FileInvoker(macReceiver::open).execute());
        
        assertEquals("MAC, OPEN", 
                new FileInvoker(new OpenFileCommand(macReceiver)).execute());
    }

    @Test
    public void macWriteFile() {
        assertEquals("MAC, WRITE",
                new FileInvoker(macReceiver::write).execute());
        
        assertEquals("MAC, WRITE", 
                new FileInvoker(new WriteFileCommand(macReceiver)).execute());
    }

    @Test
    public void macCloseFile() {
        assertEquals("MAC, CLOSE",
                new FileInvoker(macReceiver::close).execute());
        
        assertEquals("MAC, CLOSE", 
                new FileInvoker(new CloseFileCommand(macReceiver)).execute());
    }
}
