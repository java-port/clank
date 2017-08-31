/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.ir;

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import static org.llvm.ir.impl.FunctionStatics.*;
import org.llvm.ir.impl.SymbolTableListTraits$Argument.SymbolTableList$Argument;
import org.llvm.ir.impl.SymbolTableListTraits$BasicBlock.SymbolTableList$BasicBlock;
import static org.llvm.pass.IrLlvmGlobals.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::Function">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 41,
 FQN="llvm::Function", NM="_ZN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8FunctionE")
//</editor-fold>
public class Function extends /*public*/ GlobalObject implements /*public*/ IChild<Module>, IValueSymbolTableProvider, ilist_node<Function>, Iterable<BasicBlock>, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef SymbolTableList<Argument> ArgumentListType
//  public final class ArgumentListType extends SymbolTableList<Argument, Function>{ };
  // JAVA: typedef SymbolTableList<BasicBlock> BasicBlockListType
//  public final class BasicBlockListType extends SymbolTableList<BasicBlock, Function>{ };
  
  // BasicBlock iterators...
  // JAVA: typedef BasicBlockListType::iterator iterator
//  public final class iterator extends ilist_iterator<BasicBlock>{ };
  // JAVA: typedef BasicBlockListType::const_iterator const_iterator
//  public final class const_iterator extends ilist_iterator</*const*/ BasicBlock>{ };
  
  // JAVA: typedef ArgumentListType::iterator arg_iterator
//  public final class arg_iterator extends ilist_iterator<Argument>{ };
  // JAVA: typedef ArgumentListType::const_iterator const_arg_iterator
