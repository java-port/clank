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


/// GetElementPtrInst - an instruction for type-safe pointer arithmetic to
/// access elements of arrays and structs
///
//<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 829,
 FQN="llvm::GetElementPtrInst", NM="_ZN4llvm17GetElementPtrInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInstE")
//</editor-fold>
public class GetElementPtrInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  private Type /*P*/ SourceElementType;
  private Type /*P*/ ResultElementType;


  //===----------------------------------------------------------------------===//
  //                       GetElementPtrInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1639,
   FQN="llvm::GetElementPtrInst::anchor", NM="_ZN4llvm17GetElementPtrInst6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::GetElementPtrInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1650,
   FQN="llvm::GetElementPtrInst::GetElementPtrInst", NM="_ZN4llvm17GetElementPtrInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInstC1ERKS0_")
  //</editor-fold>
  private GetElementPtrInst(final /*const*/ GetElementPtrInst /*&*/ GEPI) {
    // : Instruction(GEPI.getType(), GetElementPtr, OperandTraits<GetElementPtrInst>::op_end(this) - GEPI.getNumOperands(), GEPI.getNumOperands()), SourceElementType(GEPI.SourceElementType), ResultElementType(GEPI.ResultElementType)
    //START JInit
    super(GEPI.getType(), MemoryOps.GetElementPtr,
        OperandTraitsGetElementPtrInst.<GetElementPtrInst>op_end(User.$BEING_CREATED()/*this*/).$sub(GEPI.getNumOperands()),
        GEPI.getNumOperands());
    this.SourceElementType = GEPI.SourceElementType;
    this.ResultElementType = GEPI.ResultElementType;
    //END JInit
    std.copy(GEPI.op_begin$Const(), GEPI.op_end$Const(), op_begin());
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(GEPI.SubclassOptionalData));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::init">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1641,
   FQN="llvm::GetElementPtrInst::init", NM="_ZN4llvm17GetElementPtrInst4initEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst4initEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineE")
  //</editor-fold>
  private void init(Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList,
      final /*const*/ Twine /*&*/ Name) {
    assert (getNumOperands() == 1 + IdxList.size()) : "NumOperands not initialized?";
    this./*<0>*/Op(0).$assign(Ptr);
    std.copy(IdxList.begin(), IdxList.end(), op_begin().$add(1), (source, dest)->dest.$star().$assign(source.$star()));
    setName(Name);
  }


  /// Constructors - Create a getelementptr instruction with a base pointer an
  /// list of indices. The first ctor can optionally insert before an existing
  /// instruction, the second appends the new instruction to the specified
  /// BasicBlock.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::GetElementPtrInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1055,
   FQN="llvm::GetElementPtrInst::GetElementPtrInst", NM="_ZN4llvm17GetElementPtrInstC1EPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInstC1EPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private GetElementPtrInst(JD$Type$P_Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P _dparam, Type /*P*/ PointeeType, Value /*P*/ Ptr,
      ArrayRef<Value /*P*/ > IdxList, /*uint*/int Values,
      final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : Instruction(getGEPReturnType(PointeeType, Ptr, IdxList), GetElementPtr, OperandTraits<GetElementPtrInst>::op_end(this) - Values, Values, InsertBefore), SourceElementType(PointeeType), ResultElementType(getIndexedType(PointeeType, IdxList))
    //START JInit
    super(GetElementPtrInst.getGEPReturnType(PointeeType, Ptr, new ArrayRef<Value /*P*/ >(IdxList)), MemoryOps.GetElementPtr,
        OperandTraitsGetElementPtrInst.<GetElementPtrInst>op_end(User.$BEING_CREATED()/*this*/).$sub(Values),
        Values, InsertBefore);
    this.SourceElementType = PointeeType;
    this.ResultElementType = getIndexedType_Type$P_ArrayRef$Value$P(PointeeType, new ArrayRef<Value /*P*/ >(IdxList));
    //END JInit
    assert (ResultElementType == cast_PointerType(getType().getScalarType()).getElementType());
    init(Ptr, new ArrayRef<Value /*P*/ >(IdxList), NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::GetElementPtrInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1068,
   FQN="llvm::GetElementPtrInst::GetElementPtrInst", NM="_ZN4llvm17GetElementPtrInstC1EPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInstC1EPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private GetElementPtrInst(JD$Type$P_Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P _dparam, Type /*P*/ PointeeType, Value /*P*/ Ptr,
      ArrayRef<Value /*P*/ > IdxList, /*uint*/int Values,
      final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(getGEPReturnType(PointeeType, Ptr, IdxList), GetElementPtr, OperandTraits<GetElementPtrInst>::op_end(this) - Values, Values, InsertAtEnd), SourceElementType(PointeeType), ResultElementType(getIndexedType(PointeeType, IdxList))
    //START JInit
    super(GetElementPtrInst.getGEPReturnType(PointeeType, Ptr, new ArrayRef<Value /*P*/ >(IdxList)), MemoryOps.GetElementPtr,
        OperandTraitsGetElementPtrInst.<GetElementPtrInst>op_end(User.$BEING_CREATED()/*this*/).$sub(Values),
        Values, InsertAtEnd);
    this.SourceElementType = PointeeType;
    this.ResultElementType = getIndexedType_Type$P_ArrayRef$Value$P(PointeeType, new ArrayRef<Value /*P*/ >(IdxList));
    //END JInit
    assert (ResultElementType == cast_PointerType(getType().getScalarType()).getElementType());
    init(Ptr, new ArrayRef<Value /*P*/ >(IdxList), NameStr);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/

  //===----------------------------------------------------------------------===//
  //                           cloneImpl() implementations
  //===----------------------------------------------------------------------===//

  // Define these methods here so vtables don't get emitted into every translation
  // unit that uses these classes.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3890,
   FQN="llvm::GetElementPtrInst::cloneImpl", NM="_ZNK4llvm17GetElementPtrInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst9cloneImplEv")
  //</editor-fold>
  protected GetElementPtrInst /*P*/ cloneImpl() /*const*/ {
    return ((/*JCast*/GetElementPtrInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new GetElementPtrInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 855,
   FQN="llvm::GetElementPtrInst::Create", NM="_ZN4llvm17GetElementPtrInst6CreateEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst6CreateEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static GetElementPtrInst /*P*/ Create1(Type /*P*/ PointeeType, Value /*P*/ Ptr,
         ArrayRef<Value /*P*/ > IdxList) {
    return Create1(PointeeType, Ptr,
         IdxList,
         new Twine(/*KEEP_STR*/$EMPTY),
         (Instruction /*P*/ )null);
  }
  public static GetElementPtrInst /*P*/ Create1(Type /*P*/ PointeeType, Value /*P*/ Ptr,
         ArrayRef<Value /*P*/ > IdxList,
         final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create1(PointeeType, Ptr,
         IdxList,
         NameStr,
         (Instruction /*P*/ )null);
  }
  public static GetElementPtrInst /*P*/ Create1(Type /*P*/ PointeeType, Value /*P*/ Ptr,
         ArrayRef<Value /*P*/ > IdxList,
         final /*const*/ Twine /*&*/ NameStr/*= ""*/,
         Instruction /*P*/ InsertBefore/*= null*/) {
    /*uint*/int Values = 1 + ((/*uint*/int)(IdxList.size()));
    if (!(PointeeType != null)) {
      PointeeType
         = cast_PointerType(Ptr.getType().getScalarType()).getElementType();
    } else {
      assert (PointeeType == cast_PointerType(Ptr.getType().getScalarType()).getElementType());
    }
    Type $FinalPointeeType = PointeeType;
    return ((/*JCast*/GetElementPtrInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new GetElementPtrInst(JD$Type$P_Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P.INSTANCE, $FinalPointeeType, Ptr, new ArrayRef<Value /*P*/ >(IdxList), Values,
                NameStr, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 870,
   FQN="llvm::GetElementPtrInst::Create", NM="_ZN4llvm17GetElementPtrInst6CreateEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst6CreateEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static GetElementPtrInst /*P*/ Create2(Type /*P*/ PointeeType, Value /*P*/ Ptr,
         ArrayRef<Value /*P*/ > IdxList,
         final /*const*/ Twine /*&*/ NameStr,
         BasicBlock /*P*/ InsertAtEnd) {
    /*uint*/int Values = 1 + ((/*uint*/int)(IdxList.size()));
    if (!(PointeeType != null)) {
      PointeeType
         = cast_PointerType(Ptr.getType().getScalarType()).getElementType();
    } else {
      assert (PointeeType == cast_PointerType(Ptr.getType().getScalarType()).getElementType());
    }
    Type $FinalPointeeType = PointeeType;
    return ((/*JCast*/GetElementPtrInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new GetElementPtrInst(JD$Type$P_Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P.INSTANCE, $FinalPointeeType, Ptr, new ArrayRef<Value /*P*/ >(IdxList), Values,
                NameStr, InsertAtEnd);
     })));
  }


  /// Create an "inbounds" getelementptr. See the documentation for the
  /// "inbounds" flag in LangRef.html for details.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::CreateInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 888,
   FQN="llvm::GetElementPtrInst::CreateInBounds", NM="_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static GetElementPtrInst /*P*/ CreateInBounds1(Value /*P*/ Ptr,
                 ArrayRef<Value /*P*/ > IdxList) {
    return CreateInBounds1(Ptr,
                 IdxList,
                 new Twine(/*KEEP_STR*/$EMPTY),
                 (Instruction /*P*/ )null);
  }
  public static GetElementPtrInst /*P*/ CreateInBounds1(Value /*P*/ Ptr,
                 ArrayRef<Value /*P*/ > IdxList,
                 final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return CreateInBounds1(Ptr,
                 IdxList,
                 NameStr,
                 (Instruction /*P*/ )null);
  }
  public static GetElementPtrInst /*P*/ CreateInBounds1(Value /*P*/ Ptr,
                 ArrayRef<Value /*P*/ > IdxList,
                 final /*const*/ Twine /*&*/ NameStr/*= ""*/,
                 Instruction /*P*/ InsertBefore/*= null*/) {
    return GetElementPtrInst.CreateInBounds2((Type /*P*/ )null, Ptr, new ArrayRef<Value /*P*/ >(IdxList), NameStr, InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::CreateInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 894,
   FQN="llvm::GetElementPtrInst::CreateInBounds", NM="_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static GetElementPtrInst /*P*/ CreateInBounds2(Type /*P*/ PointeeType, Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList) {
    return CreateInBounds2(PointeeType, Ptr, IdxList,
                 new Twine(/*KEEP_STR*/$EMPTY),
                 (Instruction /*P*/ )null);
  }
  public static GetElementPtrInst /*P*/ CreateInBounds2(Type /*P*/ PointeeType, Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList,
                 final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return CreateInBounds2(PointeeType, Ptr, IdxList,
                 NameStr,
                 (Instruction /*P*/ )null);
  }
  public static GetElementPtrInst /*P*/ CreateInBounds2(Type /*P*/ PointeeType, Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList,
                 final /*const*/ Twine /*&*/ NameStr/*= ""*/,
                 Instruction /*P*/ InsertBefore/*= null*/) {
    GetElementPtrInst /*P*/ GEP = GetElementPtrInst.Create1(PointeeType, Ptr, new ArrayRef<Value /*P*/ >(IdxList), NameStr, InsertBefore);
    GEP.setIsInBounds(true);
    return GEP;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::CreateInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 903,
   FQN="llvm::GetElementPtrInst::CreateInBounds", NM="_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static GetElementPtrInst /*P*/ CreateInBounds(Value /*P*/ Ptr,
                ArrayRef<Value /*P*/ > IdxList,
                final /*const*/ Twine /*&*/ NameStr,
                BasicBlock /*P*/ InsertAtEnd) {
    return GetElementPtrInst.CreateInBounds((Type /*P*/ )null, Ptr, new ArrayRef<Value /*P*/ >(IdxList), NameStr, InsertAtEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::CreateInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 909,
   FQN="llvm::GetElementPtrInst::CreateInBounds", NM="_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst14CreateInBoundsEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static GetElementPtrInst /*P*/ CreateInBounds(Type /*P*/ PointeeType, Value /*P*/ Ptr,
                ArrayRef<Value /*P*/ > IdxList,
                final /*const*/ Twine /*&*/ NameStr,
                BasicBlock /*P*/ InsertAtEnd) {
    GetElementPtrInst /*P*/ GEP = GetElementPtrInst.Create2(PointeeType, Ptr, new ArrayRef<Value /*P*/ >(IdxList), NameStr, InsertAtEnd);
    GEP.setIsInBounds(true);
    return GEP;
  }


  /// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::getOperand", NM="_ZNK4llvm17GetElementPtrInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsGetElementPtrInst.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsGetElementPtrInst.op_begin(((/*const_cast*/GetElementPtrInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::setOperand", NM="_ZN4llvm17GetElementPtrInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsGetElementPtrInst.operands(this))) : "setOperand() out of range!";
    OperandTraitsGetElementPtrInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::op_begin", NM="_ZN4llvm17GetElementPtrInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsGetElementPtrInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::op_begin", NM="_ZNK4llvm17GetElementPtrInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsGetElementPtrInst.op_begin(((/*const_cast*/GetElementPtrInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::op_end", NM="_ZN4llvm17GetElementPtrInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsGetElementPtrInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::op_end", NM="_ZNK4llvm17GetElementPtrInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsGetElementPtrInst.op_end(((/*const_cast*/GetElementPtrInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::Op", NM="Tpl__ZN4llvm17GetElementPtrInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm17GetElementPtrInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::Op", NM="Tpl__ZNK4llvm17GetElementPtrInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm17GetElementPtrInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1082,
   FQN="llvm::GetElementPtrInst::getNumOperands", NM="_ZNK4llvm17GetElementPtrInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsGetElementPtrInst.operands(this);
  }


  // getType - Overload to return most specific sequential type.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 923,
   FQN="llvm::GetElementPtrInst::getType", NM="_ZNK4llvm17GetElementPtrInst7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst7getTypeEv")
  //</editor-fold>
  public SequentialType /*P*/ getType() /*const*/ {
    return cast_SequentialType(super.getType());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getSourceElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 927,
   FQN="llvm::GetElementPtrInst::getSourceElementType", NM="_ZNK4llvm17GetElementPtrInst20getSourceElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst20getSourceElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getSourceElementType() /*const*/ {
    return SourceElementType;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::setSourceElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 929,
   FQN="llvm::GetElementPtrInst::setSourceElementType", NM="_ZN4llvm17GetElementPtrInst20setSourceElementTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst20setSourceElementTypeEPNS_4TypeE")
  //</editor-fold>
  public void setSourceElementType(Type /*P*/ Ty) {
    SourceElementType = Ty;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::setResultElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 930,
   FQN="llvm::GetElementPtrInst::setResultElementType", NM="_ZN4llvm17GetElementPtrInst20setResultElementTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst20setResultElementTypeEPNS_4TypeE")
  //</editor-fold>
  public void setResultElementType(Type /*P*/ Ty) {
    ResultElementType = Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getResultElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 932,
   FQN="llvm::GetElementPtrInst::getResultElementType", NM="_ZNK4llvm17GetElementPtrInst20getResultElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst20getResultElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getResultElementType() /*const*/ {
    assert (ResultElementType == cast_PointerType(getType().getScalarType()).getElementType());
    return ResultElementType;
  }


  /// \brief Returns the address space of this instruction's pointer type.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 939,
   FQN="llvm::GetElementPtrInst::getAddressSpace", NM="_ZNK4llvm17GetElementPtrInst15getAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst15getAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getAddressSpace() /*const*/ {
    // Note that this is always the same as the pointer operand's address space
    // and that is cheaper to compute, so cheat here.
    return getPointerAddressSpace();
  }


  /// getIndexedType - Returns the type of the element that would be loaded with
  /// a load instruction with the specified parameters.
  ///
  /// Null is returned if the indices are invalid for the specified
  /// pointer type.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getIndexedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1692,
   FQN="llvm::GetElementPtrInst::getIndexedType", NM="_ZN4llvm17GetElementPtrInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public static Type /*P*/ getIndexedType_Type$P_ArrayRef$Value$P(Type /*P*/ Ty, ArrayRef<Value /*P*/ > IdxList) {
    return InstructionsStatics.getIndexedTypeInternal(Ty, new ArrayRef<Value /*P*/ >(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getIndexedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1696,
   FQN="llvm::GetElementPtrInst::getIndexedType", NM="_ZN4llvm17GetElementPtrInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  public static Type /*P*/ getIndexedType_Type$P_ArrayRef$Constant$P(Type /*P*/ Ty,
                                           ArrayRef<Constant /*P*/ > IdxList) {
    return InstructionsStatics.getIndexedTypeInternal(Ty, new ArrayRef<Constant /*P*/ >(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getIndexedType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1701,
   FQN="llvm::GetElementPtrInst::getIndexedType", NM="_ZN4llvm17GetElementPtrInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIyEE")
  //</editor-fold>
  public static Type /*P*/ getIndexedType(Type /*P*/ Ty, ArrayRefULong IdxList) {
    return InstructionsStatics.getIndexedTypeInternal$ULLong(Ty, new ArrayRefULong(IdxList));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::idx_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 955,
   FQN="llvm::GetElementPtrInst::idx_begin", NM="_ZN4llvm17GetElementPtrInst9idx_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst9idx_beginEv")
  //</editor-fold>
  public /*inline*/ type$ptr<Use /*P*/> idx_begin() {
    return op_begin().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::idx_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 956,
   FQN="llvm::GetElementPtrInst::idx_begin", NM="_ZNK4llvm17GetElementPtrInst9idx_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst9idx_beginEv")
  //</editor-fold>
  public /*inline*/ /*const*/type$ptr<Use /*P*/> idx_begin$Const() /*const*/ {
    return op_begin$Const().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::idx_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 957,
   FQN="llvm::GetElementPtrInst::idx_end", NM="_ZN4llvm17GetElementPtrInst7idx_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst7idx_endEv")
  //</editor-fold>
  public /*inline*/ type$ptr<Use /*P*/> idx_end() {
    return op_end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::idx_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 958,
   FQN="llvm::GetElementPtrInst::idx_end", NM="_ZNK4llvm17GetElementPtrInst7idx_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst7idx_endEv")
  //</editor-fold>
  public /*inline*/ /*const*/type$ptr<Use /*P*/> idx_end$Const() /*const*/ {
    return op_end$Const();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 960,
   FQN="llvm::GetElementPtrInst::getPointerOperand", NM="_ZN4llvm17GetElementPtrInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst17getPointerOperandEv")
  //</editor-fold>
  public Value /*P*/ getPointerOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 963,
   FQN="llvm::GetElementPtrInst::getPointerOperand", NM="_ZNK4llvm17GetElementPtrInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst17getPointerOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getPointerOperand$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getPointerOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 966,
   FQN="llvm::GetElementPtrInst::getPointerOperandIndex", NM="_ZN4llvm17GetElementPtrInst22getPointerOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst22getPointerOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getPointerOperandIndex() {
    return 0/*U*/; // get index for modifying correct operand.
  }


  /// getPointerOperandType - Method to return the pointer operand as a
  /// PointerType.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getPointerOperandType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 972,
   FQN="llvm::GetElementPtrInst::getPointerOperandType", NM="_ZNK4llvm17GetElementPtrInst21getPointerOperandTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst21getPointerOperandTypeEv")
  //</editor-fold>
  public Type /*P*/ getPointerOperandType() /*const*/ {
    return getPointerOperand$Const().getType();
  }


  /// \brief Returns the address space of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getPointerAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 977,
   FQN="llvm::GetElementPtrInst::getPointerAddressSpace", NM="_ZNK4llvm17GetElementPtrInst22getPointerAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst22getPointerAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getPointerAddressSpace() /*const*/ {
    return getPointerOperandType().getPointerAddressSpace();
  }


  /// GetGEPReturnType - Returns the pointer type returned by the GEP
  /// instruction, which may be a vector of pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getGEPReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 983,
   FQN="llvm::GetElementPtrInst::getGEPReturnType", NM="_ZN4llvm17GetElementPtrInst16getGEPReturnTypeEPNS_5ValueENS_8ArrayRefIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst16getGEPReturnTypeEPNS_5ValueENS_8ArrayRefIS2_EE")
  //</editor-fold>
  public static Type /*P*/ getGEPReturnType(Value /*P*/ Ptr, ArrayRef<Value /*P*/ > IdxList) {
    return GetElementPtrInst.getGEPReturnType(cast_PointerType(Ptr.getType().getScalarType()).getElementType(),
        Ptr, new ArrayRef<Value /*P*/ >(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getGEPReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 988,
   FQN="llvm::GetElementPtrInst::getGEPReturnType", NM="_ZN4llvm17GetElementPtrInst16getGEPReturnTypeEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst16getGEPReturnTypeEPNS_4TypeEPNS_5ValueENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public static Type /*P*/ getGEPReturnType(Type /*P*/ ElTy, Value /*P*/ Ptr,
                  ArrayRef<Value /*P*/ > IdxList) {
    Type /*P*/ PtrTy = PointerType.get(IrLlvmGlobals.checkGEPType(getIndexedType_Type$P_ArrayRef$Value$P(ElTy, new ArrayRef<Value /*P*/ >(IdxList))),
        Ptr.getType().getPointerAddressSpace());
    // Vector GEP
    if (Ptr.getType().isVectorTy()) {
      /*uint*/int NumElem = Ptr.getType().getVectorNumElements();
      return VectorType.get(PtrTy, NumElem);
    }
    for (Value /*P*/ Index : IdxList)  {
      if (Index.getType().isVectorTy()) {
        /*uint*/int NumElem = Index.getType().getVectorNumElements();
        return VectorType.get(PtrTy, NumElem);
      }
    }
    // Scalar GEP
    return PtrTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::getNumIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1006,
   FQN="llvm::GetElementPtrInst::getNumIndices", NM="_ZNK4llvm17GetElementPtrInst13getNumIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst13getNumIndicesEv")
  //</editor-fold>
  public /*uint*/int getNumIndices() /*const*/ {
    // Note: always non-negative
    return getNumOperands() - 1;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::hasIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1010,
   FQN="llvm::GetElementPtrInst::hasIndices", NM="_ZNK4llvm17GetElementPtrInst10hasIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst10hasIndicesEv")
  //</editor-fold>
  public boolean hasIndices() /*const*/ {
    return $greater_uint(getNumOperands(), 1);
  }


  /// hasAllZeroIndices - Return true if all of the indices of this GEP are
  /// zeros.  If so, the result pointer and the first operand have the same
  /// value, just potentially different types.

  /// hasAllZeroIndices - Return true if all of the indices of this GEP are
  /// zeros.  If so, the result pointer and the first operand have the same
  /// value, just potentially different types.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::hasAllZeroIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1708,
   FQN="llvm::GetElementPtrInst::hasAllZeroIndices", NM="_ZNK4llvm17GetElementPtrInst17hasAllZeroIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst17hasAllZeroIndicesEv")
  //</editor-fold>
  public boolean hasAllZeroIndices() /*const*/ {
    for (/*uint*/int i = 1, e = getNumOperands(); i != e; ++i) {
      {
        ConstantInt /*P*/ CI = dyn_cast_ConstantInt(getOperand(i));
        if ((CI != null)) {
          if (!CI.isZero()) {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    return true;
  }


  /// hasAllConstantIndices - Return true if all of the indices of this GEP are
  /// constant integers.  If so, the result pointer and the first operand have
  /// a constant offset between them.

  /// hasAllConstantIndices - Return true if all of the indices of this GEP are
  /// constant integers.  If so, the result pointer and the first operand have
  /// a constant offset between them.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::hasAllConstantIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1722,
   FQN="llvm::GetElementPtrInst::hasAllConstantIndices", NM="_ZNK4llvm17GetElementPtrInst21hasAllConstantIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst21hasAllConstantIndicesEv")
  //</editor-fold>
  public boolean hasAllConstantIndices() /*const*/ {
    for (/*uint*/int i = 1, e = getNumOperands(); i != e; ++i) {
      if (!isa_ConstantInt(getOperand(i))) {
        return false;
      }
    }
    return true;
  }


  /// setIsInBounds - Set or clear the inbounds flag on this GEP instruction.
  /// See LangRef.html for the meaning of inbounds on a getelementptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::setIsInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1730,
   FQN="llvm::GetElementPtrInst::setIsInBounds", NM="_ZN4llvm17GetElementPtrInst13setIsInBoundsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst13setIsInBoundsEb")
  //</editor-fold>
  public void setIsInBounds() {
    setIsInBounds(true);
  }
  public void setIsInBounds(boolean B/*= true*/) {
    cast_GEPOperator(this).setIsInBounds(B);
  }


  /// isInBounds - Determine whether the GEP has the inbounds flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::isInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1734,
   FQN="llvm::GetElementPtrInst::isInBounds", NM="_ZNK4llvm17GetElementPtrInst10isInBoundsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst10isInBoundsEv")
  //</editor-fold>
  public boolean isInBounds() /*const*/ {
    return cast_GEPOperator(this).isInBounds();
  }


  /// \brief Accumulate the constant address offset of this GEP if possible.
  ///
  /// This routine accepts an APInt into which it will accumulate the constant
  /// offset of this GEP if the GEP is in fact constant. If the GEP is not
  /// all-constant, it returns false and the value of the offset APInt is
  /// undefined (it is *not* preserved!). The APInt passed into this routine
  /// must be at least as wide as the IntPtr type for the address space of
  /// the base GEP pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::accumulateConstantOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1738,
   FQN="llvm::GetElementPtrInst::accumulateConstantOffset", NM="_ZNK4llvm17GetElementPtrInst24accumulateConstantOffsetERKNS_10DataLayoutERNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17GetElementPtrInst24accumulateConstantOffsetERKNS_10DataLayoutERNS_5APIntE")
  //</editor-fold>
  public boolean accumulateConstantOffset(final /*const*/ DataLayout /*&*/ DL,
                          final APInt /*&*/ Offset) /*const*/ {
    // Delegate to the generic GEPOperator implementation.
    return cast_GEPOperator(this).accumulateConstantOffset(DL, Offset);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1042,
   FQN="llvm::GetElementPtrInst::classof", NM="_ZN4llvm17GetElementPtrInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return (I.getOpcode() == Instruction.MemoryOps.GetElementPtr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1045,
   FQN="llvm::GetElementPtrInst::classof", NM="_ZN4llvm17GetElementPtrInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && GetElementPtrInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrInst::~GetElementPtrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 829,
   FQN="llvm::GetElementPtrInst::~GetElementPtrInst", NM="_ZN4llvm17GetElementPtrInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17GetElementPtrInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "SourceElementType=" + SourceElementType // NOI18N
              + ", ResultElementType=" + ResultElementType // NOI18N
              + super.toString(); // NOI18N
  }
}
