@Override 
public final ValueDecl getPreviousDecl() { 
  return (ValueDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
} 

@Override 
public final ValueDecl getPreviousDecl$Const() { 
  return (ValueDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
} 
 
@Override 
public final ValueDecl getMostRecentDecl() { 
  return (ValueDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
} 

@Override 
public final ValueDecl getMostRecentDecl$Const() { 
  return (ValueDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
} 

@Override 
public final boolean isFirstDecl() { 
  return Redeclarable.super.isFirstDecl$Redeclarable(); 
} 
