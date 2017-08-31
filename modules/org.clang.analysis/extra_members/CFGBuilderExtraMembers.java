private type$ref<CFGBlock /*P*/> Block$ref = new type$ref<CFGBlock /*P*/>(){
  @Override
  public CFGBlock $deref() {
    return Block;
  }

  @Override
  public CFGBlock $set(CFGBlock value) {
    Block = value;
    return Block;
  }
};
private type$ref<CFGBlock /*P*/> Succ$ref = new type$ref<CFGBlock /*P*/>(){
  @Override
  public CFGBlock $deref() {
    return Succ;
  }

  @Override
  public CFGBlock $set(CFGBlock value) {
    Succ = value;
    return Succ;
  }
};
private type$ref<BlockScopePosPair> ContinueJumpTarget$ref = new type$ref<BlockScopePosPair>(){
  @Override
  public BlockScopePosPair $deref() {
    return ContinueJumpTarget;
  }

  @Override
  public BlockScopePosPair $set(BlockScopePosPair value) {
    ContinueJumpTarget.$assign(value);
    return ContinueJumpTarget;
  }
};
private type$ref<BlockScopePosPair> BreakJumpTarget$ref = new type$ref<BlockScopePosPair>(){
  @Override
  public BlockScopePosPair $deref() {
    return BreakJumpTarget;
  }

  @Override
  public BlockScopePosPair $set(BlockScopePosPair value) {
    BreakJumpTarget.$assign(value);
    return BreakJumpTarget;
  }
};
private type$ref<CFGBlock /*P*/> SwitchTerminatedBlock$ref = new type$ref<CFGBlock /*P*/>(){
  @Override
  public CFGBlock $deref() {
    return SwitchTerminatedBlock;
  }

  @Override
  public CFGBlock $set(CFGBlock value) {
    SwitchTerminatedBlock = value;
    return SwitchTerminatedBlock;
  }
};
private type$ref<CFGBlock /*P*/> DefaultCaseBlock$ref = new type$ref<CFGBlock /*P*/>(){
  @Override
  public CFGBlock $deref() {
    return DefaultCaseBlock;
  }

  @Override
  public CFGBlock $set(CFGBlock value) {
    DefaultCaseBlock = value;
    return DefaultCaseBlock;
  }
};
private type$ref<CFGBlock /*P*/> TryTerminatedBlock$ref = new type$ref<CFGBlock /*P*/>(){
  @Override
  public CFGBlock $deref() {
    return TryTerminatedBlock;
  }

  @Override
  public CFGBlock $set(CFGBlock value) {
    TryTerminatedBlock = value;
    return TryTerminatedBlock;
  }
};

private type$ref<LocalScope.const_iterator> ScopePos$ref = new type$ref<LocalScope.const_iterator>(){
  @Override
  public LocalScope.const_iterator $deref() {
    return ScopePos;
  }

  @Override
  public LocalScope.const_iterator $set(LocalScope.const_iterator value) {
    ScopePos.$assign(value);
    return ScopePos;
  }
};

private bool$ref switchExclusivelyCovered$ref = new bool$ref() {
  @Override
  public boolean $deref() {
    return switchExclusivelyCovered;
  }

  @Override
  public boolean $set(boolean value) {
    switchExclusivelyCovered = value;
    return switchExclusivelyCovered;
  }
};
private type$ref<Expr.EvalResult /*P*/> switchCond$ref = new type$ref<Expr.EvalResult /*P*/>(){
  @Override
  public Expr.EvalResult $deref() {
    return switchCond;
  }

  @Override
  public Expr.EvalResult $set(Expr.EvalResult value) {
    switchCond = value;
    return switchCond;
  }
};
