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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clank.support.Native.NativePOD;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.ID;


/// CallArgList - Type for representing both the value and type of
/// arguments in a call.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 56,
 FQN="clang::CodeGen::CallArgList", NM="_ZN5clang7CodeGen11CallArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgListE")
//</editor-fold>
public class CallArgList extends /*public*/ SmallVector<CallArg> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::CallArgList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 59,
   FQN="clang::CodeGen::CallArgList::CallArgList", NM="_ZN5clang7CodeGen11CallArgListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgListC1Ev")
  //</editor-fold>
  public CallArgList() {
    // : SmallVector<CallArg, 16>(), Writebacks(), CleanupsToDeactivate(), StackBase(null), StackCleanup() 
    //START JInit
    super(16, new CallArg());
    this.Writebacks = new SmallVector<Writeback>(1, new Writeback());
    this.CleanupsToDeactivate = new SmallVector<CallArgCleanup>(1, new CallArgCleanup());
    this.StackBase = null;
    this.StackCleanup = new EHScopeStack.stable_iterator();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::Writeback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 61,
   FQN="clang::CodeGen::CallArgList::Writeback", NM="_ZN5clang7CodeGen11CallArgList9WritebackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList9WritebackE")
  //</editor-fold>
  public static class/*struct*/ Writeback implements NativePOD<Writeback>, NativeMoveable<Writeback> {
    /// The original argument.  Note that the argument l-value
    /// is potentially null.
    public LValue Source;
    
    /// The temporary alloca.
    public Address Temporary;
    
    /// A value to "use" after the writeback, or null.
    public Value /*P*/ ToUse;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::Writeback::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 61,
     FQN="clang::CodeGen::CallArgList::Writeback::operator=", NM="_ZN5clang7CodeGen11CallArgList9WritebackaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList9WritebackaSERKS2_")
    //</editor-fold>
    public /*inline*/ Writeback /*&*/ $assign(final /*const*/ Writeback /*&*/ $Prm0) {
      this.Source.$assign($Prm0.Source);
      this.Temporary.$assign($Prm0.Temporary);
      this.ToUse = $Prm0.ToUse;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::Writeback::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 61,
     FQN="clang::CodeGen::CallArgList::Writeback::operator=", NM="_ZN5clang7CodeGen11CallArgList9WritebackaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList9WritebackaSEOS2_")
    //</editor-fold>
    public /*inline*/ Writeback /*&*/ $assignMove(final Writeback /*&&*/$Prm0) {
      this.Source.$assignMove($Prm0.Source);
      this.Temporary.$assignMove($Prm0.Temporary);
      this.ToUse = $Prm0.ToUse;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::Writeback::Writeback">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 61,
     FQN="clang::CodeGen::CallArgList::Writeback::Writeback", NM="_ZN5clang7CodeGen11CallArgList9WritebackC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList9WritebackC1EOS2_")
    //</editor-fold>
    public /*inline*/ Writeback(JD$Move _dparam, final Writeback /*&&*/$Prm0) {
      // : Source(static_cast<Writeback &&>().Source), Temporary(static_cast<Writeback &&>().Temporary), ToUse(static_cast<Writeback &&>().ToUse) 
      //START JInit
      this.Source = new LValue(JD$Move.INSTANCE, $Prm0.Source);
      this.Temporary = new Address(JD$Move.INSTANCE, $Prm0.Temporary);
      this.ToUse = $Prm0.ToUse;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Writeback() { 
      this.Source = new LValue();
      this.Temporary = new Address();
      this.ToUse = null;
    }
    
    public Writeback(LValue Source, Address Temporary, Value ToUse) {
      this.Source = new LValue(Source);
      this.Temporary = new Address(Temporary);
      this.ToUse = ToUse;
    }

    @Override public Writeback clone() {
      return new Writeback(this.Source, this.Temporary, this.ToUse);
    }

    @Override public Writeback move() {
      return new Writeback(JD$Move.INSTANCE, this);
    }
  
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Source=" + Source // NOI18N
                + ", Temporary=" + Temporary // NOI18N
                + ", ToUse=" + ToUse; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::CallArgCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 73,
   FQN="clang::CodeGen::CallArgList::CallArgCleanup", NM="_ZN5clang7CodeGen11CallArgList14CallArgCleanupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList14CallArgCleanupE")
  //</editor-fold>
  public static class/*struct*/ CallArgCleanup implements NativePOD<CallArgCleanup>, NativeMoveable<CallArgCleanup> {
    public EHScopeStack.stable_iterator Cleanup;
    
    /// The "is active" insertion point.  This instruction is temporary and
    /// will be removed after insertion.
    public Instruction /*P*/ IsActiveIP;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::CallArgCleanup::CallArgCleanup">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 73,
     FQN="clang::CodeGen::CallArgList::CallArgCleanup::CallArgCleanup", NM="_ZN5clang7CodeGen11CallArgList14CallArgCleanupC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList14CallArgCleanupC1Ev")
    //</editor-fold>
    public /*inline*/ CallArgCleanup() {
      // : Cleanup() 
      //START JInit
      this.Cleanup = new EHScopeStack.stable_iterator();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::CallArgCleanup::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 73,
     FQN="clang::CodeGen::CallArgList::CallArgCleanup::operator=", NM="_ZN5clang7CodeGen11CallArgList14CallArgCleanupaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList14CallArgCleanupaSEOS2_")
    //</editor-fold>
    public /*inline*/ CallArgCleanup /*&*/ $assignMove(final CallArgCleanup /*&&*/$Prm0) {
      this.Cleanup.$assignMove($Prm0.Cleanup);
      this.IsActiveIP = $Prm0.IsActiveIP;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::CallArgCleanup::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 73,
     FQN="clang::CodeGen::CallArgList::CallArgCleanup::operator=", NM="_ZN5clang7CodeGen11CallArgList14CallArgCleanupaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen11CallArgList14CallArgCleanupaSERKS2_")
    //</editor-fold>
    public /*inline*/ CallArgCleanup /*&*/ $assign(final /*const*/ CallArgCleanup /*&*/ $Prm0) {
      this.Cleanup.$assign($Prm0.Cleanup);
      this.IsActiveIP = $Prm0.IsActiveIP;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public CallArgCleanup clone() {
      return new CallArgCleanup().$assign(this);
    }

    @Override public CallArgCleanup move() {
      return new CallArgCleanup().$assignMove(this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////  

    @Override public String toString() {
      return "" + "Cleanup=" + Cleanup // NOI18N
                + ", IsActiveIP=" + IsActiveIP; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 81,
   FQN="clang::CodeGen::CallArgList::add", NM="_ZN5clang7CodeGen11CallArgList3addENS0_6RValueENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList3addENS0_6RValueENS_8QualTypeEb")
  //</editor-fold>
  public void add(RValue rvalue, QualType type) {
    add(rvalue, type, false);
  }
  public void add(RValue rvalue, QualType type, boolean needscopy/*= false*/) {
    push_back(new CallArg(new RValue(rvalue), new QualType(type), needscopy));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::addFrom">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 85,
   FQN="clang::CodeGen::CallArgList::addFrom", NM="_ZN5clang7CodeGen11CallArgList7addFromERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList7addFromERKS1_")
  //</editor-fold>
  public void addFrom(final /*const*/ CallArgList /*&*/ other) {
    insert(end(), other.begin$Const(), other.end$Const());
    Writebacks.insert(Writebacks.end(), 
        other.Writebacks.begin$Const(), other.Writebacks.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::addWriteback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 91,
   FQN="clang::CodeGen::CallArgList::addWriteback", NM="_ZN5clang7CodeGen11CallArgList12addWritebackENS0_6LValueENS0_7AddressEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList12addWritebackENS0_6LValueENS0_7AddressEPN4llvm5ValueE")
  //</editor-fold>
  public void addWriteback(LValue srcLV, Address temporary, 
              Value /*P*/ toUse) {
    Writeback writeback = new Writeback(srcLV, temporary, toUse);
    Writebacks.push_back(writeback);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::hasWritebacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 97,
   FQN="clang::CodeGen::CallArgList::hasWritebacks", NM="_ZNK5clang7CodeGen11CallArgList13hasWritebacksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen11CallArgList13hasWritebacksEv")
  //</editor-fold>
  public boolean hasWritebacks() /*const*/ {
    return !Writebacks.empty();
  }

  
  // JAVA: typedef llvm::iterator_range<SmallVectorImpl<Writeback>::const_iterator> writeback_const_range
//  public final class writeback_const_range extends iterator_range</*const*/ Writeback>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::writebacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 102,
   FQN="clang::CodeGen::CallArgList::writebacks", NM="_ZNK5clang7CodeGen11CallArgList10writebacksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen11CallArgList10writebacksEv")
  //</editor-fold>
  public iterator_range</*const*/ Writeback> writebacks() /*const*/ {
    return new iterator_range</*const*/ Writeback>(Writebacks.begin$Const(), Writebacks.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::addArgCleanupDeactivation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 106,
   FQN="clang::CodeGen::CallArgList::addArgCleanupDeactivation", NM="_ZN5clang7CodeGen11CallArgList25addArgCleanupDeactivationENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList25addArgCleanupDeactivationENS0_12EHScopeStack15stable_iteratorEPN4llvm11InstructionE")
  //</editor-fold>
  public void addArgCleanupDeactivation(EHScopeStack.stable_iterator Cleanup, 
                           Instruction /*P*/ IsActiveIP) {
    CallArgCleanup ArgCleanup/*J*/= new CallArgCleanup();
    ArgCleanup.Cleanup.$assign(Cleanup);
    ArgCleanup.IsActiveIP = IsActiveIP;
    CleanupsToDeactivate.push_back(ArgCleanup);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::getCleanupsToDeactivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 114,
   FQN="clang::CodeGen::CallArgList::getCleanupsToDeactivate", NM="_ZNK5clang7CodeGen11CallArgList23getCleanupsToDeactivateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen11CallArgList23getCleanupsToDeactivateEv")
  //</editor-fold>
  public ArrayRef<CallArgCleanup> getCleanupsToDeactivate() /*const*/ {
    return new ArrayRef<CallArgCleanup>(CleanupsToDeactivate, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::allocateArgumentMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3132,
   FQN="clang::CodeGen::CallArgList::allocateArgumentMemory", NM="_ZN5clang7CodeGen11CallArgList22allocateArgumentMemoryERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgList22allocateArgumentMemoryERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public void allocateArgumentMemory(final CodeGenFunction /*&*/ CGF) {
    assert (!(StackBase != null) && !StackCleanup.isValid());
    
    // Save the stack.
    Function /*P*/ F = CGF.CGM.getIntrinsic(ID.stacksave);
    StackBase = CGF.Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(true)/* }*/, new Twine(/*KEEP_STR*/"inalloca.save"));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::getStackBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 119,
   FQN="clang::CodeGen::CallArgList::getStackBase", NM="_ZNK5clang7CodeGen11CallArgList12getStackBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen11CallArgList12getStackBaseEv")
  //</editor-fold>
  public Instruction /*P*/ getStackBase() /*const*/ {
    return StackBase;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::freeArgumentMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3140,
   FQN="clang::CodeGen::CallArgList::freeArgumentMemory", NM="_ZNK5clang7CodeGen11CallArgList18freeArgumentMemoryERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen11CallArgList18freeArgumentMemoryERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public void freeArgumentMemory(final CodeGenFunction /*&*/ CGF) /*const*/ {
    if ((StackBase != null)) {
      // Restore the stack after the call.
      Value /*P*/ F = CGF.CGM.getIntrinsic(ID.stackrestore);
      CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(StackBase, true));
    }
  }

  
  /// \brief Returns if we're using an inalloca struct to pass arguments in
  /// memory.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::isUsingInAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 124,
   FQN="clang::CodeGen::CallArgList::isUsingInAlloca", NM="_ZNK5clang7CodeGen11CallArgList15isUsingInAllocaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen11CallArgList15isUsingInAllocaEv")
  //</editor-fold>
  public boolean isUsingInAlloca() /*const*/ {
    return (StackBase != null);
  }

/*private:*/
  private SmallVector<Writeback> Writebacks;
  
  /// Deactivate these cleanups immediately before making the call.  This
  /// is used to cleanup objects that are owned by the callee once the call
  /// occurs.
  private SmallVector<CallArgCleanup> CleanupsToDeactivate;
  
  /// The stacksave call.  It dominates all of the argument evaluation.
  private CallInst /*P*/ StackBase;
  
  /// The iterator pointing to the stack restore cleanup.  We manually run and
  /// deactivate this cleanup after the call in the unexceptional case because
  /// it doesn't run in the normal order.
  private EHScopeStack.stable_iterator StackCleanup;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::CallArgList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 56,
   FQN="clang::CodeGen::CallArgList::CallArgList", NM="_ZN5clang7CodeGen11CallArgListC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgListC1EOS1_")
  //</editor-fold>
  public /*inline*/ CallArgList(JD$Move _dparam, final CallArgList /*&&*/$Prm0) {
    // : SmallVector<CallArg, 16>(static_cast<CallArgList &&>()), Writebacks(static_cast<CallArgList &&>().Writebacks), CleanupsToDeactivate(static_cast<CallArgList &&>().CleanupsToDeactivate), StackBase(static_cast<CallArgList &&>().StackBase), StackCleanup(static_cast<CallArgList &&>().StackCleanup) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.Writebacks = new SmallVector<Writeback>(JD$Move.INSTANCE, $Prm0.Writebacks);
    this.CleanupsToDeactivate = new SmallVector<CallArgCleanup>(JD$Move.INSTANCE, $Prm0.CleanupsToDeactivate);
    this.StackBase = $Prm0.StackBase;
    this.StackCleanup = new EHScopeStack.stable_iterator(JD$Move.INSTANCE, $Prm0.StackCleanup);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 56,
   FQN="clang::CodeGen::CallArgList::operator=", NM="_ZN5clang7CodeGen11CallArgListaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgListaSEOS1_")
  //</editor-fold>
  public /*inline*/ CallArgList /*&*/ $assignMove(final CallArgList /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    this.Writebacks.$assignMove($Prm0.Writebacks);
    this.CleanupsToDeactivate.$assignMove($Prm0.CleanupsToDeactivate);
    this.StackBase = $Prm0.StackBase;
    this.StackCleanup.$assignMove($Prm0.StackCleanup);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::~CallArgList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 56,
   FQN="clang::CodeGen::CallArgList::~CallArgList", NM="_ZN5clang7CodeGen11CallArgListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen11CallArgListD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy_CallArgList() {
    //START JDestroy
    CleanupsToDeactivate.$destroy();
    Writebacks.$destroy();
    super.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArgList::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 56,
   FQN="clang::CodeGen::CallArgList::operator=", NM="_ZN5clang7CodeGen11CallArgListaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen11CallArgListaSERKS1_")
  //</editor-fold>
  public /*inline*/ CallArgList /*&*/ $assign(final /*const*/ CallArgList /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    this.Writebacks.$assign($Prm0.Writebacks);
    this.CleanupsToDeactivate.$assign($Prm0.CleanupsToDeactivate);
    this.StackBase = $Prm0.StackBase;
    this.StackCleanup.$assign($Prm0.StackCleanup);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public CallArgList clone() {
    return new CallArgList().$assign(this);
  }
  
  @Override public CallArgList move() {
    return new CallArgList(JD$Move.INSTANCE, this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + "Writebacks=" + Writebacks // NOI18N
              + ", CleanupsToDeactivate=" + CleanupsToDeactivate // NOI18N
              + ", StackBase=" + StackBase // NOI18N
              + ", StackCleanup=" + StackCleanup // NOI18N
              + super.toString(); // NOI18N
  }
}
