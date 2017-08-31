public Option(Option $Prm0) {
  this.NumOccurrences = $Prm0.NumOccurrences;
  this.Occurrences = $Prm0.Occurrences;
  this.Value = $Prm0.Value;
  this.HiddenFlag = $Prm0.HiddenFlag;
  this.Formatting = $Prm0.Formatting;
  this.Misc = $Prm0.Misc;
  this.Position = $Prm0.Position;
  this.AdditionalVals = $Prm0.AdditionalVals;
  this.NextRegistered = $Prm0.NextRegistered;
  this.ArgStr = new StringRef($Prm0.ArgStr);
  this.HelpStr = new StringRef($Prm0.HelpStr);
  this.ValueStr = new StringRef($Prm0.ValueStr);
  this.Category = $Prm0.Category;
  this.Subs = new SmallPtrSet<>($Prm0.Subs);
  this.FullyInitialized = $Prm0.FullyInitialized;
}

// JAVA: semantic from old versions
//<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getNextRegisteredOption">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*DELETED in 3.9*/, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 252,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::Option::getNextRegisteredOption")
//</editor-fold>
public Option /*P*/ getNextRegisteredOption() /*const*/ {
  return NextRegistered;
}
public Option /*P*/ NextRegistered; // Singly linked list of registered options.

///////////////////////////
// Instead of applicator<...>::apply

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1034)
protected final void apply(FormattingFlags FF) {
  this.setFormattingFlag(FF);
}

// Instead of applicator<MiscFlags>::apply
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1037)
protected final void applyMiscFlags(int /*MiscFlags*/ MF) {
  this.setMiscFlag(MF);
}

// Instead of applicator<const char *>::apply
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1011,
 notes = Converted.Notes.FAILED)
protected final void apply(String /*const char **/ Str) {
  this.setArgStr(new StringRef(Str));
}

// Instead of applicator<const char *>::apply
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1011,
 notes = Converted.Notes.FAILED)
protected final void apply(char$ptr /*const char **/ Str) {
  this.setArgStr(new StringRef(Str));
}

// Instead of applicator<NumOccurrencesFlag>::apply
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1023)
protected final void apply(NumOccurrencesFlag NO) {
  this.setNumOccurrencesFlag(NO);
}

// Instead of applicator<ValueExpected>::apply
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1028)
protected final void apply(ValueExpected VE) {
  this.setValueExpectedFlag(VE);
}  

// Instead of applicator<OptionHidden>::apply
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1028)
protected final void apply(OptionHidden Val) {
  this.setHiddenFlag(Val);
}  

public/*private*/ /*virtual*/  boolean setLocation(type$ref L) /*const*/ {
  throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
}

public/*private*/ /*virtual*/  void setInitialValue(Object Val) /*const*/ {
  throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
}

void apply(Option $this, Object... Ms) {
  assert $this == this;
  for (Object f : Ms) {      
    if (f instanceof FormattingFlags) {
      apply((FormattingFlags) f);
    } else if (f instanceof /*MiscFlags*/ Integer) { // the only int so far
      applyMiscFlags((/*MiscFlags*/ Integer) f);
    } else if (f instanceof String) {
      apply((String) f);
    } else if (f instanceof char$ptr) {
      apply((char$ptr) f);
    } else if (f instanceof NumOccurrencesFlag) {
      apply((NumOccurrencesFlag) f);
    } else if (f instanceof ValueExpected) {
      apply((ValueExpected) f);
    } else if (f instanceof OptionHidden) {
      apply((OptionHidden) f);
    } else if (f instanceof desc) {
      ((desc) f).apply(this);
    } else if (f instanceof value_desc) {
      ((value_desc) f).apply(this);
    } else if (f instanceof initializer) {
      ((initializer) f).apply(this);
    } else if (f instanceof LocationClass) {
      ((LocationClass) f).apply(this);
    } else if (f instanceof cat) {
      ((cat) f).apply(this);
    } else if (f instanceof aliasopt) {
      ((aliasopt) f).apply(this);
    } else if (f instanceof sub) {
      ((sub) f).apply(this);
    } else {
      String text = "Unexpected class: opt.opt(" + f.getClass() + ":" + f +")";
      throw NativeTrace.registerReason(new IllegalArgumentException(text));
    }
  }
}
