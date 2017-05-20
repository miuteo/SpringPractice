package gs.uploadingFiles.storage;

/**
 * Created by Asus x556 on 19-May-17.
 */
public class StorageException extends RuntimeException {
    public StorageException(String message){
        super(message);
    }

    public StorageException(String message,Throwable cause){
        super(message,cause);
    }
}
