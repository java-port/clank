/*friend*/ MCDwarfLineEntry() {
  super();
  this.Label = null;
}

@Override
public MCDwarfLoc clone() {
  assert this.getClass() == MCDwarfLineEntry.class : "Must be overridden in " + this.getClass();
  return new MCDwarfLineEntry(this);
}

@Override
public MCDwarfLoc move() {
  assert this.getClass() == MCDwarfLineEntry.class : "Must be overridden in " + this.getClass();
  return new MCDwarfLineEntry(JD$Move.INSTANCE, this);
}
