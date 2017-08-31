
public default/*interface*/ boolean has_overridden_method(String MethodName) {
  throw new UnsupportedOperationException("Why not overridden in Derived class ? " + this.getClass());
}

public default/*interface*/ void $RecursiveASTVisitor() { 
  /*for derived classes*/ 
}

public default void $destroy$RecursiveASTVisitor() {    
  /*for derived classes*/ 
}

// The following regexp-based replacements can be applied in order to change the code
//1)
//Replace What:\(/\*static_cast\*/ std\.conditional<has_same_member_pointer_type<decltype\(/\*AddrOf\*//\*FPtr\*/RecursiveASTVisitor<Derived>::.*\), decltype\(Native\.\$bitand\(Derived\..*\)\)>\.value, Derived /\*&\*/ \, RecursiveASTVisitor<Derived> /\*&\*/ >\.type\)
//=>
//Replace With:\(Derived\)
//2)
//Replace What:has_same_member_pointer_type<decltype\(/\*AddrOf\*//\*FPtr\*/RecursiveASTVisitor<Derived>::(.*)\), decltype\(Native\.\$bitand\(Derived\..*\)\)>\.value
//=>
//Replace With:has_overridden_method\("$1"\)
//3)
//Replace What:;\n(\s)*; 
// => 
//Replace With:;
