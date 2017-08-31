@Override public abstract DERIVED clone();

protected StmtIteratorImpl(JD$Move _dparam, /*const*/ StmtIteratorBase /*&*/ RHS) { 
/*for derived*/ 
}

@Override public boolean $eq(Object RHS) { 
  return this.$eq((DERIVED)RHS); 
}

@Override
public type$ref<REFERENCE> star$ref() {
  type$iterator ptr = (inStmt() ? Unnamed_field.stmt : GetDeclExpr());
  return ptr.star$ref();
}