//  public final class const_arg_iterator extends ilist_iterator</*const*/ Argument>{ };
/*private:*/
  // Important things that make up a function!
  private final SymbolTableList<BasicBlock, Function> BasicBlocks; ///< The basic blocks
  private final/*mutable */SymbolTableList<Argument, Function> ArgumentList; ///< The formal arguments
  private ValueSymbolTable /*P*/ SymTab; ///< Symbol table of args/instructions
  private AttributeSet AttributeSets; ///< Parameter attributes
  
  /*
  * Value::SubclassData
  *
  * bit 0      : HasLazyArguments
  * bit 1      : HasPrefixData
  * bit 2      : HasPrologueData
  * bit 3      : HasPersonalityFn
  * bits 4-13  : CallingConvention
  * bits 14    : HasGC
  * bits 15 : [reserved]
  */
  
  /// Bits from GlobalObject::GlobalObjectSubclassData.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 73,
   FQN="llvm::Function::(anonymous)", NM="_ZN4llvm8FunctionE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8FunctionE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// Whether this function is materializable.
    public static final /*uint*/int IsMaterializableBit = 0;
  /*}*/;
  
  /*friend  class SymbolTableListTraits<Function>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 335,
   FQN="llvm::Function::setParent", NM="_ZN4llvm8Function9setParentEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function9setParentEPNS_6ModuleE")
  //</editor-fold>
  public /*friend*//*private*/ void setParent(Module /*P*/ parent) {
    Parent = parent;
  }



  /// hasLazyArguments/CheckLazyArguments - The argument list of a function is
  /// built on demand, so that the list isn't allocated until the first client
  /// needs it.  The hasLazyArguments predicate returns true if the arg list
  /// hasn't been set up yet.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasLazyArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 87,
   FQN="llvm::Function::hasLazyArguments", NM="_ZNK4llvm8Function16hasLazyArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function16hasLazyArgumentsEv")
  //</editor-fold>
  public boolean hasLazyArguments() /*const*/ {
    return (($ushort2int(getSubclassDataFromValue()) & (1 << 0)) != 0);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::CheckLazyArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 92,
   FQN="llvm::Function::CheckLazyArguments", NM="_ZNK4llvm8Function18CheckLazyArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function18CheckLazyArgumentsEv")
  //</editor-fold>
  private void CheckLazyArguments() /*const*/ {
    if (hasLazyArguments()) {
      BuildLazyArguments();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::BuildLazyArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 292,
   FQN="llvm::Function::BuildLazyArguments", NM="_ZNK4llvm8Function18BuildLazyArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function18BuildLazyArgumentsEv")
  //</editor-fold>
  private void BuildLazyArguments() /*const*/ {
    // Create the arguments vector, all arguments start out unnamed.
    FunctionType /*P*/ FT = getFunctionType();
    for (/*uint*/int i = 0, e = FT.getNumParams(); i != e; ++i) {
      assert (!FT.getParamType(i).isVoidTy()) : "Cannot have void typed arguments!";
      ArgumentList.push_back(new Argument(FT.getParamType(i)));
    }
    
    // Clear the lazy arguments bit.
    /*uint*/int SDC = $ushort2uint(getSubclassDataFromValue());
    ((/*const_cast*/Function /*P*/ )(this)).setValueSubclassData_Function($uint2ushort(SDC &= ~(1 << 0)));
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::Function">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 98,
   FQN="llvm::Function::Function", NM="_ZN4llvm8FunctionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8FunctionC1ERKS0_")
  //</editor-fold>
  protected/*private*/ Function(final /*const*/ Function /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 99,
   FQN="llvm::Function::operator=", NM="_ZN4llvm8FunctionaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8FunctionaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ Function /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// Function ctor - If the (optional) Module argument is specified, the
  /// function is automatically inserted into the end of the function list for
  /// the module.
  ///
  
  /// Function ctor - If the (optional) Module argument is specified, the
  /// function is automatically inserted into the end of the function list for
  /// the module.
  ///
  
  //===----------------------------------------------------------------------===//
  // Function Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::Function">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 258,
   FQN="llvm::Function::Function", NM="_ZN4llvm8FunctionC1EPNS_12FunctionTypeENS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8FunctionC1EPNS_12FunctionTypeENS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_6ModuleE")
  //</editor-fold>
  private Function(FunctionType /*P*/ Ty, GlobalValue.LinkageTypes Linkage) {
    this(Ty, Linkage, new Twine(/*KEEP_STR*/$EMPTY), 
      (Module /*P*/ )null);
  }
  private Function(FunctionType /*P*/ Ty, GlobalValue.LinkageTypes Linkage, final /*const*/ Twine /*&*/ name/*= ""*/) {
    this(Ty, Linkage, name, 
      (Module /*P*/ )null);
  }
  private Function(FunctionType /*P*/ Ty, GlobalValue.LinkageTypes Linkage, final /*const*/ Twine /*&*/ name/*= ""*/, 
      Module /*P*/ ParentModule/*= null*/) {
    // : GlobalObject(Ty, Value::FunctionVal, OperandTraits<Function>::op_begin(this), 0, Linkage, name), ilist_node<Function>(), BasicBlocks(), ArgumentList(), AttributeSets() 
    //START JInit
    super(Ty, Value.ValueTy.FunctionVal, 
        OperandTraitsFunction.<Function>op_begin(User.$BEING_CREATED()/*this*/), 0, Linkage, name);
    this.ilist_node$Flds = $ilist_node();
    this.BasicBlocks = new SymbolTableList$BasicBlock(this);
    this.ArgumentList = new SymbolTableList$Argument(this);
    this.AttributeSets = new AttributeSet();
    //END JInit
    assert (FunctionType.isValidReturnType(getReturnType())) : "invalid return type";
    setGlobalObjectSubClassData(0);
    SymTab = new ValueSymbolTable();
    
    // If the function has arguments, mark them as lazily built.
    if ((Ty.getNumParams() != 0)) {
      setValueSubclassData_Function($int2ushort(1)); // Set the "has lazy arguments" bit.
    }
    if ((ParentModule != null)) {
      ParentModule.getFunctionList().push_back(this);
    }
    
    // Ensure intrinsics have the right parameter attributes.
    // Note, the IntID field will have been set in Value::setName if this function
    // name is a valid intrinsic ID.
    if ((IntID != 0)) {
      setAttributes(IntrinsicGlobals.getAttributes(getContext(), IntID));
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 109,
   FQN="llvm::Function::Create", NM="_ZN4llvm8Function6CreateEPNS_12FunctionTypeENS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function6CreateEPNS_12FunctionTypeENS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_6ModuleE")
  //</editor-fold>
  public static Function /*P*/ Create(FunctionType /*P*/ Ty, GlobalValue.LinkageTypes Linkage) {
    return Create(Ty, Linkage, 
        new Twine(/*KEEP_STR*/$EMPTY), (Module /*P*/ )null);
  }
  public static Function /*P*/ Create(FunctionType /*P*/ Ty, GlobalValue.LinkageTypes Linkage, 
        final /*const*/ Twine /*&*/ N/*= ""*/) {
    return Create(Ty, Linkage, 
        N, (Module /*P*/ )null);
  }
  public static Function /*P*/ Create(FunctionType /*P*/ Ty, GlobalValue.LinkageTypes Linkage, 
        final /*const*/ Twine /*&*/ N/*= ""*/, Module /*P*/ M/*= null*/) {
    return /*NEW_EXPR [User::new]*/User.$new_HangOffUses((type$ptr<?> New$Mem)->{
        return new Function(Ty, Linkage, N, M);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::~Function">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 281,
   FQN="llvm::Function::~Function", NM="_ZN4llvm8FunctionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8FunctionD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    dropAllReferences(); // After this it is safe to delete instructions.
    
    // Delete all of the method arguments and unlink from symbol table...
    ArgumentList.clear();
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)SymTab);
    
    // Remove the function from the on-the-side GC table.
    clearGC();
    //START JDestroy
    ArgumentList.$destroy();
    BasicBlocks.$destroy();
    super.$destroy();
    ilist_node.super.$destroy$ilist_node();
    //END JDestroy
  }



  /// \brief Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::getOperand", NM="_ZNK4llvm8Function10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsFunction.<Function>operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsFunction.<Function>op_begin(((/*const_cast*/Function /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::setOperand", NM="_ZN4llvm8Function10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsFunction.<Function>operands(this))) : "setOperand() out of range!";
    OperandTraitsFunction.<Function>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::op_begin", NM="_ZN4llvm8Function8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsFunction.<Function>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::op_begin", NM="_ZNK4llvm8Function8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsFunction.<Function>op_begin(((/*const_cast*/Function /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::op_end", NM="_ZN4llvm8Function6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsFunction.<Function>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::op_end", NM="_ZNK4llvm8Function6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsFunction.<Function>op_end(((/*const_cast*/Function /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::Op", NM="Tpl__ZN4llvm8Function2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=Tpl__ZN4llvm8Function2OpEv")
  //</editor-fold>
  protected /*<int Idx_nocapture>*/ Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::Op", NM="Tpl__ZNK4llvm8Function2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=Tpl__ZNK4llvm8Function2OpEv")
  //</editor-fold>
  protected /*<int Idx_nocapture>*/ /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 658,
   FQN="llvm::Function::getNumOperands", NM="_ZNK4llvm8Function14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsFunction.<Function>operands(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 242,
   FQN="llvm::Function::getReturnType", NM="_ZNK4llvm8Function13getReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function13getReturnTypeEv")
  //</editor-fold>
  public Type /*P*/ getReturnType() /*const*/ {
    return getFunctionType().getReturnType();
  }
 // Return the type of the ret val

  // Return the type of the ret val
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 234,
   FQN="llvm::Function::getFunctionType", NM="_ZNK4llvm8Function15getFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function15getFunctionTypeEv")
  //</editor-fold>
  public FunctionType /*P*/ getFunctionType() /*const*/ {
    return cast_FunctionType(getValueType());
  }
 // Return the FunctionType for me

  
  /// getContext - Return a reference to the LLVMContext associated with this
  /// function.
  // Return the FunctionType for me
  
  /// getContext - Return a reference to the LLVMContext associated with this
  /// function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 230,
   FQN="llvm::Function::getContext", NM="_ZNK4llvm8Function10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return getType().getContext();
  }


  
  /// isVarArg - Return true if this function takes a variable number of
  /// arguments.
  
  /// isVarArg - Return true if this function takes a variable number of
  /// arguments.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::isVarArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 238,
   FQN="llvm::Function::isVarArg", NM="_ZNK4llvm8Function8isVarArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function8isVarArgEv")
  //</editor-fold>
  public boolean isVarArg() /*const*/ {
    return getFunctionType().isVarArg();
  }


  
  //===----------------------------------------------------------------------===//
  // Helper Methods in Function
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::isMaterializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 220,
   FQN="llvm::Function::isMaterializable", NM="_ZNK4llvm8Function16isMaterializableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function16isMaterializableEv")
  //</editor-fold>
  public boolean isMaterializable() /*const*/ {
    return ((getGlobalObjectSubClassData() & (1 << IsMaterializableBit)) != 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setIsMaterializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 224,
   FQN="llvm::Function::setIsMaterializable", NM="_ZN4llvm8Function19setIsMaterializableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function19setIsMaterializableEb")
  //</editor-fold>
  public void setIsMaterializable(boolean V) {
    /*uint*/int Mask = 1 << IsMaterializableBit;
    setGlobalObjectSubClassData((~Mask & getGlobalObjectSubClassData())
           | (V ? Mask : 0/*U*/));
  }


  
  /// getIntrinsicID - This method returns the ID number of the specified
  /// function, or Intrinsic::not_intrinsic if the function is not an
  /// intrinsic, or if the pointer is null.  This value is always defined to be
  /// zero to allow easy checking for whether a function is intrinsic or not.
  /// The particular intrinsic functions which correspond to this value are
  /// defined in llvm/Intrinsics.h.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getIntrinsicID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 139,
   FQN="llvm::Function::getIntrinsicID", NM="_ZNK4llvm8Function14getIntrinsicIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14getIntrinsicIDEv")
  //</editor-fold>
  public /*Intrinsic.ID*/int getIntrinsicID() /*const*//* __attribute__((pure))*/ {
    return IntID;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::isIntrinsic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 140,
   FQN="llvm::Function::isIntrinsic", NM="_ZNK4llvm8Function11isIntrinsicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function11isIntrinsicEv")
  //</editor-fold>
  public boolean isIntrinsic() /*const*/ {
    return getName().startswith(/*STRINGREF_STR*/"llvm.");
  }

  
  /// \brief Recalculate the ID for this function if it is an Intrinsic defined
  /// in llvm/Intrinsics.h.  Sets the intrinsic ID to Intrinsic::not_intrinsic
  /// if the name of this function does not match an intrinsic in that header.
  /// Note, this method does not need to be called directly, as it is called
  /// from Value::setName() whenever the name of this function changes.
  
  /// \brief Recalculate the ID for this function if it is an Intrinsic defined
  /// in llvm/Intrinsics.h.  Sets the intrinsic ID to Intrinsic::not_intrinsic
  /// if the name of this function does not match an intrinsic in that header.
  /// Note, this method does not need to be called directly, as it is called
  /// from Value::setName() whenever the name of this function changes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::recalculateIntrinsicID">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 510,
   FQN="llvm::Function::recalculateIntrinsicID", NM="_ZN4llvm8Function22recalculateIntrinsicIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function22recalculateIntrinsicIDEv")
  //</editor-fold>
  public void recalculateIntrinsicID() {
    /*const*/ StringMapEntry<Value /*P*/ > /*P*/ ValName = /*J:ToBase*/super.getValueName();
    if (!(ValName != null) || !isIntrinsic()) {
      IntID = ID.not_intrinsic;
      return;
    }
    IntID = lookupIntrinsicID(ValName);
  }


  
  /// getCallingConv()/setCallingConv(CC) - These method get and set the
  /// calling convention of this function.  The enum values for the known
  /// calling conventions are defined in CallingConv.h.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 152,
   FQN="llvm::Function::getCallingConv", NM="_ZNK4llvm8Function14getCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14getCallingConvEv")
  //</editor-fold>
  public /*uint*/int getCallingConv() /*const*/ {
    return ((/*static_cast*//*uint*/int)(($ushort2int(getSubclassDataFromValue()) >> 4)
       & CallingConv.MaxID));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 156,
   FQN="llvm::Function::setCallingConv", NM="_ZN4llvm8Function14setCallingConvEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function14setCallingConvEj")
  //</editor-fold>
  public void setCallingConv(/*uint*/int CC) {
    /*uint*/int ID = ((/*static_cast*//*uint*/int)(CC));
    assert (!((ID & ~CallingConv.MaxID) != 0)) : "Unsupported calling convention";
    setValueSubclassData_Function($uint2ushort(($ushort2int(getSubclassDataFromValue()) & 0xc00f) | (ID << 4)));
  }

  
  /// @brief Return the attribute list for this Function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 163,
   FQN="llvm::Function::getAttributes", NM="_ZNK4llvm8Function13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function13getAttributesEv")
  //</editor-fold>
  public AttributeSet getAttributes() /*const*/ {
    return new AttributeSet(AttributeSets);
  }

  
  /// @brief Set the attribute list for this Function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 166,
   FQN="llvm::Function::setAttributes", NM="_ZN4llvm8Function13setAttributesENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function13setAttributesENS_12AttributeSetE")
  //</editor-fold>
  public void setAttributes(AttributeSet Attrs) {
    AttributeSets.$assign(Attrs);
  }

  
  /// @brief Add function attributes to this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 169,
   FQN="llvm::Function::addFnAttr", NM="_ZN4llvm8Function9addFnAttrENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function9addFnAttrENS_9Attribute8AttrKindE")
  //</editor-fold>
  public void addFnAttr(Attribute.AttrKind N) {
    setAttributes(AttributeSets.addAttribute(getContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), N));
  }

  
  /// @brief Remove function attributes from this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::removeFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 175,
   FQN="llvm::Function::removeFnAttr", NM="_ZN4llvm8Function12removeFnAttrENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function12removeFnAttrENS_9Attribute8AttrKindE")
  //</editor-fold>
  public void removeFnAttr(Attribute.AttrKind Kind) {
    setAttributes(AttributeSets.removeAttribute(getContext(), AttributeSet.AttrIndex.FunctionIndex.getValue(), Kind));
  }

  
  /// @brief Add function attributes to this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 181,
   FQN="llvm::Function::addFnAttr", NM="_ZN4llvm8Function9addFnAttrENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function9addFnAttrENS_9StringRefE")
  //</editor-fold>
  public void addFnAttr(StringRef Kind) {
    setAttributes(AttributeSets.addAttribute(getContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), new StringRef(Kind)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 186,
   FQN="llvm::Function::addFnAttr", NM="_ZN4llvm8Function9addFnAttrENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function9addFnAttrENS_9StringRefES1_")
  //</editor-fold>
  public void addFnAttr(StringRef Kind, StringRef Value) {
    setAttributes(AttributeSets.addAttribute(getContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), new StringRef(Kind), new StringRef(Value)));
  }

  
  /// Set the entry count for this function.
  
  /// Set the entry count for this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setEntryCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1256,
   FQN="llvm::Function::setEntryCount", NM="_ZN4llvm8Function13setEntryCountEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function13setEntryCountEy")
  //</editor-fold>
  public void setEntryCount(long/*uint64_t*/ Count) {
    MDBuilder MDB/*J*/= new MDBuilder(getContext());
    setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(), MDB.createFunctionEntryCount(Count));
  }


  
  /// Get the entry count for this function.
  
  /// Get the entry count for this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getEntryCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1261,
   FQN="llvm::Function::getEntryCount", NM="_ZNK4llvm8Function13getEntryCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function13getEntryCountEv")
  //</editor-fold>
  public OptionalULong getEntryCount() /*const*/ {
    MDNode /*P*/ MD = getMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue());
    if ((MD != null) && ((MD.getOperand(0).$Metadata$P()) != null)) {
      {
        MDString /*P*/ MDS = dyn_cast_MDString(MD.getOperand(0));
        if ((MDS != null)) {
          if (MDS.getString().equals(/*STRINGREF_STR*/"function_entry_count")) {
            ConstantInt /*P*/ CI = mdconst./*<ConstantInt, MDOperand>*/extract$ValidPointer(MD.getOperand(1));
            return new OptionalULong(JD$T$RR.INSTANCE, CI.getValue().getZExtValue());
          }
        }
      }
    }
    return new OptionalULong(None);
  }

  // JAVA: that's temporary and should be replaced as soon as we find a proper place
  private static class mdconst {
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 511)
    public static <X, Y> X extract$ValidPointer(Y /*&&*/MMD) {
      throw new UnsupportedOperationException("EmptyBody");
      //return cast_ConstantAsMetadata(MMD).getValue();
    }
  }
  
  
  /// @brief Return true if the function has the attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasFnAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 199,
   FQN="llvm::Function::hasFnAttribute", NM="_ZNK4llvm8Function14hasFnAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14hasFnAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasFnAttribute(Attribute.AttrKind Kind) /*const*/ {
    return AttributeSets.hasFnAttribute(Kind);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasFnAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 202,
   FQN="llvm::Function::hasFnAttribute", NM="_ZNK4llvm8Function14hasFnAttributeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14hasFnAttributeENS_9StringRefE")
  //</editor-fold>
  public boolean hasFnAttribute(StringRef Kind) /*const*/ {
    return AttributeSets.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), new StringRef(Kind));
  }

  
  /// @brief Return the attribute for the given attribute kind.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getFnAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 207,
   FQN="llvm::Function::getFnAttribute", NM="_ZNK4llvm8Function14getFnAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14getFnAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public Attribute getFnAttribute(Attribute.AttrKind Kind) /*const*/ {
    return getAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Kind);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getFnAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 210,
   FQN="llvm::Function::getFnAttribute", NM="_ZNK4llvm8Function14getFnAttributeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14getFnAttributeENS_9StringRefE")
  //</editor-fold>
  public Attribute getFnAttribute(StringRef Kind) /*const*/ {
    return getAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), new StringRef(Kind));
  }

  
  /// \brief Return the stack alignment for the function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getFnStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 215,
   FQN="llvm::Function::getFnStackAlignment", NM="_ZNK4llvm8Function19getFnStackAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function19getFnStackAlignmentEv")
  //</editor-fold>
  public /*uint*/int getFnStackAlignment() /*const*/ {
    if (!hasFnAttribute(Attribute.AttrKind.StackAlignment)) {
      return 0;
    }
    return AttributeSets.getStackAlignment(AttributeSet.AttrIndex.FunctionIndex.getValue());
  }

  
  /// hasGC/getGC/setGC/clearGC - The name of the garbage collection algorithm
  ///                             to use during code generation.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 223,
   FQN="llvm::Function::hasGC", NM="_ZNK4llvm8Function5hasGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function5hasGCEv")
  //</editor-fold>
  public boolean hasGC() /*const*/ {
    return (($ushort2int(getSubclassDataFromValue()) & (1 << 14)) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 417,
   FQN="llvm::Function::getGC", NM="_ZNK4llvm8Function5getGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function5getGCEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getGC() /*const*/ {
    assert (hasGC()) : "Function has no collector";
    return getContext().getGC(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 422,
   FQN="llvm::Function::setGC", NM="_ZN4llvm8Function5setGCESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function5setGCESs")
  //</editor-fold>
  public void setGC(std.string Str) {
    setValueSubclassDataBit(14, !Str.empty());
    getContext().setGC(/*Deref*/this, new std.string(JD$Move.INSTANCE, std.move(Str)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Function::clearGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 427,
   FQN="llvm::Function::clearGC", NM="_ZN4llvm8Function7clearGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function7clearGCEv")
  //</editor-fold>
  public void clearGC() {
    if (!hasGC()) {
      return;
    }
    getContext().deleteGC(/*Deref*/this);
    setValueSubclassDataBit(14, false);
  }


  
  /// @brief adds the attribute to the list of attributes.
  
  /// @brief adds the attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 369,
   FQN="llvm::Function::addAttribute", NM="_ZN4llvm8Function12addAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function12addAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.addAttribute(getContext(), i, Kind));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief adds the attribute to the list of attributes.
  
  /// @brief adds the attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 375,
   FQN="llvm::Function::addAttribute", NM="_ZN4llvm8Function12addAttributeEjNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function12addAttributeEjNS_9AttributeE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute Attr) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.addAttribute(getContext(), new ArrayRefUInt(i), new Attribute(Attr)));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief adds the attributes to the list of attributes.
  
  /// @brief adds the attributes to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 381,
   FQN="llvm::Function::addAttributes", NM="_ZN4llvm8Function13addAttributesEjNS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function13addAttributesEjNS_12AttributeSetE")
  //</editor-fold>
  public void addAttributes(/*uint*/int i, AttributeSet Attrs) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.addAttributes(getContext(), i, new AttributeSet(Attrs)));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief removes the attribute from the list of attributes.
  
  /// @brief removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 387,
   FQN="llvm::Function::removeAttribute", NM="_ZN4llvm8Function15removeAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function15removeAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.removeAttribute(getContext(), i, Kind));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief removes the attribute from the list of attributes.
  
  /// @brief removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 393,
   FQN="llvm::Function::removeAttribute", NM="_ZN4llvm8Function15removeAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function15removeAttributeEjNS_9StringRefE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, StringRef Kind) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.removeAttribute(getContext(), i, new StringRef(Kind)));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief removes the attributes from the list of attributes.
  
  /// @brief removes the attributes from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::removeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 399,
   FQN="llvm::Function::removeAttributes", NM="_ZN4llvm8Function16removeAttributesEjNS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function16removeAttributesEjNS_12AttributeSetE")
  //</editor-fold>
  public void removeAttributes(/*uint*/int i, AttributeSet Attrs) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.removeAttributes(getContext(), i, new AttributeSet(Attrs)));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief check if an attributes is in the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 249,
   FQN="llvm::Function::hasAttribute", NM="_ZNK4llvm8Function12hasAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function12hasAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasAttribute(/*uint*/int i, Attribute.AttrKind Kind) /*const*/ {
    return getAttributes().hasAttribute(i, Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 253,
   FQN="llvm::Function::getAttribute", NM="_ZNK4llvm8Function12getAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function12getAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i, Attribute.AttrKind Kind) /*const*/ {
    return AttributeSets.getAttribute(i, Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 257,
   FQN="llvm::Function::getAttribute", NM="_ZNK4llvm8Function12getAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function12getAttributeEjNS_9StringRefE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i, StringRef Kind) /*const*/ {
    return AttributeSets.getAttribute(i, new StringRef(Kind));
  }

  
  /// @brief adds the dereferenceable attribute to the list of attributes.
  
  /// @brief adds the dereferenceable attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addDereferenceableAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 405,
   FQN="llvm::Function::addDereferenceableAttr", NM="_ZN4llvm8Function22addDereferenceableAttrEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function22addDereferenceableAttrEjy")
  //</editor-fold>
  public void addDereferenceableAttr(/*uint*/int i, long/*uint64_t*/ Bytes) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.addDereferenceableAttr(getContext(), i, Bytes));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief adds the dereferenceable_or_null attribute to the list of
  /// attributes.
  
  /// @brief adds the dereferenceable_or_null attribute to the list of
  /// attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::addDereferenceableOrNullAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 411,
   FQN="llvm::Function::addDereferenceableOrNullAttr", NM="_ZN4llvm8Function28addDereferenceableOrNullAttrEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function28addDereferenceableOrNullAttrEjy")
  //</editor-fold>
  public void addDereferenceableOrNullAttr(/*uint*/int i, long/*uint64_t*/ Bytes) {
    AttributeSet PAL = getAttributes();
    PAL.$assignMove(PAL.addDereferenceableOrNullAttr(getContext(), i, Bytes));
    setAttributes(new AttributeSet(PAL));
  }


  
  /// @brief Extract the alignment for a call or parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getParamAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 269,
   FQN="llvm::Function::getParamAlignment", NM="_ZNK4llvm8Function17getParamAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function17getParamAlignmentEj")
  //</editor-fold>
  public /*uint*/int getParamAlignment(/*uint*/int i) /*const*/ {
    return AttributeSets.getParamAlignment(i);
  }

  
  /// @brief Extract the number of dereferenceable bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 275,
   FQN="llvm::Function::getDereferenceableBytes", NM="_ZNK4llvm8Function23getDereferenceableBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function23getDereferenceableBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes(/*uint*/int i) /*const*/ {
    return AttributeSets.getDereferenceableBytes(i);
  }

  
  /// @brief Extract the number of dereferenceable_or_null bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 281,
   FQN="llvm::Function::getDereferenceableOrNullBytes", NM="_ZNK4llvm8Function29getDereferenceableOrNullBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function29getDereferenceableOrNullBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes(/*uint*/int i) /*const*/ {
    return AttributeSets.getDereferenceableOrNullBytes(i);
  }

  
  /// @brief Determine if the function does not access memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 286,
   FQN="llvm::Function::doesNotAccessMemory", NM="_ZNK4llvm8Function19doesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function19doesNotAccessMemoryEv")
  //</editor-fold>
  public boolean doesNotAccessMemory() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.ReadNone);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 289,
   FQN="llvm::Function::setDoesNotAccessMemory", NM="_ZN4llvm8Function22setDoesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function22setDoesNotAccessMemoryEv")
  //</editor-fold>
  public void setDoesNotAccessMemory() {
    addFnAttr(Attribute.AttrKind.ReadNone);
  }

  
  /// @brief Determine if the function does not access or only reads memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 294,
   FQN="llvm::Function::onlyReadsMemory", NM="_ZNK4llvm8Function15onlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function15onlyReadsMemoryEv")
  //</editor-fold>
  public boolean onlyReadsMemory() /*const*/ {
    return doesNotAccessMemory() || hasFnAttribute(Attribute.AttrKind.ReadOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setOnlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 297,
   FQN="llvm::Function::setOnlyReadsMemory", NM="_ZN4llvm8Function18setOnlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function18setOnlyReadsMemoryEv")
  //</editor-fold>
  public void setOnlyReadsMemory() {
    addFnAttr(Attribute.AttrKind.ReadOnly);
  }

  
  /// @brief Determine if the function does not access or only writes memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotReadMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 302,
   FQN="llvm::Function::doesNotReadMemory", NM="_ZNK4llvm8Function17doesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function17doesNotReadMemoryEv")
  //</editor-fold>
  public boolean doesNotReadMemory() /*const*/ {
    return doesNotAccessMemory() || hasFnAttribute(Attribute.AttrKind.WriteOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotReadMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 305,
   FQN="llvm::Function::setDoesNotReadMemory", NM="_ZN4llvm8Function20setDoesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function20setDoesNotReadMemoryEv")
  //</editor-fold>
  public void setDoesNotReadMemory() {
    addFnAttr(Attribute.AttrKind.WriteOnly);
  }

  
  /// @brief Determine if the call can access memmory only using pointers based
  /// on its arguments.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::onlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 311,
   FQN="llvm::Function::onlyAccessesArgMemory", NM="_ZNK4llvm8Function21onlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function21onlyAccessesArgMemoryEv")
  //</editor-fold>
  public boolean onlyAccessesArgMemory() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.ArgMemOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setOnlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 314,
   FQN="llvm::Function::setOnlyAccessesArgMemory", NM="_ZN4llvm8Function24setOnlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function24setOnlyAccessesArgMemoryEv")
  //</editor-fold>
  public void setOnlyAccessesArgMemory() {
    addFnAttr(Attribute.AttrKind.ArgMemOnly);
  }

  
  /// @brief Determine if the function may only access memory that is 
  ///  inaccessible from the IR.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::onlyAccessesInaccessibleMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 318,
   FQN="llvm::Function::onlyAccessesInaccessibleMemory", NM="_ZNK4llvm8Function30onlyAccessesInaccessibleMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function30onlyAccessesInaccessibleMemoryEv")
  //</editor-fold>
  public boolean onlyAccessesInaccessibleMemory() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.InaccessibleMemOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setOnlyAccessesInaccessibleMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 321,
   FQN="llvm::Function::setOnlyAccessesInaccessibleMemory", NM="_ZN4llvm8Function33setOnlyAccessesInaccessibleMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function33setOnlyAccessesInaccessibleMemoryEv")
  //</editor-fold>
  public void setOnlyAccessesInaccessibleMemory() {
    addFnAttr(Attribute.AttrKind.InaccessibleMemOnly);
  }

  
  /// @brief Determine if the function may only access memory that is
  //  either inaccessible from the IR or pointed to by its arguments.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::onlyAccessesInaccessibleMemOrArgMem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 327,
   FQN="llvm::Function::onlyAccessesInaccessibleMemOrArgMem", NM="_ZNK4llvm8Function35onlyAccessesInaccessibleMemOrArgMemEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function35onlyAccessesInaccessibleMemOrArgMemEv")
  //</editor-fold>
  public boolean onlyAccessesInaccessibleMemOrArgMem() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.InaccessibleMemOrArgMemOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setOnlyAccessesInaccessibleMemOrArgMem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 330,
   FQN="llvm::Function::setOnlyAccessesInaccessibleMemOrArgMem", NM="_ZN4llvm8Function38setOnlyAccessesInaccessibleMemOrArgMemEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function38setOnlyAccessesInaccessibleMemOrArgMemEv")
  //</editor-fold>
  public void setOnlyAccessesInaccessibleMemOrArgMem() {
    addFnAttr(Attribute.AttrKind.InaccessibleMemOrArgMemOnly);
  }

  
  /// @brief Determine if the function cannot return.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 335,
   FQN="llvm::Function::doesNotReturn", NM="_ZNK4llvm8Function13doesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function13doesNotReturnEv")
  //</editor-fold>
  public boolean doesNotReturn() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.NoReturn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 338,
   FQN="llvm::Function::setDoesNotReturn", NM="_ZN4llvm8Function16setDoesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function16setDoesNotReturnEv")
  //</editor-fold>
  public void setDoesNotReturn() {
    addFnAttr(Attribute.AttrKind.NoReturn);
  }

  
  /// @brief Determine if the function cannot unwind.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 343,
   FQN="llvm::Function::doesNotThrow", NM="_ZNK4llvm8Function12doesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function12doesNotThrowEv")
  //</editor-fold>
  public boolean doesNotThrow() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.NoUnwind);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 346,
   FQN="llvm::Function::setDoesNotThrow", NM="_ZN4llvm8Function15setDoesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function15setDoesNotThrowEv")
  //</editor-fold>
  public void setDoesNotThrow() {
    addFnAttr(Attribute.AttrKind.NoUnwind);
  }

  
  /// @brief Determine if the call cannot be duplicated.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::cannotDuplicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 351,
   FQN="llvm::Function::cannotDuplicate", NM="_ZNK4llvm8Function15cannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function15cannotDuplicateEv")
  //</editor-fold>
  public boolean cannotDuplicate() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.NoDuplicate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setCannotDuplicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 354,
   FQN="llvm::Function::setCannotDuplicate", NM="_ZN4llvm8Function18setCannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function18setCannotDuplicateEv")
  //</editor-fold>
  public void setCannotDuplicate() {
    addFnAttr(Attribute.AttrKind.NoDuplicate);
  }

  
  /// @brief Determine if the call is convergent.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::isConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 359,
   FQN="llvm::Function::isConvergent", NM="_ZNK4llvm8Function12isConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function12isConvergentEv")
  //</editor-fold>
  public boolean isConvergent() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.Convergent);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 362,
   FQN="llvm::Function::setConvergent", NM="_ZN4llvm8Function13setConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function13setConvergentEv")
  //</editor-fold>
  public void setConvergent() {
    addFnAttr(Attribute.AttrKind.Convergent);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setNotConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 365,
   FQN="llvm::Function::setNotConvergent", NM="_ZN4llvm8Function16setNotConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function16setNotConvergentEv")
  //</editor-fold>
  public void setNotConvergent() {
    removeFnAttr(Attribute.AttrKind.Convergent);
  }

  
  /// Determine if the function is known not to recurse, directly or
  /// indirectly.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotRecurse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 371,
   FQN="llvm::Function::doesNotRecurse", NM="_ZNK4llvm8Function14doesNotRecurseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14doesNotRecurseEv")
  //</editor-fold>
  public boolean doesNotRecurse() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.NoRecurse);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotRecurse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 374,
   FQN="llvm::Function::setDoesNotRecurse", NM="_ZN4llvm8Function17setDoesNotRecurseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function17setDoesNotRecurseEv")
  //</editor-fold>
  public void setDoesNotRecurse() {
    addFnAttr(Attribute.AttrKind.NoRecurse);
  }

  
  /// @brief True if the ABI mandates (or the user requested) that this
  /// function be in a unwind table.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasUWTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 380,
   FQN="llvm::Function::hasUWTable", NM="_ZNK4llvm8Function10hasUWTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function10hasUWTableEv")
  //</editor-fold>
  public boolean hasUWTable() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.UWTable);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setHasUWTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 383,
   FQN="llvm::Function::setHasUWTable", NM="_ZN4llvm8Function13setHasUWTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function13setHasUWTableEv")
  //</editor-fold>
  public void setHasUWTable() {
    addFnAttr(Attribute.AttrKind.UWTable);
  }

  
  /// @brief True if this function needs an unwind table.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::needsUnwindTableEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 388,
   FQN="llvm::Function::needsUnwindTableEntry", NM="_ZNK4llvm8Function21needsUnwindTableEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function21needsUnwindTableEntryEv")
  //</editor-fold>
  public boolean needsUnwindTableEntry() /*const*/ {
    return hasUWTable() || !doesNotThrow();
  }

  
  /// @brief Determine if the function returns a structure through first
  /// pointer argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasStructRetAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 394,
   FQN="llvm::Function::hasStructRetAttr", NM="_ZNK4llvm8Function16hasStructRetAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function16hasStructRetAttrEv")
  //</editor-fold>
  public boolean hasStructRetAttr() /*const*/ {
    return AttributeSets.hasAttribute(1, Attribute.AttrKind.StructRet)
       || AttributeSets.hasAttribute(2, Attribute.AttrKind.StructRet);
  }

  
  /// @brief Determine if the parameter or return value is marked with NoAlias
  /// attribute.
  /// @param n The parameter to check. 1 is the first parameter, 0 is the return
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 402,
   FQN="llvm::Function::doesNotAlias", NM="_ZNK4llvm8Function12doesNotAliasEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function12doesNotAliasEj")
  //</editor-fold>
  public boolean doesNotAlias(/*uint*/int n) /*const*/ {
    return AttributeSets.hasAttribute(n, Attribute.AttrKind.NoAlias);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 405,
   FQN="llvm::Function::setDoesNotAlias", NM="_ZN4llvm8Function15setDoesNotAliasEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function15setDoesNotAliasEj")
  //</editor-fold>
  public void setDoesNotAlias(/*uint*/int n) {
    addAttribute(n, Attribute.AttrKind.NoAlias);
  }

  
  /// @brief Determine if the parameter can be captured.
  /// @param n The parameter to check. 1 is the first parameter, 0 is the return
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 411,
   FQN="llvm::Function::doesNotCapture", NM="_ZNK4llvm8Function14doesNotCaptureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function14doesNotCaptureEj")
  //</editor-fold>
  public boolean doesNotCapture(/*uint*/int n) /*const*/ {
    return AttributeSets.hasAttribute(n, Attribute.AttrKind.NoCapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 414,
   FQN="llvm::Function::setDoesNotCapture", NM="_ZN4llvm8Function17setDoesNotCaptureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function17setDoesNotCaptureEj")
  //</editor-fold>
  public void setDoesNotCapture(/*uint*/int n) {
    addAttribute(n, Attribute.AttrKind.NoCapture);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 418,
   FQN="llvm::Function::doesNotAccessMemory", NM="_ZNK4llvm8Function19doesNotAccessMemoryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function19doesNotAccessMemoryEj")
  //</editor-fold>
  public boolean doesNotAccessMemory(/*uint*/int n) /*const*/ {
    return AttributeSets.hasAttribute(n, Attribute.AttrKind.ReadNone);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setDoesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 421,
   FQN="llvm::Function::setDoesNotAccessMemory", NM="_ZN4llvm8Function22setDoesNotAccessMemoryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function22setDoesNotAccessMemoryEj")
  //</editor-fold>
  public void setDoesNotAccessMemory(/*uint*/int n) {
    addAttribute(n, Attribute.AttrKind.ReadNone);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 425,
   FQN="llvm::Function::onlyReadsMemory", NM="_ZNK4llvm8Function15onlyReadsMemoryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function15onlyReadsMemoryEj")
  //</editor-fold>
  public boolean onlyReadsMemory(/*uint*/int n) /*const*/ {
    return doesNotAccessMemory(n)
       || AttributeSets.hasAttribute(n, Attribute.AttrKind.ReadOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setOnlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 429,
   FQN="llvm::Function::setOnlyReadsMemory", NM="_ZN4llvm8Function18setOnlyReadsMemoryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function18setOnlyReadsMemoryEj")
  //</editor-fold>
  public void setOnlyReadsMemory(/*uint*/int n) {
    addAttribute(n, Attribute.AttrKind.ReadOnly);
  }

  
  /// Optimize this function for minimum size (-Oz).
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::optForMinSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 434,
   FQN="llvm::Function::optForMinSize", NM="_ZNK4llvm8Function13optForMinSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function13optForMinSizeEv")
  //</editor-fold>
  public boolean optForMinSize() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.MinSize);
  }

  
  /// Optimize this function for size (-Os) or minimum size (-Oz).
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::optForSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 437,
   FQN="llvm::Function::optForSize", NM="_ZNK4llvm8Function10optForSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function10optForSizeEv")
  //</editor-fold>
  public boolean optForSize() /*const*/ {
    return hasFnAttribute(Attribute.AttrKind.OptimizeForSize) || optForMinSize();
  }

  
  /// copyAttributesFrom - copy all additional attributes (those not needed to
  /// create a Function) from the Function Src to this one.
  
  /// copyAttributesFrom - copy all additional attributes (those not needed to
  /// create a Function) from the Function Src to this one.
  
  /// Copy all additional attributes (those not needed to create a Function) from
  /// the Function Src to this one.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::copyAttributesFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 436,
   FQN="llvm::Function::copyAttributesFrom", NM="_ZN4llvm8Function18copyAttributesFromEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function18copyAttributesFromEPKNS_11GlobalValueE")
  //</editor-fold>
  @Override public void copyAttributesFrom(/*const*/ GlobalValue /*P*/ Src)/* override*/ {
    super.copyAttributesFrom(Src);
    /*const*/ Function /*P*/ SrcF = dyn_cast_Function(Src);
    if (!(SrcF != null)) {
      return;
    }
    
    setCallingConv(SrcF.getCallingConv());
    setAttributes(SrcF.getAttributes());
    if (SrcF.hasGC()) {
      setGC(new std.string(SrcF.getGC()));
    } else {
      clearGC();
    }
    if (SrcF.hasPersonalityFn()) {
      setPersonalityFn(SrcF.getPersonalityFn());
    }
    if (SrcF.hasPrefixData()) {
      setPrefixData(SrcF.getPrefixData());
    }
    if (SrcF.hasPrologueData()) {
      setPrologueData(SrcF.getPrologueData());
    }
  }


  
  /// deleteBody - This method deletes the body of the function, and converts
  /// the linkage to external.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::deleteBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 448,
   FQN="llvm::Function::deleteBody", NM="_ZN4llvm8Function10deleteBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function10deleteBodyEv")
  //</editor-fold>
  public void deleteBody() {
    dropAllReferences();
    setLinkage(LinkageTypes.ExternalLinkage);
  }

  
  /// removeFromParent - This method unlinks 'this' from the containing module,
  /// but does not delete it.
  ///
  
  /// removeFromParent - This method unlinks 'this' from the containing module,
  /// but does not delete it.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::removeFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 246,
   FQN="llvm::Function::removeFromParent", NM="_ZN4llvm8Function16removeFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function16removeFromParentEv")
  //</editor-fold>
  @Override public void removeFromParent()/* override*/ {
    getParent().getFunctionList().remove_ilist_iterator$NodeTy$C(getIterator());
  }


  
  /// eraseFromParent - This method unlinks 'this' from the containing module
  /// and deletes it.
  ///
  
  /// eraseFromParent - This method unlinks 'this' from the containing module
  /// and deletes it.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 250,
   FQN="llvm::Function::eraseFromParent", NM="_ZN4llvm8Function15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function15eraseFromParentEv")
  //</editor-fold>
  @Override public void eraseFromParent()/* override*/ {
    getParent().getFunctionList().erase(getIterator());
  }


  
  /// Steal arguments from another function.
  ///
  /// Drop this function's arguments and splice in the ones from \c Src.
  /// Requires that this has no function body.
  
  /// Steal arguments from another function.
  ///
  /// Drop this function's arguments and splice in the ones from \c Src.
  /// Requires that this has no function body.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::stealArgumentListFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 306,
   FQN="llvm::Function::stealArgumentListFrom", NM="_ZN4llvm8Function21stealArgumentListFromERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function21stealArgumentListFromERS0_")
  //</editor-fold>
  public void stealArgumentListFrom(final Function /*&*/ Src) {
    assert (isDeclaration()) : "Expected no references to current arguments";
    
    // Drop the current arguments, if any, and set the lazy argument bit.
    if (!hasLazyArguments()) {
      assert (llvm.all_of(ArgumentList, /*[]*/ (final /*const*/ Argument /*&*/ A) -> {
            return A.use_empty();
          })) : "Expected arguments to be unused in declaration";
      ArgumentList.clear();
      setValueSubclassData_Function($int2ushort($ushort2int(getSubclassDataFromValue()) | (1 << 0)));
    }
    
    // Nothing to steal if Src has lazy arguments.
    if (Src.hasLazyArguments()) {
      return;
    }
    
    // Steal arguments from Src, and fix the lazy argument bits.
    ArgumentList.splice(ArgumentList.end(), Src.ArgumentList);
    setValueSubclassData_Function($int2ushort($ushort2int(getSubclassDataFromValue()) & ~(1 << 0)));
    Src.setValueSubclassData_Function($int2ushort($ushort2int(Src.getSubclassDataFromValue()) | (1 << 0)));
  }


  
  /// Get the underlying elements of the Function... the basic block list is
  /// empty for external functions.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 472,
   FQN="llvm::Function::getArgumentList", NM="_ZNK4llvm8Function15getArgumentListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function15getArgumentListEv")
  //</editor-fold>
  public /*friend*//*public*/ /*const*/SymbolTableList<Argument, Function>/*&*/ getArgumentList$Const() /*const*/ {
    CheckLazyArguments();
    return ArgumentList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 476,
   FQN="llvm::Function::getArgumentList", NM="_ZN4llvm8Function15getArgumentListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function15getArgumentListEv")
  //</editor-fold>
  public /*friend*//*public*/ SymbolTableList<Argument, Function>/*&*/ getArgumentList() {
    CheckLazyArguments();
    return ArgumentList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 480,
   FQN="llvm::Function::getSublistAccess", NM="_ZN4llvm8Function16getSublistAccessEPNS_8ArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function16getSublistAccessEPNS_8ArgumentE")
  //</editor-fold>
  public static Void2SymbolTableList<Argument, Function> getSublistAccess(Argument /*P*/ $Prm0) {
    return (final Function $this) -> $this.ArgumentList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getBasicBlockList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 484,
   FQN="llvm::Function::getBasicBlockList", NM="_ZNK4llvm8Function17getBasicBlockListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function17getBasicBlockListEv")
  //</editor-fold>
  public /*friend*//*public*/ /*const*/SymbolTableList<BasicBlock, Function>/*&*/ getBasicBlockList$Const() /*const*/ {
    return BasicBlocks;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getBasicBlockList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 485,
   FQN="llvm::Function::getBasicBlockList", NM="_ZN4llvm8Function17getBasicBlockListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function17getBasicBlockListEv")
  //</editor-fold>
  public /*friend*//*public*/ SymbolTableList<BasicBlock, Function>/*&*/ getBasicBlockList() {
    return BasicBlocks;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 486,
   FQN="llvm::Function::getSublistAccess", NM="_ZN4llvm8Function16getSublistAccessEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function16getSublistAccessEPNS_10BasicBlockE")
  //</editor-fold>
  public static Void2SymbolTableList<BasicBlock, Function> getSublistAccess(BasicBlock /*P*/ $Prm0) {
    return (final Function $this) -> $this.BasicBlocks;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getEntryBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 490,
   FQN="llvm::Function::getEntryBlock", NM="_ZNK4llvm8Function13getEntryBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function13getEntryBlockEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*&*/ getEntryBlock$Const() /*const*/ {
    return front$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getEntryBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 491,
   FQN="llvm::Function::getEntryBlock", NM="_ZN4llvm8Function13getEntryBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function13getEntryBlockEv")
  //</editor-fold>
  public BasicBlock /*&*/ getEntryBlock() {
    return front();
  }

  
  //===--------------------------------------------------------------------===//
  // Symbol Table Accessing functions...
  
  /// getSymbolTable() - Return the symbol table...
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 498,
   FQN="llvm::Function::getValueSymbolTable", NM="_ZN4llvm8Function19getValueSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function19getValueSymbolTableEv")
  //</editor-fold>
  public /*inline*/ ValueSymbolTable /*&*/ getValueSymbolTable() {
    return $Deref(SymTab);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 499,
   FQN="llvm::Function::getValueSymbolTable", NM="_ZNK4llvm8Function19getValueSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function19getValueSymbolTableEv")
  //</editor-fold>
  public /*inline*/ /*const*/ ValueSymbolTable /*&*/ getValueSymbolTable$Const() /*const*/ {
    return $Deref(SymTab);
  }

  
  //===--------------------------------------------------------------------===//
  // BasicBlock iterator forwarding functions
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 504,
   FQN="llvm::Function::begin", NM="_ZN4llvm8Function5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function5beginEv")
  //</editor-fold>
  public ilist_iterator<BasicBlock> begin() {
    return BasicBlocks.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 505,
   FQN="llvm::Function::begin", NM="_ZNK4llvm8Function5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function5beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ BasicBlock> begin$Const() /*const*/ {
    return BasicBlocks.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 506,
   FQN="llvm::Function::end", NM="_ZN4llvm8Function3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function3endEv")
  //</editor-fold>
  public ilist_iterator<BasicBlock> end() {
    return BasicBlocks.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 507,
   FQN="llvm::Function::end", NM="_ZNK4llvm8Function3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function3endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ BasicBlock> end$Const() /*const*/ {
    return BasicBlocks.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 509,
   FQN="llvm::Function::size", NM="_ZNK4llvm8Function4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return BasicBlocks.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 510,
   FQN="llvm::Function::empty", NM="_ZNK4llvm8Function5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return BasicBlocks.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 511,
   FQN="llvm::Function::front", NM="_ZNK4llvm8Function5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function5frontEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*&*/ front$Const() /*const*/ {
    return BasicBlocks.front$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 512,
   FQN="llvm::Function::front", NM="_ZN4llvm8Function5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function5frontEv")
  //</editor-fold>
  public BasicBlock /*&*/ front() {
    return BasicBlocks.front();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 513,
   FQN="llvm::Function::back", NM="_ZNK4llvm8Function4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function4backEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*&*/ back$Const() /*const*/ {
    return BasicBlocks.back$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 514,
   FQN="llvm::Function::back", NM="_ZN4llvm8Function4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function4backEv")
  //</editor-fold>
  public BasicBlock /*&*/ back() {
    return BasicBlocks.back();
  }

  
  /// @name Function Argument Iteration
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 519,
   FQN="llvm::Function::arg_begin", NM="_ZN4llvm8Function9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function9arg_beginEv")
  //</editor-fold>
  public ilist_iterator<Argument> arg_begin() {
    CheckLazyArguments();
    return ArgumentList.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 523,
   FQN="llvm::Function::arg_begin", NM="_ZNK4llvm8Function9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function9arg_beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ Argument> arg_begin$Const() /*const*/ {
    CheckLazyArguments();
    return new ilist_iterator</*const*/ Argument>(ArgumentList.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 527,
   FQN="llvm::Function::arg_end", NM="_ZN4llvm8Function7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function7arg_endEv")
  //</editor-fold>
  public ilist_iterator<Argument> arg_end() {
    CheckLazyArguments();
    return ArgumentList.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 531,
   FQN="llvm::Function::arg_end", NM="_ZNK4llvm8Function7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function7arg_endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ Argument> arg_end$Const() /*const*/ {
    CheckLazyArguments();
    return new ilist_iterator</*const*/ Argument>(ArgumentList.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::args">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 536,
   FQN="llvm::Function::args", NM="_ZN4llvm8Function4argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function4argsEv")
  //</editor-fold>
  public iterator_range<Argument> args() {
    return make_range(arg_begin(), arg_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::args">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 540,
   FQN="llvm::Function::args", NM="_ZNK4llvm8Function4argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function4argsEv")
  //</editor-fold>
  public iterator_range</*const*/ Argument> args$Const() /*const*/ {
    return make_range(arg_begin$Const(), arg_end$Const());
  }

  
  /// @}
  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::arg_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 328,
   FQN="llvm::Function::arg_size", NM="_ZNK4llvm8Function8arg_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function8arg_sizeEv")
  //</editor-fold>
  public /*size_t*/int arg_size() /*const*/ {
    return getFunctionType().getNumParams();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Function::arg_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 331,
   FQN="llvm::Function::arg_empty", NM="_ZNK4llvm8Function9arg_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function9arg_emptyEv")
  //</editor-fold>
  public boolean arg_empty() /*const*/ {
    return getFunctionType().getNumParams() == 0;
  }


  
  /// \brief Check whether this function has a personality function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasPersonalityFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 550,
   FQN="llvm::Function::hasPersonalityFn", NM="_ZNK4llvm8Function16hasPersonalityFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function16hasPersonalityFnEv")
  //</editor-fold>
  public boolean hasPersonalityFn() /*const*/ {
    return (($ushort2int(getSubclassDataFromValue()) & (1 << 3)) != 0);
  }

  
  /// \brief Get the personality function associated with this function.
  
  /// \brief Get the personality function associated with this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getPersonalityFn">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1192,
   FQN="llvm::Function::getPersonalityFn", NM="_ZNK4llvm8Function16getPersonalityFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function16getPersonalityFnEv")
  //</editor-fold>
  public Constant /*P*/ getPersonalityFn() /*const*/ {
    assert (hasPersonalityFn() && (getNumOperands() != 0));
    return cast_Constant(this./*<0>*/Op$Const(0));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setPersonalityFn">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1197,
   FQN="llvm::Function::setPersonalityFn", NM="_ZN4llvm8Function16setPersonalityFnEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function16setPersonalityFnEPNS_8ConstantE")
  //</editor-fold>
  public void setPersonalityFn(Constant /*P*/ Fn) {
    this./*<0>*/setHungoffOperand(0, Fn);
    setValueSubclassDataBit(3, Fn != (Constant /*P*/ )null);
  }


  
  /// \brief Check whether this function has prefix data.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasPrefixData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 559,
   FQN="llvm::Function::hasPrefixData", NM="_ZNK4llvm8Function13hasPrefixDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function13hasPrefixDataEv")
  //</editor-fold>
  public boolean hasPrefixData() /*const*/ {
    return (($ushort2int(getSubclassDataFromValue()) & (1 << 1)) != 0);
  }

  
  /// \brief Get the prefix data associated with this function.
  
  /// \brief Get the prefix data associated with this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getPrefixData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1202,
   FQN="llvm::Function::getPrefixData", NM="_ZNK4llvm8Function13getPrefixDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function13getPrefixDataEv")
  //</editor-fold>
  public Constant /*P*/ getPrefixData() /*const*/ {
    assert (hasPrefixData() && (getNumOperands() != 0));
    return cast_Constant(this.Op(1));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setPrefixData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1207,
   FQN="llvm::Function::setPrefixData", NM="_ZN4llvm8Function13setPrefixDataEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function13setPrefixDataEPNS_8ConstantE")
  //</editor-fold>
  public void setPrefixData(Constant /*P*/ PrefixData) {
    this./*<1>*/setHungoffOperand(1, PrefixData);
    setValueSubclassDataBit(1, PrefixData != (Constant /*P*/ )null);
  }


  
  /// \brief Check whether this function has prologue data.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasPrologueData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 568,
   FQN="llvm::Function::hasPrologueData", NM="_ZNK4llvm8Function15hasPrologueDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function15hasPrologueDataEv")
  //</editor-fold>
  public boolean hasPrologueData() /*const*/ {
    return (($ushort2int(getSubclassDataFromValue()) & (1 << 2)) != 0);
  }

  
  /// \brief Get the prologue data associated with this function.
  
  /// \brief Get the prologue data associated with this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getPrologueData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1212,
   FQN="llvm::Function::getPrologueData", NM="_ZNK4llvm8Function15getPrologueDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function15getPrologueDataEv")
  //</editor-fold>
  public Constant /*P*/ getPrologueData() /*const*/ {
    assert (hasPrologueData() && (getNumOperands() != 0));
    return cast_Constant(this./*<2>*/Op$Const(2));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setPrologueData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1217,
   FQN="llvm::Function::setPrologueData", NM="_ZN4llvm8Function15setPrologueDataEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function15setPrologueDataEPNS_8ConstantE")
  //</editor-fold>
  public void setPrologueData(Constant /*P*/ PrologueData) {
    this./*<2>*/setHungoffOperand(2, PrologueData);
    setValueSubclassDataBit(2, PrologueData != (Constant /*P*/ )null);
  }


  
  /// Print the function to an output stream with an optional
  /// AssemblyAnnotationWriter.
  
  //===----------------------------------------------------------------------===//
  //                       External Interface declarations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3295,
   FQN="llvm::Function::print", NM="_ZNK4llvm8Function5printERNS_11raw_ostreamEPNS_24AssemblyAnnotationWriterEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Function5printERNS_11raw_ostreamEPNS_24AssemblyAnnotationWriterEbb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ ROS) /*const*/ {
    print(ROS, (AssemblyAnnotationWriter /*P*/ )null, 
       false, 
       false);
  }
  public void print(final raw_ostream /*&*/ ROS, AssemblyAnnotationWriter /*P*/ AAW/*= null*/) /*const*/ {
    print(ROS, AAW, 
       false, 
       false);
  }
  public void print(final raw_ostream /*&*/ ROS, AssemblyAnnotationWriter /*P*/ AAW/*= null*/, 
       boolean ShouldPreserveUseListOrder/*= false*/) /*const*/ {
    print(ROS, AAW, 
       ShouldPreserveUseListOrder, 
       false);
  }
  public void print(final raw_ostream /*&*/ ROS, AssemblyAnnotationWriter /*P*/ AAW/*= null*/, 
       boolean ShouldPreserveUseListOrder/*= false*/, 
       boolean IsForDebug/*= false*/) /*const*/ {
    SlotTracker SlotTable = null;
    formatted_raw_ostream OS = null;
    AssemblyWriter W = null;
    try {
      SlotTable/*J*/= new SlotTracker(/*J:ToBase*/super.getParent$Const());
      OS/*J*/= new formatted_raw_ostream(ROS);
      W/*J*/= new AssemblyWriter(OS, SlotTable, /*J:ToBase*/super.getParent$Const(), AAW, 
          IsForDebug, 
          ShouldPreserveUseListOrder);
      W.printFunction(this);
    } finally {
      if (W != null) { W.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      if (SlotTable != null) { SlotTable.$destroy(); }
    }
  }

  
  /// viewCFG - This function is meant for use from the debugger.  You can just
  /// say 'call F->viewCFG()' and a ghostview window should pop up from the
  /// program, displaying the CFG of the current function with the code for each
  /// basic block inside.  This depends on there being a 'dot' and 'gv' program
  /// in your path.
  ///
  
  /// viewCFG - This function is meant for use from the debugger.  You can just
  /// say 'call F->viewCFG()' and a ghostview window should pop up from the
  /// program, displaying the CFG of the current function with the code for each
  /// basic block inside.  This depends on there being a 'dot' and 'gv' program
  /// in your path.
  ///
  
  /// viewCFG - This function is meant for use from the debugger.  You can just
  /// say 'call F->viewCFG()' and a ghostview window should pop up from the
  /// program, displaying the CFG of the current function.  This depends on there
  /// being a 'dot' and 'gv' program in your path.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::viewCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 145,
   FQN="llvm::Function::viewCFG", NM="_ZNK4llvm8Function7viewCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZNK4llvm8Function7viewCFGEv")
  //</editor-fold>
  public void viewCFG() /*const*/ {
    ViewGraph(this, $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"cfg", getName()));
  }


  
  /// viewCFGOnly - This function is meant for use from the debugger.  It works
  /// just like viewCFG, but it does not include the contents of basic blocks
  /// into the nodes, just the label.  If you are only interested in the CFG
  /// this can make the graph smaller.
  ///
  
  /// viewCFGOnly - This function is meant for use from the debugger.  It works
  /// just like viewCFG, but it does not include the contents of basic blocks
  /// into the nodes, just the label.  If you are only interested in the CFG
  /// this can make the graph smaller.
  ///
  
  /// viewCFGOnly - This function is meant for use from the debugger.  It works
  /// just like viewCFG, but it does not include the contents of basic blocks
  /// into the nodes, just the label.  If you are only interested in the CFG
  /// this can make the graph smaller.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::viewCFGOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 154,
   FQN="llvm::Function::viewCFGOnly", NM="_ZNK4llvm8Function11viewCFGOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZNK4llvm8Function11viewCFGOnlyEv")
  //</editor-fold>
  public void viewCFGOnly() /*const*/ {
    ViewGraph(this, $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"cfg", getName()), true);
  }


  
  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 598,
   FQN="llvm::Function::classof", NM="_ZN4llvm8Function7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.FunctionVal.getValue();
  }

  
  /// dropAllReferences() - This method causes all the subinstructions to "let
  /// go" of all references that they are maintaining.  This allows one to
  /// 'delete' a whole module at a time, even though there may be circular
  /// references... first all references are dropped, and all use counts go to
  /// zero.  Then everything is deleted for real.  Note that no operations are
  /// valid on an object that has "dropped all references", except operator
  /// delete.
  ///
  /// Since no other object in the module can have references into the body of a
  /// function, dropping all references deletes the entire body of the function,
  /// including any contained basic blocks.
  ///
  
  /// dropAllReferences() - This method causes all the subinstructions to "let
  /// go" of all references that they are maintaining.  This allows one to
  /// 'delete' a whole module at a time, even though there may be circular
  /// references... first all references are dropped, and all use counts go to
  /// zero.  Then everything is deleted for real.  Note that no operations are
  /// valid on an object that has "dropped all references", except operator
  /// delete.
  ///
  /// Since no other object in the module can have references into the body of a
  /// function, dropping all references deletes the entire body of the function,
  /// including any contained basic blocks.
  ///
  
  // dropAllReferences() - This function causes all the subinstructions to "let
  // go" of all references that they are maintaining.  This allows one to
  // 'delete' a whole class at a time, even though there may be circular
  // references... first all references are dropped, and all use counts go to
  // zero.  Then everything is deleted for real.  Note that no operations are
  // valid on an object that has "dropped all references", except operator
  // delete.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::dropAllReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 347,
   FQN="llvm::Function::dropAllReferences", NM="_ZN4llvm8Function17dropAllReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function17dropAllReferencesEv")
  //</editor-fold>
  public void dropAllReferences() {
    setIsMaterializable(false);
    
    for (final BasicBlock /*&*/ BB : /*Deref*/this)  {
      BB.dropAllReferences();
    }
    
    // Delete all basic blocks. They are now unused, except possibly by
    // blockaddresses, but BasicBlock's destructor takes care of those.
    while (!BasicBlocks.empty()) {
      BasicBlocks.begin().$arrow().eraseFromParent();
    }
    
    // Drop uses of any optional data (real or placeholder).
    if ((getNumOperands() != 0)) {
      super.dropAllReferences();
      setNumHungOffUseOperands(0);
      setValueSubclassData_Function($int2ushort($ushort2int(getSubclassDataFromValue()) & ~0xe));
    }
    
    // Metadata is stored in a side-table.
    clearMetadata();
  }


  
  /// hasAddressTaken - returns true if there are any uses of this function
  /// other than direct calls or invokes to it, or blockaddress expressions.
  /// Optionally passes back an offending user for diagnostic purposes.
  ///
  
  /// hasAddressTaken - returns true if there are any uses of this function
  /// other than direct calls or invokes to it, or blockaddress expressions.
  /// Optionally passes back an offending user for diagnostic purposes.
  ///
  
  /// hasAddressTaken - returns true if there are any uses of this function
  /// other than direct calls or invokes to it.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::hasAddressTaken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1145,
   FQN="llvm::Function::hasAddressTaken", NM="_ZNK4llvm8Function15hasAddressTakenEPPKNS_4UserE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function15hasAddressTakenEPPKNS_4UserE")
  //</editor-fold>
  public boolean hasAddressTaken() /*const*/ {
    return hasAddressTaken((type$ptr</*const*/ User /*P*/ /*P*/>)null);
  }
  public boolean hasAddressTaken(type$ptr</*const*/ User /*P*/ /*P*/> PutOffender/*= null*/) /*const*/ {
    for (final /*const*/ Use /*&*/ U : uses$Const()) {
      /*const*/ User /*P*/ FU = U.getUser();
      if (isa_BlockAddress(FU)) {
        continue;
      }
      if (!isa_CallInst(FU) && !isa_InvokeInst(FU)) {
        if (Native.$bool(PutOffender)) {
          PutOffender.$set(FU);
        }
        return true;
      }
      ImmutableCallSite CS/*J*/= new ImmutableCallSite(cast_Instruction(FU));
      if (!CS.isCallee($AddrOf(U))) {
        if (Native.$bool(PutOffender)) {
          PutOffender.$set(FU);
        }
        return true;
      }
    }
    return false;
  }


  
  /// isDefTriviallyDead - Return true if it is trivially safe to remove
  /// this function definition from the module (because it isn't externally
  /// visible, does not have its address taken, and has no callers).  To make
  /// this more accurate, call removeDeadConstantUsers first.
  
  /// isDefTriviallyDead - Return true if it is trivially safe to remove
  /// this function definition from the module (because it isn't externally
  /// visible, does not have its address taken, and has no callers).  To make
  /// this more accurate, call removeDeadConstantUsers first.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::isDefTriviallyDead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1165,
   FQN="llvm::Function::isDefTriviallyDead", NM="_ZNK4llvm8Function18isDefTriviallyDeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function18isDefTriviallyDeadEv")
  //</editor-fold>
  public boolean isDefTriviallyDead() /*const*/ {
    // Check the linkage
    if (!hasLinkOnceLinkage() && !hasLocalLinkage()
       && !hasAvailableExternallyLinkage()) {
      return false;
    }
    
    // Check if the function is used by anything other than a blockaddress.
    for (/*const*/ User /*P*/ U : users$Const())  {
      if (!isa_BlockAddress(U)) {
        return false;
      }
    }
    
    return true;
  }


  
  /// callsFunctionThatReturnsTwice - Return true if the function has a call to
  /// setjmp or other function that gcc recognizes as "returning twice".
  
  /// callsFunctionThatReturnsTwice - Return true if the function has a call to
  /// setjmp or other function that gcc recognizes as "returning twice".
  
  /// callsFunctionThatReturnsTwice - Return true if the function has a call to
  /// setjmp or other function that gcc recognizes as "returning twice".
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::callsFunctionThatReturnsTwice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1181,
   FQN="llvm::Function::callsFunctionThatReturnsTwice", NM="_ZNK4llvm8Function29callsFunctionThatReturnsTwiceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm8Function29callsFunctionThatReturnsTwiceEv")
  //</editor-fold>
  public boolean callsFunctionThatReturnsTwice() /*const*/ {
    for (InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> I = inst_begin_Function$C$P(this), E = inst_end_Function$C$P(this); I.$noteq(E); I.$preInc()) {
      ImmutableCallSite CS/*J*/= new ImmutableCallSite($AddrOf(I.$star()));
      if (CS.$bool() && CS.hasFnAttr(Attribute.AttrKind.ReturnsTwice)) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief Set the attached subprogram.
  ///
  /// Calls \a setMetadata() with \a LLVMContext::MD_dbg.
  
  /// \brief Set the attached subprogram.
  ///
  /// Calls \a setMetadata() with \a LLVMContext::MD_dbg.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setSubprogram">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1449,
   FQN="llvm::Function::setSubprogram", NM="_ZN4llvm8Function13setSubprogramEPNS_12DISubprogramE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8Function13setSubprogramEPNS_12DISubprogramE")
  //</editor-fold>
  public void setSubprogram(DISubprogram /*P*/ SP) {
    setMetadata(LLVMContext.Unnamed_enum.MD_dbg.getValue(), SP);
  }


  
  /// \brief Get the attached subprogram.
  ///
  /// Calls \a getMetadata() with \a LLVMContext::MD_dbg and casts the result
  /// to \a DISubprogram.
  
  /// \brief Get the attached subprogram.
  ///
  /// Calls \a getMetadata() with \a LLVMContext::MD_dbg and casts the result
  /// to \a DISubprogram.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::getSubprogram">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1453,
   FQN="llvm::Function::getSubprogram", NM="_ZNK4llvm8Function13getSubprogramEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm8Function13getSubprogramEv")
  //</editor-fold>
  public DISubprogram /*P*/ getSubprogram() /*const*/ {
    return cast_or_null_DISubprogram(getMetadata(LLVMContext.Unnamed_enum.MD_dbg.getValue()));
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::allocHungoffUselist">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1222,
   FQN="llvm::Function::allocHungoffUselist", NM="_ZN4llvm8Function19allocHungoffUselistEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function19allocHungoffUselistEv")
  //</editor-fold>
  private void allocHungoffUselist() {
    // If we've already allocated a uselist, stop here.
    if ((getNumOperands() != 0)) {
      return;
    }
    
    allocHungoffUses(3, /*IsPhi=*/ false);
    setNumHungOffUseOperands(3);
    
    // Initialize the uselist with placeholder operands to allow traversal.
    ConstantPointerNull /*P*/ CPN = ConstantPointerNull.get(Type.getInt1PtrTy(getContext(), 0));
    this.Op(0).set(CPN);
    this.Op(1).set(CPN);
    this.Op(2).set(CPN);
  }


  /*template <int Idx> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setHungoffOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1238,
   FQN="llvm::Function::setHungoffOperand", NM="Tpl__ZN4llvm8Function17setHungoffOperandEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=Tpl__ZN4llvm8Function17setHungoffOperandEPNS_8ConstantE")
  //</editor-fold>
  private /*<int Idx>*/ void setHungoffOperand(int Idx, Constant /*P*/ C) {
    if ((C != null)) {
      allocHungoffUselist();
      Op/*<Idx>*/(Idx).set(C);
    } else if ((getNumOperands() != 0)) {
      Op/*<Idx>*/(Idx).set(ConstantPointerNull.get(Type.getInt1PtrTy(getContext(), 0)));
    }
  }

  
  // Shadow Value::setValueSubclassData with a private forwarding method so that
  // subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setValueSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Function.h", line = 649,
   FQN="llvm::Function::setValueSubclassData", NM="_ZN4llvm8Function20setValueSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Function20setValueSubclassDataEt")
  //</editor-fold>
  private void setValueSubclassData_Function(/*ushort*/char D) {
    super.setValueSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Function::setValueSubclassDataBit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1248,
   FQN="llvm::Function::setValueSubclassDataBit", NM="_ZN4llvm8Function23setValueSubclassDataBitEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm8Function23setValueSubclassDataBitEjb")
  //</editor-fold>
  private void setValueSubclassDataBit(/*uint*/int Bit, boolean On) {
    assert ($less_uint(Bit, 16)) : "SubclassData contains only 16 bits";
    if (On) {
      setValueSubclassData_Function($int2ushort($ushort2int(getSubclassDataFromValue()) | (1 << Bit)));
    } else {
      setValueSubclassData_Function($int2ushort($ushort2int(getSubclassDataFromValue()) & ~(1 << Bit)));
    }
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Iterator<BasicBlock> iterator() {
    return new JavaIterator<BasicBlock>(begin(), end());
  }
  
  private Function() {    
    this.ilist_node$Flds = $ilist_node();
    this.BasicBlocks = null;
    this.ArgumentList = null;
  }
  
  public static Function CreateSentinel() {
    return /*NEW_EXPR [User::new]*/User.$new_FixedUses(0, (type$ptr<?> New$Mem)-> new Function());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {
    if ($isSentinel()) {
      return "Sentinel " + this.getClass().getSimpleName();
    }
    return "" + "BasicBlocks=" + BasicBlocks // NOI18N
              + ", ArgumentList=" + ArgumentList // NOI18N
              + ", SymTab=" + SymTab // NOI18N
              + ", AttributeSets=" + AttributeSets // NOI18N
              + super.toString(); // NOI18N
  }
}
