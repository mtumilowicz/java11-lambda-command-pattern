package command.ordinary;

import command.system.FileSystemReceiver;

/**
 * Created by mtumilowicz on 2017-11-20.
 */
public class OpenFileCommand extends FileCommand {

    public OpenFileCommand(FileSystemReceiver fs) {
        super(fs);
    }

    @Override
    public String execute() {
        return this.fileSystem.open();
    }
}
