public static final int DWARF2_LINE_DEFAULT_IS_STMT = 1;
public static final int DWARF2_FLAG_IS_STMT = (1 << 0);
public static final int DWARF2_FLAG_BASIC_BLOCK = (1 << 1);
public static final int DWARF2_FLAG_PROLOGUE_END = (1 << 2);
public static final int DWARF2_FLAG_EPILOGUE_BEGIN = (1 << 3);

/*friend*/MCDwarfLoc() {
}

@Override
public MCDwarfLoc clone() {
  assert this.getClass() == MCDwarfLoc.class : "Must be overridden in " + this.getClass();
  return new MCDwarfLoc(this);
}

@Override
public MCDwarfLoc move() {
  assert this.getClass() == MCDwarfLoc.class : "Must be overridden in " + this.getClass();
  return new MCDwarfLoc(JD$Move.INSTANCE, this);
}
