package command;

/**
 * Created by mtumilowicz on 2017-11-20.
 */
public class FileInvoker {
    
    private final Command command;

    public FileInvoker(Command c){
        this.command=c;
    }

    public String execute(){
        return this.command.execute();
    }
}
