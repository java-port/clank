public LockableFactEntry(LockableFactEntry $Prm0) {
  super($Prm0);
  this.Managed = $Prm0.Managed;
}

@Override public LockableFactEntry clone() { 
  return new LockableFactEntry(this); 
}
