@Override public boolean $less(Object obj) { 
  if (this == obj) return false;
  NestedNameSpecifierLoc other = (NestedNameSpecifierLoc) obj;
  boolean out = Native.$less$JavaRef(this.Qualifier, other.Qualifier);
  return out || Native.$less(this.Data, other.Data);
}

@Override
public NestedNameSpecifierLoc clone() {
  return new NestedNameSpecifierLoc(this);
}

@Override
public boolean $eq(NestedNameSpecifierLoc other) {
  return $eq_NestedNameSpecifierLoc(this, other);
}

public /*inline*/ NestedNameSpecifierLoc(type$ptr<?> This$Mem, final /*const*/ NestedNameSpecifierLoc /*&*/ $Prm0) {
  // : Qualifier(.Qualifier), Data(.Data) 
  //START JInit
  TrailingObjectsUtils.$putThisAndShift(this, This$Mem);
  this.Qualifier = $Prm0.Qualifier;
  this.Data = $tryClone($Prm0.Data);
  //END JInit
}
