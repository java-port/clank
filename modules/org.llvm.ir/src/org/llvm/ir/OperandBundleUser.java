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
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.java.*;


/// \brief A mixin to add operand bundle functionality to llvm instruction
/// classes.
///
/// OperandBundleUser uses the descriptor area co-allocated with the host User
/// to store some meta information about which operands are "normal" operands,
/// and which ones belong to some operand bundle.
///
/// The layout of an operand bundle user is
///
///          +-----------uint32_t End-------------------------------------+
///          |                                                            |
///          |  +--------uint32_t Begin--------------------+              |
///          |  |                                          |              |
///          ^  ^                                          v              v
///  |------|------|----|----|----|----|----|---------|----|---------|----|-----
///  | BOI0 | BOI1 | .. | DU | U0 | U1 | .. | BOI0_U0 | .. | BOI1_U0 | .. | Un
///  |------|------|----|----|----|----|----|---------|----|---------|----|-----
///   v  v                                  ^              ^
///   |  |                                  |              |
///   |  +--------uint32_t Begin------------+              |
///   |                                                    |
///   +-----------uint32_t End-----------------------------+
///
///
/// BOI0, BOI1 ... are descriptions of operand bundles in this User's use list.
/// These descriptions are installed and managed by this class, and they're all
/// instances of OperandBundleUser<T>::BundleOpInfo.
///
/// DU is an additional descriptor installed by User's 'operator new' to keep
/// track of the 'BOI0 ... BOIN' co-allocation.  OperandBundleUser does not
/// access or modify DU in any way, it's an implementation detail private to
/// User.
///
/// The regular Use& vector for the User starts at U0.  The operand bundle uses
/// are part of the Use& vector, just like normal uses.  In the diagram above,
/// the operand bundle uses start at BOI0_U0.  Each instance of BundleOpInfo has
/// information about a contiguous set of uses constituting an operand bundle,
/// and the total set of operand bundle uses themselves form a contiguous set of
/// uses (i.e. there are no gaps between uses corresponding to individual
/// operand bundles).
///
/// This class does not know the location of the set of operand bundle uses
/// within the use list -- that is decided by the User using this class via the
/// BeginIdx argument in populateBundleOperandInfos.
///
/// Currently operand bundle users with hung-off operands are not supported.
/*template <typename InstrTy, typename OpIteratorTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1316,
 FQN="llvm::OperandBundleUser", NM="_ZN4llvm17OperandBundleUserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleUserE")
//</editor-fold>
public interface/*class*/ OperandBundleUser</*typename*/ InstrTy extends Instruction & CallOrInvokeInst, /*typename*/ OpIteratorTy extends type$ptr<Use>>  {
/*public:*/
  /// \brief Return the number of operand bundles associated with this User.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getNumOperandBundles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1319,
   FQN="llvm::OperandBundleUser::getNumOperandBundles", NM="_ZNK4llvm17OperandBundleUser20getNumOperandBundlesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser20getNumOperandBundlesEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getNumOperandBundles() /*const*/ {
    return std.distance(bundle_op_info_begin(), bundle_op_info_end());
  }


  /// \brief Return true if this User has any operand bundles.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::hasOperandBundles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1324,
   FQN="llvm::OperandBundleUser::hasOperandBundles", NM="_ZNK4llvm17OperandBundleUser17hasOperandBundlesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser17hasOperandBundlesEv")
  //</editor-fold>
  public default/*interface*/ boolean hasOperandBundles() /*const*/ {
    return Native.$noteq(this.getNumOperandBundles(), 0);
  }


  /// \brief Return the index of the first bundle operand in the Use array.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getBundleOperandsStartIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1327,
   FQN="llvm::OperandBundleUser::getBundleOperandsStartIndex", NM="_ZNK4llvm17OperandBundleUser27getBundleOperandsStartIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser27getBundleOperandsStartIndexEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getBundleOperandsStartIndex() /*const*/ {
    assert Native.$bool(this.hasOperandBundles()) : "Don't call otherwise!";
    return bundle_op_info_begin().$star().Begin;
  }


  /// \brief Return the index of the last bundle operand in the Use array.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getBundleOperandsEndIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1333,
   FQN="llvm::OperandBundleUser::getBundleOperandsEndIndex", NM="_ZNK4llvm17OperandBundleUser25getBundleOperandsEndIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser25getBundleOperandsEndIndexEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getBundleOperandsEndIndex() /*const*/ {
    assert Native.$bool(this.hasOperandBundles()) : "Don't call otherwise!";
    return bundle_op_info_end().$at(-1).End;
  }


  /// \brief Return the total number operands (not operand bundles) used by
  /// every operand bundle in this OperandBundleUser.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getNumTotalBundleOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1340,
   FQN="llvm::OperandBundleUser::getNumTotalBundleOperands", NM="_ZNK4llvm17OperandBundleUser25getNumTotalBundleOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser25getNumTotalBundleOperandsEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getNumTotalBundleOperands() /*const*/ {
    if (Native.$not(this.hasOperandBundles())) {
      return 0;
    }

    /*uint*/int Begin = this.getBundleOperandsStartIndex();
    /*uint*/int End = this.getBundleOperandsEndIndex();
    assert ($lesseq_uint(Begin, End)) : "Should be!";
    return End - Begin;
  }


  /// \brief Return the operand bundle at a specific index.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getOperandBundleAt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1352,
   FQN="llvm::OperandBundleUser::getOperandBundleAt", NM="_ZNK4llvm17OperandBundleUser18getOperandBundleAtEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser18getOperandBundleAtEj")
  //</editor-fold>
  public default/*interface*/ OperandBundleUse getOperandBundleAt(/*uint*/int Index) /*const*/ {
    assert Native.$bool(Native.$less(Index, this.getNumOperandBundles())) : "Index out of bounds!";
    return this.operandBundleFromBundleOpInfo($Deref((Native.$add(bundle_op_info_begin(), Index))));
  }


  /// \brief Return the number of operand bundles with the tag Name attached to
  /// this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::countOperandBundlesOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1359,
   FQN="llvm::OperandBundleUser::countOperandBundlesOfType", NM="_ZNK4llvm17OperandBundleUser25countOperandBundlesOfTypeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser25countOperandBundlesOfTypeENS_9StringRefE")
  //</editor-fold>
  public default/*interface*/ /*uint*/int countOperandBundlesOfType(StringRef Name) /*const*/ {
    /*uint*/int Count = 0;
    for (/*uint*/int i = 0, e = this.getNumOperandBundles(); i != e; ++i)  {
      if (Native.$eq(this.getOperandBundleAt(i).getTagName(), Name)) {
        Count++;
      }
    }

    return Count;
  }


  /// \brief Return the number of operand bundles with the tag ID attached to
  /// this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::countOperandBundlesOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1370,
   FQN="llvm::OperandBundleUser::countOperandBundlesOfType", NM="_ZNK4llvm17OperandBundleUser25countOperandBundlesOfTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser25countOperandBundlesOfTypeEj")
  //</editor-fold>
  public default/*interface*/ /*uint*/int countOperandBundlesOfType(/*uint32_t*/int ID) /*const*/ {
    /*uint*/int Count = 0;
    for (/*uint*/int i = 0, e = this.getNumOperandBundles(); i != e; ++i)  {
      if (Native.$eq(this.getOperandBundleAt(i).getTagID(), ID)) {
        Count++;
      }
    }

    return Count;
  }


  /// \brief Return an operand bundle by name, if present.
  ///
  /// It is an error to call this for operand bundle types that may have
  /// multiple instances of them on the same instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getOperandBundle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1383,
   FQN="llvm::OperandBundleUser::getOperandBundle", NM="_ZNK4llvm17OperandBundleUser16getOperandBundleENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser16getOperandBundleENS_9StringRefE")
  //</editor-fold>
  public default/*interface*/ Optional<OperandBundleUse> getOperandBundle(StringRef Name) /*const*/ {
    assert Native.$bool(Native.$less(countOperandBundlesOfType(Name), 2)) : "Precondition violated!";

    for (/*uint*/int i = 0, e = this.getNumOperandBundles(); i != e; ++i) {
      OperandBundleUse U = this.getOperandBundleAt(i);
      if ($eq_StringRef(U.getTagName(), /*NO_COPY*/Name)) {
        return new Optional<OperandBundleUse>(JD$T$RR.INSTANCE, U);
      }
    }

    return new Optional<OperandBundleUse>(None);
  }


  /// \brief Return an operand bundle by tag ID, if present.
  ///
  /// It is an error to call this for operand bundle types that may have
  /// multiple instances of them on the same instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getOperandBundle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1399,
   FQN="llvm::OperandBundleUser::getOperandBundle", NM="_ZNK4llvm17OperandBundleUser16getOperandBundleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser16getOperandBundleEj")
  //</editor-fold>
  public default/*interface*/ Optional<OperandBundleUse> getOperandBundle(/*uint32_t*/int ID) /*const*/ {
    assert Native.$bool(Native.$less(countOperandBundlesOfType(ID), 2)) : "Precondition violated!";

    for (/*uint*/int i = 0, e = this.getNumOperandBundles(); i != e; ++i) {
      OperandBundleUse U = this.getOperandBundleAt(i);
      if (U.getTagID() == ID) {
        return new Optional<OperandBundleUse>(JD$T$RR.INSTANCE, U);
      }
    }

    return new Optional<OperandBundleUse>(None);
  }


  /// \brief Return the list of operand bundles attached to this instruction as
  /// a vector of OperandBundleDefs.
  ///
  /// This function copies the OperandBundeUse instances associated with this
  /// OperandBundleUser to a vector of OperandBundleDefs.  Note:
  /// OperandBundeUses and OperandBundleDefs are non-trivially *different*
  /// representations of operand bundles (see documentation above).
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getOperandBundlesAsDefs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1418,
   FQN="llvm::OperandBundleUser::getOperandBundlesAsDefs", NM="_ZNK4llvm17OperandBundleUser23getOperandBundlesAsDefsERNS_15SmallVectorImplINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp -nm=_ZNK4llvm17OperandBundleUser23getOperandBundlesAsDefsERNS_15SmallVectorImplINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public default/*interface*/ void getOperandBundlesAsDefs(final SmallVectorImpl<OperandBundleDefT<Value /*P*/ > > /*&*/ Defs) /*const*/ {
    for (/*uint*/int i = 0, e = this.getNumOperandBundles(); i != e; ++i)  {
      Defs.emplace_back(new OperandBundleDefT<Value /*P*/ >(this.getOperandBundleAt(i), (Use U) -> U.$Value$P()));
    }
  }


  /// \brief Return the operand bundle for the operand at index OpIdx.
  ///
  /// It is an error to call this with an OpIdx that does not correspond to an
  /// bundle operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getOperandBundleForOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1427,
   FQN="llvm::OperandBundleUser::getOperandBundleForOperand", NM="_ZNK4llvm17OperandBundleUser26getOperandBundleForOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser26getOperandBundleForOperandEj")
  //</editor-fold>
  public default/*interface*/ OperandBundleUse getOperandBundleForOperand(/*uint*/int OpIdx) /*const*/ {
    return this.operandBundleFromBundleOpInfo(this.getBundleOpInfoForOperand(OpIdx));
  }


  /// \brief Return true if this operand bundle user has operand bundles that
  /// may read from the heap.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::hasReadingOperandBundles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1433,
   FQN="llvm::OperandBundleUser::hasReadingOperandBundles", NM="_ZNK4llvm17OperandBundleUser24hasReadingOperandBundlesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser24hasReadingOperandBundlesEv")
  //</editor-fold>
  public default/*interface*/ boolean hasReadingOperandBundles() /*const*/ {
    // Implementation note: this is a conservative implementation of operand
    // bundle semantics, where *any* operand bundle forces a callsite to be at
    // least readonly.
    return this.hasOperandBundles();
  }


  /// \brief Return true if this operand bundle user has operand bundles that
  /// may write to the heap.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::hasClobberingOperandBundles">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1442,
   FQN="llvm::OperandBundleUser::hasClobberingOperandBundles", NM="_ZNK4llvm17OperandBundleUser27hasClobberingOperandBundlesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser27hasClobberingOperandBundlesEv")
  //</editor-fold>
  public default/*interface*/ boolean hasClobberingOperandBundles() /*const*/ {
    for (final BundleOpInfo /*&*/ BOI : bundle_op_infos()) {
      if (Native.$bool(Native.$eq(BOI.Tag.second, LLVMContext.Unnamed_enum1.OB_deopt))
         || Native.$bool(Native.$eq(BOI.Tag.second, LLVMContext.Unnamed_enum1.OB_funclet))) {
        continue;
      }

      // This instruction has an operand bundle that is not known to us.
      // Assume the worst.
      return true;
    }

    return false;
  }


  /// \brief Return true if the bundle operand at index \p OpIdx has the
  /// attribute \p A.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::bundleOperandHasAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1458,
   FQN="llvm::OperandBundleUser::bundleOperandHasAttr", NM="_ZNK4llvm17OperandBundleUser20bundleOperandHasAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser20bundleOperandHasAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public default/*interface*/ boolean bundleOperandHasAttr(/*uint*/int OpIdx, Attribute.AttrKind A) /*const*/ {
    final BundleOpInfo /*&*/ BOI = this.getBundleOpInfoForOperand(OpIdx);
    /*<dependent type>*/OperandBundleUse OBU = this.operandBundleFromBundleOpInfo(BOI);
    return OBU.operandHasAttr(OpIdx - BOI.Begin, A);
  }


  /// \brief Return true if \p Other has the same sequence of operand bundle
  /// tags with the same number of operands on each one of them as this
  /// OperandBundleUser.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::hasIdenticalOperandBundleSchema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1467,
   FQN="llvm::OperandBundleUser::hasIdenticalOperandBundleSchema", NM="_ZNK4llvm17OperandBundleUser31hasIdenticalOperandBundleSchemaERKNS_17OperandBundleUserIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser31hasIdenticalOperandBundleSchemaERKNS_17OperandBundleUserIT_T0_EE")
  //</editor-fold>
  public default/*interface*/ boolean hasIdenticalOperandBundleSchema(final /*const*/ OperandBundleUser<InstrTy, OpIteratorTy> /*&*/ Other) /*const*/ {
    if (Native.$noteq(this.getNumOperandBundles(), Other.getNumOperandBundles())) {
      return false;
    }

    return std.equal(bundle_op_info_begin(), bundle_op_info_end(),
        Other.bundle_op_info_begin());
  }


  /// \brief Return true if this operand bundle user contains operand bundles
  /// with tags other than those specified in \p IDs.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::hasOperandBundlesOtherThan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1478,
   FQN="llvm::OperandBundleUser::hasOperandBundlesOtherThan", NM="_ZNK4llvm17OperandBundleUser26hasOperandBundlesOtherThanENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser26hasOperandBundlesOtherThanENS_8ArrayRefIjEE")
  //</editor-fold>
  public default/*interface*/ boolean hasOperandBundlesOtherThan(ArrayRefUInt IDs) /*const*/ {
    for (/*uint*/int i = 0, e = this.getNumOperandBundles(); i != e; ++i) {
      /*uint32_t*/int ID = this.getOperandBundleAt(i).getTagID();
      if ($eq_ptr(std.find(IDs.begin(), IDs.end(), ID), IDs.end())) {
        return true;
      }
    }
    return false;
  }

