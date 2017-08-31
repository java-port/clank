@Override
public ModuleFileInfo clone() {
  assert this.getClass() == ModuleFileInfo.class : "Must be overridden in " + this.getClass();
  return new ModuleFileInfo(this);
}

@Override
public ModuleFileInfo move() {
  assert this.getClass() == ModuleFileInfo.class : "Must be overridden in " + this.getClass();
  return new ModuleFileInfo(JD$Move.INSTANCE, this);
}
