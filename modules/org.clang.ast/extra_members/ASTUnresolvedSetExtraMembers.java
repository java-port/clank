/**
 * Used by deserialization
 */
public void addDecl(final ASTContext /*&*/ C, /*NamedDecl P*/int D, AccessSpecifier AS) {
  Decls.push_back(DeclAccessPair.make(D, AS), C);
}
