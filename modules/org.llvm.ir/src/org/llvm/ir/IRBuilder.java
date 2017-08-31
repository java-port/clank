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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief This provides a uniform API for creating instructions and inserting
/// them into a basic block: either at the end of a BasicBlock, or at a specific
/// iterator location in a block.
///
/// Note that the builder does not expose the full generality of LLVM
/// instructions.  For access to extra instruction properties, use the mutators
/// (e.g. setVolatile) on the instructions after they have been
/// created. Convenience state exists to specify fast-math flags and fp-math
/// tags.
///
/// The first template argument specifies a class to use for creating constants.
/// This defaults to creating minimally folded constants.  The second template
/// argument allows clients to specify custom insertion hooks that are called on
/// every newly created insertion.
/*template <typename T = ConstantFolder, typename Inserter = IRBuilderDefaultInserter> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 564,
 FQN="llvm::IRBuilder", NM="_ZN4llvm9IRBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderE")
//</editor-fold>
public class IRBuilder</*typename*/ T extends IFolder<Constant, Constant>/* = ConstantFolder*/, /*typename*/ Inserter extends IRBuilderDefaultInserter/* = IRBuilderDefaultInserter*/>  extends /*public*/ IRBuilderBase implements IRBuilderDefaultInserter, Destructors.ClassWithDestructor, LLVMOpaqueBuilder {
  private T Folder;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::IRBuilder<T, Inserter>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 570,
   FQN="llvm::IRBuilder::IRBuilder<T, Inserter>", NM="_ZN4llvm9IRBuilderC1ERNS_11LLVMContextERKT_T0_PNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderC1ERNS_11LLVMContextERKT_T0_PNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public IRBuilder(JD$LLVMContext_T$C$R_T1_MDNode$P_ArrayRef$OperandBundleDefT$P _dparam, final LLVMContext /*&*/ C, final /*const*/ T /*&*/ F, ConstructorCallback<Inserter> $InserterCtor) {
    this(_dparam, C, F, /*new Inserter()*/$InserterCtor.$call(),
      (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(JD$LLVMContext_T$C$R_T1_MDNode$P_ArrayRef$OperandBundleDefT$P _dparam, final LLVMContext /*&*/ C, final /*const*/ T /*&*/ F, Inserter I/*= Inserter()*/) {
    this(_dparam, C, F, I,
      (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(JD$LLVMContext_T$C$R_T1_MDNode$P_ArrayRef$OperandBundleDefT$P _dparam, final LLVMContext /*&*/ C, final /*const*/ T /*&*/ F, Inserter I/*= Inserter()*/,
      MDNode /*P*/ FPMathTag/*= null*/) {
    this(_dparam, C, F, I,
      FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(JD$LLVMContext_T$C$R_T1_MDNode$P_ArrayRef$OperandBundleDefT$P _dparam, final LLVMContext /*&*/ C, final /*const*/ T /*&*/ F, Inserter I/*= Inserter()*/,
      MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : IRBuilderBase(C, FPMathTag, OpBundles), Inserter(std::move(I)), Folder(F)
    //START JInit
    /*ParenListExpr*/super(C, FPMathTag, OpBundles);
    ///*ParenListExpr*/super(std.move(I));
    // JAVA:Folder$CopyCtor/Folder$DefaultCtor:
    // the below Folder$CopyCtor and Folder$DefaultCtor initialization works only for default template params
    // Ideally, we should duplicate each constructor to allow clients that use default template params to stay unchanged
    // But there are 21 constructors in this class! So probably it's better to add only those ones we need?
    this.Folder = /*ParenListExpr*/(T) F.clone();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::IRBuilder<T, Inserter>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 576,
   FQN="llvm::IRBuilder::IRBuilder<T, Inserter>", NM="_ZN4llvm9IRBuilderC1ERNS_11LLVMContextEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderC1ERNS_11LLVMContextEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public /*explicit*/ IRBuilder(final LLVMContext /*&*/ C) {
    this(C,
      () -> (T) new ConstantFolder(), // ClassCastException here means you need to pass a ConstructorCallback
      (MDNode /*P*/ )null, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(final LLVMContext /*&*/ C, ConstructorCallback<T> Folder$DefaultCtor) {
    this(C, Folder$DefaultCtor, (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(final LLVMContext /*&*/ C, ConstructorCallback<T> Folder$DefaultCtor, MDNode /*P*/ FPMathTag/*= null*/) {
    this(C, Folder$DefaultCtor, FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(final LLVMContext /*&*/ C, ConstructorCallback<T> Folder$DefaultCtor, MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : IRBuilderBase(C, FPMathTag, OpBundles), Folder()
    //START JInit
    /*ParenListExpr*/super(C, FPMathTag, OpBundles);
    // JAVA: see "Folder$CopyCtor/Folder$DefaultCtor" comment above
    this.Folder = /*ParenListExpr*/Folder$DefaultCtor.$call();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::IRBuilder<T, Inserter>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 580,
   FQN="llvm::IRBuilder::IRBuilder<T, Inserter>", NM="_ZN4llvm9IRBuilderC1EPNS_10BasicBlockERKT_PNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderC1EPNS_10BasicBlockERKT_PNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public /*explicit*/ IRBuilder(BasicBlock /*P*/ TheBB, final /*const*/ T /*&*/ F) {
    this(TheBB, F, (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(BasicBlock /*P*/ TheBB, final /*const*/ T /*&*/ F, MDNode /*P*/ FPMathTag/*= null*/) {
    this(TheBB, F, FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(BasicBlock /*P*/ TheBB, final /*const*/ T /*&*/ F, MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : IRBuilderBase(TheBB->getContext(), FPMathTag, OpBundles), Folder(F)
    //START JInit
    /*ParenListExpr*/super(TheBB.getContext(), FPMathTag, OpBundles);
    // JAVA: see "Folder$CopyCtor/Folder$DefaultCtor" comment above
    this.Folder = /*ParenListExpr*/(T) F.clone();
    //END JInit
    SetInsertPoint(TheBB);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::IRBuilder<T, Inserter>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 586,
   FQN="llvm::IRBuilder::IRBuilder<T, Inserter>", NM="_ZN4llvm9IRBuilderC1EPNS_10BasicBlockEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderC1EPNS_10BasicBlockEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public /*explicit*/ IRBuilder(BasicBlock /*P*/ TheBB) {
    this(TheBB,
      () -> (T) new ConstantFolder(), // ClassCastException here means you need to pass a ConstructorCallback
      (MDNode /*P*/ )null, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(BasicBlock /*P*/ TheBB, ConstructorCallback<T> Folder$DefaultCtor) {
    this(TheBB, Folder$DefaultCtor, (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(BasicBlock /*P*/ TheBB, ConstructorCallback<T> Folder$DefaultCtor, MDNode /*P*/ FPMathTag/*= null*/) {
    this(TheBB, Folder$DefaultCtor, FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(BasicBlock /*P*/ TheBB, ConstructorCallback<T> Folder$DefaultCtor, MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : IRBuilderBase(TheBB->getContext(), FPMathTag, OpBundles), Folder()
    //START JInit
    /*ParenListExpr*/super(TheBB.getContext(), FPMathTag, OpBundles);
    // JAVA: see "Folder$CopyCtor/Folder$DefaultCtor" comment above
    this.Folder = /*ParenListExpr*/Folder$DefaultCtor.$call();
    //END JInit
    SetInsertPoint(TheBB);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::IRBuilder<T, Inserter>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 592,
   FQN="llvm::IRBuilder::IRBuilder<T, Inserter>", NM="_ZN4llvm9IRBuilderC1EPNS_11InstructionEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderC1EPNS_11InstructionEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public /*explicit*/ IRBuilder(Instruction /*P*/ IP) {
    this(IP,
      () -> (T) new ConstantFolder(), // ClassCastException here means you need to pass a ConstructorCallback
      (MDNode /*P*/ )null, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(Instruction /*P*/ IP, ConstructorCallback<T> Folder$DefaultCtor) {
    this(IP, Folder$DefaultCtor, (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(Instruction /*P*/ IP, ConstructorCallback<T> Folder$DefaultCtor, MDNode /*P*/ FPMathTag/*= null*/) {
    this(IP, Folder$DefaultCtor, FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public /*explicit*/ IRBuilder(Instruction /*P*/ IP, ConstructorCallback<T> Folder$DefaultCtor, MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : IRBuilderBase(IP->getContext(), FPMathTag, OpBundles), Folder()
    //START JInit
    /*ParenListExpr*/super(IP.getContext(), FPMathTag, OpBundles);
    // JAVA: see "Folder$CopyCtor/Folder$DefaultCtor" comment above
    this.Folder = /*ParenListExpr*/Folder$DefaultCtor.$call();;
    //END JInit
    SetInsertPoint(IP);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::IRBuilder<T, Inserter>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 598,
   FQN="llvm::IRBuilder::IRBuilder<T, Inserter>", NM="_ZN4llvm9IRBuilderC1EPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEERKT_PNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderC1EPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEERKT_PNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public IRBuilder(JD$BasicBlock$P_Ilist_iterator$Instruction_T$C$R_MDNode$P_ArrayRef$OperandBundleDefT$P _dparam, BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP, final /*const*/ T /*&*/ F) {
    this(_dparam, TheBB, IP, F,
      (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(JD$BasicBlock$P_Ilist_iterator$Instruction_T$C$R_MDNode$P_ArrayRef$OperandBundleDefT$P _dparam, BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP, final /*const*/ T /*&*/ F,
      MDNode /*P*/ FPMathTag/*= null*/) {
    this(_dparam, TheBB, IP, F,
      FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(JD$BasicBlock$P_Ilist_iterator$Instruction_T$C$R_MDNode$P_ArrayRef$OperandBundleDefT$P _dparam, BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP, final /*const*/ T /*&*/ F,
      MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : IRBuilderBase(TheBB->getContext(), FPMathTag, OpBundles), Folder(F)
    //START JInit
    /*ParenListExpr*/super(TheBB.getContext(), FPMathTag, OpBundles);
    // JAVA: see "Folder$CopyCtor/Folder$DefaultCtor" comment above
    this.Folder = /*ParenListExpr*/(T) F.clone();
    //END JInit
    SetInsertPoint(TheBB, IP);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::IRBuilder<T, Inserter>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 605,
   FQN="llvm::IRBuilder::IRBuilder<T, Inserter>", NM="_ZN4llvm9IRBuilderC1EPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilderC1EPNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEEPNS_6MDNodeENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public IRBuilder(BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP) {
    this(TheBB, IP,
      () -> (T) new ConstantFolder(), // ClassCastException here means you need to pass a ConstructorCallback
      (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP, ConstructorCallback<T> Folder$DefaultCtor) {
    this(TheBB, IP, Folder$DefaultCtor,
      (MDNode /*P*/ )null,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP, ConstructorCallback<T> Folder$DefaultCtor,
      MDNode /*P*/ FPMathTag/*= null*/) {
    this(TheBB, IP, Folder$DefaultCtor,
      FPMathTag,
      new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false));
  }
  public IRBuilder(BasicBlock /*P*/ TheBB, ilist_iterator<Instruction> IP, ConstructorCallback<T> Folder$DefaultCtor,
      MDNode /*P*/ FPMathTag/*= null*/,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles/*= None*/) {
    // : IRBuilderBase(TheBB->getContext(), FPMathTag, OpBundles), Folder()
    //START JInit
    /*ParenListExpr*/super(TheBB.getContext(), FPMathTag, OpBundles);
    // JAVA: see "Folder$CopyCtor/Folder$DefaultCtor" comment above
    this.Folder = /*ParenListExpr*/Folder$DefaultCtor.$call();
    //END JInit
    SetInsertPoint(TheBB, IP);
  }


  /// \brief Get the constant folder being used.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::getFolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 613,
   FQN="llvm::IRBuilder::getFolder", NM="_ZN4llvm9IRBuilder9getFolderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9getFolderEv")
  //</editor-fold>
  public /*const*/ T /*&*/ getFolder() {
    return Folder;
  }


  /// \brief Insert and return the specified instruction.
  /*template <typename InstTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::Insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 617,
   FQN="llvm::IRBuilder::Insert", NM="Tpl__ZNK4llvm9IRBuilder6InsertEPT_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=Tpl__ZNK4llvm9IRBuilder6InsertEPT_RKNS_5TwineE")
  //</editor-fold>
  public </*typename*/ InstTy extends Instruction> InstTy /*P*/ Insert$T(InstTy /*P*/ I) /*const*/ {
    return Insert$T(I, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public </*typename*/ InstTy extends Instruction> InstTy /*P*/ Insert$T(InstTy /*P*/ I, final /*const*/ Twine /*&*/ Name/*= ""*/) /*const*/ {
    this.InsertHelper(I, Name, BB, InsertPt);
    this.SetInstDebugLocation(I);
    return I;
  }


  /// \brief No-op overload to handle constants.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::Insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 624,
   FQN="llvm::IRBuilder::Insert", NM="_ZNK4llvm9IRBuilder6InsertEPNS_8ConstantERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZNK4llvm9IRBuilder6InsertEPNS_8ConstantERKNS_5TwineE")
  //</editor-fold>
  public Constant /*P*/ Insert(Constant /*P*/ C) /*const*/ {
    return Insert(C, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Constant /*P*/ Insert(Constant /*P*/ C, final /*const*/ Twine /*&*/ $Prm1/*= ""*/) /*const*/ {
    return C;
  }


  //===--------------------------------------------------------------------===//
  // Instruction creation methods: Terminators
  //===--------------------------------------------------------------------===//
  /*private:*/
  /// \brief Helper to add branch weight and unpredictable metadata onto an
  /// instruction.
  /// \returns The annotated instruction.
  /*template <typename InstTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::addBranchMetadata">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 637,
   FQN="llvm::IRBuilder::addBranchMetadata", NM="Tpl__ZN4llvm9IRBuilder17addBranchMetadataEPT_PNS_6MDNodeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=Tpl__ZN4llvm9IRBuilder17addBranchMetadataEPT_PNS_6MDNodeES4_")
  //</editor-fold>
  private </*typename*/ InstTy extends Instruction> InstTy /*P*/ addBranchMetadata(InstTy /*P*/ I, MDNode /*P*/ Weights, MDNode /*P*/ Unpredictable) {
    if ((Weights != null)) {
      I.setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(), Weights);
    }
    if ((Unpredictable != null)) {
      I.setMetadata(LLVMContext.Unnamed_enum.MD_unpredictable.getValue(), Unpredictable);
    }
    return I;
  }

/*public:*/
  /// \brief Create a 'ret void' instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateRetVoid">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 647,
   FQN="llvm::IRBuilder::CreateRetVoid", NM="_ZN4llvm9IRBuilder13CreateRetVoidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateRetVoidEv")
  //</editor-fold>
  public ReturnInst /*P*/ CreateRetVoid() {
    return Insert$T(ReturnInst.Create(Context));
  }


  /// \brief Create a 'ret <val>' instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateRet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 652,
   FQN="llvm::IRBuilder::CreateRet", NM="_ZN4llvm9IRBuilder9CreateRetEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateRetEPNS_5ValueE")
  //</editor-fold>
  public ReturnInst /*P*/ CreateRet(Value /*P*/ V) {
    return Insert$T(ReturnInst.Create(Context, V));
  }


  /// \brief Create a sequence of N insertvalue instructions,
  /// with one Value from the retVals array each, that build a aggregate
  /// return value one value at a time, and a ret instruction to return
  /// the resulting aggregate value.
  ///
  /// This is a convenience function for code that uses aggregate return values
  /// as a vehicle for having multiple return values.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAggregateRet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 663,
   FQN="llvm::IRBuilder::CreateAggregateRet", NM="_ZN4llvm9IRBuilder18CreateAggregateRetEPKPNS_5ValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateAggregateRetEPKPNS_5ValueEj")
  //</editor-fold>
  public ReturnInst /*P*/ CreateAggregateRet(type$ptr<Value /*P*/ /*const*/ /*P*/> retVals, /*uint*/int N) {
    Value /*P*/ V = UndefValue.get(getCurrentFunctionReturnType());
    for (/*uint*/int i = 0; i != N; ++i)  {
      V = CreateInsertValue(V, retVals.$at(i), new ArrayRefUInt(i), new Twine("mrv"));
    }
    return Insert$T(ReturnInst.Create(Context, V));
  }


  /// \brief Create an unconditional 'br label X' instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateBr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 671,
   FQN="llvm::IRBuilder::CreateBr", NM="_ZN4llvm9IRBuilder8CreateBrEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder8CreateBrEPNS_10BasicBlockE")
  //</editor-fold>
  public BranchInst /*P*/ CreateBr(BasicBlock /*P*/ Dest) {
    return Insert$T(BranchInst.Create(Dest));
  }


  /// \brief Create a conditional 'br Cond, TrueDest, FalseDest'
  /// instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCondBr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 677,
   FQN="llvm::IRBuilder::CreateCondBr", NM="_ZN4llvm9IRBuilder12CreateCondBrEPNS_5ValueEPNS_10BasicBlockES4_PNS_6MDNodeES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateCondBrEPNS_5ValueEPNS_10BasicBlockES4_PNS_6MDNodeES6_")
  //</editor-fold>
  public BranchInst /*P*/ CreateCondBr(Value /*P*/ Cond, BasicBlock /*P*/ True, BasicBlock /*P*/ False) {
    return CreateCondBr(Cond, True, False,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public BranchInst /*P*/ CreateCondBr(Value /*P*/ Cond, BasicBlock /*P*/ True, BasicBlock /*P*/ False,
              MDNode /*P*/ BranchWeights/*= null*/) {
    return CreateCondBr(Cond, True, False,
              BranchWeights,
              (MDNode /*P*/ )null);
  }
  public BranchInst /*P*/ CreateCondBr(Value /*P*/ Cond, BasicBlock /*P*/ True, BasicBlock /*P*/ False,
              MDNode /*P*/ BranchWeights/*= null*/,
              MDNode /*P*/ Unpredictable/*= null*/) {
    return Insert$T(addBranchMetadata(BranchInst.Create(True, False, Cond),
            BranchWeights, Unpredictable));
  }


  /// \brief Create a switch instruction with the specified value, default dest,
  /// and with a hint for the number of cases that will be added (for efficient
  /// allocation).
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSwitch">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 687,
   FQN="llvm::IRBuilder::CreateSwitch", NM="_ZN4llvm9IRBuilder12CreateSwitchEPNS_5ValueEPNS_10BasicBlockEjPNS_6MDNodeES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateSwitchEPNS_5ValueEPNS_10BasicBlockEjPNS_6MDNodeES6_")
  //</editor-fold>
  public SwitchInst /*P*/ CreateSwitch(Value /*P*/ V, BasicBlock /*P*/ Dest) {
    return CreateSwitch(V, Dest, 10,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public SwitchInst /*P*/ CreateSwitch(Value /*P*/ V, BasicBlock /*P*/ Dest, /*uint*/int NumCases/*= 10*/) {
    return CreateSwitch(V, Dest, NumCases,
              (MDNode /*P*/ )null,
              (MDNode /*P*/ )null);
  }
  public SwitchInst /*P*/ CreateSwitch(Value /*P*/ V, BasicBlock /*P*/ Dest, /*uint*/int NumCases/*= 10*/,
              MDNode /*P*/ BranchWeights/*= null*/) {
    return CreateSwitch(V, Dest, NumCases,
              BranchWeights,
              (MDNode /*P*/ )null);
  }
  public SwitchInst /*P*/ CreateSwitch(Value /*P*/ V, BasicBlock /*P*/ Dest, /*uint*/int NumCases/*= 10*/,
              MDNode /*P*/ BranchWeights/*= null*/,
              MDNode /*P*/ Unpredictable/*= null*/) {
    return Insert$T(addBranchMetadata(SwitchInst.Create(V, Dest, NumCases),
            BranchWeights, Unpredictable));
  }


  /// \brief Create an indirect branch instruction with the specified address
  /// operand, with an optional hint for the number of destinations that will be
  /// added (for efficient allocation).
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateIndirectBr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 697,
   FQN="llvm::IRBuilder::CreateIndirectBr", NM="_ZN4llvm9IRBuilder16CreateIndirectBrEPNS_5ValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder16CreateIndirectBrEPNS_5ValueEj")
  //</editor-fold>
  public IndirectBrInst /*P*/ CreateIndirectBr(Value /*P*/ Addr) {
    return CreateIndirectBr(Addr, 10);
  }
  public IndirectBrInst /*P*/ CreateIndirectBr(Value /*P*/ Addr, /*uint*/int NumDests/*= 10*/) {
    return Insert$T(IndirectBrInst.Create(Addr, NumDests));
  }


  /// \brief Create an invoke instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInvoke">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 702,
   FQN="llvm::IRBuilder::CreateInvoke", NM="_ZN4llvm9IRBuilder12CreateInvokeEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateInvokeEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EERKNS_5TwineE")
  //</editor-fold>
  public InvokeInst /*P*/ CreateInvoke(Value /*P*/ Callee, BasicBlock /*P*/ NormalDest,
              BasicBlock /*P*/ UnwindDest) {
    return CreateInvoke(Callee, NormalDest,
              UnwindDest,
              new ArrayRef<Value /*P*/ >(None, true),
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public InvokeInst /*P*/ CreateInvoke(Value /*P*/ Callee, BasicBlock /*P*/ NormalDest,
              BasicBlock /*P*/ UnwindDest,
              ArrayRef<Value /*P*/ > Args/*= None*/) {
    return CreateInvoke(Callee, NormalDest,
              UnwindDest,
              Args,
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public InvokeInst /*P*/ CreateInvoke(Value /*P*/ Callee, BasicBlock /*P*/ NormalDest,
              BasicBlock /*P*/ UnwindDest,
              ArrayRef<Value /*P*/ > Args/*= None*/,
              final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(InvokeInst.Create2(Callee, NormalDest, UnwindDest, new ArrayRef<Value /*P*/ >(Args)),
        Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInvoke">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 709,
   FQN="llvm::IRBuilder::CreateInvoke", NM="_ZN4llvm9IRBuilder12CreateInvokeEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateInvokeEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineE")
  //</editor-fold>
  public InvokeInst /*P*/ CreateInvoke(Value /*P*/ Callee, BasicBlock /*P*/ NormalDest,
              BasicBlock /*P*/ UnwindDest, ArrayRef<Value /*P*/ > Args,
              ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles) {
    return CreateInvoke(Callee, NormalDest,
              UnwindDest, Args,
              OpBundles,
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public InvokeInst /*P*/ CreateInvoke(Value /*P*/ Callee, BasicBlock /*P*/ NormalDest,
              BasicBlock /*P*/ UnwindDest, ArrayRef<Value /*P*/ > Args,
              ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles,
              final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(InvokeInst.Create2(Callee, NormalDest, UnwindDest, new ArrayRef<Value /*P*/ >(Args),
            new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpBundles)), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateResume">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 717,
   FQN="llvm::IRBuilder::CreateResume", NM="_ZN4llvm9IRBuilder12CreateResumeEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateResumeEPNS_5ValueE")
  //</editor-fold>
  public ResumeInst /*P*/ CreateResume(Value /*P*/ Exn) {
    return Insert$T(ResumeInst.Create(Exn));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCleanupRet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 721,
   FQN="llvm::IRBuilder::CreateCleanupRet", NM="_ZN4llvm9IRBuilder16CreateCleanupRetEPNS_14CleanupPadInstEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder16CreateCleanupRetEPNS_14CleanupPadInstEPNS_10BasicBlockE")
  //</editor-fold>
  public CleanupReturnInst /*P*/ CreateCleanupRet(CleanupPadInst /*P*/ CleanupPad) {
    return CreateCleanupRet(CleanupPad,
                  (BasicBlock /*P*/ )null);
  }
  public CleanupReturnInst /*P*/ CreateCleanupRet(CleanupPadInst /*P*/ CleanupPad,
                  BasicBlock /*P*/ UnwindBB/*= null*/) {
    return Insert$T(CleanupReturnInst.Create(CleanupPad, UnwindBB));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCatchSwitch">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 726,
   FQN="llvm::IRBuilder::CreateCatchSwitch", NM="_ZN4llvm9IRBuilder17CreateCatchSwitchEPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateCatchSwitchEPNS_5ValueEPNS_10BasicBlockEjRKNS_5TwineE")
  //</editor-fold>
  public CatchSwitchInst /*P*/ CreateCatchSwitch(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindBB,
                   /*uint*/int NumHandlers) {
    return CreateCatchSwitch(ParentPad, UnwindBB,
                   NumHandlers,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CatchSwitchInst /*P*/ CreateCatchSwitch(Value /*P*/ ParentPad, BasicBlock /*P*/ UnwindBB,
                   /*uint*/int NumHandlers,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(CatchSwitchInst.Create(ParentPad, UnwindBB, NumHandlers),
        Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCatchPad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 733,
   FQN="llvm::IRBuilder::CreateCatchPad", NM="_ZN4llvm9IRBuilder14CreateCatchPadEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder14CreateCatchPadEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE")
  //</editor-fold>
  public CatchPadInst /*P*/ CreateCatchPad(Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args) {
    return CreateCatchPad(ParentPad, Args,
                new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CatchPadInst /*P*/ CreateCatchPad(Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args,
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(CatchPadInst.Create_Value1(ParentPad, new ArrayRef<Value /*P*/ >(Args)), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCleanupPad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 738,
   FQN="llvm::IRBuilder::CreateCleanupPad", NM="_ZN4llvm9IRBuilder16CreateCleanupPadEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder16CreateCleanupPadEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE")
  //</editor-fold>
  public CleanupPadInst /*P*/ CreateCleanupPad(Value /*P*/ ParentPad) {
    return CreateCleanupPad(ParentPad,
                  new ArrayRef<Value /*P*/ >(None, true),
                  new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CleanupPadInst /*P*/ CreateCleanupPad(Value /*P*/ ParentPad,
                  ArrayRef<Value /*P*/ > Args/*= None*/) {
    return CreateCleanupPad(ParentPad,
                  Args,
                  new Twine(/*KEEP_STR*/$EMPTY));
  }
  public CleanupPadInst /*P*/ CreateCleanupPad(Value /*P*/ ParentPad,
                  ArrayRef<Value /*P*/ > Args/*= None*/,
                  final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(CleanupPadInst.Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(ParentPad, new ArrayRef<Value /*P*/ >(Args)), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCatchRet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 744,
   FQN="llvm::IRBuilder::CreateCatchRet", NM="_ZN4llvm9IRBuilder14CreateCatchRetEPNS_12CatchPadInstEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder14CreateCatchRetEPNS_12CatchPadInstEPNS_10BasicBlockE")
  //</editor-fold>
  public CatchReturnInst /*P*/ CreateCatchRet(CatchPadInst /*P*/ CatchPad, BasicBlock /*P*/ BB) {
    return Insert$T(CatchReturnInst.Create(CatchPad, BB));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateUnreachable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 748,
   FQN="llvm::IRBuilder::CreateUnreachable", NM="_ZN4llvm9IRBuilder17CreateUnreachableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateUnreachableEv")
  //</editor-fold>
  public UnreachableInst /*P*/ CreateUnreachable() {
    return Insert$T(/*NEW_EXPR [UnreachableInst::new]*//*FIXME 2: UnreachableInst.$new_UnreachableInst*/
        UnreachableInst.$new_UnreachableInst((type$ptr<?> New$Mem)->{
                return new UnreachableInst(( Context ));
    }));
  }


  //===--------------------------------------------------------------------===//
  // Instruction creation methods: Binary Operators
  //===--------------------------------------------------------------------===//
  /*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInsertNUWNSWBinOp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 756,
   FQN="llvm::IRBuilder::CreateInsertNUWNSWBinOp", NM="_ZN4llvm9IRBuilder23CreateInsertNUWNSWBinOpENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder23CreateInsertNUWNSWBinOpENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEbb")
  //</editor-fold>
  private BinaryOperator /*P*/ CreateInsertNUWNSWBinOp(/*BinaryOps*/int Opc,
                         Value /*P*/ LHS, Value /*P*/ RHS,
                         final /*const*/ Twine /*&*/ Name,
                         boolean HasNUW, boolean HasNSW) {
    BinaryOperator /*P*/ BO = Insert$T(BinaryOperator.Create(Opc, LHS, RHS), Name);
    if (HasNUW) {
      BO.setHasNoUnsignedWrap();
    }
    if (HasNSW) {
      BO.setHasNoSignedWrap();
    }
    return BO;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::AddFPMathAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 766,
   FQN="llvm::IRBuilder::AddFPMathAttributes", NM="_ZNK4llvm9IRBuilder19AddFPMathAttributesEPNS_11InstructionEPNS_6MDNodeENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZNK4llvm9IRBuilder19AddFPMathAttributesEPNS_11InstructionEPNS_6MDNodeENS_13FastMathFlagsE")
  //</editor-fold>
  private Instruction /*P*/ AddFPMathAttributes(Instruction /*P*/ I,
                     MDNode /*P*/ FPMathTag,
                     FastMathFlags FMF) /*const*/ {
    if (!(FPMathTag != null)) {
      FPMathTag = DefaultFPMathTag;
    }
    if ((FPMathTag != null)) {
      I.setMetadata(LLVMContext.Unnamed_enum.MD_fpmath.getValue(), FPMathTag);
    }
    I.setFastMathFlags(new FastMathFlags(FMF));
    return I;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 778,
   FQN="llvm::IRBuilder::CreateAdd", NM="_ZN4llvm9IRBuilder9CreateAddEPNS_5ValueES2_RKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateAddEPNS_5ValueES2_RKNS_5TwineEbb")
  //</editor-fold>
  public Value /*P*/ CreateAdd(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateAdd(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
           false, false);
  }
  public Value /*P*/ CreateAdd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAdd(LHS, RHS, Name,
           false, false);
  }
  public Value /*P*/ CreateAdd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/) {
    return CreateAdd(LHS, RHS, Name,
           HasNUW, false);
  }
  public Value /*P*/ CreateAdd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateAdd(LC, RC, HasNUW, HasNSW), Name);
          }
        }
      }
    }
    return CreateInsertNUWNSWBinOp(Instruction.BinaryOps.Add, LHS, RHS, Name,
        HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNSWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 786,
   FQN="llvm::IRBuilder::CreateNSWAdd", NM="_ZN4llvm9IRBuilder12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNSWAddEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNSWAdd(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateNSWAdd(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNSWAdd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAdd(LHS, RHS, Name, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNUWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 789,
   FQN="llvm::IRBuilder::CreateNUWAdd", NM="_ZN4llvm9IRBuilder12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNUWAddEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNUWAdd(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateNUWAdd(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNUWAdd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAdd(LHS, RHS, Name, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFAdd">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 792,
   FQN="llvm::IRBuilder::CreateFAdd", NM="_ZN4llvm9IRBuilder10CreateFAddEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateFAddEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFAdd(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFAdd(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFAdd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFAdd(LHS, RHS, Name,
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFAdd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateAdd(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(AddFPMathAttributes(BinaryOperator.CreateFAdd(LHS, RHS),
            FPMathTag, FMF), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 800,
   FQN="llvm::IRBuilder::CreateSub", NM="_ZN4llvm9IRBuilder9CreateSubEPNS_5ValueES2_RKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateSubEPNS_5ValueES2_RKNS_5TwineEbb")
  //</editor-fold>
  public Value /*P*/ CreateSub(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateSub(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
           false, false);
  }
  public Value /*P*/ CreateSub(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateSub(LHS, RHS, Name,
           false, false);
  }
  public Value /*P*/ CreateSub(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/) {
    return CreateSub(LHS, RHS, Name,
           HasNUW, false);
  }
  public Value /*P*/ CreateSub(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateSub(LC, RC, HasNUW, HasNSW), Name);
          }
        }
      }
    }
    return CreateInsertNUWNSWBinOp(Instruction.BinaryOps.Sub, LHS, RHS, Name,
        HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNSWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 808,
   FQN="llvm::IRBuilder::CreateNSWSub", NM="_ZN4llvm9IRBuilder12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNSWSubEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNSWSub(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateNSWSub(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNSWSub(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateSub(LHS, RHS, Name, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNUWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 811,
   FQN="llvm::IRBuilder::CreateNUWSub", NM="_ZN4llvm9IRBuilder12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNUWSubEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNUWSub(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateNUWSub(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNUWSub(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateSub(LHS, RHS, Name, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFSub">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 814,
   FQN="llvm::IRBuilder::CreateFSub", NM="_ZN4llvm9IRBuilder10CreateFSubEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateFSubEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFSub(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFSub(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFSub(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFSub(LHS, RHS, Name,
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFSub(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateFSub(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(AddFPMathAttributes(BinaryOperator.CreateFSub(LHS, RHS),
            FPMathTag, FMF), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 822,
   FQN="llvm::IRBuilder::CreateMul", NM="_ZN4llvm9IRBuilder9CreateMulEPNS_5ValueES2_RKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateMulEPNS_5ValueES2_RKNS_5TwineEbb")
  //</editor-fold>
  public Value /*P*/ CreateMul(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateMul(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
           false, false);
  }
  public Value /*P*/ CreateMul(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateMul(LHS, RHS, Name,
           false, false);
  }
  public Value /*P*/ CreateMul(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/) {
    return CreateMul(LHS, RHS, Name,
           HasNUW, false);
  }
  public Value /*P*/ CreateMul(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateMul(LC, RC, HasNUW, HasNSW), Name);
          }
        }
      }
    }
    return CreateInsertNUWNSWBinOp(Instruction.BinaryOps.Mul, LHS, RHS, Name,
        HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNSWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 830,
   FQN="llvm::IRBuilder::CreateNSWMul", NM="_ZN4llvm9IRBuilder12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNSWMulEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNSWMul(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateNSWMul(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNSWMul(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateMul(LHS, RHS, Name, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNUWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 833,
   FQN="llvm::IRBuilder::CreateNUWMul", NM="_ZN4llvm9IRBuilder12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNUWMulEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNUWMul(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateNUWMul(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNUWMul(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateMul(LHS, RHS, Name, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFMul">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 836,
   FQN="llvm::IRBuilder::CreateFMul", NM="_ZN4llvm9IRBuilder10CreateFMulEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateFMulEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFMul(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFMul(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFMul(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFMul(LHS, RHS, Name,
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFMul(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateFMul(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(AddFPMathAttributes(BinaryOperator.CreateFMul(LHS, RHS),
            FPMathTag, FMF), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateUDiv">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 844,
   FQN="llvm::IRBuilder::CreateUDiv", NM="_ZN4llvm9IRBuilder10CreateUDivEPNS_5ValueES2_RKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateUDivEPNS_5ValueES2_RKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateUDiv(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateUDiv(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateUDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateUDiv(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateUDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateUDiv(LC, RC, isExact), Name);
          }
        }
      }
    }
    if (!isExact) {
      return Insert$T(BinaryOperator.CreateUDiv(LHS, RHS), Name);
    }
    return Insert$T(BinaryOperator.CreateExactUDiv(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateExactUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 853,
   FQN="llvm::IRBuilder::CreateExactUDiv", NM="_ZN4llvm9IRBuilder15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder15CreateExactUDivEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateExactUDiv(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateExactUDiv(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateExactUDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateUDiv(LHS, RHS, Name, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSDiv">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 856,
   FQN="llvm::IRBuilder::CreateSDiv", NM="_ZN4llvm9IRBuilder10CreateSDivEPNS_5ValueES2_RKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateSDivEPNS_5ValueES2_RKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateSDiv(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateSDiv(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateSDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateSDiv(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateSDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateSDiv(LC, RC, isExact), Name);
          }
        }
      }
    }
    if (!isExact) {
      return Insert$T(BinaryOperator.CreateSDiv(LHS, RHS), Name);
    }
    return Insert$T(BinaryOperator.CreateExactSDiv(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateExactSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 865,
   FQN="llvm::IRBuilder::CreateExactSDiv", NM="_ZN4llvm9IRBuilder15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder15CreateExactSDivEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateExactSDiv(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateExactSDiv(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateExactSDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateSDiv(LHS, RHS, Name, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFDiv">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 868,
   FQN="llvm::IRBuilder::CreateFDiv", NM="_ZN4llvm9IRBuilder10CreateFDivEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateFDivEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFDiv(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFDiv(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFDiv(LHS, RHS, Name,
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFDiv(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateFDiv(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(AddFPMathAttributes(BinaryOperator.CreateFDiv(LHS, RHS),
            FPMathTag, FMF), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateURem">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 876,
   FQN="llvm::IRBuilder::CreateURem", NM="_ZN4llvm9IRBuilder10CreateURemEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateURemEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateURem(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateURem(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateURem(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateURem(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(BinaryOperator.CreateURem(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSRem">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 882,
   FQN="llvm::IRBuilder::CreateSRem", NM="_ZN4llvm9IRBuilder10CreateSRemEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateSRemEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateSRem(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateSRem(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateSRem(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateSRem(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(BinaryOperator.CreateSRem(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFRem">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 888,
   FQN="llvm::IRBuilder::CreateFRem", NM="_ZN4llvm9IRBuilder10CreateFRemEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateFRemEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFRem(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFRem(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFRem(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFRem(LHS, RHS, Name,
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFRem(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateFRem(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(AddFPMathAttributes(BinaryOperator.CreateFRem(LHS, RHS),
            FPMathTag, FMF), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 897,
   FQN="llvm::IRBuilder::CreateShl", NM="_ZN4llvm9IRBuilder9CreateShlEPNS_5ValueES2_RKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateShlEPNS_5ValueES2_RKNS_5TwineEbb")
  //</editor-fold>
  public Value /*P*/ CreateShl(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateShl(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
           false, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateShl(LHS, RHS, Name,
           false, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/) {
    return CreateShl(LHS, RHS, Name,
           HasNUW, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateShl(LC, RC, HasNUW, HasNSW), Name);
          }
        }
      }
    }
    return CreateInsertNUWNSWBinOp(Instruction.BinaryOps.Shl, LHS, RHS, Name,
        HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 905,
   FQN="llvm::IRBuilder::CreateShl", NM="_ZN4llvm9IRBuilder9CreateShlEPNS_5ValueERKNS_5APIntERKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateShlEPNS_5ValueERKNS_5APIntERKNS_5TwineEbb")
  //</editor-fold>
  public Value /*P*/ CreateShl(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS) {
    return CreateShl(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
           false, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateShl(LHS, RHS, Name,
           false, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/) {
    return CreateShl(LHS, RHS, Name,
           HasNUW, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    return CreateShl(LHS, ConstantInt.get(LHS.getType(), RHS), Name,
        HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 910,
   FQN="llvm::IRBuilder::CreateShl", NM="_ZN4llvm9IRBuilder9CreateShlEPNS_5ValueEyRKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateShlEPNS_5ValueEyRKNS_5TwineEbb")
  //</editor-fold>
  public Value /*P*/ CreateShl(Value /*P*/ LHS, long/*uint64_t*/ RHS) {
    return CreateShl(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
           false, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateShl(LHS, RHS, Name,
           false, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/) {
    return CreateShl(LHS, RHS, Name,
           HasNUW, false);
  }
  public Value /*P*/ CreateShl(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    return CreateShl(LHS, ConstantInt.get(LHS.getType(), RHS), Name,
        HasNUW, HasNSW);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLShr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 916,
   FQN="llvm::IRBuilder::CreateLShr", NM="_ZN4llvm9IRBuilder10CreateLShrEPNS_5ValueES2_RKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateLShrEPNS_5ValueES2_RKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateLShr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateLShr(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateLShr(LC, RC, isExact), Name);
          }
        }
      }
    }
    if (!isExact) {
      return Insert$T(BinaryOperator.CreateLShr(LHS, RHS), Name);
    }
    return Insert$T(BinaryOperator.CreateExactLShr(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 925,
   FQN="llvm::IRBuilder::CreateLShr", NM="_ZN4llvm9IRBuilder10CreateLShrEPNS_5ValueERKNS_5APIntERKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateLShrEPNS_5ValueERKNS_5APIntERKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS) {
    return CreateLShr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateLShr(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    return CreateLShr(LHS, ConstantInt.get(LHS.getType(), RHS), Name, isExact);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 929,
   FQN="llvm::IRBuilder::CreateLShr", NM="_ZN4llvm9IRBuilder10CreateLShrEPNS_5ValueEyRKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateLShrEPNS_5ValueEyRKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, long/*uint64_t*/ RHS) {
    return CreateLShr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateLShr(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateLShr(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    return CreateLShr(LHS, ConstantInt.get(LHS.getType(), RHS), Name, isExact);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAShr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 934,
   FQN="llvm::IRBuilder::CreateAShr", NM="_ZN4llvm9IRBuilder10CreateAShrEPNS_5ValueES2_RKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateAShrEPNS_5ValueES2_RKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateAShr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAShr(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateAShr(LC, RC, isExact), Name);
          }
        }
      }
    }
    if (!isExact) {
      return Insert$T(BinaryOperator.CreateAShr(LHS, RHS), Name);
    }
    return Insert$T(BinaryOperator.CreateExactAShr(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 943,
   FQN="llvm::IRBuilder::CreateAShr", NM="_ZN4llvm9IRBuilder10CreateAShrEPNS_5ValueERKNS_5APIntERKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateAShrEPNS_5ValueERKNS_5APIntERKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS) {
    return CreateAShr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAShr(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    return CreateAShr(LHS, ConstantInt.get(LHS.getType(), RHS), Name, isExact);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 947,
   FQN="llvm::IRBuilder::CreateAShr", NM="_ZN4llvm9IRBuilder10CreateAShrEPNS_5ValueEyRKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateAShrEPNS_5ValueEyRKNS_5TwineEb")
  //</editor-fold>
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, long/*uint64_t*/ RHS) {
    return CreateAShr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
            false);
  }
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAShr(LHS, RHS, Name,
            false);
  }
  public Value /*P*/ CreateAShr(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
            boolean isExact/*= false*/) {
    return CreateAShr(LHS, ConstantInt.get(LHS.getType(), RHS), Name, isExact);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAnd">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 952,
   FQN="llvm::IRBuilder::CreateAnd", NM="_ZN4llvm9IRBuilder9CreateAndEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateAndEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateAnd(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateAnd(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateAnd(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ RC = dyn_cast_Constant(RHS);
      if ((RC != null)) {
        if (isa_ConstantInt(RC) && cast_ConstantInt(RC).isAllOnesValue()) {
          return LHS; // LHS & -1 -> LHS
        }
        {
          Constant /*P*/ LC = dyn_cast_Constant(LHS);
          if ((LC != null)) {
            return Insert(Folder.CreateAnd(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(BinaryOperator.CreateAnd(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 961,
   FQN="llvm::IRBuilder::CreateAnd", NM="_ZN4llvm9IRBuilder9CreateAndEPNS_5ValueERKNS_5APIntERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateAndEPNS_5ValueERKNS_5APIntERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateAnd(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS) {
    return CreateAnd(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateAnd(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAnd(LHS, ConstantInt.get(LHS.getType(), RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 964,
   FQN="llvm::IRBuilder::CreateAnd", NM="_ZN4llvm9IRBuilder9CreateAndEPNS_5ValueEyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateAndEPNS_5ValueEyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateAnd(Value /*P*/ LHS, long/*uint64_t*/ RHS) {
    return CreateAnd(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateAnd(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAnd(LHS, ConstantInt.get(LHS.getType(), RHS), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateOr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 968,
   FQN="llvm::IRBuilder::CreateOr", NM="_ZN4llvm9IRBuilder8CreateOrEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder8CreateOrEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateOr(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateOr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateOr(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ RC = dyn_cast_Constant(RHS);
      if ((RC != null)) {
        if (RC.isNullValue()) {
          return LHS; // LHS | 0 -> LHS
        }
        {
          Constant /*P*/ LC = dyn_cast_Constant(LHS);
          if ((LC != null)) {
            return Insert(Folder.CreateOr(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(BinaryOperator.CreateOr(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 977,
   FQN="llvm::IRBuilder::CreateOr", NM="_ZN4llvm9IRBuilder8CreateOrEPNS_5ValueERKNS_5APIntERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder8CreateOrEPNS_5ValueERKNS_5APIntERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateOr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS) {
    return CreateOr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateOr(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateOr(LHS, ConstantInt.get(LHS.getType(), RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 980,
   FQN="llvm::IRBuilder::CreateOr", NM="_ZN4llvm9IRBuilder8CreateOrEPNS_5ValueEyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder8CreateOrEPNS_5ValueEyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateOr(Value /*P*/ LHS, long/*uint64_t*/ RHS) {
    return CreateOr(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateOr(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateOr(LHS, ConstantInt.get(LHS.getType(), RHS), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateXor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 984,
   FQN="llvm::IRBuilder::CreateXor", NM="_ZN4llvm9IRBuilder9CreateXorEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateXorEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateXor(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateXor(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateXor(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateXor(LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(BinaryOperator.CreateXor(LHS, RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 990,
   FQN="llvm::IRBuilder::CreateXor", NM="_ZN4llvm9IRBuilder9CreateXorEPNS_5ValueERKNS_5APIntERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateXorEPNS_5ValueERKNS_5APIntERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateXor(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS) {
    return CreateXor(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateXor(Value /*P*/ LHS, final /*const*/ APInt /*&*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateXor(LHS, ConstantInt.get(LHS.getType(), RHS), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 993,
   FQN="llvm::IRBuilder::CreateXor", NM="_ZN4llvm9IRBuilder9CreateXorEPNS_5ValueEyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateXorEPNS_5ValueEyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateXor(Value /*P*/ LHS, long/*uint64_t*/ RHS) {
    return CreateXor(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateXor(Value /*P*/ LHS, long/*uint64_t*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateXor(LHS, ConstantInt.get(LHS.getType(), RHS), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateBinOp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 997,
   FQN="llvm::IRBuilder::CreateBinOp", NM="_ZN4llvm9IRBuilder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_5ValueES4_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateBinOp(/*BinaryOps*/int Opc,
             Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateBinOp(Opc,
             LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
             (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateBinOp(/*BinaryOps*/int Opc,
             Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateBinOp(Opc,
             LHS, RHS, Name,
             (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateBinOp(/*BinaryOps*/int Opc,
             Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
             MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateBinOp(Opc, LC, RC), Name);
          }
        }
      }
    }
    Instruction /*P*/ BinOp = BinaryOperator.Create(Opc, LHS, RHS);
    if (isa_FPMathOperator(BinOp)) {
      BinOp = AddFPMathAttributes(BinOp, FPMathTag, FMF);
    }
    return Insert$T(BinOp, Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNeg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1009,
   FQN="llvm::IRBuilder::CreateNeg", NM="_ZN4llvm9IRBuilder9CreateNegEPNS_5ValueERKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateNegEPNS_5ValueERKNS_5TwineEbb")
  //</editor-fold>
  public Value /*P*/ CreateNeg(Value /*P*/ V) {
    return CreateNeg(V, new Twine(/*KEEP_STR*/$EMPTY),
           false, false);
  }
  public Value /*P*/ CreateNeg(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateNeg(V, Name,
           false, false);
  }
  public Value /*P*/ CreateNeg(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/) {
    return CreateNeg(V, Name,
           HasNUW, false);
  }
  public Value /*P*/ CreateNeg(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) {
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateNeg(VC, HasNUW, HasNSW), Name);
      }
    }
    BinaryOperator /*P*/ BO = Insert$T(BinaryOperator.CreateNeg(V), Name);
    if (HasNUW) {
      BO.setHasNoUnsignedWrap();
    }
    if (HasNSW) {
      BO.setHasNoSignedWrap();
    }
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNSWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1018,
   FQN="llvm::IRBuilder::CreateNSWNeg", NM="_ZN4llvm9IRBuilder12CreateNSWNegEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNSWNegEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNSWNeg(Value /*P*/ V) {
    return CreateNSWNeg(V, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNSWNeg(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateNeg(V, Name, false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNUWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1021,
   FQN="llvm::IRBuilder::CreateNUWNeg", NM="_ZN4llvm9IRBuilder12CreateNUWNegEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateNUWNegEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNUWNeg(Value /*P*/ V) {
    return CreateNUWNeg(V, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNUWNeg(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateNeg(V, Name, true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFNeg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1024,
   FQN="llvm::IRBuilder::CreateFNeg", NM="_ZN4llvm9IRBuilder10CreateFNegEPNS_5ValueERKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateFNegEPNS_5ValueERKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFNeg(Value /*P*/ V) {
    return CreateFNeg(V, new Twine(/*KEEP_STR*/$EMPTY),
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFNeg(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFNeg(V, Name,
            (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFNeg(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/,
            MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateFNeg(VC), Name);
      }
    }
    return Insert$T(AddFPMathAttributes(BinaryOperator.CreateFNeg(V),
            FPMathTag, FMF), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateNot">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1031,
   FQN="llvm::IRBuilder::CreateNot", NM="_ZN4llvm9IRBuilder9CreateNotEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateNotEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateNot(Value /*P*/ V) {
    return CreateNot(V, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateNot(Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateNot(VC), Name);
      }
    }
    return Insert$T(BinaryOperator.CreateNot(V), Name);
  }


  //===--------------------------------------------------------------------===//
  // Instruction creation methods: Memory Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAlloca">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1041,
   FQN="llvm::IRBuilder::CreateAlloca", NM="_ZN4llvm9IRBuilder12CreateAllocaEPNS_4TypeEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateAllocaEPNS_4TypeEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public AllocaInst /*P*/ CreateAlloca(Type /*P*/ Ty) {
    return CreateAlloca(Ty, (Value /*P*/ )null,
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public AllocaInst /*P*/ CreateAlloca(Type /*P*/ Ty, Value /*P*/ ArraySize/*= null*/) {
    return CreateAlloca(Ty, ArraySize,
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public AllocaInst /*P*/ CreateAlloca(Type /*P*/ Ty, Value /*P*/ ArraySize/*= null*/,
              final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
            return new AllocaInst(Ty, ArraySize);
         }), Name);
  }

  // \brief Provided to resolve 'CreateLoad(Ptr, "...")' correctly, instead of
  // converting the string to 'bool' for the isVolatile parameter.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLoad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1047,
   FQN="llvm::IRBuilder::CreateLoad", NM="_ZN4llvm9IRBuilder10CreateLoadEPNS_5ValueEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateLoadEPNS_5ValueEPKc")
  //</editor-fold>
  public LoadInst /*P*/ CreateLoad(Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ Name) {
    return Insert$T(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
            return new LoadInst(Ptr);
         }), new Twine(Name));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLoad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1050,
   FQN="llvm::IRBuilder::CreateLoad", NM="_ZN4llvm9IRBuilder10CreateLoadEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateLoadEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateLoad(Value /*P*/ Ptr) {
    return CreateLoad(Ptr, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateLoad(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
            return new LoadInst(Ptr);
         }), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLoad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1053,
   FQN="llvm::IRBuilder::CreateLoad", NM="_ZN4llvm9IRBuilder10CreateLoadEPNS_4TypeEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateLoadEPNS_4TypeEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateLoad(Type /*P*/ Ty, Value /*P*/ Ptr) {
    return CreateLoad(Ty, Ptr, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateLoad(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
            return new LoadInst(Ty, Ptr);
         }), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLoad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1056,
   FQN="llvm::IRBuilder::CreateLoad", NM="_ZN4llvm9IRBuilder10CreateLoadEPNS_5ValueEbRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateLoadEPNS_5ValueEbRKNS_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateLoad(Value /*P*/ Ptr, boolean isVolatile) {
    return CreateLoad(Ptr, isVolatile, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateLoad(Value /*P*/ Ptr, boolean isVolatile, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
            return new LoadInst(Ptr, (/*const*/char$ptr/*char P*/ )null, isVolatile);
         }), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateStore">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1059,
   FQN="llvm::IRBuilder::CreateStore", NM="_ZN4llvm9IRBuilder11CreateStoreEPNS_5ValueES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder11CreateStoreEPNS_5ValueES2_b")
  //</editor-fold>
  public StoreInst /*P*/ CreateStore(Value /*P*/ Val, Value /*P*/ Ptr) {
    return CreateStore(Val, Ptr, false);
  }
  public StoreInst /*P*/ CreateStore(Value /*P*/ Val, Value /*P*/ Ptr, boolean isVolatile/*= false*/) {
    return Insert$T(/*NEW_EXPR [StoreInst::new]*/StoreInst.$new_StoreInst((type$ptr<?> New$Mem)->{
            return new StoreInst(Val, Ptr, isVolatile);
         }));
  }

  // \brief Provided to resolve 'CreateAlignedLoad(Ptr, Align, "...")'
  // correctly, instead of converting the string to 'bool' for the isVolatile
  // parameter.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1065,
   FQN="llvm::IRBuilder::CreateAlignedLoad", NM="_ZN4llvm9IRBuilder17CreateAlignedLoadEPNS_5ValueEjPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateAlignedLoadEPNS_5ValueEjPKc")
  //</editor-fold>
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Ptr, /*uint*/int Align, /*const*/char$ptr/*char P*/ Name) {
    LoadInst /*P*/ LI = CreateLoad(Ptr, Name);
    LI.setAlignment(Align);
    return LI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1070,
   FQN="llvm::IRBuilder::CreateAlignedLoad", NM="_ZN4llvm9IRBuilder17CreateAlignedLoadEPNS_5ValueEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateAlignedLoadEPNS_5ValueEjRKNS_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Ptr, /*uint*/int Align) {
    return CreateAlignedLoad(Ptr, Align,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Ptr, /*uint*/int Align,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    LoadInst /*P*/ LI = CreateLoad(Ptr, Name);
    LI.setAlignment(Align);
    return LI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1076,
   FQN="llvm::IRBuilder::CreateAlignedLoad", NM="_ZN4llvm9IRBuilder17CreateAlignedLoadEPNS_5ValueEjbRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateAlignedLoadEPNS_5ValueEjbRKNS_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Ptr, /*uint*/int Align, boolean isVolatile) {
    return CreateAlignedLoad(Ptr, Align, isVolatile,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Ptr, /*uint*/int Align, boolean isVolatile,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    LoadInst /*P*/ LI = CreateLoad(Ptr, isVolatile, Name);
    LI.setAlignment(Align);
    return LI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAlignedStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1082,
   FQN="llvm::IRBuilder::CreateAlignedStore", NM="_ZN4llvm9IRBuilder18CreateAlignedStoreEPNS_5ValueES2_jb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateAlignedStoreEPNS_5ValueES2_jb")
  //</editor-fold>
  public StoreInst /*P*/ CreateAlignedStore(Value /*P*/ Val, Value /*P*/ Ptr, /*uint*/int Align) {
    return CreateAlignedStore(Val, Ptr, Align,
                    false);
  }
  public StoreInst /*P*/ CreateAlignedStore(Value /*P*/ Val, Value /*P*/ Ptr, /*uint*/int Align,
                    boolean isVolatile/*= false*/) {
    StoreInst /*P*/ SI = CreateStore(Val, Ptr, isVolatile);
    SI.setAlignment(Align);
    return SI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFence">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1088,
   FQN="llvm::IRBuilder::CreateFence", NM="_ZN4llvm9IRBuilder11CreateFenceENS_14AtomicOrderingENS_20SynchronizationScopeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder11CreateFenceENS_14AtomicOrderingENS_20SynchronizationScopeERKNS_5TwineE")
  //</editor-fold>
  public FenceInst /*P*/ CreateFence(AtomicOrdering Ordering) {
    return CreateFence(Ordering,
             SynchronizationScope.CrossThread,
             new Twine(/*KEEP_STR*/$EMPTY));
  }
  public FenceInst /*P*/ CreateFence(AtomicOrdering Ordering,
             SynchronizationScope SynchScope/*= CrossThread*/) {
    return CreateFence(Ordering,
             SynchScope,
             new Twine(/*KEEP_STR*/$EMPTY));
  }
  public FenceInst /*P*/ CreateFence(AtomicOrdering Ordering,
             SynchronizationScope SynchScope/*= CrossThread*/,
             final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(/*NEW_EXPR [FenceInst::new]*//*FIXME 2: FenceInst.$new_FenceInst*/
            FenceInst.$new_FenceInst((type$ptr<?> New$Mem)->{
              return new FenceInst(Context, Ordering, SynchScope);
            }), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAtomicCmpXchg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1093,
   FQN="llvm::IRBuilder::CreateAtomicCmpXchg", NM="_ZN4llvm9IRBuilder19CreateAtomicCmpXchgEPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateAtomicCmpXchgEPNS_5ValueES2_S2_NS_14AtomicOrderingES3_NS_20SynchronizationScopeE")
  //</editor-fold>
  public AtomicCmpXchgInst /*P*/ CreateAtomicCmpXchg(Value /*P*/ Ptr, Value /*P*/ Cmp, Value /*P*/ New,
                     AtomicOrdering SuccessOrdering,
                     AtomicOrdering FailureOrdering) {
    return CreateAtomicCmpXchg(Ptr, Cmp, New,
                     SuccessOrdering,
                     FailureOrdering,
                     SynchronizationScope.CrossThread);
  }
  public AtomicCmpXchgInst /*P*/ CreateAtomicCmpXchg(Value /*P*/ Ptr, Value /*P*/ Cmp, Value /*P*/ New,
                     AtomicOrdering SuccessOrdering,
                     AtomicOrdering FailureOrdering,
                     SynchronizationScope SynchScope/*= CrossThread*/) {
    return Insert$T(/*NEW_EXPR [AtomicCmpXchgInst::new]*/AtomicCmpXchgInst.$new_AtomicCmpXchgInst((type$ptr<?> New$Mem)->{
            return new AtomicCmpXchgInst(Ptr, Cmp, New, SuccessOrdering,
                    FailureOrdering, SynchScope);
         }));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAtomicRMW">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1101,
   FQN="llvm::IRBuilder::CreateAtomicRMW", NM="_ZN4llvm9IRBuilder15CreateAtomicRMWENS_13AtomicRMWInst5BinOpEPNS_5ValueES4_NS_14AtomicOrderingENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder15CreateAtomicRMWENS_13AtomicRMWInst5BinOpEPNS_5ValueES4_NS_14AtomicOrderingENS_20SynchronizationScopeE")
  //</editor-fold>
  public AtomicRMWInst /*P*/ CreateAtomicRMW(AtomicRMWInst.BinOp Op, Value /*P*/ Ptr, Value /*P*/ Val,
                 AtomicOrdering Ordering) {
    return CreateAtomicRMW(Op, Ptr, Val,
                 Ordering,
                 SynchronizationScope.CrossThread);
  }
  public AtomicRMWInst /*P*/ CreateAtomicRMW(AtomicRMWInst.BinOp Op, Value /*P*/ Ptr, Value /*P*/ Val,
                 AtomicOrdering Ordering,
                 SynchronizationScope SynchScope/*= CrossThread*/) {
    return Insert$T(/*NEW_EXPR [AtomicRMWInst::new]*/AtomicRMWInst.$new_AtomicRMWInst((type$ptr<?> New$Mem)->{
            return new AtomicRMWInst(Op, Ptr, Val, Ordering, SynchScope);
         }));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1106,
   FQN="llvm::IRBuilder::CreateGEP", NM="_ZN4llvm9IRBuilder9CreateGEPEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateGEPEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateGEP(Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList) {
    return CreateGEP(Ptr, IdxList,
           new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateGEP(Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList,
           final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateGEP(null, Ptr, IdxList, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1110,
   FQN="llvm::IRBuilder::CreateGEP", NM="_ZN4llvm9IRBuilder9CreateGEPEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateGEPEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateGEP(Type /*P*/ Ty, Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList) {
    return CreateGEP(Ty, Ptr, IdxList,
           new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateGEP(Type /*P*/ Ty, Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList,
           final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        // Every index must be constant.
        /*size_t*/int i;
        /*size_t*/int e;
        for (i = 0 , e = IdxList.size(); i != e; ++i)  {
          if (!isa_Constant(IdxList.$at(i))) {
            break;
          }
        }
        if (i == e) {
          return Insert(Folder.CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Ty, PC, IdxList), Name);
        }
      }
    }
    return Insert$T(GetElementPtrInst.Create1(Ty, Ptr, new ArrayRef<Value /*P*/ >(IdxList)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInBoundsGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1123,
   FQN="llvm::IRBuilder::CreateInBoundsGEP", NM="_ZN4llvm9IRBuilder17CreateInBoundsGEPEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateInBoundsGEPEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateInBoundsGEP(Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList) {
    return CreateInBoundsGEP(Ptr, IdxList,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateInBoundsGEP(Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateInBoundsGEP(null, Ptr, IdxList, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInBoundsGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1127,
   FQN="llvm::IRBuilder::CreateInBoundsGEP", NM="_ZN4llvm9IRBuilder17CreateInBoundsGEPEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateInBoundsGEPEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateInBoundsGEP(Type /*P*/ Ty, Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList) {
    return CreateInBoundsGEP(Ty, Ptr, IdxList,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateInBoundsGEP(Type /*P*/ Ty, Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        // Every index must be constant.
        /*size_t*/int i;
        /*size_t*/int e;
        for (i = 0 , e = IdxList.size(); i != e; ++i)  {
          if (!isa_Constant(IdxList.$at(i))) {
            break;
          }
        }
        if (i == e) {
          return Insert(Folder.CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Ty, PC, IdxList),
              Name);
        }
      }
    }
    return Insert$T(GetElementPtrInst.CreateInBounds2(Ty, Ptr, new ArrayRef<Value /*P*/ >(IdxList)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1141,
   FQN="llvm::IRBuilder::CreateGEP", NM="_ZN4llvm9IRBuilder9CreateGEPEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateGEPEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateGEP(Value /*P*/ Ptr, Value /*P*/ Idx) {
    return CreateGEP(Ptr, Idx, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateGEP(Value /*P*/ Ptr, Value /*P*/ Idx, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateGEP(null, Ptr, Idx, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1144,
   FQN="llvm::IRBuilder::CreateGEP", NM="_ZN4llvm9IRBuilder9CreateGEPEPNS_4TypeEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreateGEPEPNS_4TypeEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateGEP(Type /*P*/ Ty, Value /*P*/ Ptr, Value /*P*/ Idx) {
    return CreateGEP(Ty, Ptr, Idx, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateGEP(Type /*P*/ Ty, Value /*P*/ Ptr, Value /*P*/ Idx, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        {
          Constant /*P*/ IC = dyn_cast_Constant(Idx);
          if ((IC != null)) {
            return Insert(Folder.CreateGetElementPtr(Ty, PC, IC), Name);
          }
        }
      }
    }
    return Insert$T(GetElementPtrInst.Create1(Ty, Ptr, new ArrayRef<Value /*P*/ >(Idx, true)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInBoundsGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1150,
   FQN="llvm::IRBuilder::CreateInBoundsGEP", NM="_ZN4llvm9IRBuilder17CreateInBoundsGEPEPNS_4TypeEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateInBoundsGEPEPNS_4TypeEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateInBoundsGEP(Type /*P*/ Ty, Value /*P*/ Ptr, Value /*P*/ Idx) {
    return CreateInBoundsGEP(Ty, Ptr, Idx,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateInBoundsGEP(Type /*P*/ Ty, Value /*P*/ Ptr, Value /*P*/ Idx,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        {
          Constant /*P*/ IC = dyn_cast_Constant(Idx);
          if ((IC != null)) {
            return Insert(Folder.CreateInBoundsGetElementPtr(Ty, PC, IC), Name);
          }
        }
      }
    }
    return Insert$T(GetElementPtrInst.CreateInBounds2(Ty, Ptr, new ArrayRef<Value /*P*/ >(Idx, true)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstGEP1_32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1157,
   FQN="llvm::IRBuilder::CreateConstGEP1_32", NM="_ZN4llvm9IRBuilder18CreateConstGEP1_32EPNS_5ValueEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateConstGEP1_32EPNS_5ValueEjRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstGEP1_32(Value /*P*/ Ptr, /*uint*/int Idx0) {
    return CreateConstGEP1_32(Ptr, Idx0, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstGEP1_32(Value /*P*/ Ptr, /*uint*/int Idx0, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateConstGEP1_32(null, Ptr, Idx0, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstGEP1_32">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1160,
   FQN="llvm::IRBuilder::CreateConstGEP1_32", NM="_ZN4llvm9IRBuilder18CreateConstGEP1_32EPNS_4TypeEPNS_5ValueEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateConstGEP1_32EPNS_4TypeEPNS_5ValueEjRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstGEP1_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0) {
    return CreateConstGEP1_32(Ty, Ptr, Idx0,
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstGEP1_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0,
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Constant /*P*/ Idx = ConstantInt.get(Type.getInt32Ty(Context), Idx0);
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateGetElementPtr(Ty, PC, Idx), Name);
      }
    }

    return Insert$T(GetElementPtrInst.Create1(Ty, Ptr, new ArrayRef<Value /*P*/ >(Idx, true)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstInBoundsGEP1_32">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1169,
   FQN="llvm::IRBuilder::CreateConstInBoundsGEP1_32", NM="_ZN4llvm9IRBuilder26CreateConstInBoundsGEP1_32EPNS_4TypeEPNS_5ValueEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder26CreateConstInBoundsGEP1_32EPNS_4TypeEPNS_5ValueEjRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstInBoundsGEP1_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0) {
    return CreateConstInBoundsGEP1_32(Ty, Ptr, Idx0,
                            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstInBoundsGEP1_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0,
                            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Constant /*P*/ Idx = ConstantInt.get(Type.getInt32Ty(Context), Idx0);
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateInBoundsGetElementPtr(Ty, PC, Idx), Name);
      }
    }

    return Insert$T(GetElementPtrInst.CreateInBounds2(Ty, Ptr, new ArrayRef<Value /*P*/ >(Idx, true)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstGEP2_32">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1178,
   FQN="llvm::IRBuilder::CreateConstGEP2_32", NM="_ZN4llvm9IRBuilder18CreateConstGEP2_32EPNS_4TypeEPNS_5ValueEjjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateConstGEP2_32EPNS_4TypeEPNS_5ValueEjjRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstGEP2_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0, /*uint*/int Idx1) {
    return CreateConstGEP2_32(Ty, Ptr, Idx0, Idx1,
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstGEP2_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0, /*uint*/int Idx1,
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    ArrayRef<Value> /*P*/ Idxs = /*((void)*/ new ArrayRef<Value>(new Value[] {
      ConstantInt.get(Type.getInt32Ty(Context), Idx0),
      ConstantInt.get(Type.getInt32Ty(Context), Idx1)
    });
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Ty, PC, Idxs), Name);
      }
    }

    return Insert$T(GetElementPtrInst.Create1(Ty, Ptr, Idxs), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstInBoundsGEP2_32">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1190,
   FQN="llvm::IRBuilder::CreateConstInBoundsGEP2_32", NM="_ZN4llvm9IRBuilder26CreateConstInBoundsGEP2_32EPNS_4TypeEPNS_5ValueEjjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder26CreateConstInBoundsGEP2_32EPNS_4TypeEPNS_5ValueEjjRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstInBoundsGEP2_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0,
                            /*uint*/int Idx1) {
    return CreateConstInBoundsGEP2_32(Ty, Ptr, Idx0,
                            Idx1, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstInBoundsGEP2_32(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx0,
                            /*uint*/int Idx1, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    ArrayRef<Value> /*P*/ Idxs = /*((void)*/ new ArrayRef<Value>(new Value[] {
      ConstantInt.get(Type.getInt32Ty(Context), Idx0),
      ConstantInt.get(Type.getInt32Ty(Context), Idx1)
    });
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Ty, PC, Idxs), Name);
      }
    }

    return Insert$T(GetElementPtrInst.CreateInBounds2(Ty, Ptr, Idxs), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstGEP1_64">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1202,
   FQN="llvm::IRBuilder::CreateConstGEP1_64", NM="_ZN4llvm9IRBuilder18CreateConstGEP1_64EPNS_5ValueEyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateConstGEP1_64EPNS_5ValueEyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstGEP1_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0) {
    return CreateConstGEP1_64(Ptr, Idx0, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstGEP1_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Constant /*P*/ Idx = ConstantInt.get(Type.getInt64Ty(Context), Idx0);
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateGetElementPtr(null, PC, Idx), Name);
      }
    }

    return Insert$T(GetElementPtrInst.Create1((Type /*P*/ )null, Ptr, new ArrayRef<Value /*P*/ >(Idx, true)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstInBoundsGEP1_64">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1210,
   FQN="llvm::IRBuilder::CreateConstInBoundsGEP1_64", NM="_ZN4llvm9IRBuilder26CreateConstInBoundsGEP1_64EPNS_5ValueEyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder26CreateConstInBoundsGEP1_64EPNS_5ValueEyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstInBoundsGEP1_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0) {
    return CreateConstInBoundsGEP1_64(Ptr, Idx0,
                            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstInBoundsGEP1_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0,
                            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Constant /*P*/ Idx = ConstantInt.get(Type.getInt64Ty(Context), Idx0);
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateInBoundsGetElementPtr(null, PC, Idx), Name);
      }
    }

    return Insert$T(GetElementPtrInst.CreateInBounds2((Type /*P*/ )null, Ptr, new ArrayRef<Value /*P*/ >(Idx, true)), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstGEP2_64">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1219,
   FQN="llvm::IRBuilder::CreateConstGEP2_64", NM="_ZN4llvm9IRBuilder18CreateConstGEP2_64EPNS_5ValueEyyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateConstGEP2_64EPNS_5ValueEyyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstGEP2_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0, long/*uint64_t*/ Idx1) {
    return CreateConstGEP2_64(Ptr, Idx0, Idx1,
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstGEP2_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0, long/*uint64_t*/ Idx1,
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    ArrayRef<Value> /*P*/ Idxs = /*((void)*/ new ArrayRef<Value>(new Value[] {
      ConstantInt.get(Type.getInt64Ty(Context), Idx0),
      ConstantInt.get(Type.getInt64Ty(Context), Idx1),
    });
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(null, PC, Idxs), Name);
      }
    }

    return Insert$T(GetElementPtrInst.Create1(null, Ptr, Idxs), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateConstInBoundsGEP2_64">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1231,
   FQN="llvm::IRBuilder::CreateConstInBoundsGEP2_64", NM="_ZN4llvm9IRBuilder26CreateConstInBoundsGEP2_64EPNS_5ValueEyyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder26CreateConstInBoundsGEP2_64EPNS_5ValueEyyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstInBoundsGEP2_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0, long/*uint64_t*/ Idx1) {
    return CreateConstInBoundsGEP2_64(Ptr, Idx0, Idx1,
                            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstInBoundsGEP2_64(Value /*P*/ Ptr, long/*uint64_t*/ Idx0, long/*uint64_t*/ Idx1,
                            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    ArrayRef<Value> /*P*/ Idxs = /*((void)*/ new ArrayRef<Value>(new Value[] {
      ConstantInt.get(Type.getInt64Ty(Context), Idx0),
      ConstantInt.get(Type.getInt64Ty(Context), Idx1),
    });
    {

      Constant /*P*/ PC = dyn_cast_Constant(Ptr);
      if ((PC != null)) {
        return Insert(Folder.CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(null, PC, Idxs),
            Name);
      }
    }

    return Insert$T(GetElementPtrInst.CreateInBounds2(null, Ptr, Idxs), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateStructGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1244,
   FQN="llvm::IRBuilder::CreateStructGEP", NM="_ZN4llvm9IRBuilder15CreateStructGEPEPNS_4TypeEPNS_5ValueEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder15CreateStructGEPEPNS_4TypeEPNS_5ValueEjRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateStructGEP(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx) {
    return CreateStructGEP(Ty, Ptr, Idx,
                 new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateStructGEP(Type /*P*/ Ty, Value /*P*/ Ptr, /*uint*/int Idx,
                 final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateConstInBoundsGEP2_32(Ty, Ptr, 0, Idx, Name);
  }


  /// \brief Same as CreateGlobalString, but return a pointer with "i8*" type
  /// instead of a pointer to array of i8.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateGlobalStringPtr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1251,
   FQN="llvm::IRBuilder::CreateGlobalStringPtr", NM="_ZN4llvm9IRBuilder21CreateGlobalStringPtrENS_9StringRefERKNS_5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder21CreateGlobalStringPtrENS_9StringRefERKNS_5TwineEj")
  //</editor-fold>
  public Value /*P*/ CreateGlobalStringPtr(StringRef Str) {
    return CreateGlobalStringPtr(Str, new Twine(/*KEEP_STR*/$EMPTY),
                       0);
  }
  public Value /*P*/ CreateGlobalStringPtr(StringRef Str, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateGlobalStringPtr(Str, Name,
                       0);
  }
  public Value /*P*/ CreateGlobalStringPtr(StringRef Str, final /*const*/ Twine /*&*/ Name/*= ""*/,
                       /*uint*/int AddressSpace/*= 0*/) {
    GlobalVariable /*P*/ gv = CreateGlobalString(Str, Name, AddressSpace);
    Value /*P*/ zero = ConstantInt.get(Type.getInt32Ty(Context), 0);
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {zero, zero};
    return CreateInBoundsGEP(gv.getValueType(), gv, new ArrayRef(Args), Name);
  }


  //===--------------------------------------------------------------------===//
  // Instruction creation methods: Cast/Conversion Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1263,
   FQN="llvm::IRBuilder::CreateTrunc", NM="_ZN4llvm9IRBuilder11CreateTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder11CreateTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateTrunc(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateTrunc(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateTrunc(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.Trunc, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateZExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1266,
   FQN="llvm::IRBuilder::CreateZExt", NM="_ZN4llvm9IRBuilder10CreateZExtEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateZExtEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateZExt(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateZExt(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateZExt(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.ZExt, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1269,
   FQN="llvm::IRBuilder::CreateSExt", NM="_ZN4llvm9IRBuilder10CreateSExtEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateSExtEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateSExt(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateSExt(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateSExt(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.SExt, V, DestTy, Name);
  }

  /// \brief Create a ZExt or Trunc from the integer value V to DestTy. Return
  /// the value untouched if the type of V is already DestTy.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateZExtOrTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1274,
   FQN="llvm::IRBuilder::CreateZExtOrTrunc", NM="_ZN4llvm9IRBuilder17CreateZExtOrTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateZExtOrTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateZExtOrTrunc(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateZExtOrTrunc(V, DestTy,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateZExtOrTrunc(Value /*P*/ V, Type /*P*/ DestTy,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (V.getType().isIntOrIntVectorTy() && DestTy.isIntOrIntVectorTy()) : "Can only zero extend/truncate integers!";
    Type /*P*/ VTy = V.getType();
    if ($less_uint(VTy.getScalarSizeInBits(), DestTy.getScalarSizeInBits())) {
      return CreateZExt(V, DestTy, Name);
    }
    if ($greater_uint(VTy.getScalarSizeInBits(), DestTy.getScalarSizeInBits())) {
      return CreateTrunc(V, DestTy, Name);
    }
    return V;
  }

  /// \brief Create a SExt or Trunc from the integer value V to DestTy. Return
  /// the value untouched if the type of V is already DestTy.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSExtOrTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1288,
   FQN="llvm::IRBuilder::CreateSExtOrTrunc", NM="_ZN4llvm9IRBuilder17CreateSExtOrTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateSExtOrTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateSExtOrTrunc(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateSExtOrTrunc(V, DestTy,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateSExtOrTrunc(Value /*P*/ V, Type /*P*/ DestTy,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (V.getType().isIntOrIntVectorTy() && DestTy.isIntOrIntVectorTy()) : "Can only sign extend/truncate integers!";
    Type /*P*/ VTy = V.getType();
    if ($less_uint(VTy.getScalarSizeInBits(), DestTy.getScalarSizeInBits())) {
      return CreateSExt(V, DestTy, Name);
    }
    if ($greater_uint(VTy.getScalarSizeInBits(), DestTy.getScalarSizeInBits())) {
      return CreateTrunc(V, DestTy, Name);
    }
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFPToUI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1300,
   FQN="llvm::IRBuilder::CreateFPToUI", NM="_ZN4llvm9IRBuilder12CreateFPToUIEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateFPToUIEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateFPToUI(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateFPToUI(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateFPToUI(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.FPToUI, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFPToSI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1303,
   FQN="llvm::IRBuilder::CreateFPToSI", NM="_ZN4llvm9IRBuilder12CreateFPToSIEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateFPToSIEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateFPToSI(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateFPToSI(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateFPToSI(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.FPToSI, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateUIToFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1306,
   FQN="llvm::IRBuilder::CreateUIToFP", NM="_ZN4llvm9IRBuilder12CreateUIToFPEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateUIToFPEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateUIToFP(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateUIToFP(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateUIToFP(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.UIToFP, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSIToFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1309,
   FQN="llvm::IRBuilder::CreateSIToFP", NM="_ZN4llvm9IRBuilder12CreateSIToFPEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateSIToFPEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateSIToFP(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateSIToFP(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateSIToFP(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.SIToFP, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFPTrunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1312,
   FQN="llvm::IRBuilder::CreateFPTrunc", NM="_ZN4llvm9IRBuilder13CreateFPTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFPTruncEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateFPTrunc(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateFPTrunc(V, DestTy,
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateFPTrunc(Value /*P*/ V, Type /*P*/ DestTy,
               final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.FPTrunc, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFPExt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1316,
   FQN="llvm::IRBuilder::CreateFPExt", NM="_ZN4llvm9IRBuilder11CreateFPExtEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder11CreateFPExtEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateFPExt(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateFPExt(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateFPExt(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.FPExt, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreatePtrToInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1319,
   FQN="llvm::IRBuilder::CreatePtrToInt", NM="_ZN4llvm9IRBuilder14CreatePtrToIntEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder14CreatePtrToIntEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreatePtrToInt(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreatePtrToInt(V, DestTy,
                new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreatePtrToInt(Value /*P*/ V, Type /*P*/ DestTy,
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.PtrToInt, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateIntToPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1323,
   FQN="llvm::IRBuilder::CreateIntToPtr", NM="_ZN4llvm9IRBuilder14CreateIntToPtrEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder14CreateIntToPtrEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateIntToPtr(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateIntToPtr(V, DestTy,
                new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateIntToPtr(Value /*P*/ V, Type /*P*/ DestTy,
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.IntToPtr, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1327,
   FQN="llvm::IRBuilder::CreateBitCast", NM="_ZN4llvm9IRBuilder13CreateBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateBitCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateBitCast(V, DestTy,
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateBitCast(Value /*P*/ V, Type /*P*/ DestTy,
               final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.BitCast, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1331,
   FQN="llvm::IRBuilder::CreateAddrSpaceCast", NM="_ZN4llvm9IRBuilder19CreateAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateAddrSpaceCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateAddrSpaceCast(V, DestTy,
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateAddrSpaceCast(Value /*P*/ V, Type /*P*/ DestTy,
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCast(Instruction.CastOps.AddrSpaceCast, V, DestTy, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateZExtOrBitCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1335,
   FQN="llvm::IRBuilder::CreateZExtOrBitCast", NM="_ZN4llvm9IRBuilder19CreateZExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateZExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateZExtOrBitCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateZExtOrBitCast(V, DestTy,
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateZExtOrBitCast(Value /*P*/ V, Type /*P*/ DestTy,
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateZExtOrBitCast(VC, DestTy), Name);
      }
    }
    return Insert$T(CastInst.CreateZExtOrBitCast(V, DestTy), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSExtOrBitCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1343,
   FQN="llvm::IRBuilder::CreateSExtOrBitCast", NM="_ZN4llvm9IRBuilder19CreateSExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateSExtOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateSExtOrBitCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateSExtOrBitCast(V, DestTy,
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateSExtOrBitCast(Value /*P*/ V, Type /*P*/ DestTy,
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateSExtOrBitCast(VC, DestTy), Name);
      }
    }
    return Insert$T(CastInst.CreateSExtOrBitCast(V, DestTy), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateTruncOrBitCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1351,
   FQN="llvm::IRBuilder::CreateTruncOrBitCast", NM="_ZN4llvm9IRBuilder20CreateTruncOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder20CreateTruncOrBitCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateTruncOrBitCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateTruncOrBitCast(V, DestTy,
                      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateTruncOrBitCast(Value /*P*/ V, Type /*P*/ DestTy,
                      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateTruncOrBitCast(VC, DestTy), Name);
      }
    }
    return Insert$T(CastInst.CreateTruncOrBitCast(V, DestTy), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1359,
   FQN="llvm::IRBuilder::CreateCast", NM="_ZN4llvm9IRBuilder10CreateCastENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateCastENS_11Instruction7CastOpsEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateCast(/*CastOps*/int Op, Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateCast(Op, V, DestTy,
            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateCast(/*CastOps*/int Op, Value /*P*/ V, Type /*P*/ DestTy,
            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateCast(Op, VC, DestTy), Name);
      }
    }
    return Insert$T(CastInst.Create(Op, V, DestTy), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreatePointerCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1367,
   FQN="llvm::IRBuilder::CreatePointerCast", NM="_ZN4llvm9IRBuilder17CreatePointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreatePointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreatePointerCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreatePointerCast(V, DestTy,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreatePointerCast(Value /*P*/ V, Type /*P*/ DestTy,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreatePointerCast(VC, DestTy), Name);
      }
    }
    return Insert$T(CastInst.CreatePointerCast(V, DestTy), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreatePointerBitCastOrAddrSpaceCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1376,
   FQN="llvm::IRBuilder::CreatePointerBitCastOrAddrSpaceCast", NM="_ZN4llvm9IRBuilder35CreatePointerBitCastOrAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder35CreatePointerBitCastOrAddrSpaceCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreatePointerBitCastOrAddrSpaceCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreatePointerBitCastOrAddrSpaceCast(V, DestTy,
                                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreatePointerBitCastOrAddrSpaceCast(Value /*P*/ V, Type /*P*/ DestTy,
                                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {

      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreatePointerBitCastOrAddrSpaceCast(VC, DestTy),
            Name);
      }
    }

    return Insert$T(CastInst.CreatePointerBitCastOrAddrSpaceCast(V, DestTy),
        Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateIntCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1390,
   FQN="llvm::IRBuilder::CreateIntCast", NM="_ZN4llvm9IRBuilder13CreateIntCastEPNS_5ValueEPNS_4TypeEbRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateIntCastEPNS_5ValueEPNS_4TypeEbRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateIntCast(Value /*P*/ V, Type /*P*/ DestTy, boolean isSigned) {
    return CreateIntCast(V, DestTy, isSigned,
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateIntCast(Value /*P*/ V, Type /*P*/ DestTy, boolean isSigned,
               final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateIntCast(VC, DestTy, isSigned), Name);
      }
    }
    return Insert$T(CastInst.CreateIntegerCast(V, DestTy, isSigned), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateBitOrPointerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1399,
   FQN="llvm::IRBuilder::CreateBitOrPointerCast", NM="_ZN4llvm9IRBuilder22CreateBitOrPointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder22CreateBitOrPointerCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateBitOrPointerCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateBitOrPointerCast(V, DestTy,
                        new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateBitOrPointerCast(Value /*P*/ V, Type /*P*/ DestTy,
                        final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    if (V.getType().getScalarType().isPointerTy()
       && DestTy.getScalarType().isIntegerTy()) {
      return CreatePtrToInt(V, DestTy, Name);
    }
    if (V.getType().getScalarType().isIntegerTy()
       && DestTy.getScalarType().isPointerTy()) {
      return CreateIntToPtr(V, DestTy, Name);
    }

    return CreateBitCast(V, DestTy, Name);
  }

/*private:*/
  // \brief Provided to resolve 'CreateIntCast(Ptr, Ptr, "...")', giving a
  // compile time error, instead of converting the string to bool for the
  // isSigned parameter.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateIntCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1417,
   FQN="llvm::IRBuilder::CreateIntCast", NM="_ZN4llvm9IRBuilder13CreateIntCastEPNS_5ValueEPNS_4TypeEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateIntCastEPNS_5ValueEPNS_4TypeEPKc")
  //</editor-fold>
  protected/*private*/ Value /*P*/ CreateIntCast(Value /*P*/ $Prm0, Type /*P*/ $Prm1, /*const*/char$ptr/*char P*/ $Prm2) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFPCast">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1420,
   FQN="llvm::IRBuilder::CreateFPCast", NM="_ZN4llvm9IRBuilder12CreateFPCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateFPCastEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateFPCast(Value /*P*/ V, Type /*P*/ DestTy) {
    return CreateFPCast(V, DestTy, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateFPCast(Value /*P*/ V, Type /*P*/ DestTy, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    if (V.getType() == DestTy) {
      return V;
    }
    {
      Constant /*P*/ VC = dyn_cast_Constant(V);
      if ((VC != null)) {
        return Insert(Folder.CreateFPCast(VC, DestTy), Name);
      }
    }
    return Insert$T(CastInst.CreateFPCast(V, DestTy), Name);
  }


  //===--------------------------------------------------------------------===//
  // Instruction creation methods: Compare Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1432,
   FQN="llvm::IRBuilder::CreateICmpEQ", NM="_ZN4llvm9IRBuilder12CreateICmpEQEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateICmpEQEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpEQ(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpEQ(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpEQ(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_EQ, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpNE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1435,
   FQN="llvm::IRBuilder::CreateICmpNE", NM="_ZN4llvm9IRBuilder12CreateICmpNEEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateICmpNEEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpNE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpNE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpNE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_NE, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpUGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1438,
   FQN="llvm::IRBuilder::CreateICmpUGT", NM="_ZN4llvm9IRBuilder13CreateICmpUGTEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpUGTEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpUGT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpUGT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpUGT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_UGT, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpUGE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1441,
   FQN="llvm::IRBuilder::CreateICmpUGE", NM="_ZN4llvm9IRBuilder13CreateICmpUGEEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpUGEEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpUGE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpUGE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpUGE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_UGE, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpULT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1444,
   FQN="llvm::IRBuilder::CreateICmpULT", NM="_ZN4llvm9IRBuilder13CreateICmpULTEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpULTEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpULT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpULT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpULT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_ULT, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpULE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1447,
   FQN="llvm::IRBuilder::CreateICmpULE", NM="_ZN4llvm9IRBuilder13CreateICmpULEEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpULEEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpULE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpULE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpULE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_ULE, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpSGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1450,
   FQN="llvm::IRBuilder::CreateICmpSGT", NM="_ZN4llvm9IRBuilder13CreateICmpSGTEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpSGTEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpSGT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpSGT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpSGT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_SGT, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpSGE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1453,
   FQN="llvm::IRBuilder::CreateICmpSGE", NM="_ZN4llvm9IRBuilder13CreateICmpSGEEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpSGEEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpSGE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpSGE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpSGE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_SGE, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpSLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1456,
   FQN="llvm::IRBuilder::CreateICmpSLT", NM="_ZN4llvm9IRBuilder13CreateICmpSLTEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpSLTEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpSLT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpSLT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpSLT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_SLT, LHS, RHS, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmpSLE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1459,
   FQN="llvm::IRBuilder::CreateICmpSLE", NM="_ZN4llvm9IRBuilder13CreateICmpSLEEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateICmpSLEEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmpSLE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmpSLE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmpSLE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmp(ICmpInst.Predicate.ICMP_SLE, LHS, RHS, Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpOEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1463,
   FQN="llvm::IRBuilder::CreateFCmpOEQ", NM="_ZN4llvm9IRBuilder13CreateFCmpOEQEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpOEQEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpOEQ(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpOEQ(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOEQ(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpOEQ(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOEQ(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_OEQ, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpOGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1467,
   FQN="llvm::IRBuilder::CreateFCmpOGT", NM="_ZN4llvm9IRBuilder13CreateFCmpOGTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpOGTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpOGT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpOGT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOGT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpOGT(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOGT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_OGT, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpOGE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1471,
   FQN="llvm::IRBuilder::CreateFCmpOGE", NM="_ZN4llvm9IRBuilder13CreateFCmpOGEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpOGEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpOGE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpOGE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOGE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpOGE(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOGE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_OGE, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpOLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1475,
   FQN="llvm::IRBuilder::CreateFCmpOLT", NM="_ZN4llvm9IRBuilder13CreateFCmpOLTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpOLTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpOLT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpOLT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOLT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpOLT(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOLT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_OLT, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpOLE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1479,
   FQN="llvm::IRBuilder::CreateFCmpOLE", NM="_ZN4llvm9IRBuilder13CreateFCmpOLEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpOLEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpOLE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpOLE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOLE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpOLE(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpOLE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_OLE, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpONE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1483,
   FQN="llvm::IRBuilder::CreateFCmpONE", NM="_ZN4llvm9IRBuilder13CreateFCmpONEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpONEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpONE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpONE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpONE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpONE(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpONE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_ONE, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpORD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1487,
   FQN="llvm::IRBuilder::CreateFCmpORD", NM="_ZN4llvm9IRBuilder13CreateFCmpORDEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpORDEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpORD(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpORD(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpORD(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpORD(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpORD(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_ORD, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpUNO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1491,
   FQN="llvm::IRBuilder::CreateFCmpUNO", NM="_ZN4llvm9IRBuilder13CreateFCmpUNOEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpUNOEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpUNO(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpUNO(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUNO(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpUNO(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUNO(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_UNO, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpUEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1495,
   FQN="llvm::IRBuilder::CreateFCmpUEQ", NM="_ZN4llvm9IRBuilder13CreateFCmpUEQEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpUEQEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpUEQ(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpUEQ(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUEQ(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpUEQ(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUEQ(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_UEQ, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpUGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1499,
   FQN="llvm::IRBuilder::CreateFCmpUGT", NM="_ZN4llvm9IRBuilder13CreateFCmpUGTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpUGTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpUGT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpUGT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUGT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpUGT(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUGT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_UGT, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpUGE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1503,
   FQN="llvm::IRBuilder::CreateFCmpUGE", NM="_ZN4llvm9IRBuilder13CreateFCmpUGEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpUGEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpUGE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpUGE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUGE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpUGE(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUGE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_UGE, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpULT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1507,
   FQN="llvm::IRBuilder::CreateFCmpULT", NM="_ZN4llvm9IRBuilder13CreateFCmpULTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpULTEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpULT(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpULT(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpULT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpULT(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpULT(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_ULT, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpULE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1511,
   FQN="llvm::IRBuilder::CreateFCmpULE", NM="_ZN4llvm9IRBuilder13CreateFCmpULEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpULEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpULE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpULE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpULE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpULE(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpULE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_ULE, LHS, RHS, Name, FPMathTag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmpUNE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1515,
   FQN="llvm::IRBuilder::CreateFCmpUNE", NM="_ZN4llvm9IRBuilder13CreateFCmpUNEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreateFCmpUNEEPNS_5ValueES2_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmpUNE(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmpUNE(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY),
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUNE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmpUNE(LHS, RHS, Name,
               (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmpUNE(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/,
               MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateFCmp(FCmpInst.Predicate.FCMP_UNE, LHS, RHS, Name, FPMathTag);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateICmp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1520,
   FQN="llvm::IRBuilder::CreateICmp", NM="_ZN4llvm9IRBuilder10CreateICmpENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateICmpENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateICmp(CmpInst.Predicate P, Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateICmp(P, LHS, RHS,
            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateICmp(CmpInst.Predicate P, Value /*P*/ LHS, Value /*P*/ RHS,
            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateICmp(P, LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(/*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
            return new ICmpInst(P, LHS, RHS);
         }), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateFCmp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1527,
   FQN="llvm::IRBuilder::CreateFCmp", NM="_ZN4llvm9IRBuilder10CreateFCmpENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateFCmpENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public Value /*P*/ CreateFCmp(CmpInst.Predicate P, Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreateFCmp(P, LHS, RHS,
            new Twine(/*KEEP_STR*/$EMPTY), (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmp(CmpInst.Predicate P, Value /*P*/ LHS, Value /*P*/ RHS,
            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateFCmp(P, LHS, RHS,
            Name, (MDNode /*P*/ )null);
  }
  public Value /*P*/ CreateFCmp(CmpInst.Predicate P, Value /*P*/ LHS, Value /*P*/ RHS,
            final /*const*/ Twine /*&*/ Name/*= ""*/, MDNode /*P*/ FPMathTag/*= null*/) {
    {
      Constant /*P*/ LC = dyn_cast_Constant(LHS);
      if ((LC != null)) {
        {
          Constant /*P*/ RC = dyn_cast_Constant(RHS);
          if ((RC != null)) {
            return Insert(Folder.CreateFCmp(P, LC, RC), Name);
          }
        }
      }
    }
    return Insert$T(AddFPMathAttributes(/*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
                return new FCmpInst(P, LHS, RHS);
             }),
            FPMathTag, FMF), Name);
  }


  //===--------------------------------------------------------------------===//
  // Instruction creation methods: Other Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreatePHI">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1540,
   FQN="llvm::IRBuilder::CreatePHI", NM="_ZN4llvm9IRBuilder9CreatePHIEPNS_4TypeEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder9CreatePHIEPNS_4TypeEjRKNS_5TwineE")
  //</editor-fold>
  public PHINode /*P*/ CreatePHI(Type /*P*/ Ty, /*uint*/int NumReservedValues) {
    return CreatePHI(Ty, NumReservedValues,
           new Twine(/*KEEP_STR*/$EMPTY));
  }
  public PHINode /*P*/ CreatePHI(Type /*P*/ Ty, /*uint*/int NumReservedValues,
           final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(PHINode.Create(Ty, NumReservedValues), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1545,
   FQN="llvm::IRBuilder::CreateCall", NM="_ZN4llvm9IRBuilder10CreateCallEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateCallEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public CallInst /*P*/ CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Value /*P*/ Callee) {
    return CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, new ArrayRef<Value /*P*/ >(None, true),
                                                      new Twine(/*KEEP_STR*/$EMPTY), (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Args/*= None*/) {
    return CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, Args,
                                                      new Twine(/*KEEP_STR*/$EMPTY), (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Args/*= None*/,
                                                      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, Args,
                                                      Name, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Args/*= None*/,
                                                      final /*const*/ Twine /*&*/ Name/*= ""*/, MDNode /*P*/ FPMathTag/*= null*/) {
    PointerType /*P*/ PTy = cast_PointerType(Callee.getType());
    FunctionType /*P*/ FTy = cast_FunctionType(PTy.getElementType());
    return CreateCall(FTy, Callee, Args, Name, FPMathTag);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1552,
   FQN="llvm::IRBuilder::CreateCall", NM="_ZN4llvm9IRBuilder10CreateCallEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateCallEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public CallInst /*P*/ CreateCall(FunctionType /*P*/ FTy, Value /*P*/ Callee,
            ArrayRef<Value /*P*/ > Args) {
    return CreateCall(FTy, Callee,
            Args, new Twine(/*KEEP_STR*/$EMPTY),
            (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall(FunctionType /*P*/ FTy, Value /*P*/ Callee,
            ArrayRef<Value /*P*/ > Args, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCall(FTy, Callee,
            Args, Name,
            (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall(FunctionType /*P*/ FTy, Value /*P*/ Callee,
            ArrayRef<Value /*P*/ > Args, final /*const*/ Twine /*&*/ Name/*= ""*/,
            MDNode /*P*/ FPMathTag/*= null*/) {
    CallInst /*P*/ CI = CallInst.Create(FTy, Callee, Args, DefaultOperandBundles);
    if (isa_FPMathOperator(CI)) {
      CI = cast_CallInst(AddFPMathAttributes(CI, FPMathTag, FMF));
    }
    return Insert$T(CI, Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1561,
   FQN="llvm::IRBuilder::CreateCall", NM="_ZN4llvm9IRBuilder10CreateCallEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateCallEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public CallInst /*P*/ CreateCall(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Args,
            ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles) {
    return CreateCall(Callee, Args,
            OpBundles,
            new Twine(/*KEEP_STR*/$EMPTY), (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Args,
            ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles,
            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCall(Callee, Args,
            OpBundles,
            Name, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall(Value /*P*/ Callee, ArrayRef<Value /*P*/ > Args,
            ArrayRef<OperandBundleDefT<Value /*P*/ >> OpBundles,
            final /*const*/ Twine /*&*/ Name/*= ""*/, MDNode /*P*/ FPMathTag/*= null*/) {
    CallInst /*P*/ CI = CallInst.Create_Value1(Callee, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpBundles));
    if (isa_FPMathOperator(CI)) {
      CI = cast_CallInst(AddFPMathAttributes(CI, FPMathTag, FMF));
    }
    return Insert$T(CI, Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1570,
   FQN="llvm::IRBuilder::CreateCall", NM="_ZN4llvm9IRBuilder10CreateCallEPNS_8FunctionENS_8ArrayRefIPNS_5ValueEEERKNS_5TwineEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder10CreateCallEPNS_8FunctionENS_8ArrayRefIPNS_5ValueEEERKNS_5TwineEPNS_6MDNodeE")
  //</editor-fold>
  public CallInst /*P*/ CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(Function /*P*/ Callee, ArrayRef<Value /*P*/ > Args) {
    return CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, Args,
                                                         new Twine(/*KEEP_STR*/$EMPTY), (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(Function /*P*/ Callee, ArrayRef<Value /*P*/ > Args,
                                                         final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(Callee, Args,
                                                         Name, (MDNode /*P*/ )null);
  }
  public CallInst /*P*/ CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(Function /*P*/ Callee, ArrayRef<Value /*P*/ > Args,
                                                         final /*const*/ Twine /*&*/ Name/*= ""*/, MDNode /*P*/ FPMathTag/*= null*/) {
    return CreateCall(Callee.getFunctionType(), Callee, Args, Name, FPMathTag);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateSelect">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1575,
   FQN="llvm::IRBuilder::CreateSelect", NM="_ZN4llvm9IRBuilder12CreateSelectEPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateSelectEPNS_5ValueES2_S2_RKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public Value /*P*/ CreateSelect(Value /*P*/ C, Value /*P*/ True, Value /*P*/ False) {
    return CreateSelect(C, True, False,
              new Twine(/*KEEP_STR*/$EMPTY), (Instruction /*P*/ )null);
  }
  public Value /*P*/ CreateSelect(Value /*P*/ C, Value /*P*/ True, Value /*P*/ False,
              final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateSelect(C, True, False,
              Name, (Instruction /*P*/ )null);
  }
  public Value /*P*/ CreateSelect(Value /*P*/ C, Value /*P*/ True, Value /*P*/ False,
              final /*const*/ Twine /*&*/ Name/*= ""*/, Instruction /*P*/ MDFrom/*= null*/) {
    {
      Constant /*P*/ CC = dyn_cast_Constant(C);
      if ((CC != null)) {
        {
          Constant /*P*/ TC = dyn_cast_Constant(True);
          if ((TC != null)) {
            {
              Constant /*P*/ FC = dyn_cast_Constant(False);
              if ((FC != null)) {
                return Insert(Folder.CreateSelect(CC, TC, FC), Name);
              }
            }
          }
        }
      }
    }

    SelectInst /*P*/ Sel = SelectInst.Create(C, True, False);
    if ((MDFrom != null)) {
      MDNode /*P*/ Prof = MDFrom.getMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue());
      MDNode /*P*/ Unpred = MDFrom.getMetadata(LLVMContext.Unnamed_enum.MD_unpredictable.getValue());
      Sel = addBranchMetadata(Sel, Prof, Unpred);
    }
    return Insert$T(Sel, Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateVAArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1591,
   FQN="llvm::IRBuilder::CreateVAArg", NM="_ZN4llvm9IRBuilder11CreateVAArgEPNS_5ValueEPNS_4TypeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder11CreateVAArgEPNS_5ValueEPNS_4TypeERKNS_5TwineE")
  //</editor-fold>
  public VAArgInst /*P*/ CreateVAArg(Value /*P*/ List, Type /*P*/ Ty) {
    return CreateVAArg(List, Ty, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public VAArgInst /*P*/ CreateVAArg(Value /*P*/ List, Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(/*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
            return new VAArgInst(List, Ty);
         }), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateExtractElement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1595,
   FQN="llvm::IRBuilder::CreateExtractElement", NM="_ZN4llvm9IRBuilder20CreateExtractElementEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder20CreateExtractElementEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateExtractElement(Value /*P*/ Vec, Value /*P*/ Idx) {
    return CreateExtractElement(Vec, Idx,
                      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateExtractElement(Value /*P*/ Vec, Value /*P*/ Idx,
                      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ VC = dyn_cast_Constant(Vec);
      if ((VC != null)) {
        {
          Constant /*P*/ IC = dyn_cast_Constant(Idx);
          if ((IC != null)) {
            return Insert(Folder.CreateExtractElement(VC, IC), Name);
          }
        }
      }
    }
    return Insert$T(ExtractElementInst.Create(Vec, Idx), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateExtractElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1603,
   FQN="llvm::IRBuilder::CreateExtractElement", NM="_ZN4llvm9IRBuilder20CreateExtractElementEPNS_5ValueEyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder20CreateExtractElementEPNS_5ValueEyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateExtractElement(Value /*P*/ Vec, long/*uint64_t*/ Idx) {
    return CreateExtractElement(Vec, Idx,
                      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateExtractElement(Value /*P*/ Vec, long/*uint64_t*/ Idx,
                      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateExtractElement(Vec, getInt64(Idx), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInsertElement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1608,
   FQN="llvm::IRBuilder::CreateInsertElement", NM="_ZN4llvm9IRBuilder19CreateInsertElementEPNS_5ValueES2_S2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateInsertElementEPNS_5ValueES2_S2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateInsertElement(Value /*P*/ Vec, Value /*P*/ NewElt, Value /*P*/ Idx) {
    return CreateInsertElement(Vec, NewElt, Idx,
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateInsertElement(Value /*P*/ Vec, Value /*P*/ NewElt, Value /*P*/ Idx,
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ VC = dyn_cast_Constant(Vec);
      if ((VC != null)) {
        {
          Constant /*P*/ NC = dyn_cast_Constant(NewElt);
          if ((NC != null)) {
            {
              Constant /*P*/ IC = dyn_cast_Constant(Idx);
              if ((IC != null)) {
                return Insert(Folder.CreateInsertElement(VC, NC, IC), Name);
              }
            }
          }
        }
      }
    }
    return Insert$T(InsertElementInst.Create(Vec, NewElt, Idx), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInsertElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1617,
   FQN="llvm::IRBuilder::CreateInsertElement", NM="_ZN4llvm9IRBuilder19CreateInsertElementEPNS_5ValueES2_yRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateInsertElementEPNS_5ValueES2_yRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateInsertElement(Value /*P*/ Vec, Value /*P*/ NewElt, long/*uint64_t*/ Idx) {
    return CreateInsertElement(Vec, NewElt, Idx,
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateInsertElement(Value /*P*/ Vec, Value /*P*/ NewElt, long/*uint64_t*/ Idx,
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateInsertElement(Vec, NewElt, getInt64(Idx), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateShuffleVector">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1622,
   FQN="llvm::IRBuilder::CreateShuffleVector", NM="_ZN4llvm9IRBuilder19CreateShuffleVectorEPNS_5ValueES2_S2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateShuffleVectorEPNS_5ValueES2_S2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateShuffleVector(Value /*P*/ V1, Value /*P*/ V2, Value /*P*/ Mask) {
    return CreateShuffleVector(V1, V2, Mask,
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateShuffleVector(Value /*P*/ V1, Value /*P*/ V2, Value /*P*/ Mask,
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ V1C = dyn_cast_Constant(V1);
      if ((V1C != null)) {
        {
          Constant /*P*/ V2C = dyn_cast_Constant(V2);
          if ((V2C != null)) {
            {
              Constant /*P*/ MC = dyn_cast_Constant(Mask);
              if ((MC != null)) {
                return Insert(Folder.CreateShuffleVector(V1C, V2C, MC), Name);
              }
            }
          }
        }
      }
    }
    return Insert$T(/*NEW_EXPR [ShuffleVectorInst::new]*/ShuffleVectorInst.$new_ShuffleVectorInst((type$ptr<?> New$Mem)->{
            return new ShuffleVectorInst(V1, V2, Mask);
         }), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateShuffleVector">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1631,
   FQN="llvm::IRBuilder::CreateShuffleVector", NM="_ZN4llvm9IRBuilder19CreateShuffleVectorEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder19CreateShuffleVectorEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateShuffleVector(Value /*P*/ V1, Value /*P*/ V2, ArrayRefUInt IntMask) {
    return CreateShuffleVector(V1, V2, IntMask,
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateShuffleVector(Value /*P*/ V1, Value /*P*/ V2, ArrayRefUInt IntMask,
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Value /*P*/ Mask = ConstantDataVector.getFP_LLVMContext_ArrayRefUInt(Context, IntMask);
    return CreateShuffleVector(V1, V2, Mask, Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateExtractValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1637,
   FQN="llvm::IRBuilder::CreateExtractValue", NM="_ZN4llvm9IRBuilder18CreateExtractValueEPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder18CreateExtractValueEPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateExtractValue(Value /*P*/ Agg,
                    ArrayRefUInt Idxs) {
    return CreateExtractValue(Agg,
                    Idxs,
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateExtractValue(Value /*P*/ Agg,
                    ArrayRefUInt Idxs,
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ AggC = dyn_cast_Constant(Agg);
      if ((AggC != null)) {
        return Insert(Folder.CreateExtractValue(AggC, Idxs), Name);
      }
    }
    return Insert$T(ExtractValueInst.Create_Value1(Agg, new ArrayRefUInt(Idxs)), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInsertValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1645,
   FQN="llvm::IRBuilder::CreateInsertValue", NM="_ZN4llvm9IRBuilder17CreateInsertValueEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateInsertValueEPNS_5ValueES2_NS_8ArrayRefIjEERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateInsertValue(Value /*P*/ Agg, Value /*P*/ Val,
                   ArrayRefUInt Idxs) {
    return CreateInsertValue(Agg, Val,
                   Idxs,
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateInsertValue(Value /*P*/ Agg, Value /*P*/ Val,
                   ArrayRefUInt Idxs,
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    {
      Constant /*P*/ AggC = dyn_cast_Constant(Agg);
      if ((AggC != null)) {
        {
          Constant /*P*/ ValC = dyn_cast_Constant(Val);
          if ((ValC != null)) {
            return Insert(Folder.CreateInsertValue(AggC, ValC, Idxs), Name);
          }
        }
      }
    }
    return Insert$T(InsertValueInst.Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Agg, Val, new ArrayRefUInt(Idxs)), Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateLandingPad">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1654,
   FQN="llvm::IRBuilder::CreateLandingPad", NM="_ZN4llvm9IRBuilder16CreateLandingPadEPNS_4TypeEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder16CreateLandingPadEPNS_4TypeEjRKNS_5TwineE")
  //</editor-fold>
  public LandingPadInst /*P*/ CreateLandingPad(Type /*P*/ Ty, /*uint*/int NumClauses) {
    return CreateLandingPad(Ty, NumClauses,
                  new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LandingPadInst /*P*/ CreateLandingPad(Type /*P*/ Ty, /*uint*/int NumClauses,
                  final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Insert$T(LandingPadInst.Create(Ty, NumClauses), Name);
  }


  //===--------------------------------------------------------------------===//
  // Utility creation methods
  //===--------------------------------------------------------------------===//

  /// \brief Return an i1 value testing if \p Arg is null.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateIsNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1664,
   FQN="llvm::IRBuilder::CreateIsNull", NM="_ZN4llvm9IRBuilder12CreateIsNullEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder12CreateIsNullEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateIsNull(Value /*P*/ Arg) {
    return CreateIsNull(Arg, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateIsNull(Value /*P*/ Arg, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmpEQ(Arg, Constant.getNullValue(Arg.getType()),
        Name);
  }


  /// \brief Return an i1 value testing if \p Arg is not null.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateIsNotNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1670,
   FQN="llvm::IRBuilder::CreateIsNotNull", NM="_ZN4llvm9IRBuilder15CreateIsNotNullEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder15CreateIsNotNullEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateIsNotNull(Value /*P*/ Arg) {
    return CreateIsNotNull(Arg, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateIsNotNull(Value /*P*/ Arg, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateICmpNE(Arg, Constant.getNullValue(Arg.getType()),
        Name);
  }


  /// \brief Return the i64 difference between two pointer values, dividing out
  /// the size of the pointed-to objects.
  ///
  /// This is intended to implement C-style pointer subtraction. As such, the
  /// pointers must be appropriately aligned for their element types and
  /// pointing into the same object.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreatePtrDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1681,
   FQN="llvm::IRBuilder::CreatePtrDiff", NM="_ZN4llvm9IRBuilder13CreatePtrDiffEPNS_5ValueES2_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder13CreatePtrDiffEPNS_5ValueES2_RKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreatePtrDiff(Value /*P*/ LHS, Value /*P*/ RHS) {
    return CreatePtrDiff(LHS, RHS, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreatePtrDiff(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (LHS.getType() == RHS.getType()) : "Pointer subtraction operand types must match!";
    PointerType /*P*/ ArgType = cast_PointerType(LHS.getType());
    Value /*P*/ LHS_int = CreatePtrToInt(LHS, Type.getInt64Ty(Context));
    Value /*P*/ RHS_int = CreatePtrToInt(RHS, Type.getInt64Ty(Context));
    Value /*P*/ Difference = CreateSub(LHS_int, RHS_int);
    return CreateExactSDiv(Difference,
        ConstantExpr.getSizeOf(ArgType.getElementType()),
        Name);
  }


  /// \brief Create an invariant.group.barrier intrinsic call, that stops
  /// optimizer to propagate equality using invariant.group metadata.
  /// If Ptr type is different from i8*, it's casted to i8* before call
  /// and casted back to Ptr type after call.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateInvariantGroupBarrier">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1697,
   FQN="llvm::IRBuilder::CreateInvariantGroupBarrier", NM="_ZN4llvm9IRBuilder27CreateInvariantGroupBarrierEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder27CreateInvariantGroupBarrierEPNS_5ValueE")
  //</editor-fold>
  public Value /*P*/ CreateInvariantGroupBarrier(Value /*P*/ Ptr) {
    Module /*P*/ M = BB.getParent().getParent();
    Function /*P*/ FnInvariantGroupBarrier = IntrinsicGlobals.getDeclaration(M,
        ID.invariant_group_barrier);

    Type /*P*/ ArgumentAndReturnType = FnInvariantGroupBarrier.getReturnType();
    assert (ArgumentAndReturnType == FnInvariantGroupBarrier.getFunctionType().getParamType(0)) : "InvariantGroupBarrier should take and return the same type";
    Type /*P*/ PtrType = Ptr.getType();

    boolean PtrTypeConversionNeeded = PtrType != ArgumentAndReturnType;
    if (PtrTypeConversionNeeded) {
      Ptr = CreateBitCast(Ptr, ArgumentAndReturnType);
    }

    CallInst /*P*/ Fn = CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(FnInvariantGroupBarrier, new ArrayRef(Ptr));
    if (PtrTypeConversionNeeded) {
      return CreateBitCast(Fn, PtrType);
    }
    return Fn;
  }


  /// \brief Return a vector value that contains \arg V broadcasted to \p
  /// NumElts elements.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateVectorSplat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1721,
   FQN="llvm::IRBuilder::CreateVectorSplat", NM="_ZN4llvm9IRBuilder17CreateVectorSplatEjPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder17CreateVectorSplatEjPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateVectorSplat(/*uint*/int NumElts, Value /*P*/ V) {
    return CreateVectorSplat(NumElts, V, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateVectorSplat(/*uint*/int NumElts, Value /*P*/ V, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert ($greater_uint(NumElts, 0)) : "Cannot splat to an empty vector!";

    // First insert it into an undef vector so we can shuffle it.
    Type /*P*/ I32Ty = getInt32Ty();
    Value /*P*/ Undef = UndefValue.get(VectorType.get(V.getType(), NumElts));
    V = CreateInsertElement(Undef, V, ConstantInt.get(I32Ty, $int2ulong(0)),
        $add_Twine$C(Name, new Twine(/*KEEP_STR*/".splatinsert")));

    // Shuffle the value across the desired number of elements.
    Value /*P*/ Zeros = ConstantAggregateZero.get(VectorType.get(I32Ty, NumElts));
    return CreateShuffleVector(V, Undef, Zeros, $add_Twine$C(Name, new Twine(/*KEEP_STR*/".splat")));
  }


  /// \brief Return a value that has been extracted from a larger integer type.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateExtractInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1736,
   FQN="llvm::IRBuilder::CreateExtractInteger", NM="_ZN4llvm9IRBuilder20CreateExtractIntegerERKNS_10DataLayoutEPNS_5ValueEPNS_11IntegerTypeEyRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder20CreateExtractIntegerERKNS_10DataLayoutEPNS_5ValueEPNS_11IntegerTypeEyRKNS_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateExtractInteger(final /*const*/ DataLayout /*&*/ DL, Value /*P*/ From,
                      IntegerType /*P*/ ExtractedTy, long/*uint64_t*/ Offset,
                      final /*const*/ Twine /*&*/ Name) {
    IntegerType /*P*/ IntTy = cast_IntegerType(From.getType());
    assert ($lesseq_ullong_ulong(DL.getTypeStoreSize(ExtractedTy) + Offset, DL.getTypeStoreSize(IntTy))) : "Element extends past full value";
    long/*uint64_t*/ ShAmt = $int2ullong(8) * Offset;
    Value /*P*/ V = From;
    if (DL.isBigEndian()) {
      ShAmt = $int2ullong(8) * (DL.getTypeStoreSize(IntTy)
         - DL.getTypeStoreSize(ExtractedTy) - Offset);
    }
    if ((ShAmt != 0)) {
      V = CreateLShr(V, ShAmt, $add_Twine$C(Name, new Twine(/*KEEP_STR*/".shift")));
    }
    assert ($lesseq_uint(ExtractedTy.getBitWidth(), IntTy.getBitWidth())) : "Cannot extract to a larger integer!";
    if (ExtractedTy != IntTy) {
      V = CreateTrunc(V, ExtractedTy, $add_Twine$C(Name, new Twine(/*KEEP_STR*/".trunc")));
    }
    return V;
  }


  /// \brief Create an assume intrinsic call that represents an alignment
  /// assumption on the provided pointer.
  ///
  /// An optional offset can be provided, and if it is provided, the offset
  /// must be subtracted from the provided pointer to get the pointer with the
  /// specified alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRBuilder::CreateAlignmentAssumption">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1765,
   FQN="llvm::IRBuilder::CreateAlignmentAssumption", NM="_ZN4llvm9IRBuilder25CreateAlignmentAssumptionERKNS_10DataLayoutEPNS_5ValueEjS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRBuilder.cpp -nm=_ZN4llvm9IRBuilder25CreateAlignmentAssumptionERKNS_10DataLayoutEPNS_5ValueEjS5_")
  //</editor-fold>
  public CallInst /*P*/ CreateAlignmentAssumption(final /*const*/ DataLayout /*&*/ DL, Value /*P*/ PtrValue,
                           /*uint*/int Alignment) {
    return CreateAlignmentAssumption(DL, PtrValue,
                           Alignment,
                           (Value /*P*/ )null);
  }
  public CallInst /*P*/ CreateAlignmentAssumption(final /*const*/ DataLayout /*&*/ DL, Value /*P*/ PtrValue,
                           /*uint*/int Alignment,
                           Value /*P*/ OffsetValue/*= null*/) {
    assert (isa_PointerType(PtrValue.getType())) : "trying to create an alignment assumption on a non-pointer?";

    PointerType /*P*/ PtrTy = cast_PointerType(PtrValue.getType());
    Type /*P*/ IntPtrTy = getIntPtrTy(DL, PtrTy.getAddressSpace());
    Value /*P*/ PtrIntValue = CreatePtrToInt(PtrValue, IntPtrTy, new Twine("ptrint"));

    Value /*P*/ Mask = ConstantInt.get(IntPtrTy,
        $uint2ulong($greater_uint(Alignment, 0) ? Alignment - 1 : 0));
    if ((OffsetValue != null)) {
      boolean IsOffsetZero = false;
      {
        ConstantInt /*P*/ CI = dyn_cast_ConstantInt(OffsetValue);
        if ((CI != null)) {
          IsOffsetZero = CI.isZero();
        }
      }
      if (!IsOffsetZero) {
        if (OffsetValue.getType() != IntPtrTy) {
          OffsetValue = CreateIntCast(OffsetValue, IntPtrTy, /*isSigned*/ true,
              new Twine("offsetcast"));
        }
        PtrIntValue = CreateSub(PtrIntValue, OffsetValue, new Twine("offsetptr"));
      }
    }

    Value /*P*/ Zero = ConstantInt.get(IntPtrTy, $int2ulong(0));
    Value /*P*/ MaskedPtr = CreateAnd(PtrIntValue, Mask, new Twine("maskedptr"));
    Value /*P*/ InvCond = CreateICmpEQ(MaskedPtr, Zero, new Twine("maskcond"));

    return CreateAssumption(InvCond);
  }

  @Override public String toString() {
    return "" + "Folder=" + Folder // NOI18N
              + super.toString(); // NOI18N
  }
}
