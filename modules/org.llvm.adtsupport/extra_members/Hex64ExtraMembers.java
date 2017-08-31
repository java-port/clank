public ulong$ref value_ref = new ulong$ref(){
  @Override
  public long $deref() {
    return value;
  }

  @Override
  public long $set(long v) {
    value = v;
    return value;
  }
};
