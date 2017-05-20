package gs.uploadingFiles.storage;

/**
 * Created by Asus x556 on 19-May-17.
 */
public class StorageFileNotFoundException extends StorageException{
    public StorageFileNotFoundException(String message){
        super(message);
    }

    public StorageFileNotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
