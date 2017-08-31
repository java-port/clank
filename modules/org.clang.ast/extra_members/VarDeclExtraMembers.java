@Override 
public final VarDecl getPreviousDecl() { 
  return (VarDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
} 

@Override 
public final VarDecl getPreviousDecl$Const() { 
  return (VarDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
} 
 
@Override 
public /*derived non-final*/ VarDecl getMostRecentDecl() { 
  return (VarDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
} 

@Override 
public final VarDecl getMostRecentDecl$Const() { 
  return (VarDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
} 

@Override 
public final boolean isFirstDecl() { 
  return Redeclarable.super.isFirstDecl$Redeclarable(); 
} 