/*protected:*/
  /// \brief Is the function attribute S disallowed by some operand bundle on
  /// this operand bundle user?
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::isFnAttrDisallowedByOpBundle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1490,
   FQN="llvm::OperandBundleUser::isFnAttrDisallowedByOpBundle", NM="_ZNK4llvm17OperandBundleUser28isFnAttrDisallowedByOpBundleENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser28isFnAttrDisallowedByOpBundleENS_9StringRefE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ boolean isFnAttrDisallowedByOpBundle(StringRef S) /*const*/ {
    // Operand bundles only possibly disallow readnone, readonly and argmenonly
    // attributes.  All String attributes are fine.
    return false;
  }


  /// \brief Is the function attribute A disallowed by some operand bundle on
  /// this operand bundle user?
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::isFnAttrDisallowedByOpBundle">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1498,
   FQN="llvm::OperandBundleUser::isFnAttrDisallowedByOpBundle", NM="_ZNK4llvm17OperandBundleUser28isFnAttrDisallowedByOpBundleENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser28isFnAttrDisallowedByOpBundleENS_9Attribute8AttrKindE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ boolean isFnAttrDisallowedByOpBundle(Attribute.AttrKind A) /*const*/ {
    switch (A) {
     default:
      return false;
     case ArgMemOnly:
      return this.hasReadingOperandBundles();
     case ReadNone:
      return this.hasReadingOperandBundles();
     case ReadOnly:
      return this.hasClobberingOperandBundles();
    }
    //throw new llvm_unreachable("switch has a default case!");
  }


  /// \brief Used to keep track of an operand bundle.  See the main comment on
  /// OperandBundleUser above.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::BundleOpInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1518,
   FQN="llvm::OperandBundleUser::BundleOpInfo", NM="_ZN4llvm17OperandBundleUser12BundleOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleUser12BundleOpInfoE")
  //</editor-fold>
  public/*protected*/ static class/*struct*/ BundleOpInfo implements Native.NativeComparable<BundleOpInfo> {
    /// \brief The operand bundle tag, interned by
    /// LLVMContextImpl::getOrInsertBundleTag.
    public StringMapEntryUInt /*P*/ Tag;

    /// \brief The index in the Use& vector where operands for this operand
    /// bundle starts.
    public /*uint32_t*/int Begin;

    /// \brief The index in the Use& vector where operands for this operand
    /// bundle ends.
    public /*uint32_t*/int End;

    //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::BundleOpInfo::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1531,
     FQN="llvm::OperandBundleUser::BundleOpInfo::operator==", NM="_ZNK4llvm17OperandBundleUser12BundleOpInfoeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser12BundleOpInfoeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ BundleOpInfo /*&*/ Other) /*const*/ {
      return Native.$bool(Native.$bool(Native.$eq(Tag, Other.Tag)) && Native.$bool(Native.$eq(Begin, Other.Begin))) && Native.$bool(Native.$eq(End, Other.End));
    }


    @Override public String toString() {
      return "" + "Tag=" + Tag // NOI18N
                + ", Begin=" + Begin // NOI18N
                + ", End=" + End; // NOI18N
    }
  };

  /// \brief Simple helper function to map a BundleOpInfo to an
  /// OperandBundleUse.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::operandBundleFromBundleOpInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1538,
   FQN="llvm::OperandBundleUser::operandBundleFromBundleOpInfo", NM="_ZNK4llvm17OperandBundleUser29operandBundleFromBundleOpInfoERKNS0_12BundleOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser29operandBundleFromBundleOpInfoERKNS0_12BundleOpInfoE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ OperandBundleUse operandBundleFromBundleOpInfo(final /*const*/ BundleOpInfo /*&*/ BOI) /*const*/ {
    /*<dependent type>*//*auto*/type$ptr<Use> op_begin = ((/*static_cast*//*const*/ InstrTy /*P*/ )(this)).op_begin();
    ArrayRef<Use> Inputs/*J*/= /*ParenList*/new ArrayRef<Use>(Native.$add(op_begin, BOI.Begin), Native.$add(op_begin, BOI.End), false);
    return new OperandBundleUse(BOI.Tag, Inputs);
  }


  // JAVA: typedef BundleOpInfo *bundle_op_iterator
