protected Type() { /*added to allow subclasses to use $Type(args) when args uses 'this'*/ }

protected Type(TypeClass tc, QualType canon, boolean Dependent, 
    boolean InstantiationDependent, boolean VariablyModified, 
    boolean ContainsUnexpandedParameterPack) {
  $Type(tc, canon, Dependent, InstantiationDependent, VariablyModified, ContainsUnexpandedParameterPack);
}

