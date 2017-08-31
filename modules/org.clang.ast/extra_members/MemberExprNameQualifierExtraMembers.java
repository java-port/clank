@Converted(kind = Converted.Kind.MANUAL_ADDED)
public MemberExprNameQualifier() {
  this.QualifierLoc = new NestedNameSpecifierLoc();
  this.FoundDecl = new DeclAccessPair();
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public MemberExprNameQualifier(MemberExprNameQualifier other) {
  this.QualifierLoc = new NestedNameSpecifierLoc(other.QualifierLoc);
  this.FoundDecl = new DeclAccessPair(other.FoundDecl);
}

@Override
public MemberExprNameQualifier clone() {
  return new MemberExprNameQualifier(this);
}
