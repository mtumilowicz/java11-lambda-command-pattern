package command.ordinary;

import command.system.FileSystemReceiver;

/**
 * Created by mtumilowicz on 2017-11-20.
 */
public class WriteFileCommand extends FileCommand {
    
    public WriteFileCommand(FileSystemReceiver fs) {
        super(fs);
    }

    @Override
    public String execute() {
        return this.fileSystem.write();
    }
}
