public ObjCInterfaceCacheEntry() { }

@Override
public ObjCInterfaceCacheEntry $assign(ObjCInterfaceCacheEntry $Prm0) {
  this.Type = $Prm0.Type;
  this.Decl = $Prm0.Decl;
  this.Unit = $Prm0.Unit;
  return this;
}

@Override
public ObjCInterfaceCacheEntry clone() {
  return new ObjCInterfaceCacheEntry(this);
}
