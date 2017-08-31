@Override
public PartialDiagnostic clone() {
  return new PartialDiagnostic(this);
}

@Override
public PartialDiagnostic move() {
  return new PartialDiagnostic(JD$Move.INSTANCE, this);
}

public void /*&*/ $MemoryCopy(/*const*/PartialDiagnostic /*&*/ Other) {
  DiagID = Other.DiagID;
  DiagStorage = Other.DiagStorage;
  this.Allocator = Other.Allocator;
}
