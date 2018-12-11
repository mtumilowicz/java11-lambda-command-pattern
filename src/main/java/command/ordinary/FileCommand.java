package command.ordinary;

import command.Command;
import command.system.FileSystemReceiver;

/**
 * Created by mtumilowicz on 2017-11-20.
 */
public abstract class FileCommand implements Command {
    
    protected final FileSystemReceiver fileSystem;

    public FileCommand(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
}
