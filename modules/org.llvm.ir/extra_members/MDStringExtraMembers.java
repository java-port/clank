private static final MDString EMPTY = new MDString();
public static MDString $Empty() { return EMPTY; }

protected MDString(JD$Move _dparm, MDString $Prm0) {
  super($Prm0);
  this.Entry = $Prm0.Entry;
}

@Override public MDString clone() { 
  assert this == EMPTY || this.Entry == null: "only EMPTY const is expected to be cloned";
  assert this.getClass() == MDString.class : "Why not overridden in " + this.getClass();
  return new MDString();
}

@Override public MDString move() { 
  assert this.getClass() == MDString.class : "Why not overridden in " + this.getClass();
  return new MDString(JD$Move.INSTANCE, this);
}
