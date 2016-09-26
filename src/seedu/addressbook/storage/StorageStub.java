package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;

/**
 * use to test Logic class independently so that StorageFile class will not be involved
 *
 */
public class StorageStub extends Storage{

    @Override
    public void save(AddressBook addressBook) throws StorageOperationException {
        
    }

    @Override
    public AddressBook load() throws StorageOperationException {
        // TODO Auto-generated method stub
        return new AddressBook();
    }

}
