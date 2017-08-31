/*for collections*//*package*/Cleanup() { 
  this(null, false);
}
@Override public Cleanup clone() { 
  return new Cleanup(this.Value.getPointer(), this.Value.getBool()); 
}
public @Override void swap(NativeSwappable RHS) {
  PointerBoolPair<APValue /*P*//* , 1, boolean*/> v = Value;
  this.Value = ((Cleanup)RHS).Value;
  ((Cleanup)RHS).Value = v;
}
