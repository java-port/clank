public org.clank.support.aliases.uint$ref Level_ref = new org.clank.support.aliases.uint$ref() {
  @Override
  public int $deref() {
    return Level;
  }

  @Override
  public int $set(int value) {
    Level = value;
    return Level;
  }
};

@Override
public UnwrappedLine clone() {
  return new UnwrappedLine(this);
}

@Override
public boolean $eq(UnwrappedLine other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.Level != other.Level) {
    return false;
  }
  if (this.InPPDirective != other.InPPDirective) {
    return false;
  }
  if (this.MustBeDeclaration != other.MustBeDeclaration) {
    return false;
  }
  return this.Tokens.$eq(other.Tokens);
}

@Override public UnwrappedLine move() {
  return new UnwrappedLine(JD$Move.INSTANCE, this);
}
