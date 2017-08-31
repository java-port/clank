  private final Argument $sentinelField = new Argument();

  @Override
  public Argument $SentinelField() {
    return $sentinelField;
  }

  @Override
  public Class<Argument> $getValueSubClass() {
    return Argument.class;
  }


  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static class SymbolTableList$Argument extends SymbolTableList<Argument, Function> {

    public SymbolTableList$Argument(Function/*P*/ Owner) {
      super(Owner);
    }
    
    @Override
    public Argument $SentinelField() {
      return (Argument)((SymbolTableListTraits)super.$traits()).$SentinelField();
    }
    
    @Override
    protected SymbolTableListTraits$Argument $createTraits() {
      return new SymbolTableListTraits$Argument();
    }
    
    @Override
    public Class<Argument> $getValueSubClass() {
      return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
    }
  }
