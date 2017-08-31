private final SpecificDecl$BoolPredicate<SpecificDecl>/*const*/ Acceptable;
private final Class<SpecificDecl> clazz;

public filtered_decl_iterator(filtered_decl_iterator<SpecificDecl> $Prm0) {
  this.clazz = $Prm0.clazz;
  this.Acceptable = $Prm0.Acceptable;
  this.Current = new DeclContext.decl_iterator($Prm0.Current);
}

@Override public boolean $eq(Object other) { 
  return $eq_filtered_decl_iterator$C(this, (filtered_decl_iterator)other); 
}

@Override public boolean $noteq(Object other) { 
  return $noteq_filtered_decl_iterator$C(this, (filtered_decl_iterator)other); 
}

@Override
public filtered_decl_iterator clone() {
  return new filtered_decl_iterator(this);
}