private static ASTNodeKind getFromNodeKindImplByClass(Class<?> clazz) {
  NodeKindId kind = AstKindToKindIdRegistry.Class2NodeKindId.get(clazz);
  if (kind == null) {
    throw new IllegalStateException("not registered kind-id for " + clazz);
  }
  return new ASTNodeKind(kind);
}

@Override public ASTNodeKind clone() {
  return new ASTNodeKind(this);
}
