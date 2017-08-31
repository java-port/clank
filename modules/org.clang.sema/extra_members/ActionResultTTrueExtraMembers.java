protected PtrTy $ActionResultTTrue$PtrTy() { 
  return (PtrTy)null;
}

private boolean $bool(PtrTy Val) { 
  if (Val == null) {
    return false;
  } else if (Val instanceof OpaquePtr) {
    return ((OpaquePtr) Val).$bool();
  } else {
    return true;
  }
}

public /*const*/ ActionResultTTrue<PtrTy/*, CompressInvalid*/> /*&*/ $assignMove(ActionResultTTrue<? extends PtrTy/*, CompressInvalid*/> Other) {
  assert this != Other;
  this.Invalid = Other.Invalid;
  this.Val = Other.Val;
  Other.Val = null;
  return this;
}

public ActionResultTTrue(ActionResultTTrue<? extends PtrTy> $Prm0) {
  // : Val(val), Invalid(false) 
  //START JInit
  this.Val = /*ParenListExpr*/$Prm0.Val;//new PtrTy(val);
  this.Invalid = $Prm0.Invalid;
  //END JInit
}

@Override public ActionResultTTrue clone() { return new ActionResultTTrue(this); }
