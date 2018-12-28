[![Build Status](https://travis-ci.com/mtumilowicz/java11-lambda-command-pattern.svg?branch=master)](https://travis-ci.com/mtumilowicz/java11-lambda-command-pattern)

# java11-lambda-command-pattern
Simple implementation of command design pattern using lambda and comparison to the old approach.

# preface
Details of command design pattern could be seen here: 
https://github.com/mtumilowicz/designPatterns#command

# project description
We define `Command`:
```
@FunctionalInterface
public interface Command {
    String execute();
}
```
and we want to implement different file operations 
(open, close, write) for different systems (windows, mac)

# old approach
Define each command in other class:
* `OpenFileCommand`
    ```
    public class OpenFileCommand extends FileCommand {
    
        public OpenFileCommand(FileSystemReceiver fs) {
            super(fs);
        }
    
        @Override
        public String execute() {
            return this.fileSystem.open();
        }
    }
    ```
* `WriteFileCommand`
    ```
    public class WriteFileCommand extends FileCommand {
        
        public WriteFileCommand(FileSystemReceiver fs) {
            super(fs);
        }
    
        @Override
        public String execute() {
            return this.fileSystem.write();
        }
    }
    ```
* `CloseFileCommand`
    ```
    public class CloseFileCommand extends FileCommand {
        public CloseFileCommand(FileSystemReceiver fs) {
            super(fs);
        }
    
        @Override
        public String execute() {
            return this.fileSystem.close();
        }
    }
    ```
* then tests:
    ```
    assertEquals("WINDOWS, OPEN", 
            new FileInvoker(new OpenFileCommand(windowsReceiver)).execute());
            
    assertEquals("WINDOWS, WRITE", 
            new FileInvoker(new WriteFileCommand(windowsReceiver)).execute());
            
    assertEquals("WINDOWS, CLOSE", 
            new FileInvoker(new CloseFileCommand(windowsReceiver)).execute());
            
    assertEquals("MAC, OPEN", 
            new FileInvoker(new OpenFileCommand(macReceiver)).execute());
            
    assertEquals("MAC, WRITE", 
            new FileInvoker(new WriteFileCommand(macReceiver)).execute());
            
    assertEquals("MAC, CLOSE", 
            new FileInvoker(new CloseFileCommand(macReceiver)).execute());                         
    ```
# functional approach
* use directly appropriate methods from receiver:
    ```
    assertEquals("WINDOWS, OPEN",
            new FileInvoker(windowsReceiver::open).execute());
            
    assertEquals("WINDOWS, WRITE",
            new FileInvoker(windowsReceiver::write).execute());

    assertEquals("WINDOWS, CLOSE",
            new FileInvoker(windowsReceiver::close).execute());

    assertEquals("MAC, OPEN",
            new FileInvoker(macReceiver::open).execute());

    assertEquals("MAC, WRITE",
            new FileInvoker(macReceiver::write).execute());

    assertEquals("MAC, CLOSE",
            new FileInvoker(macReceiver::close).execute());
    ```
