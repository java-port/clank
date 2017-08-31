private ulong$ref MostDerivedArraySize$Ref = new ulong$ref() {
  @Override
  public long $deref() {
    return MostDerivedArraySize;
  }
  @Override
  public long $set(long value) {
    MostDerivedArraySize = value;
    return MostDerivedArraySize;
  }
};