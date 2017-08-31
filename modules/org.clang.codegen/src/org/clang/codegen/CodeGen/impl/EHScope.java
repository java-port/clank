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
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;


/// A protected scope for zero-cost EH handling.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 44,
 FQN="clang::CodeGen::EHScope", NM="_ZN5clang7CodeGen7EHScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScopeE")
//</editor-fold>
public class EHScope {
  private BasicBlock /*P*/ CachedLandingPad;
  private BasicBlock /*P*/ CachedEHDispatchBlock;
  
  private EHScopeStack.stable_iterator EnclosingEHScope;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::CommonBitFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 50,
   FQN="clang::CodeGen::EHScope::CommonBitFields", NM="_ZN5clang7CodeGen7EHScope15CommonBitFieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScope15CommonBitFieldsE")
  //</editor-fold>
  private static class CommonBitFields {
    /*friend  class EHScope*/
    private /*JBYTE unsigned int*/ byte Kind /*: 3*/;
    
    @Override public String toString() {
      return "" + "Kind=" + $uchar2uint(Kind); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 54,
   FQN="clang::CodeGen::EHScope::(anonymous)", NM="_ZN5clang7CodeGen7EHScopeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScopeE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumCommonBits = 3;
  /*}*/;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::CatchBitFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 57,
   FQN="clang::CodeGen::EHScope::CatchBitFields", NM="_ZN5clang7CodeGen7EHScope14CatchBitFieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScope14CatchBitFieldsE")
  //</editor-fold>
  protected static class CatchBitFields {
    /*friend  class EHCatchScope*/
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumCommonBits*/;
    
    /*friend*/public/*private*/ /*uint*/int NumHandlers /*: 32 - NumCommonBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", NumHandlers=" + NumHandlers; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::CleanupBitFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 64,
   FQN="clang::CodeGen::EHScope::CleanupBitFields", NM="_ZN5clang7CodeGen7EHScope16CleanupBitFieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScope16CleanupBitFieldsE")
  //</editor-fold>
  protected static class CleanupBitFields {
    /*friend  class EHCleanupScope*/
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumCommonBits*/;
    
    /// Whether this cleanup needs to be run along normal edges.
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean IsNormalCleanup /*: 1*/;
    
    /// Whether this cleanup needs to be run along exception edges.
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean IsEHCleanup /*: 1*/;
    
    /// Whether this cleanup is currently active.
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean IsActive /*: 1*/;
    
    /// Whether this cleanup is a lifetime marker
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean IsLifetimeMarker /*: 1*/;
    
    /// Whether the normal cleanup should test the activation flag.
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean TestFlagInNormalCleanup /*: 1*/;
    
    /// Whether the EH cleanup should test the activation flag.
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean TestFlagInEHCleanup /*: 1*/;
    
    /// The amount of extra storage needed by the Cleanup.
    /// Always a multiple of the scope-stack alignment.
    /*friend*/public/*private*/ /*JCHAR unsigned int*/ char CleanupSize /*: 12*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", IsNormalCleanup=" + IsNormalCleanup // NOI18N
                + ", IsEHCleanup=" + IsEHCleanup // NOI18N
                + ", IsActive=" + IsActive // NOI18N
                + ", IsLifetimeMarker=" + IsLifetimeMarker // NOI18N
                + ", TestFlagInNormalCleanup=" + TestFlagInNormalCleanup // NOI18N
                + ", TestFlagInEHCleanup=" + TestFlagInEHCleanup // NOI18N
                + ", CleanupSize=" + $ushort2uint(CleanupSize); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::FilterBitFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 91,
   FQN="clang::CodeGen::EHScope::FilterBitFields", NM="_ZN5clang7CodeGen7EHScope15FilterBitFieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScope15FilterBitFieldsE")
  //</editor-fold>
  protected static class FilterBitFields {
    /*friend  class EHFilterScope*/
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumCommonBits*/;
    
    /*friend*/public/*private*/ /*uint*/int NumFilters /*: 32 - NumCommonBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", NumFilters=" + NumFilters; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 98,
   FQN="clang::CodeGen::EHScope::(anonymous)", NM="_ZN5clang7CodeGen7EHScopeE_Unnamed_union5",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScopeE_Unnamed_union5")
  //</editor-fold>
  protected static class/*union*/ Unnamed_union5 {
    public CommonBitFields CommonBits;
    public CatchBitFields CatchBits;
    public CleanupBitFields CleanupBits;
    public FilterBitFields FilterBits;
    
    @Override public String toString() {
      return "" + "CommonBits=" + CommonBits // NOI18N
                + ", CatchBits=" + CatchBits // NOI18N
                + ", CleanupBits=" + CleanupBits // NOI18N
                + ", FilterBits=" + FilterBits; // NOI18N
    }
  };
  protected Unnamed_union5 Unnamed_field3 = new Unnamed_union5();
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 106,
   FQN="clang::CodeGen::EHScope::Kind", NM="_ZN5clang7CodeGen7EHScope4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScope4KindE")
  //</editor-fold>
  public enum Kind implements Native.NativeUIntEnum {
    Cleanup(0),
    Catch(Cleanup.getValue() + 1),
    Terminate(Catch.getValue() + 1),
    Filter(Terminate.getValue() + 1),
    PadEnd(Filter.getValue() + 1);

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
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::EHScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 108,
   FQN="clang::CodeGen::EHScope::EHScope", NM="_ZN5clang7CodeGen7EHScopeC1ENS1_4KindENS0_12EHScopeStack15stable_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScopeC1ENS1_4KindENS0_12EHScopeStack15stable_iteratorE")
  //</editor-fold>
  public EHScope(Kind kind, EHScopeStack.stable_iterator enclosingEHScope) {
    // : CachedLandingPad(null), CachedEHDispatchBlock(null), EnclosingEHScope(enclosingEHScope) 
    //START JInit
    this.CachedLandingPad = null;
    this.CachedEHDispatchBlock = null;
    this.EnclosingEHScope = new EHScopeStack.stable_iterator(enclosingEHScope);
    //END JInit
    Unnamed_field3.CommonBits.Kind = $uint2uint_3bits(kind.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 114,
   FQN="clang::CodeGen::EHScope::getKind", NM="_ZNK5clang7CodeGen7EHScope7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen7EHScope7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return /*static_cast*/Kind.valueOf($3bits_uint2uint(Unnamed_field3.CommonBits.Kind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::getCachedLandingPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 116,
   FQN="clang::CodeGen::EHScope::getCachedLandingPad", NM="_ZNK5clang7CodeGen7EHScope19getCachedLandingPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen7EHScope19getCachedLandingPadEv")
  //</editor-fold>
  public BasicBlock /*P*/ getCachedLandingPad() /*const*/ {
    return CachedLandingPad;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::setCachedLandingPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 120,
   FQN="clang::CodeGen::EHScope::setCachedLandingPad", NM="_ZN5clang7CodeGen7EHScope19setCachedLandingPadEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScope19setCachedLandingPadEPN4llvm10BasicBlockE")
  //</editor-fold>
  public void setCachedLandingPad(BasicBlock /*P*/ block) {
    CachedLandingPad = block;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::getCachedEHDispatchBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 124,
   FQN="clang::CodeGen::EHScope::getCachedEHDispatchBlock", NM="_ZNK5clang7CodeGen7EHScope24getCachedEHDispatchBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen7EHScope24getCachedEHDispatchBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ getCachedEHDispatchBlock() /*const*/ {
    return CachedEHDispatchBlock;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::setCachedEHDispatchBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 128,
   FQN="clang::CodeGen::EHScope::setCachedEHDispatchBlock", NM="_ZN5clang7CodeGen7EHScope24setCachedEHDispatchBlockEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen7EHScope24setCachedEHDispatchBlockEPN4llvm10BasicBlockE")
  //</editor-fold>
  public void setCachedEHDispatchBlock(BasicBlock /*P*/ block) {
    CachedEHDispatchBlock = block;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::hasEHBranches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 132,
   FQN="clang::CodeGen::EHScope::hasEHBranches", NM="_ZNK5clang7CodeGen7EHScope13hasEHBranchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen7EHScope13hasEHBranchesEv")
  //</editor-fold>
  public boolean hasEHBranches() /*const*/ {
    {
      BasicBlock /*P*/ block = getCachedEHDispatchBlock();
      if ((block != null)) {
        return !block.use_empty();
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScope::getEnclosingEHScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 138,
   FQN="clang::CodeGen::EHScope::getEnclosingEHScope", NM="_ZNK5clang7CodeGen7EHScope19getEnclosingEHScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen7EHScope19getEnclosingEHScopeEv")
  //</editor-fold>
  public EHScopeStack.stable_iterator getEnclosingEHScope() /*const*/ {
    return new EHScopeStack.stable_iterator(EnclosingEHScope);
  }

  
  @Override public String toString() {
    return "" + "CachedLandingPad=" + CachedLandingPad // NOI18N
              + ", CachedEHDispatchBlock=" + CachedEHDispatchBlock // NOI18N
              + ", EnclosingEHScope=" + EnclosingEHScope // NOI18N
              + ", Unnamed_field3=" + Unnamed_field3; // NOI18N
  }
}
