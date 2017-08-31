/// Used for default values in collections, i.e. fill everything with zeroes
private LambdaCapture() {
  this.Kind = Kind.LCK_This;
  this.Loc = new SourceLocation();
  this.Id = new IdentifierInfo(NativePointer.$EMPTY, 0);
  this.EllipsisLoc = new SourceLocation();
  this.InitKind = InitKind.NoInit;
  this.Init = new ActionResultTTrue();
  this.InitCaptureType = new OpaquePtr();
}

public /*inline*/ LambdaCapture /*&*/ $assign(final LambdaCapture /*&&*/$Prm0) {
  this.Kind = $Prm0.Kind;
  this.Loc.$assign($Prm0.Loc);
  this.Id = $Prm0.Id;
  this.EllipsisLoc.$assign($Prm0.EllipsisLoc);
  this.InitKind = $Prm0.InitKind;
  this.Init.$assign($Prm0.Init);
  this.InitCaptureType.$assign($Prm0.InitCaptureType);
  return /*Deref*/this;
}

@Override
public LambdaCapture clone() {
  return new LambdaCapture().$assign(this);
}