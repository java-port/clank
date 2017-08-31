public BraceWrappingFlags(boolean AfterClass, boolean AfterControlStatement, boolean AfterEnum, boolean AfterFunction, boolean AfterNamespace, boolean AfterObjCDeclaration, boolean AfterStruct, boolean AfterUnion, boolean BeforeCatch, boolean BeforeElse, boolean IndentBraces) {
  this.AfterClass = AfterClass;
  this.AfterControlStatement = AfterControlStatement;
  this.AfterEnum = AfterEnum;
  this.AfterFunction = AfterFunction;
  this.AfterNamespace = AfterNamespace;
  this.AfterObjCDeclaration = AfterObjCDeclaration;
  this.AfterStruct = AfterStruct;
  this.AfterUnion = AfterUnion;
  this.BeforeCatch = BeforeCatch;
  this.BeforeElse = BeforeElse;
  this.IndentBraces = IndentBraces;
}

public bool$ref AfterClass_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterClass;
  }

  @Override
  public boolean $set(boolean value) {
    AfterClass = value;
    return AfterClass;
  }
};
public bool$ref AfterControlStatement_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterControlStatement;
  }

  @Override
  public boolean $set(boolean value) {
    AfterControlStatement = value;
    return AfterControlStatement;
  }
};
public bool$ref AfterEnum_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterEnum;
  }

  @Override
  public boolean $set(boolean value) {
    AfterEnum = value;
    return AfterEnum;
  }
};
public bool$ref AfterFunction_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterFunction;
  }

  @Override
  public boolean $set(boolean value) {
    AfterFunction = value;
    return AfterFunction;
  }
};
public bool$ref AfterNamespace_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterNamespace;
  }

  @Override
  public boolean $set(boolean value) {
    AfterNamespace = value;
    return AfterNamespace;
  }
};
public bool$ref AfterObjCDeclaration_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterObjCDeclaration;
  }

  @Override
  public boolean $set(boolean value) {
    AfterObjCDeclaration = value;
    return AfterObjCDeclaration;
  }
};
public bool$ref AfterStruct_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterStruct;
  }

  @Override
  public boolean $set(boolean value) {
    AfterStruct = value;
    return AfterStruct;
  }
};
public bool$ref AfterUnion_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return AfterUnion;
  }

  @Override
  public boolean $set(boolean value) {
    AfterUnion = value;
    return AfterUnion;
  }
};
public bool$ref BeforeCatch_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return BeforeCatch;
  }

  @Override
  public boolean $set(boolean value) {
    BeforeCatch = value;
    return BeforeCatch;
  }
};
public bool$ref BeforeElse_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return BeforeElse;
  }

  @Override
  public boolean $set(boolean value) {
    BeforeElse = value;
    return BeforeElse;
  }
};
public bool$ref IndentBraces_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return IndentBraces;
  }

  @Override
  public boolean $set(boolean value) {
    IndentBraces = value;
    return IndentBraces;
  }
};
