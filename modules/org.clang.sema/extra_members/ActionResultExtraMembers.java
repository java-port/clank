protected PtrTy $ActionResult$PtrTy() { 
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

public /*const*/ ActionResult<PtrTy/*, CompressInvalid*/> /*&*/ $assignMove(ActionResult<? extends PtrTy/*, CompressInvalid*/> Other) {
  assert this != Other;
  this.Invalid = Other.Invalid;
  this.Val = Other.Val;
  Other.Val = null;
  return this;
}

public ActionResult(ActionResult<? extends PtrTy> $Prm0) {
  // : Val(val), Invalid(false) 
  //START JInit
  this.Val = /*ParenListExpr*/$Prm0.Val;//new PtrTy(val);
  this.Invalid = $Prm0.Invalid;
  //END JInit
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public ActionResult(JD$T _dparam, boolean Invalid, PtrTy val) {
  // : Val(PtrTy()), Invalid(Invalid) 
  //START JInit
  this.Val = /*ParenListExpr*/val; // do not clone here because in this constructor val is default value
  this.Invalid = Invalid;
  //END JInit
}