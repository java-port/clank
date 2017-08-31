  @Override
  public GlobalDecl clone() {
    return new GlobalDecl(this);
  }

  @Override
  public int $hashcode() {
    return Value == null ? 0 : Value.$hashcode();
  }
