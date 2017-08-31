public ScopedLockableFactEntry(ScopedLockableFactEntry $Prm0) {
  super($Prm0);
  this.UnderlyingMutexes = new SmallVector($Prm0.UnderlyingMutexes);
}

@Override public ScopedLockableFactEntry clone() { 
  return new ScopedLockableFactEntry(this); 
}
