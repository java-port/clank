  protected void $destroy() { }
  
  public CapabilityExpr() { }

  @Override
  public CapabilityExpr clone() {
    return new CapabilityExpr(this);
  }
