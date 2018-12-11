package command.system;

/**
 * Created by mtumilowicz on 2017-11-20.
 */
public abstract class FileSystemReceiver {
    private final SystemType type;

    FileSystemReceiver(SystemType type) {
        this.type = type;
    }

    public String open() {
        return type + ", " + FileOperationType.OPEN;
    }

    public String write() {
        return type + ", " + FileOperationType.WRITE;
    }

    public String close() {
        return type + ", " + FileOperationType.CLOSE;
    }
}
