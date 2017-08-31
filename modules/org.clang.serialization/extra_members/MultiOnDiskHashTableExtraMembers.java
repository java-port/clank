private final MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> $Info;
private MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder> Info() {
  return this.$Info;
}

public static interface MultiInfoInterface<external_key_type, internal_key_type, data_type, data_type_builder extends MultiInfoInterface.DataTypeBuilder<data_type>> 
  extends OnDiskChainedHashTable.InfoInterface<external_key_type, internal_key_type, data_type> {
  default data_type new$data_type() {
    throw new UnsupportedOperationException("This methods must be implemented to return 'new data_type()' from :" + this.getClass());
  }
  default data_type_builder new$data_type_builder(data_type data) {
    throw new UnsupportedOperationException("This methods must be implemented to return 'new data_type_builder(data)' from :" + this.getClass());
  }

  // Maximum number of lookup tables we allow before condensing the tables.
  public default /*const*/int $MaxTables() {
    throw new UnsupportedOperationException("This methods must be implemented to return 'MaxTables' field from :" + this.getClass());
  }

  // this method usually is implemented by default as static 
  public default void MergeDataInto(final /*const*/data_type /*&*/ From, final data_type_builder /*&*/ To) {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
  }

  public static interface DataTypeBuilder<data_type> {

  }

  public default void ReadDataInto(internal_key_type $Prm0, 
                /*const*/char$ptr/*uchar P*/ d, 
                /*uint*/int DataLen, 
                final data_type_builder /*&*/ Val) {
    throw new UnsupportedOperationException("This methods must be implemented in :" + this.getClass() + ". Forgot to remove static?");
  }
}
