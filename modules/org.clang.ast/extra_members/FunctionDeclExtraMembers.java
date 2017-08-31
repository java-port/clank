@Override 
public final FunctionDecl getPreviousDecl() { 
  return (FunctionDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
} 

@Override 
public final FunctionDecl getPreviousDecl$Const() { 
  return (FunctionDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
} 
 
@Override 
public/*derived non-final*/ FunctionDecl getMostRecentDecl() { 
  return (FunctionDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
} 

@Override 
public/*derived non-final*/ FunctionDecl getMostRecentDecl$Const() { 
  return (FunctionDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
} 

@Override 
public final boolean isFirstDecl() { 
  return Redeclarable.super.isFirstDecl$Redeclarable(); 
} 

private static final type$ptr<ParmVarDecl/*P*/> EMPTY_PARAMS = create_const_type$const_ptr((ParmVarDecl[])null);