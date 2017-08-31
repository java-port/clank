public TypeOfExprTypeLocInfo() {
}

public TypeOfExprTypeLocInfo(TypeOfExprTypeLocInfo $Prm0) {
  super($Prm0);
}

@Override
public TypeOfExprTypeLocInfo clone() {
  assert this.getClass() == TypeOfExprTypeLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new TypeOfExprTypeLocInfo(this);
}  
