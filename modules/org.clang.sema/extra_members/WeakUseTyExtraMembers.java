public WeakUseTy() {
  this.Rep = new PointerBoolPair<>();
}

@Override
public WeakUseTy clone() {
  return new WeakUseTy(Rep.getPointer(), Rep.getBool());
}
