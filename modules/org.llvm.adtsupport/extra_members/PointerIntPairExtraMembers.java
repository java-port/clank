@Override public int $hashcode() {
return DenseMapInfoPair.combineTwoHashes(
        (this.PtrVal instanceof NativeHashable) ? ((NativeHashable)this.PtrVal).$hashcode() : System.identityHashCode(this.PtrVal),
        this.IntVal);
}

public final void ProfilePointerIntPair(final FoldingSetNodeID /*&*/ ID) {
  ID.AddPointer(this.PtrVal);
  ID.AddInteger_int(this.IntVal);
}

@Override public PointerIntPair<PointerTy> clone() {
  return new PointerIntPair<PointerTy>(this);
}

@Override
public boolean $eqPointerLike(Object other) {
  if (this == other) {
    return true;
  }
  if (this.PtrVal == other && this.IntVal == 0) {
    return true;
  }
  if (other instanceof PointerIntPair) {
    return this.IntVal == ((PointerIntPair) other).IntVal
            && Native.$eq_ptr(this.PtrVal, ((PointerIntPair) other).PtrVal);
  }
  assert !(other instanceof NativePointerLike) 
          : "Pointer like comparizon of " + getClass().getCanonicalName() + " with " + other.getClass().getCanonicalName() 
          + " is not implemented!";
  return false;
}
