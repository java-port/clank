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


/// \brief A lightweight accessor for an operand bundle meant to be passed
/// around by value.
//<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1189,
 FQN="llvm::OperandBundleUse", NM="_ZN4llvm16OperandBundleUseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm16OperandBundleUseE")
//</editor-fold>
public class/*struct*/ OperandBundleUse {
  public ArrayRef<Use> Inputs;

  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::OperandBundleUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1192,
   FQN="llvm::OperandBundleUse::OperandBundleUse", NM="_ZN4llvm16OperandBundleUseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm16OperandBundleUseC1Ev")
  //</editor-fold>
  public OperandBundleUse() {
    // : Inputs()
    //START JInit
    this.Inputs = new ArrayRef<Use>(false);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::OperandBundleUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1193,
   FQN="llvm::OperandBundleUse::OperandBundleUse", NM="_ZN4llvm16OperandBundleUseC1EPNS_14StringMapEntryIjEENS_8ArrayRefINS_3UseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm16OperandBundleUseC1EPNS_14StringMapEntryIjEENS_8ArrayRefINS_3UseEEE")
  //</editor-fold>
  public /*explicit*/ OperandBundleUse(StringMapEntryUInt /*P*/ Tag, ArrayRef<Use> Inputs) {
    // : Inputs(Inputs), Tag(Tag)
    //START JInit
    this.Inputs = new ArrayRef<Use>(Inputs);
    this.Tag = Tag;
    //END JInit
  }


  /// \brief Return true if the operand at index \p Idx in this operand bundle
  /// has the attribute A.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::operandHasAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1198,
   FQN="llvm::OperandBundleUse::operandHasAttr", NM="_ZNK4llvm16OperandBundleUse14operandHasAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm16OperandBundleUse14operandHasAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean operandHasAttr(/*uint*/int Idx, Attribute.AttrKind A) /*const*/ {
    if (isDeoptOperandBundle()) {
      if (A == Attribute.AttrKind.ReadOnly || A == Attribute.AttrKind.NoCapture) {
        return Inputs.$at(Idx).$arrow$Const().getType().isPointerTy();
      }
    }

    // Conservative answer:  no operands have any attributes.
    return false;
  }


  /// \brief Return the tag of this operand bundle as a string.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::getTagName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1208,
   FQN="llvm::OperandBundleUse::getTagName", NM="_ZNK4llvm16OperandBundleUse10getTagNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm16OperandBundleUse10getTagNameEv")
  //</editor-fold>
  public StringRef getTagName() /*const*/ {
    return Tag.getKey();
  }


  /// \brief Return the tag of this operand bundle as an integer.
  ///
  /// Operand bundle tags are interned by LLVMContextImpl::getOrInsertBundleTag,
  /// and this function returns the unique integer getOrInsertBundleTag
  /// associated the tag of this operand bundle to.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::getTagID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1217,
   FQN="llvm::OperandBundleUse::getTagID", NM="_ZNK4llvm16OperandBundleUse8getTagIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm16OperandBundleUse8getTagIDEv")
  //</editor-fold>
  public /*uint32_t*/int getTagID() /*const*/ {
    return Tag.getValue();
  }


  /// \brief Return true if this is a "deopt" operand bundle.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::isDeoptOperandBundle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1222,
   FQN="llvm::OperandBundleUse::isDeoptOperandBundle", NM="_ZNK4llvm16OperandBundleUse20isDeoptOperandBundleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm16OperandBundleUse20isDeoptOperandBundleEv")
  //</editor-fold>
  public boolean isDeoptOperandBundle() /*const*/ {
    return getTagID() == LLVMContext.Unnamed_enum1.OB_deopt.getValue();
  }


  /// \brief Return true if this is a "funclet" operand bundle.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::isFuncletOperandBundle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1227,
   FQN="llvm::OperandBundleUse::isFuncletOperandBundle", NM="_ZNK4llvm16OperandBundleUse22isFuncletOperandBundleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm16OperandBundleUse22isFuncletOperandBundleEv")
  //</editor-fold>
  public boolean isFuncletOperandBundle() /*const*/ {
    return getTagID() == LLVMContext.Unnamed_enum1.OB_funclet.getValue();
  }

/*private:*/
  /// \brief Pointer to an entry in LLVMContextImpl::getOrInsertBundleTag.
  private StringMapEntryUInt /*P*/ Tag;
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUse::OperandBundleUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1189,
   FQN="llvm::OperandBundleUse::OperandBundleUse", NM="_ZN4llvm16OperandBundleUseC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm16OperandBundleUseC1EOS0_")
  //</editor-fold>
  public /*inline*/ OperandBundleUse(JD$Move _dparam, final OperandBundleUse /*&&*/$Prm0) {
    // : Inputs(static_cast<OperandBundleUse &&>().Inputs), Tag(static_cast<OperandBundleUse &&>().Tag)
    //START JInit
    this.Inputs = new ArrayRef<Use>(JD$Move.INSTANCE, $Prm0.Inputs);
    this.Tag = $Prm0.Tag;
    //END JInit
  }


  @Override public String toString() {
    return "" + "Inputs=" + Inputs // NOI18N
              + ", Tag=" + Tag; // NOI18N
  }
}
