@Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
private final int$ref currStmtIdx$ref = new int$ref() {
  @Override
  public int $deref() {
    return currStmtIdx;
  }

  @Override
  public int $set(int value) {
    currStmtIdx = value;
    return currStmtIdx;
  }
};  
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
private final type$ref</*const*/ NodeBuilderContext /*P*/> currBldrCtx$ref = new type$ref</*const*/ NodeBuilderContext /*P*/>() {
  @Override
  public NodeBuilderContext $deref() {
    return currBldrCtx;
  }

  @Override
  public NodeBuilderContext $set(NodeBuilderContext value) {
    currBldrCtx = value;
    return currBldrCtx;
  }
};
