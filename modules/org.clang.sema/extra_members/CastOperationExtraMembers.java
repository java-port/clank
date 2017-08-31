private final type$ref<ExprValueKind> ValueKind$Ref = new type$ref<ExprValueKind>() {
  @Override
  public ExprValueKind $deref() {
    return ValueKind;
  }

  @Override
  public ExprValueKind $set(ExprValueKind value) {
    ValueKind = value;
    return ValueKind;
  }
};

private final type$ref<CastKind> Kind$Ref = new type$ref<CastKind>() {
  @Override
  public CastKind $deref() {
    return Kind;
  }

  @Override
  public CastKind $set(CastKind value) {
    Kind = value;
    return Kind;
  }
};
