public uint$ref NumberOfParts_ref = new uint$ref(){
  @Override
  public int $deref() {
    return NumberOfParts;
  }

  @Override
  public int $set(int value) {
    NumberOfParts = value;
    return NumberOfParts;
  }
};
