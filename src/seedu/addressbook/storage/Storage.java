package seedu.addressbook.storage;

import java.nio.file.Path;

import seedu.addressbook.data.AddressBook;


/**
 * Storage class defines the default behavior of storage objects
 *
 */
public abstract class Storage {
    
    public Path path;
    
    /**
     * returns path as a string
     */
    public String getPath() {
        return path.toString();
    }
    
    /**
     * Signals that some error has occured while trying to convert and read/write data between the application
     * and the storage file.
     */
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }

    /**
     * Saves all data to this storage file.
     * Throws StorageOperationException
     */
    public abstract void save(AddressBook addressBook) throws StorageOperationException;
    
    /**
     * Loads data from this storage file.
     * Throws StorageOperationException
     */
    public abstract AddressBook load() throws StorageOperationException;
    


}
