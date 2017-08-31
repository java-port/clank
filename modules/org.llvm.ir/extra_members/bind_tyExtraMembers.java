private final Class<ClassValue> cls;

public bind_ty(bind_ty<ClassValue> other) {
  this.cls = other.cls;
  this./*&*/VR=/*&*//*ParenListExpr*/other.VR;
}

@Override
public bind_ty clone() {
  return new bind_ty(this);
}
