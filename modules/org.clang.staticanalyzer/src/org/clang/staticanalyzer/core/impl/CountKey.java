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

package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import static org.clank.support.Unsigned.$less_uint;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CountKey">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 24,
 FQN="(anonymous namespace)::CountKey", NM="_ZN12_GLOBAL__N_18CountKeyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN12_GLOBAL__N_18CountKeyE")
//</editor-fold>
public class CountKey implements FoldingSetTrait.Profilable, Native.NativeComparable<CountKey>, Native.ComparableLower {
  private /*const*/ StackFrameContext /*P*/ CallSite;
  private /*uint*/int BlockID;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CountKey::CountKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 29,
   FQN="(anonymous namespace)::CountKey::CountKey", NM="_ZN12_GLOBAL__N_18CountKeyC1EPKN5clang17StackFrameContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN12_GLOBAL__N_18CountKeyC1EPKN5clang17StackFrameContextEj")
  //</editor-fold>
  public CountKey(/*const*/ StackFrameContext /*P*/ CS, /*uint*/int ID) {
    // : CallSite(CS), BlockID(ID) 
    //START JInit
    this.CallSite = CS;
    this.BlockID = ID;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CountKey::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 32,
   FQN="(anonymous namespace)::CountKey::operator==", NM="_ZNK12_GLOBAL__N_18CountKeyeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZNK12_GLOBAL__N_18CountKeyeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ CountKey /*&*/ RHS) /*const*/ {
    return (CallSite == RHS.CallSite) && (BlockID == RHS.BlockID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CountKey::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 36,
   FQN="(anonymous namespace)::CountKey::operator<", NM="_ZNK12_GLOBAL__N_18CountKeyltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZNK12_GLOBAL__N_18CountKeyltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ CountKey /*&*/ RHS) /*const*/ {
    // JAVA: emulate comparation
    //return $less_tuple$C(std.tie(CallSite, BlockID), std.tie(RHS.CallSite, RHS.BlockID));
    int hash1 = System.identityHashCode(this.CallSite);
    int hash2 = System.identityHashCode(RHS.CallSite);
    if (hash1 < hash2) {
      return true;
    }
    if (hash1 > hash2) {
      return false;
    }
    return $less_uint(BlockID, RHS.BlockID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CountKey::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 40,
   FQN="(anonymous namespace)::CountKey::Profile", NM="_ZNK12_GLOBAL__N_18CountKey7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZNK12_GLOBAL__N_18CountKey7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer(CallSite);
    ID.AddInteger_uint(BlockID);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CountKey::CountKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 24,
   FQN="(anonymous namespace)::CountKey::CountKey", NM="_ZN12_GLOBAL__N_18CountKeyC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN12_GLOBAL__N_18CountKeyC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CountKey(final /*const*/ CountKey /*&*/ $Prm0) {
    // : CallSite(.CallSite), BlockID(.BlockID) 
    //START JInit
    this.CallSite = $Prm0.CallSite;
    this.BlockID = $Prm0.BlockID;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CountKey::CountKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 24,
   FQN="(anonymous namespace)::CountKey::CountKey", NM="_ZN12_GLOBAL__N_18CountKeyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN12_GLOBAL__N_18CountKeyC1EOS0_")
  //</editor-fold>
  public /*inline*/ CountKey(JD$Move _dparam, final CountKey /*&&*/$Prm0) {
    // : CallSite(static_cast<CountKey &&>().CallSite), BlockID(static_cast<CountKey &&>().BlockID) 
    //START JInit
    this.CallSite = $Prm0.CallSite;
    this.BlockID = $Prm0.BlockID;
    //END JInit
  }

  @Override public boolean $less(Object obj) { return $less((CountKey)obj); }

  @Override public String toString() {
    return "" + "CallSite=" + "[StackFrameContext]" // NOI18N
              + ", BlockID=" + BlockID; // NOI18N
  }
}
