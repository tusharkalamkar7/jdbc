public interface AddressDAOI{
    Address getAddress(int id);
    Set<Address> getAllAddresses();
    boolean insertAddress(Address addr);
    boolean updateAddress(Address addr);
    boolean deleteAddress(int id);
}