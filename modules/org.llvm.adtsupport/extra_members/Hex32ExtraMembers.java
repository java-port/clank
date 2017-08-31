public uint$ref value_ref = new uint$ref(){
  @Override
  public int $deref() {
    return value;
  }

  @Override
  public int $set(int v) {
    value = v;
    return value;
  }
};
