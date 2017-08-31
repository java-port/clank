@Override public MacroState clone() {
  assert this == DEFAULT : "only empty default-value instance can be cloned";
  return new MacroState();
}

@Override public MacroState move() {
  return new MacroState(JD$Move.INSTANCE, this);
}

public static final MacroState DEFAULT = new MacroState();
