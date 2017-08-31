@Override public void $destroy() {
  this.Gen.$destroy();
}

public static interface MultiEmitInfoInterface<internal_key_type, data_type, import_data_from_type, file_type> extends OnDiskChainedHashTableGenerator.EmitInfoInterface<internal_key_type, data_type, file_type> {

  public default data_type ImportData(/*file_type*/import_data_from_type data) {
    throw new UnsupportedOperationException("ImportData must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }    
}
