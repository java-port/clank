@Override 
public final NamespaceDecl getPreviousDecl() { 
  return (NamespaceDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
} 

@Override 
public final NamespaceDecl getPreviousDecl$Const() { 
  return (NamespaceDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
} 
 
@Override 
public final NamespaceDecl getMostRecentDecl() { 
  return (NamespaceDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
} 

@Override 
public final NamespaceDecl getMostRecentDecl$Const() { 
  return (NamespaceDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
} 

@Override 
public final boolean isFirstDecl() { 
  return Redeclarable.super.isFirstDecl$Redeclarable(); 
} 

@Override
public boolean $less(Object obj) {
  NamespaceDecl other = (NamespaceDecl) obj;
  return BasicClangGlobals.$less_SourceLocation$C(this.LocStart, other.LocStart);
}
