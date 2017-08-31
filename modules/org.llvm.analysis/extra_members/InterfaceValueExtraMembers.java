public InterfaceValue() {
}

public InterfaceValue(int Index, int DerefLevel) {
  this.Index = Index;
  this.DerefLevel = DerefLevel;
}

  @Override
public InterfaceValue clone() {
  return new InterfaceValue(Index, DerefLevel);
}
