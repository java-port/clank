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


//===----------------------------------------------------------------------===//
//                                ExtractValueInst Class
//===----------------------------------------------------------------------===//

/// ExtractValueInst - This instruction extracts a struct member or array
/// element value from an aggregate value.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2230,
 FQN="llvm::ExtractValueInst", NM="_ZN4llvm16ExtractValueInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInstE")
//</editor-fold>
public class ExtractValueInst extends /*public*/ UnaryInstruction implements Destructors.ClassWithDestructor {
  private SmallVectorUInt Indices;

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::ExtractValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1998,
   FQN="llvm::ExtractValueInst::ExtractValueInst", NM="_ZN4llvm16ExtractValueInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInstC1ERKS0_")
  //</editor-fold>
  private ExtractValueInst(final /*const*/ ExtractValueInst /*&*/ EVI) {
    // : UnaryInstruction(EVI.getType(), ExtractValue, EVI.getOperand(0)), Indices(EVI.Indices)
    //START JInit
    super(EVI.getType(), OtherOps.ExtractValue, EVI.getOperand(0));
    this.Indices = new SmallVectorUInt(EVI.Indices);
    //END JInit
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(EVI.SubclassOptionalData));
  }


  //===----------------------------------------------------------------------===//
  //                             ExtractValueInst Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1987,
   FQN="llvm::ExtractValueInst::init", NM="_ZN4llvm16ExtractValueInst4initENS_8ArrayRefIjEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst4initENS_8ArrayRefIjEERKNS_5TwineE")
  //</editor-fold>
  private void init(ArrayRefUInt Idxs, final /*const*/ Twine /*&*/ Name) {
    assert (getNumOperands() == 1) : "NumOperands not initialized?";

    // There's no fundamental reason why we require at least one index.
    // But there's no present need to support it.
    assert ($greater_uint(Idxs.size(), 0)) : "ExtractValueInst must have at least one index";

    Indices.append_T(Idxs.begin(), Idxs.end());
    setName(Name);
  }


  /// Constructors - Create a extractvalue instruction with a base aggregate
  /// value and a list of indices.  The first ctor can optionally insert before
  /// an existing instruction, the second appends the new instruction to the
  /// specified BasicBlock.
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::ExtractValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2315,
   FQN="llvm::ExtractValueInst::ExtractValueInst", NM="_ZN4llvm16ExtractValueInstC1EPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInstC1EPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private ExtractValueInst(JD$Value$P_ArrayRefUInt_Twine$C_Instruction$P _dparam, Value /*P*/ Agg,
      ArrayRefUInt Idxs,
      final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : UnaryInstruction(checkGEPType(getIndexedType(Agg->getType(), Idxs)), ExtractValue, Agg, InsertBefore), Indices()
    //START JInit
    super(IrLlvmGlobals.checkGEPType(getIndexedType(Agg.getType(), new ArrayRefUInt(Idxs))),
        OtherOps.ExtractValue, Agg, InsertBefore);
    this.Indices = new SmallVectorUInt(4, 0);
    //END JInit
    init(new ArrayRefUInt(Idxs), NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::ExtractValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2323,
   FQN="llvm::ExtractValueInst::ExtractValueInst", NM="_ZN4llvm16ExtractValueInstC1EPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInstC1EPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private ExtractValueInst(JD$Value$P_ArrayRefUInt_Twine$C_BasicBlock$P _dparam, Value /*P*/ Agg,
      ArrayRefUInt Idxs,
      final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    // : UnaryInstruction(checkGEPType(getIndexedType(Agg->getType(), Idxs)), ExtractValue, Agg, InsertAtEnd), Indices()
    //START JInit
    super(IrLlvmGlobals.checkGEPType(getIndexedType(Agg.getType(), new ArrayRefUInt(Idxs))),
        OtherOps.ExtractValue, Agg, InsertAtEnd);
    this.Indices = new SmallVectorUInt(4, 0);
    //END JInit
    init(new ArrayRefUInt(Idxs), NameStr);
  }


  // allocate space for exactly one operand
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2249,
   FQN="llvm::ExtractValueInst::operator new", NM="_ZN4llvm16ExtractValueInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInstnwEj")
  //</editor-fold>
  private static <T extends ExtractValueInst> T/*void P*/ $new_ExtractValueInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */1, $Ctor);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3906,
   FQN="llvm::ExtractValueInst::cloneImpl", NM="_ZNK4llvm16ExtractValueInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst9cloneImplEv")
  //</editor-fold>
  protected ExtractValueInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [ExtractValueInst::new]*/ExtractValueInst.$new_ExtractValueInst((type$ptr<?> New$Mem)->{
        return new ExtractValueInst(/*Deref*/this);
     });
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2257,
   FQN="llvm::ExtractValueInst::Create", NM="_ZN4llvm16ExtractValueInst6CreateEPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst6CreateEPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static ExtractValueInst /*P*/ Create_Value1(Value /*P*/ Agg,
               ArrayRefUInt Idxs) {
    return Create_Value1(Agg,
               Idxs,
               new Twine(/*KEEP_STR*/$EMPTY),
               (Instruction /*P*/ )null);
  }
  public static ExtractValueInst /*P*/ Create_Value1(Value /*P*/ Agg,
               ArrayRefUInt Idxs,
               final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create_Value1(Agg,
               Idxs,
               NameStr,
               (Instruction /*P*/ )null);
  }
  public static ExtractValueInst /*P*/ Create_Value1(Value /*P*/ Agg,
               ArrayRefUInt Idxs,
               final /*const*/ Twine /*&*/ NameStr/*= ""*/,
               Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [ExtractValueInst::new]*/ExtractValueInst.$new_ExtractValueInst((type$ptr<?> New$Mem)->{
        return new ExtractValueInst(JD$Value$P_ArrayRefUInt_Twine$C_Instruction$P.INSTANCE, Agg, new ArrayRefUInt(Idxs), NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2264,
   FQN="llvm::ExtractValueInst::Create", NM="_ZN4llvm16ExtractValueInst6CreateEPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst6CreateEPNS_5ValueENS_8ArrayRefIjEERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static ExtractValueInst /*P*/ Create_Value2(Value /*P*/ Agg,
               ArrayRefUInt Idxs,
               final /*const*/ Twine /*&*/ NameStr,
               BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [ExtractValueInst::new]*/ExtractValueInst.$new_ExtractValueInst((type$ptr<?> New$Mem)->{
        return new ExtractValueInst(JD$Value$P_ArrayRefUInt_Twine$C_BasicBlock$P.INSTANCE, Agg, new ArrayRefUInt(Idxs), NameStr, InsertAtEnd);
     });
  }


  /// getIndexedType - Returns the type of the element that would be extracted
  /// with an extractvalue instruction with the specified parameters.
  ///
  /// Null is returned if the indices are invalid for the specified type.

  // getIndexedType - Returns the type of the element that would be extracted
  // with an extractvalue instruction with the specified parameters.
  //
  // A null type is returned if the indices are invalid for the specified
  // pointer type.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::getIndexedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2010,
   FQN="llvm::ExtractValueInst::getIndexedType", NM="_ZN4llvm16ExtractValueInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst14getIndexedTypeEPNS_4TypeENS_8ArrayRefIjEE")
  //</editor-fold>
  public static Type /*P*/ getIndexedType(Type /*P*/ Agg,
                ArrayRefUInt Idxs) {
    for (/*uint*/int Index : Idxs) {
      {
        // We can't use CompositeType::indexValid(Index) here.
        // indexValid() always returns true for arrays because getelementptr allows
        // out-of-bounds indices. Since we don't allow those for extractvalue and
        // insertvalue we need to check array indexing manually.
        // Since the only other types we can index into are struct types it's just
        // as easy to check those manually as well.
        ArrayType /*P*/ AT = dyn_cast_ArrayType(Agg);
        if ((AT != null)) {
          if ($greatereq_uint_ulong(Index, AT.getNumElements())) {
            return null;
          }
        } else {
          StructType /*P*/ ST = dyn_cast_StructType(Agg);
          if ((ST != null)) {
            if ($greatereq_uint(Index, ST.getNumElements())) {
              return null;
            }
          } else {
            // Not a valid type to index into.
            return null;
          }
        }
      }

      Agg = cast_CompositeType(Agg).getTypeAtIndex(Index);
    }
    return ((/*const_cast*/Type /*P*/ )(Agg));
  }


  // JAVA: typedef const unsigned int *idx_iterator;
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::idx_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2278,
   FQN="llvm::ExtractValueInst::idx_begin", NM="_ZNK4llvm16ExtractValueInst9idx_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst9idx_beginEv")
  //</editor-fold>
  public /*inline*/ /*const*/uint$ptr/*uint P*/ idx_begin() /*const*/ {
    return Indices.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::idx_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2279,
   FQN="llvm::ExtractValueInst::idx_end", NM="_ZNK4llvm16ExtractValueInst7idx_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst7idx_endEv")
  //</editor-fold>
  public /*inline*/ /*const*/uint$ptr/*uint P*/ idx_end() /*const*/ {
    return Indices.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::indices">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2280,
   FQN="llvm::ExtractValueInst::indices", NM="_ZNK4llvm16ExtractValueInst7indicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst7indicesEv")
  //</editor-fold>
  public /*inline*/ iterator_rangeUInt indices() /*const*/ {
    return make_range(idx_begin(), idx_end());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::getAggregateOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2284,
   FQN="llvm::ExtractValueInst::getAggregateOperand", NM="_ZN4llvm16ExtractValueInst19getAggregateOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst19getAggregateOperandEv")
  //</editor-fold>
  public Value /*P*/ getAggregateOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::getAggregateOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2287,
   FQN="llvm::ExtractValueInst::getAggregateOperand", NM="_ZNK4llvm16ExtractValueInst19getAggregateOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst19getAggregateOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getAggregateOperand$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::getAggregateOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2290,
   FQN="llvm::ExtractValueInst::getAggregateOperandIndex", NM="_ZN4llvm16ExtractValueInst24getAggregateOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst24getAggregateOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getAggregateOperandIndex() {
    return 0/*U*/; // get index for modifying correct operand
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::getIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2294,
   FQN="llvm::ExtractValueInst::getIndices", NM="_ZNK4llvm16ExtractValueInst10getIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst10getIndicesEv")
  //</editor-fold>
  public ArrayRefUInt getIndices() /*const*/ {
    return new ArrayRefUInt(Indices);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::getNumIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2298,
   FQN="llvm::ExtractValueInst::getNumIndices", NM="_ZNK4llvm16ExtractValueInst13getNumIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst13getNumIndicesEv")
  //</editor-fold>
  public /*uint*/int getNumIndices() /*const*/ {
    return (/*uint*/int)Indices.size();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::hasIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2302,
   FQN="llvm::ExtractValueInst::hasIndices", NM="_ZNK4llvm16ExtractValueInst10hasIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm16ExtractValueInst10hasIndicesEv")
  //</editor-fold>
  public boolean hasIndices() /*const*/ {
    return true;
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2307,
   FQN="llvm::ExtractValueInst::classof", NM="_ZN4llvm16ExtractValueInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.ExtractValue;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2310,
   FQN="llvm::ExtractValueInst::classof", NM="_ZN4llvm16ExtractValueInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && ExtractValueInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ExtractValueInst::~ExtractValueInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2230,
   FQN="llvm::ExtractValueInst::~ExtractValueInst", NM="_ZN4llvm16ExtractValueInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm16ExtractValueInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Indices.$destroy();
    super.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "Indices=" + Indices // NOI18N
              + super.toString(); // NOI18N
  }
}
