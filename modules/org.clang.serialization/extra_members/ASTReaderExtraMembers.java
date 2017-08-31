private bool$ref PassingDeclsToConsumer_ref = new bool$ref() {
  @Override
  public boolean $deref() {
    return PassingDeclsToConsumer;
  }

  @Override
  public boolean $set(boolean value) {
    PassingDeclsToConsumer = value;
    return PassingDeclsToConsumer;
  }

  @Override
  public String toString() {
    return "" + $deref();
  }

};

private type$ref<SourceLocation> CurrentImportLoc_ref = new type$ref<SourceLocation>(){
  @Override
  public SourceLocation $deref() {
    return CurrentImportLoc;
  }

  @Override
  public SourceLocation $set(SourceLocation value) {
    CurrentImportLoc = value;
    return CurrentImportLoc;
  }
};

private uint$ref NumIdentifierLookupHits_ref = new uint$ref(){
  @Override
  public int $deref() {
    return NumIdentifierLookupHits;
  }

  @Override
  public int $set(int value) {
    NumIdentifierLookupHits = value;
    return NumIdentifierLookupHits;
  }

  @Override
  public String toString() {
    return "" + $deref();
  }

};

private uint$ref NumIdentifierLookups_ref = new uint$ref(){
  @Override
  public int $deref() {
    return NumIdentifierLookups;
  }

  @Override
  public int $set(int value) {
    NumIdentifierLookups = value;
    return NumIdentifierLookups;
  }

  @Override
  public String toString() {
    return "" + $deref();
  }

};


@Override
public IdentifierInfo get(char$ptr Name, int Len) {
  // TODO: optimize
  return get(new StringRef(Name, Len));
}

@Override
public IdentifierInfo get(byte[] Name, int NameStIndex, int Len) {
  // TODO: optimize
  return get(new StringRef(Name, NameStIndex, Len));
}