//  public final class bundle_op_iterator extends BundleOpInfo /*P*/ { };
  // JAVA: typedef const BundleOpInfo *const_bundle_op_iterator
//  public final class const_bundle_op_iterator extends /*const*/ BundleOpInfo /*P*/ { };

  /// \brief Return the start of the list of BundleOpInfo instances associated
  /// with this OperandBundleUser.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::bundle_op_info_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1550,
   FQN="llvm::OperandBundleUser::bundle_op_info_begin", NM="_ZN4llvm17OperandBundleUser20bundle_op_info_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleUser20bundle_op_info_beginEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ type$ptr<BundleOpInfo /*P*/ > bundle_op_info_begin() {
    if (Native.$not(((/*static_cast*/InstrTy /*P*/ )(this)).hasDescriptor())) {
      return null;
    }
    Object/*uint8_t*//*P*/ BytesBegin = ((/*static_cast*/InstrTy /*P*/ )(this)).getDescriptor().begin();
    return ((type$ptr<BundleOpInfo /*P*/ >)reinterpret_cast(type$ptr.class, BytesBegin));
  }


  /// \brief Return the start of the list of BundleOpInfo instances associated
  /// with this OperandBundleUser.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::bundle_op_info_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1560,
   FQN="llvm::OperandBundleUser::bundle_op_info_begin", NM="_ZNK4llvm17OperandBundleUser20bundle_op_info_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser20bundle_op_info_beginEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ type$ptr</*const*/ BundleOpInfo /*P*/ > bundle_op_info_begin$Const() /*const*/ {
    OperandBundleUser<InstrTy, OpIteratorTy> /*P*/ NonConstThis = ((/*const_cast*/OperandBundleUser<InstrTy, OpIteratorTy> /*P*/ )(this));
    return NonConstThis.bundle_op_info_begin();
  }


  /// \brief Return the end of the list of BundleOpInfo instances associated
  /// with this OperandBundleUser.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::bundle_op_info_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1568,
   FQN="llvm::OperandBundleUser::bundle_op_info_end", NM="_ZN4llvm17OperandBundleUser18bundle_op_info_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleUser18bundle_op_info_endEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ type$ptr<BundleOpInfo /*P*/ > bundle_op_info_end() {
    if (Native.$not(((/*static_cast*/InstrTy /*P*/ )(this)).hasDescriptor())) {
      return null;
    }

    Object/*uint8_t*//*P*/ BytesEnd = ((/*static_cast*/InstrTy /*P*/ )(this)).getDescriptor().end();
    return ((type$ptr<BundleOpInfo /*P*/ >)reinterpret_cast(type$ptr.class, BytesEnd));
  }


  /// \brief Return the end of the list of BundleOpInfo instances associated
  /// with this OperandBundleUser.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::bundle_op_info_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1578,
   FQN="llvm::OperandBundleUser::bundle_op_info_end", NM="_ZNK4llvm17OperandBundleUser18bundle_op_info_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser18bundle_op_info_endEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ type$ptr</*const*/ BundleOpInfo /*P*/ > bundle_op_info_end$Const() /*const*/ {
    OperandBundleUser<InstrTy, OpIteratorTy> /*P*/ NonConstThis = ((/*const_cast*/OperandBundleUser<InstrTy, OpIteratorTy> /*P*/ )(this));
    return NonConstThis.bundle_op_info_end();
  }


  /// \brief Return the range [\p bundle_op_info_begin, \p bundle_op_info_end).
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::bundle_op_infos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1585,
   FQN="llvm::OperandBundleUser::bundle_op_infos", NM="_ZN4llvm17OperandBundleUser15bundle_op_infosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleUser15bundle_op_infosEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ iterator_range<BundleOpInfo> bundle_op_infos() {
    return make_range(bundle_op_info_begin(), bundle_op_info_end());
  }


  /// \brief Return the range [\p bundle_op_info_begin, \p bundle_op_info_end).
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::bundle_op_infos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1590,
   FQN="llvm::OperandBundleUser::bundle_op_infos", NM="_ZNK4llvm17OperandBundleUser15bundle_op_infosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser15bundle_op_infosEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ iterator_range</*const*/ BundleOpInfo> bundle_op_infos$Const() /*const*/ {
    return make_range(bundle_op_info_begin(), bundle_op_info_end());
  }


  /// \brief Populate the BundleOpInfo instances and the Use& vector from \p
  /// Bundles.  Return the op_iterator pointing to the Use& one past the last
  /// last bundle operand use.
  ///
  /// Each \p OperandBundleDef instance is tracked by a OperandBundleInfo
  /// instance allocated in this User's descriptor.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::populateBundleOperandInfos">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1600,
   FQN="llvm::OperandBundleUser::populateBundleOperandInfos", NM="_ZN4llvm17OperandBundleUser26populateBundleOperandInfosENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleUser26populateBundleOperandInfosENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEEj")
  //</editor-fold>
  public/*protected*/ default/*interface*/ OpIteratorTy populateBundleOperandInfos(ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
                            /*const*//*uint*/int BeginIndex) {
    if( true ) {
      throw new UnsupportedOperationException("EmptyBody");
    }
    /*<dependent type>*/type$ptr<Use> It = Native.$add(((/*static_cast*/InstrTy /*P*/ )(this)).op_begin(), BeginIndex);
    for (final /*const*/ OperandBundleDefT<Value /*P*/ > /*&*/ B : Bundles)  {
      It = std.copy(B.input_begin(), B.input_end(), It, (source, dest)->dest.$star().$assign(source.$star()));
    }

    LLVMContextImpl /*P*/ ContextImpl = ((/*static_cast*/InstrTy /*P*/ )(this)).getContext().pImpl;
    type$ptr</*const*/ OperandBundleDefT<Value /*P*/ > /*P*/ > BI = $tryClone(Bundles.begin());
    /*uint*/int CurrentIndex = BeginIndex;

    for (final BundleOpInfo /*&*/ BOI : bundle_op_infos()) {
      assert ($noteq_ptr(BI, Bundles.end())) : "Incorrect allocation?";

      BOI.Tag = ContextImpl.getOrInsertBundleTag(BI./*->*/$star().getTag());
      BOI.Begin = CurrentIndex;
      BOI.End = CurrentIndex + BI./*->*/$star().input_size();
      CurrentIndex = BOI.End;
      BI.$postInc();
    }
    assert ($eq_ptr(BI, Bundles.end())) : "Incorrect allocation?";

    return (OpIteratorTy) It;
  }


  /// \brief Return the BundleOpInfo for the operand at index OpIdx.
  ///
  /// It is an error to call this with an OpIdx that does not correspond to an
  /// bundle operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::getBundleOpInfoForOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1629,
   FQN="llvm::OperandBundleUser::getBundleOpInfoForOperand", NM="_ZNK4llvm17OperandBundleUser25getBundleOpInfoForOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZNK4llvm17OperandBundleUser25getBundleOpInfoForOperandEj")
  //</editor-fold>
  public/*protected*/ default/*interface*/ /*const*/ BundleOpInfo /*&*/ getBundleOpInfoForOperand(/*uint*/int OpIdx) /*const*/ {
    for (final BundleOpInfo /*&*/ BOI : bundle_op_infos())  {
      if (Native.$bool(Native.$lesseq(BOI.Begin, OpIdx)) && Native.$bool(Native.$less(OpIdx, BOI.End))) {
        return BOI;
      }
    }
    throw new llvm_unreachable("Did not find operand bundle for operand!");
  }


  /// \brief Return the total number of values used in \p Bundles.
  //<editor-fold defaultstate="collapsed" desc="llvm::OperandBundleUser::CountBundleInputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1638,
   FQN="llvm::OperandBundleUser::CountBundleInputs", NM="_ZN4llvm17OperandBundleUser17CountBundleInputsENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm17OperandBundleUser17CountBundleInputsENS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public/*protected*/ /*interface*/ static </*typename*/ InstrTy, /*typename*/ OpIteratorTy> /*uint*/int CountBundleInputs(ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles) {
    /*uint*/int Total = 0;
    for (final /*const*/ OperandBundleDefT<Value /*P*/ > /*&*/ B : Bundles)  {
      Total += B.input_size();
    }
    return Total;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  default void $OperandBundleUser() {}
  default void $destroy$OperandBundleUser() {}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

}
