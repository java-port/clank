public ConstraintInfo() {
  this.ImmRange = new Unnamed_struct1();
  this.ImmSet = new SmallSetInt(4);
  this.ConstraintStr = new std.string();
  this.Name = new std.string();
}

@Override public ConstraintInfo clone() { 
  return new ConstraintInfo(this); 
}
