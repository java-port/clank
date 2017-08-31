@Override public SubmoduleState clone() {
  assert this.Macros.empty() : "Only empty can be cloned as default-value";
  assert this.VisibleModules.getGeneration() == 0 : "Only empty can be cloned as default-value";
  return new SubmoduleState();
}

@Override public SubmoduleState move() {
  return new SubmoduleState(JD$Move.INSTANCE, this);
}

public static final SubmoduleState DEFAULT = new SubmoduleState();
