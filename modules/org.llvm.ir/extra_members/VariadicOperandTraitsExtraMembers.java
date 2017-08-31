    private final int MINARITY;
  
    public VariadicOperandTraits() {
      MINARITY = 0;
    }
  
    public VariadicOperandTraits(/*uint*/int MINARITY) {
      this.MINARITY = MINARITY;
    }
  
    public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/>
            type$ptr<Use /*P*/> op_begin(/*uint*/int MINARITY, SubClass /*P*/ U) {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/> 
            type$ptr<Use /*P*/> op_end(/*uint*/int MINARITY, SubClass /*P*/ U) {
      throw new UnsupportedOperationException("EmptyBody");
    }
  
    public static </*typename*/ SubClass>//, /*uint*/int MINARITY/* = 0*/>
            /*uint*/ int operands(/*uint*/int MINARITY, /*const*/ User /*P*/ U) {
      throw new UnsupportedOperationException("EmptyBody");
    }
