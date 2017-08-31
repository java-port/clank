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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.ast.DeclContext.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.staticanalyzer.core.impl.MemRegionStatics.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;


//===----------------------------------------------------------------------===//
// Base region classes.
//===----------------------------------------------------------------------===//

/// MemRegion - The root abstract class for all memory regions.
//<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 79,
 FQN="clang::ento::MemRegion", NM="_ZN5clang4ento9MemRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9MemRegionE")
//</editor-fold>
public abstract class MemRegion extends FoldingSetImpl.NodeImpl$Tracker implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 81,
   FQN="clang::ento::MemRegion::Kind", NM="_ZN5clang4ento9MemRegion4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9MemRegion4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    CodeSpaceRegionKind(0),
    GlobalImmutableSpaceRegionKind(CodeSpaceRegionKind.getValue() + 1),
    GlobalInternalSpaceRegionKind(GlobalImmutableSpaceRegionKind.getValue() + 1),
    GlobalSystemSpaceRegionKind(GlobalInternalSpaceRegionKind.getValue() + 1),
    BEGIN_NON_STATIC_GLOBAL_MEMSPACES(Kind.GlobalImmutableSpaceRegionKind.getValue()),
    END_NON_STATIC_GLOBAL_MEMSPACES(Kind.GlobalSystemSpaceRegionKind.getValue()),
    StaticGlobalSpaceRegionKind(END_NON_STATIC_GLOBAL_MEMSPACES.getValue() + 1),
    BEGIN_GLOBAL_MEMSPACES(Kind.GlobalImmutableSpaceRegionKind.getValue()),
    END_GLOBAL_MEMSPACES(Kind.StaticGlobalSpaceRegionKind.getValue()),
    HeapSpaceRegionKind(END_GLOBAL_MEMSPACES.getValue() + 1),
    StackArgumentsSpaceRegionKind(HeapSpaceRegionKind.getValue() + 1),
    StackLocalsSpaceRegionKind(StackArgumentsSpaceRegionKind.getValue() + 1),
    BEGIN_STACK_MEMSPACES(Kind.StackArgumentsSpaceRegionKind.getValue()),
    END_STACK_MEMSPACES(Kind.StackLocalsSpaceRegionKind.getValue()),
    UnknownSpaceRegionKind(END_STACK_MEMSPACES.getValue() + 1),
    BEGIN_MEMSPACES(Kind.CodeSpaceRegionKind.getValue()),
    END_MEMSPACES(Kind.UnknownSpaceRegionKind.getValue()),
    AllocaRegionKind(END_MEMSPACES.getValue() + 1),
    SymbolicRegionKind(AllocaRegionKind.getValue() + 1),
    BlockDataRegionKind(SymbolicRegionKind.getValue() + 1),
    BlockCodeRegionKind(BlockDataRegionKind.getValue() + 1),
    FunctionCodeRegionKind(BlockCodeRegionKind.getValue() + 1),
    BEGIN_CODE_TEXT_REGIONS(Kind.BlockCodeRegionKind.getValue()),
    END_CODE_TEXT_REGIONS(Kind.FunctionCodeRegionKind.getValue()),
    CompoundLiteralRegionKind(END_CODE_TEXT_REGIONS.getValue() + 1),
    CXXBaseObjectRegionKind(CompoundLiteralRegionKind.getValue() + 1),
    CXXTempObjectRegionKind(CXXBaseObjectRegionKind.getValue() + 1),
    CXXThisRegionKind(CXXTempObjectRegionKind.getValue() + 1),
    FieldRegionKind(CXXThisRegionKind.getValue() + 1),
    ObjCIvarRegionKind(FieldRegionKind.getValue() + 1),
    VarRegionKind(ObjCIvarRegionKind.getValue() + 1),
    BEGIN_DECL_REGIONS(Kind.FieldRegionKind.getValue()),
    END_DECL_REGIONS(Kind.VarRegionKind.getValue()),
    ElementRegionKind(END_DECL_REGIONS.getValue() + 1),
    ObjCStringRegionKind(ElementRegionKind.getValue() + 1),
    StringRegionKind(ObjCStringRegionKind.getValue() + 1),
    BEGIN_TYPED_VALUE_REGIONS(Kind.CompoundLiteralRegionKind.getValue()),
    END_TYPED_VALUE_REGIONS(Kind.StringRegionKind.getValue()),
    BEGIN_TYPED_REGIONS(Kind.BlockDataRegionKind.getValue()),
    END_TYPED_REGIONS(Kind.StringRegionKind.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private /*const*/ Kind kind;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::MemRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 91,
   FQN="clang::ento::MemRegion::MemRegion", NM="_ZN5clang4ento9MemRegionC1ENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9MemRegionC1ENS1_4KindE")
  //</editor-fold>
  protected MemRegion(Kind k) {
    // : FoldingSetNode(), kind(k) 
    //START JInit
    $Node();
    this.kind = k;
    //END JInit
  }

  
  //===----------------------------------------------------------------------===//
  // Object destruction.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::~MemRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 134,
   FQN="clang::ento::MemRegion::~MemRegion", NM="_ZN5clang4ento9MemRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9MemRegionD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy() {
    FoldingSetImpl.Node.super.$destroy$Node();
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // Out-of-line member definitions.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1307,
   FQN="clang::ento::MemRegion::getContext", NM="_ZNK5clang4ento9MemRegion10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion10getContextEv")
  //</editor-fold>
  public /*inline*/ ASTContext /*&*/ getContext() /*const*/ {
    return getMemRegionManager().getContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 97,
   FQN="clang::ento::MemRegion::Profile", NM="_ZNK5clang4ento9MemRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public abstract /*virtual*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getMemRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 99,
   FQN="clang::ento::MemRegion::getMemRegionManager", NM="_ZNK5clang4ento9MemRegion19getMemRegionManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion19getMemRegionManagerEv")
  //</editor-fold>
  public abstract /*virtual*/ MemRegionManager /*P*/ getMemRegionManager() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getMemorySpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1097,
   FQN="clang::ento::MemRegion::getMemorySpace", NM="_ZNK5clang4ento9MemRegion14getMemorySpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion14getMemorySpaceEv")
  //</editor-fold>
  public /*const*/ MemSpaceRegion /*P*/ getMemorySpace() /*const*/ {
    /*const*/ MemRegion /*P*/ R = this;
    /*const*/ SubRegion /*P*/ SR = dyn_cast_SubRegion(this);
    while ((SR != null)) {
      R = SR.getSuperRegion();
      SR = dyn_cast_SubRegion(R);
    }
    
    return dyn_cast_MemSpaceRegion(R);
  }

  
  
  // getBaseRegion strips away all elements and fields, and get the base region
  // of them.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getBaseRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1129,
   FQN="clang::ento::MemRegion::getBaseRegion", NM="_ZNK5clang4ento9MemRegion13getBaseRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion13getBaseRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getBaseRegion() /*const*/ {
    /*const*/ MemRegion /*P*/ R = this;
    while (true) {
      switch (R.getKind()) {
       case ElementRegionKind:
       case FieldRegionKind:
       case ObjCIvarRegionKind:
       case CXXBaseObjectRegionKind:
        R = cast_SubRegion(R).getSuperRegion();
        continue;
       default:
        break;
      }
      break;
    }
    return R;
  }

  
  /// Check if the region is a subregion of the given region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::isSubRegionOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1147,
   FQN="clang::ento::MemRegion::isSubRegionOf", NM="_ZNK5clang4ento9MemRegion13isSubRegionOfEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion13isSubRegionOfEPKS1_")
  //</editor-fold>
  public boolean isSubRegionOf(/*const*/ MemRegion /*P*/ R) /*const*/ {
    return false;
  }

  
  
  //===----------------------------------------------------------------------===//
  // View handling.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::StripCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1155,
   FQN="clang::ento::MemRegion::StripCasts", NM="_ZNK5clang4ento9MemRegion10StripCastsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion10StripCastsEb")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ StripCasts() /*const*/ {
    return StripCasts(true);
  }
  public /*const*/ MemRegion /*P*/ StripCasts(boolean StripBaseCasts/*= true*/) /*const*/ {
    /*const*/ MemRegion /*P*/ R = this;
    while (true) {
      switch (R.getKind()) {
       case ElementRegionKind:
        {
          /*const*/ ElementRegion /*P*/ ER = cast_ElementRegion(R);
          if (!ER.getIndex().isZeroConstant()) {
            return R;
          }
          R = ER.getSuperRegion();
          break;
        }
       case CXXBaseObjectRegionKind:
        if (!StripBaseCasts) {
          return R;
        }
        R = cast_CXXBaseObjectRegion(R).getSuperRegion();
        break;
       default:
        return R;
      }
    }
  }

  
  /// \brief If this is a symbolic region, returns the region. Otherwise,
  /// goes up the base chain looking for the first symbolic base region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getSymbolicBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1177,
   FQN="clang::ento::MemRegion::getSymbolicBase", NM="_ZNK5clang4ento9MemRegion15getSymbolicBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion15getSymbolicBaseEv")
  //</editor-fold>
  public /*const*/ SymbolicRegion /*P*/ getSymbolicBase() /*const*/ {
    /*const*/ SubRegion /*P*/ SubR = dyn_cast_SubRegion(this);
    while ((SubR != null)) {
      {
        /*const*/ SymbolicRegion /*P*/ SymR = dyn_cast_SymbolicRegion(SubR);
        if ((SymR != null)) {
          return SymR;
        }
      }
      SubR = dyn_cast_SubRegion(SubR.getSuperRegion());
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::hasGlobalsOrParametersStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1121,
   FQN="clang::ento::MemRegion::hasGlobalsOrParametersStorage", NM="_ZNK5clang4ento9MemRegion29hasGlobalsOrParametersStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion29hasGlobalsOrParametersStorageEv")
  //</editor-fold>
  public boolean hasGlobalsOrParametersStorage() /*const*/ {
    /*const*/ MemSpaceRegion /*P*/ MS = getMemorySpace();
    return isa_StackArgumentsSpaceRegion(MS)
       || isa_GlobalsSpaceRegion(MS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::hasStackStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1109,
   FQN="clang::ento::MemRegion::hasStackStorage", NM="_ZNK5clang4ento9MemRegion15hasStackStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion15hasStackStorageEv")
  //</editor-fold>
  public boolean hasStackStorage() /*const*/ {
    return isa_StackSpaceRegion(getMemorySpace());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::hasStackNonParametersStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1113,
   FQN="clang::ento::MemRegion::hasStackNonParametersStorage", NM="_ZNK5clang4ento9MemRegion28hasStackNonParametersStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion28hasStackNonParametersStorageEv")
  //</editor-fold>
  public boolean hasStackNonParametersStorage() /*const*/ {
    return isa_StackLocalsSpaceRegion(getMemorySpace());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::hasStackParametersStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1117,
   FQN="clang::ento::MemRegion::hasStackParametersStorage", NM="_ZNK5clang4ento9MemRegion25hasStackParametersStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion25hasStackParametersStorageEv")
  //</editor-fold>
  public boolean hasStackParametersStorage() /*const*/ {
    return isa_StackArgumentsSpaceRegion(getMemorySpace());
  }

  
  /// Compute the offset within the top level memory object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getAsOffset">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1246,
   FQN="clang::ento::MemRegion::getAsOffset", NM="_ZNK5clang4ento9MemRegion11getAsOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion11getAsOffsetEv")
  //</editor-fold>
  public RegionOffset getAsOffset() /*const*/ {
    /*const*/ MemRegion /*P*/ R = this;
    /*const*/ MemRegion /*P*/ SymbolicOffsetBase = null;
    long/*int64_t*/ Offset = 0;
    Loop:while (true) {
      switch (R.getKind()) {
       case CodeSpaceRegionKind:
       case StackLocalsSpaceRegionKind:
       case StackArgumentsSpaceRegionKind:
       case HeapSpaceRegionKind:
       case UnknownSpaceRegionKind:
       case StaticGlobalSpaceRegionKind:
       case GlobalInternalSpaceRegionKind:
       case GlobalSystemSpaceRegionKind:
       case GlobalImmutableSpaceRegionKind:
        // Stores can bind directly to a region space to set a default value.
        assert (Offset == 0 && !(SymbolicOffsetBase != null));
        break Loop;//goto Finish;
       case FunctionCodeRegionKind:
       case BlockCodeRegionKind:
       case BlockDataRegionKind:
        // These will never have bindings, but may end up having values requested
        // if the user does some strange casting.
        if (Offset != 0) {
          SymbolicOffsetBase = R;
        }
        break Loop;//goto Finish;
       case SymbolicRegionKind:
       case AllocaRegionKind:
       case CompoundLiteralRegionKind:
       case CXXThisRegionKind:
       case StringRegionKind:
       case ObjCStringRegionKind:
       case VarRegionKind:
       case CXXTempObjectRegionKind:
        // Usual base regions.
        break Loop;//goto Finish;
       case ObjCIvarRegionKind:
        // This is a little strange, but it's a compromise between
        // ObjCIvarRegions having unknown compile-time offsets (when using the
        // non-fragile runtime) and yet still being distinct, non-overlapping
        // regions. Thus we treat them as "like" base regions for the purposes
        // of computing offsets.
        break Loop;//goto Finish;
       case CXXBaseObjectRegionKind:
        {
          /*const*/ CXXBaseObjectRegion /*P*/ BOR = cast_CXXBaseObjectRegion(R);
          R = BOR.getSuperRegion();
          
          QualType Ty/*J*/= new QualType();
          boolean RootIsSymbolic = false;
          {
            /*const*/ TypedValueRegion /*P*/ TVR = dyn_cast_TypedValueRegion(R);
            if ((TVR != null)) {
              Ty.$assignMove(TVR.getDesugaredValueType(getContext()));
            } else {
              /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
              if ((SR != null)) {
                // If our base region is symbolic, we don't know what type it really is.
                // Pretend the type of the symbol is the true dynamic type.
                // (This will at least be self-consistent for the life of the symbol.)
                Ty.$assignMove(SR.getSymbol().getType().$arrow().getPointeeType());
                RootIsSymbolic = true;
              }
            }
          }
          
          /*const*/ CXXRecordDecl /*P*/ Child = Ty.$arrow().getAsCXXRecordDecl();
          if (!(Child != null)) {
            // We cannot compute the offset of the base class.
            SymbolicOffsetBase = R;
          } else {
            if (RootIsSymbolic) {
              // Base layers on symbolic regions may not be type-correct.
              // Double-check the inheritance here, and revert to a symbolic offset
              // if it's invalid (e.g. due to a reinterpret_cast).
              if (BOR.isVirtual()) {
                if (!Child.isVirtuallyDerivedFrom(BOR.getDecl())) {
                  SymbolicOffsetBase = R;
                }
              } else {
                if (!isImmediateBase(Child, BOR.getDecl())) {
                  SymbolicOffsetBase = R;
                }
              }
            }
          }
          
          // Don't bother calculating precise offsets if we already have a
          // symbolic offset somewhere in the chain.
          if ((SymbolicOffsetBase != null)) {
            continue;
          }
          
          CharUnits BaseOffset/*J*/= new CharUnits();
          final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(Child);
          if (BOR.isVirtual()) {
            BaseOffset.$assignMove(Layout.getVBaseClassOffset(BOR.getDecl()));
          } else {
            BaseOffset.$assignMove(Layout.getBaseClassOffset(BOR.getDecl()));
          }
          
          // The base offset is in chars, not in bits.
          Offset += BaseOffset.getQuantity() * getContext().getCharWidth();
          break;
        }
       case ElementRegionKind:
        {
          /*const*/ ElementRegion /*P*/ ER = cast_ElementRegion(R);
          R = ER.getSuperRegion();
          
          QualType EleTy = ER.getValueType();
          if (EleTy.$arrow().isIncompleteType()) {
            // We cannot compute the offset of the base class.
            SymbolicOffsetBase = R;
            continue;
          }
          
          SVal Index = new SVal(JD$Move.INSTANCE, ER.getIndex());
          {
            Optional<NsNonloc.ConcreteInt> CI = Index.getAs(NsNonloc.ConcreteInt.class);
            if (CI.$bool()) {
              // Don't bother calculating precise offsets if we already have a
              // symbolic offset somewhere in the chain.
              if ((SymbolicOffsetBase != null)) {
                continue;
              }
              
              long/*int64_t*/ i = CI.$arrow().getValue().getSExtValue();
              // This type size is in bits.
              Offset += i * getContext().getTypeSize(new QualType(EleTy));
            } else {
              // We cannot compute offset for non-concrete index.
              SymbolicOffsetBase = R;
            }
          }
          break;
        }
       case FieldRegionKind:
        {
          /*const*/ FieldRegion /*P*/ FR = cast_FieldRegion(R);
          R = FR.getSuperRegion();
          
          /*const*/ RecordDecl /*P*/ RD = FR.getDecl().getParent$Const();
          if (RD.isUnion() || !RD.isCompleteDefinition()) {
            // We cannot compute offset for incomplete type.
            // For unions, we could treat everything as offset 0, but we'd rather
            // treat each field as a symbolic offset so they aren't stored on top
            // of each other, since we depend on things in typed regions actually
            // matching their types.
            SymbolicOffsetBase = R;
          }
          
          // Don't bother calculating precise offsets if we already have a
          // symbolic offset somewhere in the chain.
          if ((SymbolicOffsetBase != null)) {
            continue;
          }
          
          // Get the field number.
          /*uint*/int idx = 0;
          for (specific_decl_iterator<FieldDecl> FI = RD.field_begin(), 
              FE = RD.field_end(); $noteq_specific_decl_iterator$SpecificDecl$C(FI, FE); FI.$preInc() , ++idx) {
            if (FR.getDecl() == FI.$star()) {
              break;
            }
          }
          final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(RD);
          // This is offset in bits.
          Offset += Layout.getFieldOffset(idx);
          break;
        }
      }
    }
   Finish:
    if ((SymbolicOffsetBase != null)) {
      return new RegionOffset(SymbolicOffsetBase, RegionOffset.Symbolic);
    }
    return new RegionOffset(R, Offset);
  }

  
  /// \brief Get a string representation of a region for debug use.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 441,
   FQN="clang::ento::MemRegion::getString", NM="_ZNK5clang4ento9MemRegion9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion9getStringEv")
  //</editor-fold>
  public std.string getString() /*const*/ {
    raw_string_ostream os = null;
    try {
      std.string s/*J*/= new std.string();
      os/*J*/= new raw_string_ostream(s);
      dumpToStream(os);
      return new std.string(os.str());
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 448,
   FQN="clang::ento::MemRegion::dumpToStream", NM="_ZNK5clang4ento9MemRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpToStream(final raw_ostream /*&*/ os) /*const*/ {
    os.$out(/*KEEP_STR*/"<Unknown Region>");
  }

  
  
  //===----------------------------------------------------------------------===//
  // Region pretty-printing.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 437,
   FQN="clang::ento::MemRegion::dump", NM="_ZNK5clang4ento9MemRegion4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpToStream(llvm.errs());
  }

  
  /// \brief Returns true if this region can be printed in a user-friendly way.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::canPrintPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 568,
   FQN="clang::ento::MemRegion::canPrintPretty", NM="_ZNK5clang4ento9MemRegion14canPrintPrettyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion14canPrintPrettyEv")
  //</editor-fold>
  public boolean canPrintPretty() /*const*/ {
    return canPrintPrettyAsExpr();
  }

  
  /// \brief Print the region for use in diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 576,
   FQN="clang::ento::MemRegion::printPretty", NM="_ZNK5clang4ento9MemRegion11printPrettyERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion11printPrettyERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ os) /*const*/ {
    assert (canPrintPretty()) : "This region cannot be printed pretty.";
    os.$out(/*KEEP_STR*/$SGL_QUOTE);
    printPrettyAsExpr(os);
    os.$out(/*KEEP_STR*/$SGL_QUOTE);
  }

  
  /// \brief Returns true if this region's textual representation can be used
  /// as part of a larger expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::canPrintPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 572,
   FQN="clang::ento::MemRegion::canPrintPrettyAsExpr", NM="_ZNK5clang4ento9MemRegion20canPrintPrettyAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion20canPrintPrettyAsExprEv")
  //</editor-fold>
  public boolean canPrintPrettyAsExpr() /*const*/ {
    return false;
  }

  
  /// \brief Print the region as expression.
  ///
  /// When this region represents a subexpression, the method is for printing
  /// an expression containing it.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::printPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 583,
   FQN="clang::ento::MemRegion::printPrettyAsExpr", NM="_ZNK5clang4ento9MemRegion17printPrettyAsExprERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion17printPrettyAsExprERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPrettyAsExpr(final raw_ostream /*&*/ os) /*const*/ {
    throw new llvm_unreachable("This region cannot be printed pretty.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 148,
   FQN="clang::ento::MemRegion::getKind", NM="_ZNK5clang4ento9MemRegion7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return kind;
  }

  
  /*template <typename RegionTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1106,
   FQN="clang::ento::MemRegion::getAs", NM="Tpl__ZNK5clang4ento9MemRegion5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=Tpl__ZNK5clang4ento9MemRegion5getAsEv")
  //</editor-fold>
  public </*typename*/ RegionTy extends MemRegion> /*const*/ RegionTy /*P*/ getAs(Class<RegionTy> clazz) /*const*/ {
    {
      /*const*/ RegionTy /*P*/ RT = dyn_cast(clazz, this);
      if (RT != null) {
        return RT;
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::isBoundable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 152,
   FQN="clang::ento::MemRegion::isBoundable", NM="_ZNK5clang4ento9MemRegion11isBoundableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion11isBoundableEv")
  //</editor-fold>
  public /*virtual*/ boolean isBoundable() /*const*/ {
    return false;
  }

  
  /// Get descriptive name for memory region. The name is obtained from
  /// the variable/field declaration retrieved from the memory region.
  /// Regions that point to an element of an array are returned as: "arr[0]".
  /// Regions that point to a struct are returned as: "st.var".
  //
  /// \param UseQuotes Set if the name should be quoted.
  ///
  /// \returns variable name for memory region
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::getDescriptiveName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 635,
   FQN="clang::ento::MemRegion::getDescriptiveName", NM="_ZNK5clang4ento9MemRegion18getDescriptiveNameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion18getDescriptiveNameEb")
  //</editor-fold>
  public std.string getDescriptiveName() /*const*/ {
    return getDescriptiveName(true);
  }
  public std.string getDescriptiveName(boolean UseQuotes/*= true*/) /*const*/ {
    raw_svector_ostream os = null;
    try {
      std.string VariableName/*J*/= new std.string();
      std.string ArrayIndices/*J*/= new std.string();
      /*const*/ MemRegion /*P*/ R = this;
      SmallString/*50*/ buf/*J*/= new SmallString/*50*/(50);
      os/*J*/= new raw_svector_ostream(buf);
      
      // Obtain array indices to add them to the variable name.
      /*const*/ ElementRegion /*P*/ ER = null;
      while (((ER = R.getAs(ElementRegion.class)) != null)) {
        {
          // Index is a ConcreteInt.
          Optional<NsNonloc.ConcreteInt> CI = ER.getIndex().getAs(NsNonloc.ConcreteInt.class);
          if (CI.$bool()) {
            SmallString/*2*/ Idx/*J*/= new SmallString/*2*/(2);
            CI.$arrow().getValue().__toString(Idx);
            ArrayIndices.$assignMove(($add_Twine$C($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/$LSQUARE), new Twine(Idx.str())), new Twine(/*KEEP_STR*/$RSQUARE)), new Twine(ArrayIndices))).str());
          } else {
            std.string Idx = ER.getDescriptiveName(false);
            if (!Idx.empty()) {
              ArrayIndices.$assignMove(($add_Twine$C($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/$LSQUARE), new Twine(Idx)), new Twine(/*KEEP_STR*/$RSQUARE)), new Twine(ArrayIndices))).str());
            }
          }
        }
        R = ER.getSuperRegion();
      }
      
      // Get variable name.
      if ((R != null) && R.canPrintPrettyAsExpr()) {
        R.printPrettyAsExpr(os);
        if (UseQuotes) {
          return ($add_Twine$C($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/$SGL_QUOTE), new Twine(os.str())), new Twine(ArrayIndices)), new Twine(/*KEEP_STR*/$SGL_QUOTE))).str();
        } else {
          return ($add_Twine$C(new Twine(os.str()), new Twine(ArrayIndices))).str();
        }
      }
      
      return VariableName;
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  
  /// Retrieve source range from memory region. The range retrieval
  /// is based on the decl obtained from the memory region.
  /// For a VarRegion the range of the base region is returned.
  /// For a FieldRegion the range of the field is returned.
  /// If no declaration is found, an empty source range is returned.
  /// The client is responsible for checking if the returned range is valid.
  ///
  /// \returns source range for declaration retrieved from memory region
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegion::sourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 675,
   FQN="clang::ento::MemRegion::sourceRange", NM="_ZNK5clang4ento9MemRegion11sourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9MemRegion11sourceRangeEv")
  //</editor-fold>
  public SourceRange sourceRange() /*const*/ {
    /*const*/ VarRegion /*P*/ /*const*/ VR = dyn_cast_VarRegion(this.getBaseRegion());
    /*const*/ FieldRegion /*P*/ /*const*/ FR = dyn_cast_FieldRegion(this);
    
    // Check for more specific regions first.
    // FieldRegion
    if ((FR != null)) {
      return FR.getDecl().getSourceRange();
    } else // VarRegion
    if ((VR != null)) {
      return VR.getDecl().getSourceRange();
    } else {
      return /*{ */new SourceRange()/* }*/;
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  /*
  @FunctionalInterface
  public interface MemRegion2MemRegion <T extends MemRegion> {
    T $call(MemRegion p);
  }
  
  private static final java.util.Map<Class<? extends MemRegion>, MemRegion2MemRegion> DynCastMemRegion = new java.util.HashMap<>(64);
  static void mapMemRegionTypeClass(Class<? extends MemRegion> MemRegionClass, MemRegion2MemRegion dynCast) {
    DynCastMemRegion.put(MemRegionClass, dynCast);
  }
  
  static { mapMemRegionTypeClass(StaticGlobalSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StaticGlobalSpaceRegion);}
  static { mapMemRegionTypeClass(StackLocalsSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StackLocalsSpaceRegion);}
  static { mapMemRegionTypeClass(DeclRegion.class, StaticanalyzerRTTI::dyn_cast_DeclRegion);}
  static { mapMemRegionTypeClass(GlobalSystemSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalSystemSpaceRegion);}
  static { mapMemRegionTypeClass(StackSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StackSpaceRegion);}
  static { mapMemRegionTypeClass(ElementRegion.class, StaticanalyzerRTTI::dyn_cast_ElementRegion);}
  static { mapMemRegionTypeClass(CXXThisRegion.class, StaticanalyzerRTTI::dyn_cast_CXXThisRegion);}
  static { mapMemRegionTypeClass(FunctionCodeRegion.class, StaticanalyzerRTTI::dyn_cast_FunctionCodeRegion);}
  static { mapMemRegionTypeClass(GlobalImmutableSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalImmutableSpaceRegion);}
  static { mapMemRegionTypeClass(CodeSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_CodeSpaceRegion);}
  static { mapMemRegionTypeClass(UnknownSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_UnknownSpaceRegion);}
  static { mapMemRegionTypeClass(CXXTempObjectRegion.class, StaticanalyzerRTTI::dyn_cast_CXXTempObjectRegion);}
  static { mapMemRegionTypeClass(BlockCodeRegion.class, StaticanalyzerRTTI::dyn_cast_BlockCodeRegion);}
  static { mapMemRegionTypeClass(HeapSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_HeapSpaceRegion);}
  static { mapMemRegionTypeClass(NonStaticGlobalSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_NonStaticGlobalSpaceRegion);}
  static { mapMemRegionTypeClass(ObjCStringRegion.class, StaticanalyzerRTTI::dyn_cast_ObjCStringRegion);}
  static { mapMemRegionTypeClass(MemSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_MemSpaceRegion);}
  static { mapMemRegionTypeClass(AllocaRegion.class, StaticanalyzerRTTI::dyn_cast_AllocaRegion);}
  static { mapMemRegionTypeClass(StringRegion.class, StaticanalyzerRTTI::dyn_cast_StringRegion);}
  static { mapMemRegionTypeClass(SubRegion.class, StaticanalyzerRTTI::dyn_cast_SubRegion);}
  static { mapMemRegionTypeClass(CXXBaseObjectRegion.class, StaticanalyzerRTTI::dyn_cast_CXXBaseObjectRegion);}
  static { mapMemRegionTypeClass(TypedRegion.class, StaticanalyzerRTTI::dyn_cast_TypedRegion);}
  static { mapMemRegionTypeClass(TypedValueRegion.class, StaticanalyzerRTTI::dyn_cast_TypedValueRegion);}
  static { mapMemRegionTypeClass(StackArgumentsSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StackArgumentsSpaceRegion);}
  static { mapMemRegionTypeClass(SymbolicRegion.class, StaticanalyzerRTTI::dyn_cast_SymbolicRegion);}
  static { mapMemRegionTypeClass(GlobalInternalSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalInternalSpaceRegion);}
  static { mapMemRegionTypeClass(BlockDataRegion.class, StaticanalyzerRTTI::dyn_cast_BlockDataRegion);}
  static { mapMemRegionTypeClass(CompoundLiteralRegion.class, StaticanalyzerRTTI::dyn_cast_CompoundLiteralRegion);}
  static { mapMemRegionTypeClass(ObjCIvarRegion.class, StaticanalyzerRTTI::dyn_cast_ObjCIvarRegion);}
  static { mapMemRegionTypeClass(VarRegion.class, StaticanalyzerRTTI::dyn_cast_VarRegion);}
  static { mapMemRegionTypeClass(FieldRegion.class, StaticanalyzerRTTI::dyn_cast_FieldRegion);}
  static { mapMemRegionTypeClass(CodeTextRegion.class, StaticanalyzerRTTI::dyn_cast_CodeTextRegion);}
  static { mapMemRegionTypeClass(GlobalsSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalsSpaceRegion);}
  */

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      dumpToStream(OS);
      OS.flush();      
      return Buf.toJavaString();
    }
    return "" + "kind=" + kind // NOI18N
              + super.toString(); // NOI18N
  }
}
