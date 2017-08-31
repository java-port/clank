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


/// \brief Attributes that may be specified on loops.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 37,
 FQN="clang::CodeGen::LoopAttributes", NM="_ZN5clang7CodeGen14LoopAttributesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen14LoopAttributesE")
//</editor-fold>
public class/*struct*/ LoopAttributes {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopAttributes::LoopAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp", line = 102,
   FQN="clang::CodeGen::LoopAttributes::LoopAttributes", NM="_ZN5clang7CodeGen14LoopAttributesC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen14LoopAttributesC1Eb")
  //</editor-fold>
  public LoopAttributes() {
    this(false);
  }
  public LoopAttributes(boolean IsParallel/*= false*/) {
    // : IsParallel(IsParallel), VectorizeEnable(LoopAttributes::Unspecified), UnrollEnable(LoopAttributes::Unspecified), VectorizeWidth(0), InterleaveCount(0), UnrollCount(0), DistributeEnable(LoopAttributes::Unspecified) 
    //START JInit
    this.IsParallel = IsParallel;
    this.VectorizeEnable = LoopAttributes.LVEnableState.Unspecified;
    this.UnrollEnable = LoopAttributes.LVEnableState.Unspecified;
    this.VectorizeWidth = 0;
    this.InterleaveCount = 0;
    this.UnrollCount = 0;
    this.DistributeEnable = LoopAttributes.LVEnableState.Unspecified;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopAttributes::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp", line = 108,
   FQN="clang::CodeGen::LoopAttributes::clear", NM="_ZN5clang7CodeGen14LoopAttributes5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen14LoopAttributes5clearEv")
  //</editor-fold>
  public void clear() {
    IsParallel = false;
    VectorizeWidth = 0;
    InterleaveCount = 0;
    UnrollCount = 0;
    VectorizeEnable = LoopAttributes.LVEnableState.Unspecified;
    UnrollEnable = LoopAttributes.LVEnableState.Unspecified;
  }

  
  /// \brief Generate llvm.loop.parallel metadata for loads and stores.
  public boolean IsParallel;
  
  /// \brief State of loop vectorization or unrolling.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopAttributes::LVEnableState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 45,
   FQN="clang::CodeGen::LoopAttributes::LVEnableState", NM="_ZN5clang7CodeGen14LoopAttributes13LVEnableStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen14LoopAttributes13LVEnableStateE")
  //</editor-fold>
  public enum LVEnableState implements Native.NativeUIntEnum {
    Unspecified(0),
    Enable(Unspecified.getValue() + 1),
    Disable(Enable.getValue() + 1),
    Full(Disable.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LVEnableState valueOf(int val) {
      LVEnableState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LVEnableState[] VALUES;
      private static final LVEnableState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LVEnableState kind : LVEnableState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LVEnableState[min < 0 ? (1-min) : 0];
        VALUES = new LVEnableState[max >= 0 ? (1+max) : 0];
        for (LVEnableState kind : LVEnableState.values()) {
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
    private LVEnableState(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Value for llvm.loop.vectorize.enable metadata.
  public LVEnableState VectorizeEnable;
  
  /// \brief Value for llvm.loop.unroll.* metadata (enable, disable, or full).
  public LVEnableState UnrollEnable;
  
  /// \brief Value for llvm.loop.vectorize.width metadata.
  public /*uint*/int VectorizeWidth;
  
  /// \brief Value for llvm.loop.interleave.count metadata.
  public /*uint*/int InterleaveCount;
  
  /// \brief llvm.unroll.
  public /*uint*/int UnrollCount;
  
  /// \brief Value for llvm.loop.distribute.enable metadata.
  public LVEnableState DistributeEnable;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::LoopAttributes::LoopAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.h", line = 37,
   FQN="clang::CodeGen::LoopAttributes::LoopAttributes", NM="_ZN5clang7CodeGen14LoopAttributesC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGLoopInfo.cpp -nm=_ZN5clang7CodeGen14LoopAttributesC1ERKS1_")
  //</editor-fold>
  public /*inline*/ LoopAttributes(final /*const*/ LoopAttributes /*&*/ $Prm0) {
    // : IsParallel(.IsParallel), VectorizeEnable(.VectorizeEnable), UnrollEnable(.UnrollEnable), VectorizeWidth(.VectorizeWidth), InterleaveCount(.InterleaveCount), UnrollCount(.UnrollCount), DistributeEnable(.DistributeEnable) 
    //START JInit
    this.IsParallel = $Prm0.IsParallel;
    this.VectorizeEnable = $Prm0.VectorizeEnable;
    this.UnrollEnable = $Prm0.UnrollEnable;
    this.VectorizeWidth = $Prm0.VectorizeWidth;
    this.InterleaveCount = $Prm0.InterleaveCount;
    this.UnrollCount = $Prm0.UnrollCount;
    this.DistributeEnable = $Prm0.DistributeEnable;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "IsParallel=" + IsParallel // NOI18N
              + ", VectorizeEnable=" + VectorizeEnable // NOI18N
              + ", UnrollEnable=" + UnrollEnable // NOI18N
              + ", VectorizeWidth=" + VectorizeWidth // NOI18N
              + ", InterleaveCount=" + InterleaveCount // NOI18N
              + ", UnrollCount=" + UnrollCount // NOI18N
              + ", DistributeEnable=" + DistributeEnable; // NOI18N
  }
}
