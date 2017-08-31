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


/// This is an important class for using LLVM in a threaded context.  It
/// (opaquely) owns and manages the core "global" data of LLVM's core
/// infrastructure, including the type and constant uniquing tables.
/// LLVMContext itself provides no locking guarantees, so you should be careful
/// to have one context per thread.
//<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 43,
 FQN="llvm::LLVMContext", NM="_ZN4llvm11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContextE")
//</editor-fold>
public class LLVMContext implements LLVMOpaqueContext, Destructors.ClassWithDestructor {
/*public:*/
  public LLVMContextImpl /*P*/ /*const*/ pImpl;
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::LLVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 35,
   FQN="llvm::LLVMContext::LLVMContext", NM="_ZN4llvm11LLVMContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContextC1Ev")
  //</editor-fold>
  public LLVMContext() {
    // : pImpl(new LLVMContextImpl(*this))
    //START JInit
    this.pImpl = new LLVMContextImpl(/*Deref*/this);
    //END JInit
    // Create the fixed metadata kinds. This is done in the same order as the
    // MD_* enum values so that they correspond.

    // Create the 'dbg' metadata kind.
    /*uint*/int DbgID = getMDKindID(new StringRef(/*KEEP_STR*/"dbg"));
    assert (DbgID == Unnamed_enum.MD_dbg.getValue()) : "dbg kind id drifted";
    ///*J:(void)*/DbgID;

    // Create the 'tbaa' metadata kind.
    /*uint*/int TBAAID = getMDKindID(new StringRef(/*KEEP_STR*/"tbaa"));
    assert (TBAAID == Unnamed_enum.MD_tbaa.getValue()) : "tbaa kind id drifted";
    ///*J:(void)*/TBAAID;

    // Create the 'prof' metadata kind.
    /*uint*/int ProfID = getMDKindID(new StringRef(/*KEEP_STR*/"prof"));
    assert (ProfID == Unnamed_enum.MD_prof.getValue()) : "prof kind id drifted";
    ///*J:(void)*/ProfID;

    // Create the 'fpmath' metadata kind.
    /*uint*/int FPAccuracyID = getMDKindID(new StringRef(/*KEEP_STR*/"fpmath"));
    assert (FPAccuracyID == Unnamed_enum.MD_fpmath.getValue()) : "fpmath kind id drifted";
    ///*J:(void)*/FPAccuracyID;

    // Create the 'range' metadata kind.
    /*uint*/int RangeID = getMDKindID(new StringRef(/*KEEP_STR*/"range"));
    assert (RangeID == Unnamed_enum.MD_range.getValue()) : "range kind id drifted";
    ///*J:(void)*/RangeID;

    // Create the 'tbaa.struct' metadata kind.
    /*uint*/int TBAAStructID = getMDKindID(new StringRef(/*KEEP_STR*/"tbaa.struct"));
    assert (TBAAStructID == Unnamed_enum.MD_tbaa_struct.getValue()) : "tbaa.struct kind id drifted";
    ///*J:(void)*/TBAAStructID;

    // Create the 'invariant.load' metadata kind.
    /*uint*/int InvariantLdId = getMDKindID(new StringRef(/*KEEP_STR*/"invariant.load"));
    assert (InvariantLdId == Unnamed_enum.MD_invariant_load.getValue()) : "invariant.load kind id drifted";
    ///*J:(void)*/InvariantLdId;

    // Create the 'alias.scope' metadata kind.
    /*uint*/int AliasScopeID = getMDKindID(new StringRef(/*KEEP_STR*/"alias.scope"));
    assert (AliasScopeID == Unnamed_enum.MD_alias_scope.getValue()) : "alias.scope kind id drifted";
    ///*J:(void)*/AliasScopeID;

    // Create the 'noalias' metadata kind.
    /*uint*/int NoAliasID = getMDKindID(new StringRef(/*KEEP_STR*/"noalias"));
    assert (NoAliasID == Unnamed_enum.MD_noalias.getValue()) : "noalias kind id drifted";
    ///*J:(void)*/NoAliasID;

    // Create the 'nontemporal' metadata kind.
    /*uint*/int NonTemporalID = getMDKindID(new StringRef(/*KEEP_STR*/"nontemporal"));
    assert (NonTemporalID == Unnamed_enum.MD_nontemporal.getValue()) : "nontemporal kind id drifted";
    ///*J:(void)*/NonTemporalID;

    // Create the 'llvm.mem.parallel_loop_access' metadata kind.
    /*uint*/int MemParallelLoopAccessID = getMDKindID(new StringRef(/*KEEP_STR*/"llvm.mem.parallel_loop_access"));
    assert (MemParallelLoopAccessID == Unnamed_enum.MD_mem_parallel_loop_access.getValue()) : "mem_parallel_loop_access kind id drifted";
    ///*J:(void)*/MemParallelLoopAccessID;

    // Create the 'nonnull' metadata kind.
    /*uint*/int NonNullID = getMDKindID(new StringRef(/*KEEP_STR*/$nonnull));
    assert (NonNullID == Unnamed_enum.MD_nonnull.getValue()) : "nonnull kind id drifted";
    ///*J:(void)*/NonNullID;

    // Create the 'dereferenceable' metadata kind.
    /*uint*/int DereferenceableID = getMDKindID(new StringRef(/*KEEP_STR*/"dereferenceable"));
    assert (DereferenceableID == Unnamed_enum.MD_dereferenceable.getValue()) : "dereferenceable kind id drifted";
    ///*J:(void)*/DereferenceableID;

    // Create the 'dereferenceable_or_null' metadata kind.
    /*uint*/int DereferenceableOrNullID = getMDKindID(new StringRef(/*KEEP_STR*/"dereferenceable_or_null"));
    assert (DereferenceableOrNullID == Unnamed_enum.MD_dereferenceable_or_null.getValue()) : "dereferenceable_or_null kind id drifted";
    ///*J:(void)*/DereferenceableOrNullID;

    // Create the 'make.implicit' metadata kind.
    /*uint*/int MakeImplicitID = getMDKindID(new StringRef(/*KEEP_STR*/"make.implicit"));
    assert (MakeImplicitID == Unnamed_enum.MD_make_implicit.getValue()) : "make.implicit kind id drifted";
    ///*J:(void)*/MakeImplicitID;

    // Create the 'unpredictable' metadata kind.
    /*uint*/int UnpredictableID = getMDKindID(new StringRef(/*KEEP_STR*/"unpredictable"));
    assert (UnpredictableID == Unnamed_enum.MD_unpredictable.getValue()) : "unpredictable kind id drifted";
    ///*J:(void)*/UnpredictableID;

    // Create the 'invariant.group' metadata kind.
    /*uint*/int InvariantGroupId = getMDKindID(new StringRef(/*KEEP_STR*/"invariant.group"));
    assert (InvariantGroupId == Unnamed_enum.MD_invariant_group.getValue()) : "invariant.group kind id drifted";
    ///*J:(void)*/InvariantGroupId;

    // Create the 'align' metadata kind.
    /*uint*/int AlignID = getMDKindID(new StringRef(/*KEEP_STR*/"align"));
    assert (AlignID == Unnamed_enum.MD_align.getValue()) : "align kind id drifted";
    ///*J:(void)*/AlignID;

    // Create the 'llvm.loop' metadata kind.
    /*uint*/int LoopID = getMDKindID(new StringRef(/*KEEP_STR*/"llvm.loop"));
    assert (LoopID == Unnamed_enum.MD_loop.getValue()) : "llvm.loop kind id drifted";
    ///*J:(void)*/LoopID;

    /*uint*/int TypeID = getMDKindID(new StringRef(/*KEEP_STR*/"type"));
    assert (TypeID == Unnamed_enum.MD_type.getValue()) : "type kind id drifted";
    ///*J:(void)*/TypeID;

    StringMapEntryUInt/*P*/ DeoptEntry = pImpl.getOrInsertBundleTag(new StringRef(/*KEEP_STR*/"deopt"));
    assert (DeoptEntry.second == LLVMContext.Unnamed_enum1.OB_deopt.getValue()) : "deopt operand bundle id drifted!";
    ///*J:(void)*/DeoptEntry;

    StringMapEntryUInt/*P*/ FuncletEntry = pImpl.getOrInsertBundleTag(new StringRef(/*KEEP_STR*/"funclet"));
    assert (FuncletEntry.second == LLVMContext.Unnamed_enum1.OB_funclet.getValue()) : "funclet operand bundle id drifted!";
    ///*J:(void)*/FuncletEntry;

    StringMapEntryUInt/*P*/ GCTransitionEntry = pImpl.getOrInsertBundleTag(new StringRef(/*KEEP_STR*/"gc-transition"));
    assert (GCTransitionEntry.second == LLVMContext.Unnamed_enum1.OB_gc_transition.getValue()) : "gc-transition operand bundle id drifted!";
    ///*J:(void)*/GCTransitionEntry;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::~LLVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 157,
   FQN="llvm::LLVMContext::~LLVMContext", NM="_ZN4llvm11LLVMContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)pImpl);
  }


  // Pinned metadata names, which always have the same value.  This is a
  // compile-time performance optimization, not a correctness optimization.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 51,
   FQN="llvm::LLVMContext::(anonymous)", NM="_ZN4llvm11LLVMContextE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContextE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.NativeUIntEnum {
    MD_dbg(0), // "dbg"
    MD_tbaa(1), // "tbaa"
    MD_prof(2), // "prof"
    MD_fpmath(3), // "fpmath"
    MD_range(4), // "range"
    MD_tbaa_struct(5), // "tbaa.struct"
    MD_invariant_load(6), // "invariant.load"
    MD_alias_scope(7), // "alias.scope"
    MD_noalias(8), // "noalias",
    MD_nontemporal(9), // "nontemporal"
    MD_mem_parallel_loop_access(10), // "llvm.mem.parallel_loop_access"
    MD_nonnull(11), // "nonnull"
    MD_dereferenceable(12), // "dereferenceable"
    MD_dereferenceable_or_null(13), // "dereferenceable_or_null"
    MD_make_implicit(14), // "make.implicit"
    MD_unpredictable(15), // "unpredictable"
    MD_invariant_group(16), // "invariant.group"
    MD_align(17), // "align"
    MD_loop(18), // "llvm.loop"
    MD_type(19); // "type"

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  /// Known operand bundle tag IDs, which always have the same value.  All
  /// operand bundle tags that LLVM has special knowledge of are listed here.
  /// Additionally, this scheme allows LLVM to efficiently check for specific
  /// operand bundle tags without comparing strings.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 78,
   FQN="llvm::LLVMContext::(anonymous)", NM="_ZN4llvm11LLVMContextE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContextE_Unnamed_enum1")
  //</editor-fold>
  public enum Unnamed_enum1 implements Native.NativeUIntEnum {
    OB_deopt(0), // "deopt"
    OB_funclet(1), // "funclet"
    OB_gc_transition(2); // "gc-transition"

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum1 valueOf(int val) {
      Unnamed_enum1 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum1[] VALUES;
      private static final Unnamed_enum1[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum1[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum1[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum1(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  /// getMDKindID - Return a unique non-zero ID for the specified metadata kind.
  /// This ID is uniqued across modules in the current LLVMContext.

  //===----------------------------------------------------------------------===//
  // Metadata Kind Uniquing
  //===----------------------------------------------------------------------===//

  /// Return a unique non-zero ID for the specified metadata kind.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getMDKindID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 289,
   FQN="llvm::LLVMContext::getMDKindID", NM="_ZNK4llvm11LLVMContext11getMDKindIDENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext11getMDKindIDENS_9StringRefE")
  //</editor-fold>
  public /*uint*/int getMDKindID(StringRef Name) /*const*/ {
    // If this is new, assign it its ID.
    return pImpl.CustomMDKindNames.insert(std.make_pair_T_uint($Clone(Name), pImpl.CustomMDKindNames.size())).
        first.$arrow().second;
  }


  /// getMDKindNames - Populate client supplied SmallVector with the name for
  /// custom metadata IDs registered in this LLVMContext.

  /// getHandlerNames - Populate client-supplied smallvector using custom
  /// metadata name and ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getMDKindNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 299,
   FQN="llvm::LLVMContext::getMDKindNames", NM="_ZNK4llvm11LLVMContext14getMDKindNamesERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext14getMDKindNamesERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public void getMDKindNames(final SmallVectorImpl<StringRef> /*&*/ Names) /*const*/ {
    Names.resize(pImpl.CustomMDKindNames.size());
    for (StringMapIteratorUInt I = new StringMapIteratorUInt(JD$Move.INSTANCE, pImpl.CustomMDKindNames.begin()),
        E = new StringMapIteratorUInt(JD$Move.INSTANCE, pImpl.CustomMDKindNames.end()); I.$noteq(E); I.$preInc())  {
      Names.$at(I.$arrow().second).$assignMove(I.$arrow().first());
    }
  }


  /// getOperandBundleTags - Populate client supplied SmallVector with the
  /// bundle tags registered in this LLVMContext.  The bundle tags are ordered
  /// by increasing bundle IDs.
  /// \see LLVMContext::getOperandBundleTagID
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getOperandBundleTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 306,
   FQN="llvm::LLVMContext::getOperandBundleTags", NM="_ZNK4llvm11LLVMContext20getOperandBundleTagsERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext20getOperandBundleTagsERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public void getOperandBundleTags(final SmallVectorImpl<StringRef> /*&*/ Tags) /*const*/ {
    pImpl.getOperandBundleTags(Tags);
  }


  /// getOperandBundleTagID - Maps a bundle tag to an integer ID.  Every bundle
  /// tag registered with an LLVMContext has an unique ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getOperandBundleTagID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 310,
   FQN="llvm::LLVMContext::getOperandBundleTagID", NM="_ZNK4llvm11LLVMContext21getOperandBundleTagIDENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext21getOperandBundleTagIDENS_9StringRefE")
  //</editor-fold>
  public /*uint32_t*/int getOperandBundleTagID(StringRef Tag) /*const*/ {
    return pImpl.getOperandBundleTagID(new StringRef(Tag));
  }


  /// Define the GC for a function
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::setGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 314,
   FQN="llvm::LLVMContext::setGC", NM="_ZN4llvm11LLVMContext5setGCERKNS_8FunctionESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext5setGCERKNS_8FunctionESs")
  //</editor-fold>
  public void setGC(final /*const*/ Function /*&*/ Fn, std.string GCName) {
    DenseMapIterator</*const*/ Function /*P*/ , std.string> It = pImpl.GCNames.find($AddrOf(Fn));
    if (It.$eq(/*NO_ITER_COPY*/pImpl.GCNames.end())) {
      pImpl.GCNames.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T($AddrOf(Fn), $Move(std.move(GCName))));
      return;
    }
    It.$arrow().second.$assignMove(std.move(GCName));
  }


  /// Return the GC for a function
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 324,
   FQN="llvm::LLVMContext::getGC", NM="_ZN4llvm11LLVMContext5getGCERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext5getGCERKNS_8FunctionE")
  //</editor-fold>
  public /*const*/std.string/*&*/ getGC(final /*const*/ Function /*&*/ Fn) {
    return pImpl.GCNames.$at_T1$RR($AddrOf(Fn));
  }


  /// Remove the GC for a function
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::deleteGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 328,
   FQN="llvm::LLVMContext::deleteGC", NM="_ZN4llvm11LLVMContext8deleteGCERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext8deleteGCERKNS_8FunctionE")
  //</editor-fold>
  public void deleteGC(final /*const*/ Function /*&*/ Fn) {
    pImpl.GCNames.erase($AddrOf(Fn));
  }


  /// Return true if the Context runtime configuration is set to discard all
  /// value names. When true, only GlobalValue names will be available in the
  /// IR.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::shouldDiscardValueNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 332,
   FQN="llvm::LLVMContext::shouldDiscardValueNames", NM="_ZNK4llvm11LLVMContext23shouldDiscardValueNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext23shouldDiscardValueNamesEv")
  //</editor-fold>
  public boolean shouldDiscardValueNames() /*const*/ {
    return pImpl.DiscardValueNames;
  }


  /// Set the Context runtime configuration to discard all value name (but
  /// GlobalValue). Clients can use this flag to save memory and runtime,
  /// especially in release mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::setDiscardValueNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 347,
   FQN="llvm::LLVMContext::setDiscardValueNames", NM="_ZN4llvm11LLVMContext20setDiscardValueNamesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext20setDiscardValueNamesEb")
  //</editor-fold>
  public void setDiscardValueNames(boolean Discard) {
    pImpl.DiscardValueNames = Discard;
  }


  /// Whether there is a string map for uniquing debug info
  /// identifiers across the context.  Off by default.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::isODRUniquingDebugTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 336,
   FQN="llvm::LLVMContext::isODRUniquingDebugTypes", NM="_ZNK4llvm11LLVMContext23isODRUniquingDebugTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext23isODRUniquingDebugTypesEv")
  //</editor-fold>
  public boolean isODRUniquingDebugTypes() /*const*/ {
    return !!pImpl.DITypeMap.$bool();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::enableDebugTypeODRUniquing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 338,
   FQN="llvm::LLVMContext::enableDebugTypeODRUniquing", NM="_ZN4llvm11LLVMContext26enableDebugTypeODRUniquingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext26enableDebugTypeODRUniquingEv")
  //</editor-fold>
  public void enableDebugTypeODRUniquing() {
    if (pImpl.DITypeMap.$bool()) {
      return;
    }

    pImpl.DITypeMap.emplace();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::disableDebugTypeODRUniquing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 345,
   FQN="llvm::LLVMContext::disableDebugTypeODRUniquing", NM="_ZN4llvm11LLVMContext27disableDebugTypeODRUniquingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext27disableDebugTypeODRUniquingEv")
  //</editor-fold>
  public void disableDebugTypeODRUniquing() {
    pImpl.DITypeMap.reset();
  }


  // JAVA: typedef void (*InlineAsmDiagHandlerTy)(const SMDiagnostic &, void *, unsigned int);

  /// Defines the type of a diagnostic handler.
  /// \see LLVMContext::setDiagnosticHandler.
  /// \see LLVMContext::diagnose.
  // JAVA: typedef void (*DiagnosticHandlerTy)(const DiagnosticInfo &, void *);

  /// Defines the type of a yield callback.
  /// \see LLVMContext::setYieldCallback.
  // JAVA: typedef void (*YieldCallbackTy)(LLVMContext *, void *);

  /// setInlineAsmDiagnosticHandler - This method sets a handler that is invoked
  /// when problems with inline asm are detected by the backend.  The first
  /// argument is a function pointer and the second is a context pointer that
  /// gets passed into the DiagHandler.
  ///
  /// LLVMContext doesn't take ownership or interpret either of these
  /// pointers.

  //===----------------------------------------------------------------------===//
  // Recoverable Backend Errors
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::setInlineAsmDiagnosticHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 171,
   FQN="llvm::LLVMContext::setInlineAsmDiagnosticHandler", NM="_ZN4llvm11LLVMContext29setInlineAsmDiagnosticHandlerEPFvRKNS_12SMDiagnosticEPvjES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext29setInlineAsmDiagnosticHandlerEPFvRKNS_12SMDiagnosticEPvjES4_")
  //</editor-fold>
  public void setInlineAsmDiagnosticHandler(SMDiagnosticHandler DiagHandler) {
    setInlineAsmDiagnosticHandler(DiagHandler,
                               (Object/*void P*/ )null);
  }
  public void setInlineAsmDiagnosticHandler(SMDiagnosticHandler DiagHandler,
                               Object/*void P*/ DiagContext/*= null*/) {
    pImpl.InlineAsmDiagHandler = $tryClone(DiagHandler);
    pImpl.InlineAsmDiagContext = DiagContext;
  }


  /// getInlineAsmDiagnosticHandler - Return the diagnostic handler set by
  /// setInlineAsmDiagnosticHandler.

  /// getInlineAsmDiagnosticHandler - Return the diagnostic handler set by
  /// setInlineAsmDiagnosticHandler.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getInlineAsmDiagnosticHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 180,
   FQN="llvm::LLVMContext::getInlineAsmDiagnosticHandler", NM="_ZNK4llvm11LLVMContext29getInlineAsmDiagnosticHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext29getInlineAsmDiagnosticHandlerEv")
  //</editor-fold>
  public SMDiagnosticHandler getInlineAsmDiagnosticHandler() /*const*/ {
    return pImpl.InlineAsmDiagHandler;
  }


  /// getInlineAsmDiagnosticContext - Return the diagnostic context set by
  /// setInlineAsmDiagnosticHandler.

  /// getInlineAsmDiagnosticContext - Return the diagnostic context set by
  /// setInlineAsmDiagnosticHandler.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getInlineAsmDiagnosticContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 187,
   FQN="llvm::LLVMContext::getInlineAsmDiagnosticContext", NM="_ZNK4llvm11LLVMContext29getInlineAsmDiagnosticContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext29getInlineAsmDiagnosticContextEv")
  //</editor-fold>
  public Object/*void P*/ getInlineAsmDiagnosticContext() /*const*/ {
    return pImpl.InlineAsmDiagContext;
  }


  /// setDiagnosticHandler - This method sets a handler that is invoked
  /// when the backend needs to report anything to the user.  The first
  /// argument is a function pointer and the second is a context pointer that
  /// gets passed into the DiagHandler.  The third argument should be set to
  /// true if the handler only expects enabled diagnostics.
  ///
  /// LLVMContext doesn't take ownership or interpret either of these
  /// pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::setDiagnosticHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 191,
   FQN="llvm::LLVMContext::setDiagnosticHandler", NM="_ZN4llvm11LLVMContext20setDiagnosticHandlerEPFvRKNS_14DiagnosticInfoEPvES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext20setDiagnosticHandlerEPFvRKNS_14DiagnosticInfoEPvES4_b")
  //</editor-fold>
  public void setDiagnosticHandler(DiagnosticInfoHandler DiagnosticHandler) {
    setDiagnosticHandler(DiagnosticHandler,
                      (Object/*void P*/ )null,
                      false);
  }
  public void setDiagnosticHandler(DiagnosticInfoHandler DiagnosticHandler,
                      Object/*void P*/ DiagnosticContext/*= null*/) {
    setDiagnosticHandler(DiagnosticHandler,
                      DiagnosticContext,
                      false);
  }
  public void setDiagnosticHandler(DiagnosticInfoHandler DiagnosticHandler,
                      Object/*void P*/ DiagnosticContext/*= null*/,
                      boolean RespectFilters/*= false*/) {
    pImpl.DiagnosticHandler = $tryClone(DiagnosticHandler);
    pImpl.DiagnosticContext = DiagnosticContext;
    pImpl.RespectDiagnosticFilters = RespectFilters;
  }


  /// getDiagnosticHandler - Return the diagnostic handler set by
  /// setDiagnosticHandler.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getDiagnosticHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 206,
   FQN="llvm::LLVMContext::getDiagnosticHandler", NM="_ZNK4llvm11LLVMContext20getDiagnosticHandlerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext20getDiagnosticHandlerEv")
  //</editor-fold>
  public DiagnosticInfoHandler getDiagnosticHandler() /*const*/ {
    return pImpl.DiagnosticHandler;
  }


  /// getDiagnosticContext - Return the diagnostic context set by
  /// setDiagnosticContext.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getDiagnosticContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 210,
   FQN="llvm::LLVMContext::getDiagnosticContext", NM="_ZNK4llvm11LLVMContext20getDiagnosticContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext20getDiagnosticContextEv")
  //</editor-fold>
  public Object/*void P*/ getDiagnosticContext() /*const*/ {
    return pImpl.DiagnosticContext;
  }


  /// \brief Return if a code hotness metric should be included in optimization
  /// diagnostics.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getDiagnosticHotnessRequested">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 202,
   FQN="llvm::LLVMContext::getDiagnosticHotnessRequested", NM="_ZNK4llvm11LLVMContext29getDiagnosticHotnessRequestedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZNK4llvm11LLVMContext29getDiagnosticHotnessRequestedEv")
  //</editor-fold>
  public boolean getDiagnosticHotnessRequested() /*const*/ {
    return pImpl.DiagnosticHotnessRequested;
  }

  /// \brief Set if a code hotness metric should be included in optimization
  /// diagnostics.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::setDiagnosticHotnessRequested">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 199,
   FQN="llvm::LLVMContext::setDiagnosticHotnessRequested", NM="_ZN4llvm11LLVMContext29setDiagnosticHotnessRequestedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext29setDiagnosticHotnessRequestedEb")
  //</editor-fold>
  public void setDiagnosticHotnessRequested(boolean Requested) {
    pImpl.DiagnosticHotnessRequested = Requested;
  }


  /// \brief Get the prefix that should be printed in front of a diagnostic of
  ///        the given \p Severity
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getDiagnosticMessagePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 245,
   FQN="llvm::LLVMContext::getDiagnosticMessagePrefix", NM="_ZN4llvm11LLVMContext26getDiagnosticMessagePrefixENS_18DiagnosticSeverityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext26getDiagnosticMessagePrefixENS_18DiagnosticSeverityE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getDiagnosticMessagePrefix(DiagnosticSeverity Severity) {
    switch (Severity) {
     case DS_Error:
      return $error;
     case DS_Warning:
      return $warning;
     case DS_Remark:
      return $("remark");
     case DS_Note:
      return $("note");
    }
    throw new llvm_unreachable("Unknown DiagnosticSeverity");
  }


  /// \brief Report a message to the currently installed diagnostic handler.
  ///
  /// This function returns, in particular in the case of error reporting
  /// (DI.Severity == \a DS_Error), so the caller should leave the compilation
  /// process in a self-consistent state, even though the generated code
  /// need not be correct.
  ///
  /// The diagnostic message will be implicitly prefixed with a severity keyword
  /// according to \p DI.getSeverity(), i.e., "error: " for \a DS_Error,
  /// "warning: " for \a DS_Warning, and "note: " for \a DS_Note.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::diagnose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 260,
   FQN="llvm::LLVMContext::diagnose", NM="_ZN4llvm11LLVMContext8diagnoseERKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext8diagnoseERKNS_14DiagnosticInfoE")
  //</editor-fold>
  public void diagnose(final /*const*/ DiagnosticInfo /*&*/ DI) {
    DiagnosticPrinterRawOStream DP = null;
    try {
      // If there is a report handler, use it.
      if ((pImpl.DiagnosticHandler != null)) {
        if (!pImpl.RespectDiagnosticFilters || LLVMContextStatics.isDiagnosticEnabled(DI)) {
          pImpl.DiagnosticHandler.$call(DI, pImpl.DiagnosticContext);
        }
        return;
      }
      if (!LLVMContextStatics.isDiagnosticEnabled(DI)) {
        return;
      }

      // Otherwise, print the message with a prefix based on the severity.
      DP/*J*/= new DiagnosticPrinterRawOStream(errs());
      errs().$out(getDiagnosticMessagePrefix(DI.getSeverity())).$out(/*KEEP_STR*/": ");
      DI.print(DP);
      errs().$out(/*KEEP_STR*/$LF);
      if (DI.getSeverity() == DiagnosticSeverity.DS_Error) {
        exit(1);
      }
    } finally {
      if (DP != null) { DP.$destroy(); }
    }
  }


  /// \brief Registers a yield callback with the given context.
  ///
  /// The yield callback function may be called by LLVM to transfer control back
  /// to the client that invoked the LLVM compilation. This can be used to yield
  /// control of the thread, or perform periodic work needed by the client.
  /// There is no guaranteed frequency at which callbacks must occur; in fact,
  /// the client is not guaranteed to ever receive this callback. It is at the
  /// sole discretion of LLVM to do so and only if it can guarantee that
  /// suspending the thread won't block any forward progress in other LLVM
  /// contexts in the same process.
  ///
  /// At a suspend point, the state of the current LLVM context is intentionally
  /// undefined. No assumptions about it can or should be made. Only LLVM
  /// context API calls that explicitly state that they can be used during a
  /// yield callback are allowed to be used. Any other API calls into the
  /// context are not supported until the yield callback function returns
  /// control to LLVM. Other LLVM contexts are unaffected by this restriction.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::setYieldCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 214,
   FQN="llvm::LLVMContext::setYieldCallback", NM="_ZN4llvm11LLVMContext16setYieldCallbackEPFvPS0_PvES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext16setYieldCallbackEPFvPS0_PvES2_")
  //</editor-fold>
  public void setYieldCallback(YieldCallbackTy Callback, Object/*void P*/ OpaqueHandle) {
    pImpl.YieldCallback = $tryClone(Callback);
    pImpl.YieldOpaqueHandle = OpaqueHandle;
  }


  /// \brief Calls the yield callback (if applicable).
  ///
  /// This transfers control of the current thread back to the client, which may
  /// suspend the current thread. Only call this method when LLVM doesn't hold
  /// any global mutex or cannot block the execution in another LLVM context.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::yield">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 220,
   FQN="llvm::LLVMContext::yield", NM="_ZN4llvm11LLVMContext5yieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext5yieldEv")
  //</editor-fold>
  public void yield() {
    if ((pImpl.YieldCallback != null)) {
      pImpl.YieldCallback.$call(this, pImpl.YieldOpaqueHandle);
    }
  }


  /// emitError - Emit an error message to the currently installed error handler
  /// with optional location information.  This function returns, so code should
  /// be prepared to drop the erroneous construct on the floor and "not crash".
  /// The generated code need not be correct.  The error message will be
  /// implicitly prefixed with "error: " and should not end with a ".".
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::emitError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 280,
   FQN="llvm::LLVMContext::emitError", NM="_ZN4llvm11LLVMContext9emitErrorEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext9emitErrorEjRKNS_5TwineE")
  //</editor-fold>
  public void emitError(/*uint*/int LocCookie, final /*const*/ Twine /*&*/ ErrorStr) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      diagnose($c$.track(new DiagnosticInfoInlineAsm(LocCookie, ErrorStr))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::emitError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 229,
   FQN="llvm::LLVMContext::emitError", NM="_ZN4llvm11LLVMContext9emitErrorEPKNS_11InstructionERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext9emitErrorEPKNS_11InstructionERKNS_5TwineE")
  //</editor-fold>
  public void emitError(/*const*/ Instruction /*P*/ I, final /*const*/ Twine /*&*/ ErrorStr) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ((I != null)) : "Invalid instruction";
      diagnose($c$.track(new DiagnosticInfoInlineAsm($Deref(I), ErrorStr))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::emitError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 225,
   FQN="llvm::LLVMContext::emitError", NM="_ZN4llvm11LLVMContext9emitErrorERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext9emitErrorERKNS_5TwineE")
  //</editor-fold>
  public void emitError(final /*const*/ Twine /*&*/ ErrorStr) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      diagnose($c$.track(new DiagnosticInfoInlineAsm(ErrorStr))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  /// \brief Query for a debug option's value.
  ///
  /// This function returns typed data populated from command line parsing.
  /*template <typename ValT, typename Base, ValT (Base::*) Mem> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getOption">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 239,
   FQN="llvm::LLVMContext::getOption", NM="Tpl__ZNK4llvm11LLVMContext9getOptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=Tpl__ZNK4llvm11LLVMContext9getOptionEv")
  //</editor-fold>
  public </*typename*/ ValT, /*typename*/ Base> ValT getOption(byte Mem) /*const*/ {
    return OptionRegistry.instance()./*template */<ValT, Base>/*<Mem>*/get(Mem);
  }


  /// \brief Access the object which manages optimization bisection for failure
  /// analysis.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::getOptBisect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 351,
   FQN="llvm::LLVMContext::getOptBisect", NM="_ZN4llvm11LLVMContext12getOptBisectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext12getOptBisectEv")
  //</editor-fold>
  public OptBisect /*&*/ getOptBisect() {
    return pImpl.getOptBisect();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::LLVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 247,
   FQN="llvm::LLVMContext::LLVMContext", NM="_ZN4llvm11LLVMContextC1ERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContextC1ERS0_")
  //</editor-fold>
  protected/*private*/ LLVMContext(final LLVMContext /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 248,
   FQN="llvm::LLVMContext::operator=", NM="_ZN4llvm11LLVMContextaSERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContextaSERS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final LLVMContext /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  /// addModule - Register a module as being instantiated in this context.  If
  /// the context is deleted, the module will be deleted as well.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::addModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 159,
   FQN="llvm::LLVMContext::addModule", NM="_ZN4llvm11LLVMContext9addModuleEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext9addModuleEPNS_6ModuleE")
  //</editor-fold>
  /*friend*//*private*/ void addModule(Module /*P*/ M) {
    pImpl.OwnedModules.insert(M);
  }


  /// removeModule - Unregister a module from this context.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContext::removeModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 163,
   FQN="llvm::LLVMContext::removeModule", NM="_ZN4llvm11LLVMContext12removeModuleEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp -nm=_ZN4llvm11LLVMContext12removeModuleEPNS_6ModuleE")
  //</editor-fold>
  /*friend*//*private*/ void removeModule(Module /*P*/ M) {
    pImpl.OwnedModules.erase(M);
  }


  // Module needs access to the add/removeModule methods.
  /*friend  class Module*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 234)
  private static boolean isDiagnosticEnabled(DiagnosticInfo DI) {
    if (DI instanceof DiagnosticInfoOptimizationBase) {
      return ((DiagnosticInfoOptimizationBase) DI).isEnabled();
    }
    return true;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "pImpl=" + pImpl; // NOI18N
  }
}
